insert into USER (name, email, password)
values ('Student', 'student@student.com', '$2a$10$A5opIpSGfPVBrvNHo0LsC.1Cd3HinSV.gXEU0Io06WLNP.L25Z1FK');

insert into course (name, category) values ( 'Spring boot', 'Programming' );
insert into course (name, category) values ( 'Clojure', 'Programming' );

insert into topic (title, message, created_at, status, author_id, course_id) values ( 'Doubt', 'Error', '2019-05-05 20:00:00', 'NOT_ANSWERED', 1, 1);
insert into topic (title, message, created_at, status, author_id, course_id) values ( 'Doasdasdt', 'Error', '2019-05-05 20:00:00', 'NOT_ANSWERED', 1, 1);
insert into topic (title, message, created_at, status, author_id, course_id) values ( 'Dfskdfsbt', 'Error', '2019-05-05 20:00:00', 'NOT_ANSWERED', 1, 1);