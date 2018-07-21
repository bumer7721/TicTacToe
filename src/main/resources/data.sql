insert into `GAME` (`name`, `status`) values('game1', 'X_WON');
insert into `GAME` (`name`, `status`) values('game2', 'O_WON');

--CREATE TABLE `STEP` (
--	`id` int NOT NULL AUTO_INCREMENT,
--	`game_id` int NOT NULL,
--	`number_of_step` int(1) NOT NULL,
--	`x` int(1) NOT NULL,
--	`y` int(1) NOT NULL,
--	PRIMARY KEY (`id`)
--);
--
--ALTER TABLE `STEP` ADD CONSTRAINT `STEP_fk0` FOREIGN KEY (`game_id`) REFERENCES `GAME`(`id`);
