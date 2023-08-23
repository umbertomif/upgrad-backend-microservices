package com.sweet.home.booking.dto;

import javax.validation.constraints.NotBlank;

public class BookingInfoDTO {

    private String fromDate;

    private String toDate;

    private String aadharNumber;

    @NotBlank(message = "numOfRooms cannot be null")
    private int numOfRooms;

    @NotBlank(message = "roomNumbers cannot be null")
    private String roomNumbers;

    @NotBlank(message = "roomPrice cannot be null")
    private int roomPrice;

    @NotBlank(message = "transactionId cannot be null")
    private int transactionId;

    private String bookedOn;
}
