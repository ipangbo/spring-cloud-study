# Spring Cloud Study

学习Spring Cloud的过程

### 初始化数据库
```sql
create table DB_BOOK
(
    bid    int auto_increment
        primary key,
    title  varchar(255) not null,
    `desc` varchar(255) not null
);

INSERT INTO cloudstudy.DB_BOOK (bid, title, `desc`) VALUES (1, '深入理解Java虚拟机', '讲解JVM底层原理');
INSERT INTO cloudstudy.DB_BOOK (bid, title, `desc`) VALUES (2, 'Java并发编程的艺术', '讲解并发编程的各种技术');
INSERT INTO cloudstudy.DB_BOOK (bid, title, `desc`) VALUES (3, 'Java核心技术卷一', '讲解Java的基础知识等');
INSERT INTO cloudstudy.DB_BOOK (bid, title, `desc`) VALUES (4, '计算机网络', '讲解计算机的网络实现原理和知识');


create table DB_USER
(
    uid  int auto_increment
        primary key,
    name varchar(255)      not null,
    age  int               not null,
    sex  enum ('男', '女') not null
);

INSERT INTO cloudstudy.DB_USER (uid, name, age, sex) VALUES (1, '小明', 18, '男');
INSERT INTO cloudstudy.DB_USER (uid, name, age, sex) VALUES (2, '小红', 17, '女');
INSERT INTO cloudstudy.DB_USER (uid, name, age, sex) VALUES (3, '小芳', 18, '女');
INSERT INTO cloudstudy.DB_USER (uid, name, age, sex) VALUES (4, '小刚', 17, '男');


create table DB_BORROW
(
    id  int auto_increment
        primary key,
    uid int not null,
    bid int not null,
    constraint unique_bid_uid
        unique (uid, bid),
    constraint f_bid
        foreign key (bid) references DB_BOOK (bid),
    constraint f_uid
        foreign key (uid) references DB_USER (uid)
);

INSERT INTO cloudstudy.DB_BORROW (id, uid, bid) VALUES (1, 1, 1);
INSERT INTO cloudstudy.DB_BORROW (id, uid, bid) VALUES (2, 1, 3);
```

2022年暑假