-- MySQL dump 10.13  Distrib 5.5.27, for Win64 (x86)
--
-- Host: localhost    Database: restorankayit
-- ------------------------------------------------------
-- Server version	5.5.27-log

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
-- Table structure for table `cevap`
--

DROP TABLE IF EXISTS `cevap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cevap` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cevapKod` int(255) DEFAULT NULL,
  `cevapKelimesi` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cevap`
--

LOCK TABLES `cevap` WRITE;
/*!40000 ALTER TABLE `cevap` DISABLE KEYS */;
INSERT INTO `cevap` VALUES (1,1,'Çok Kötü...'),(2,2,'Kötü..'),(3,3,'Orta..'),(4,4,'Güzel..'),(5,5,'Çok Güzel..');
/*!40000 ALTER TABLE `cevap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dbyetki`
--

DROP TABLE IF EXISTS `dbyetki`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dbyetki` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `yetkiliID` int(255) DEFAULT NULL,
  `aciklama` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dbyetki`
--

LOCK TABLES `dbyetki` WRITE;
/*!40000 ALTER TABLE `dbyetki` DISABLE KEYS */;
INSERT INTO `dbyetki` VALUES (1,1,'#381'),(2,1,'#206'),(3,1,'#106');
/*!40000 ALTER TABLE `dbyetki` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hareketler`
--

DROP TABLE IF EXISTS `hareketler`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hareketler` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `kisiAdiSoyadi` varchar(255) DEFAULT NULL,
  `mekanID` int(255) DEFAULT NULL,
  `soruID` int(255) DEFAULT NULL,
  `cevapID` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hareketler`
--

LOCK TABLES `hareketler` WRITE;
/*!40000 ALTER TABLE `hareketler` DISABLE KEYS */;
INSERT INTO `hareketler` VALUES (1,'CANER KANSIZ',1,6,4),(2,'CANER KANSIZ',1,5,4),(3,'CANER KANSIZ',1,4,4),(4,'CANER KANSIZ',1,3,3),(5,'CANER KANSIZ',1,2,3),(6,'CANER KANSIZ',1,1,4),(7,'ALİCAN',2,6,3),(8,'ALİCAN',2,5,2),(9,'ALİCAN',2,4,2),(10,'ALİCAN',2,3,2),(11,'ALİCAN',2,2,3),(12,'ALİCAN',2,1,4),(13,'DADF',3,6,-1),(14,'DADF',3,5,0),(15,'DADF',3,4,0),(16,'DADF',3,3,0),(17,'DADF',3,2,0),(18,'DADF',3,1,0),(19,'WQEWEQ',1,6,-1),(20,'WQEWEQ',1,5,0),(21,'WQEWEQ',1,4,0),(22,'WQEWEQ',1,3,0),(23,'WQEWEQ',1,2,0),(24,'WQEWEQ',1,1,0),(25,'QAZ',3,6,-1),(26,'QAZ',3,5,0),(27,'QAZ',3,4,0),(28,'QAZ',3,3,0),(29,'QAZ',3,2,0),(30,'QAZ',3,1,0),(31,'NNNNNNNN',3,6,5),(32,'NNNNNNNN',3,5,5),(33,'NNNNNNNN',3,4,5),(34,'NNNNNNNN',3,3,5),(35,'NNNNNNNN',3,2,5),(36,'NNNNNNNN',3,1,5);
/*!40000 ALTER TABLE `hareketler` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kisi`
--

DROP TABLE IF EXISTS `kisi`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kisi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `yetkiID` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `tarh` date DEFAULT NULL,
  `saat` time DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kisi`
--

LOCK TABLES `kisi` WRITE;
/*!40000 ALTER TABLE `kisi` DISABLE KEYS */;
INSERT INTO `kisi` VALUES (1,'1','CANER','Kansız','root','root12','2012-09-27','22:54:14');
/*!40000 ALTER TABLE `kisi` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mekan`
--

DROP TABLE IF EXISTS `mekan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mekan` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mekanAdi` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mekan`
--

LOCK TABLES `mekan` WRITE;
/*!40000 ALTER TABLE `mekan` DISABLE KEYS */;
INSERT INTO `mekan` VALUES (1,'Medcezir'),(2,'Sultan'),(3,'Şirin');
/*!40000 ALTER TABLE `mekan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `soru`
--

DROP TABLE IF EXISTS `soru`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `soru` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `soruKodu` int(255) DEFAULT NULL,
  `soruKelimesi` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `soru`
--

LOCK TABLES `soru` WRITE;
/*!40000 ALTER TABLE `soru` DISABLE KEYS */;
INSERT INTO `soru` VALUES (1,1,'Yemek Kalitesini Nasıl Buldunuz ?'),(2,2,'Yemek Lezzetini Nasıl Buldunuz ?'),(3,3,'Servis Kalitesini Nasıl Buldunuz ?'),(4,4,'Garsonların Size Karşı Davranışı ?'),(5,5,'Fiyatları Makul Mu ?'),(6,6,'Genel Memnuniyet Dereceniz ?');
/*!40000 ALTER TABLE `soru` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `yetki`
--

DROP TABLE IF EXISTS `yetki`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `yetki` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `yetkili` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `yetki`
--

LOCK TABLES `yetki` WRITE;
/*!40000 ALTER TABLE `yetki` DISABLE KEYS */;
INSERT INTO `yetki` VALUES (1,'SÜPER YÖNETİCİ'),(2,'YÖNETİCİ'),(3,'ADMİN');
/*!40000 ALTER TABLE `yetki` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-10-10  0:15:36
