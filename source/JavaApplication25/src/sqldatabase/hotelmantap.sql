-- MySQL dump 10.13  Distrib 5.7.12, for Win32 (AMD64)
--
-- Host: localhost    Database: hotelmantap
-- ------------------------------------------------------
-- Server version	5.7.12

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
-- Table structure for table `checkflow`
--

DROP TABLE IF EXISTS `checkflow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `checkflow` (
  `id` varchar(20) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `roomType` varchar(10) DEFAULT NULL,
  `checkin` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `checkout` datetime DEFAULT NULL,
  `actualcheckout` datetime DEFAULT NULL,
  `fine` int(11) DEFAULT NULL,
  `Invoice` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `checkflow`
--

LOCK TABLES `checkflow` WRITE;
/*!40000 ALTER TABLE `checkflow` DISABLE KEYS */;
/*!40000 ALTER TABLE `checkflow` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customerdata`
--

DROP TABLE IF EXISTS `customerdata`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customerdata` (
  `id` varchar(20) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `Address` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customerdata`
--

LOCK TABLES `customerdata` WRITE;
/*!40000 ALTER TABLE `customerdata` DISABLE KEYS */;
/*!40000 ALTER TABLE `customerdata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `room`
--

DROP TABLE IF EXISTS `room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `room` (
  `Number` int(11) DEFAULT NULL,
  `type` varchar(10) DEFAULT NULL,
  `customer` varchar(50) DEFAULT NULL,
  `checkout` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `room`
--

LOCK TABLES `room` WRITE;
/*!40000 ALTER TABLE `room` DISABLE KEYS */;
INSERT INTO `room` VALUES (101,'Regular',NULL,NULL),(102,'Regular',NULL,NULL),(103,'Regular',NULL,NULL),(104,'Regular',NULL,NULL),(105,'Regular',NULL,NULL),(106,'Regular',NULL,NULL),(107,'Regular',NULL,NULL),(108,'Regular',NULL,NULL),(109,'Regular',NULL,NULL),(110,'Regular',NULL,NULL),(201,'Regular',NULL,NULL),(202,'Regular',NULL,NULL),(203,'Regular',NULL,NULL),(204,'Regular',NULL,NULL),(205,'Regular',NULL,NULL),(206,'Regular',NULL,NULL),(207,'Regular',NULL,NULL),(208,'Regular',NULL,NULL),(209,'Regular',NULL,NULL),(210,'Regular',NULL,NULL),(301,'Regular',NULL,NULL),(302,'Regular',NULL,NULL),(303,'Regular',NULL,NULL),(304,'Regular',NULL,NULL),(305,'Regular',NULL,NULL),(306,'Regular',NULL,NULL),(307,'Regular',NULL,NULL),(308,'Regular',NULL,NULL),(309,'Regular',NULL,NULL),(310,'Regular',NULL,NULL),(401,'Regular',NULL,NULL),(402,'Regular',NULL,NULL),(403,'Regular',NULL,NULL),(404,'Regular',NULL,NULL),(405,'Regular',NULL,NULL),(406,'Regular',NULL,NULL),(407,'Regular',NULL,NULL),(408,'Regular',NULL,NULL),(409,'Regular',NULL,NULL),(410,'Regular',NULL,NULL),(501,'Regular',NULL,NULL),(502,'Regular',NULL,NULL),(503,'Regular',NULL,NULL),(504,'Regular',NULL,NULL),(505,'Regular',NULL,NULL),(506,'Regular',NULL,NULL),(507,'Regular',NULL,NULL),(508,'Regular',NULL,NULL),(509,'Regular',NULL,NULL),(510,'Regular',NULL,NULL),(601,'Premium',NULL,NULL),(602,'Premium',NULL,NULL),(603,'Premium',NULL,NULL),(604,'Premium',NULL,NULL),(605,'Premium',NULL,NULL),(606,'Premium',NULL,NULL),(607,'Premium',NULL,NULL),(608,'Premium',NULL,NULL),(609,'Premium',NULL,NULL),(610,'Premium',NULL,NULL),(701,'Premium',NULL,NULL),(702,'Premium',NULL,NULL),(703,'Premium',NULL,NULL),(704,'Premium',NULL,NULL),(705,'Premium',NULL,NULL),(706,'Premium',NULL,NULL),(707,'Premium',NULL,NULL),(708,'Premium',NULL,NULL),(709,'Premium',NULL,NULL),(710,'Premium',NULL,NULL),(801,'Suite',NULL,NULL),(802,'Suite',NULL,NULL),(803,'Suite',NULL,NULL),(804,'Suite',NULL,NULL),(805,'Suite',NULL,NULL),(806,'Suite',NULL,NULL),(807,'Suite',NULL,NULL),(808,'Suite',NULL,NULL),(809,'Suite',NULL,NULL),(810,'Suite',NULL,NULL),(901,'Suite',NULL,NULL),(902,'Suite',NULL,NULL),(903,'Suite',NULL,NULL),(904,'Suite',NULL,NULL),(905,'Suite',NULL,NULL),(906,'Suite',NULL,NULL),(907,'Suite',NULL,NULL),(908,'Suite',NULL,NULL),(909,'Suite',NULL,NULL),(910,'Suite',NULL,NULL),(1001,'VIP',NULL,NULL),(1002,'VIP',NULL,NULL),(1003,'VIP',NULL,NULL),(1004,'VIP',NULL,NULL),(1005,'VIP',NULL,NULL),(1006,'VIP',NULL,NULL),(1007,'VIP',NULL,NULL),(1008,'VIP',NULL,NULL),(1009,'VIP',NULL,NULL),(1010,'VIP',NULL,NULL);
/*!40000 ALTER TABLE `room` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-24 19:10:31
