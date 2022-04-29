package com.cinema.seating;

import java.util.HashMap;

public class Ticket {
    private Cinema cinemaDetails;
    private int[][] seatingArray;
    private int currentAvailableSeats;
    private HashMap rowMap;

    public Ticket(Cinema cinemaDetails) {
        this.cinemaDetails = cinemaDetails;
    }

    private HashMap<Character, Integer> getMap() {
        rowMap = new HashMap<Character, Integer>();
        rowMap.put('A', 5);
        rowMap.put('B', 5);
        rowMap.put('C', 5);
        return rowMap;
    }



}
