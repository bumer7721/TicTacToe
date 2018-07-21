DROP TABLE IF EXISTS `STEP`;
DROP TABLE IF EXISTS `GAME`;

CREATE TABLE `GAME` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `status` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

CREATE TABLE `STEP` (
	`id` int NOT NULL AUTO_INCREMENT,
	`game_id` int NOT NULL,
	`number_of_step` int(1) NOT NULL,
	`x` int(1) NOT NULL,
	`y` int(1) NOT NULL,
	PRIMARY KEY (`id`),
	UNIQUE KEY `props_of_step` (`game_id`, `x`, `y`)
);

ALTER TABLE `STEP` ADD CONSTRAINT `STEP_fk0` FOREIGN KEY (`game_id`) REFERENCES `GAME`(`id`) ON DELETE CASCADE;
