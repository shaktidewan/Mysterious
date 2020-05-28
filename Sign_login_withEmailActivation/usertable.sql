-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 28, 2020 at 06:23 AM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 7.3.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `email_validation`
--

-- --------------------------------------------------------

--
-- Table structure for table `usertable`
--

CREATE TABLE `usertable` (
  `id` int(255) NOT NULL,
  `fname` varchar(255) NOT NULL,
  `lname` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `pword` varchar(255) NOT NULL,
  `hash` varchar(255) NOT NULL,
  `active` int(1) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `usertable`
--

INSERT INTO `usertable` (`id`, `fname`, `lname`, `email`, `pword`, `hash`, `active`) VALUES
(15, 'shakti', 'dewan', 'shaktiyakhha@gmail.com', 'b21fcd04b036226e8a75037438c41592', '4183f5a13849ce6e740552ba49fa6f35', 1),
(16, 'shakti', 'dewan', 'shaktiyakhha@gmail.com', 'b21fcd04b036226e8a75037438c41592', 'd740d8881d2f0ec7c8821ff4c33dec9e', 1),
(17, 'shakti', 'dewan', 'shaktiyakhha@gmail.com', '25f9e794323b453885f5181f1b624d0b', '62f0df4064fcc74f5fce7e3c0c212397', 0),
(18, 'shakti', 'dewan', 'shaktiyakhha@gmail.com', '25f9e794323b453885f5181f1b624d0b', '74a597245ce6939c89ffd3e8dfd7da5d', 1),
(19, 'shakti', 'dewan', 'shaktiyakhha@gmail.com', 'c329cb74d54b0404d60c4a24ccfb0f26', '754a3208263349843da23539547df3cd', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `usertable`
--
ALTER TABLE `usertable`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `usertable`
--
ALTER TABLE `usertable`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
