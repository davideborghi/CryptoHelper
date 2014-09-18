-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generato il: Set 18, 2014 alle 22:57
-- Versione del server: 5.5.38-0ubuntu0.14.04.1
-- Versione PHP: 5.5.9-1ubuntu4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `cryptohelper`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `messaggio`
--

CREATE TABLE IF NOT EXISTS `messaggio` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_mittente` int(11) NOT NULL,
  `id_destinatario` int(11) NOT NULL,
  `testo` varchar(120) NOT NULL,
  `testoCifrato` varchar(120) NOT NULL,
  `lingua` varchar(120) NOT NULL,
  `titolo` varchar(120) NOT NULL,
  `bozza` tinyint(1) NOT NULL,
  `letto` tinyint(1) NOT NULL,
  `idsistemacifratura` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `id_mittente` (`id_mittente`),
  KEY `id_destinatario` (`id_destinatario`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=22 ;

--
-- Dump dei dati per la tabella `messaggio`
--

INSERT INTO `messaggio` (`id`, `id_mittente`, `id_destinatario`, `testo`, `testoCifrato`, `lingua`, `titolo`, `bozza`, `letto`, `idsistemacifratura`) VALUES
(19, 1, 3, 'bellaaaaaaaaaaaaa!!!!', 'bellaaaaaaaaaaaaa', 'Italiano', 'titoloDiProva', 0, 0, 0),
(20, 1, 2, 'ciao bob qui tutto a posto', 'rxp~ q~q ??x ????~ p ~??~', 'null', 'titoloDiProva', 0, 0, 0),
(21, 1, 2, 'ciao', 'rxp~', 'Italiano', 'titoloDiProva', 0, 0, 0);

-- --------------------------------------------------------

--
-- Struttura della tabella `proposta`
--

CREATE TABLE IF NOT EXISTS `proposta` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `id_mittente` varchar(120) NOT NULL,
  `id_destinatario` varchar(120) NOT NULL,
  `idsistemacifratura` int(11) NOT NULL,
  `stato` varchar(120) NOT NULL,
  `notificata` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `user_mittente` (`id_mittente`),
  KEY `user_destinatario` (`id_destinatario`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=11 ;

--
-- Dump dei dati per la tabella `proposta`
--

INSERT INTO `proposta` (`id`, `id_mittente`, `id_destinatario`, `idsistemacifratura`, `stato`, `notificata`) VALUES
(7, '1', '2', 5, 'accettata', NULL),
(8, '1', '3', 6, 'accettata', NULL),
(9, '1', '2', 7, 'accettata', NULL),
(10, '2', '3', 8, 'rifiutata', NULL);

-- --------------------------------------------------------

--
-- Struttura della tabella `Sessione`
--

CREATE TABLE IF NOT EXISTS `Sessione` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'unique ID',
  `userId` int(11) NOT NULL COMMENT 'user ID',
  `key` varchar(255) NOT NULL COMMENT 'Human Readable key',
  `session` blob NOT NULL COMMENT 'The serialized Session object',
  PRIMARY KEY (`id`),
  UNIQUE KEY `userId` (`userId`,`key`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Struttura della tabella `sistemacifratura`
--

CREATE TABLE IF NOT EXISTS `sistemacifratura` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `chiave` varchar(120) NOT NULL,
  `metodo` varchar(120) NOT NULL,
  `idcreatore` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Dump dei dati per la tabella `sistemacifratura`
--

INSERT INTO `sistemacifratura` (`id`, `chiave`, `metodo`, `idcreatore`) VALUES
(5, '15', 'Sistema di cesare', 1),
(6, '0', 'Sistema di cesare', 1),
(7, 'ciaao', 'Parola chiave', 1),
(8, '30', 'Sistema di cesare', 2);

-- --------------------------------------------------------

--
-- Struttura della tabella `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(120) NOT NULL AUTO_INCREMENT,
  `username` varchar(120) NOT NULL,
  `password` varchar(120) NOT NULL,
  `nome` varchar(120) DEFAULT NULL,
  `cognome` varchar(120) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Dump dei dati per la tabella `user`
--

INSERT INTO `user` (`id`, `username`, `password`, `nome`, `cognome`) VALUES
(1, 'roberto', 'root', NULL, NULL),
(2, 'bob', 'root', NULL, NULL),
(3, 'davide', 'prova', NULL, NULL);

--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `messaggio`
--
ALTER TABLE `messaggio`
  ADD CONSTRAINT `messaggio_ibfk_1` FOREIGN KEY (`id_mittente`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `messaggio_ibfk_2` FOREIGN KEY (`id_destinatario`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
