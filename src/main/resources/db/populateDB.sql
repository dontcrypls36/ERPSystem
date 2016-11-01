DELETE FROM user_roles;
DELETE FROM users;

ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO users (name, surname, email, department, position, password, login)
VALUES ('Artem', 'Pozdnyakov', 'user@yandex.ru', 'IT', 'Java Developer', 'password', 'login');


INSERT INTO user_roles (role, user_id) VALUES
  ('MANAGER', 100000);