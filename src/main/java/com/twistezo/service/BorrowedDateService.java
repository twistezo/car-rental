package com.twistezo.service;

import com.twistezo.model.AvailableCarsResult;
import com.twistezo.model.BorrowedDate;

import java.util.Calendar;
import java.util.List;

/**
 * @author twistezo (02.03.2017)
 */

public interface BorrowedDateService {

    List<AvailableCarsResult> checkAvailableCarById(Calendar startDate, Calendar endDate, Long id);
    List<AvailableCarsResult> checkAvailableCars(Calendar startDate, Calendar endDate);
    List<BorrowedDate> findAll();
    BorrowedDate findByCustomerId(Long id);
    BorrowedDate findByCarId(Long id);
    void save(BorrowedDate borrowedDate);
    long countDays(BorrowedDate borrowedDate);
}
