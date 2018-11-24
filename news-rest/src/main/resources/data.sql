INSERT INTO USER(USER_ID,NAME,USERNAME, PASSWORD, ROLE) VALUES (1, 'Szilágyi Erzsébet','zsike123', 'jelszo',  'ROLE_ADMIN');
INSERT INTO USER(USER_ID,NAME,USERNAME, PASSWORD, ROLE) VALUES (2, 'Szilágyi Gábor', 'gabor93', 'jelszo123', 'ROLE_USER');
INSERT INTO USER(USER_ID,NAME,USERNAME, PASSWORD, ROLE) VALUES (3, 'Szalontai Márk', 'mark12345', 'jelszo12345', 'ROLE_ADMIN');
INSERT INTO USER(USER_ID,NAME,USERNAME, PASSWORD, ROLE) VALUES (4,'Molnár Krisztián',  'kiki10', 'kiki10', 'ROLE_USER');
select * from USER;

INSERT INTO ARTICLE(ARTICLE_ID, TITLE, AUTHOR, DATE, SUMMARY, FULL_ARTICLE, ISLEADINGARTICLE) VALUES (1,'Cim', 'Szilágyi Gábor', '2008-11-11', 'Ez egy rövid összefoglaló a cikkről', 'Ez a cikk teljes tartalma', FALSE);

select * from ARTICLE;

INSERT INTO PICTURE(ARTICLE_ID,URL) VALUES ('1', 'valami.jpg');

select * from PICTURE;