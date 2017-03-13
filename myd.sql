-- MySQL dump 10.10
--
-- Host: localhost    Database: myd
-- ------------------------------------------------------
-- Server version	5.0.18-nt

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
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL auto_increment,
  `name` char(30) NOT NULL,
  `paw` char(30) NOT NULL,
  `pnum` char(11) NOT NULL,
  `mail` char(30) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `admin`
--


/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
LOCK TABLES `admin` WRITE;
INSERT INTO `admin` VALUES (2,'jjtx','root','17839927862','786274022@qq.com'),(3,'myd','jjtx','17839927862','2991186645@qq.com');
UNLOCK TABLES;
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;

--
-- Table structure for table `food`
--

DROP TABLE IF EXISTS `food`;
CREATE TABLE `food` (
  `id` int(11) NOT NULL auto_increment,
  `name` char(50) NOT NULL,
  `type` int(11) default '0',
  `price` decimal(10,2) NOT NULL,
  `shopid` int(11) default NULL,
  `picpath` char(50) NOT NULL,
  `des` char(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `food`
--


/*!40000 ALTER TABLE `food` DISABLE KEYS */;
LOCK TABLES `food` WRITE;
INSERT INTO `food` VALUES (2,'霸王鸡',3,'24.00',1,'E:\\foodimgs\\0.jpg','霸王鸡！霸王别鸡！'),(3,'照烧鸡腿饼',2,'4.00',1,'E:\\foodimgs\\2.jpg','照烧鸡腿饼！照烧鸡腿饼！照烧鸡腿饼！照烧鸡腿饼！照烧鸡腿饼！'),(4,'金牛爆肚',5,'24.00',1,'E:\\foodimgs\\3.jpg','金牛爆肚！金牛爆肚！金牛爆肚！'),(5,'麻辣粉皮',0,'8.00',1,'E:\\foodimgs\\4.jpg','麻辣粉皮！麻辣粉皮！麻辣粉皮！麻辣粉皮！'),(7,'饼加鸡蛋豆皮',2,'5.00',2,'E:\\foodimgs\\6.jpg','饼加鸡蛋豆皮！饼加鸡蛋豆皮！饼加鸡蛋豆皮！'),(10,'饼加鸡蛋豆皮',5,'12.00',2,'E:\\foodimgs\\7.jpg','饼加鸡蛋豆皮!饼加鸡蛋豆皮！饼加鸡蛋豆皮！');
UNLOCK TABLES;
/*!40000 ALTER TABLE `food` ENABLE KEYS */;

--
-- Table structure for table `foodcomment`
--

DROP TABLE IF EXISTS `foodcomment`;
CREATE TABLE `foodcomment` (
  `comment` char(255) NOT NULL,
  `foodid` int(11) default NULL,
  `level` int(11) default '2',
  `userid` int(11) default NULL,
  `time` timestamp NOT NULL default CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `foodcomment`
--


/*!40000 ALTER TABLE `foodcomment` DISABLE KEYS */;
LOCK TABLES `foodcomment` WRITE;
INSERT INTO `foodcomment` VALUES ('[o_o] 还不错',2,2,2,'2016-05-10 12:51:09'),('',2,1,2,'2016-05-22 01:43:09'),('[:,.] [:,.] [-.-] afsdfdsa',2,3,2,'2016-05-22 07:21:57');
UNLOCK TABLES;
/*!40000 ALTER TABLE `foodcomment` ENABLE KEYS */;

--
-- Table structure for table `orderform`
--

DROP TABLE IF EXISTS `orderform`;
CREATE TABLE `orderform` (
  `id` int(11) NOT NULL auto_increment,
  `foodid` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  `time` timestamp NOT NULL default CURRENT_TIMESTAMP,
  `status` int(11) unsigned zerofill NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `orderform`
--


/*!40000 ALTER TABLE `orderform` DISABLE KEYS */;
LOCK TABLES `orderform` WRITE;
INSERT INTO `orderform` VALUES (1,2,2,'2016-05-09 13:53:59',00000000002),(2,2,2,'2016-05-11 13:51:22',00000000002),(3,3,2,'2016-05-12 10:42:09',00000000002),(4,2,2,'2016-05-15 08:47:42',00000000002),(5,2,2,'2016-05-22 07:20:42',00000000001);
UNLOCK TABLES;
/*!40000 ALTER TABLE `orderform` ENABLE KEYS */;

--
-- Table structure for table `shopcomment`
--

DROP TABLE IF EXISTS `shopcomment`;
CREATE TABLE `shopcomment` (
  `id` int(11) NOT NULL auto_increment,
  `shopid` int(11) default NULL,
  `userid` int(11) default NULL,
  `level` int(11) default '2',
  `time` timestamp NOT NULL default CURRENT_TIMESTAMP,
  `comment` char(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `shopcomment`
--


/*!40000 ALTER TABLE `shopcomment` DISABLE KEYS */;
LOCK TABLES `shopcomment` WRITE;
INSERT INTO `shopcomment` VALUES (1,1,2,3,'2016-05-10 13:09:30','[t_t] nice 店主服务不错'),(2,1,2,3,'2016-05-10 13:11:35','[-_-zz] 哈哈收下了');
UNLOCK TABLES;
/*!40000 ALTER TABLE `shopcomment` ENABLE KEYS */;

--
-- Table structure for table `shope`
--

DROP TABLE IF EXISTS `shope`;
CREATE TABLE `shope` (
  `id` int(11) NOT NULL auto_increment,
  `name` char(255) NOT NULL,
  `paw` char(30) NOT NULL,
  `shopename` char(255) NOT NULL,
  `pnum` char(11) NOT NULL,
  `mail` char(30) NOT NULL,
  `adress` char(255) NOT NULL,
  `logopath` char(255) NOT NULL,
  `opened` tinyint(4) default '0',
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `shope`
--


/*!40000 ALTER TABLE `shope` DISABLE KEYS */;
LOCK TABLES `shope` WRITE;
INSERT INTO `shope` VALUES (1,'myd','root','博士圆','17839927862','786274022@qq.com','郑州大学新校区北门莲花街','E:\\shopimgs\\786274022@qq.com.jpg',1),(2,'jjtx0','jjtx','云南米线','17839927862','2991186645@qq.com','郑州高新区莲花街11号3幢1单元1层4号','E:\\shopimgs\\2991186645@qq.com.jpg',1),(3,'wer','123456','wer','17839927862','2991186645@qq.com','郑州大学','E:\\shopimgs\\2991186645@qq.com.jpg',1),(4,'','','','','','','',1);
UNLOCK TABLES;
/*!40000 ALTER TABLE `shope` ENABLE KEYS */;

--
-- Table structure for table `shope_temp`
--

DROP TABLE IF EXISTS `shope_temp`;
CREATE TABLE `shope_temp` (
  `name` char(30) NOT NULL,
  `paw` char(30) NOT NULL,
  `shopename` char(30) NOT NULL,
  `pnum` char(11) NOT NULL,
  `mail` char(30) NOT NULL,
  `adress` char(255) NOT NULL,
  `logopath` char(255) default NULL,
  PRIMARY KEY  (`mail`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `shope_temp`
--


/*!40000 ALTER TABLE `shope_temp` DISABLE KEYS */;
LOCK TABLES `shope_temp` WRITE;
INSERT INTO `shope_temp` VALUES ('','','','','','','');
UNLOCK TABLES;
/*!40000 ALTER TABLE `shope_temp` ENABLE KEYS */;

--
-- Table structure for table `shopping_cart`
--

DROP TABLE IF EXISTS `shopping_cart`;
CREATE TABLE `shopping_cart` (
  `id` int(11) NOT NULL auto_increment,
  `foodid` int(11) default NULL,
  `userid` int(11) default NULL,
  `time` timestamp NOT NULL default CURRENT_TIMESTAMP,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `shopping_cart`
--


/*!40000 ALTER TABLE `shopping_cart` DISABLE KEYS */;
LOCK TABLES `shopping_cart` WRITE;
INSERT INTO `shopping_cart` VALUES (1,2,1,'2016-05-08 01:34:12'),(3,3,2,'2016-05-22 07:20:01'),(4,5,2,'2016-05-22 07:20:04');
UNLOCK TABLES;
/*!40000 ALTER TABLE `shopping_cart` ENABLE KEYS */;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL auto_increment,
  `name` char(30) NOT NULL,
  `paw` char(30) NOT NULL,
  `pnum` char(11) NOT NULL,
  `adress` char(255) NOT NULL,
  `mail` char(30) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user`
--


/*!40000 ALTER TABLE `user` DISABLE KEYS */;
LOCK TABLES `user` WRITE;
INSERT INTO `user` VALUES (1,'jjtx','jxj','17839927862','郑州大学新校区松园20号楼111宿舍','786274022@qq.com'),(2,'hcc','jjtx','15083477751','云南大学新区（具体位置不清楚）','2991186645@qq.com');
UNLOCK TABLES;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

--
-- Table structure for table `user_temp`
--

DROP TABLE IF EXISTS `user_temp`;
CREATE TABLE `user_temp` (
  `name` char(30) NOT NULL,
  `paw` char(30) NOT NULL,
  `pnum` char(11) NOT NULL,
  `mail` char(30) NOT NULL,
  `adress` char(255) NOT NULL,
  PRIMARY KEY  (`mail`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `user_temp`
--


/*!40000 ALTER TABLE `user_temp` DISABLE KEYS */;
LOCK TABLES `user_temp` WRITE;
INSERT INTO `user_temp` VALUES ('2014','1234','15638250368','1643527025@qq.com','无'),('helloxj','helloxj','18625929818','675475017@qq.com','你猜'),('wlk','wlk','17839927862','876815784@qq.com','郑州大学新校区');
UNLOCK TABLES;
/*!40000 ALTER TABLE `user_temp` ENABLE KEYS */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

