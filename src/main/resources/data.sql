INSERT INTO user(name, password, authority)
VALUES('user', '$2a$10$3iU1Z.Q8FcUkVK1..fUgDeLYQE/0DwYtRJk5VgLuI5pl7T5RecH.a', 'ROLE_USER');

INSERT INTO todo(userId, title, significance, method, barrier, advantage, disadvantage)
VALUES(1, 'やりたいこと', '達成の目的', '達成のための具体的な方法', '達成における障壁', '達成するメリット', '達成しないデメリット')