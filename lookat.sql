-- phpMyAdmin SQL Dump
-- version 4.1.4
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Nov 07, 2014 at 02:42 AM
-- Server version: 5.6.15-log
-- PHP Version: 5.5.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `lookat`
--
CREATE DATABASE IF NOT EXISTS `lookat` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `lookat`;

-- --------------------------------------------------------

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
CREATE TABLE IF NOT EXISTS `categories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(300) CHARACTER SET latin1 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `categories`
--

INSERT INTO `categories` (`id`, `nom`) VALUES
(1, 'Mode'),
(2, 'Sport'),
(3, 'I-Tech'),
(4, 'Monde'),
(5, 'France'),
(6, 'Cinéma'),
(7, 'People'),
(8, 'Jeux');

-- --------------------------------------------------------

--
-- Table structure for table `commentaires`
--

DROP TABLE IF EXISTS `commentaires`;
CREATE TABLE IF NOT EXISTS `commentaires` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `etoile` int(11) NOT NULL DEFAULT '0',
  `idSite` int(11) NOT NULL,
  `contenu` varchar(1000) NOT NULL,
  `idUser` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idSite` (`idSite`),
  KEY `idUser` (`idUser`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

--
-- Dumping data for table `commentaires`
--

INSERT INTO `commentaires` (`id`, `etoile`, `idSite`, `contenu`, `idUser`) VALUES
(5, 4, 54, 'héhé', 37),
(6, 5, 59, 'Juste énorme !', 37);

-- --------------------------------------------------------

--
-- Table structure for table `site`
--

DROP TABLE IF EXISTS `site`;
CREATE TABLE IF NOT EXISTS `site` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(300) CHARACTER SET latin1 NOT NULL,
  `nom` varchar(300) CHARACTER SET latin1 DEFAULT NULL,
  `description` varchar(1000) CHARACTER SET utf8mb4 DEFAULT NULL,
  `idCat` int(11) NOT NULL,
  `nbClick` int(11) NOT NULL DEFAULT '0',
  `idUser` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idCategorie` (`idCat`),
  KEY `idUser` (`idUser`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=60 ;

--
-- Dumping data for table `site`
--

INSERT INTO `site` (`id`, `url`, `nom`, `description`, `idCat`, `nbClick`, `idUser`) VALUES
(54, 'http://www.lequipe.fr/', 'L''équipe', 'Site d''actualité de sport en tout genre : foot, rugby, cyclisme, basket, F1 etc..\r\n\r\nClassement, live et bien d''autres', 2, 21, 37),
(55, 'http://www.google.fr', 'Google', 'Le meilleurs des moteurs de recherche', 4, 2, 37),
(56, 'http://www.allocine.fr/', 'Allo Ciné', 'Site de Cinéma pour voir les bandes annonces et les horraires', 6, 1, 37),
(57, 'http://www.stream-foot.fr/', 'Stream Foot', 'Site pour voir le football payant gratuitement en streaming', 2, 8, 37),
(58, 'http://www.motoplanete.com/', 'Moto Planete', 'Site d''actualité Moto, description, nouveautés, prix de vente etc..', 2, 7, 37),
(59, 'http://iphoneaddict.fr/', 'IPhoneAddict', 'Un des meilleurs site d''actualités iPhone : Jailbreak, promotions, infos, retranscription en direct des KeyNotes etc..', 3, 1, 37);

-- --------------------------------------------------------

--
-- Table structure for table `utilisateurs`
--

DROP TABLE IF EXISTS `utilisateurs`;
CREATE TABLE IF NOT EXISTS `utilisateurs` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pseudo` varchar(300) NOT NULL,
  `password` varchar(300) NOT NULL,
  `email` varchar(300) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=38 ;

--
-- Dumping data for table `utilisateurs`
--

INSERT INTO `utilisateurs` (`id`, `pseudo`, `password`, `email`) VALUES
(37, 'Sonii', '123456', 'remond@et.esiea.fr');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `commentaires`
--
ALTER TABLE `commentaires`
  ADD CONSTRAINT `commentaires_ibfk_1` FOREIGN KEY (`idSite`) REFERENCES `site` (`id`),
  ADD CONSTRAINT `commentaires_ibfk_2` FOREIGN KEY (`idUser`) REFERENCES `utilisateurs` (`id`);

--
-- Constraints for table `site`
--
ALTER TABLE `site`
  ADD CONSTRAINT `categorie` FOREIGN KEY (`idCat`) REFERENCES `categories` (`id`),
  ADD CONSTRAINT `site_ibfk_1` FOREIGN KEY (`idUser`) REFERENCES `utilisateurs` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
