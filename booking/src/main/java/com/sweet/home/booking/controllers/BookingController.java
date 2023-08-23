package com.sweet.home.booking.controllers;

import com.sweet.home.booking.dto.BookingInfoDTO;
import com.sweet.home.booking.dto.TransactionDetailsDTO;
import com.sweet.home.booking.feign.PaymentServiceClient;
import com.sweet.home.booking.services.BookingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "booking_app/hotel")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    PaymentServiceClient paymentServiceClient;

    @GetMapping(
            value = "/healthy-check"
    )
    public Object checkStatus() {
        return ResponseEntity.ok().body("Service is up and running fine.");
    }

    // RequestBody: fromDate, toDate, aadharNumber, numOfRooms
    @PostMapping(
            value = "/booking",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<BookingInfoDTO> booking(BookingInfoDTO data) {
        return new ResponseEntity(new BookingInfoDTO(), HttpStatus.CREATED);
    }

    // RequestBody: paymentMode, bookingId, upiId, cardNumber
    @PostMapping(
            value = "/booking/{bookingId}/transaction",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<BookingInfoDTO> bookingTransactionById(@PathVariable(name = "bookingId") int bookingId, TransactionDetailsDTO data) {
        return new ResponseEntity(new BookingInfoDTO(), HttpStatus.CREATED);
    }
}
