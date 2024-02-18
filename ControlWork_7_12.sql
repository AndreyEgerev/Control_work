/*7. В подключенном MySQL репозитории создать базу данных “Друзья
человека”
*/
DROP DATABASE IF EXISTS HumanFriends;
CREATE DATABASE HumanFriends;
USE HumanFriends;

/* 8. Создать таблицы с иерархией из диаграммы в БД
*/

DROP TABLE IF EXISTS cat;
CREATE TABLE cat (
	id INT PRIMARY KEY AUTO_INCREMENT,
	animal_name VARCHAR(50),
    commands TEXT,
    date_of_birth DATE
);

DROP TABLE IF EXISTS dog;
CREATE TABLE dog (
	id INT PRIMARY KEY AUTO_INCREMENT,
	animal_name VARCHAR(50),
    commands TEXT,
    date_of_birth DATE
);

DROP TABLE IF EXISTS hamster;
CREATE TABLE hamster (
	id INT PRIMARY KEY AUTO_INCREMENT,
	animal_name VARCHAR(50),
    commands TEXT,
    date_of_birth DATE
);

DROP TABLE IF EXISTS horse;
CREATE TABLE horse (
	id INT PRIMARY KEY AUTO_INCREMENT,
	animal_name VARCHAR(50),
    commands TEXT,
    date_of_birth DATE
);

DROP TABLE IF EXISTS camel;
CREATE TABLE camel (
	id INT PRIMARY KEY AUTO_INCREMENT,
	animal_name VARCHAR(50),
    commands TEXT,
    date_of_birth DATE
);

DROP TABLE IF EXISTS donkey;
CREATE TABLE donkey (
	id INT PRIMARY KEY AUTO_INCREMENT,
	animal_name VARCHAR(50),
    commands TEXT,
    date_of_birth DATE
);

/* 9. Заполнить низкоуровневые таблицы именами(животных), командами
которые они выполняют и датами рождения
*/
INSERT INTO cat (animal_name,commands, date_of_birth) 
VALUES 
	('Barsik', 'Sit', '2021-01-01'),
	('Bagira', 'Meow,Stand', '2018-08-10'),
    ('Myrka', 'Meow,Jump', '2020-02-02'),
    ('Lord', 'Meow,Jump', '2021-02-01'),
    ('Jonny', 'Meow,Jump', '2020-12-30'),
    ('Tom', 'Meow', '2022-03-03');
   
INSERT INTO dog (animal_name,commands, date_of_birth) 
VALUES 
	('Muxtar', 'Paw,Run', '2021-01-01'),
	('Butch', 'Sit', '2019-12-10'),
    ('Max', 'Paw,Run,Jump', '2020-02-02'),
    ('Ledi', 'Paw,Sit', '2022-03-03'),
    ('Reks', 'Voice,Run,Jump,Paw', '2018-05-05');
    
INSERT INTO hamster (animal_name,commands, date_of_birth) 
VALUES 
	('Xoma', 'Eat', '2023-01-01'),
	('Sem', 'Run,Spin', '2021-12-30'),
    ('Bysik', 'Run', '2020-02-02'),
    ('Bazzy', 'Run,Spin', '2022-07-03'),
    ('Georg', 'Run', '2019-06-06');
    
INSERT INTO horse (animal_name,commands, date_of_birth) 
VALUES 
	('Julius', 'Trot,Gallop', '2017-01-01'),
	('Thunder', 'Walk,Carry Load', '2019-09-10'),
    ('Storm', 'Trot,Gallop,Jump', '2020-04-24'),
    ('Blaze', 'Trot,Gallop,Jump', '2022-03-03');
    
INSERT INTO camel (animal_name,commands, date_of_birth) 
VALUES 
	('Arata', 'Walk,Carry Load', '2021-01-01'),
	('Sandy', 'Walk,Carry Load', '2019-12-10'),
    ('Maria', 'Walk,Carry Load', '2020-02-02'),
    ('Dune', 'Walk,Carry Load', '2022-03-03'),
    ('Sahara', 'Walk,Run', '2018-05-05');
