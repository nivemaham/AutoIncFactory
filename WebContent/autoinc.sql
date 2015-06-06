-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               5.6.17 - MySQL Community Server (GPL)
-- Server OS:                    Win64
-- HeidiSQL Version:             8.3.0.4821
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping database structure for autoinc
CREATE DATABASE IF NOT EXISTS `autoinc` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `autoinc`;


-- Dumping structure for table autoinc.address
CREATE TABLE IF NOT EXISTS `address` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `addline1` varchar(50) NOT NULL,
  `addline2` varchar(50) NOT NULL DEFAULT '0',
  `city` varchar(50) NOT NULL DEFAULT '0',
  `country` varchar(50) NOT NULL DEFAULT '0',
  `zipcode` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- Dumping data for table autoinc.address: ~6 rows (approximately)
/*!40000 ALTER TABLE `address` DISABLE KEYS */;
INSERT INTO `address` (`id`, `addline1`, `addline2`, `city`, `country`, `zipcode`) VALUES
	(1, 'Hind Nagar', 'Hidcnd Nagar', 'Lucknow', '0', 'aaaaaaa'),
	(2, 'arvis 22', 'Heraklion', 'Heraklion', 'Greece', '71305'),
	(3, ' Champ de Mars ', '5 Avenue Anatole France', 'Paris ', 'France', '75007 '),
	(4, 'New supplier 1', '79, Main road', 'Stuttgart', 'Germany', '70569'),
	(5, 'New supplier 1', '79, Main road', 'Stuttgart', 'Germany', '70569'),
	(6, 'New supplier 1', '79, Fake street', 'Pisa', 'Italy', '70569');
/*!40000 ALTER TABLE `address` ENABLE KEYS */;


-- Dumping structure for table autoinc.country
CREATE TABLE IF NOT EXISTS `country` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `country` varchar(40) NOT NULL,
  `captial` varchar(20) NOT NULL,
  `latitude` varchar(20) NOT NULL,
  `logitude` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table autoinc.country: ~0 rows (approximately)
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
/*!40000 ALTER TABLE `country` ENABLE KEYS */;


-- Dumping structure for table autoinc.customer
CREATE TABLE IF NOT EXISTS `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL DEFAULT '0',
  `name` varchar(50) NOT NULL DEFAULT '0',
  `addressid` int(11) NOT NULL DEFAULT '0',
  `contactnumber` int(15) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `userid_FK` (`userid`),
  KEY `addressid_FK` (`addressid`),
  CONSTRAINT `addressid_FK` FOREIGN KEY (`addressid`) REFERENCES `address` (`id`),
  CONSTRAINT `userid_FK` FOREIGN KEY (`userid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table autoinc.customer: ~0 rows (approximately)
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;


