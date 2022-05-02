package com.cinema.seating;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class SeatAllocationServiceTest {

    private SeatAllocationService seatAllocationService;

    @BeforeEach
    public void setUp() {
        Cinema cinema = new Cinema(3, 5);
        Ticket ticket = new Ticket(cinema);
        seatAllocationService = new SeatAllocationService(ticket);
    }

    @ParameterizedTest
    @CsvSource({"3, A1A2A3", "2, A1A2", "1, A1"})
    public void testAllocateSeats(int inputSeats, String expected) {
        assertEquals(expected, seatAllocationService.allocateSeats(inputSeats));
    }

    @Test
    public void testAllocateSeatsWithTwoInputRequestsOf3Seats() {
        seatAllocationService.allocateSeats(3);
        String result = seatAllocationService.allocateSeats(3);
        assertEquals("B1B2B3", result);
    }

    @Test
    public void testAllocateSeatsWithTwoInputRequestsOfDiffInputSeats() {
        seatAllocationService.allocateSeats(3);
        String result = seatAllocationService.allocateSeats(2);
        assertEquals("A4A5", result);
    }

    @Test
    public void testAllocateSeatsWithThreeInputRequestsOf3Seats() {
        seatAllocationService.allocateSeats(3);
        seatAllocationService.allocateSeats(3);
        String result = seatAllocationService.allocateSeats(3);
        assertEquals("C1C2C3", result);
    }

    @Test
    public void testAllocateSeatsWithThreeInputRequestsOfDiffInputSeats() {
        seatAllocationService.allocateSeats(3);
        seatAllocationService.allocateSeats(3);
        String result = seatAllocationService.allocateSeats(2);
        assertEquals("A4A5", result);
    }

    @Test
    public void testAllocateSeatsWithThreeInputRequestsOfAllDiffInputSeats() {
        seatAllocationService.allocateSeats(3);
        seatAllocationService.allocateSeats(1);
        String result = seatAllocationService.allocateSeats(2);
        assertEquals("B1B2", result);
    }

    @Test
    public void testAllocateSeatsWithMoreThan3InputSeats() {
        assertEquals("Please enter input value between 0 and 3", seatAllocationService.allocateSeats(4));
    }

    @Test
    public void testAvailableSeatWhenEnoughSeatsAreNotAvailable() {
        seatAllocationService.allocateSeats(3);
        seatAllocationService.allocateSeats(3);
        seatAllocationService.allocateSeats(3);
        seatAllocationService.allocateSeats(2);
        seatAllocationService.allocateSeats(2);
        assertFalse(seatAllocationService.availableSeats(3));
    }

    @Test
    public void testAvailableSeatWhenSeatsAreAvailable() {
        seatAllocationService.allocateSeats(3);
        seatAllocationService.allocateSeats(3);
        seatAllocationService.allocateSeats(3);
        seatAllocationService.allocateSeats(2);
        seatAllocationService.allocateSeats(2);
        assertTrue(seatAllocationService.availableSeats(2));
    }
}
