create schema if not exists "public";
DROP TABLE IF EXISTS music_festival;
DROP TABLE IF EXISTS accompany;
DROP TABLE IF EXISTS artist;

CREATE TABLE IF NOT EXISTS `music_festival` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `place` varchar(255) NOT NULL,
  `event_date` DATE NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `accompany` (
  `festival_id` bigint(20) NOT NULL,
  `accompany_id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`festival_id`, `accompany_id`),
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `artist` (
  `festival_id` bigint(20) NOT NULL,
  `artist_id` bigint(20) NOT NULL,
  `name` varchar(255) NOT NULL,
  `play_order` bigint(2) NOT NULL,
  `start` DATETIME,
  PRIMARY KEY (`festival_id`, `artist_id`),
  UNIQUE KEY `name` (`name`, `festival_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
