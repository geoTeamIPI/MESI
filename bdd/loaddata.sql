--
-- Contenu de la table `places`
--

INSERT INTO `places` (`id`, `longitude`, `latitude`, `numberstreet`, `street`, `city`, `zipcode`, `creator`, `dateCreation`, `dateUpdate`) VALUES
(1, '45.779557', '4.827420', NULL, 'Rue Hénon', 'Lyon', '69004', 1 , '2013-05-15', NULL ),
(2, '45.788307', '4.813071', '49-43', 'rue des Docks', 'Lyon', '69009', 1 , '2013-05-15', NULL),
(3, '45.780279', '4.805270', '10', 'rue du 24 mars 1852', 'Lyon', '69009', 1 , '2013-05-15', NULL),
(4, '45.766118', '4.805506', '57-55', 'rue du Sergent Michel Berthet', 'Lyon', '69009', 1 , '2013-05-15', NULL),
(5, '45.766888', '4.897420', 'a noter', 'a noter', 'a noter', 'a noter', 1 , '2013-05-15', NULL),
(6, '45.746997', '4.887420', 'a noter', 'a noter', 'a noter', 'a noter', 14 , '2013-05-15', NULL),
(7, '45.76118', '4.877420', 'a noter', 'a noter', 'a noter', 'a noter', 2 , '2013-05-15', NULL),
(8, '45.716118', '4.867420', 'a noter', 'a noter', 'a noter', 'a noter', 15 , '2013-05-15', NULL),
(9, '45.769118', '4.857420', 'a noter', 'a noter', 'a noter', 'a noter', 11 , '2013-05-15', NULL),
(10, '45.766518', '4.847420', 'a noter', 'a noter', 'a noter', 'a noter', 8 , '2013-05-15', NULL),
(11, '45.766158', '4.837420', 'a noter', 'a noter', 'a noter', 'a noter', 6 , '2013-05-15', NULL),
(12, '45.866118', '4.817420', 'a noter', 'a noter', 'a noter', 'a noter', 7 , '2013-05-15', NULL),
(13, '45.966118', '4.127420', 'a noter', 'a noter', 'a noter', 'a noter', 7 , '2013-05-15', NULL),
(14, '45.666118', '4.227420', 'a noter', 'a noter', 'a noter', 'a noter', 4 , '2013-05-15', NULL),
(15, '45.566118', '4.327420', 'a noter', 'a noter', 'a noter', 'a noter', 5 , '2013-05-15', NULL),
(16, '45.466118', '4.427420', 'a noter', 'a noter', 'a noter', 'a noter', 7 , '2013-05-15', NULL),
(17, '45.366118', '4.527420', 'a noter', 'a noter', 'a noter', 'a noter', 6 , '2013-05-15', NULL),
(18, '45.266118', '4.627420', 'a noter', 'a noter', 'a noter', 'a noter', 2 , '2013-05-15', NULL),
(19, '45.166118', '4.727420', 'a noter', 'a noter', 'a noter', 'a noter', 8 , '2013-05-15', NULL),
(20, '45.726118', '4.827420', 'a noter', 'a noter', 'a noter', 'a noter', 7 , '2013-05-15', NULL),
(21, '45.796118', '4.927420', 'a noter', 'a noter', 'a noter', 'a noter', 11 , '2013-05-15', NULL);


--
-- Contenu de la table `users`
--

INSERT INTO `users` (`id`, `email`, `password`, `city`, `profile`, `nickname`) VALUES
(1, 'admin@admin.fr', '$2a$10$U/Eca8Iqa.RrxcntkqY60etOrifWFPdMAvvaUG.YSglatp4A0wK6C', 'Lyon', 'admin', 'admin'),
(2, 'user@user.fr', '$2a$10$LiMMGi3/uJuVuKBalHhuGeZNYJdZn59H4IX1ZLE/AxaHClr5Ifcp6', 'Lyon', 'user', 'user'),
(3, 'tr@tr.fr', '$2a$10$GR1nWEkiCwJKC.yltbv8yOY362Vk5wi/IQaB6f9vLKdrgTyDBjPPW', 'Marseille', 'user', 'touché rectal'),
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

