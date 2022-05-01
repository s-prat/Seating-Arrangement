package com.cinema.seating;

import java.util.HashMap;

public class SeatAllocationService {

    private Ticket ticket;

    public SeatAllocationService(Ticket ticket) {
        this.ticket = ticket;
    }

    public String allocateSeats(int inputSeat) {
        if(inputSeat<0 || inputSeat>3) {
            return "Please enter input value between 0 and 3";
        } else if(availableSeats(inputSeat)) {
            HashMap rowMap = ticket.getRowMap();
            char rowName;
            if(Integer.valueOf(rowMap.get('A').toString()) >= inputSeat) {
                rowName = 'A';
            } else if(Integer.valueOf(rowMap.get('B').toString()) >= inputSeat) {
                rowName = 'B';
            } else {
                rowName = 'C';
            }
            return getSeatsAndUpdateAvailableSeatsInARow(rowMap, rowName, inputSeat);
        } else {
            return "Seats are not available. Please try for next show!";
        }
    }

    private String getSeats(String a, Integer availableSeat, int inputSeat) {
        StringBuilder result = new StringBuilder();
        for(int i=6-availableSeat; i<6-availableSeat+inputSeat;i++) {
            result.append(a);
            result.append(i);
        }
        return result.toString();
    }

    private String getSeatsAndUpdateAvailableSeatsInARow(HashMap rowMap, char rowName, int inputSeat) {
        int NoOfSeatsInARow = Integer.valueOf(rowMap.get(rowName).toString());
        ticket.setCurrentAvailableSeats(ticket.getCurrentAvailableSeats() - inputSeat);
        rowMap.put(rowName, NoOfSeatsInARow - inputSeat);
        return getSeats(String.valueOf(rowName), NoOfSeatsInARow, inputSeat);
    }

    public boolean availableSeats(int inputSeat) {
        return inputSeat<=ticket.getCurrentAvailableSeats();
    }
}
