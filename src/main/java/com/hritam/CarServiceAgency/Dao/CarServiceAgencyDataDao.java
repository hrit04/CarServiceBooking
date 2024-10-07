package com.hritam.CarServiceAgency.Dao;


import com.hritam.CarServiceAgency.Entity.BookingData;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

// Dao contains all the database custom calls

@Repository
@Transactional
public interface CarServiceAgencyDataDao extends JpaRepository<BookingData, Long> {

    @Query("select k from BookingData k where k.id =:id")
    BookingData getBookingDataById(Long id);

    @Query("select k from BookingData k where k.operatorId =:operator_id and k.booking_date =:booking_date")
    List<BookingData> findAllByOpIdDate(@Param("operator_id") Long operator_id, @Param("booking_date") String booking_date);

    /*
    booking_status : 1 = CREATED
                     2 = RESCHEDULED
                     3 = COMPLETED
                     4 = CANCELED
    */
    @Modifying
    @Query("update BookingData b set b.booking_status=:status where b.id=:id")
    void updateBooking(@Param("id") Long id, @Param("status") int status);

    @Modifying
    @Query("update BookingData b set b.booking_status=:status , b.booking_date=:booking_date where b.id=:id")
    void updateBookingTime(@Param("id") Long id, @Param("status") int status, @Param("booking_date") String booking_date);
}
