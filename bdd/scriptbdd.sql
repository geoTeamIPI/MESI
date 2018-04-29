CREATE TABLE `users` (
	`id` BIGINT(10) NOT NULL AUTO_INCREMENT,
	`email` VARCHAR(50) NOT NULL UNIQUE,
	`password` VARCHAR(30) NOT NULL,
	`city` VARCHAR(50) NOT NULL,
	`profile` VARCHAR(20) NOT NULL DEFAULT "user",
	PRIMARY KEY (`id`)
);

CREATE TABLE `stories` (
	`id` BIGINT(10) NOT NULL AUTO_INCREMENT,
	`title` VARCHAR(255) NOT NULL,
	`description` TEXT NULL,
	`content` TEXT NULL,
	`creator_id` BIGINT NOT NULL,
	`place_id` BIGINT NOT NULL,
	`type_id` BIGINT NOT NULL,
	`starting_year` INT(10) NULL,
	`starting_month` INT(2) NULL,
	`starting_day` INT(2) NULL,
	`ending_year` INT(10) NULL,
	`ending_month` INT(2) NULL,
	`ending_day` INT(2) NULL,
	`date_creation` DATE NOT NULL,
	`date_update` DATE NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `places` (
	`id` BIGINT(10) NOT NULL AUTO_INCREMENT,
	`longitude` varchar(90) NOT NULL,
	`latitude` varchar(90) NOT NULL,
	`number_street` VARCHAR(10) NULL,
	`street` VARCHAR(255) NULL,
	`city` VARCHAR(255) NULL,
	`zip_code` VARCHAR(10) NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `timelapses` (
	`id` BIGINT(10) NOT NULL AUTO_INCREMENT,
	`period` VARCHAR(255) NOT NULL UNIQUE,
	`starting_year` INT(10) NOT NULL,
	`ending_year` INT(10) NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `types` (
	`id` BIGINT(10) NOT NULL AUTO_INCREMENT,
	`name` varchar(255) NOT NULL UNIQUE,
	`type_id` BIGINT(10) NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `media` (
	`id` BIGINT(10) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(255) NOT NULL,
	`comment` TEXT NULL,
	`path` TEXT NOT NULL,
	`story_id` BIGINT(10) NOT NULL,
	`date_creation` DATE NOT NULL,
	`date_update` DATE NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `votes` (
	`id` BIGINT(10) NOT NULL AUTO_INCREMENT,
	`voter_id` BIGINT(10) NOT NULL,
	`story_id` BIGINT(10) NOT NULL,
	`value` BOOLEAN NOT NULL,
	`comment` enum('Excellent', 'Tres_bon', 'bon', 'Informations_fausses', 'Acte_de_troll') DEFAULT 'bon',
	`date_creation` DATE NOT NULL,
	`date_update` DATE NULL,
	PRIMARY KEY (`id`)
);

ALTER TABLE `stories` ADD CONSTRAINT `stories_fk0` FOREIGN KEY (`creator_id`) REFERENCES `users`(`id`);

ALTER TABLE `stories` ADD CONSTRAINT `stories_fk1` FOREIGN KEY (`place_id`) REFERENCES `places`(`id`);

ALTER TABLE `stories` ADD CONSTRAINT `stories_fk2` FOREIGN KEY (`type_id`) REFERENCES `types`(`id`);

ALTER TABLE `media` ADD CONSTRAINT `media_fk0` FOREIGN KEY (`story_id`) REFERENCES `stories`(`id`);

ALTER TABLE `types` ADD CONSTRAINT `types_fk0` FOREIGN KEY (`type_id`) REFERENCES `types`(`id`);

ALTER TABLE `votes` ADD CONSTRAINT `votes_fk0` FOREIGN KEY (`voter_id`) REFERENCES `users`(`id`);

ALTER TABLE `votes` ADD CONSTRAINT `votes_fk1` FOREIGN KEY (`story_id`) REFERENCES `stories`(`id`);

