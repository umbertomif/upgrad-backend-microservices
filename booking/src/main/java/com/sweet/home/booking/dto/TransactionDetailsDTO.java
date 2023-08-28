package com.sweet.home.booking.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class TransactionDetailsDTO {

    @NotBlank(message = "paymentMode cannot be null")
    @Pattern(regexp = "^(CARD|UPI)$", message = "Invalid mode of payment")
    private String paymentMode;

    @NotNull(message = "bookingId cannot be null")
    private int bookingId;

    private String upiId;

    private String cardNumber;

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getUpiId() {
        return upiId;
    }

    public void setUpiId(String upiId) {
        this.upiId = upiId;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
}
