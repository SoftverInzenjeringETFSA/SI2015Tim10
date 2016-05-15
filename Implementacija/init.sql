-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: tim10
-- ------------------------------------------------------
-- Server version	5.7.12-log

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
-- Table structure for table `kategorija`
--

DROP TABLE IF EXISTS `kategorija`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `kategorija` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ime` varchar(255) DEFAULT NULL,
  `putanja` varchar(255) DEFAULT NULL,
  `parentKategorija` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKtesrnwyeebbfx4obmcemcpd6d` (`parentKategorija`),
  CONSTRAINT `FKtesrnwyeebbfx4obmcemcpd6d` FOREIGN KEY (`parentKategorija`) REFERENCES `kategorija` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kategorija`
--

LOCK TABLES `kategorija` WRITE;
/*!40000 ALTER TABLE `kategorija` DISABLE KEYS */;
INSERT INTO `kategorija` VALUES (1,'MS Office','',NULL),(5,'Word','MS Office/',1),(6,'Excel','MS Office/',1),(8,'Tabele','MS Office/Word/',5),(9,'Font','MS Office/Word/',5),(10,'Margine','MS Office/Word/',5),(11,'Dodavanje tabele','MS Office/Word/Tabele/',8),(12,'Brisanje tabele','MS Office/Word/Tabele/',8),(13,'Promjena velicine fonta','MS Office/Word/Font/',9),(14,'Promjena boje fonta','MS Office/Word/Font/',9),(15,'Promjena margine','MS Office/Word/Margine/',10),(16,'Selektovanje margine','MS Office/Word/Margine/',10),(17,'Filtriranje','MS Office/Excel/',6),(21,'Dodavanje filtera','MS Office/Excel/Filtriranje/',17),(22,'Iskljucivanje filtera','MS Office/Excel/Filtriranje/',17);
/*!40000 ALTER TABLE `kategorija` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `klijent`
--

DROP TABLE IF EXISTS `klijent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `klijent` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `Adresa` varchar(255) DEFAULT NULL,
  `brojTelefona` varchar(255) DEFAULT NULL,
  `ime` varchar(255) DEFAULT NULL,
  `prezime` varchar(255) DEFAULT NULL,
  `starost` int(11) NOT NULL,
  `zaposlenje` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `klijent`
--

