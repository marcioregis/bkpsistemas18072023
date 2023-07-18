CREATE DATABASE  IF NOT EXISTS `sistema` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `sistema`;
-- MySQL dump 10.13  Distrib 5.7.12, for Win64 (x86_64)
--
-- Host: localhost    Database: sistema
-- ------------------------------------------------------
-- Server version	5.7.13-log

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
-- Table structure for table `fornecedores`
--

DROP TABLE IF EXISTS `fornecedores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fornecedores` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fornecedores`
--

LOCK TABLES `fornecedores` WRITE;
/*!40000 ALTER TABLE `fornecedores` DISABLE KEYS */;
INSERT INTO `fornecedores` VALUES (1,'FORNECEDOR 1'),(2,'FORNECEDOR 2');
/*!40000 ALTER TABLE `fornecedores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `imoveis`
--

DROP TABLE IF EXISTS `imoveis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `imoveis` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `endereco` varchar(45) NOT NULL,
  `bairro` varchar(45) NOT NULL,
  `cidade` varchar(25) NOT NULL,
  `cep` varchar(45) NOT NULL,
  `tipo` varchar(45) NOT NULL,
  `uf` varchar(45) NOT NULL,
  `andar` varchar(45) NOT NULL,
  `valoraluguel` decimal(7,2) NOT NULL,
  `valorcondominio` decimal(7,2) NOT NULL,
  `valoriptu` decimal(7,2) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `imoveis`
--

LOCK TABLES `imoveis` WRITE;
/*!40000 ALTER TABLE `imoveis` DISABLE KEYS */;
INSERT INTO `imoveis` VALUES (2,'EDIFICIO JARDIM DAS FLORES','RUA BB','CENTRO','FORTALEZA','33333222','EDF','CE','2',400.00,60.00,20.00),(4,'EDIFICIO PANORAMICO','RUA 13 DE MAIO 2345','BENFICA','FORTALEZA','60899543','EDF','CE','33',100.00,10.00,5.00),(6,'EDIFICIO SAN LORENZO','RUA 13 DE MAIO, 2345','CENTRO','FORTALEZA','60899543','APTO','CE','12',100.00,10.00,5.00);
/*!40000 ALTER TABLE `imoveis` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inquilinos`
--

DROP TABLE IF EXISTS `inquilinos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inquilinos` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `nomeinq` varchar(45) NOT NULL,
  `endereco` varchar(45) NOT NULL,
  `imoveis_codigo` int(11) NOT NULL,
  `bairro` varchar(25) NOT NULL,
  `cidade` varchar(45) NOT NULL,
  `cep` varchar(9) NOT NULL,
  `uf` varchar(2) NOT NULL,
  `cpf` varchar(20) NOT NULL,
  `rg` varchar(40) NOT NULL,
  `profissao` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `telefone` varchar(20) NOT NULL,
  `celular` varchar(20) NOT NULL,
  `enderecocom` varchar(45) NOT NULL,
  `bairrocom` varchar(45) NOT NULL,
  `cidadecom` varchar(45) NOT NULL,
  `cepcom` varchar(10) NOT NULL,
  `ufcom` varchar(2) NOT NULL,
  `telefonecom` varchar(20) NOT NULL,
  `celularcom` varchar(20) NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `fk_inquilinos_imoveis1_idx` (`imoveis_codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inquilinos`
--

LOCK TABLES `inquilinos` WRITE;
/*!40000 ALTER TABLE `inquilinos` DISABLE KEYS */;
INSERT INTO `inquilinos` VALUES (6,'MARCIO GAZELLI','RUA TERERZA S',2,'CENTRO','CAUCAIA','54645645','CE','11111111111','22222222222','GERENTE','mmr@gmail.com','33421916','9999999','AV W SOARES, 1321','CURICACA','FORTALEZA','444444','CE','55555777','988776622'),(7,'CARLIM GAZELLI','RUA TERERZA S',6,'CENTRO','FORTALEZA','54645645','CE','21321323','33333333333','CEO','mmr@gmail.com','33421916','9999999','RUA DOS ANJOSA, 23','CURICACA','FORTALEZA','444444','CE','88761233','988776622'),(9,'JOSE FEITAS MARINHO DOS ANJOS DA SILVA MELO','RUA SANTA ISABEL,24',4,'CENTRO','FORTALEZA','12345777','CE','23402095423','98989898989','MOTORISTA','jose@gmail.com','12345577','987651234','RUA COMERCIAL, 20','CAJAJEIRAS','FORTALEZA','61609123','CE','(85)4422-3322','988997777');
/*!40000 ALTER TABLE `inquilinos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produtos`
--

DROP TABLE IF EXISTS `produtos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produtos` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) NOT NULL,
  `quantidade` int(11) NOT NULL,
  `preco` decimal(6,2) NOT NULL,
  `fornecedores_codigo` int(11) NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `fk_produtos_fornecedores_idx` (`fornecedores_codigo`),
  CONSTRAINT `fk_produtos_fornecedores` FOREIGN KEY (`fornecedores_codigo`) REFERENCES `fornecedores` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produtos`
--

LOCK TABLES `produtos` WRITE;
/*!40000 ALTER TABLE `produtos` DISABLE KEYS */;
INSERT INTO `produtos` VALUES (1,'REMEDIO A',10,22.00,1),(2,'REMEDIO B',15,23.00,2),(3,'REMEDIO C',17,27.00,2);
/*!40000 ALTER TABLE `produtos` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-07-18 12:06:32
