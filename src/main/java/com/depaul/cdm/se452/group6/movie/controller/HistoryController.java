package com.depaul.cdm.se452.group6.movie.controller;

import com.depaul.cdm.se452.group6.movie.entity.*;
import com.depaul.cdm.se452.group6.movie.service.*;
import com.depaul.cdm.se452.group6.movie.utility.HistoryEntry;
import com.depaul.cdm.se452.group6.movie.utility.ParsedEntry;
import net.bytebuddy.dynamic.scaffold.MethodGraph;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.*;

@Controller
public class HistoryController {

    @Autowired
    private HistoryService historyService;
    private SeatService seatService;
    private FoodService foodService;
    private DrinkService drinkService;
    private AlcoholService alcoholService;
    private CartService cartService;
    private TicketService ticketService;
    private MovieService movieService;
    private TheaterService theaterService;

    /*
    public HistoryController(HistoryService historyService, SeatService seatService){
        this.historyService = historyService;
        this.seatService = seatService;
    }*/

    @GetMapping("/history")
    public String showUserHistory(Model model) {

        //createDummy();

        PurchaseHistory history = historyService.getHistoryByUserId(1L);
        List<ParsedEntry> ph;
        if (history == null || history.getEntries().isEmpty()){
            ph = null;
        }
        else {
            ph = parseHistory(history.getEntries());
        }
        model.addAttribute("ph",ph);

        return "history";
    }


    @RequestMapping(value="/history", method= RequestMethod.POST)
    public String saveAndDisplayHistory(Model model) {

        PurchaseHistory history = historyService.getHistoryByUserId(1L);
        Date date = new Date();

        List<HistoryEntry> entries = new ArrayList<>();

        if (history == null || history.getEntries().isEmpty()) {
            HistoryEntry entry = new HistoryEntry();
            entry.setDate(date.toString());
            List<Cart> carts = cartService.getCartByUserId(1L);
            entry.setCart(carts.get(0));
            entries.add(entry);
            historyService.pushHistory(1L,entries);
        }
        history = historyService.getHistoryByUserId(1L);
        entries = history.getEntries();

        List<ParsedEntry> ph = parseHistory(entries);

        model.addAttribute("ph",ph);
        return "history";
    }


    private List<ParsedEntry> parseHistory(List<HistoryEntry> entries){
        List<ParsedEntry> parsed = new LinkedList<>();
        System.out.println("Beginning parsing");
        for (HistoryEntry entry : entries){
            ParsedEntry pe = new ParsedEntry();
            List<String[]> lines = new LinkedList<>();
            String date = entry.getDate();
            Cart cart = entry.getCart();

            /*
            System.out.println("Looking through tickets");
            if (!cart.getTicketCart().isEmpty() && cart.getTicketCart() != null){
                for (Long id : cart.getTicketCart()){
                    List<Ticket> tickets = ticketService.findTicketsByid(id);
                    Seat seat = tickets.get(0).getSeat();
                    Theater theater = seat.getTheater();
                    Movie movie = theater.getMovieID();
                    String time = String.valueOf(theater.getTime());
                    String[] line = new String[] {
                            movie.getName(),
                            "",
                            time
                    };
                    lines.add(line);
                }
            }*/
            System.out.println("Looking through food");
            if (!cart.getFoodCart().isEmpty() && cart.getFoodCart() != null){
                System.out.println("Food Exists");
                for (Long id : cart.getFoodCart().keySet()){
                    System.out.println("Got key: " + id);
                    Food item = foodService.getFoodById(id);
                    System.out.println("Got a food item");
                    String[] line = new String[] {
                            item.getItem(),
                            String.valueOf(cart.getFoodCart().get(id)),
                            item.getSize()
                    };
                    lines.add(line);
                }
            }
            System.out.println("Looking through drinks");
            if (!cart.getDrinkCart().isEmpty() && cart.getAlcoholCart() != null){
                for (Long id : cart.getDrinkCart().keySet()){
                    System.out.println("Got key: " + id);
                    Drink item = drinkService.getDrinkById(id);
                    System.out.println("Got a drink");
                    String[] line = new String[]{
                            item.getItem(),
                            String.valueOf(cart.getDrinkCart().get(id)),
                            item.getSize()
                    };
                    lines.add(line);
                }
            }
            System.out.println("Looking through alcohol");
            if (!cart.getAlcoholCart().isEmpty() && cart.getAlcoholCart() != null){
                for (Long id : cart.getAlcoholCart().keySet()){
                    System.out.println("Got key: " + id);
                    AlcoholItem item = alcoholService.getAlcoholById(id);
                    System.out.println("Got a drink");
                    String[] line = new String[]{
                            item.getType(),
                            String.valueOf(cart.getAlcoholCart().get(id)),
                            ""
                    };
                    lines.add(line);
                }
            }

            pe.lines = lines;
            parsed.add(pe);
        }

        return parsed;
    }

    private void createDummy(){
        Cart cart = new Cart();
        System.out.println("cart made");
        List<Long> tickets = new ArrayList<>();
        tickets.add(1L);
        System.out.println("tickets made");
        Map<Long,Integer> food= new HashMap<Long, Integer>();
        food.put(2L,1);
        food.put(4L,1);
        System.out.println("food made");
        Map<Long,Integer> drink = new HashMap<Long, Integer>();
        drink.put(1L,2);
        System.out.println("drink made");
        Map<Long,Integer> alcohol = new HashMap<Long, Integer>();
        alcohol.put(2L,1);
        System.out.println("alcohol made");
        cart.setTicketCart(tickets);
        cart.setFoodCart(food);
        cart.setDrinkCart(drink);
        cart.setAlcoholCart(alcohol);
        System.out.println("cart filled");
        Date date = new Date();
        HistoryEntry entry = new HistoryEntry();
        System.out.println("entry made");
        entry.setDate(date.toString());
        entry.setCart(cart);
        System.out.println("entry filled");
        List<HistoryEntry> entries = new LinkedList<>();
        entries.add(entry);
        System.out.println("history made");
        historyService.pushHistory(1L,entries);

        System.out.println("history pushed");

    }

}
