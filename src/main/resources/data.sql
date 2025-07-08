INSERT INTO movie (title, genre, duration)
VALUES ('Inception', 'Sci-Fi', 148),
       ('Titanic', 'Drama', 195),
       ('Avengers: Endgame', 'Action', 181),
       ('The Matrix', 'Sci-Fi', 136),
       ('Interstellar', 'Sci-Fi', 169);

INSERT INTO theater (name, address)
VALUES ('CGV Vincom Center', '72 Lê Thánh Tôn, Quận 1'),
       ('Galaxy Nguyễn Du', '116 Nguyễn Du, Quận 1');

INSERT INTO screen_room (name, capacity, theater_id)
VALUES ('Room 1', 100, 1),
       ('Room 2', 120, 1),
       ('VIP Room', 60, 2);

INSERT INTO seat (seat_number, screen_room_id)
VALUES ('A1', 1),
       ('A2', 1),
       ('A3', 1),
       ('A4', 1),
       ('A5', 1);

INSERT INTO schedule (movie_id, screen_room_id, start_time, end_time, number_seat_empty)
VALUES (1, 1, '2025-07-08 14:00:00', '2025-07-08 16:30:00', 80),
       (2, 2, '2025-07-08 17:00:00', '2025-07-08 20:15:00', 90),
       (3, 3, '2025-07-09 19:00:00', '2025-07-09 21:30:00', 50);
