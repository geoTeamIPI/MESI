CREATE TABLE `users` (
	`id` MEDIUMINT(10) NOT NULL AUTO_INCREMENT,
	`email` VARCHAR(10) NOT NULL UNIQUE,
	`password` VARCHAR(10) NOT NULL,
	`city` VARCHAR(10) NOT NULL,
	`profile` varchar(20) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `stories` (
	`id` MEDIUMINT(10) NOT NULL AUTO_INCREMENT UNIQUE,
	`title` VARCHAR(255) NOT NULL,
	`description` TEXT NOT NULL,
	`content` TEXT NOT NULL,
	`creator_id` MEDIUMINT NOT NULL,
	`place_id` MEDIUMINT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `places` (
	`id` MEDIUMINT(10) NOT NULL AUTO_INCREMENT,
	`long` varchar(90) NOT NULL,
	`lat` varchar(90) NOT NULL,
	`street` VARCHAR(255) NULL,
	`city` VARCHAR(255) NULL,
	`zip_code` VARCHAR(5) NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `timelapses` (
	`id` MEDIUMINT(10) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(100) NOT NULL UNIQUE,
	`story_id` MEDIUMINT(10) NOT NULL,
	`time_id` MEDIUMINT(10) NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `docs` (
	`id` MEDIUMINT(10) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(10) NOT NULL,
	`comment` VARCHAR(200),
	`story_id` MEDIUMINT(10) NOT NULL,
	`path` TEXT NOT NULL,
	PRIMARY KEY (`id`)
);

CREATE TABLE `Type` (
	`id` MEDIUMINT(10) NOT NULL AUTO_INCREMENT,
	`name` varchar(200) NOT NULL UNIQUE,
	`storyId` MEDIUMINT(10) NOT NULL UNIQUE,
	`type_id` MEDIUMINT(10) NOT NULL UNIQUE,
	PRIMARY KEY (`id`)
);

CREATE TABLE `votes_users_stories` (
	`voter_id` BINARY NOT NULL,
	`story_id` BINARY NOT NULL,
	`value` BOOLEAN NOT NULL
);

ALTER TABLE `stories` ADD CONSTRAINT `stories_fk0` FOREIGN KEY (`creator_id`) REFERENCES `users`(`id`);

ALTER TABLE `stories` ADD CONSTRAINT `stories_fk1` FOREIGN KEY (`place_id`) REFERENCES `places`(`id`);

ALTER TABLE `timelapses` ADD CONSTRAINT `timelapses_fk0` FOREIGN KEY (`story_id`) REFERENCES `stories`(`id`);

ALTER TABLE `timelapses` ADD CONSTRAINT `timelapses_fk1` FOREIGN KEY (`time_id`) REFERENCES `timelapses`(`id`);

ALTER TABLE `docs` ADD CONSTRAINT `docs_fk0` FOREIGN KEY (`story_id`) REFERENCES `stories`(`id`);

ALTER TABLE `Type` ADD CONSTRAINT `Type_fk0` FOREIGN KEY (`storyId`) REFERENCES `stories`(`id`);

ALTER TABLE `Type` ADD CONSTRAINT `Type_fk1` FOREIGN KEY (`type_id`) REFERENCES `Type`(`id`);

ALTER TABLE `votes_users_stories` ADD CONSTRAINT `votes_users_stories_fk0` FOREIGN KEY (`voter_id`) REFERENCES `users`(`id`);

ALTER TABLE `votes_users_stories` ADD CONSTRAINT `votes_users_stories_fk1` FOREIGN KEY (`story_id`) REFERENCES `stories`(`id`);