INSERT INTO `types` (`id`, `name`, `comments`, `isapproved`, `logo`, `pathpicture`) VALUES
(1, 'Monument', NULL, true, 'town-hall-15', 'monument.jpg' ),
(2, 'Art', NULL, true, 'theatre-15', 'art.jpg'),
(3, 'Mobilier urbain', NULL, true, 'garden-15', 'urbain.jpg'),
(4, 'Cimetière', NULL, true, 'cemetery-15', 'cimetiere.jpg'),
(5, 'Religieux christianisme', NULL, true, 'religious-christian-15', 'christ.jpg'),
(6, 'Religieux juif', NULL, true, 'religious-jewish-15', 'juif.jpg'),
(7, 'Religieux musulman', NULL, true, 'religious-muslim-15', 'musulman.jpg'),
(8, 'Musical', NULL, true, 'music-15', 'musique.jpg'),
(9, 'Musée', NULL, true, 'museum-15', 'musee.jpg'),
(10, 'Nature', NULL, true, 'park-15', 'nature.jpg'),
(11, 'Animalier', NULL, true, 'zoo-15', 'animalier.jpg'),
(12, 'Informatif', NULL, true, 'information-15', 'informatif.jpg'),
(13, 'Maritime', NULL, true, 'harbor-15', 'maritime.jpg'),
(14, 'Cinématographique', NULL, true, 'cinema-15', 'cinema.jpg'),
(15, 'Test approve 1', NULL, false, 'star-15', 'test.jpg'),
(16, 'Test approve 2', NULL, false, 'star-15', 'test.jpg');



--
-- Contenu de la table `timelapses`
--

INSERT INTO `timelapses` (`id`, `period`, `startingYear`, `endingYear`, `comments`, `isapproved`, `logo`, `color`) VALUES
(1, 'Préhistoire', -2800000, -3500, null, true, 'prehistoire.jpg', 'prehistoire2.jpg'),
(2, 'Antiquité', -3500, 476, null, true, 'antiquite.jpg', 'antiquite2.jpg'),
(3, 'Moyen-Age', 476, 1492, null, true, 'moyenage.jpg', 'moyenage2.jpg'),
(4, 'Temps modernes', 1492, 1789, null, true, 'tempsmodernes.jpg', 'tempsmodernes2.jpg'),
(5, 'Temps révolutionnaires', 1789, 1815, null, true, 'tempsrevolutionnaires.jpg', 'tempsrevolutionnaires2.jpg'),
(6, 'Restauration monarchie et monarchie de juillet ', 1815, 1848, null, true, 'monarchie.jpg', 'monarchie2.jpg'),
(7, 'Deuxième République', 1848, 1852, null, true, 'republique2.jpg', 'republique22.jpg'),
(8, 'Second Empire', 1852, 1870, null, true, 'empire2.jpg', 'empire22.jpg'),
(9, 'Troisième République', 1870, 1914, null, true, 'republique3.jpg', 'republique32.jpg'),
(10, 'Première guerre mondiale', 1914, 1918, null, true, 'ww1.jpg', 'ww12.jpg'),
(11, 'Entre deux guerres', 1918, 1939, null, true, 'entre2.jpg', 'entre22.jpg'),
(12, 'Deuxième guerre mondiale', 1939, 1945, null, true, 'ww2.jpg', 'ww22.jpg'),
(13, 'Quatrième République', 1946, 1958, null, true, 'republique4.jpg', 'republique42.jpg'),
(14, 'Cinquième République', 1958, 2037, null, true, 'republique5.jpg', 'republique52.jpg'),
(15, 'Troisième guerre mondiale', 2037, 2058, null, true, 'ww3.jpg', 'ww32.jpg'),
(18, 'Test 1 non atribué', 0, NULL, null, false, 'test.jpg', 'test2.jpg'),
(19, 'Test 2 non atribué', 0, NULL, null, false, 'test.jpg', 'test2.jpg');




--
-- Contenu de la table `stories`
--

