package com.cinema.seating;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeatAllocationServiceTest {

    private SeatAllocationService seatAllocationService;

    @BeforeEach
    public void setUp() {
        seatAllocationService = new SeatAllocationService();
    }

    @ParameterizedTest
    @CsvSource({"3, A1 A2 A2"})
    public void testAllocateSeats(int inputSeats, String expected) {
        assertEquals(expected, seatAllocationService.allocateSeats(inputSeats));
    }
}
