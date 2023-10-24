-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jun 09, 2023 at 06:39 PM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `Cash_Flow_Bank`
--

-- --------------------------------------------------------

--
-- Table structure for table `Accounts`
--

CREATE TABLE `Accounts` (
  `FirstName` varchar(40) NOT NULL,
  `LastName` varchar(40) NOT NULL,
  `PhoneNumber` int(10) NOT NULL,
  `Balance` int(11) NOT NULL,
  `Gender` varchar(10) NOT NULL,
  `Address` varchar(45) NOT NULL,
  `AccountType` varchar(45) NOT NULL,
  `PinNumber` int(6) NOT NULL,
  `AccountNumber` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `Accounts`
--

INSERT INTO `Accounts` (`FirstName`, `LastName`, `PhoneNumber`, `Balance`, `Gender`, `Address`, `AccountType`, `PinNumber`, `AccountNumber`) VALUES
('Mihiret', 'Tekalegn', 943121167, 12100, 'Female', 'Addis Ababa, Saris', 'Saving Account', 121212, '1256822761'),
('Tinsae', 'Getachew', 944211992, 18150, 'Female', 'Addis Ababa, Megenagna ', 'SAVING ACCOUNT', 123654, '2147483647'),
('Betelhem', 'Getachew', 938772887, 13680, 'Female', 'Addis Ababa, Bethel', 'SAVING ACCOUNT', 129078, '4539045637'),
('Yohannes', 'Alemayehu', 934252190, 20000, 'Male', 'A.A CMC', 'Saving Account', 213243, '1234567890'),
('Rahel', 'Abera', 961663412, 100, 'Female', 'Addis Ababa, Bulbula', 'SAVING ACCOUNT', 231323, '2147483647'),
('Bethel', 'Hadush', 993376719, 9900, 'Female', 'Addis Ababa, Bole', 'STUDENT\'S ACCOUNT', 321400, '9045342388'),
('Aklesiya', 'Tewodros', 982564421, 10000, 'Female', 'Addis Ababa, Kolfe', 'WOMAN\'S ACCOUNT', 329913, '4983427701'),
('Samrawit', 'Derara', 989674523, 10000, 'Female', 'Addis ababa, 6kilo', 'Saving Account', 342312, '1164821486'),
('hana', 'kebede', 956453423, 1000, 'Female', 'gulele', 'Saving Account', 342319, '2147483647'),
('Abel', 'Kassaw', 43219566, 23600, 'Male', 'A.A Megenagna', 'Saving Account', 343434, '0987654321'),
('beti', 'haile', 989786756, 100, 'Female', 'addis ababa', 'SAVING ACCOUNT', 345678, '560084158'),
('Betelhem', 'Haile', 989596357, 12000, 'Female', 'Addis Ababa, Bole', 'SAVING ACCOUNT', 546734, '4536278689'),
('Dawit', 'Belete', 923297865, 1000, 'Male', 'A.A Ras Desta', 'Saving Account', 563345, '8100584738'),
('Betelhem', 'Kirub', 966578211, 13000, 'Female', 'Addis Ababa, Gelan', 'SAVING ACCOUNT', 783324, '7823143389'),
('Selam', 'Nigatu', 9432980, 18700, 'Female', 'A.A Mexico', 'Saving Account', 894537, '1357908642'),
('Daniel', 'Getachew', 940402071, 17000, 'Male', 'Addis Ababa, Kolfe', 'SAVING ACCOUNT', 902219, '8934216788'),
('Amanuel', 'Tefera', 934887812, 18500, 'Male', 'Addis Ababa', 'Saving Account', 902311, '9876543210'),
('Michael ', 'Jemberu', 912128544, 19000, 'Male', 'A.A Bethel', 'Saving Account', 921176, '2468101214');

-- --------------------------------------------------------

--
-- Table structure for table `Employees`
--

CREATE TABLE `Employees` (
  `EmpId` int(11) NOT NULL,
  `FirstName` varchar(40) NOT NULL,
  `LastName` varchar(40) NOT NULL,
  `JobTitle` varchar(40) NOT NULL,
  `HireDate` date NOT NULL,
  `Salary` int(11) NOT NULL,
  `AccountNumber` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `Employees`
--

INSERT INTO `Employees` (`EmpId`, `FirstName`, `LastName`, `JobTitle`, `HireDate`, `Salary`, `AccountNumber`) VALUES
(1001, 'Yohannes', 'Alemayehu', 'Account Manager', '2017-01-01', 12000, '1234567890'),
(1002, 'Abel', 'Kassaw', 'Loan Officer', '2018-02-15', 6500, '0987654321'),
(1003, 'Michael', 'Jemberu', 'Financial Analyst', '2019-03-17', 9000, '2468101214'),
(1004, 'Selam', 'Nigatu', 'Accountant', '2020-04-30', 9000, '1357908642'),
(1005, 'Dawit', 'Belete', 'Credit Analyst', '2021-06-12', 12000, '8100584738'),
(1006, 'Amanuel', 'Tefera', 'Accountant', '2017-07-01', 8500, '9876543210'),
(1009, 'Tinsae', 'Getachew', 'Accountant', '2023-06-06', 9000, '2147483647'),
(1010, 'Rahel', 'Abera', 'Credit Aanalyst', '2023-06-07', 9000, '2147483647'),
(1011, 'beti', 'haile', 'accountant', '2023-06-08', 5000, '560084158');

-- --------------------------------------------------------

--
-- Table structure for table `Transactions`
--

CREATE TABLE `Transactions` (
  `TransactionID` int(11) NOT NULL,
  `AccountNumber` varchar(10) NOT NULL,
  `TransactionType` varchar(40) NOT NULL,
  `Amount` int(11) NOT NULL,
  `Date` date NOT NULL,
  `Description` varchar(45) NOT NULL,
  `CurrentBalance` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `Transactions`
--

INSERT INTO `Transactions` (`TransactionID`, `AccountNumber`, `TransactionType`, `Amount`, `Date`, `Description`, `CurrentBalance`) VALUES
(1, '2147483647', 'Deposit', 2000, '2023-06-05', 'Payment', 14000),
(2, '4539045637', 'Deposit', 4000, '2023-06-05', 'credit', 10000),
(3, '7612341200', 'Deposit', 4000, '2023-06-05', 'Initial Deposit', 4000),
(4, '7823143389', 'Withdraw', 4000, '2023-06-05', 'Deposit', 9000),
(6, '4536278689', 'Deposit', 5000, '2023-06-05', 'Payment', 16000),
(8, '4539045637', 'Money Transfer', 1000, '2023-06-06', 'credit', 14000),
(9, '2147483647', 'Deposit', 1000, '2023-06-06', 'Money Transfer', 13000),
(23, '2147483647', 'Wages', 3000, '2023-06-06', 'Payment', 12100),
(24, '2147483647', 'Wages', 3000, '2023-06-06', 'Payment', 21100),
(25, '1234567890', 'Money Transfer', 2000, '2023-06-07', 'gift', 20000),
(26, '0987654321', 'Deposit', 2000, '2023-06-07', 'Money Transfer', 4000),
(27, '1256822761', 'Money Transfer', 50, '2023-06-07', 'payment', 12000),
(28, '2147483647', 'Deposit', 50, '2023-06-07', 'Money Transfer', 18150),
(29, '1256822761', 'WithDraw', 100, '2023-06-07', 'Air Time', 11900),
(30, '4539045637', 'Money Transfer', 100, '2023-06-07', 'payment', 13680),
(31, '1256822761', 'Deposit', 100, '2023-06-07', 'Money Transfer', 12000),
(32, '987654321', 'Wages', 1000, '2023-06-07', 'Payment', 11500),
(34, '1256822761', 'Deposit', 100, '2023-06-07', 'Money Transfer', 12100),
(35, '987654321', 'Wages', 1000, '2023-06-07', 'Payment', 18000),
(36, '1234567890', 'Withdraw', 500, '2023-06-08', 'withdraw', 20000),
(37, '1357908642', 'Withdraw', 200, '2023-06-08', 'withdraw', 18700),
(38, '987654321', 'Wages', 1000, '2023-06-08', 'Payment', 24500),
(39, '0987654321', 'Deposit', 100, '2023-06-08', 'Deposit', 23600);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Accounts`
--
ALTER TABLE `Accounts`
  ADD PRIMARY KEY (`PinNumber`);

--
-- Indexes for table `Employees`
--
ALTER TABLE `Employees`
  ADD PRIMARY KEY (`EmpId`);

--
-- Indexes for table `Transactions`
--
ALTER TABLE `Transactions`
  ADD PRIMARY KEY (`TransactionID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Employees`
--
ALTER TABLE `Employees`
  MODIFY `EmpId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1012;

--
-- AUTO_INCREMENT for table `Transactions`
--
ALTER TABLE `Transactions`
  MODIFY `TransactionID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=40;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
