-- SQL-skript for oblig3 i dat107

DROP SCHEMA IF EXISTS oblig3 CASCADE;
CREATE SCHEMA oblig3;
SET search_path TO oblig3;
    
CREATE TABLE Ansatt
(
	ansattID INTEGER NOT NULL,
	brukernavn VARCHAR(45) NOT NULL,
	fornavn VARCHAR(45),
	etternavn VARCHAR(45),
	ansatt_dato DATE,
	stilling VARCHAR(45),
	maanedslonn INTEGER,
	CONSTRAINT Ansatt_pk PRIMARY KEY (ansattID)
);

INSERT INTO
  Ansatt(ansattID, brukernavn, fornavn, etternavn, dato, stilling, maanedslonn)
VALUES
    (2, 'ape', 'Olga', 'Brekkeflat', '2023-06-14', 'Janitor', 1000),
    (4, 'pinne', 'Tor', 'Muhammed', '2023-06-15', 'Stripper', 99999),
    (6, 'stein', 'Reidun', 'Eplekake', '2023-06-16', 'PlasticSurgeon', 50000);

