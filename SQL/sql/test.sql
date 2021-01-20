Select stud.knyga.metai ,
count(distinct stud.autorius.vardas || stud.autorius.pavarde) as Skaicius,
count(distinct stud.egzempliorius.nr ) As egzemplioriai ,
  sum(stud.knyga.verte)  as verte 
From stud.knyga, stud.autorius, stud.egzempliorius
where stud.knyga.isbn = stud.autorius.isbn and stud.knyga.isbn = stud.egzempliorius.isbn
group by  stud.knyga.metai
order by stud.knyga.metai desc;


with knyguSkaiciaiPerMetus(Metai, egzemplioriuSkaicius)
 	AS (Select stud.knyga.metai, count(stud.egzempliorius.isbn) 
	from stud.knyga, stud.egzempliorius
	where stud.knyga.isbn = stud.egzempliorius.isbn
	Group by stud.knyga.metai
	), 
	KnyguVidurkisPerMetus(Vidurkis, minimalusSkaicius)
	as ( select avg(egzemplioriuSkaicius), 
	min(egzemplioriuSkaicius) from knyguSkaiciaiPerMetus)
select * 
 from knyguSkaiciaiPerMetus, KnyguVidurkisPerMetus
where  egzemplioriuSkaicius > Vidurkis  or egzemplioriuSkaicius  = minimalusSkaicius
order by metai;


SELECT  data_type ,count(data_type) as kiekis
FROM Information_Schema.columns
group by data_Type;


with pirmas(dataTipas, kiekisKiekvienam)
 	AS (SELECT  data_type ,count(data_type) 
FROM Information_Schema.columns
group by data_Type
	), 
	
	
	
antras(isViso,dataTipas)
as(
SELECT  count(distinct table_name),data_type
FROM Information_Schema.columns
group by data_type),



trecias(kiek_nullable,dataTipas) 
as ( select count( is_nullable),data_type
from information_schema.columns
where is_nullable = 'YES'
group by data_Type
),


ketvirtas (ilgiausias,dataTipas)
as(select max(character_maximum_length),data_type from information_schema.columns
group by data_type
),


first_join as (select pirmas.dataTipas as tipas, pirmas.kiekiskiekvienam as stulpeliai, antras.isviso as lenteles
from pirmas
right join antras on antras.dataTipas = pirmas.dataTipas),


second_join as (select first_join.tipas as tipas, first_join.stulpeliai as stul, first_join.lenteles as lent, trecias.kiek_nullable as nullabl 
from first_join
right join trecias on first_join.tipas = trecias.dataTipas ),


third_join as ( select second_join.tipas as tipas, second_join.stul as stul, second_join.lent as lent, second_join.nullabl as nullabl 
, ketvirtas.ilgiausias as ilgiausias from second_join
right join ketvirtas on second_join.tipas = ketvirtas.dataTipas )


select * from third_join




