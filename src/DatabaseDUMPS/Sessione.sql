
--
-- Struttura della tabella `Sessione`
--

CREATE TABLE IF NOT EXISTS `Sessione` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'unique ID',
  `userId` int(11) NOT NULL COMMENT 'user ID',
  `key` varchar(255) NOT NULL COMMENT 'Human Readable key',
  `sessione` blob NOT NULL COMMENT 'The serialized Session object',
  PRIMARY KEY (`id`),
  UNIQUE KEY `userId` (`userId`,`key`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;