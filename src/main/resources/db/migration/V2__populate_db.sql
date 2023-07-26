INSERT INTO client (name) VALUES
    ('Client 1'), ('Client 2'),
    ('Client 3'), ('Client 4'),
    ('Client 5'), ('Client 6'),
    ('Client 7'), ('Client 8'),
    ('Client 9'), ('Client 10');

INSERT INTO planet (id, name) VALUES
    ('MARS', 'Mars Planet'),
    ('VEN', 'Venus Planet'),
    ('EARTH', 'Earth Planet'),
    ('JUP', 'Jupiter Planet'),
    ('SAT', 'Saturn Planet');

INSERT INTO ticket (created_at, client_id, from_planet_id, to_planet_id) VALUES
    (NOW(), 1, 'MARS', 'VEN'), (NOW(), 2, 'EARTH', 'JUP'),
    (NOW(), 3, 'VEN', 'MARS'), (NOW(), 4, 'MARS', 'SAT'),
    (NOW(), 5, 'JUP', 'VEN'), (NOW(), 6, 'SAT', 'MARS'),
    (NOW(), 7, 'JUP', 'VEN'), (NOW(), 8, 'MARS', 'VEN'),
    (NOW(), 9, 'VEN', 'MARS'), (NOW(), 10, 'JUP', 'VEN');