
    create table Developer (
        devId bigserial not null,
        apiKey uuid,
        email varchar(255),
        primary key (devId)
    );

    create table Post (
        dislikes integer not null,
        likes integer not null,
        idPost bigserial not null,
        userId bigint,
        text varchar(255),
        title varchar(255),
        whoLiked bigint array,
        primary key (idPost)
    );

    create table users (
        id bigserial not null,
        username varchar(255),
        primary key (id)
    );
INSERT INTO users (username, apikey) VALUES ('Dennis', '4b3029f1-98d5-4cf4-9d05-9b3a8a857d2b');
INSERT INTO users (username, apikey) VALUES ('Love', '8d2d68f2-5b51-4a9f-8f64-320a8bc47b1c');
INSERT INTO users (username, apikey) VALUES ('Eric', 'ac5a1fc4-3f39-44f8-bb6d-18491d9a4b7e');
INSERT INTO users (username, apikey) VALUES ('Sam', 'ac5a1fc4-3f39-44f8-bb6d-18491d9a4b7c');
INSERT INTO users (username, apikey) VALUES ('Viktor', 'ac5a1fc4-3f39-44f8-bb6d-18491d9a4b7f');
INSERT INTO Post (title, text, userId, likes, dislikes) VALUES ('Mat', 'Hamburgare är gott', 1, 0, 0);
INSERT INTO Post (title, text, userId, likes, dislikes) VALUES ('Mat', 'Pizza är gott', 1, 0, 0);
INSERT INTO Post (title, text, userId, likes, dislikes) VALUES ('Mat', 'Pannkakor är gott', 1, 0, 0);
INSERT INTO Post (title, text, userId, likes, dislikes) VALUES ('Mat', 'Hamburgare är gott', 2, 0, 0);
INSERT INTO Post (title, text, userId, likes, dislikes) VALUES ('Mat', 'Pizza är gott', 2, 0, 0);
INSERT INTO Post (title, text, userId, likes, dislikes) VALUES ('Mat', 'Pannkakor är gott', 2, 0, 0);

