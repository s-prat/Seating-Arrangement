package com.cinema.seating;

public class Cinema {
    private int totalSeatingCapacity;
    private int noOfRows;
    private int noOfColumns;

    public Cinema(int noOfRows, int noOfColumns) {
        this.totalSeatingCapacity = noOfRows * noOfColumns;
        this.noOfColumns = noOfColumns;
        this.noOfRows = noOfRows;
    }

    public int getTotalSeatingCapacity() {
        return totalSeatingCapacity;
    }

    public int getNoOfRows() {
        return noOfRows;
    }

    public int getNoOfColumns() {
        return noOfColumns;
    }
}
