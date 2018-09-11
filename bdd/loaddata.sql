--
-- Contenu de la table `places`
--

INSERT INTO `places` (`id`, `longitude`, `latitude`, `numberstreet`, `street`, `city`, `zipcode`, `creator`, `dateCreation`, `dateUpdate`) VALUES
(1, '45.779557', '4.827420', NULL, 'Rue Hénon', 'Lyon', '69004', 1 , '2013-05-15', NULL ),
(2, '45.788307', '4.813071', '49-43', 'rue des Docks', 'Lyon', '69009', 1 , '2013-05-15', NULL),
(3, '45.780279', '4.805270', '10', 'rue du 24 mars 1852', 'Lyon', '69009', 1 , '2013-05-15', NULL),
(4, '45.766118', '4.805506', '57-55', 'rue du Sergent Michel Berthet', 'Lyon', '69009', 1 , '2013-05-15', NULL);


--
-- Contenu de la table `users`
--

INSERT INTO `users` (`id`, `email`, `password`, `city`, `profile`, `nickname`) VALUES
(1, 'admin@admin.fr', '$2a$10$U/Eca8Iqa.RrxcntkqY60etOrifWFPdMAvvaUG.YSglatp4A0wK6C', 'Lyon', 'admin', 'admin'),
(2, 'user@user.fr', '$2a$10$LiMMGi3/uJuVuKBalHhuGeZNYJdZn59H4IX1ZLE/AxaHClr5Ifcp6', 'Lyon', 'user', 'user'),
(3, 'tr@tr.fr', '$2a$10$GR1nWEkiCwJKC.yltbv8yOY362Vk5wi/IQaB6f9vLKdrgTyDBjPPW', '', 'user', 'touché rectal'),
(4, 'julien.juuf@free.fr', '$2a$10$J/5ftjVMxRNnfIpe8l3IK.09SqMdZYZxC/gGF3RBOalAekR2Yu4by', 'Valence', 'user', 'julien'),
(5, 'luc.dahan@gmail.com', '$2a$10$qxQobscbKr4o8.RNvrEfpedsnLnzN2FwjawMjZvWo/QdFSOvHYGsm', 'Valence', 'user', 'luc'),
(6, 'papa@gmail.com', '$2a$10$jnPlQ4U/YkqxMmB2NX26COUOGsFH2i4fWvO0/dPK0YD.IY1b.axPW', 'Lyon', 'user', 'papa'),
(7, 'regis@gmail.com', '$2a$10$obn3PcCSpcWN6zOif7kvHeKZuo7USvCDXYHZW80EeAFUIq1WtptAC', 'Marseille', 'admin', 'regus'),
(8, 'test@test.fr', 'azertyuio', 'Valence', 'user', 'test'),
(9, 'jean@gmail.com', '$2a$10$HDjwIuoDQj1VTvDzvM6OBORBimgut7o/BuRjD8WlRyZje7B2ruARm', 'Lyon', 'user', 'Jacques et Michel'),
(10, 'lulu@gmail.com', '$2a$10$92vO3F2P6C9i.y.ghYSaTubASsLbyJxYx2pjOo3s2WkLrGUQvNque', 'Lyon', 'user', 'Lulu'),
(11, 'valentin@gmail.com', '$2a$10$DIxziAYWebfa6RIbp4FNb.GTIqP8VT4GW4Jvijs2.dUs7r18MHftG', 'Valence', 'user', 'Valentin'),
(12, 'albert@gmail.com', '$2a$10$BnSyscLZVNcm6drPM92V6uO82STW8WYJdnMSH.z8fXQYz0tRIwVkG', 'Lyon', 'user', 'Albert'),
(13, 'testing2.postman@yahoo.fr', '$2a$10$x6qGcXTWJT8O.CsoGQwUWuJuQEpivLsF5lL3XDN1o4C6JSYJE3LnG', 'Lyon', 'user', 'Testeur'),
(14, 'momo@gg.fr', '$2a$10$KahwCTo5vxnvS2CJSv4oK.l0/g.5ZrTRDGFsVGkEb78iXRCZwBnXO', 'Lyon', 'user', 'momo');



--
-- Contenu de la table `types`
--

INSERT INTO `types` (`id`, `name`, `typeParent_id`) VALUES
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
(11, 'Bouche d\'égout', 3);


--
-- Contenu de la table `timelapses`
--

