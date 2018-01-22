/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.1.62-community : Database - db_votemanager
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`db_votemanager` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `db_votemanager`;

/*Table structure for table `tb_channel` */

DROP TABLE IF EXISTS `tb_channel`;

CREATE TABLE `tb_channel` (
  `channel_id` int(11) NOT NULL AUTO_INCREMENT,
  `channel_name` varchar(30) NOT NULL DEFAULT '',
  PRIMARY KEY (`channel_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `tb_channel` */

insert  into `tb_channel`(`channel_id`,`channel_name`) values (1,'NBA'),(2,'CBA'),(3,'足球世界杯'),(4,'中超'),(5,'英超'),(6,'F1');

/*Table structure for table `tb_vote` */

DROP TABLE IF EXISTS `tb_vote`;

CREATE TABLE `tb_vote` (
  `vote_id` int(11) NOT NULL AUTO_INCREMENT,
  `vote_name` varchar(30) NOT NULL DEFAULT '',
  `channel_id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`vote_id`),
  KEY `channel_id` (`channel_id`),
  CONSTRAINT `tb_vote_ibfk_1` FOREIGN KEY (`channel_id`) REFERENCES `tb_channel` (`channel_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `tb_vote` */

insert  into `tb_vote`(`vote_id`,`vote_name`,`channel_id`) values (3,'最喜欢的球队',1),(4,'最看好的球队',3),(5,'最喜欢的球星',1);

/*Table structure for table `tb_voteoption` */

DROP TABLE IF EXISTS `tb_voteoption`;

CREATE TABLE `tb_voteoption` (
  `voteoption_id` int(11) NOT NULL AUTO_INCREMENT,
  `voteoption_name` varchar(30) NOT NULL DEFAULT '',
  `vote_id` int(11) NOT NULL DEFAULT '0',
  `ticket_num` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`voteoption_id`),
  KEY `vote_id` (`vote_id`),
  CONSTRAINT `tb_voteoption_ibfk_1` FOREIGN KEY (`vote_id`) REFERENCES `tb_vote` (`vote_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `tb_voteoption` */

insert  into `tb_voteoption`(`voteoption_id`,`voteoption_name`,`vote_id`,`ticket_num`) values (8,'rocket',3,4),(9,'laker',3,6),(10,'heat',3,8),(11,'巴西',4,9),(12,'中国',4,12),(13,'德国',4,453),(14,'乔丹',5,324),(15,'科比',5,34),(16,'马龙',5,45);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