LOCK TABLES `klijent` WRITE;
/*!40000 ALTER TABLE `klijent` DISABLE KEYS */;
INSERT INTO `klijent` VALUES (1,'Alipašino','061-245-211','Ammar','Lala',25,'Student'),(2,'Vojničko polje','062-531-355','Eldin','Kasap',24,'Student'),(3,'Pejton','061-331-777','Aldin','Tatlic',39,'Administrativni radnik'),(4,'Dobrinja 1','061-332-675','Damir','Zornic',13,'Nezaposlen'),(5,'Ustanička','063-317-785','Edin','Dzaferovic',32,'Nezaposlen');
/*!40000 ALTER TABLE `klijent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `korisnik`
--

DROP TABLE IF EXISTS `korisnik`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `korisnik` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `adresa` varchar(255) DEFAULT NULL,
  `brojLicneKarte` varchar(255) DEFAULT NULL,
  `brojTelefona` varchar(255) DEFAULT NULL,
  `datumZaposlenja` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `ime` varchar(255) DEFAULT NULL,
  `jmbg` varchar(255) DEFAULT NULL,
  `korisnickoIme` varchar(255) DEFAULT NULL,
  `prezime` varchar(255) DEFAULT NULL,
  `sifra` varchar(255) DEFAULT NULL,
  `operater_id` bigint(20) DEFAULT NULL,
  `tipkorisnika_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKirr3oi7whch9c9w06dpmcpmqf` (`operater_id`),
  KEY `FKqmnvyde8ppxq1t56ve7vl867a` (`tipkorisnika_id`),
  CONSTRAINT `FKirr3oi7whch9c9w06dpmcpmqf` FOREIGN KEY (`operater_id`) REFERENCES `operater` (`id`),
  CONSTRAINT `FKqmnvyde8ppxq1t56ve7vl867a` FOREIGN KEY (`tipkorisnika_id`) REFERENCES `tipkorisnika` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `korisnik`
--

LOCK TABLES `korisnik` WRITE;
/*!40000 ALTER TABLE `korisnik` DISABLE KEYS */;
INSERT INTO `korisnik` VALUES (1,'Nerkeza Smailagića','06btn8359','061-112-332','2014-05-05 22:41:59','dino@gmail.com','Dino','2493881557721','DinoAdmin','Dedovic','65FKMNSTU4GYGA0',NULL,NULL),(2,'Nedima Filipovića','75trk3713','061-351-354','2012-05-23 22:43:10','emir@gmail.com','Emir','2300756588835','EmirAdmin','Hurem','10PV79DOY7Y84QB',NULL,NULL),(3,'Trg Heroja','84knb3859','066-512-321','2014-09-08 22:44:31','amela@gmail.com','Amela','3454773728812','AmelaMenadzer','Agresivna','EZKOAMFKWBGUMKS',NULL,NULL),(4,'Envera Sehovića','11asd5848','063-231-876','2016-01-03 22:46:23','denis@gmail.com','Denis','5792391558833','DenisMenadzer','Korjenic','EOQAI9NKWGL8TLL',NULL,NULL),(5,'Zmaj od Bosne','57utj3795','061-223-551','2010-07-27 22:47:40','almedin@gmai.com','Almedin','1354467882277','AlmedinKorisnik','Velija','F0JXJJVU7DBRM6L',NULL,NULL),(6,'Paromlinska','11rkb8472','061-231-515','2010-02-10 22:49:26','enver@gmail.com','Enver','7658995167754','EnverKorisnik','Peza','KZ7HV1AB2FVEZUF',NULL,NULL);
/*!40000 ALTER TABLE `korisnik` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `odjava`
--

DROP TABLE IF EXISTS `odjava`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `odjava` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `datumOdjave` datetime DEFAULT NULL,
  `korisnik_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKehsfvbs4rn8lrkofwo61e0ysf` (`korisnik_id`),
  CONSTRAINT `FKehsfvbs4rn8lrkofwo61e0ysf` FOREIGN KEY (`korisnik_id`) REFERENCES `korisnik` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `odjava`
--

LOCK TABLES `odjava` WRITE;
/*!40000 ALTER TABLE `odjava` DISABLE KEYS */;
/*!40000 ALTER TABLE `odjava` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `operater`
--

DROP TABLE IF EXISTS `operater`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `operater` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `adresa` varchar(255) DEFAULT NULL,
  `ime` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `operater`
--

LOCK TABLES `operater` WRITE;
/*!40000 ALTER TABLE `operater` DISABLE KEYS */;
/*!40000 ALTER TABLE `operater` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pitanje`
--

DROP TABLE IF EXISTS `pitanje`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pitanje` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `odgovor` varchar(255) DEFAULT NULL,
  `pitanje` varchar(255) DEFAULT NULL,
  `putanja` varchar(255) DEFAULT NULL,
  `kategorija_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK1dl17lrr7injo072qmkoi9e6k` (`kategorija_id`),
  CONSTRAINT `FK1dl17lrr7injo072qmkoi9e6k` FOREIGN KEY (`kategorija_id`) REFERENCES `kategorija` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pitanje`
--

LOCK TABLES `pitanje` WRITE;
/*!40000 ALTER TABLE `pitanje` DISABLE KEYS */;
INSERT INTO `pitanje` VALUES (1,'Insert-> Add Table -> Izabrati veličinu','Kako ubacit tabelu?','MS Office/Word/Tabele/Dodavanje tabele/',11),(2,'Selekt tabelu -> Delete','Kako obrisati tabelu?','MS Office/Word/Tabele/Brisanje tabele/',12),(3,'Home-> Font Size -> Veličina koju želimo','Kako promjenit veličinu fonta?','MS Office/Word/Font/Promjena velicine fonta/',13),(4,'Home-> font color ','Kako promjenit boju slova?','MS Office/Word/Font/Promjena boje fonta/',14),(5,'Home -> Background color -> promjenit u željenu boju.','Kako promjenit boju pozadine ?','MS Office/Word/Font/Promjena boje fonta/',14),(6,'Ide se margins promjena...','Kako promjenit marginu?','MS Office/Word/Margine/Promjena margine/',15),(7,'select home page lyaout','Kako selektova marginu?','MS Office/Word/Margine/Selektovanje margine/',16),(8,'ide se data add filter..','Kako dodati filter?','MS Office/Excel/Filtriranje/',17),(9,'filter odabir ....','Kako filtrirati tabelu?','MS Office/Excel/Filtriranje/',17),(10,'ide se data add filter..','Kako dodati filter?','MS Office/Excel/Filtriranje/',17),(11,'filter odabir ....','Kako filtrirati tabelu?','MS Office/Excel/Filtriranje/',17),(12,'filter odabir ....','Kako filtrirati tabelu?','MS Office/Excel/Filtriranje/',17);
/*!40000 ALTER TABLE `pitanje` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pitanje_poziv`
--

DROP TABLE IF EXISTS `pitanje_poziv`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pitanje_poziv` (
  `pitanje_id` bigint(20) NOT NULL,
  `poziv_id` bigint(20) NOT NULL,
  PRIMARY KEY (`pitanje_id`,`poziv_id`),
  KEY `FKrwoah3a3l0nx0c4ux1f7nfvad` (`poziv_id`),
  CONSTRAINT `FK558bsgx6ey3i9g0xpq2e8oa5d` FOREIGN KEY (`pitanje_id`) REFERENCES `pitanje` (`id`),
  CONSTRAINT `FKrwoah3a3l0nx0c4ux1f7nfvad` FOREIGN KEY (`poziv_id`) REFERENCES `telefonskipoziv` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pitanje_poziv`
--

LOCK TABLES `pitanje_poziv` WRITE;
/*!40000 ALTER TABLE `pitanje_poziv` DISABLE KEYS */;
INSERT INTO `pitanje_poziv` VALUES (10,5),(12,7),(12,9);
/*!40000 ALTER TABLE `pitanje_poziv` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prijava`
--

DROP TABLE IF EXISTS `prijava`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prijava` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `datumPrijave` datetime DEFAULT NULL,
  `korisnik_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKk9qlhlenh7r34w55enj7mn133` (`korisnik_id`),
  CONSTRAINT `FKk9qlhlenh7r34w55enj7mn133` FOREIGN KEY (`korisnik_id`) REFERENCES `korisnik` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prijava`
--

LOCK TABLES `prijava` WRITE;
/*!40000 ALTER TABLE `prijava` DISABLE KEYS */;
/*!40000 ALTER TABLE `prijava` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `telefonskipoziv`
--

DROP TABLE IF EXISTS `telefonskipoziv`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `telefonskipoziv` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `opisniTekst` varchar(255) DEFAULT NULL,
  `poziv` datetime DEFAULT NULL,
  `trajanjePoziva` double NOT NULL,
  `klijent_id` bigint(20) DEFAULT NULL,
  `operater_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgwabnfknjjhaedra24owj9jup` (`klijent_id`),
  KEY `FKbqjs1ms9868txb0012dbnylt5` (`operater_id`),
  CONSTRAINT `FKbqjs1ms9868txb0012dbnylt5` FOREIGN KEY (`operater_id`) REFERENCES `operater` (`id`),
  CONSTRAINT `FKgwabnfknjjhaedra24owj9jup` FOREIGN KEY (`klijent_id`) REFERENCES `klijent` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `telefonskipoziv`
--

LOCK TABLES `telefonskipoziv` WRITE;
/*!40000 ALTER TABLE `telefonskipoziv` DISABLE KEYS */;
INSERT INTO `telefonskipoziv` VALUES (1,'','2016-05-15 23:12:20',0,1,NULL),(2,'','2016-05-15 23:13:24',0,2,NULL),(3,'','2016-05-15 23:14:22',0,3,NULL),(4,'','2016-05-15 23:23:09',0,4,NULL),(5,NULL,'2016-05-15 23:23:09',0,4,NULL),(6,'Filter tabela','2016-05-15 23:27:25',0,5,NULL),(7,NULL,'2016-05-15 23:27:25',0,5,NULL),(8,'test','2016-05-15 23:45:10',0,1,NULL),(9,NULL,'2016-05-15 23:46:34',0,1,NULL);
/*!40000 ALTER TABLE `telefonskipoziv` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipkorisnika`
--

DROP TABLE IF EXISTS `tipkorisnika`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipkorisnika` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `tipKorisnika` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipkorisnika`
--

LOCK TABLES `tipkorisnika` WRITE;
/*!40000 ALTER TABLE `tipkorisnika` DISABLE KEYS */;
INSERT INTO `tipkorisnika` VALUES (1,'Administrator'),(2,'Menadzer'),(3,'Obicni korisnik');
/*!40000 ALTER TABLE `tipkorisnika` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-05-16  0:03:05