-- Dumping structure for table autoinc.deliveryoffers
CREATE TABLE IF NOT EXISTS `deliveryoffers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `supplierid` int(11) NOT NULL DEFAULT '0',
  `servicelevel` varchar(50) NOT NULL DEFAULT '0',
  `costperunit` float NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `supplier-FK` (`supplierid`),
  CONSTRAINT `supplier-FK` FOREIGN KEY (`supplierid`) REFERENCES `supplier` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table autoinc.deliveryoffers: ~1 rows (approximately)
/*!40000 ALTER TABLE `deliveryoffers` DISABLE KEYS */;
INSERT INTO `deliveryoffers` (`id`, `supplierid`, `servicelevel`, `costperunit`) VALUES
	(1, 3, 'HOME_DELIVERY', 50);
/*!40000 ALTER TABLE `deliveryoffers` ENABLE KEYS */;


-- Dumping structure for table autoinc.inventory
CREATE TABLE IF NOT EXISTS `inventory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `warehouseId` int(11) NOT NULL DEFAULT '0',
  `productSpecId` int(11) NOT NULL DEFAULT '0',
  `quantity` int(5) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `productSpecId` (`productSpecId`),
  KEY `warehouse-fk` (`warehouseId`),
  CONSTRAINT `productSpecId` FOREIGN KEY (`productSpecId`) REFERENCES `product` (`id`),
  CONSTRAINT `warehouse-fk` FOREIGN KEY (`warehouseId`) REFERENCES `warehouse` (`warehouseid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Dumping data for table autoinc.inventory: ~5 rows (approximately)
/*!40000 ALTER TABLE `inventory` DISABLE KEYS */;
INSERT INTO `inventory` (`id`, `warehouseId`, `productSpecId`, `quantity`) VALUES
	(1, 2, 2, 13),
	(2, 1, 2, 10),
	(3, 2, 3, 5),
	(4, 2, 4, 5),
	(5, 2, 4, 5);
/*!40000 ALTER TABLE `inventory` ENABLE KEYS */;


-- Dumping structure for table autoinc.order
CREATE TABLE IF NOT EXISTS `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `customerid` int(11) DEFAULT '0',
  `productid` int(11) DEFAULT '0',
  `supplier` int(11) DEFAULT '0',
  `orderstatus` varchar(50) DEFAULT '0',
  `totalcost` double DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `customer-fk` (`customerid`),
  KEY `product-fk` (`productid`),
  KEY `sup-fk` (`supplier`),
  CONSTRAINT `sup-fk` FOREIGN KEY (`supplier`) REFERENCES `supplier` (`id`),
  CONSTRAINT `customer-fk` FOREIGN KEY (`customerid`) REFERENCES `customer` (`id`),
  CONSTRAINT `product-fk` FOREIGN KEY (`productid`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table autoinc.order: ~0 rows (approximately)
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
/*!40000 ALTER TABLE `order` ENABLE KEYS */;


-- Dumping structure for table autoinc.product
CREATE TABLE IF NOT EXISTS `product` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `modelnumber` varchar(20) NOT NULL,
  `imageurl` varchar(100) NOT NULL,
  `manufacturer` varchar(30) NOT NULL,
  `brand` varchar(10) NOT NULL,
  `price` int(10) NOT NULL,
  `color` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

-- Dumping data for table autoinc.product: ~4 rows (approximately)
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` (`id`, `modelnumber`, `imageurl`, `manufacturer`, `brand`, `price`, `color`) VALUES
	(1, 'KZ240', 'imageUrl', 'Asian Regional MHQ', 'AutoInc', 25000, 'Red'),
	(2, 'KZ240', 'imageUrl', 'Asian Regional MHQ', 'AutoInc', 25000, 'Red'),
	(3, 'KZ240', 'imageUrl', 'Asian Regional MHQ', 'AutoInc', 25000, 'Red'),
	(4, 'KZ240', 'imageUrl', 'Asian Regional MHQ', 'AutoInc', 25000, 'Red'),
	(5, 'KZ240', 'imageUrl', 'Asian Regional MHQ', 'AutoInc', 25000, 'Red');
/*!40000 ALTER TABLE `product` ENABLE KEYS */;


-- Dumping structure for table autoinc.productdetails
CREATE TABLE IF NOT EXISTS `productdetails` (
  `productid` int(11) NOT NULL,
  `engine` varchar(25) NOT NULL,
  `type` varchar(25) NOT NULL,
  `bodystyle` varchar(25) NOT NULL,
  `mileage` int(10) NOT NULL,
  KEY `productkey` (`productid`),
  CONSTRAINT `productkey` FOREIGN KEY (`productid`) REFERENCES `product` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table autoinc.productdetails: ~4 rows (approximately)
/*!40000 ALTER TABLE `productdetails` DISABLE KEYS */;
INSERT INTO `productdetails` (`productid`, `engine`, `type`, `bodystyle`, `mileage`) VALUES
	(2, 'c3000', 'aliance', 'sport', 800),
	(3, 'c3000', 'aliance', 'sport', 800),
	(4, 'c3000', 'aliance', 'sport', 800),
	(5, 'c3000', 'aliance', 'sport', 800);
/*!40000 ALTER TABLE `productdetails` ENABLE KEYS */;


-- Dumping structure for table autoinc.shoppingcart
CREATE TABLE IF NOT EXISTS `shoppingcart` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `productids` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table autoinc.shoppingcart: ~0 rows (approximately)
/*!40000 ALTER TABLE `shoppingcart` DISABLE KEYS */;
/*!40000 ALTER TABLE `shoppingcart` ENABLE KEYS */;


-- Dumping structure for table autoinc.supplier
CREATE TABLE IF NOT EXISTS `supplier` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `location` int(11) NOT NULL,
  `serviceurl` varchar(100) NOT NULL,
  `suppliername` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `location_FK` (`location`),
  CONSTRAINT `location_FK` FOREIGN KEY (`location`) REFERENCES `address` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

-- Dumping data for table autoinc.supplier: ~3 rows (approximately)
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` (`id`, `location`, `serviceurl`, `suppliername`) VALUES
	(1, 4, 'someUrl', NULL),
	(2, 5, 'someUrl', 'FedEx'),
	(3, 6, 'someUrl', 'edEx');
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;


-- Dumping structure for table autoinc.transportationstatus
CREATE TABLE IF NOT EXISTS `transportationstatus` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderId` int(11) DEFAULT NULL,
  `shippingstatus` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `order-fk` (`orderId`),
  CONSTRAINT `order-fk` FOREIGN KEY (`orderId`) REFERENCES `order` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table autoinc.transportationstatus: ~0 rows (approximately)
/*!40000 ALTER TABLE `transportationstatus` DISABLE KEYS */;
/*!40000 ALTER TABLE `transportationstatus` ENABLE KEYS */;


-- Dumping structure for table autoinc.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `emailaddress` varchar(50) NOT NULL DEFAULT '0',
  `role` varchar(50) NOT NULL DEFAULT '0',
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- Dumping data for table autoinc.user: ~0 rows (approximately)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;


-- Dumping structure for table autoinc.warehouse
CREATE TABLE IF NOT EXISTS `warehouse` (
  `warehouseid` int(11) NOT NULL AUTO_INCREMENT,
  `locationid` int(11) NOT NULL DEFAULT '0',
  `capacity` int(11) NOT NULL DEFAULT '0',
  `serviceurl` varchar(100) NOT NULL DEFAULT '0',
  PRIMARY KEY (`warehouseid`),
  KEY `location-fk` (`locationid`),
  CONSTRAINT `location-fk` FOREIGN KEY (`locationid`) REFERENCES `address` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- Dumping data for table autoinc.warehouse: ~2 rows (approximately)
/*!40000 ALTER TABLE `warehouse` DISABLE KEYS */;
INSERT INTO `warehouse` (`warehouseid`, `locationid`, `capacity`, `serviceurl`) VALUES
	(1, 2, 50, 'http:localhost:someurl'),
	(2, 3, 100, 'http:localhost:otherurl');
/*!40000 ALTER TABLE `warehouse` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
