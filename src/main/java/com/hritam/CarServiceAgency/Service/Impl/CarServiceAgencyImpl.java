package com.hritam.CarServiceAgency.Service.Impl;

import com.hritam.CarServiceAgency.Constants;
import com.hritam.CarServiceAgency.Dao.CarServiceAgencyDataDao;
import com.hritam.CarServiceAgency.Entity.BookingData;
import com.hritam.CarServiceAgency.Json.BookingJson;
import com.hritam.CarServiceAgency.Json.ErrorJson;
import com.hritam.CarServiceAgency.Json.RequestJson;
import com.hritam.CarServiceAgency.Json.ResponseJson;
import com.hritam.CarServiceAgency.Service.CarServiceAgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;


@Service
public class CarServiceAgencyImpl implements CarServiceAgencyService {

    @Autowired
    private CarServiceAgencyDataDao carServiceAgencyDataDao;

    @Override
    public ResponseJson postBooking(RequestJson requestJson) {
        ResponseJson responseJson = new ResponseJson();
        if (requestJson != null) {
           BookingData bookingData = new BookingData();
            BookingJson bookingJson = requestJson.getBookingInfo();
            bookingData.setCustomerId(bookingJson.getCustomer_id());
            bookingData.setBooking_status(bookingJson.getBooking_status());
            bookingData.setBooking_slot(bookingJson.getBooking_slot());
            bookingData.setOperatorId(bookingJson.getOperator_id());
            bookingData.setBooking_date(bookingJson.getBooking_date());
            BookingData savedBooking = carServiceAgencyDataDao.save(bookingData);
            responseJson.setGeneratedBookingId(savedBooking.getId());
            responseJson.setStatusCode(200);
            responseJson.setMessage("Success");
        } else {
            ErrorJson errorJson = new ErrorJson();
            errorJson.setCode(400);
            errorJson.setMessage("Unable to create booking");
            responseJson.setError(errorJson);

        }
        return responseJson;
    }

    @Override
    public ResponseJson fetchAllBookingOfOperator(Long operator_id, String booking_date) {
        ResponseJson responseJson = new ResponseJson();
        if (operator_id != null && booking_date != null) {
             List<BookingData> bookingDataList = new ArrayList<>();
             List<String>bookedSlots = new ArrayList<>();
             List<Integer>sortedSlots = new ArrayList<>();

              bookingDataList = carServiceAgencyDataDao.findAllByOpIdDate(operator_id, booking_date);
              for (BookingData bookingData : bookingDataList) {
                  if(bookingData.getBooking_slot() > 0) {
                      sortedSlots.add(bookingData.getBooking_slot());
                  }
              }
              Collections.sort(sortedSlots);
              for (int i = 0; i < sortedSlots.size(); i++) {
                  int from = sortedSlots.get(i);
                  int to = (from + 1) % 24;
                  bookedSlots.add(from + "-" +to);
              }
              System.out.println(bookedSlots);
              responseJson.setBookedSlots(bookedSlots);
              responseJson.setStatusCode(200);
              responseJson.setMessage("Success");
        } else {
            ErrorJson errorJson = new ErrorJson();
            errorJson.setCode(400);
            errorJson.setMessage("Input is not sufficient to fetch all bookings");
            responseJson.setError(errorJson);
        }
        return responseJson;
    }


    @Override
    public ResponseJson fetchAllAvaliableSlotsOfOperator(Long operator_id, String booking_date) {
        ResponseJson responseJson = new ResponseJson();
        if (operator_id != null && booking_date != null) {
            List<BookingData> bookingDataList = new ArrayList<>();
            HashMap<Integer, Integer>mappedBookings = new HashMap<>();
            List<Integer>freeSlots = new ArrayList<>();
            List<Integer>bookedSlots = new ArrayList<>();
            List<String>mergedFreeSlots = new ArrayList<>();

            bookingDataList = carServiceAgencyDataDao.findAllByOpIdDate(operator_id, booking_date);
            for (BookingData bookingData : bookingDataList) {
                if(bookingData.getBooking_slot() > 0) {
                    mappedBookings.put(bookingData.getBooking_slot(),  1);
                }
            }

            for (int i = 1; i<=24; i++) {
                if (!mappedBookings.containsKey(i)) {
                    freeSlots.add(i);
                }
            }
            Collections.sort(freeSlots);
            int start = freeSlots.get(0);
            for(int i=0; i<freeSlots.size()-1; i++) {
                System.out.print(freeSlots.get(i) + ",");
                if(freeSlots.get(i+1) != freeSlots.get(i)+1 ) {
                    int end =  freeSlots.get(i);
                    if (start == end) {
                        end = end + 1;
                    }
                    mergedFreeSlots.add(start + "-" + end);
                    start = freeSlots.get(i+1);
                }
            }
            if(start != 24) {
                mergedFreeSlots.add(start + "-" + 24);
            }
            System.out.println(mergedFreeSlots);
            responseJson.setAvailableSlots(mergedFreeSlots);
            responseJson.setStatusCode(200);
            responseJson.setMessage("Success");
            //return responseJson;
        } else {
            ErrorJson errorJson = new ErrorJson();
            errorJson.setCode(400);
            errorJson.setMessage("Input is not sufficient to fetch free slots");
            responseJson.setError(errorJson);
        }
        return responseJson;
    }

    @Override
    public ResponseJson disableBooking(Long id) {
        ResponseJson responseJson = new ResponseJson();
        if (id != null) {
            Constants constants = new Constants();
            int status = constants.getValue("BOOKING_CANCELED");
            carServiceAgencyDataDao.updateBooking(id, status);
            responseJson.setStatusCode(200);
            responseJson.setMessage("Success");
        } else {
            ErrorJson errorJson = new ErrorJson();
            errorJson.setCode(400);
            errorJson.setMessage("Input is not sufficient to cancel booking");
            responseJson.setError(errorJson);
        }
        return responseJson;
    }

    @Override
    public ResponseJson rescheduleBooking(Long id, String reschedule_time) {
        ResponseJson responseJson = new ResponseJson();
        if (id != null) {
            Constants constants = new Constants();
            int status = constants.getValue("BOOKING_RESCHEDULED");
            carServiceAgencyDataDao.updateBookingTime(id, status, reschedule_time);
            responseJson.setStatusCode(200);
            responseJson.setMessage("Success");
        } else {
            ErrorJson errorJson = new ErrorJson();
            errorJson.setCode(400);
            errorJson.setMessage("Input is not sufficient to reschedule booking");
            responseJson.setError(errorJson);
        }
        return responseJson;
    }


}
