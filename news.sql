-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.1.34-MariaDB-0ubuntu0.18.04.1 - Ubuntu 18.04
-- Server OS:                    debian-linux-gnu
-- HeidiSQL Version:             9.5.0.5196
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Dumping structure for table news.category
CREATE TABLE IF NOT EXISTS `category` (
  `c_id` int(11) NOT NULL AUTO_INCREMENT,
  `c_name` varchar(50) DEFAULT NULL,
  `c_description` varchar(150) DEFAULT NULL,
  `c_created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `c_updated_at` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`c_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table news.category: ~1 rows (approximately)
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
REPLACE INTO `category` (`c_id`, `c_name`, `c_description`, `c_created_at`, `c_updated_at`) VALUES
	(1, 'Tech', 'this is the description', '2019-03-08 13:38:50', NULL),
	(10, 'Math', 'All about math', '2019-03-08 21:11:38', NULL),
	(13, 'Sport', 'All about sport', '2019-03-08 21:32:17', NULL);
/*!40000 ALTER TABLE `category` ENABLE KEYS */;

-- Dumping structure for table news.news
CREATE TABLE IF NOT EXISTS `news` (
  `n_id` int(11) NOT NULL AUTO_INCREMENT,
  `n_c_id` int(11) DEFAULT NULL,
  `n_u_id` int(11) DEFAULT NULL,
  `n_title` varchar(100) DEFAULT NULL,
  `n_description` text,
  `n_created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `n_updated_at` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`n_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table news.news: ~0 rows (approximately)
/*!40000 ALTER TABLE `news` DISABLE KEYS */;
REPLACE INTO `news` (`n_id`, `n_c_id`, `n_u_id`, `n_title`, `n_description`, `n_created_at`, `n_updated_at`) VALUES
	(1, 1, 8, 'New iPhone XZ', 'iPhone iPhone iPhone iPhone iPhone iPhone iPhone iPhone iPhone iPhone iPhone iPhone iPhone iPhone iPhone iPhone iPhone iPhone iPhone iPhone iPhone iPhone iPhone iPhone iPhone iPhone ', '2019-03-08 15:53:33', NULL),
	(2, 1, 8, 'akdjsl', 'kajdlkasjdlkas', '2019-03-08 16:22:19', NULL),
	(3, 1, 8, 'Jagoan Doang', 'cerita tengtang jagoan kalian dimasa sulit', '2019-03-08 18:39:31', '2019-03-08 20:38:02'),
	(4, 1, 8, 'Jagoan Neon', 'lkjdsflkja sdfkl adslfkj asdlkfj adsklfj lads fsda f', '2019-03-08 21:05:43', NULL);
/*!40000 ALTER TABLE `news` ENABLE KEYS */;

-- Dumping structure for table news.users
CREATE TABLE IF NOT EXISTS `users` (
  `u_id` int(11) NOT NULL AUTO_INCREMENT,
  `u_username` varchar(50) DEFAULT NULL,
  `u_name` varchar(100) DEFAULT NULL,
  `u_password` varchar(150) DEFAULT NULL,
  `u_gender` enum('Laki-laki','Perempuan') DEFAULT NULL,
  `u_created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `u_updated_at` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`u_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table news.users: ~3 rows (approximately)
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
REPLACE INTO `users` (`u_id`, `u_username`, `u_name`, `u_password`, `u_gender`, `u_created_at`, `u_updated_at`) VALUES
	(8, 'figarjanuar', 'Figar JR', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', 'Laki-laki', '2019-03-08 13:29:53', '2019-03-08 13:34:40'),
	(9, 'figarjanuar2', 'Figar Januari R.', '18138372fad4b94533cd4881f03dc6c69296dd897234e0cee83f727e2e6b1f63', 'Laki-laki', '2019-03-08 13:29:53', NULL),
	(10, 'erna', 'Siti Erna Wati', 'fbab199c48b68362b780c7b29337742ab1701ed4939102b3d3c92fda6d975f4a', 'Perempuan', '2019-03-08 13:29:53', NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
