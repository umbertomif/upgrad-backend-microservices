package com.sweet.home.booking.services;

import com.sweet.home.booking.dto.TransactionDetailsDTO;
import com.sweet.home.booking.entities.BookingInfoEntity;
import com.sweet.home.booking.repository.BookingRepository;
import com.sweet.home.booking.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository repository;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${paymentApp.transactionPath}")
    private String transactionPath;

    @Override
    public BookingInfoEntity createBooking(BookingInfoEntity bookingInfoEntity) {
        ArrayList<String> listRooms = Utils.getRandomNumbers(bookingInfoEntity.getNumOfRooms());
        bookingInfoEntity.setRoomNumbers(String.join(",", listRooms));
        long daysBetween = ChronoUnit.DAYS.between(bookingInfoEntity.getFromDate(), bookingInfoEntity.getToDate());
        bookingInfoEntity.setRoomPrice(1000 * bookingInfoEntity.getNumOfRooms() * (int) daysBetween);
        bookingInfoEntity.setBookedOn(LocalDateTime.now());
        return repository.save(bookingInfoEntity);
    }

    @Override
    public BookingInfoEntity getBookingDetails(int id) throws NoSuchElementException {
        Optional<BookingInfoEntity> optionalBooking = repository.findById(id);
        if (optionalBooking.isPresent()) {
            return optionalBooking.get();
        } else {
            throw new NoSuchElementException("Invalid Booking Id");
        }
    }

    @Override
    public BookingInfoEntity makePayment(int bookingId, TransactionDetailsDTO transactionDetailsDTO) {
        BookingInfoEntity savedBooking = getBookingDetails(bookingId);
        int transactionId = restTemplate.postForObject(transactionPath, transactionDetailsDTO, Integer.class);
        savedBooking.setTransactionId(transactionId);
        return repository.save(savedBooking);
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
