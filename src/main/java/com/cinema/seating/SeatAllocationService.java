package com.cinema.seating;

public class SeatAllocationService {

    private Ticket ticket;

    public SeatAllocationService(Ticket ticket) {
        this.ticket = ticket;
    }

    public String allocateSeats(int inputSeat) {
        return "A1 A2 A3";
    }

    public boolean availableSeats(int inputSeat) {
        return inputSeat<ticket.getCurrentAvailableSeats();
    }
}
