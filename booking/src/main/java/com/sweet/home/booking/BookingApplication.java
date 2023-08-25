package com.sweet.home.booking;

import com.sweet.home.booking.entities.BookingInfoEntity;
import com.sweet.home.booking.services.BookingService;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.time.LocalDate;

@RestController
@SpringBootApplication
@EnableAspectJAutoProxy
@EnableJpaRepositories(basePackages = "com.sweet.home.booking.repository")
public class BookingApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BookingApplication.class, args);

		// Testing
		BookingService bookingService = context.getBean(BookingService.class);
		System.out.println("Booking Service bean : " + bookingService);
		// create
		System.out.println("created");
		BookingInfoEntity bookingInfoEntity = new BookingInfoEntity();
		bookingInfoEntity.setFromDate(LocalDate.parse("2023-08-03"));
		bookingInfoEntity.setToDate(LocalDate.parse("2023-10-03"));
		bookingInfoEntity.setAadharNumber("123456");
		bookingInfoEntity.setNumOfRooms(1);
		bookingInfoEntity.setRoomNumbers("one");
		bookingInfoEntity.setRoomPrice(1000);
		BookingInfoEntity created = bookingService.createBooking(bookingInfoEntity);
		System.out.println(created);
		// update
		System.out.println("updated");
		BookingInfoEntity updateBooking = new BookingInfoEntity();
		updateBooking.setBookingId(created.getBookingId());
		updateBooking.setFromDate(LocalDate.parse("2023-08-03"));
		updateBooking.setToDate(LocalDate.parse("2023-10-03"));
		updateBooking.setAadharNumber("ABIDE");
		updateBooking.setNumOfRooms(1);
		updateBooking.setRoomNumbers("one");
		updateBooking.setRoomPrice(1000);
		updateBooking.setTransactionId(1234567890);
		updateBooking.setBookedOn(LocalDate.parse("2023-08-03"));
		BookingInfoEntity updated = bookingService.updateBooking(updateBooking.getBookingId(), updateBooking);
		System.out.println(updated);
		// get
		System.out.println("getBooking");
		BookingInfoEntity getBooking = bookingService.getBookingDetails(updated.getBookingId());
		System.out.println(getBooking);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
}
