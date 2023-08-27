package com.sweet.home.booking;

import com.sweet.home.booking.dto.BookingInfoDTO;
import com.sweet.home.booking.entities.BookingInfoEntity;
import org.modelmapper.*;
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
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@RestController
@SpringBootApplication
@EnableAspectJAutoProxy
@EnableJpaRepositories(basePackages = "com.sweet.home.booking.repository")
public class BookingApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(BookingApplication.class, args);
	}

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelmapper = new ModelMapper();
		Converter<String, LocalDateTime> toStringDate = new AbstractConverter<String, LocalDateTime>() {
			@Override
			protected LocalDateTime convert(String source) {
				LocalDate localDate = LocalDate.parse(source, DateTimeFormatter.ISO_DATE);
				return localDate.atTime(LocalTime.MIDNIGHT);
			}
		};
		TypeMap<BookingInfoDTO, BookingInfoEntity> propertyMapper = modelmapper.createTypeMap(BookingInfoDTO.class, BookingInfoEntity.class);
		propertyMapper.addMappings(mapper -> mapper.using(toStringDate).map(BookingInfoDTO::getFromDate, BookingInfoEntity::setFromDate));
		propertyMapper.addMappings(mapper -> mapper.using(toStringDate).map(BookingInfoDTO::getToDate, BookingInfoEntity::setToDate));
		return modelmapper;
	}

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
}
