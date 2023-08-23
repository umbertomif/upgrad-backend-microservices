package com.sweet.home.booking.dto;

import javax.validation.constraints.NotBlank;

public class TransactionDetailsDTO {

    @NotBlank(message = "paymentMode cannot be null")
    private String paymentMode;

    @NotBlank(message = "bookingId cannot be null")
    private int bookingId;

    private String upiId;

    private String cardNumber;
}
