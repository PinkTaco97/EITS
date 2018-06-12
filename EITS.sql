-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Jun 12, 2018 at 11:34 AM
-- Server version: 5.6.38
-- PHP Version: 7.2.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `EITS`
--

-- --------------------------------------------------------

--
-- Table structure for table `Courses`
--

CREATE TABLE `Courses` (
  `ID` int(11) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `IndustryID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Industry`
--

CREATE TABLE `Industry` (
  `ID` int(11) NOT NULL,
  `Name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Units`
--

CREATE TABLE `Units` (
  `ID` int(11) NOT NULL,
  `Code` varchar(255) NOT NULL,
  `Description` mediumtext NOT NULL,
  `CourseID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Users`
--

CREATE TABLE `Users` (
  `ID` int(11) NOT NULL,
  `Username` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `CourseID` int(11) DEFAULT NULL,
  `Access` int(11) NOT NULL,
  `LastLoggedIn` varchar(255) NOT NULL,
  `Active` int(11) NOT NULL,
  `IPAddress` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Users`
--

INSERT INTO `Users` (`ID`, `Username`, `Password`, `Email`, `CourseID`, `Access`, `LastLoggedIn`, `Active`, `IPAddress`) VALUES
(1, 'admin', 'admin', 'admin@example.com', 1, 0, '', 0, ''),
(2, 'Nathan', 'nathan', 'nathan@example.com', NULL, 2, '', 0, ''),
(3, 'Liana', 'liana', 'liana@example.com', NULL, 2, '', 0, ''),
(4, 'Kaitlyn', 'kaitlyn', 'kaitlyn@example.com', NULL, 2, '', 0, ''),
(5, 'Rani', 'rani', 'rani@example.com', NULL, 2, '', 0, ''),
(6, 'staff', 'staff', 'staff@example.com', NULL, 1, '', 0, '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Courses`
--
ALTER TABLE `Courses`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `Industry`
--
ALTER TABLE `Industry`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `Units`
--
ALTER TABLE `Units`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `Users`
--
ALTER TABLE `Users`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Courses`
--
ALTER TABLE `Courses`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Industry`
--
ALTER TABLE `Industry`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Units`
--
ALTER TABLE `Units`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Users`
--
ALTER TABLE `Users`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
