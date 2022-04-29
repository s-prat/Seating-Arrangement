package com.cinema.seating;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SeatAllocationServiceTest {

    private SeatAllocationService seatAllocationService;

    @BeforeEach
    public void setUp() {
        seatAllocationService = new SeatAllocationService();
    }

    @Test
    public void testAllocateSeats(int inputSeats) {
        String result = seatAllocationService.allocateSeats(3);
    }
}
