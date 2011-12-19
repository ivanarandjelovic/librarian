use ${db.root.name};

create database if not exists ${db.name};

GRANT ALL PRIVILEGES ON ${db.name}.* TO '${db.user}'@'localhost' WITH GRANT OPTION;
