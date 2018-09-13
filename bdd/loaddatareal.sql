--
-- Contenu de la table `places`
--

INSERT INTO `places` (`id`, `longitude`, `latitude`, `numberstreet`, `street`, `city`, `zipcode`, `creator`, `dateCreation`, `dateUpdate`) VALUES
(1, '4.813071', '45.788307', '49-43', 'rue des Docks', 'Lyon', '69009', 1 , '2013-05-15', NULL), 
(2, '4.805506', '45.766118', '57-55', 'rue du Sergent Michel Berthet', 'Lyon', '69009', 1 , '2013-05-15', NULL), 
(3, '4.8059379','45.7683916','47', 'rue du Sergent Michel Berthet', 'Lyon', '69009', 1 , '2014-05-15', NULL),
(4, '4.8056605', '45.7703256','7-9', 'rue Jean-Marie Leclair', 'Lyon', '69009', 1 , '2018-05-15', NULL),
(5, '4.8530257', '45.7774069','2', 'Avenue Verguin', 'Lyon', '69006', 1 , '2011-05-15', NULL), 
(6, '4.8545258', '45.7784452','10', 'Avenue Verguin', 'Lyon', '69006', 1 , '2016-05-15', NULL),
(7, '4.820878','45.7550934', '0', 'Place de l’Abbé larue', 'Lyon', '69005', 1 , '2013-05-15', NULL),
(8, '4.8218358','45.7618622', '19', 'Rue de la Bombarde', 'Lyon', '69005', 1 , '2016-05-15', NULL),
(9, '4.7974164', '45.7929315','26', 'rue du Sergent Michel Berthet', 'Lyon', '69009', 1 , '2016-05-15', NULL),
(10, '4.7974164', '45.7930405','24', 'rue du Sergent Michel Berthet', 'Lyon', '69009', 1 , '2016-05-15', NULL), 
(11, '4.8097544','45.7616621', '22-24', 'rue de la gare', 'Lyon', '69009', 1 , '2016-05-15', NULL),
(12, '4.8097544', '45.7618337','1', 'Rue Lucien Sportisse', 'Lyon', '69001', 1 , '2016-05-15', NULL), 
(13,  '4.822626','45.7622928', '8', 'Place de Fourvière', 'Lyon', '69005', 1 , '2016-05-15', NULL),
(14,  '4.8386325','45.7535863', '8', 'Quai Claude Bernard', 'Lyon', '69007', 1 , '2016-05-15', NULL); 

--
-- Contenu de la table `stories`
--

INSERT INTO `stories` (`id`, `title`, `description`, `content`, `creator_id`, `place_id`, `type_id`, `timelapse_id`,  `startingYear`, `startingMonth`, `startingDay`, `endingYear`, `endingMonth`, `endingDay`, `dateCreation`, `dateUpdate`) VALUES
(1, 'CGI, La force de l\'engagement', 'CGI, monument historique des UDEV', '', 3, 1, 6, 14, 1990, NULL, NULL, NULL, NULL, NULL, '2018-01-15', NULL),
(2, 'Entrée du métro George de Loup ', 'Oui il s agit d\'une nouvelle station de métro  en mémoire à George le Conquérant qui montait un loup pour attaquer ses ennemis ', 'Vous remarquerez ces magnifiques statues de CN News et 20 minutes à l\'entrée!', 3, 2, 4, 5, 1789, 11, 25, NULL, NULL, NULL, '2014-10-18', NULL),
(3, 'Ancienne demeure des U’Dev', 'Voici, l’ancien temple des U’dev ', '', 3, 3, 4, 14, 2011, 11, 25, NULL, NULL, NULL, '2011-10-18', NULL),
(4, 'Nouveau Temple des U’Dev', 'Oui, Voici le nouveau Temple des U’Dev, leurs nouvelles installations est à la pointe de la technologie. ', '', 2, 4, 4, 14, 2017, 11, 25, NULL, NULL, NULL, '2017-10-18', NULL),
(5, 'Parc de la Tête d’or ', 'Vaste parc du XIXe siècle avec statues, fontaines, grands arbres, roseraie, jardin botanique et lac. ', 'Vous remarquerez sa grande verdure', 2, 5, 4, 10, 1917, 11, 25, NULL, NULL, NULL, '2014-10-18', NULL),
(6, 'Zoo Tête d’or ', 'Vaste jardin zoologique verdoyant abritant des animaux exotiques d Asie, d Afrique et des Amériques.', 'Allez voir les crocodiles', 2, 6, 4, 14, 1996, 11, 25, NULL, NULL, NULL, '2014-10-18', NULL),
(7, 'Jardin des Curiosités ', 'Il s’agit d’un parc de 6000 m² ', 'Remarquer sa vue Magnifique', 3, 7, 4, 5, 1789, 11, 25, NULL, NULL, NULL, '2014-10-18', NULL),
(8, 'Bonchon Les Lyonnais ', 'Des spécialités lyonnaises servies dans un cadre chaleureux aux murs oranges ornés de photos en noir et blanc. ', 'Plat typique', 3, 8, 4, 14, 2003, 11, 25, NULL, NULL, NULL, '2014-10-18', NULL),
(9, 'Ninkazi ', 'Des spécialités lyonnaises servies dans un cadre chaleureux aux murs oranges ornés de photos en noir et blanc. ', 'Plat typique', 3, 9, 4, 14, 2003, 11, 25, NULL, NULL, NULL, '2014-10-18', NULL);