INSERT INTO `stories` (`id`, `title`, `description`, `content`, `creator_id`, `place_id`, `type_id`, `timelapse_id`,  `startingYear`, `startingMonth`, `startingDay`, `endingYear`, `endingMonth`, `endingDay`, `dateCreation`, `dateUpdate`) VALUES
(1, 'Belle statue!!!', 'Wow elle est trop belle cette statue', 'Y a plein de crottes de pigeons dessus', 1, 1, 4, 1, 1800, 10, 25, NULL, NULL, NULL, '2013-05-15', '2017-07-07'),
(2, 'Statue de la vierge', 'Magnifique statue de la vierge du 15eme siècle érigée par Charles de La Frite suite à une commande du cardinal de Lasagne ', 'cette statue de la vierge est en hommage à la mère de Skywalker (Shmi Skywalker) qui mourra dans un camps des homme des sables', 2, 2, 7, 2, 1400, NULL, NULL, NULL, NULL, NULL, '2015-12-11', NULL),
(3, 'CGI c\'est de la bombe ', 'CGI, monument historique des UDEV', '', 3, 3, 6, 3, 1990, NULL, NULL, NULL, NULL, NULL, '2018-01-15', NULL),
(4, 'Batiment de CGI', 'Tellement de bons souvenirs pour moi là-bas!!!!!!!!!!!!', '', 6, 4, 2, 4, 1987, 2, 24, NULL, NULL, NULL, '2010-01-28', '2010-02-02'),
(5, 'Petite histoire salace', 'Celle des employés CGI qui font gollum gollum dans les toilettes du 3ème étage ', '', 4, 5, 4, 5, 2018, 10, 2, NULL, NULL, NULL, '2018-03-14', NULL),
(6, 'Plaque d égout ', 'du 32ème siècle aprés Jesus Christ', 'Et oui c\'est une plaque d\'égout du futur!!', 6, 6, 7, 6, 2257, NULL, NULL, NULL, NULL, NULL, '2017-08-05', NULL),
(7, 'Entrée du métro George de Loup ', 'Oui il s agit d\'une nouvelle station de métro  en mémoire à George le Conquérant qui montait un loup pour attaquer ses ennemis ', 'Vous remarquerez ces magnifiques statues de CN News et 20 minutes à l\'entrée!', 3, 7, 4, 7, 1789, 11, 25, NULL, NULL, NULL, '2014-10-18', NULL),
(8, 'A écrire', 'A écrire', 'A écrire', 13, 8, 9, 7, 1789, 11, 25, NULL, NULL, NULL, '2014-10-18', NULL),
(9, 'A écrire', 'A écrire', 'A écrire', 3, 9, 7, 7, 1789, 11, 25, NULL, NULL, NULL, '2014-10-18', NULL),
(10, 'A écrire', 'A écrire', 'A écrire', 14, 10, 1, 7, 1789, 11, 25, NULL, NULL, NULL, '2014-10-18', NULL),
(11, 'A écrire', 'A écrire', 'A écrire', 5, 11, 9, 8, 1789, 11, 25, NULL, NULL, NULL, '2014-10-18', NULL),
(12, 'A écrire', 'A écrire', 'A écrire', 5, 12, 11, 7, 1789, 11, 25, NULL, NULL, NULL, '2014-10-18', NULL),
(13, 'A écrire', 'A écrire', 'A écrire', 7, 13, 12, 5, 1789, 11, 25, NULL, NULL, NULL, '2014-10-18', NULL),
(14, 'A écrire', 'A écrire', 'A écrire', 8, 14, 12, 7, 1789, 11, 25, NULL, NULL, NULL, '2014-10-18', NULL),
(15, 'A écrire', 'A écrire', 'A écrire', 9, 15, 7, 7, 1789, 11, 25, NULL, NULL, NULL, '2014-10-18', NULL),
(16, 'A écrire', 'A écrire', 'A écrire', 13, 16, 3, 1, 1789, 11, 25, NULL, NULL, NULL, '2014-10-18', NULL),
(17, 'A écrire', 'A écrire', 'A écrire', 12, 7, 9, 3, 1789, 11, 25, NULL, NULL, NULL, '2014-10-18', NULL),
(18, 'A écrire', 'A écrire', 'A écrire', 11, 8, 14, 2, 1789, 11, 25, NULL, NULL, NULL, '2014-10-18', NULL),
(19, 'A écrire', 'A écrire', 'A écrire', 10, 1, 15, 7, 1789, 11, 25, NULL, NULL, NULL, '2014-10-18', NULL),
(20, 'A écrire', 'A écrire', 'A écrire', 7, 2, 1, 12, 1789, 11, 25, NULL, NULL, NULL, '2014-10-18', NULL),
(21, 'A écrire', 'A écrire', 'A écrire', 8, 8, 1, 11, 1789, 11, 25, NULL, NULL, NULL, '2014-10-18', NULL),
(22, 'A écrire', 'A écrire', 'A écrire', 5, 9, 1, 9, 1789, 11, 25, NULL, NULL, NULL, '2014-10-18', NULL),
(23, 'A écrire', 'A écrire', 'A écrire', 4, 17, 8, 7, 1789, 11, 25, NULL, NULL, NULL, '2014-10-18', NULL),
(24, 'A écrire', 'A écrire', 'A écrire', 9, 14, 9, 10, 1789, 11, 25, NULL, NULL, NULL, '2014-10-18', NULL),
(25, 'A écrire', 'A écrire', 'A écrire', 2, 11, 14, 9, 1789, 11, 25, NULL, NULL, NULL, '2014-10-18', NULL),
(26, 'A écrire', 'A écrire', 'A écrire', 3, 12, 14, 7, 1789, 11, 25, NULL, NULL, NULL, '2014-10-18', NULL);


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
