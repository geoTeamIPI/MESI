-- phpMyAdmin SQL Dump
-- version 4.5.4.1
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Jeu 28 Juin 2018 à 11:25
-- Version du serveur :  5.7.11
-- Version de PHP :  7.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `geopatrimoine`
--

-- --------------------------------------------------------

--
-- Structure de la table `media`
--

CREATE TABLE `media` (
  `id` bigint(10) NOT NULL,
  `name` varchar(255) NOT NULL,
  `comment` text,
  `path` text NOT NULL,
  `story_id` bigint(10) NOT NULL,
  `date_creation` date NOT NULL,
  `date_update` date DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


-- --------------------------------------------------------

--
-- Structure de la table `places`
--

CREATE TABLE `places` (
  `id` bigint(10) NOT NULL,
  `longitude` varchar(90) NOT NULL,
  `latitude` varchar(90) NOT NULL,
  `numberstreet` varchar(10) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `zipcode` varchar(10) DEFAULT NULL, 
  `creator` bigint(20) NOT NULL,
  `dateCreation` date NOT NULL,
  `dateUpdate` date DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


-- --------------------------------------------------------

--
-- Structure de la table `stories`
--

CREATE TABLE `stories` (
  `id` bigint(10) NOT NULL,
  `title` varchar(255) NOT NULL,
  `description` text,
  `content` text,
  `creator_id` bigint(20) NOT NULL,
  `place_id` bigint(20) NOT NULL,
  `type_id` bigint(20) NOT NULL,
  `timelapse_id` bigint(20) NOT NULL,
  `startingYear` int(10) DEFAULT NULL,
  `startingMonth` int(2) DEFAULT NULL,
  `startingDay` int(2) DEFAULT NULL,
  `endingYear` int(10) DEFAULT NULL,
  `endingMonth` int(2) DEFAULT NULL,
  `endingDay` int(2) DEFAULT NULL,
  `dateCreation` date NOT NULL,
  `dateUpdate` date DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


-- --------------------------------------------------------

--
-- Structure de la table `timelapses`
--

CREATE TABLE `timelapses` (
  `id` bigint(10) NOT NULL,
  `period` varchar(255) NOT NULL,
  `startingYear` int(10) NOT NULL,
  `endingYear` int(10) DEFAULT NULL,
  `comments` varchar(255) DEFAULT NULL,
  `logo` varchar(255) DEFAULT NULL,
  `isapproved` boolean DEFAULT false,
  `color` varchar(255) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


-- --------------------------------------------------------

--
-- Structure de la table `types`
--

CREATE TABLE `types` (
  `id` bigint(10) NOT NULL,
  `name` varchar(255) NOT NULL,
  `typeParent_id` bigint(10) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE `users` (
  `id` bigint(10) NOT NULL,
  `email` varchar(50) NOT NULL,
  `password` varchar(60) NOT NULL,
  `city` varchar(50) NOT NULL,
  `profile` varchar(20) NOT NULL DEFAULT 'user',
  `nickname` varchar(80) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


-- --------------------------------------------------------

--
-- Structure de la table `votes`
--

CREATE TABLE `votes` (
  `id` bigint(10) NOT NULL,
  `voter_id` bigint(10) NOT NULL,
  `votedstory_id` bigint(10) NOT NULL,
  `value` tinyint(1) NOT NULL,
  `comment` enum('Excellent','Tres_bon','bon','Informations_fausses','Acte_de_troll') DEFAULT 'bon',
  `date_creation` date NOT NULL,
  `date_update` date DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;


--
-- Index pour les tables exportées
--

--
-- Index pour la table `media`
--
ALTER TABLE `media`
  ADD PRIMARY KEY (`id`),
  ADD KEY `media_fk0` (`story_id`);

--
-- Index pour la table `places`
--
ALTER TABLE `places`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `stories`
--
ALTER TABLE `stories`
  ADD PRIMARY KEY (`id`),
  ADD KEY `stories_fk0` (`creator_id`),
  ADD KEY `stories_fk1` (`place_id`),
  ADD KEY `stories_fk2` (`type_id`);

--
-- Index pour la table `timelapses`
--
ALTER TABLE `timelapses`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `period` (`period`);

--
-- Index pour la table `types`
--
ALTER TABLE `types`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `name` (`name`),
  ADD KEY `types_fk0` (`typeParent_id`);

--
-- Index pour la table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Index pour la table `votes`
--
ALTER TABLE `votes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `votes_fk0` (`voter_id`),
  ADD KEY `votes_fk1` (`votedstory_id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `media`
--
ALTER TABLE `media`
  MODIFY `id` bigint(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT pour la table `places`
--
ALTER TABLE `places`
  MODIFY `id` bigint(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT pour la table `stories`
--
ALTER TABLE `stories`
  MODIFY `id` bigint(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT pour la table `timelapses`
--
ALTER TABLE `timelapses`
  MODIFY `id` bigint(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT pour la table `types`
--
ALTER TABLE `types`
  MODIFY `id` bigint(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT pour la table `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=58;
--
-- AUTO_INCREMENT pour la table `votes`
--
ALTER TABLE `votes`
  MODIFY `id` bigint(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
