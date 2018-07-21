insert into game (id, name, status) values(1, 'gameTest1', 'X_WON');
insert into game (id, name, status) values(2, 'game2', 'O_WON');

insert into step (id, game_id, number_of_step, x, y) values(1, 1, 0, 1, 1);
insert into step (id, game_id, number_of_step, x, y) values(2, 1, 1, 0, 0);
insert into step (id, game_id, number_of_step, x, y) values(3, 1, 2, 0, 2);

ALTER TABLE game AUTO_INCREMENT = 100;
ALTER TABLE step AUTO_INCREMENT = 100;