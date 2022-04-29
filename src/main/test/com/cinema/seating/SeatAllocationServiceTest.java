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
        seatAllocationService = new SeatAllocationService();
    }

    @ParameterizedTest
    @CsvSource({"3, A1 A2 A3", "2, A1 A2", "1, A1"})
    public void testAllocateSeats(int inputSeats, String expected) {
        assertEquals(expected, seatAllocationService.allocateSeats(inputSeats));
    }

    @Test
    public void testAllocateSeatsWithTwoInputRequestsOf3Seats() {
        seatAllocationService.allocateSeats(3);
        String result = seatAllocationService.allocateSeats(3);
        assertEquals("B1 B2 B3", result);
    }

    @Test
    public void testAllocateSeatsWithTwoInputRequestsOfDiffInputSeats() {
        seatAllocationService.allocateSeats(3);
        String result = seatAllocationService.allocateSeats(2);
        assertEquals("A4 A5", result);
    }

    @Test
    public void testAllocateSeatsWithThreeInputRequestsOf3Seats() {
        seatAllocationService.allocateSeats(3);
        seatAllocationService.allocateSeats(3);
        String result = seatAllocationService.allocateSeats(3);
        assertEquals("C1 C2 C3", result);
    }

    @Test
    public void testAllocateSeatsWithThreeInputRequestsOfDiffInputSeats() {
        seatAllocationService.allocateSeats(3);
        seatAllocationService.allocateSeats(3);
        String result = seatAllocationService.allocateSeats(2);
        assertEquals("A4 A5", result);
    }

    @Test
    public void testAllocateSeatsWithThreeInputRequestsOfAllDiffInputSeats() {
        seatAllocationService.allocateSeats(3);
        seatAllocationService.allocateSeats(1);
        String result = seatAllocationService.allocateSeats(2);
        assertEquals("B1 B2", result);
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
