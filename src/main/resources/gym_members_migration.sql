DROP TABLE IF EXISTS membership_card;
DROP TABLE IF EXISTS member;
DROP TABLE IF EXISTS membership_gym;

CREATE TABLE member (
    member_id serial not null,
    first_name varchar (30) not null,
    last_name varchar(30) not null,
    date_of_birth date not null,
    tel_number varchar (20),
    sex varchar(20),
    source_of_advertising varchar(20),
    PRIMARY KEY (member_id)
);

CREATE TABLE membership_gym (
    membership_gym_id serial not null,
    type_of_membership_gym varchar (30) not null,
    number_of_workouts integer not null,
    validity_months integer not null,
    PRIMARY KEY (membership_gym_id)
);

CREATE TABLE membership_card (
    membership_card_id serial not null,
    member_id bigint,
    membership_gym_id bigint,
    marked_workouts integer,
    purchase_date date not null,
    expired_date date not null,
    membership_status varchar (15) not null,
    PRIMARY KEY (membership_card_id),
    FOREIGN KEY (member_id) REFERENCES member(member_id) ON DELETE RESTRICT,
    FOREIGN KEY (membership_gym_id) REFERENCES membership_gym(membership_gym_id) ON DELETE RESTRICT
);



INSERT INTO member (first_name, last_name, date_of_birth, tel_number, sex, source_of_advertising)
VALUES ('Василий', 'Васильев', '12.02.1992', '+375(29)298-42-12', 'мужской', 'instagram'),
('Петр', 'Васильев', '12.02.1992', '+375(29)298-42-12', 'мужской', 'instagram'),
('Анатолий', 'Самсонов', '12.02.1992', '+375(29)298-42-12', 'мужской', 'instagram'),
('Евгений', 'Попов', '12.02.1992', '+375(29)298-42-12', 'мужской', 'instagram'),
('Петр', 'Андреев', '12.02.1992', '+375(29)298-42-12', 'мужской', 'instagram'),
('Егор', 'Ламницкий', '12.02.1992', '+375(29)298-42-12', 'мужской', 'instagram'),
('Дмитрий', 'Сиводедов', '12.02.1992', '+375(29)298-42-12', 'мужской', 'instagram'),
('Антонина', 'Васильева', '12.02.1992', '+375(29)298-42-12', 'мужской', 'instagram'),
('Надежда', 'Простанина', '12.02.1992', '+375(33)272-28-12', 'женский', 'vk');

INSERT INTO membership_gym (type_of_membership_gym, number_of_workouts, validity_months)
VALUES ('ULT1', 16, 1),
('ULT3', 48, 3),
('ULT6', 96, 6),
('ULT12', 192, 12),
('FAM1', 16, 1),
('FAM3', 48, 3),
('FAM6', 96, 6),
('FAM12', 192, 12),
('NT12', 12, 0),
('GR12', 12, 1),
('PER12', 12, 1);


INSERT INTO membership_card (member_id, membership_gym_id, marked_workouts, purchase_date, expired_date, membership_status)
VALUES (1, 1, 1, '28.03.2021', '27.03.2021', 0),
(2, 2, 1, '28.03.2021', '27.03.2021', 0),
(3, 3, 1, '28.03.2021', '27.03.2021', 0),
(4, 4, 1, '28.03.2021', '27.03.2021', 0),
(5, 5, 1, '28.03.2021', '27.03.2021', 0),
(6, 6, 1, '28.03.2021', '27.03.2021', 0),
(7, 7, 1, '28.03.2021', '27.03.2021', 0),
(8, 8, 1, '28.03.2021', '27.03.2021', 0),
(9, 1, 1, '28.03.2021', '27.03.2021', 0);
