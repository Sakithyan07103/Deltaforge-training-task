
create table student_marks_portal.students
(
stdId int primary key auto_increment,
stdName varchar(50),
subRoll int
);

create table student_marks_portal.subjects
(
subId int primary key auto_increment,
subName varchar(50)
);

create table student_marks_portal.exam
(
examId int primary key auto_increment,
examName varchar(50)
);

create table student_marks_portal.marks
(
id int primary key auto_increment,
stdId int ,
subId int,
examId int,
score decimal(5,2),
foreign key (stdId) references students(stdId),
foreign key (subId) references subjects(subId),
foreign key (examId) references exam(examId)
);

INSERT INTO students(stdId, stdname, stdRoll) VALUES (1, 'sakithyan', 108), (2, 'shwetha', 109), (3, 'rohini', 110);
INSERT INTO subjects(subId, subName) VALUES (101, 'Maths'), (102, 'science'), (103, 'English');
INSERT INTO exam(examId, examName) VALUES (201, 'CA-1'), (202, 'CA-2');
INSERT INTO marks(id, stdId, subId, examId, score) VALUES 
(301,1,101,201,80), (302,1,102,201,85), (303,1,103,201,80),
(304,2,101,201,80), (305,2,102,201,85), (306,2,103,201,80),
(307,3,101,201,80), (308,3,102,201,85), (309,3,103,201,80);