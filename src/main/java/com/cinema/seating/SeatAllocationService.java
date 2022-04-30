package com.cinema.seating;

public class SeatAllocationService {

    private Ticket ticket;

    public SeatAllocationService(Ticket ticket) {
        this.ticket = ticket;
    }

    public String allocateSeats(int inputSeat) {
        if(inputSeat<0 || inputSeat>3) {
            return "Please enter input value between 0 and 3";
        } else if(availableSeats(inputSeat)) {
            return "";
        } else {
            return "Seats are not available. Please try for next show!";
        }
    }

    public boolean availableSeats(int inputSeat) {
        return inputSeat<ticket.getCurrentAvailableSeats();
    }
}
