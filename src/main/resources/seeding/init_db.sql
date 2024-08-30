
SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE IF EXISTS chat_room;
DROP TABLE IF EXISTS chat_member;
SET FOREIGN_KEY_CHECKS = 1;

CREATE TABLE chat_room
(
    chat_room_id INT UNSIGNED AUTO_INCREMENT NOT NULL COMMENT 'Chat Room Id' PRIMARY KEY,
    chat_room_name VARCHAR(50) NOT NULL COMMENT 'Chat Room Name',
    creator_id INT UNSIGNED NOT NULL COMMENT 'Creator Member Id',
    created_dt DATETIME NOT NULL COMMENT 'Created Date Time'
)
COMMENT 'Chat Room Information'
ENGINE=InnoDB DEFAULT CHARSET=utf8mb4  COLLATE utf8mb4_unicode_ci;

CREATE TABLE chat_room_member
(
    seq INT UNSIGNED AUTO_INCREMENT NOT NULL COMMENT 'Chat Room Member seq' PRIMARY KEY,
    chat_room_id VARCHAR(50) NOT NULL COMMENT 'Chat Room Id',
    member_id INT UNSIGNED NOT NULL COMMENT 'Member Id',
    join_dt DATETIME NOT NULL COMMENT 'Join Date Time'
)
    COMMENT 'Chat Room Information'
    ENGINE=InnoDB DEFAULT CHARSET=utf8mb4  COLLATE utf8mb4_unicode_ci;


CREATE TABLE chat_member
(
    chat_member_id INT UNSIGNED AUTO_INCREMENT NOT NULL COMMENT 'Chat Member Id' PRIMARY KEY,
    member_login_id VARCHAR(50) NOT NULL COMMENT 'Member Login Id',
    member_name VARCHAR(50) NOT NULL COMMENT 'Member Name',
    member_nickname VARCHAR(50) NOT NULL COMMENT 'Member Nickname',
    created_dt DATETIME NOT NULL COMMENT 'Created Date Time'
)
    COMMENT 'Chat Member Information'
    ENGINE=InnoDB DEFAULT CHARSET=utf8mb4  COLLATE utf8mb4_unicode_ci;

CREATE TABLE chat_log
(
    seq INT UNSIGNED AUTO_INCREMENT NOT NULL COMMENT 'Chat Log Seq' PRIMARY KEY,
    chat_room_id VARCHAR(50) NOT NULL COMMENT 'Chat Room Id',
    member_id VARCHAR(50) NOT NULL COMMENT 'Member Id',
    message VARCHAR(1000) NOT NULL COMMENT 'Chat Message',
    send_dt DATETIME NOT NULL COMMENT 'Created Date Time'
)
    COMMENT 'Chat Log Information'
    ENGINE=InnoDB DEFAULT CHARSET=utf8mb4  COLLATE utf8mb4_unicode_ci;