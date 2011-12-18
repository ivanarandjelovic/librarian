use mysql;

create database if not exists dev_librarian;

GRANT ALL PRIVILEGES ON dev_librarian.* TO 'dev_librarian'@'%' WITH GRANT OPTION;
