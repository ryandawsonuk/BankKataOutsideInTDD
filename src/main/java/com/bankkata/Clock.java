package com.bankkata;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by ryan on 06/02/2017.
 * Abstraction over java date's so that we can control how date is obtained.
 */
public class Clock {

    /**
     * date needs to be formatted string
     * @return
     */
    public String dateAsString(){

        LocalDate date = today();
        return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

    }

    /**
     * date-producing method so that date can be controlled for testing purposes
     * @return
     */
    protected LocalDate today() {
        return LocalDate.now();
    }
}
