package com.sweet.home.booking.services;

import com.sweet.home.booking.entities.BookingInfoEntity;
import com.sweet.home.booking.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository repository;

    @Override
    public BookingInfoEntity createBooking(BookingInfoEntity bookingInfoEntity) {
        return repository.save(bookingInfoEntity);
    }

    @Override
    public BookingInfoEntity getBookingDetails(int id) {
        return repository.findById(id).get();
    }

    @Override
    public BookingInfoEntity updateBooking(int id, BookingInfoEntity bookingInfoEntity) {
        // get booking
        BookingInfoEntity savedBooking = getBookingDetails(id);
        // update booking
        savedBooking.setFromDate(bookingInfoEntity.getFromDate());
        savedBooking.setToDate(bookingInfoEntity.getToDate());
        savedBooking.setAadharNumber(bookingInfoEntity.getAadharNumber());
        savedBooking.setNumOfRooms(bookingInfoEntity.getNumOfRooms());
        savedBooking.setRoomNumbers(bookingInfoEntity.getRoomNumbers());
        savedBooking.setRoomPrice(bookingInfoEntity.getRoomPrice());
        savedBooking.setTransactionId(bookingInfoEntity.getTransactionId());
        savedBooking.setBookedOn(bookingInfoEntity.getBookedOn());
        // save booking
        return repository.save(bookingInfoEntity);
    }
}
