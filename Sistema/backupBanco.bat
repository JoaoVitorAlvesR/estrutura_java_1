set path_old=%path%
set PGPASSWORD=%2
set path=C:\Program Files\PostgreSQL\15\bin;%path%
start pg_dump -h localhost -p 5432 -U %1 -w -F c -b -v -f %3 sistema
set path=%path_old%
set path_old=
set PGPASSWORD=
pause