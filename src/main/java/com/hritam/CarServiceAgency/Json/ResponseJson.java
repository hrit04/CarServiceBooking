package com.hritam.CarServiceAgency.Json;

import com.hritam.CarServiceAgency.Entity.BookingData;

import java.util.List;

public class ResponseJson {

    private String message;
    private int statusCode;
    private List<BookingData> bookingData;
    private List<String>bookedSlots;
    private List<String>availableSlots;
    private Long GeneratedBookingId;
    public ResponseJson(String message, int statusCode, List<BookingData> bookingData, List<String> bookedSlots, List<String> availableSlots, Long generatedBookingId) {
        this.message = message;
        this.statusCode = statusCode;
        this.bookingData = bookingData;
        this.bookedSlots = bookedSlots;
        this.availableSlots = availableSlots;
        this.GeneratedBookingId = generatedBookingId;
    }

    public Long getGeneratedBookingId() {
        return GeneratedBookingId;
    }

    public void setGeneratedBookingId(Long generatedBookingId) {
        GeneratedBookingId = generatedBookingId;
    }

    public List<String> getAvailableSlots() {
        return availableSlots;
    }

    public void setAvailableSlots(List<String> availableSlots) {
        this.availableSlots = availableSlots;
    }

    public List<String> getBookedSlots() {
        return bookedSlots;
    }

    public void setBookedSlots(List<String> bookedSlots) {
        this.bookedSlots = bookedSlots;
    }

    public List<BookingData> getBookingData() {
        return bookingData;
    }

    public void setBookingData(List<BookingData> bookingData) {
        this.bookingData = bookingData;
    }

    public ResponseJson() {}
    public ResponseJson(String message, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    ErrorJson error;


    public ErrorJson getError() {
        return error;
    }
    public void setError(ErrorJson error) {
        this.error = error;
    }
}
