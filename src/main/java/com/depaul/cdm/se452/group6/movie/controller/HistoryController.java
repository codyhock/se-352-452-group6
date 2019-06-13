package com.depaul.cdm.se452.group6.movie.controller;

import com.depaul.cdm.se452.group6.movie.entity.*;
import com.depaul.cdm.se452.group6.movie.service.*;
import com.depaul.cdm.se452.group6.movie.utility.HistoryEntry;
import com.depaul.cdm.se452.group6.movie.utility.ParsedEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
    public String showUserHistory(Model model, @SessionAttribute(name="userID") Long userID) {

        //createDummy();

        PurchaseHistory history = historyService.getHistoryByUserId(userID);
        List<ParsedEntry> ph;
        if (history == null || history.getEntries().isEmpty()){
            ph = null;
        }
        else {
            ph = parseHistory(history.getEntries(), userID);
        }
        model.addAttribute("history",ph);

        return "history";
    }


    @PostMapping("/history")
    public String saveAndDisplayHistory(Model model, @SessionAttribute(name="userID") Long userID) {


        PurchaseHistory history = historyService.getHistoryByUserId(userID);
        Date date = Calendar.getInstance().getTime();
        DateFormat format = new SimpleDateFormat("yyyy-mm-dd");
        String strDate = format.format(date);
        HistoryEntry entry = new HistoryEntry();
        entry.setDate(strDate);
        List<Cart> carts = cartService.getCartByUserId(userID);
        entry.setCart(carts.get(0));

        List<HistoryEntry> entries = new ArrayList<>();

        if (history == null || history.getEntries().isEmpty()) {
            entries.add(entry);
            historyService.pushHistory(userID,entries);
        }
        else{
            entries = history.getEntries();

            entries.add(0,entry);
            historyService.updateHistory(userID,entries);
        }

        PurchaseHistory updated = historyService.getHistoryByUserId(userID);
        entries = updated.getEntries();

        List<ParsedEntry> ph = parseHistory(entries, userID);

        for (ParsedEntry parsed : ph){
            System.out.println(parsed.date);
        }

        cartService.deleteCart(carts.get(0));
        model.addAttribute("history",ph);
        return "history";
    }


    private List<ParsedEntry> parseHistory(List<HistoryEntry> entries, Long userID){
        List<ParsedEntry> parsed = new LinkedList<>();
        for (HistoryEntry entry : entries){
            ParsedEntry pe = new ParsedEntry();
            List<String[]> lines = new LinkedList<>();
            Cart cart = entry.getCart();

            if (!cart.getTicketCart().isEmpty() && cart.getTicketCart() != null){
                for (Long id : cart.getTicketCart()){
                    List<Ticket> tickets = ticketService.findTicketsByid(id,userID);
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
                    Food item = foodService.getFoodById(id,userID);
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
                    Drink item = drinkService.getDrinkById(id,userID);
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
                    AlcoholItem item = alcoholService.getAlcoholById(id,userID);
                    String[] line = new String[]{
                            item.getType(),
                            String.valueOf(cart.getAlcoholCart().get(id)),
                            ""
                    };
                    lines.add(line);
                }
            }

            pe.lines = lines;
            pe.date = entry.getDate();
            parsed.add(pe);
        }

        return parsed;
    }

}
