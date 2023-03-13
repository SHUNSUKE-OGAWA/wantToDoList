INSERT INTO user(name, password, authority)
VALUES('shun', '$2a$10$3iU1Z.Q8FcUkVK1..fUgDeLYQE/0DwYtRJk5VgLuI5pl7T5RecH.a', 'ROLE_USER');

INSERT INTO todo(userId, title, significance, method, barrier, advantage, disadvantage)
VALUES(1, '目標', '目標達成の目的', '目標達成の具体的な方法', '目標達成における障壁', '目標達成のメリット', '目標達成しないデメリット')