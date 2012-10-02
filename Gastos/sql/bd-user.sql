CREATE DATABASE gastos_v2;
CREATE USER 'gastos'@'localhost' IDENTIFIED BY 'natalia';
GRANT ALL ON gastos_v2.* TO 'gastos'@'localhost' WITH GRANT OPTION;