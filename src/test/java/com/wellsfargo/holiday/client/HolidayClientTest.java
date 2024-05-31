package com.wellsfargo.holiday.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@ActiveProfiles("test")
public class HolidayClientTest {

    @Autowired
    private HolidayClient holidayClient;


    @Test
    public void testThatNewYearsDayIsAHoliday() {

        boolean actual = holidayClient.isDateAHoliday(2023, 1, 1);

        assertTrue(actual);
    }

    @Test
    public void testThatJanuaryTenthIsNotAHoliday() {

        boolean actual = holidayClient.isDateAHoliday(2023, 1, 10);

        assertFalse(actual);
    }

    @Test
    public void testThatIndependenceDayIsAHoliday() {

        boolean actual = holidayClient.isDateAHoliday(2023, 7, 4);

        assertTrue(actual);
    }

    @Test
    public void testThatChristmasIsAHoliday() {

        boolean actual = holidayClient.isDateAHoliday(2023, 12, 25);

        assertTrue(actual);
    }


}
