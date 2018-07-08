/*
SQLyog Ultimate v12.09 (64 bit)
MySQL - 6.0.11-alpha-community : Database - test
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
DROP DATABASE IF EXISTS `test`;
CREATE DATABASE `test` ;

USE `test`;

/*Table structure for table `flight` */

DROP TABLE IF EXISTS `flight`;

CREATE TABLE `flight` (
  `flightNum` varchar(20) NOT NULL DEFAULT '',
  `flightPrice` int(10) DEFAULT NULL,
  `numSeats` int(10) DEFAULT NULL,
  `flightnumAvail` int(10) DEFAULT NULL,
  `flyDate` date DEFAULT NULL,
  `flyfromCity` varchar(20) DEFAULT NULL,
  `flytoCity` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`flightNum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `flight` */

insert into `flight`(`flightNum`,`flightPrice`,`numSeats`,`flightnumAvail`,`flyDate`,`flyfromCity`,`flytoCity`) values ('nj21',12,2,1,'2012-09-21','as','aw'),('TV6686',872,212,21,'2018-01-22','成都','北京'),('ZH9772',776,31,31,'2018-01-03','南昌','云南'),('ZG9236',730,56,78,'2018-02-04','西安','云南');

/*Table structure for table `hotel` */

DROP TABLE IF EXISTS `hotel`;

CREATE TABLE `hotel` (
  `hotelNum` varchar(20) NOT NULL DEFAULT '',
  `hotelName` varchar(20) DEFAULT NULL,
  `hotelCity` varchar(20) DEFAULT NULL,
  `hotelStar` varchar(20) DEFAULT NULL,
  `hotelPrice` int(10) DEFAULT NULL,
  `hotelnumRooms` int(10) DEFAULT NULL,
  `HotelnumAvail` int(20) DEFAULT NULL,
  `hotelConnectWay` varchar(20) DEFAULT NULL,
  `hotelPhone` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`hotelNum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `hotel` */

insert  into `hotel`(`hotelNum`,`hotelName`,`hotelCity`,`hotelStar`,`hotelPrice`,`hotelnumRooms`,`HotelnumAvail`,`hotelConnectWay`,`hotelPhone`) values ('131313','国际旅行社','南昌','五星',133,218,21,'李白','1271313'),('233363','东方旅行社','上饶','四星',156,289,29,'杜甫','1445673'),('234561','西方旅行社','北京','三星',523,589,53,'辛弃疾','4353455'),('233783','东方旅行社','上海','六星',234,345,79,'陆游','4562389');

/*Table structure for table `journeyuser` */

DROP TABLE IF EXISTS `journeyuser`;

CREATE TABLE `journeyuser` (
  `userId` int(10) NOT NULL AUTO_INCREMENT,
  `userName` varchar(20) DEFAULT NULL,
  `sex` varchar(20) DEFAULT NULL,
  `age` int(10) DEFAULT NULL,
  `identifyNo` varchar(20) DEFAULT NULL,
  `phone` int(10) DEFAULT NULL,
  `password` varchar(20) NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `journeyuser` */

insert  into `journeyuser`(`userId`,`userName`,`sex`,`age`,`identifyNo`,`phone`,`password`) values (1,'liang','男',2121,'2121',2112,'123'),(2,'冯亮','男',24,'131',21,'123'),(3,'强哥','男',12,'31',21,'123'),(4,'moji','男',26,'213',123,'123'),(5,'刘哥','男',28,'674',21,'abc');

/*Table structure for table `reservation` */

DROP TABLE IF EXISTS `reservation`;

CREATE TABLE `reservation` (
  `reservatId` int(10) NOT NULL AUTO_INCREMENT,
  `r_userId` int(10) DEFAULT NULL,
  `r_userName` varchar(20) DEFAULT NULL,
  `restype` varchar(20) NOT NULL,
  `associateId` varchar(20) NOT NULL,
  `resStatus` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`reservatId`),
  KEY `r_userId` (`r_userId`),
  CONSTRAINT `reservation_ibfk_1` FOREIGN KEY (`r_userId`) REFERENCES `journeyuser` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `reservation` */

insert  into `reservation`(`reservatId`,`r_userId`,`r_userName`,`restype`,`associateId`,`resStatus`) values (1,2,'墨迹','F','TV6686','成功'),(2,2,'墨迹','H','131313','成功'),(3,2,'墨迹','T','赣A2213','成功');

/*Table structure for table `transfor` */

DROP TABLE IF EXISTS `transfor`;

CREATE TABLE `transfor` (
  `carNum` varchar(20) NOT NULL DEFAULT '',
  `cartype` varchar(20) DEFAULT NULL,
  `CarFrom` varchar(20) DEFAULT NULL,
  `CarTO` varchar(20) DEFAULT NULL,
  `carPrice` int(10) DEFAULT NULL,
  `carNumAvail` int(20) DEFAULT NULL,
  PRIMARY KEY (`carNum`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `transfor` */

insert  into `transfor`(`carNum`,`cartype`,`CarFrom`,`CarTO`,`carPrice`,`carNumAvail`) values ('赣A2113','出租车','机场','酒店',10,21),('苏A2453','出租车','机场','度假村',10,56),('赣B4513','轿车','机场','宾馆',10,25);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
