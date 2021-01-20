CREATE TABLE aumi4492.Transportas
( 
		id serial,
    AIN          VARCHAR(32)      NOT NULL,
    Marke      VARCHAR(15)   NOT NULL,
    Modelis      VARCHAR(20)   NOT NULL,     

    PRIMARY KEY  (AIN)
); -- padaryta lentele


CREATE TABLE aumi4492.Krovinys
( 
    KN         VARCHAR(32)      NOT NULL,
    atvezimo_data     date     NOT NULL check (atvezimo_data > current_date ),
    CMR     VARCHAR(20)   NOT NULL,     
    PRIMARY KEY  (KN)
);  -- sukuriau 


CREATE TABLE aumi4492.Automobilis
(
    AIN          VARCHAR(32)      NOT NULL,
    Gaminimo_data    date      NOT NULL check (gaminimo_data < current_date +1 ),
    vieta VARCHAR(15) default 'nera',
    uzsakovas          VarCHAR(15),
    Uzdarbis int not null, 
    krovinys VARCHAR(32),
    PRIMARY KEY  (AIN),
    FOREIGN KEY  (AIN) REFERENCES Transportas on delete cascade,
    FOREIGN KEY  (krovinys) REFERENCES Krovinys
);  -- sukuriau


CREATE TABLE aumi4492.Autovezis 
(
    AIN          VARCHAR(32)      NOT NULL,
    krovinys   VARCHAR(32) , 
    Rida     int not null check (rida >0) default 1, 
    Kaina  	  int   NOT NULL    CHECK (Kaina > 0),

    PRIMARY KEY   (AIN),
    FOREIGN KEY   (AIN) REFERENCES Transportas 
                                ON DELETE CASCADE,
   Foreign key (Krovinys) references krovinys on delete set null
); -- sukuriau !!!!!


CREATE TABLE aumi4492.vairuotojas
(
    Vardas         VARCHAR(15)   NOT NULL,
    Pavarde        VARCHAR(20)   NOT NULL,
    Sutarties_data       DATE          NOT NULL   check ( sutarties_data < current_date+1),

    PN   VARCHAR(15) not null,
   autovezis         VARCHAR(32)      NOT NULL, 

    PRIMARY KEY (PN),
    FOREIGN KEY (autovezis) REFERENCES autovezis
                                            ON DELETE set null
); -- sukuriau !

CREATE INDEX automobiliui ON aumi4492.transportas(marke, modelis);


CREATE INDEX vairuotojui ON aumi4492.vairuotojas(vardas, pavarde);


create unique index kroviniui on aumi4492.krovinys(cmr);

create view nepakrautiAutomobiliai as Select aumi4492.automobilis.vieta, aumi4492.automobilis.Ain, aumi4492.automobilis.uzdarbis from aumi4492.automobilis where krovinys is null;



CREATE MATERIALIZED VIEW uzdarbis_is_kroviniu AS SELECT count(*), krovinys FROM automobilis
group by krovinys;


CREATE FUNCTION vietuMax() RETURNS "trigger" AS $$
DECLARE yra   SMALLINT;
    BEGIN

  
        SELECT COUNT(*) INTO yra FROM automobilis
              WHERE krovinys= NEW.krovinys;
        
        IF yra >= 9
            THEN RAISE EXCEPTION 'Autovezyje nera pakankamai vietos !';
        END IF;
        RETURN NEW;
    END;
$$
LANGUAGE plpgsql;

CREATE TRIGGER pilnumui
    BEFORE INSERT OR UPDATE ON Automobilis
    FOR EACH ROW EXECUTE PROCEDURE vietuMax();


-- padariau viena triggeri



create function NevairuojaDvieju() returns "trigger" as $$
declare vairuoja smallint;
begin 
   
        SELECT COUNT(*) INTO vairuoja FROM vairuotojas
              WHERE autovezis= NEW.autovezis;
        
        IF vairuoja >1 
            THEN RAISE EXCEPTION 'Vairuotojas negali vairuoti 2 sunkvezimiu!';
        END IF;
        RETURN NEW;
    END;
