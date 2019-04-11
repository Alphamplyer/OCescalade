-- ========================================================================= TABLE ========================================================================= --

-- TABLE users

CREATE SEQUENCE public.ocusers_id_seq;

CREATE TABLE public.users (
    id INTEGER NOT NULL DEFAULT nextval('public.ocusers_id_seq'),
    first_name VARCHAR(60) NOT NULL,
    last_name VARCHAR(60) NOT NULL,
    nickname VARCHAR(60) NOT NULL,
    password VARCHAR(255) NOT NULL,
    birthdate DATE NOT NULL,
    inscription_date DATE NOT NULL,
    mail VARCHAR(260) NOT NULL,
    permission_level VARCHAR(1) NOT NULL DEFAULT '0',
    salt VARCHAR(255) NOT NULL,
    CONSTRAINT ocusers_primarykey_constraint PRIMARY KEY (id)
);

ALTER SEQUENCE public.ocusers_id_seq OWNED BY public.users.id;

-- TABLE topo

CREATE SEQUENCE public.topo_id_seq;

CREATE TABLE public.Topo (
    id INTEGER NOT NULL DEFAULT nextval('public.topo_id_seq'),
    author_id INTEGER NOT NULL,
    topo_title VARCHAR(255) NOT NULL,
    topo_description TEXT NOT NULL,
    topo_content TEXT NOT NULL,
    creation_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    topo_like INTEGER NOT NULL DEFAULT '0',
    topo_vues INTEGER NOT NULL DEFAULT '0',
    is_bookable BOOLEAN NOT NULL DEFAULT 'FALSE',
    begin_date TIMESTAMP,
    end_date TIMESTAMP,
    organizer_id INTEGER,
    CONSTRAINT topo_primarykey_constraint PRIMARY KEY (id)
);

ALTER SEQUENCE public.topo_id_seq OWNED BY public.Topo.id;

-- TABLE Comment

CREATE SEQUENCE public.comment_id_seq;

CREATE TABLE public.Comment  (
    id INTEGER NOT NULL DEFAULT nextval('public.comment_id_seq'),
    topo_id INTEGER NOT NULL,
    user_id INTEGER NOT NULL,
    comment_content TEXT NOT NULL,
    creation_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    reply BOOLEAN NOT NULL,
    parent_id INTEGER,
    edited BOOLEAN NOT NULL DEFAULT 'FALSE',
    CONSTRAINT comment_primarykey_constraint PRIMARY KEY (id)
);

ALTER SEQUENCE public.comment_id_seq OWNED BY public.Comment.id;

-- TABLE Site

CREATE SEQUENCE public.site_id_seq;

CREATE TABLE public.Site (
    id INTEGER NOT NULL DEFAULT nextval('public.site_id_seq'),
    topo_id INTEGER NOT NULL,
    site_name VARCHAR(150) NOT NULL,
    site_description TEXT NOT NULL,
    site_elevation NUMERIC(6,2) NOT NULL,
    rock_type VARCHAR(30) NOT NULL,
    CONSTRAINT site_primarykey_constraint PRIMARY KEY (id)
);

ALTER SEQUENCE public.site_id_seq OWNED BY public.Site.id;

-- TABLE Sector

CREATE SEQUENCE public.sector_id_seq;

CREATE TABLE public.Sector (
    id INTEGER NOT NULL DEFAULT nextval('public.sector_id_seq'),
    site_id INTEGER NOT NULL,
    orientation VARCHAR(2) NOT NULL,
    sector_name VARCHAR(150) NOT NULL,
    sector_description TEXT NOT NULL,
    CONSTRAINT sector_primarykey_constraint PRIMARY KEY (id)
);

ALTER SEQUENCE public.sector_id_seq OWNED BY public.Sector.id;

-- TABLE Way

CREATE SEQUENCE public.way_id_seq;

CREATE TABLE public.Way (
    id INTEGER NOT NULL DEFAULT nextval('public.way_id_seq'),
    sector_id INTEGER NOT NULL,
    height NUMERIC(6,2),
    quotation VARCHAR(2) NOT NULL,
    way_name VARCHAR(150) NOT NULL,
    way_description TEXT NOT NULL,
    CONSTRAINT way_primarykey_constraint PRIMARY KEY (id)
);

ALTER SEQUENCE public.way_id_seq OWNED BY public.Way.id;


-- ====================================================================== ALTER TABLE ====================================================================== --

-- TABLE Topo

ALTER TABLE public.Topo ADD CONSTRAINT author_id_topo_fk
FOREIGN KEY (author_id)
REFERENCES public.users (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.Topo ADD CONSTRAINT organizer_id_topo_fk
FOREIGN KEY (organizer_id)
REFERENCES public.users (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

-- TABLE Comment

ALTER TABLE public.Comment ADD CONSTRAINT topo_id_comment_fk
FOREIGN KEY (topo_id)
REFERENCES public.Topo (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.Comment ADD CONSTRAINT user_id_comment_fk
FOREIGN KEY (user_id)
REFERENCES public.users (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE public.Comment ADD CONSTRAINT parent_id_comment_fk
FOREIGN KEY (parent_id)
REFERENCES public.Comment (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

-- TABLE Site

ALTER TABLE public.Site ADD CONSTRAINT topo_id_site_fk
FOREIGN KEY (topo_id)
REFERENCES public.Topo (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

-- TABLE Sector

ALTER TABLE public.Sector ADD CONSTRAINT site_id_sector_fk
FOREIGN KEY (site_id)
REFERENCES public.Site (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

-- TABLE Way

ALTER TABLE public.Way ADD CONSTRAINT sector_id_way_fk
FOREIGN KEY (sector_id)
REFERENCES public.Sector (id)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;