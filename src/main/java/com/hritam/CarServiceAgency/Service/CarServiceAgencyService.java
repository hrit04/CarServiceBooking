package com.hritam.CarServiceAgency.Service;

import com.hritam.CarServiceAgency.Json.RequestJson;
import com.hritam.CarServiceAgency.Json.ResponseJson;

import java.util.Date;

public interface CarServiceAgencyService {

    ResponseJson postBooking(RequestJson requestJson);

    ResponseJson fetchAllBookingOfOperator(Long operator_id, String booking_date);

    ResponseJson fetchAllAvaliableSlotsOfOperator(Long operator_id, String booking_date);

    ResponseJson disableBooking(Long id);

    ResponseJson rescheduleBooking(Long id, String reschedule_time);
}
