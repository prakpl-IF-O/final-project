-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: hotel
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
-- Table structure for table `detailtransaksi`
--

DROP TABLE IF EXISTS `detailtransaksi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `detailtransaksi` (
  `kodeTransaksi` int(11) DEFAULT NULL,
  `idPelanggan` int(11) DEFAULT NULL,
  `nomorKamar` int(11) DEFAULT NULL,
  `checkIn` datetime DEFAULT NULL,
  `batas` datetime DEFAULT NULL,
  `checkOut` datetime DEFAULT NULL,
  `total` double DEFAULT NULL,
  KEY `kodeTransaksi` (`kodeTransaksi`),
  KEY `idPelanggan` (`idPelanggan`),
  KEY `nomorKamar` (`nomorKamar`),
  CONSTRAINT `detailtransaksi_ibfk_1` FOREIGN KEY (`kodeTransaksi`) REFERENCES `transaksi` (`kode`),
  CONSTRAINT `detailtransaksi_ibfk_2` FOREIGN KEY (`idPelanggan`) REFERENCES `pelanggan` (`id`),
  CONSTRAINT `detailtransaksi_ibfk_3` FOREIGN KEY (`nomorKamar`) REFERENCES `kamar` (`noKamar`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detailtransaksi`
--

LOCK TABLES `detailtransaksi` WRITE;
/*!40000 ALTER TABLE `detailtransaksi` DISABLE KEYS */;
/*!40000 ALTER TABLE `detailtransaksi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kamar`
--

DROP TABLE IF EXISTS `kamar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kamar` (
  `noKamar` int(11) NOT NULL,
  `harga` double DEFAULT NULL,
  `kelas` varchar(10) DEFAULT NULL,
  `isSewa` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`noKamar`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kamar`
--

LOCK TABLES `kamar` WRITE;
/*!40000 ALTER TABLE `kamar` DISABLE KEYS */;
INSERT INTO `kamar` VALUES (1,100000,'Reguler',0),(2,100000,'Reguler',0),(3,100000,'Reguler',0),(4,100000,'Reguler',0),(5,100000,'Reguler',0),(6,100000,'Reguler',0),(7,100000,'Reguler',0),(8,100000,'Reguler',0),(9,100000,'Reguler',0),(10,100000,'Reguler',0),(11,100000,'Reguler',0),(12,100000,'Reguler',0),(13,100000,'Reguler',0),(14,100000,'Reguler',0),(15,100000,'Reguler',0),(16,100000,'Reguler',0),(17,100000,'Reguler',0),(18,100000,'Reguler',0),(19,100000,'Reguler',0),(20,100000,'Reguler',0),(21,100000,'Reguler',0),(22,100000,'Reguler',0),(23,100000,'Reguler',0),(24,100000,'Reguler',0),(25,100000,'Reguler',0),(26,100000,'Reguler',0),(27,100000,'Reguler',0),(28,100000,'Reguler',0),(29,100000,'Reguler',0),(30,100000,'Reguler',0),(31,100000,'Reguler',0),(32,100000,'Reguler',0),(33,100000,'Reguler',0),(34,100000,'Reguler',0),(35,100000,'Reguler',0),(36,100000,'Reguler',0),(37,100000,'Reguler',0),(38,100000,'Reguler',0),(39,100000,'Reguler',0),(40,100000,'Reguler',0),(41,100000,'Reguler',0),(42,100000,'Reguler',0),(43,100000,'Reguler',0),(44,100000,'Reguler',0),(45,100000,'Reguler',0),(46,100000,'Reguler',0),(47,100000,'Reguler',0),(48,100000,'Reguler',0),(49,100000,'Reguler',0),(50,100000,'Reguler',0),(51,200000,'Premium',0),(52,200000,'Premium',0),(53,200000,'Premium',0),(54,200000,'Premium',0),(55,200000,'Premium',0),(56,200000,'Premium',0),(57,200000,'Premium',0),(58,200000,'Premium',0),(59,200000,'Premium',0),(60,200000,'Premium',0),(61,200000,'Premium',0),(62,200000,'Premium',0),(63,200000,'Premium',0),(64,200000,'Premium',0),(65,200000,'Premium',0),(66,200000,'Premium',0),(67,200000,'Premium',0),(68,200000,'Premium',0),(69,200000,'Premium',0),(70,200000,'Premium',0),(71,350000,'Suite',0),(72,350000,'Suite',0),(73,350000,'Suite',0),(74,350000,'Suite',0),(75,350000,'Suite',0),(76,350000,'Suite',0),(77,350000,'Suite',0),(78,350000,'Suite',0),(79,350000,'Suite',0),(80,350000,'Suite',0),(81,350000,'Suite',0),(82,350000,'Suite',0),(83,350000,'Suite',0),(84,350000,'Suite',0),(85,350000,'Suite',0),(86,350000,'Suite',0),(87,350000,'Suite',0),(88,350000,'Suite',0),(89,350000,'Suite',0),(90,350000,'Suite',0),(91,750000,'VIP',0),(92,750000,'VIP',0),(93,750000,'VIP',0),(94,750000,'VIP',0),(95,750000,'VIP',0),(96,750000,'VIP',0),(97,750000,'VIP',0),(98,750000,'VIP',0),(99,750000,'VIP',0),(100,750000,'VIP',0);
/*!40000 ALTER TABLE `kamar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pelanggan`
--

DROP TABLE IF EXISTS `pelanggan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pelanggan` (
  `id` int(11) NOT NULL,
  `nik` varchar(30) DEFAULT NULL,
  `nama` varchar(40) DEFAULT NULL,
  `tempatlahir` varchar(20) DEFAULT NULL,
  `tglLahir` date DEFAULT NULL,
  `tglDaftar` date DEFAULT NULL,
  `akumulasi` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pelanggan`
--

LOCK TABLES `pelanggan` WRITE;
/*!40000 ALTER TABLE `pelanggan` DISABLE KEYS */;
/*!40000 ALTER TABLE `pelanggan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `transaksi`
--

DROP TABLE IF EXISTS `transaksi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `transaksi` (
  `kode` int(11) NOT NULL,
  `idPelanggan` int(11) DEFAULT NULL,
  `tglTransaksi` datetime DEFAULT NULL,
  PRIMARY KEY (`kode`),
  KEY `idPelanggan` (`idPelanggan`),
  CONSTRAINT `transaksi_ibfk_1` FOREIGN KEY (`idPelanggan`) REFERENCES `pelanggan` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `transaksi`
--

LOCK TABLES `transaksi` WRITE;
/*!40000 ALTER TABLE `transaksi` DISABLE KEYS */;
/*!40000 ALTER TABLE `transaksi` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-22 20:09:01
