SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;


CREATE TABLE IF NOT EXISTS `users` (
`id` bigint(10) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(60) NOT NULL,
  `city` varchar(50) NOT NULL,
  `profile` varchar(20) NOT NULL DEFAULT 'user'
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=58 ;


CREATE TABLE IF NOT EXISTS `stories` (
`id` bigint(10) NOT NULL,
  `title` varchar(255) NOT NULL,
  `description` text,
  `content` text,
  `creator_id` bigint(20) NOT NULL,
  `place_id` bigint(20) NOT NULL,
  `type_id` bigint(20) NOT NULL,
  `starting_year` int(10) DEFAULT NULL,
  `starting_month` int(2) DEFAULT NULL,
  `starting_day` int(2) DEFAULT NULL,
  `ending_year` int(10) DEFAULT NULL,
  `ending_month` int(2) DEFAULT NULL,
  `ending_day` int(2) DEFAULT NULL,
  `date_creation` date NOT NULL,
  `date_update` date DEFAULT NULL
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=8 ;

CREATE TABLE IF NOT EXISTS `places` (
`id` bigint(10) NOT NULL,
  `longitude` varchar(90) NOT NULL,
  `latitude` varchar(90) NOT NULL,
  `number_street` varchar(10) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `zip_code` varchar(10) DEFAULT NULL
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

CREATE TABLE IF NOT EXISTS `timelapses` (
`id` bigint(10) NOT NULL,
  `period` varchar(255) NOT NULL,
  `starting_year` int(10) NOT NULL,
  `ending_year` int(10) DEFAULT NULL
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

CREATE TABLE IF NOT EXISTS `types` (
`id` bigint(10) NOT NULL,
  `name` varchar(255) NOT NULL,
  `type_id` bigint(10) DEFAULT NULL
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;


CREATE TABLE IF NOT EXISTS `media` (
`id` bigint(10) NOT NULL,
  `name` varchar(255) NOT NULL,
  `comment` text,
  `path` text NOT NULL,
  `story_id` bigint(10) NOT NULL,
  `date_creation` date NOT NULL,
  `date_update` date DEFAULT NULL
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

CREATE TABLE IF NOT EXISTS `votes` (
`id` bigint(10) NOT NULL,
  `voter_id` bigint(10) NOT NULL,
  `story_id` bigint(10) NOT NULL,
  `value` tinyint(1) NOT NULL,
  `comment` enum('Excellent','Tres_bon','bon','Informations_fausses','Acte_de_troll') DEFAULT 'bon',
  `date_creation` date NOT NULL,
  `date_update` date DEFAULT NULL
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;


--
-- Index pour la table `media`
--
ALTER TABLE `media`
 ADD PRIMARY KEY (`id`), ADD KEY `media_fk0` (`story_id`);

--
-- Index pour la table `places`
--
ALTER TABLE `places`
 ADD PRIMARY KEY (`id`);

--
-- Index pour la table `stories`
--
ALTER TABLE `stories`
 ADD PRIMARY KEY (`id`), ADD KEY `stories_fk0` (`creator_id`), ADD KEY `stories_fk1` (`place_id`), ADD KEY `stories_fk2` (`type_id`);

--
-- Index pour la table `timelapses`
--
ALTER TABLE `timelapses`
 ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `period` (`period`);

--
-- Index pour la table `types`
--
ALTER TABLE `types`
 ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `name` (`name`), ADD KEY `types_fk0` (`type_id`);

--
-- Index pour la table `users`
--
ALTER TABLE `users`
 ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `email` (`email`);

--
-- Index pour la table `votes`
--
ALTER TABLE `votes`
 ADD PRIMARY KEY (`id`), ADD KEY `votes_fk0` (`voter_id`), ADD KEY `votes_fk1` (`story_id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `media`
--
ALTER TABLE `media`
MODIFY `id` bigint(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `places`
--
ALTER TABLE `places`
MODIFY `id` bigint(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT pour la table `stories`
--
ALTER TABLE `stories`
MODIFY `id` bigint(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT pour la table `timelapses`
--
ALTER TABLE `timelapses`
MODIFY `id` bigint(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT pour la table `types`
--
ALTER TABLE `types`
MODIFY `id` bigint(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT pour la table `users`
--
ALTER TABLE `users`
MODIFY `id` bigint(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=58;
--
-- AUTO_INCREMENT pour la table `votes`
--
ALTER TABLE `votes`
MODIFY `id` bigint(10) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=10;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;