package com.cinema.seating;

import java.util.HashMap;

public class Ticket {
    private int[][] seatingArray;
    private int currentAvailableSeats;
    private HashMap rowMap;

    public Ticket(Cinema cinemaDetails) {
        currentAvailableSeats = cinemaDetails.getTotalSeatingCapacity();
        //rowMap is used to check which row has how many empty seats
        rowMap = new HashMap<Character, Integer>();
        rowMap.put('A', 5);
        rowMap.put('B', 5);
        rowMap.put('C', 5);

        seatingArray = new int[cinemaDetails.getNoOfRows()][cinemaDetails.getNoOfColumns()];
    }

    public int[][] getSeatingArray() {
        return seatingArray;
    }

    public int getCurrentAvailableSeats() {
        return currentAvailableSeats;
    }

    public HashMap getRowMap() {
        return rowMap;
    }

    public void setCurrentAvailableSeats(int currentAvailableSeats) {
        this.currentAvailableSeats = currentAvailableSeats;
    }

    public void setRowMap(HashMap rowMap) {
        this.rowMap = rowMap;
    }
}
