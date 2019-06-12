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

    @Autowired
    private SeatService seatService;

    @Autowired
    private FoodService foodService;

    @Autowired
    private DrinkService drinkService;

    @Autowired
    private AlcoholService alcoholService;

    @Autowired
    private CartService cartService;

    @Autowired
    private TicketService ticketService;

    @Autowired
    private MovieService movieService;

    @Autowired
    private TheaterService theaterService;


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

        for (ParsedEntry entry : ph){
            for (String[] line : entry.lines){
                System.out.println("Line: " + line[0] + " " + line[1] + " " + line[2]);
            }
        }
        model.addAttribute("history",ph);

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
        for (HistoryEntry entry : entries){
            ParsedEntry pe = new ParsedEntry();
            List<String[]> lines = new LinkedList<>();
            String date = entry.getDate();
            Cart cart = entry.getCart();


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
            }
            if (!cart.getFoodCart().isEmpty() && cart.getFoodCart() != null){
                for (Long id : cart.getFoodCart().keySet()){
                    Food item = foodService.getFoodById(id);
                    String[] line = new String[] {
                            item.getItem(),
                            String.valueOf(cart.getFoodCart().get(id)),
                            item.getSize()
                    };
                    lines.add(line);
                }
            }
            if (!cart.getDrinkCart().isEmpty() && cart.getAlcoholCart() != null){
                for (Long id : cart.getDrinkCart().keySet()){
                    Drink item = drinkService.getDrinkById(id);
                    String[] line = new String[]{
                            item.getItem(),
                            String.valueOf(cart.getDrinkCart().get(id)),
                            item.getSize()
                    };
                    lines.add(line);
                }
            }
            if (!cart.getAlcoholCart().isEmpty() && cart.getAlcoholCart() != null){
                for (Long id : cart.getAlcoholCart().keySet()){
                    AlcoholItem item = alcoholService.getAlcoholById(id);
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
        List<Long> tickets = new ArrayList<>();
        tickets.add(1L);
        Map<Long,Integer> food= new HashMap<Long, Integer>();
        food.put(2L,1);
        food.put(4L,1);
        Map<Long,Integer> drink = new HashMap<Long, Integer>();
        drink.put(1L,2);
        Map<Long,Integer> alcohol = new HashMap<Long, Integer>();
        alcohol.put(2L,1);
        cart.setTicketCart(tickets);
        cart.setFoodCart(food);
        cart.setDrinkCart(drink);
        cart.setAlcoholCart(alcohol);
        Date date = new Date();
        HistoryEntry entry = new HistoryEntry();
        entry.setDate(date.toString());
        entry.setCart(cart);
        List<HistoryEntry> entries = new LinkedList<>();
        entries.add(entry);
        historyService.pushHistory(1L,entries);

        System.out.println("history pushed");

    }

}
