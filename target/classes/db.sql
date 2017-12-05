-- MySQL dump 10.13  Distrib 5.7.18, for osx10.11 (x86_64)
--
-- Host: localhost    Database: ac
-- ------------------------------------------------------
-- Server version	5.7.18

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
-- Table structure for table `bootcamp`
--

DROP TABLE IF EXISTS `bootcamp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bootcamp` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `location` varchar(255) DEFAULT NULL,
  `start` datetime DEFAULT NULL,
  `end` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bootcamp`
--

LOCK TABLES `bootcamp` WRITE;
/*!40000 ALTER TABLE `bootcamp` DISABLE KEYS */;
INSERT INTO `bootcamp` VALUES (1,'Lisboa',NULL,NULL),(2,'Lisboa',NULL,NULL),(3,'Lisboa',NULL,NULL),(4,'Fund√£o',NULL,NULL);
/*!40000 ALTER TABLE `bootcamp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `code_cadet`
--

DROP TABLE IF EXISTS `code_cadet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `code_cadet` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gender` tinyblob,
  `address` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `birthdate` datetime DEFAULT NULL,
  `bootcamp_id` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK_at03b9hj9adr3ic9dgqshdhr4` (`user_id`),
  KEY `FK7x251n4hwwo0qh5xbibp5bnyi` (`bootcamp_id`),
  CONSTRAINT `FK7x251n4hwwo0qh5xbibp5bnyi` FOREIGN KEY (`bootcamp_id`) REFERENCES `bootcamp` (`id`),
  CONSTRAINT `FKcqs9wgfkbr2so5ot1nw99aoru` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `code_cadet`
--

LOCK TABLES `code_cadet` WRITE;
/*!40000 ALTER TABLE `code_cadet` DISABLE KEYS */;
INSERT INTO `code_cadet` VALUES (1,'¨\Ì\0~r\0*org.academiadecodigo.bootcamp.utils.Gender\0\0\0\0\0\0\0\0\0\0xr\0java.lang.Enum\0\0\0\0\0\0\0\0\0\0xpt\0M','Rua 1','Coimbra','666999','1970-01-01 01:00:00',1,4),(2,'¨\Ì\0~r\0*org.academiadecodigo.bootcamp.utils.Gender\0\0\0\0\0\0\0\0\0\0xr\0java.lang.Enum\0\0\0\0\0\0\0\0\0\0xpt\0M','Rua 1','Coimbra','666999','1970-01-01 01:00:00',1,3);
/*!40000 ALTER TABLE `code_cadet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Rui Ferr√£o','8df75d2dd0764b94fb2da0516f521b5e0a664499','rui.ferrao@academiadecodigo.org'),(2,'Catarina Campino','8df75d2dd0764b94fb2da0516f521b5e0a664499','catarina.campino@academiadecodigo.org'),(3,'Daniel Francisco','8df75d2dd0764b94fb2da0516f521b5e0a664499','daniel.francisco@gmail.com'),(4,'Lopo Antunes','8df75d2dd0764b94fb2da0516f521b5e0a664499','lopo.antunes@gmail.com');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-07-30 18:53:54
