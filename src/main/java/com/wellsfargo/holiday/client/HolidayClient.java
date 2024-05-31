package com.wellsfargo.holiday.client;

import com.wellsfargo.holiday.model.HolidayAPIResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Objects;

@Component
public class HolidayClient {

    private static final String COUNTRY_CODE = "US";

    @Value("${holiday.api.url}")
    private String url;

    @Value("${holiday.api.key}")
    private String key;

    private RestTemplate restTemplate;

    @Autowired
    public HolidayClient(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
      public boolean isDateAHoliday(final int year, final int month, final int day) {

        //https://holidayapi.com/v1/holidays?country={countryCode}&key={key}&year={year}&month={month]&day={day}
        UriComponents uri = UriComponentsBuilder
                  .fromHttpUrl(url)
                  .buildAndExpand(COUNTRY_CODE, key, year, month, day);

        HolidayAPIResponse result = restTemplate.getForObject(uri.toUriString(), HolidayAPIResponse.class);

        return !Objects.requireNonNull(result).getHolidays().isEmpty();
    }
}
