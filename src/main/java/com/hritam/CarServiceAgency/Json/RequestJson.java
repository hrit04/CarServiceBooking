package com.hritam.CarServiceAgency.Json;

public class RequestJson {

    BookingJson booking;

    public RequestJson(BookingJson booking) {
        this.booking = booking;
    }

    public BookingJson getBookingInfo() {
        return booking;
    }

    public void setBookingInfo(BookingJson booking) {
        this.booking = booking;
    }

}
