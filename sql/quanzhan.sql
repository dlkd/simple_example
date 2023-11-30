-- MySQL dump 10.13  Distrib 5.7.39, for Win64 (x86_64)
--
-- Host: localhost    Database: quanzhan_test
-- ------------------------------------------------------
-- Server version	5.7.39-log

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
-- Table structure for table `ap_user`
--

DROP TABLE IF EXISTS `ap_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ap_user` (
  `id` int(10) unsigned DEFAULT NULL,
  `salt` varchar(32) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  `password` varchar(32) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `sex` tinyint(3) unsigned DEFAULT NULL,
  `is_certification` tinyint(3) unsigned DEFAULT NULL,
  `is_identity_authentication` tinyint(4) DEFAULT NULL,
  `status` tinyint(3) unsigned DEFAULT NULL,
  `flag` tinyint(3) unsigned DEFAULT NULL,
  `created_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ap_user`
--

LOCK TABLES `ap_user` WRITE;
/*!40000 ALTER TABLE `ap_user` DISABLE KEYS */;
INSERT INTO `ap_user` VALUES (1,'abc','zhangsan','abc','13511223453',NULL,1,NULL,NULL,1,1,'2020-03-19 23:22:07'),(2,'abc','lisi','abc','13511223454','',1,NULL,NULL,1,1,'2020-03-19 23:22:07'),(3,'sdsa','wangwu','wangwu','13511223455',NULL,NULL,NULL,NULL,NULL,1,NULL),(4,'123abc','admin','81e158e10201b6d7aee6e35eaf744796','13511223456',NULL,1,NULL,NULL,1,1,'2020-03-30 16:36:32'),(5,'123','suwukong','suwukong','13511223458',NULL,1,NULL,NULL,1,1,'2020-08-01 11:09:57'),(6,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `ap_user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `emp_name` varchar(32) DEFAULT NULL,
  `sex` varchar(4) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `dept_name` varchar(32) DEFAULT NULL,
  `emp_degree_name` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=40 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'张一3','女',29,'业务部','博士'),(3,'张三','男',27,'后勤部','大专'),(4,'张四','女',28,'人事部','大专'),(5,'张五','男',29,'后勤部','大专'),(6,'张六','女',29,'后勤部','本科'),(7,'张七','男',33,'业务部','研究生'),(10,'李一','女',45,'业务部','研究生'),(11,'李二','女',19,'人事部','本科'),(12,'李三','男',28,'业务部','研究生'),(13,'李四','女',46,'后勤部','研究生'),(14,'李五','男',58,'业务部','大专'),(15,'李六','女',22,'人事部','研究生'),(16,'李七','男',26,'后勤部','大专'),(17,'李八','男',25,'人事部','研究生'),(18,'李九','女',29,'后勤部','研究生'),(19,'王一','男',45,'后勤部','本科'),(20,'王二','女',21,'业务部','本科'),(21,'王三','男',21,'业务部','大专'),(22,'王四','男',23,'业务部','大专'),(23,'王五','女',33,'业务部','大专'),(24,'王六','男',45,'人事部','本科'),(25,'王七','男',35,'业务部','研究生'),(26,'王八','男',41,'后勤部','本科'),(27,'王九','女',25,'业务部','大专'),(28,'赵一','男',26,'人事部','研究生'),(29,'赵二','男',20,'后勤部','本科'),(30,'赵三','女',21,'人事部','研究生'),(31,'赵四','男',19,'后勤部','研究生'),(32,'赵五','女',35,'后勤部','大专'),(33,'赵六','男',24,'业务部','研究生'),(34,'赵七','男',29,'业务部','大专'),(35,'赵八','女',33,'业务部','研究生'),(36,'赵九','男',45,'业务部','本科'),(37,'孙维良','1',23,'业务部','其他'),(38,'测试','男',26,'业务部','大专'),(39,'赵九','女',66,'人事部','高中');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-11-30 16:41:04
