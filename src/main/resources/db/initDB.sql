DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS tasks;
DROP TABLE IF EXISTS users CASCADE ;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START 100000;

CREATE TABLE users
(
  id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name       VARCHAR NOT NULL,
  surname      VARCHAR NOT NULL,
  email      VARCHAR NOT NULL,
  department      VARCHAR NOT NULL,
  position      VARCHAR NOT NULL,
  login      VARCHAR NOT NULL,
  password   VARCHAR NOT NULL,
  registered TIMESTAMP DEFAULT now()

);

CREATE UNIQUE INDEX users_unique_email_idx ON users (email);

CREATE TABLE user_roles
(
  user_id INTEGER NOT NULL,
  role    VARCHAR,
  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE tasks (
  id          INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
  name  VARCHAR NOT NULL,
description       VARCHAR NOT NULL,
complete       BOOLEAN NOT NULL,
executor_id       INTEGER NOT NULL,
owner_id       INTEGER NOT NULL,
date_time_create    TIMESTAMP NOT NULL,
date_time_complete    TIMESTAMP NOT NULL,
FOREIGN KEY (executor_id) REFERENCES users (id) ON DELETE CASCADE,
FOREIGN KEY (owner_id) REFERENCES users (id) ON DELETE CASCADE
);
