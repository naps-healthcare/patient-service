SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_with_oids = false;

DROP TABLE if exists public.patient;

CREATE TABLE public.patient (
    id int NOT NULL,
    patientFullName character varying(255)
);

ALTER TABLE public.patient OWNER TO naps;

CREATE SEQUENCE if not exists public.patient_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
ALTER SEQUENCE public.patient_seq OWNER TO naps;

INSERT INTO public.patient VALUES (nextval('public.patient_seq'), 'Warren Peace');
INSERT INTO public.patient VALUES (nextval('public.patient_seq'), 'Charity Case');
INSERT INTO public.patient VALUES (nextval('public.patient_seq'), 'Earl E. Bird');
INSERT INTO public.patient VALUES (nextval('public.patient_seq'), 'Hazel Nutt');
INSERT INTO public.patient VALUES (nextval('public.patient_seq'), 'Jack Pott');
INSERT INTO public.patient VALUES (nextval('public.patient_seq'), 'Jo King');
INSERT INTO public.patient VALUES (nextval('public.patient_seq'), 'Matt Tress');
INSERT INTO public.patient VALUES (nextval('public.patient_seq'), 'Mike Stand');
INSERT INTO public.patient VALUES (nextval('public.patient_seq'), 'Mona Lott');
INSERT INTO public.patient VALUES (nextval('public.patient_seq'), 'Orson Carte');
INSERT INTO public.patient VALUES (nextval('public.patient_seq'), 'Ray Gunn');
INSERT INTO public.patient VALUES (nextval('public.patient_seq'), 'Sonny Day');
INSERT INTO public.patient VALUES (nextval('public.patient_seq'), 'Adam Zapel');