INSERT INTO `timelapses` (`id`, `period`, `startingYear`, `endingYear`, `comments`, `isapproved`, `logo`, `color`) VALUES
(1, 'Préhistoire', -2800000, -3500, null, true, "prehistoire.jpg", 'darkbrown'),
(2, 'Antiquité', -3500, 476, null, true, "antiquite.jpg", 'black'),
(3, 'Moyen-Age', 476, 1492, null, true, "moyenage.jpg", 'darkgray'),
(4, 'Temps modernes', 1492, 1789, null, true, "tempsmodernes.jpg", 'darkpink'),
(5, 'Temps révolutionnaires', 1789, 1815, null, true, "tempsrevolutionnaires.jpg", 'darkpurple'),
(6, 'Restauration monarchie et monarchie de juillet ', 1815, 1848, null, true, "monarchie.jpg", 'darkblue'),
(7, 'Deuxième République', 1848, 1852, null, true, "republique2.jpg", 'darkgreen'),
(8, 'Second Empire', 1852, 1870, null, true, "empire2.jpg", 'darkyellow'),
(9, 'Troisième République', 1870, 1914, null, true, "republique3.jpg", 'darkorange'),
(10, 'Première guerre mondiale', 1914, 1918, null, true, "ww1.jpg", 'darkred'),
(11, 'Entre deux guerres', 1918, 1939, null, true, "entre2.jpg", 'lightbrown'),
(12, 'Deuxième guerre mondiale', 1939, 1945, null, true, "ww2.jpg", 'lightgray'),
(13, 'Quatrième République', 1946, 1958, null, true, "republique4.jpg", 'lightpink'),
(14, 'Cinquième République', 1958, 2037, null, true, "republique5.jpg", 'lightpurple'),
(15, 'Troisième guerre mondiale', 2037, 2058, null, true, "ww3.jpg", 'lightblue'),
(18, 'Test 1 non atribué', 0, NULL, null, false, "test.jpg", 'lightyellow'),
(19, 'Test 2 non atribué', 0, NULL, null, false, "test.jpg", 'lightorange');




--
-- Contenu de la table `stories`
--

INSERT INTO `stories` (`id`, `title`, `description`, `content`, `creator_id`, `place_id`, `type_id`, `timelapse_id`,  `startingYear`, `startingMonth`, `startingDay`, `endingYear`, `endingMonth`, `endingDay`, `dateCreation`, `dateUpdate`) VALUES
(1, 'Belle statue!!!', 'Wow elle est trop belle cette statue', 'Y a plein de crottes de pigeons dessus', 1, 1, 4, 1, 1800, 10, 25, NULL, NULL, NULL, '2013-05-15', '2017-07-07'),
(2, 'Statue de la vierge', 'Magnifique statue de la vierge du 15eme siècle érigée par Charles de La Frite suite à une commande du cardinal de Lasagne ', 'cette statue de la vierge est en hommage à la mère de Skywalker (Shmi Skywalker) qui mourra dans un camps des homme des sables', 2, 1, 7, 2, 1400, NULL, NULL, NULL, NULL, NULL, '2015-12-11', NULL),
(3, 'CGI c\'est de la bombe ', 'CGI, monument historique des UDEV', '', 3, 2, 6, 3, 1990, NULL, NULL, NULL, NULL, NULL, '2018-01-15', NULL),
(4, 'Batiment de CGI', 'Tellement de bons souvenirs pour moi là-bas!!!!!!!!!!!!', '', 6, 2, 2, 4, 1987, 2, 24, NULL, NULL, NULL, '2010-01-28', '2010-02-02'),
(5, 'Petite histoire salace', 'Celle des employés CGI qui font gollum gollum dans les toilettes du 3ème étage ', '', 4, 2, 4, 5, 2018, 10, 2, NULL, NULL, NULL, '2018-03-14', NULL),
(6, 'Plaque d égout ', 'du 32ème siècle aprés Jesus Christ', 'Et oui c\'est une plaque d\'égout du futur!!', 6, 3, 7, 6, 2257, NULL, NULL, NULL, NULL, NULL, '2017-08-05', NULL),
(7, 'Entrée du métro George de Loup ', 'Oui il s agit d\'une nouvelle station de métro  en mémoire à George le Conquérant qui montait un loup pour attaquer ses ennemis ', 'Vous remarquerez ces magnifiques statues de CN News et 20 minutes à l\'entrée!', 3, 4, 4, 7, 1789, 11, 25, NULL, NULL, NULL, '2014-10-18', NULL);


--
-- Contenu de la table `votes`
--

INSERT INTO `votes` (`id`, `voter_id`, `votedstory_id`, `value`, `comment`, `date_creation`, `date_update`) VALUES
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
-- Contenu de la table `media`
--

INSERT INTO `media` (`id`, `name`, `comment`, `path`, `story_id`, `date_creation`, `date_update`) VALUES
(1, 'De belles noix!!!!!', NULL, '/disquedur/pics/noix.jpg', 3, '2018-01-15', NULL),
(2, 'Statue couverte de merde', NULL, '/disquedur/pics/statueshit.jpg', 1, '2013-05-15', '2017-07-07'),
(3, 'Plaque d\'égout', 'Remarquez ces détails hallucinants sur le pingouin pendant sa période où il vivait dans les égouts de Gotham', '/disquedur/pics/plaqueegout.jpg', 6, '2017-08-05', NULL);
