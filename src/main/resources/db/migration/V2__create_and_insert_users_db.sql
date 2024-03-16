CREATE TABLE users (
    user_id bigint AUTO_INCREMENT PRIMARY KEY,
    user_name varchar(100) UNIQUE NOT NULL,
    password varchar(64) NOT NULL,
    role varchar(45) NOT NULL,
    enabled bool DEFAULT NULL
);
-- user password jdbcDefault
INSERT INTO users (user_name, password, role, enabled)
VALUES
    ('user',
     '$2a$10$/ALK/o3r8oxFt9vyO3eneeFWHso8OBv5Mbbr8N5dYRAJpPvjLACWS',
     'ROLE_ADMIN',
      true);

--bimbo password strongPassword
INSERT INTO users (user_name, password, role, enabled)
VALUES
     ('bimbo',
      '$2a$10$Yu9FA96EO6Tg0.EkX93hRu02JpRi26eKO4bKeEm6/Eh1vKXRl1xk6',
      'ROLE_USER',
       true);

