-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1:8889
-- Generation Time: Jun 12, 2018 at 03:51 AM
-- Server version: 10.1.9-MariaDB
-- PHP Version: 5.5.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `eits`
--

-- --------------------------------------------------------

--
-- Table structure for table `courses`
--

CREATE TABLE `courses` (
  `ID` int(11) NOT NULL,
  `Name` varchar(255) NOT NULL,
  `IndustryID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `courses`
--

INSERT INTO `courses` (`ID`, `Name`, `IndustryID`) VALUES
(1, 'Certificate III in Applied Fashion Design And Technology', 1),
(2, 'Diploma of Fashion Design  and Merchandising', 1),
(3, 'Certificate ll in Applied  Fashion Design and Technology', 1),
(4, 'Certificate l in Engineering', 2),
(5, 'Certificate lV in Engineering (CNC Programming)', 2),
(6, 'Certificate lll in Engineering', 2),
(7, 'Certificate lll in Logistics', 3),
(8, 'Certificate ll in Warehousing Operations', 3),
(9, 'Diploma of logistics', 3);

-- --------------------------------------------------------

--
-- Table structure for table `industry`
--

CREATE TABLE `industry` (
  `ID` int(11) NOT NULL,
  `Name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `industry`
--

INSERT INTO `industry` (`ID`, `Name`) VALUES
(1, 'Fashion Design'),
(2, 'Engineering'),
(3, 'Logistics and warehousing');

-- --------------------------------------------------------

--
-- Table structure for table `units`
--

CREATE TABLE `units` (
  `ID` int(11) NOT NULL,
  `Code` varchar(255) NOT NULL,
  `Description` mediumtext NOT NULL,
  `CourseID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `units`
--

INSERT INTO `units` (`ID`, `Code`, `Description`, `CourseID`) VALUES
(1, 'MSTCL3010', 'Sew woven and stretch knit garments', 1),
(2, 'MSTCL3007', 'Embellish garment by hand or machine', 1),
(3, 'MSTCL2007', 'Lay up mark and cut uncomplicated fabric and lays', 1),
(4, 'MSTGN2011', 'Identify fibres, fabrics and textiles used in the TCF industry ', 1),
(5, 'MSTFD2005', 'Identify design process for fashion designs', 1),
(6, 'MSMENV272', 'Participate in environmentally sustainable work practices', 1),
(7, 'MSTFD3004', 'Operate computing technology in a TCF work place', 1),
(8, 'MSTFD2001', 'Design and produce a simple garment', 1),
(9, 'MSTLCL3009', 'Devolop patterns from a block using basic pattern making principles', 1),
(10, 'MSS402051', 'Prepare and produce a whole garment from specifications', 1),
(11, 'MSTGN2003', 'Oraganise and plan own work to achieve planned outcomes', 1),
(12, 'BSBDES202', 'Evaluate the nature of design in a specific industry context', 1),
(13, 'MST50116', 'Explore the use of color ', 2),
(14, 'MSTFD4006', 'Devolop and present design concepts within specific guidelines', 2),
(15, 'MSTFD4017', 'Source materials and resources for production of fashion designs', 2),
(16, 'MSTGN2011', 'Identify design process for fashion designs', 2),
(17, 'MSMENV272', 'Draw a trade drawing for fashion design', 2),
(18, 'MSTLC3009', 'Conduct quality assurance for patterns and garments', 2),
(19, 'MSTCL2010', 'Modify patterns to create basic styles', 2),
(20, 'MSTTFD5020', 'Assess impact of current fashion industry innovations and practices', 2),
(21, 'MSTFD2006', 'Use a sewing machine for fashion design', 2),
(22, 'MSTFD5017', 'Aplliy design studio process to meet client brief', 2),
(23, 'MSTFD5011', 'Produc efashion illustrations to assist product visualisation', 2),
(24, 'MSTCL3001', 'Identify fabric performances and handling requirements', 2),
(25, 'MSTCL2007', 'Lay up,mark and cut uncomplicated fabrics and lays', 3),
(26, 'MSTCL3007', 'Embellish garment by hand or machine', 3),
(27, 'MSTFD2005', 'Identify fabrics and textiles in TCF industry', 3),
(28, 'MSTGN2009', 'Operate computing technology in a TCF workplace', 3),
(29, 'MSTCL1001', 'Produce a simple garment', 3),
(30, 'MSTLC2011', 'Draw and interpret a basic design', 3),
(31, 'MSTGN2003', 'Work in the TCF industry', 3),
(32, 'MSTFD2006', 'Use a sewing machine for fashion design', 3),
(33, 'MSMWHS200', 'Work safely', 3),
(34, 'MSMSUP106', 'Work in a team', 3),
(35, 'MEM12001B', 'Use comparision and basic measuring devices', 4),
(36, 'MEM16007A', 'Perform operational maintenance of machines/equipment', 4),
(37, 'MEM16008A', 'Interact with computing technology', 4),
(38, 'MEM05013C', 'Perform manual production welding', 4),
(39, 'MEM11011B', 'Undertake manual handling', 4),
(40, 'MEM05012C', 'Perform routine manual metal arc welding', 4),
(41, 'MEM13014A', 'Apply principles of occupational health and safety in the work environment', 4),
(42, 'MEM14005A', 'Plan a complete activity', 4),
(43, 'MEM18002B', 'Use power tools and hand held operations', 4),
(44, 'MEMO5004C', 'Perform routine oxy acetylene welding', 4),
(45, 'MEMO5007C', 'Perform manual heating and thermal cutting', 4),
(46, 'MEM18001C', 'Use hand tools', 4),
(47, 'MEM18055B', 'Dismantle,replace and assemble engineering components', 5),
(48, 'MEM16007A', 'Work with others in a manufacturing,engineering or related environments', 5),
(49, 'MEMO7007C', 'Perform milling operations', 5),
(50, 'MEM18003C', 'Use tools for precision work', 5),
(51, 'MEMO9023A', 'Create 3D code files using computer aided manufacturing systems', 5),
(52, 'MEMO7006C', 'Perform lathe operations', 5),
(53, 'MEMO7008D', 'Perform grinding operations', 5),
(54, 'MEM18013B', 'Perform gland packing', 5),
(55, 'MEMO7018C', 'Write basic NC/CNC programs', 5),
(56, 'MEM16006A', 'Organise and communicate information', 5),
(57, 'MEM18055B', 'Dismantle,replace and assemble engineering components', 6),
(58, 'MEMO9010C', 'Create 3D models', 6),
(59, 'MEMO5046B', 'Perform welds to code standards using manual metal arc welding process', 6),
(60, 'MEMO5053A', 'Set and edit computer controlled thermal cutting machines', 6),
(61, 'MEMO9003B', 'Prepare basic engineering drawing', 6),
(62, 'MEMO9004B', 'Perform electrical/electronic detail drafting', 6),
(63, 'MEM12025A', 'Use graphical techniques and perform simple statistical computations', 6),
(64, 'MEM18003C', 'Use tools for precision work', 6),
(65, 'MEMO5047B', 'Perform geometric devolopment', 6),
(66, 'MEMO9023A', 'Create 3D code files using computer aided manufacturing system', 6),
(67, 'MEMO5009C', 'Perform automated thermal  cutting', 6),
(68, 'MEMO9011B', 'Apply basic engineering design concepts', 6),
(69, 'MEMO505B', 'Perform routine gas metal arc welding', 6),
(70, 'TLIU3011', 'Implement and monitor environmentally sustainable work practices', 7),
(71, 'BSBCUS301', 'Deliver and monitor a service to customers', 7),
(72, 'TLIF3063', 'Administer the implementation of fqatigue management strategies', 7),
(73, 'TLIA3016', 'Use inventory systems to organise stock control', 7),
(74, 'TLIE3002', 'Estimate mass,area and quantify dimensions', 7),
(75, 'TLIL1001', 'Complete workplace orientation/induction procedures', 7),
(76, 'TLIA3017', 'Organise despatch operations', 7),
(77, 'TLIJ3002', 'Apply quality systems', 7),
(78, 'TLIG3002', 'Lead a work team or group', 7),
(79, 'TLIF0001', 'Apply chain of responsibility,legislation,regulations and workplace procedures', 7),
(80, 'TLIE3004', 'Prepare work place documents', 7),
(81, 'TLIA2021', 'Despatch stock', 8),
(82, 'TLID2003', 'Participate in stocktakes', 8),
(83, 'TLIA2020', 'Replenish stock', 8),
(84, 'TLIF1001', 'Follow work health and safety procedures', 8),
(85, 'TLIA2001', 'License to operate a forklift', 8),
(86, 'TLIL1001', 'Complete workplace orientation/induction procedures', 8),
(87, 'TLIO2021', 'Follow security procedures when working with goods and cargo', 8),
(88, 'TLIF2006', 'Apply accident-emergency procedures', 8),
(89, 'TLIK2010', 'Use infotechnology devices in the workplace', 8),
(90, 'TLIJ2001', 'Apply quality procedures', 8),
(91, 'TLIF0001', 'Apply chain of responsibility legislation,regulations and workplace procedures', 8),
(92, 'TLID2010', 'Operate a forklift', 8),
(93, 'TLIR5014', 'Manage suppliers', 9),
(94, 'TLIJ5007', 'Conduct internal quality audits', 9),
(95, 'TLIL5055', 'Manage a supply chain', 9),
(96, 'TLIA5035', 'Manage International freight transfer', 9),
(97, 'TLIF0002', 'Administer chain of responsibility policies and procedures', 9),
(98, 'BSBMGT502', 'Manage budgets and financial plans', 9),
(99, 'TLIR5005', 'Manage a contract', 9),
(100, 'TLIX4028', 'Apply knowledge of logistics', 9),
(101, 'TLIL5057', 'Manage and monitor technical data and information systems', 9),
(102, 'TLIL5020', 'Develop and maintain operational procedures for transport and logistics enterprise', 9),
(103, 'BSBMGT517', 'Manage operational plan', 9);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `ID` int(11) NOT NULL,
  `Username` varchar(255) NOT NULL,
  `Password` varchar(255) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `CourseID` int(11) DEFAULT NULL,
  `Time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `Access` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`ID`, `Username`, `Password`, `Email`, `CourseID`, `Time`, `Access`) VALUES
(1, 'admin', 'admin', 'admin@example.com', 1, '2018-06-11 23:00:45', 0),
(2, 'Nathan', 'nathan', 'nathan@example.com', NULL, '2018-06-11 23:01:39', 2),
(3, 'Liana', 'liana', 'liana@example.com', NULL, '2018-06-11 23:01:55', 2),
(4, 'Kaitlyn', 'kaitlyn', 'kaitlyn@example.com', NULL, '2018-06-11 23:02:14', 2),
(5, 'Rani', 'rani', 'rani@example.com', NULL, '2018-06-11 23:02:43', 2),
(6, 'staff', 'staff', 'staff@example.com', NULL, '2018-06-11 23:03:14', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `courses`
--
ALTER TABLE `courses`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `industry`
--
ALTER TABLE `industry`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `units`
--
ALTER TABLE `units`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `courses`
--
ALTER TABLE `courses`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `industry`
--
ALTER TABLE `industry`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `units`
--
ALTER TABLE `units`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=104;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