--
-- Contenu de la table `users`
--

INSERT INTO `users` (`id`, `email`, `password`, `city`, `profile`, `nickname`) VALUES
(1, 'admin@admin.fr', '$2a$10$U/Eca8Iqa.RrxcntkqY60etOrifWFPdMAvvaUG.YSglatp4A0wK6C', 'Lyon', 'admin', 'admin'),
(2, 'user@user.fr', '$2a$10$LiMMGi3/uJuVuKBalHhuGeZNYJdZn59H4IX1ZLE/AxaHClr5Ifcp6', 'Lyon', 'user', 'user'),
(3, 'guillaume.artignan@ipi.fr', '$2a$10$GR1nWEkiCwJKC.yltbv8yOY362Vk5wi/IQaB6f9vLKdrgTyDBjPPW', 'Marseille', 'user', 'Guillaume'),
(4, 'julien@free.fr', '$2a$10$J/5ftjVMxRNnfIpe8l3IK.09SqMdZYZxC/gGF3RBOalAekR2Yu4by', 'Valence', 'user', 'Juju'),
(5, 'luc.dahan@gmail.com', '$2a$10$qxQobscbKr4o8.RNvrEfpedsnLnzN2FwjawMjZvWo/QdFSOvHYGsm', 'Strasbourg', 'user', 'Luc Skywalker'),
(6, 'papa@gmail.com', '$2a$10$jnPlQ4U/YkqxMmB2NX26COUOGsFH2i4fWvO0/dPK0YD.IY1b.axPW', 'Lyon', 'user', 'Big Daddy'),
(7, 'montmirail@gmail.com', '$2a$10$obn3PcCSpcWN6zOif7kvHeKZuo7USvCDXYHZW80EeAFUIq1WtptAC', 'Marseille', 'admin', 'Seigneur de Montmirail'),
(8, 'test@test.fr', 'azertyuio', 'Clermont-Ferrand', 'user', 'Testeur ultime'),
(9, 'perenoel@gift.com', '$2a$10$HDjwIuoDQj1VTvDzvM6OBORBimgut7o/BuRjD8WlRyZje7B2ruARm', 'Lyon', 'user', 'Père Noel'),
(10, 'thor@avengers.com', '$2a$10$92vO3F2P6C9i.y.ghYSaTubASsLbyJxYx2pjOo3s2WkLrGUQvNque', 'Lyon', 'user', 'Thor'),
(11, 'batman@gc.com', '$2a$10$DIxziAYWebfa6RIbp4FNb.GTIqP8VT4GW4Jvijs2.dUs7r18MHftG', 'Gotham City', 'user', 'Bat'),
(12, 'albert@mousquetaire.com', '$2a$10$BnSyscLZVNcm6drPM92V6uO82STW8WYJdnMSH.z8fXQYz0tRIwVkG', 'Lyon', 'user', 'Albert le cinquième mousquetaire');


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
