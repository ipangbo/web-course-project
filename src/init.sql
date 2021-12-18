DROP TABLE IF EXISTS NEWS;
create table NEWS
(
    AID           INT AUTO_INCREMENT,
    ATITLE        VARCHAR(80)                                                     not null,
    AAUTHOR       VARCHAR(20)                                                     not null,
    ACONTENTJSON  MEDIUMTEXT                                                      not null,
    ACONTENTHTML  MEDIUMTEXT                                                      not null,
    AABSTRACTJSON MEDIUMTEXT                                                              ,
    AABSTRACTHTML MEDIUMTEXT                                                              ,
    ACATEGORY     INT       default 1                                                     ,
    ACREATETIME   TIMESTAMP default CURRENT_TIMESTAMP                             not null,
    AMODIFYTIME   TIMESTAMP default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP not null,
    ATYPE         INT       default 1,
    constraint NOTICE_pk
        primary key (AID)
);

DROP TABLE IF EXISTS NOTICE;
create table NOTICE
(
    AID           INT AUTO_INCREMENT,
    ATITLE        VARCHAR(80)                                                     not null,
    AAUTHOR       VARCHAR(20)                                                     not null,
    ACONTENTJSON  MEDIUMTEXT                                                      not null,
    ACONTENTHTML  MEDIUMTEXT                                                      not null,
    AABSTRACTJSON MEDIUMTEXT                                                              ,
    AABSTRACTHTML MEDIUMTEXT                                                              ,
    ACATEGORY     INT       default 1                                                     ,
    ACREATETIME   TIMESTAMP default CURRENT_TIMESTAMP                             not null,
    AMODIFYTIME   TIMESTAMP default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP not null,
    ATYPE         INT       default 2,
    constraint NOTICE_pk
        primary key (AID)
);