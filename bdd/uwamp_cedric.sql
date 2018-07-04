-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Mer 20 Juin 2018 à 13:06
-- Version du serveur :  5.6.20-log
-- Version de PHP :  5.4.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `geopatrimoine`
--

-- --------------------------------------------------------

--
-- Structure de la table `media`
--

CREATE TABLE IF NOT EXISTS `media` (
`id` bigint(10) NOT NULL,
  `name` varchar(255) NOT NULL,
  `comment` text,
  `path` text NOT NULL,
  `story_id` bigint(10) NOT NULL,
  `date_creation` date NOT NULL,
  `date_update` date DEFAULT NULL
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=4 ;

--
-- Contenu de la table `media`
--

INSERT INTO `media` (`id`, `name`, `comment`, `path`, `story_id`, `date_creation`, `date_update`) VALUES
(1, 'De belles noix!!!!!', NULL, '/disquedur/pics/noix.jpg', 3, '2018-01-15', NULL),
(2, 'Statue couverte de merde', NULL, '/disquedur/pics/statueshit.jpg', 1, '2013-05-15', '2017-07-07'),
(3, 'Plaque d''égout', 'Remarquez ces détails hallucinants sur le pingouin pendant sa période où il vivait dans les égouts de Gotham', '/disquedur/pics/plaqueegout.jpg', 6, '2017-08-05', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `places`
--

CREATE TABLE IF NOT EXISTS `places` (
`id` bigint(10) NOT NULL,
  `longitude` varchar(90) NOT NULL,
  `latitude` varchar(90) NOT NULL,
  `number_street` varchar(10) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `zip_code` varchar(10) DEFAULT NULL
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=5 ;

--
-- Contenu de la table `places`
--

INSERT INTO `places` (`id`, `longitude`, `latitude`, `number_street`, `street`, `city`, `zip_code`) VALUES
(1, '45.779557', '4.827420', NULL, 'Rue Hénon', 'Lyon', '69004'),
(2, '45.788307', '4.813071', '49-43', 'rue des Docks', 'Lyon', '69009'),
(3, '45.780279', '4.805270', '10', 'rue du 24 mars 1852', 'Lyon', '69009'),
(4, '45.766118', '4.805506', '57-55', 'rue du Sergent Michel Berthet', 'Lyon', '69009');

-- --------------------------------------------------------

--
-- Structure de la table `stories`
--

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

--
-- Contenu de la table `stories`
--

INSERT INTO `stories` (`id`, `title`, `description`, `content`, `creator_id`, `place_id`, `type_id`, `starting_year`, `starting_month`, `starting_day`, `ending_year`, `ending_month`, `ending_day`, `date_creation`, `date_update`) VALUES
(1, 'Belle statue!!!', 'Wow elle est trop belle cette statue', 'Y a plein de crottes de pigeons dessus', 1, 1, 4, 1800, 10, 25, NULL, NULL, NULL, '2013-05-15', '2017-07-07'),
(2, 'Statue de la vierge', 'Magnifique statue de la vierge du 15eme siècle érigée par Charles de La Frite suite à une commande du cardinal de Lasagne ', 'cette statue de la vierge est en hommage à la mère de Skywalker (Shmi Skywalker) qui mourra dans un camps des homme des sables', 2, 1, 7, 1400, NULL, NULL, NULL, NULL, NULL, '2015-12-11', NULL),
(3, 'CGI c''est de la bombe ', 'CGI, monument historique des UDEV', '', 3, 2, 6, 1990, NULL, NULL, NULL, NULL, NULL, '2018-01-15', NULL),
(4, 'Batiment de CGI', 'Tellement de bons souvenirs pour moi là-bas!!!!!!!!!!!!', '', 6, 2, 2, 1987, 2, 24, NULL, NULL, NULL, '2010-01-28', '2010-02-02'),
(5, 'Petite histoire salace', 'Celle des employés CGI qui font gollum gollum dans les toilettes du 3ème étage ', '', 4, 2, 4, 2018, 10, 2, NULL, NULL, NULL, '2018-03-14', NULL),
(6, 'Plaque d égout ', 'du 32ème siècle aprés Jesus Christ', 'Et oui c''est une plaque d''égout du futur!!', 6, 3, 7, 2257, NULL, NULL, NULL, NULL, NULL, '2017-08-05', NULL),
(7, 'Entrée du métro George de Loup ', 'Oui il s agit d''une nouvelle station de métro  en mémoire à George le Conquérant qui montait un loup pour attaquer ses ennemis ', 'Vous remarquerez ces magnifiques statues de CN News et 20 minutes à l''entrée!', 3, 4, 4, 1789, 11, 25, NULL, NULL, NULL, '2014-10-18', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `timelapses`
--

CREATE TABLE IF NOT EXISTS `timelapses` (
`id` bigint(10) NOT NULL,
  `period` varchar(255) NOT NULL,
  `starting_year` int(10) NOT NULL,
  `ending_year` int(10) DEFAULT NULL
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=10 ;

--
-- Contenu de la table `timelapses`
--

INSERT INTO `timelapses` (`id`, `period`, `starting_year`, `ending_year`) VALUES
(1, 'Antiquité', -3500, 476),
(2, 'Renaissance', 1300, 1600),
(3, 'Révolution industrielle', 1769, 1939),
(4, 'Première guerre mondiale', 1914, 1918),
(5, 'Deuxième guerre mondiale', 1939, 1945),
(6, 'Troisième guerre mondiale', 2025, 2075),
(7, 'Préhistoire', -2800000, -3500),
(8, 'Moyen-Age', 476, 1492),
(9, 'Temps modernes', 1945, NULL);

-- --------------------------------------------------------

--
-- Structure de la table `types`
--

CREATE TABLE IF NOT EXISTS `types` (
`id` bigint(10) NOT NULL,
  `name` varchar(255) NOT NULL,
  `type_id` bigint(10) DEFAULT NULL
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

--
-- Contenu de la table `types`
--

INSERT INTO `types` (`id`, `name`, `type_id`) VALUES
(1, 'Monument', NULL),
(2, 'Décoration', NULL),
(3, 'Mobilier urbain', NULL),
(4, 'Sculpture', NULL),
(5, 'Peinture', NULL),
(6, 'Art moderne', NULL),
(7, 'Musée', 1),
(8, 'Bibliothèque', 1),
(9, 'Porte', 2),
(10, 'Enseigne', 2),
(11, 'Bouche d''égout', 3);

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
`id` bigint(10) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(60) NOT NULL,
  `city` varchar(50) NOT NULL,
  `profile` varchar(20) NOT NULL DEFAULT 'user'
) ENGINE=MyISAM  DEFAULT CHARSET=latin1 AUTO_INCREMENT=58 ;

--
-- Contenu de la table `users`
--

INSERT INTO `users` (`id`, `email`, `password`, `city`, `profile`) VALUES
(1, 'toto@yahoo.fr', 'pwd', 'Lyon', 'user'),
(2, 'tata@gmail.com', 'pwd', 'Villeurbanne', 'user'),
(3, 'titi@yahoo.fr', 'pwd', 'L''Arbresle', 'user'),
(4, 'stephane@yahoo.fr', 'pwd', '', 'user'),
(5, 'cedric.becbenzene@gnail.com', 'pwd', 'Lyon', 'user'),
(6, 'stephane.rip@zombie.fr', 'pwd', 'Lyon', 'user'),
(7, 'ludo@game.fr', 'pwd', 'Lyon', 'user'),
(8, 'pierre.charlot@chaplin.fr', 'pwd', 'Lyon', 'user'),
(9, 'nicolas.hell@wtfh.com', 'pwd', 'Marseille', 'user'),
(28, 'tr@tr.fr', '$2a$10$GR1nWEkiCwJKC.yltbv8yOY362Vk5wi/IQaB6f9vLKdrgTyDBjPPW', '', 'user'),
(12, 'julien.juuf@free.fr', '$2a$10$J/5ftjVMxRNnfIpe8l3IK.09SqMdZYZxC/gGF3RBOalAekR2Yu4by', 'Valence', 'user'),
(13, 'luc.dahan@gmail.com', '$2a$10$qxQobscbKr4o8.RNvrEfpedsnLnzN2FwjawMjZvWo/QdFSOvHYGsm', 'Valence', 'user'),
(46, 'louis@gmail.com', 'jules', 'Lyon', 'user'),
(49, 'papa@gmail.com', '$2a$10$jnPlQ4U/YkqxMmB2NX26COUOGsFH2i4fWvO0/dPK0YD.IY1b.axPW', 'Lyon', 'user'),
(21, 'regis@gmail.com', '$2a$10$obn3PcCSpcWN6zOif7kvHeKZuo7USvCDXYHZW80EeAFUIq1WtptAC', 'Marseille', 'admin'),
(19, 'test@test.fr', 'azertyuio', 'Valence', 'user'),
(44, 'jean@gmail.com', '$2a$10$HDjwIuoDQj1VTvDzvM6OBORBimgut7o/BuRjD8WlRyZje7B2ruARm', 'Lyon', 'user'),
(45, 'jules@gmail.com', 'jules', 'Lyon', 'user'),
(30, 'lulu@gmail.com', '$2a$10$92vO3F2P6C9i.y.ghYSaTubASsLbyJxYx2pjOo3s2WkLrGUQvNque', 'Lyon', 'admin'),
(57, 'valentin@gmail.com', '$2a$10$DIxziAYWebfa6RIbp4FNb.GTIqP8VT4GW4Jvijs2.dUs7r18MHftG', 'Valence', 'user'),
(47, 'jules@yahoo.fr', 'alain', 'Lyon', 'user'),
(55, 'papi@gmail.com', 'papilyon', 'Lyon', 'user'),
(56, 'albert@gmail.com', '$2a$10$BnSyscLZVNcm6drPM92V6uO82STW8WYJdnMSH.z8fXQYz0tRIwVkG', 'Lyon', 'user');

-- --------------------------------------------------------

--
-- Structure de la table `votes`
--

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
-- Contenu de la table `votes`
--

INSERT INTO `votes` (`id`, `voter_id`, `story_id`, `value`, `comment`, `date_creation`, `date_update`) VALUES
(1, 1, 2, 1, 'Excellent', '2018-04-15', '2018-04-16'),
(2, 1, 5, 1, 'Tres_bon', '2017-09-23', NULL),
(3, 1, 7, 1, 'Excellent', '2018-01-03', NULL),
(4, 2, 1, 0, 'Informations_fausses', '2017-12-24', NULL),
(5, 2, 3, 1, 'Tres_bon', '2017-10-15', NULL),
(6, 2, 5, 0, 'Acte_de_troll', '2017-11-12', NULL),
(7, 4, 7, 1, 'bon', '0201-12-15', '2018-01-16'),
(8, 8, 7, 1, 'Excellent', '2018-02-26', NULL),
(9, 7, 6, 1, 'bon', '2018-02-09', NULL);

--
-- Index pour les tables exportées
--

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
