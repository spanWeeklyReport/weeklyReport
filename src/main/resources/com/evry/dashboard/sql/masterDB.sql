-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.5.31 - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             9.3.0.4984
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for report
CREATE DATABASE IF NOT EXISTS `report` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `report`;


-- Dumping structure for table report.project_details
CREATE TABLE IF NOT EXISTS `project_details` (
  `OID` int(11) NOT NULL AUTO_INCREMENT,
  `PROJECT_NAME` varchar(45) DEFAULT NULL,
  `PROJECT_STATUS` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`OID`),
  UNIQUE KEY `proid_UNIQUE` (`OID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- Dumping data for table report.project_details: ~4 rows (approximately)
/*!40000 ALTER TABLE `project_details` DISABLE KEYS */;
INSERT IGNORE INTO `project_details` (`OID`, `PROJECT_NAME`, `PROJECT_STATUS`) VALUES
	(1, 'Alystra', 'Completed'),
	(2, 'Vodafone', 'Pending'),
	(3, 'Poston', 'Completed'),
	(4, 'Telenor', 'Running');
/*!40000 ALTER TABLE `project_details` ENABLE KEYS */;


-- Dumping structure for table report.risk_details
CREATE TABLE IF NOT EXISTS `risk_details` (
  `RISK_ID` int(11) NOT NULL AUTO_INCREMENT,
  `RISK_TYPE` enum('High','Medium','Low') DEFAULT NULL,
  `RISK_DESCRIPTION` varchar(255) DEFAULT NULL,
  `RISK_RESPONSIBLE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`RISK_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=148 DEFAULT CHARSET=utf8;

-- Dumping data for table report.risk_details: ~8 rows (approximately)
/*!40000 ALTER TABLE `risk_details` DISABLE KEYS */;
INSERT IGNORE INTO `risk_details` (`RISK_ID`, `RISK_TYPE`, `RISK_DESCRIPTION`, `RISK_RESPONSIBLE`) VALUES
	(140, 'High', 'risk description one', 'person one'),
	(141, 'Medium', 'risk description two', 'person two'),
	(142, 'Low', 'very less', 'AJ'),
	(143, 'Low', 'very less', 'AJ'),
	(144, 'Medium', 'less risky', 'Ab'),
	(145, 'Low', 'very less', 'AJ'),
	(146, 'Low', 'risk description three', 'person three'),
	(147, 'Low', 'low risk', 'xyz');
/*!40000 ALTER TABLE `risk_details` ENABLE KEYS */;


-- Dumping structure for table report.task_details
CREATE TABLE IF NOT EXISTS `task_details` (
  `TASK_ID` int(11) NOT NULL AUTO_INCREMENT,
  `U_ID` int(11) DEFAULT NULL,
  `PROJECT_ID` int(11) DEFAULT NULL,
  `WEEK_NO` int(11) DEFAULT NULL,
  `YEAR_NO` int(45) DEFAULT NULL,
  `PLANNED_TASK` varchar(45) DEFAULT NULL,
  `COMPLETED_TASK` varchar(45) DEFAULT NULL,
  `HOLD_TASK` varchar(45) DEFAULT NULL,
  `INPROGRESS_TASK` varchar(45) DEFAULT NULL,
  `SHARED_RESOURCES` varchar(745) DEFAULT NULL,
  `BILLED_RESOURCES` varchar(45) DEFAULT NULL,
  `PROJECT_INC_B` varchar(45) DEFAULT NULL,
  `PROJECT_DEC_B` varchar(45) DEFAULT NULL,
  `PROJECT_INC_SH` varchar(45) DEFAULT NULL,
  `PROJECT_DEC_SH` varchar(45) DEFAULT NULL,
  `PROJECT_UPDATES` varchar(255) DEFAULT NULL,
  `RESOURCE_LOADING_B` varchar(45) DEFAULT NULL,
  `RESOURCE_LOADING_SH` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`TASK_ID`),
  KEY `pid_idx` (`PROJECT_ID`),
  CONSTRAINT `pid` FOREIGN KEY (`PROJECT_ID`) REFERENCES `project_details` (`OID`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=87 DEFAULT CHARSET=latin1;

-- Dumping data for table report.task_details: ~6 rows (approximately)
/*!40000 ALTER TABLE `task_details` DISABLE KEYS */;
INSERT IGNORE INTO `task_details` (`TASK_ID`, `U_ID`, `PROJECT_ID`, `WEEK_NO`, `YEAR_NO`, `PLANNED_TASK`, `COMPLETED_TASK`, `HOLD_TASK`, `INPROGRESS_TASK`, `SHARED_RESOURCES`, `BILLED_RESOURCES`, `PROJECT_INC_B`, `PROJECT_DEC_B`, `PROJECT_INC_SH`, `PROJECT_DEC_SH`, `PROJECT_UPDATES`, `RESOURCE_LOADING_B`, `RESOURCE_LOADING_SH`) VALUES
	(1, NULL, 1, 12, 2016, '2', '3', '2', '3', '2', '3', '2', '3', '2', '3', 'this is the recent project update', '3', '2'),
	(33, NULL, 1, 18, 2016, '22', '23', '23', '28', '4', '3', '2', '3', '4', '3', '2', '3', '4'),
	(48, NULL, 1, 10, 2016, '2', '2', '2', '2', '2', '2', '2', '2', '2', '2', 'this is the update', '2', '2'),
	(64, NULL, 1, 19, 2016, '5', '5', '5', '5', '2', '2', '4', '5', '4', '3', '1) This is update one\r\n2) This is update two', '3', '3'),
	(85, NULL, 3, 20, 2016, '5', '5', '5', '5', '2', '2', '2', '2', '2', '2', '2', '2', '2'),
	(86, NULL, 1, 20, 2016, '3', '3', '33', '3', '2', '2', '2', '2', '2', '2', 'project updates 234', '2', '2');
/*!40000 ALTER TABLE `task_details` ENABLE KEYS */;


-- Dumping structure for table report.task_risk_mapping
CREATE TABLE IF NOT EXISTS `task_risk_mapping` (
  `TASK_ID` int(11) NOT NULL,
  `RISK_ID` int(11) NOT NULL,
  KEY `task_risk_fk1` (`TASK_ID`),
  KEY `risk_task_fk2` (`RISK_ID`),
  CONSTRAINT `FK_task_risk_mapping_risk_details` FOREIGN KEY (`RISK_ID`) REFERENCES `risk_details` (`RISK_ID`),
  CONSTRAINT `FK_task_risk_mapping_task_details` FOREIGN KEY (`TASK_ID`) REFERENCES `task_details` (`TASK_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table report.task_risk_mapping: ~4 rows (approximately)
/*!40000 ALTER TABLE `task_risk_mapping` DISABLE KEYS */;
INSERT IGNORE INTO `task_risk_mapping` (`TASK_ID`, `RISK_ID`) VALUES
	(64, 140),
	(64, 141),
	(64, 146),
	(86, 147);
/*!40000 ALTER TABLE `task_risk_mapping` ENABLE KEYS */;


-- Dumping structure for table report.user_details
CREATE TABLE IF NOT EXISTS `user_details` (
  `OID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_NAME` varchar(45) DEFAULT NULL,
  `PASSWORD` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`OID`),
  UNIQUE KEY `id_UNIQUE` (`OID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

-- Dumping data for table report.user_details: ~1 rows (approximately)
/*!40000 ALTER TABLE `user_details` DISABLE KEYS */;
INSERT IGNORE INTO `user_details` (`OID`, `USER_NAME`, `PASSWORD`) VALUES
	(1, 'mehak', '123');
/*!40000 ALTER TABLE `user_details` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
