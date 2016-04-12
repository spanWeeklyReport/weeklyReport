CREATE DATABASE  IF NOT EXISTS `report` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `report`;
-- MySQL dump 10.13  Distrib 5.5.16, for Win32 (x86)
--
-- Host: localhost    Database: report
-- ------------------------------------------------------
-- Server version	5.5.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `task_details`
--

DROP TABLE IF EXISTS `task_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `task_details` (
  `O_ID` int(11) NOT NULL AUTO_INCREMENT,
  `U_ID` int(11) DEFAULT NULL,
  `PROJECT_ID` int(11) DEFAULT NULL,
  `WEEK_NO.` int(11) DEFAULT NULL,
  `PLANNED_TASK` varchar(45) DEFAULT NULL,
  `COMPLETED_TASK` varchar(45) DEFAULT NULL,
  `HOLD_TASK` varchar(45) DEFAULT NULL,
  `INPROGRESS_TASK` varchar(45) DEFAULT NULL,
  `RISK_DESC` varchar(700) DEFAULT NULL,
  `RISK_RESP` varchar(45) DEFAULT NULL,
  `SHARED_RESOURCES` varchar(745) DEFAULT NULL,
  `BILLED_RESOURCES` varchar(45) DEFAULT NULL,
  `PROJECT_INC` varchar(45) DEFAULT NULL,
  `PROJECT_DEC` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`O_ID`),
  KEY `uid_idx` (`U_ID`),
  KEY `pid_idx` (`PROJECT_ID`),
  CONSTRAINT `pid` FOREIGN KEY (`PROJECT_ID`) REFERENCES `project_details` (`O_ID`) ON DELETE NO ACTION ON UPDATE CASCADE,
  CONSTRAINT `uid` FOREIGN KEY (`U_ID`) REFERENCES `user_details` (`O_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `task_details`
--

LOCK TABLES `task_details` WRITE;
/*!40000 ALTER TABLE `task_details` DISABLE KEYS */;
INSERT INTO `task_details` VALUES (1,NULL,NULL,3,'9','5','2','2','risk reduced upto great extent','none','7','2','9','5'),(2,NULL,NULL,7,'15','7','5','8','no risk','none','5','1','7','3'),(3,NULL,NULL,13,'17','5','7','6','high risk','dolly','7','5','9','1'),(4,NULL,NULL,20,'8','2','2','2','medium level','neha','3','1','4','2'),(5,NULL,NULL,12,'30','20','2','4','low risk','mehak','8','4','7','4');
/*!40000 ALTER TABLE `task_details` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-03-22 18:41:30
