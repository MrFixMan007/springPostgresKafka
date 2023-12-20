FROM postgres:12
COPY ./backup3.sql /docker-entrypoint-initdb.d/init.sql
CMD ["docker-entrypoint.sh", "postgres"]
