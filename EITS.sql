-- phpMyAdmin SQL Dump
-- version 4.8.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 14, 2018 at 05:21 AM
-- Server version: 10.1.32-MariaDB
-- PHP Version: 7.2.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
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
(3, 'Certificate II in Applied  Fashion Design and Technology', 1),
(4, 'Certificate I in Engineering', 2),
(5, 'Certificate IV in Engineering (CNC Programming)', 2),
(6, 'Certificate III in Engineering', 2),
(7, 'Certificate III in Logistics', 3),
(8, 'Certificate II in Warehousing Operations', 3),
(9, 'Diploma of Logistics', 3),
(10, 'Diploma of Software Development', 4),
(11, 'Cert III in Information Digital Media and Technology', 4),
(12, 'Diploma of Information Technology Networking', 4),
(13, 'Certificate IV in Accounting', 5),
(14, 'Diploma of Accounting', 5),
(15, 'Advanced Diploma of Accounting', 5),
(16, 'Certificate II in Printing and Graphic Arts (General)', 6),
(17, 'Diploma of Graphic Design', 6),
(18, 'Certificate III in Design Fundamentals', 6),
(19, 'Diploma of Building Design', 7),
(21, 'Certificate IV in Civil Construction Supervision', 7),
(22, 'Certificate I in Construction', 7),
(23, 'Certificate IV in Environmental Management and Sustainability', 8),
(24, 'Diploma of Conservation Land Management', 8),
(25, 'Diploma of Landscape Design', 8),
(26, 'Certificate II in Health Support Services', 9),
(27, 'Certificate IV in Fitness', 9),
(28, 'Certificate III in Health Servies Assistance', 9),
(29, 'Certificate III in Make-Up', 10),
(30, 'Certificate III in Hairdressing', 10),
(31, 'Diploma of Beauty Therapy', 10);

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
(3, 'Logistics and Warehousing'),
(4, 'Information Communication Technology'),
(5, 'Accounting'),
(6, 'Graphic Design'),
(7, 'Construction'),
(8, 'Agricultural & Environmental Studies'),
(9, 'Health & Fitness'),
(10, 'Hairdressing & Beauty');

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
(1, 'MSTCL3010', 'Sew woven and stretch knit garments.', 1),
(2, 'MSTCL3007', 'Embellish garment by hand or machine.', 1),
(3, 'MSTCL2007', 'Lay up mark and cut uncomplicated fabric and lays.', 1),
(4, 'MSTGN2011', 'Identify fibres, fabrics and textiles used in the TCF industry.', 1),
(5, 'MSTFD2005', 'Identify design process for fashion designs.', 1),
(6, 'MSMENV272', 'Participate in environmentally sustainable work practices.', 1),
(7, 'MSTFD3004', 'Operate computing technology in a TCF work place.', 1),
(8, 'MSTFD2001', 'Design and produce a simple garment.', 1),
(9, 'MSTLCL3009', 'Devolop patterns from a block using basic pattern making principles.', 1),
(10, 'MSS402051', 'Prepare and produce a whole garment from specifications.', 1),
(11, 'MSTGN2003', 'Oraganise and plan own work to achieve planned outcomes.', 1),
(12, 'BSBDES202', 'Evaluate the nature of design in a specific industry context.', 1),
(13, 'MST50116', 'Explore the use of color.', 2),
(14, 'MSTFD4006', 'Devolop and present design concepts within specific guidelines.', 2),
(15, 'MSTFD4017', 'Source materials and resources for production of fashion designs.', 2),
(16, 'MSTGN2011', 'Identify design process for fashion designs.', 2),
(17, 'MSMENV272', 'Draw a trade drawing for fashion design.', 2),
(18, 'MSTLC3009', 'Conduct quality assurance for patterns and garments.', 2),
(19, 'MSTCL2010', 'Modify patterns to create basic styles.', 2),
(20, 'MSTTFD5020', 'Assess impact of current fashion industry innovations and practices.', 2),
(21, 'MSTFD2006', 'Use a sewing machine for fashion design.', 2),
(22, 'MSTFD5017', 'Apply design studio process to meet client brief.', 2),
(23, 'MSTFD5011', 'Produc efashion illustrations to assist product visualisation.', 2),
(24, 'MSTCL3001', 'Identify fabric performances and handling requirements.', 2),
(25, 'MSTCL2007', 'Lay up,mark and cut uncomplicated fabrics and lays.', 3),
(26, 'MSTCL3007', 'Embellish garment by hand or machine.', 3),
(27, 'MSTFD2005', 'Identify fabrics and textiles in TCF industry.', 3),
(28, 'MSTGN2009', 'Operate computing technology in a TCF workplace.', 3),
(29, 'MSTCL1001', 'Produce a simple garment.', 3),
(30, 'MSTLC2011', 'Draw and interpret a basic design.', 3),
(31, 'MSTGN2003', 'Work in the TCF industry.', 3),
(32, 'MSTFD2006', 'Use a sewing machine for fashion design.', 3),
(33, 'MSMWHS200', 'Work safely.', 3),
(34, 'MSMSUP106', 'Work in a team.', 3),
(35, 'MEM12001B', 'Use comparision and basic measuring devices.', 4),
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
(103, 'BSBMGT517', 'Manage operational plan', 9),
(104, 'ICT001', 'Contribute to copyright, ethics and privacy in an ICT environment', 10),
(105, 'ICT002', 'Apply intermediate programming skills in another language', 10),
(106, 'ICT003', 'Apply advanced object-oriented language skills', 10),
(107, 'ICT004', 'Manage a project using software management tools', 10),
(108, 'ICT005', 'Debug and monitor applications', 10),
(109, 'ICT006', 'Deploy an application design against specifications', 10),
(110, 'ICT007', 'Validate an application design against specifications', 10),
(111, 'ICT008', 'Apply advanced programming skills in another language', 10),
(112, 'ICT009', 'Apply testing techniques for software development', 10),
(113, 'ICT010', 'Participate effectively in WHS communication and consultation processes', 11),
(114, 'ICT011', 'Implement and monitor environmentally sustainable work practices', 11),
(115, 'ICT012', 'Work and communicate effectively in an ICT environment', 11),
(116, 'ICT013', 'Create user documentation', 11),
(117, 'ICT014', 'Install and optimise operating system software', 11),
(118, 'ICT015', 'Run standard diagnostic tests', 11),
(119, 'ACC001', 'Provide financial and business performance information', 12),
(120, 'ACC002', 'Prepare tax documentation for individuals', 12),
(121, 'ACC003', 'Manage budgets and forecasts', 12),
(122, 'ACC004', 'Prepare financial reports for corporate entities', 12),
(123, 'ACC005', 'Implement and maintain internal control procedures', 12),
(124, 'ACC006', 'Provide management accounting information', 12),
(125, 'ACC007', 'Apply priciples of professional practice to work in the financial services industry', 13),
(126, 'ACC008', 'Establish and maintain a payroll system', 13),
(127, 'ACC009', 'Carry out business activity and installment activity statement tasks', 13),
(128, 'ACC010', 'Setup and operate a comuterized accounting system', 13),
(129, 'ACC011', 'Prepare financial statements for non-reporting entities', 13),
(130, 'ACC012', 'Prepare operational budgets', 13),
(131, 'ACC013', 'Administer subsidiary accounts and ledgers', 13),
(132, 'ACC014', 'Process financial transactions and extract interim reports', 13),
(133, 'ACC015', 'Design and produce business documents', 13),
(134, 'ACC016', 'Prepare financial reports', 13),
(135, 'ICPPRP397', 'Transfer digital files', 14),
(136, 'BSBSUS201', 'Participate in environmentally sustainable work practices', 14),
(137, 'ICPSUP262', 'Communicate in the workplace', 14),
(138, 'ICPPRP225', 'Produce graphics using a graphics application', 14),
(139, 'ICPPRP252', 'Output images', 14),
(140, 'ICPSUP216', 'Inspect quality against required standards', 14),
(141, 'ICPPRP284', 'Produce PDF files for online or screen display', 14),
(142, 'ICPPRP283', 'Prepare artwork for screen printing', 14),
(143, 'ICPPRP321', 'Produce a typographic image', 14),
(144, 'ICPSUP260', 'Maintain a safe work environment', 14),
(145, 'ICPPRP221', 'Select and apply type', 14),
(146, 'ICPPRP224', 'Produce pages using a page layout application', 14),
(147, 'ICPPRP211', 'Develop a basic design concept', 14),
(148, 'ICPPRP286', 'Scan images for reproduction', 14),
(149, 'ICPPRP322', 'Digitise images for reproduction', 14),
(150, 'BSBDES403', 'Develop and extend design skills and practice', 15),
(151, 'CUAACD501', 'Define drawing and other visual representation tools', 15),
(152, 'CUAGRD501', 'Research visual communication history and theory', 15),
(153, 'CUAGRD502', 'Produce graphic designs for 2D and 3D applications', 15),
(154, 'CUAGRD503', 'Produce typographic design solutions', 15),
(155, 'CUAGRD504', 'Create and manipulate graphics', 15),
(156, 'CUARGD505', 'Design and manipulate complex layouts', 15),
(157, 'CUAGRD506', 'Develop graphic design practice to meet industry needs', 15),
(158, 'CUAPPR503', 'Present a body of own creative work', 15),
(159, 'ICTICT418', 'Contribute to copyright, ethics and privacy in an ICT environment', 16),
(160, 'ICTICT511', 'Match ICT needs with the strategic direction of the enterprise', 16),
(161, 'ICTNWK529', 'Install and manage complex ICT networks', 16),
(162, 'ICTSUS501', 'Implement server virtualisation for a sustainable ICT system', 16),
(163, 'ICTTEN611', 'Produce an ICT network architecture design', 16),
(164, 'BD016', 'Apply OHS requirements, policies and procedures in the construction industry', 17),
(165, 'BD017', 'Research construction materials and methods for small-scale residential building design projects', 17),
(166, 'BD018', 'Research compliance requirements for small-scale residential building design projects', 17),
(167, 'BD019', 'Recommend sustainability solutions for small-scale building design projects', 17),
(168, 'BD020', 'Develop concepts for small-scale building design projects and finalise solutions with clients', 17),
(169, 'BD021', 'Produce compliant client-approved designs for small-scale building design projects', 17),
(170, 'BD022', 'Produce compliant client-approved working drawings for small-scale residential buildings', 17),
(171, 'FNSINC602', 'Interpret and use financial statistics and tools', 18),
(172, 'FNSINC601', 'Apply economic principles to work in the financial services industry', 18),
(173, 'FNSACC604', 'Monitor corporate governance activities', 18),
(174, 'BSBDES201', 'Follow a design process', 20),
(175, 'BSBDES301', 'Explore the use of colour', 20),
(176, 'BSBDES302', 'Explore and apply the creative design process to 2D forms', 20),
(177, 'BSBDES303', 'Explore and apply the creative design process to 3D forms', 20),
(178, 'BSBDES304', 'Source and apply design industry knowledge', 20),
(179, 'BSBWHS201', 'Contribute to health and safety of self and others', 20),
(180, 'CUAACD301', 'Produce drawings to communicate ideas', 20),
(181, 'BSBMGT401', 'Show leadership in the workplace', 21),
(182, 'BSBMGT402', 'Implement operational plan', 21),
(183, 'BSBWHS401', 'Implement and monitor WHS policies, procedures and programs to meet legislative requirements', 21),
(184, 'RIICWM401D', 'Supervise civil works', 21),
(185, 'RIIRIS401D', 'Apply site risk management system', 21),
(186, 'CPCCCM1012A', 'Work effectively and sustainably in the construction industry', 22),
(187, 'CPCCCM1013A', 'Plan and organise work', 22),
(188, 'CPCCCM1014A', 'Conduct workplace communication', 22),
(189, 'CPCCCM2001A', 'Read and interpret plans and specifications', 22),
(190, 'CPCCCM2005A', 'Use construction tools and equipment', 22),
(191, 'CPCCWHS1001', 'Prepare to work safely in the construction industry', 22),
(192, 'CPCCOHS2001A', 'Apply OHS requirements, policies and procedures in the construction industry', 22),
(193, 'CPCCVE1011A', 'Undertake a basic construction project', 22),
(194, 'BSBSUS406', 'Identify and apply sustainability rating tools', 23),
(195, 'BSBSUS404', 'Assess, implement, monitor and report on waste management', 23),
(196, 'BSBSUS402', 'Implement an environmental management plan', 23),
(197, 'BSBRSK401', 'Identify risk and apply risk management processes', 23),
(198, 'BSBWHS402', 'Assist with compliance with WHS laws', 23),
(199, 'BSBSUS403', 'Measure, monitor and reduce carbon emissions', 23),
(200, 'BSBSUS401', 'Implement and monitor environmentally sustainable work practices', 23),
(201, 'AHCILM504', 'Develop strategies for Indigenous land or sea management', 24),
(202, 'AHCILM503', 'Manage restoration of cultural places', 24),
(203, 'AHCFAU501', 'Manage fauna populations', 24),
(204, 'AHCNAR506', 'Develop and implement sustainable land use strategies', 24),
(205, 'AHCNAR502', 'Conduct biological surveys', 24),
(206, 'AHCPMG410', 'Implement the pest monitoring and evaluation plan', 24),
(207, 'AHCPMG413', 'Define the pest problem', 24),
(208, 'AHCFIR501', 'Manage wildfire hazard reduction programs', 24),
(209, 'AHCWHS401', 'Maintain work health and safety processes', 24),
(210, 'AHCLPW501', 'Develop a management plan for a designated area', 24),
(211, 'AHCSAW502', 'Plan erosion and sediment control measures', 24),
(212, 'AHCNAR503', 'Design a natural area restoration project', 24),
(213, 'AHCSAW503', 'Plan conservation earthworks', 24),
(214, 'AHCNAR504', 'Manage natural area restoration programs', 24),
(215, 'AHCPCM502', 'Collect and classify plants', 24),
(216, 'AHCILM501', 'Conduct field research into naturla and cultural resources', 24),
(217, 'CUAACD302', 'Produce computer-aided drawings', 25),
(218, 'AHCARB502', 'Identify, select and specifty trees', 25),
(219, 'AHCPCM503', 'Specify plants for landscapes', 25),
(220, 'AHCPCM501', 'Diagnose plant health problems', 25),
(221, 'AHCLSC501', 'Survey and establish site levels', 25),
(222, 'AHCPCM504', 'Design specialised landscape', 25),
(223, 'AHCWRK503', 'Prepare reports', 25),
(224, 'AHCBUS504', 'Prepare estimates, quotes and tenders', 25),
(225, 'AHCDES503', 'Assess landscape sites', 25),
(226, 'AHCDES504', 'Design for construction of landscape features', 25),
(227, 'AHCDES501', 'Design sustainable landscapes', 25),
(228, 'AHCDES502', 'Prepare a landscape design', 25),
(229, 'HLTWHS005', 'Conduct manual task safely', 26),
(230, 'CHCCCS020', 'Respone effectively to behaviours of concern', 26),
(231, 'HLTHSS005', 'Undertake routine stock maintenance', 26),
(232, 'CHCCCS012', 'Prepare and maintain beds', 26),
(233, 'CHCDIV001', 'Work with diverse people', 26),
(234, 'HLTWHS001', 'Participate in workplace health and safety', 26),
(235, 'BSBWOR203', 'Work effectively with others', 26),
(236, 'HLTFSE001', 'Follow basic food safety practices', 26),
(237, 'CHCCOM005', 'Communicate and work in health or community services', 26),
(238, 'CHCCCS010', 'Maintain a high standard of service', 26),
(239, 'CHCCCS026', 'Transport individuals', 26),
(240, 'HLTINF001', 'Comply with infection prevention and control policies and procedures', 26),
(241, 'SISSSTC301A', 'Instruct strength and conditioning techniques', 27),
(242, 'SISFFIT018', 'Promote functional movement capacity', 27),
(243, 'SISFFIT025', 'Recognise the dangers of providing nutrition advice to clients', 27),
(244, 'BSBSMB401', 'Establish legal and risk management requirements of small business', 27),
(245, 'BSBSUS201', 'Participate in environmentally sustainable work practices', 27),
(246, 'SISFFIT020', 'Instruct exercise programs for body composition goals', 27),
(247, 'BSBSMB403', 'Market the small business', 27),
(248, 'SISFFIT021', 'Instruct personal training programs', 27),
(249, 'SISFFIT015', 'Collaborate with medical and allied health professionals in a fitness context', 27),
(250, 'SISSSTC402A', 'Develop strength and conditioning programs', 27),
(251, 'SISFFIT026', 'Support healthy eating through the Eat for Health Program', 27),
(252, 'SISFFIT019', 'Incorporate exercise science principles into fitness programming', 27),
(253, 'BSBSMB404', 'Undertake small business planning', 27),
(254, 'SISXRES001', 'Conduct sustainable work practices in open spaces', 27),
(255, 'SISFFIT017', 'Instruct long-term exercise programs', 27),
(256, 'BSBSMB405', 'Monitor and manage small business operations', 27),
(257, 'HLTAIN001', 'Assist with nursing care in an acute care environment', 28),
(258, 'HLTAIN002', 'Provide non-client contact support in an acute care environment', 28),
(259, 'BSBWOR301', 'Organise personal work priorities and development', 28),
(260, 'CHCCCS020', 'Respond efectively to behaviours of concern', 28),
(261, 'BSBMED301', 'Interpret and apply medical terminology appropriately', 28),
(262, 'CHCCCS002', 'Assist with movement', 28),
(263, 'CHCDIV001', 'Work with diverse people', 28),
(264, 'HLTWHS001', 'Participate in workplace health and safety', 28),
(265, 'CHCMHS001', 'Work with people with mental health issues', 28),
(266, 'HLTAID003', 'Provide first aid', 28),
(267, 'CHCCOM005', 'Communicate and work in health or community services', 28),
(268, 'HLTAAP001', 'Recognise healthy body systems', 28),
(269, 'CHCCCS026', 'Transport individuals', 28),
(270, 'CHCAGE005', 'Provide support to people living with dementia', 28),
(271, 'HLTINF001', 'Comply with infection prevention and control policies and procedures', 28),
(272, 'SHBBRES001', 'Research and apply beauty industry information', 29),
(273, 'SHBBFAS001', 'Provide las and brow services', 29),
(274, 'SHBBMUP002', 'Design and apply make-up', 29),
(275, 'SHBBMUP007', 'Work collaboratively on make-up productions', 29),
(276, 'SHBBMUP003', 'Design and apply make-up for photography', 29),
(277, 'SHBBMUP004', 'Design and apply remedial camouflage make-up', 29),
(278, 'BSBSMB403', 'Market the small business', 29),
(279, 'SHBXCCS001', 'Conduct salon financial transactions', 29),
(280, 'SHBBMUP006', 'Design and apply creative make-up', 29),
(281, 'SHBXIND001', 'Comply with organisational requirements within a personal services environment', 29),
(282, 'SHBXCCS002', 'Provide salon services to clients', 29),
(283, 'SHBXWHS001', 'Apply safe hygiene, health and work practices', 29),
(284, 'SHBHDES004', 'Create classic long hair up-styles', 29),
(285, 'SHBBMUP005', 'Apply airbrushes make-up', 29),
(286, 'SHBBCCS001', 'Advise on beauty products and services', 29),
(287, 'SHBHTRI001', 'Identify and treat hair and scalp conditions', 30),
(288, 'SHBHIND001', 'Maintain and organise tools, equipment and work areas', 30),
(289, 'SHBHREF002', 'Straighten and relax hair with chemical treatments', 30),
(290, 'SHBHBAS001', 'Provide shampoo and basin services', 30),
(291, 'BSBSUS201', 'Participate in environmentally sustainable work practices', 30),
(292, 'SHBHDES003', 'Create finished hair designs', 30),
(293, 'SHBHCUT003', 'Create graduated haircut structures', 30),
(294, 'SHBHCUT002', 'Create one length or solid haircut structures', 30),
(295, 'SHBHDES002', 'Braid hair', 30),
(296, 'SHBHCLS005', 'Provide on scalp full head and retouch bleach treatments', 30),
(297, 'SHBHCLS004', 'Neutralise unwanted colours and tones', 30),
(298, 'SHBHCUT005', 'Cut hair using over-comb techniques', 30),
(299, 'SHBXIND001', 'Comply with organisational requirements within a personal services environment ', 30),
(300, 'SHBXCCS001', 'Conduct salon financial transactions', 30),
(301, 'SHBHCUT004', 'Create layered haircut structures', 30),
(302, 'SHBHCUT001', 'Design haircute structures', 30),
(303, 'SHBHIND003', 'Develop and expand a client base', 30),
(304, 'SHBBRES001', 'Research and apply beauty industry information', 31),
(305, 'SHBBFAS002', 'Provide facial treatments and skin care recommendations', 31),
(306, 'SHBBCCS002', 'Prepare personalised aromatic plant oil blends for beauty treatments', 31),
(307, 'SHBBSPA002', 'Provide spa therapies', 31),
(308, 'SHBBMUP004', 'Design and apply remedial camouflage make-up', 31),
(309, 'SHBXCCS002', 'Provide salon services to clients', 31),
(310, 'BSBSMB406', 'Manage small business finances', 31),
(311, 'BSBSMB404', 'Undertake small business planning', 31),
(312, 'SHBBFAS003', 'Provide specialised facial treatments', 31),
(313, 'SHBBCCS001', 'Advise on beauty products and services', 31),
(314, 'BSBSMB304', 'Determine resource requirements for the micro business', 31),
(315, 'SHBBSKS003', 'Design and provide cosmetic tattooing', 31),
(316, 'BD016', 'Apply OHS requirements, policies and procedures in the construction industry', 19),
(317, 'BD017', 'Research construction materials and methods for small-scale residential building design projects', 19),
(318, 'BD018', 'Research compliance requirements for small-scale residential building design projects', 19),
(319, 'BD019', 'Recommend sustainability solutions for small-scale building design projects', 19),
(320, 'BD020', 'Develop concepts for small-scale building design projects and finalise solutions with clients', 19),
(321, 'BD021', 'Produce compliant client-approved designs for small-scale building design projects', 19),
(322, 'BD022', 'Produce compliant client-approved working drawings for small-scale residential buildings', 19);

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
  `Access` int(11) NOT NULL,
  `LastLoggedIn` varchar(255) NOT NULL,
  `Active` int(11) NOT NULL,
  `IPAddress` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`ID`, `Username`, `Password`, `Email`, `CourseID`, `Access`, `LastLoggedIn`, `Active`, `IPAddress`) VALUES
(1, 'admin', 'admin', 'admin@example.com', 1, 0, 'Thu Jun 14 13:17:32 AEST 2018', 0, '172.17.120.232'),
(2, 'Nathan', 'nathan', 'nathan@example.com', NULL, 2, '', 0, ''),
(3, 'Liana', 'liana', 'liana@example.com', NULL, 2, '', 0, ''),
(4, 'Kaitlyn', 'kaitlyn', 'kaitlyn@example.com', 6, 2, 'Thu Jun 14 13:20:17 AEST 2018', 1, '172.17.120.232'),
(5, 'Rani', 'rani', 'rani@example.com', NULL, 2, '', 0, ''),
(6, 'staff', 'staff', 'staff@example.com', NULL, 1, 'Thu Jun 14 08:36:10 AEST 2018', 1, '172.17.120.232');

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
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT for table `industry`
--
ALTER TABLE `industry`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `units`
--
ALTER TABLE `units`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=323;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
