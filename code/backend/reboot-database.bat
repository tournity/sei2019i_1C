psql -c "DROP DATABASE IF EXISTS tournity" postgres root

psql -c "CREATE DATABASE tournity" postgres root

psql -c "CREATE EXTENSION POSTGIS" tournity root

sequelize db:migrate

psql -c "\i .seed-database" tournity root