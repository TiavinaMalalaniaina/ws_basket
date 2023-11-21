CREATE SEQUENCE "public".action_id_seq START WITH 1;

CREATE SEQUENCE "public".equipe_id_seq START WITH 1;

CREATE SEQUENCE "public".equipe_joueur_id_seq START WITH 1;

CREATE SEQUENCE "public".joueur_id_seq START WITH 1;

CREATE SEQUENCE "public".match_changement_id_seq START WITH 1;

CREATE SEQUENCE "public".match_id_seq START WITH 1;

CREATE SEQUENCE "public".type_action_id_seq START WITH 1;

CREATE SEQUENCE "public".type_action_valeur_id_seq START WITH 1;

CREATE  TABLE "public".equipe (
                                  equipe_id            varchar DEFAULT custom_seq('EQP'::character varying, 'equipe_id_seq'::character varying, 4) NOT NULL ,
                                  nom                  varchar(20)  NOT NULL ,
                                  CONSTRAINT pk_equipe_equipe_id PRIMARY KEY ( equipe_id )
);

CREATE  TABLE "public".joueur (
                                  jouer_id             varchar DEFAULT custom_seq('JR'::character varying, 'joueur_id_seq'::character varying, 4) NOT NULL ,
                                  nom                  varchar(30)  NOT NULL ,
                                  prenom               varchar(30)  NOT NULL ,
                                  dtn                  date  NOT NULL ,
                                  taille               float8  NOT NULL ,
                                  poids                float8  NOT NULL ,
                                  CONSTRAINT pk_joueur_jouer_id PRIMARY KEY ( jouer_id )
);

CREATE  TABLE "public"."match" (
                                   match_id             varchar DEFAULT custom_seq('MTC'::character varying, 'match_id_seq'::character varying, 4) NOT NULL ,
                                   equipe1_id           varchar  NOT NULL ,
                                   equipe2_id           varchar  NOT NULL ,
                                   encours              integer   ,
                                   CONSTRAINT pk_tbl_match_id PRIMARY KEY ( match_id ),
                                   CONSTRAINT fk_match_equipe FOREIGN KEY ( equipe1_id ) REFERENCES "public".equipe( equipe_id )   ,
                                   CONSTRAINT fk_match_equipe_0 FOREIGN KEY ( equipe2_id ) REFERENCES "public".equipe( equipe_id )
);

CREATE  TABLE "public".match_changement (
                                            match_changement_id  varchar DEFAULT custom_seq('MC'::character varying, 'match_changement_id_seq'::character varying, 4) NOT NULL ,
                                            temps                float8   ,
                                            match_id             varchar  NOT NULL ,
                                            joueur_entrant       varchar  NOT NULL ,
                                            joueur_sortant       varchar  NOT NULL ,
                                            CONSTRAINT pk_match_changement_match_changement_id PRIMARY KEY ( match_changement_id ),
                                            CONSTRAINT fk_match_changement_match FOREIGN KEY ( match_id ) REFERENCES "public"."match"( match_id )   ,
                                            CONSTRAINT fk_match_changement_joueur FOREIGN KEY ( joueur_entrant ) REFERENCES "public".joueur( jouer_id )   ,
                                            CONSTRAINT fk_match_changement_joueur_0 FOREIGN KEY ( joueur_sortant ) REFERENCES "public".joueur( jouer_id )
);

CREATE  TABLE "public".type_action (
                                       type_action_id       varchar DEFAULT custom_seq('TYA'::character varying, 'type_action_id_seq'::character varying, 4) NOT NULL ,
                                       nom                  varchar  NOT NULL ,
                                       CONSTRAINT pk_type_action_type_action_id PRIMARY KEY ( type_action_id )
);

CREATE  TABLE "public".type_action_valeur (
                                              type_action_id       varchar  NOT NULL ,
                                              valeur               varchar  NOT NULL ,
                                              CONSTRAINT fk_type_action_valeur_type_action FOREIGN KEY ( type_action_id ) REFERENCES "public".type_action( type_action_id )
);

CREATE  TABLE "public"."action" (
                                    action_id            varchar DEFAULT custom_seq('ACT'::character varying, 'action_id_seq'::character varying, 4) NOT NULL ,
                                    temps                float8  NOT NULL ,
                                    match_id             varchar  NOT NULL ,
                                    joueur_id            varchar  NOT NULL ,
                                    type_action_id       varchar  NOT NULL ,
                                    CONSTRAINT pk_tbl_action_id PRIMARY KEY ( action_id ),
                                    CONSTRAINT fk_action_type_action FOREIGN KEY ( type_action_id ) REFERENCES "public".type_action( type_action_id )   ,
                                    CONSTRAINT fk_action_joueur FOREIGN KEY ( joueur_id ) REFERENCES "public".joueur( jouer_id )
);

CREATE  TABLE "public".equipe_joueur (
                                         equipe_id            varchar  NOT NULL ,
                                         jouer_id             varchar  NOT NULL ,
                                         CONSTRAINT fk_equipe_joueur_equipe FOREIGN KEY ( equipe_id ) REFERENCES "public".equipe( equipe_id )   ,
                                         CONSTRAINT fk_equipe_joueur_joueur FOREIGN KEY ( jouer_id ) REFERENCES "public".joueur( jouer_id )
);

CREATE OR REPLACE FUNCTION public.custom_seq(in_prefix character varying, in_sequence_name character varying, in_digit_count integer)
 RETURNS character varying
 LANGUAGE plpgsql
AS $function$
DECLARE
seq_value INT;
    result VARCHAR;
BEGIN
EXECUTE 'SELECT nextval(''' || in_sequence_name || '''::regclass)' INTO seq_value;
result := in_prefix || LPAD(seq_value::TEXT, in_digit_count, '0');
RETURN result;
END;
$function$
;

INSERT INTO "public".equipe( equipe_id, nom ) VALUES ( 'EQP0001', 'LAKERS');
INSERT INTO "public".equipe( equipe_id, nom ) VALUES ( 'EQP0002', 'UTAH JAZZ');
INSERT INTO "public".joueur( jouer_id, nom, prenom, dtn, taille, poids ) VALUES ( 'JR0001', 'LEBROWN', 'JAMES', '1970-12-12', 180.0, 90.0);
INSERT INTO "public".joueur( jouer_id, nom, prenom, dtn, taille, poids ) VALUES ( 'JR0002', 'CURRY', 'IRVINES', '1970-12-12', 180.0, 90.0);
INSERT INTO "public"."match"( match_id, equipe1_id, equipe2_id, encours ) VALUES ( 'MTC0001', 'EQP0001', 'EQP0002', 0);
INSERT INTO "public".match_changement( match_changement_id, temps, match_id, joueur_entrant, joueur_sortant ) VALUES ( 'MC0003', 30.0, 'MTC0001', 'JR0001', 'JR0001');
INSERT INTO "public".type_action( type_action_id, nom ) VALUES ( 'TYA0001', 'tire');
INSERT INTO "public".type_action_valeur( type_action_id, valeur ) VALUES ( 'TYA0001', '2');
INSERT INTO "public"."action"( action_id, temps, match_id, joueur_id, type_action_id ) VALUES ( 'ACT0001', 50.0, 'MTC0001', 'JR0001', 'TYA0001');
INSERT INTO "public".equipe_joueur( equipe_id, jouer_id ) VALUES ( 'EQP0001', 'JR0001');
INSERT INTO "public".equipe_joueur( equipe_id, jouer_id ) VALUES ( 'EQP0002', 'JR0002');