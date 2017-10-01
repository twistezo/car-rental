package com.twistezo.repository;

import com.twistezo.model.AvailableCarsResult;
import com.twistezo.model.BorrowedDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Calendar;
import java.util.List;

@Repository
public interface BorrowedDateDAO extends JpaRepository<BorrowedDate, Long> {
    BorrowedDate findByCustomerId(Long id);
    BorrowedDate findByCarId(Long id);
    List<BorrowedDate> findAll();

    /*
    Hibernate console test:

    select NEW com.twistezo.model.AvailableCarsResult
    (b.id, b.car.id, b.car.name, b.car.description, b.car.price)
    from BorrowedDate as b
    where '2017-04-01 00:00:00' not between b.startDate and b.endDate
    and '2017-04-10 00:00:00' not between b.startDate and b.endDate
    and b.car.id NOT IN (select DISTINCT bd.car.id
    from BorrowedDate bd
    where '2017-04-01 00:00:00' between bd.startDate and bd.endDate
    OR '2017-04-10 00:00:00' between bd.startDate and bd.endDate)

    + every without borrowed dates
    from Car as c
    where c.id not in
    (select b.car.id from BorrowedDate as b)
    */
    @Query("select NEW com.twistezo.model.AvailableCarsResult "+
            "(b.id, b.car.id, b.car.name, b.car.description, b.car.price) "+
            "from BorrowedDate as b "+
            "where :startDate not between b.startDate and b.endDate "+
            "and :endDate not between b.startDate and b.endDate "+
            "and b.car.id NOT IN (select DISTINCT bd.car.id "+
                "from BorrowedDate bd "+
                "where :startDate between bd.startDate and bd.endDate "+
                "OR :endDate between bd.startDate and bd.endDate) " +
                "group by b.car.id")
    List<AvailableCarsResult> checkAvailableCars(@Param("startDate") Calendar startDate,
                                                 @Param("endDate") Calendar endDate);

    @Query("select NEW com.twistezo.model.AvailableCarsResult "+
            "(b.id, b.car.id, b.car.name, b.car.description, b.car.price) "+
            "from BorrowedDate as b "+
            "where :startDate not between b.startDate and b.endDate "+
            "and :endDate not between b.startDate and b.endDate "+
            "and b.car.id = :carId "+
            "and b.car.id NOT IN (select DISTINCT bd.car.id "+
                "from BorrowedDate bd "+
                "where :startDate between bd.startDate and bd.endDate "+
                "OR :endDate between bd.startDate and bd.endDate)")
    List<AvailableCarsResult> checkAvailableCarById(@Param("startDate") Calendar startDate,
                                                    @Param("endDate") Calendar endDate,
                                                    @Param("carId") Long id);


}
