package com.hritam.CarServiceAgency.Controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hritam.CarServiceAgency.Json.ErrorJson;
import com.hritam.CarServiceAgency.Json.RequestJson;
import com.hritam.CarServiceAgency.Json.ResponseJson;
import com.hritam.CarServiceAgency.Service.CarServiceAgencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// All the API endpoint are exposed her ein the controller

@RestController
@RequestMapping("/v1/carsService")
public class CarServiceAgencyController {

    @Autowired
    private CarServiceAgencyService carServiceAgencyService;

    private static  final  Gson gson  = new GsonBuilder().setDateFormat(String.valueOf("dd/mm/yyyy HH:mm:ss")).create();
    @GetMapping("/healthCheck")
    public ResponseEntity<String> healthCheck() {
      System.out.println("Health Check");
      return ResponseEntity.ok("OK");
    }

    @PostMapping(value= "/createBooking")
    public ResponseEntity<String> createBooking(@RequestBody String body) {
        System.out.println("Request Received for booking");
        RequestJson requestJson;
        ResponseJson responseJson = new ResponseJson();

        try{
            requestJson = gson.fromJson(body, RequestJson.class);
        } catch (Exception e) {
            ErrorJson errorJson = new ErrorJson();
            errorJson.setCode(434);
            errorJson.setMessage(e.getMessage());
            responseJson.setError(errorJson);
            return ResponseEntity.status(434).body(gson.toJson(responseJson));
        }

        try{
            responseJson = carServiceAgencyService.postBooking(requestJson);
            if (responseJson.getError() !=null ) {
               return ResponseEntity.status(434).body(gson.toJson(responseJson));
            } else {
                return ResponseEntity.status(200).body(gson.toJson(responseJson));
            }
        } catch (Exception e) {
              return new ResponseEntity<>("InternalServerError", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/allBookingsOfOperator")
    public ResponseEntity<String> allBookingsOfCustomer(
            @RequestParam(name = "operatorId", required = true, defaultValue = "") Long operator_id,
            @RequestHeader(name = "Date", required = false) String booking_date
    ) {
        System.out.println("Request Received for fetching all bookings");
        ResponseJson responseJson = new ResponseJson();
        responseJson = carServiceAgencyService.fetchAllBookingOfOperator(operator_id, booking_date);
        return ResponseEntity.status(200).body(gson.toJson(responseJson));
    }

    @GetMapping(value = "/allAvailableSlotsOfOperator")
    public ResponseEntity<String> allAvailableSlotsOfOperator(
            @RequestParam(name = "operatorId", required = true, defaultValue = "") Long operator_id,
            @RequestHeader(name = "Date", required = false) String booking_date
    ) {
        ResponseJson responseJson = new ResponseJson();
        try{
            System.out.println("Request Received for fetching all available slots");
            responseJson = carServiceAgencyService.fetchAllAvaliableSlotsOfOperator(operator_id, booking_date);
            return ResponseEntity.status(200).body(gson.toJson(responseJson));
        } catch (Exception e) {
            ErrorJson errorJson = new ErrorJson();
            errorJson.setCode(434);
            errorJson.setMessage(e.getMessage());
            responseJson.setError(errorJson);
            return ResponseEntity.status(434).body(gson.toJson(responseJson));
        }
    }

    @PutMapping(value = "/cancelBooking")
    public ResponseEntity<String> cancelBooking(
            @RequestParam(name = "bookingId", required = true, defaultValue = "") Long id
    ) {
        ResponseJson responseJson = new ResponseJson();
        try{
            responseJson = carServiceAgencyService.disableBooking(id);
            if (responseJson.getError() !=null ) {
                return ResponseEntity.status(434).body(gson.toJson(responseJson));
            }
            return ResponseEntity.status(200).body(gson.toJson(responseJson));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            ErrorJson errorJson = new ErrorJson();
            errorJson.setCode(434);
            errorJson.setMessage(e.getMessage());
            responseJson.setError(errorJson);
            return new ResponseEntity<>("InternalServerError", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping(value = "/rescheduleBooking")
    public ResponseEntity<String> rescheduleBooking(
            @RequestParam(name = "bookingId", required = true, defaultValue = "") Long id,
             @RequestHeader(name = "bookingDate", required = true) String bookingDate
    ) {
        ResponseJson responseJson = new ResponseJson();
        try{
            responseJson = carServiceAgencyService.rescheduleBooking(id, bookingDate);
            if (responseJson.getError() !=null ) {
                return ResponseEntity.status(434).body(gson.toJson(responseJson));
            }
            return ResponseEntity.status(200).body(gson.toJson(responseJson));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            ErrorJson errorJson = new ErrorJson();
            errorJson.setCode(434);
            errorJson.setMessage(e.getMessage());
            responseJson.setError(errorJson);
            return new ResponseEntity<>("InternalServerError", HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
