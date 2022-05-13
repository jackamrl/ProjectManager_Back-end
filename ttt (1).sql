-- phpMyAdmin SQL Dump
-- version 4.9.7
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: May 13, 2022 at 12:21 AM
-- Server version: 5.7.36
-- PHP Version: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ttt`
--

-- --------------------------------------------------------

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
CREATE TABLE IF NOT EXISTS `company` (
  `id_company` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `company_name` varchar(200) NOT NULL,
  PRIMARY KEY (`id_company`)
) ENGINE=MyISAM AUTO_INCREMENT=42 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `company`
--

INSERT INTO `company` (`id_company`, `company_name`) VALUES
(14, 'defi'),
(3, 'Merge Test Company New Name'),
(15, 'nicshop'),
(16, 'jackdesign'),
(17, 'jackconsulting'),
(22, 'licence3'),
(23, 'aaaa'),
(24, 'bbb'),
(38, 'defi informatique'),
(37, 'akif'),
(36, 'bòyò'),
(40, 'bb lome'),
(39, 'snb'),
(35, 'ffff'),
(33, 'oda milk'),
(34, 'Mhez shop'),
(41, 'brillant shop');

-- --------------------------------------------------------

--
-- Table structure for table `project`
--

DROP TABLE IF EXISTS `project`;
CREATE TABLE IF NOT EXISTS `project` (
  `id_project` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `project_name` varchar(200) NOT NULL,
  `id_company` int(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`id_project`),
  KEY `FKboddo7ysfscupbnhxjtirb1aj` (`id_company`)
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `project`
--

INSERT INTO `project` (`id_project`, `project_name`, `id_company`) VALUES
(1, 'developpement de site web', 14),
(2, 'redaction d\'appel d\'offre', 16),
(3, 'commande de marchandise', 16),
(4, 'Production de lait', 33),
(5, 'Préparation de couscous', 33),
(6, 'Préparation ', 36),
(7, 'maquette', 36),
(8, 'design', 36),
(9, 'new project', 36),
(10, 'projet lune', 36),
(11, 'aaa', 15),
(12, 'k', 16);

-- --------------------------------------------------------

--
-- Table structure for table `task`
--

DROP TABLE IF EXISTS `task`;
CREATE TABLE IF NOT EXISTS `task` (
  `id_task` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_project` int(10) UNSIGNED NOT NULL,
  `task_name` varchar(200) NOT NULL,
  PRIMARY KEY (`id_task`),
  KEY `FK71wpakscks910bw227hjuk7kf` (`id_project`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `task`
--

INSERT INTO `task` (`id_task`, `id_project`, `task_name`) VALUES
(1, 1, 'reunion'),
(3, 1, 'analyse\r\n'),
(4, 2, 'Entretien'),
(5, 1, 'conception '),
(6, 1, 'test unitaires'),
(7, 1, 'Developpemnt Back-end'),
(8, 1, 'Developpemnt Front-end'),
(9, 2, 'Maquette web'),
(10, 2, 'Maquette mobile');

-- --------------------------------------------------------

--
-- Table structure for table `task_log`
--

DROP TABLE IF EXISTS `task_log`;
CREATE TABLE IF NOT EXISTS `task_log` (
  `id_task_log` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `id_task` int(10) UNSIGNED NOT NULL,
  `username` varchar(10) NOT NULL,
  `task_description` varchar(2000) NOT NULL,
  `task_log_date` date NOT NULL,
  `task_minutes` int(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`id_task_log`),
  KEY `FKbc3nqom2et6fghvdatd2vjgxk` (`id_task`),
  KEY `FKrtftjoxivhypnmgj9eajvwje8` (`username`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `task_log`
--

INSERT INTO `task_log` (`id_task_log`, `id_task`, `username`, `task_description`, `task_log_date`, `task_minutes`) VALUES
(1, 1, 'jackdev', 'Cahier des charges', '2022-04-06', 50),
(2, 1, 'louissem', 'good', '2022-04-06', 5),
(3, 3, 'jackdev', 'Elaboration du prototype', '2022-03-08', 350),
(4, 3, 'jackdev', 'Analyse et conception', '2022-03-17', 222),
(5, 3, 'jackdev', 'Diagrammes UML', '2022-04-01', 120),
(6, 3, 'louissem', 'Création de la bdd', '2022-04-05', 500),
(7, 3, 'jackdev', 'Développement Back end', '2022-04-11', 150),
(8, 3, 'jackdev', 'Test unitaires', '2022-04-19', 514),
(9, 3, 'jackdev', 'Intégration front-end', '2022-05-01', 600),
(10, 7, 'jackdev', 'Repository\r\n', '2022-05-02', 520),
(11, 7, 'jackdev', 'Controller', '2022-05-02', 250);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `username` varchar(10) NOT NULL,
  `first_name` varchar(100) NOT NULL,
  `last_name` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `admin_role` char(1) NOT NULL,
  PRIMARY KEY (`username`),
  UNIQUE KEY `email` (`email`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`username`, `first_name`, `last_name`, `email`, `password`, `admin_role`) VALUES
('JackDev', 'Jacques', 'Boyodi', 'amrlbyctt@gmail.com', '2507', 'Y'),
('louissem', 'louis', 'semeglo', 'louis@gmail.com', '1234', 'n');

-- --------------------------------------------------------

--
-- Table structure for table `user_log`
--

DROP TABLE IF EXISTS `user_log`;
CREATE TABLE IF NOT EXISTS `user_log` (
  `id_user_log` int(11) NOT NULL AUTO_INCREMENT,
  `ip_address` varchar(255) NOT NULL,
  `log_date` datetime DEFAULT NULL,
  `status` char(1) NOT NULL,
  `username` varchar(255) NOT NULL,
  PRIMARY KEY (`id_user_log`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
