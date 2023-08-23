package com.sweet.home.booking.services;

import com.sweet.home.booking.entities.BookingInfoEntity;

public interface BookingService {

    public BookingInfoEntity createBooking(BookingInfoEntity bookingInfoEntity);

    public BookingInfoEntity getBookingDetails(int id);

    public BookingInfoEntity updateBooking(int id, BookingInfoEntity bookingInfoEntity);
}
