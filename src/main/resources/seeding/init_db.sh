#!/bin/bash

mysql --default-character-set=utf8 -u root -p${MYSQL_ROOT_PASSWORD} -D ${MYSQL_DATABASE} < "/docker-entrypoint-initdb.d/init_db.sql"