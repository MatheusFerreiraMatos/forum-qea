INSERT INTO MEMBER(first_name, last_name, email, password) VALUES('Matheus', 'Matos', 'matheus.matos@forumqa.com', '123456');

INSERT INTO CATEGORY(name) VALUES('Java');
INSERT INTO CATEGORY(name) VALUES('Spring Boot');
INSERT INTO CATEGORY(name) VALUES('Spring Data');

INSERT INTO TOPIC(title, message, creation_date, status, author_id, category_id) VALUES('Dúvida I', 'Erro ao criar projeto Spring', '2023-12-26 18:00:00', 'NOT_ANSWERED', 1, 1);
INSERT INTO TOPIC(title, message, creation_date, status, author_id, category_id) VALUES('Dúvida II', 'Projeto não compila no Java', '2023-12-27 19:00:00', 'NOT_ANSWERED', 1, 2);
INSERT INTO TOPIC(title, message, creation_date, status, author_id, category_id) VALUES('Dúvida III', 'Tag HTML', '2023-12-29 20:00:00', 'NOT_ANSWERED', 1, 3);