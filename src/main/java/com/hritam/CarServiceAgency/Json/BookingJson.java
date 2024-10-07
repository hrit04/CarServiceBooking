package com.hritam.CarServiceAgency.Json;


public class BookingJson {

    private Long customer_id;
    private Long operator_id;
    private int booking_slot;
    private int booking_status;
    private String booking_date;


    public BookingJson() {

    }

    public BookingJson(int booking_slot, int booking_status, Long customer_id, Long operator_id, String booking_date) {
        this.booking_slot = booking_slot;
        this.booking_status = booking_status;
        this.customer_id = customer_id;
        this.operator_id = operator_id;
        this.booking_date = booking_date;
    }

    public String getBooking_date() {
        return booking_date;
    }

    public void setBooking_date(String booking_date) {
        this.booking_date = booking_date;
    }

    public int getBooking_slot() {
        return booking_slot;
    }

    public void setBooking_slot(int booking_slot) {
        this.booking_slot = booking_slot;
    }

    public int getBooking_status() {
        return booking_status;
    }

    public void setBooking_status(int booking_status) {
        this.booking_status = booking_status;
    }

    public Long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Long customer_id) {
        this.customer_id = customer_id;
    }

    public Long getOperator_id() {
        return operator_id;
    }

    public void setOperator_id(Long operator_id) {
        this.operator_id = operator_id;
    }
}
