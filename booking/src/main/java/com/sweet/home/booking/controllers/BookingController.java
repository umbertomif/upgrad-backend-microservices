package com.sweet.home.booking.controllers;

import com.sweet.home.booking.dto.BookingInfoDTO;
import com.sweet.home.booking.dto.TransactionDetailsDTO;
import com.sweet.home.booking.entities.BookingInfoEntity;
import com.sweet.home.booking.services.BookingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/hotel")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping(
            value = "/healthy-check"
    )
    public ResponseEntity getStatus() {
        return new ResponseEntity("Service is up and running fine.", HttpStatus.OK);
    }

    @PostMapping(
            value = "/booking",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<BookingInfoEntity> booking(@RequestBody BookingInfoDTO data) {
        BookingInfoEntity requestedBooking = modelMapper.map(data, BookingInfoEntity.class);
        BookingInfoEntity responseBooking = bookingService.createBooking(requestedBooking);
        return new ResponseEntity(responseBooking, HttpStatus.CREATED);
    }

    @PostMapping(
            value = "/booking/{bookingId}/transaction",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<BookingInfoEntity> bookingTransactionById(@PathVariable(name = "bookingId") int bookingId, @Valid @RequestBody TransactionDetailsDTO data) {;
        BookingInfoEntity booking = bookingService.makePayment(bookingId, data);

        return new ResponseEntity(booking, HttpStatus.CREATED);
    }
}