$$
LANGUAGE plpgsql;

create trigger Vairavimui
 before insert or update on Vairuotojas
 for each row execute procedure nevairuojaDvieju();

 -- padarytas dar vienas triggeris
 
 
 
 
 
create function NevairuojaDaugiauDvieju() returns "trigger" as $$
declare vairuoja smallint;
begin 
   
        SELECT COUNT(*) INTO vairuoja FROM vairuotojas, autovezis
              WHERE vairuotojas.autovezis = autovezis.ain;
        
        IF vairuoja >2 
            THEN RAISE EXCEPTION 'Vairuoti gali tik 2 =mones!';
        END IF; 
        RETURN NEW;
    END;
$$
LANGUAGE plpgsql;

create trigger autoveziovairuotojai
 before insert or update on Vairuotojas
 for each row execute procedure nevairuojaDaugiauDvieju();
--- padarytas


 insert into transportas values (default,'01','mercedes-benz','Maybach');
 insert into transportas values (default,'02','mercedes-benz','A200');
 insert into transportas values (default,'03','mercedes-benz','Actros');
 insert into transportas values (default,'04','Scania','P420');
 insert into transportas values (default,'05','Scania','P410');
 insert into transportas values (default,'06','Toyota','Avensis');
insert into transportas values(default,'07', 'Toyota', ' Yaris');
insert into transportas values(default,'08', 'Toyota', 'Supra');
insert into transportas values(default,'09', 'Toyota   ', 'Corola');
insert into transportas values(default,'10', 'BMW', 'E30');
insert into transportas values(default,'11', 'BMW', ' e34');
insert into transportas values(default,'12', 'BMW', 'e60');
insert into transportas values(default,'13', 'VW', 'Passat');
insert into transportas values(default,'14', 'VW', 'Golf ');
insert into transportas values(default,'15', 'VW', 'Beatle');
insert into transportas values(default,'16', 'VW', ' multivan');
insert into transportas values(default,'17', 'opel ', 'zefira');
insert into transportas values(default,'18', 'seat ', 'altea');
insert into transportas values(default,'19', ' Honda', ' Civic');

insert into krovinys values ('k01', '2019-06-08', 'cmr2');
insert into krovinys values ('k02', '2020-09-06', 'cmr');


insert into automobilis values ('01', '1998-01-01' ,'Vilnius' ,'Blinda', 450, null);
insert into automobilis values ('06', '2000-01-01' , 'kaunas' ,'Blinda', 200, 'k01');
insert into automobilis values ('07', '1997-01-01' , 'marselis' ,'JonasPetrausk', 1200, 'k01');
insert into automobilis values ('08', '1998-01-01' , 'peru' ,'Gangsteris', 9999, 'k01');
insert into automobilis values ('09', '2019-01-01' , 'Paryzius','M1011', 350, 'k01');
insert into automobilis values ('10', '2019-01-01' , 'Paryzius','M1011',  180, 'k01');
insert into automobilis values ('11', '2019-01-01' , 'Paryzius', 'M1011', 150, 'k01');
insert into automobilis values ('12', '2019-01-01' , 'Paryzius','M1011',  600, 'k01');
insert into automobilis values ('14', '2019-01-01' , 'Paryzius','M1011',  470, 'k01');
insert into automobilis values ('15', '2019-01-01' , 'Paryzius','M1011',  900, 'k01');
insert into automobilis values ('16', '2019-01-01' , 'Paryzius','M1011',  1000, 'k02');



insert into autovezis values('02','k01',150000,12000);
insert into autovezis values('03','k02',1000,40000);
insert into autovezis values('04',null,1,1000000);
insert into autovezis values('05',null,1,1000000);

insert into vairuotojas values('jonas','jonaitis','2010-01-01','p020','02');
insert into vairuotojas values('migle','jonaite','2010-01-01','p210','02');