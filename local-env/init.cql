CREATE KEYSPACE "spring_cassandra"
    WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 3};

USE spring_cassandra;
CREATE TABLE vet (
                     id          text primary key,
                     name        text,
                     surname     text,
                     specialties text
);