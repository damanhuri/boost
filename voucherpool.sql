-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.1.37-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win32
-- HeidiSQL Version:             11.3.0.6295
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Dumping structure for table voucherpool.receipient
CREATE TABLE IF NOT EXISTS `receipient` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE armscii8_bin NOT NULL,
  `email` varchar(100) COLLATE armscii8_bin NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin;

-- Dumping data for table voucherpool.receipient: ~0 rows (approximately)
/*!40000 ALTER TABLE `receipient` DISABLE KEYS */;
INSERT INTO `receipient` (`id`, `name`, `email`) VALUES
	(1, 'Ali', 'ali@gmail.com'),
	(4, 'Abu', 'abu@gmail.com');
/*!40000 ALTER TABLE `receipient` ENABLE KEYS */;

-- Dumping structure for table voucherpool.special_offer
CREATE TABLE IF NOT EXISTS `special_offer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE armscii8_bin NOT NULL,
  `discount` decimal(5,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin;

-- Dumping data for table voucherpool.special_offer: ~0 rows (approximately)
/*!40000 ALTER TABLE `special_offer` DISABLE KEYS */;
INSERT INTO `special_offer` (`id`, `name`, `discount`) VALUES
	(1, 'CNY Offer', 12.50),
	(2, 'Raya Offer', 12.50),
	(3, '11.11 Offer', 12.50),
	(4, 'Merdeka Offer', 12.50);
/*!40000 ALTER TABLE `special_offer` ENABLE KEYS */;

-- Dumping structure for table voucherpool.voucher_code
CREATE TABLE IF NOT EXISTS `voucher_code` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `code` varchar(50) COLLATE armscii8_bin NOT NULL,
  `receipient_id` int(11) NOT NULL,
  `special_offer_id` int(11) NOT NULL,
  `expiry_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `usage_date` timestamp NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_voucher_code_receipient` (`receipient_id`),
  KEY `FK_voucher_code_special_offer` (`special_offer_id`),
  CONSTRAINT `FK_voucher_code_receipient` FOREIGN KEY (`receipient_id`) REFERENCES `receipient` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_voucher_code_special_offer` FOREIGN KEY (`special_offer_id`) REFERENCES `special_offer` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=armscii8 COLLATE=armscii8_bin COMMENT='voucher_code';

-- Dumping data for table voucherpool.voucher_code: ~0 rows (approximately)
/*!40000 ALTER TABLE `voucher_code` DISABLE KEYS */;
INSERT INTO `voucher_code` (`id`, `code`, `receipient_id`, `special_offer_id`, `expiry_date`, `usage_date`) VALUES
	(1, '1df64495bf404605b231d6016db154eb', 1, 1, '2022-02-28 08:00:00', '2022-02-14 00:47:16'),
	(2, '8d21b98f8ac5444994738f6bba3694b6', 4, 1, '2022-02-28 08:00:00', NULL),
	(3, '536a449b44a84be7a7aa947e51a2738f', 1, 2, '2022-02-14 00:40:25', NULL),
	(4, '953c622dcaef475fa6856c0336195e78', 4, 2, '2022-02-14 00:40:25', NULL),
	(5, '154ac3971c0d43f997ed00ff6b41df0e', 1, 3, '2022-02-14 00:44:51', NULL),
	(6, 'd05080f599774746b65057b7bc5d8039', 4, 3, '2022-02-14 00:44:51', NULL),
	(7, 'fd32d1e159c04e4993c93d6a772dc3a9', 1, 4, '2022-02-14 00:47:16', NULL),
	(8, 'da6788665bf4430abde7c3f69e19f7b8', 4, 4, '2022-02-14 00:47:16', NULL);
/*!40000 ALTER TABLE `voucher_code` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
