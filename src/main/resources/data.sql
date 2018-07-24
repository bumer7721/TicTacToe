insert into game (id, name, status) values(1, 'game1', 'IN_PROGRESS');
insert into game (id, name, status) values(2, 'game2', 'O_WON');

insert into step (id, game_id, number_of_step, x, y) values(1, 1, 1, 2, 2);
insert into step (id, game_id, number_of_step, x, y) values(2, 1, 2, 1, 1);
insert into step (id, game_id, number_of_step, x, y) values(3, 1, 3, 1, 3);

insert into step (id, game_id, number_of_step, x, y) values(4, 2, 1, 1, 1);
insert into step (id, game_id, number_of_step, x, y) values(5, 2, 2, 2, 2);
insert into step (id, game_id, number_of_step, x, y) values(6, 2, 3, 3, 3);
insert into step (id, game_id, number_of_step, x, y) values(7, 2, 4, 1, 3);
insert into step (id, game_id, number_of_step, x, y) values(8, 2, 5, 2, 3);
insert into step (id, game_id, number_of_step, x, y) values(9, 2, 6, 3, 1);

ALTER TABLE game AUTO_INCREMENT = 100;
ALTER TABLE step AUTO_INCREMENT = 100;