SELECT * FROM camel;    
INSERT INTO donkey (animal_name,commands, date_of_birth) 
VALUES 
	('Ia', 'Walk,Carry Load', '2021-01-01'),
	('Moses', 'Walk,Carry Load', '2019-12-10'),
    ('Jekass', 'Walk,Carry Load', '2020-02-02'),
    ('Donk', 'Walk,Carry Load', '2022-03-03');
SELECT * FROM donkey;
/* 10. Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой
питомник на зимовку. Объединить таблицы лошади, и ослы в одну таблицу
*/
TRUNCATE camel;
DROP TABLE IF EXISTS pack_animal;
CREATE TABLE pack_animal (
	id INT PRIMARY KEY AUTO_INCREMENT,
	animal_name VARCHAR(50),
    commands TEXT,
    date_of_birth DATE
);

INSERT INTO pack_animal(animal_name, commands, date_of_birth)
SELECT animal_name, commands, date_of_birth
FROM horse
UNION ALL
SELECT animal_name, commands, date_of_birth 
FROM donkey
UNION ALL
SELECT animal_name, commands, date_of_birth 
FROM camel;

SELECT * FROM pack_animal;

/* 11. Создать новую таблицу “молодые животные” в которую попадут все
животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью
до месяца подсчитать возраст животных в новой таблице
*/
DELIMITER $$
CREATE FUNCTION age (date_of_birth DATE)
RETURNS VARCHAR(20)
DETERMINISTIC
BEGIN
    DECLARE age VARCHAR(20) DEFAULT '';
	SET age = CONCAT(
            TIMESTAMPDIFF(YEAR, date_of_birth, CURRENT_DATE()), ' years ',
            TIMESTAMPDIFF(MONTH, date_of_birth, CURRENT_DATE()) % 12, ' month');
	RETURN age;
END $$
DELIMITER ;
-- отределяем количество месяцев, а не количество лет для более точного определения возраста сортировки
CREATE or REPLACE VIEW young_animals AS
SELECT *, age(date_of_birth) AS 'age'
FROM cat
WHERE timestampdiff(MONTH, date_of_birth, CURRENT_DATE()) BETWEEN 12 AND 36
UNION ALL
SELECT *, age(date_of_birth) AS 'age'
FROM dog
WHERE timestampdiff(MONTH, date_of_birth, CURRENT_DATE()) BETWEEN 12 AND 36
UNION ALL
SELECT *, age(date_of_birth) AS 'age'
FROM hamster
WHERE timestampdiff(MONTH, date_of_birth, CURRENT_DATE()) BETWEEN 12 AND 36
UNION ALL
SELECT *, age(date_of_birth) AS 'age'
FROM horse
WHERE timestampdiff(MONTH, date_of_birth, CURRENT_DATE()) BETWEEN 12 AND 36
UNION ALL
SELECT *, age(date_of_birth) AS 'age'
FROM camel
WHERE timestampdiff(MONTH, date_of_birth, CURRENT_DATE()) BETWEEN 12 AND 36
UNION ALL
SELECT *, age(date_of_birth) AS 'age'
FROM donkey
WHERE timestampdiff(MONTH, date_of_birth, CURRENT_DATE()) BETWEEN 12 AND 36;

SELECT * FROM young_animals;

/* 12. Объединить все таблицы в одну, при этом сохраняя поля, указывающие на
прошлую принадлежность к старым таблицам
*/

CREATE or REPLACE VIEW animals AS
SELECT *, 'cat' AS 'type'
FROM cat
UNION ALL
SELECT *, 'dog' AS 'type'
FROM dog
UNION ALL
SELECT *, 'hamster' AS 'type'
FROM hamster
UNION ALL
SELECT *, 'horse' AS 'type'
FROM horse
UNION ALL
SELECT *, 'camel' AS 'type'
FROM camel
UNION ALL
SELECT *, 'donkey' AS 'type'
FROM donkey;

SELECT * FROM animals;


