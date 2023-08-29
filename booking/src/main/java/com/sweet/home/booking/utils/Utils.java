package com.sweet.home.booking.utils;

import com.sweet.home.booking.entities.BookingInfoEntity;

import java.util.ArrayList;
import java.util.Random;

public class Utils {
    public static ArrayList<String> getRandomNumbers(int count){
        Random rand = new Random();
        int upperBound = 100;
        ArrayList<String>numberList = new ArrayList<String>();

        for (int i=0; i<count; i++){
            numberList.add(String.valueOf(rand.nextInt(upperBound)));
        }
        return numberList;
    }

    public static void generateBookingConfirmationMessage(BookingInfoEntity bookingInfo) {
        String message = "Booking confirmed for user with Aadhaar number: " +
                bookingInfo.getAadharNumber() +
                " | " +
                "Booking details: " + bookingInfo;
        System.out.println(message);
    }
}
