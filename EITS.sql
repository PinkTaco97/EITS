-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: May 17, 2018 at 02:12 PM
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
  `Code` varchar(255) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `Level` varchar(255) NOT NULL,
  `IndustryID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Courses`
--

INSERT INTO `Courses` (`ID`, `Code`, `Name`, `Level`, `IndustryID`) VALUES
(1, 'ICT369', 'Diploma of Software Development', 'Diploma', 1),
(2, 'ICT583', 'Information Digital Media and Technology', 'Cert III', 1);

-- --------------------------------------------------------

--
-- Table structure for table `Industry`
--

CREATE TABLE `Industry` (
  `ID` int(11) NOT NULL,
  `Name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Industry`
--

INSERT INTO `Industry` (`ID`, `Name`) VALUES
(1, 'Information Communication Technology'),
(2, 'Accounting');

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

--
-- Dumping data for table `Units`
--

INSERT INTO `Units` (`ID`, `Code`, `Description`, `CourseID`) VALUES
(1, 'ICT001', 'Contribute to copyright, ethics and privacy in an ICT environment.', 1),
(2, 'ICT002', 'Apply intermediate programming skills in another language.', 1),
(4, 'ICT003', 'Apply advanced object oriented language skills.', 1),
(5, 'ICT004', 'Manage a project using software management tools.', 1),
(6, 'ICT005', 'Debug and monitor applications.', 1),
(7, 'ICT006', 'Deploy an application to a production environment.', 1),
(8, 'ICT007', 'Validate an application design against specifications.', 1),
(9, 'ICT008', 'Apply advanced programming skills in another language.', 1),
(10, 'ICT009', 'Apply testing techniques for software development.', 1),
(11, 'ICT010', 'Participate effectively in WHS communication and consultation processes. ', 2),
(12, 'ICT011', 'Implement and monitor environmentally sustainable work practices.', 2),
(13, 'ICT012', 'Work and communicate effectively in an ICT environment.', 2),
(14, 'ICT013', 'Create user documentation.', 2),
(15, 'ICT014', 'Install and optimize operating system software.', 2),
(16, 'ICT015', 'Run standard diagnostic tests.', 2);

-- --------------------------------------------------------

--
-- Table structure for table `Users`
--

CREATE TABLE `Users` (
  `ID` int(11) NOT NULL,
  `Username` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `CourseID` int(11) NOT NULL,
  `Time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `Industry`
--
ALTER TABLE `Industry`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `Units`
--
ALTER TABLE `Units`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `Users`
--
ALTER TABLE `Users`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;