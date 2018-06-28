INSERT INTO `places` (`longitude`, `latitude`, `number_street`, `street`, `city`, `zip_code`) VALUES
('45.779557', '4.827420', null, 'Rue Hénon', 'Lyon', '69004'),
('45.788307', '4.813071', '49-43', 'rue des Docks', 'Lyon', '69009'),
('45.780279', '4.805270', '10', 'rue du 24 mars 1852', 'Lyon', '69009'),
('45.766118', '4.805506', '57-55', 'rue du Sergent Michel Berthet', 'Lyon', '69009');

INSERT INTO `users` (`email`, `password`, `city`, `profile`) VALUES
('toto@yahoo.fr', 'pwd', 'Lyon', 'user'),
('tata@gmail.com', 'pwd', 'Villeurbanne', 'user'),
('titi@yahoo.fr', 'pwd', 'L\'Arbresle', 'user'),
('stephane@yahoo.fr', 'pwd', 'Clermont-Ferrand', 'user'),
('cedric.becbenzene@gnail.com', 'pwd', 'Lyon', 'user'),
('stephane.rip@zombie.fr', 'pwd', 'Lyon', 'user'),
('ludo@game.fr', 'pwd', 'Lyon', 'user'),
('pierre.charlot@chaplin.fr', 'pwd', 'Lyon', 'user'),
('nicolas.hell@wtfh.com', 'pwd', 'Lyon', 'user');

INSERT INTO `types` (`name`, `type_id`) VALUES
('Monument', NULL),
('Décoration', NULL),
('Mobilier urbain', NULL),
('Sculpture', NULL),
('Peinture', NULL),
('Art moderne', NULL),
('Musée', 1),
('Bibliothèque', 1),
('Porte', 2),
('Enseigne', 2),
("Bouche d'égout", 3);

INSERT INTO `timelapses` (`period`, `starting_year`, `ending_year`) VALUES
('Antiquité', -3500, 476),
('Renaissance', 1300, 1600),
('Révolution industrielle', 1769, 1939),
('Première guerre mondiale', 1914, 1918),
('Deuxième guerre mondiale', 1939, 1945),
('Troisième guerre mondiale', 2025, 2075),
('Préhistoire', -2800000, -3500),
('Moyen-Age', 476, 1492),
('Temps modernes', 1945, NULL);

INSERT INTO `stories` (`title`, `description`, `content`, `creator_id`, `place_id`, `type_id`, `starting_year`, `starting_month`, `starting_day`, `ending_year`, `ending_month`, `ending_day`, `date_creation`, `date_update`) VALUES
('Belle statue!!!', 'Wow elle est trop belle cette statue', 'Y a plein de crottes de pigeons dessus', 1, 1, 4, 1800, 10, 25, null, null, null, '2013-05-15', '2017-07-07'),
('Statue de la vierge', 'Magnifique statue de la vierge du 15eme siècle érigée par Charles de La Frite suite à une commande du cardinal de Lasagne ', 'cette statue de la vierge est en hommage à la mère de Skywalker (Shmi Skywalker) qui mourra dans un camps des homme des sables', 2, 1, 7, 1400, null, null, null, null, null, '2015-12-11', null),
('CGI c\'est de la bombe ', 'CGI, monument historique des UDEV', '', 3, 2, 6, 1990, null, null, null, null, null, '2018-01-15', null),
('Batiment de CGI', 'Tellement de bons souvenirs pour moi là-bas!!!!!!!!!!!!', '', 6, 2, 2, 1987, 2, 24, null, null, null, '2010-01-28', '2010-02-02'),
('Petite histoire salace', 'Celle des employés CGI qui font gollum gollum dans les toilettes du 3ème étage ', '', 4, 2, 4, 2018, 10, 2, null, null, null, '2018-03-14', null),
('Plaque d égout ', 'du 32ème siècle aprés Jesus Christ', 'Et oui c\'est une plaque d\'égout du futur!!', 6, 3, 7, 2257, null, null, null, null, null, '2017-08-05', null),
('Entrée du métro George de Loup ', 'Oui il s agit d\'une nouvelle station de métro  en mémoire à George le Conquérant qui montait un loup pour attaquer ses ennemis ', 'Vous remarquerez ces magnifiques statues de CN News et 20 minutes à l\'entrée!', 3, 4, 4, 1789, 11, 25, null, null, null, '2014-10-18', null);

INSERT INTO `votes` (`voter_id`, `story_id`, `value`, `comment`, `date_creation`, `date_update`) VALUES
(1 ,2 , true, 'Excellent', '2018-04-15', '2018-04-16'), 
(1 ,5 , true, 'Tres_bon', '2017-09-23', null), 
(1 ,7 , true, 'Excellent', '2018-01-03', null), 
(2 ,1 , false, 'Informations_fausses', '2017-12-24', null), 
(2 ,3 , true, 'Tres_bon', '2017-10-15', null), 
(2 ,5 , false, 'Acte_de_troll', '2017-11-12', null), 
(4 ,7 , true, 'bon', '201-12-15', '2018-01-16'), 
(8 ,7 , true, 'Excellent', '2018-02-26', null), 
(7 ,6 , true, 'bon', '2018-02-09', null);

INSERT INTO `media` (`name`, `comment`, `path`, `story_id`, `date_creation`, `date_update`) VALUES
("De belles noix!!!!!" , null , "/disquedur/pics/noix.jpg", 3, '2018-01-15', null), 
("Statue couverte de merde" , null , "/disquedur/pics/statueshit.jpg", 1, '2013-05-15', '2017-07-07'), 
("Plaque d'égout" , "Remarquez ces détails hallucinants sur le pingouin pendant sa période où il vivait dans les égouts de Gotham" , "/disquedur/pics/plaqueegout.jpg", 6, '2017-08-05', null);

