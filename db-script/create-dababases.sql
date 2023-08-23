create database booking;
use booking;
CREATE TABLE booking (
    bookingId INT AUTO_INCREMENT PRIMARY KEY,
    fromDate DATE,
    toDate DATE,
    aadharNumber VARCHAR(50),
    numOfRooms INT,
    roomNumbers TEXT,
    roomPrice INT NOT NULL DEFAULT 1000,
    transactionId INT DEFAULT 0,
    bookedOn DATE
);

create database payment;
use payment;
CREATE TABLE transaction (
    transactionId INT AUTO_INCREMENT PRIMARY KEY,
    paymentMode VARCHAR(4),
    bookingId INT NOT NULL,
    upiId VARCHAR(50) NULL,
    cardNumber VARCHAR(16) NULL
);
