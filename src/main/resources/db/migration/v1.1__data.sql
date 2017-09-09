delete from music_festival where userId in (1,2);
delete from artist;

insert into music_festival values (1, 'JAPAN JAM BEACH 2015', '幕張メッセ',cast('2015-05-03' as date));
insert into artist values (1, 1, 'Base Ball Bear', 1, cast('2015-05-03 11:00:00' as datetime));
insert into artist values (1, 2, 'サンボマスター', 2, cast('2015-05-03 13:00:00' as datetime));
insert into artist values (1, 3, 'the telephones', 3, cast('2015-05-03 14:00:00' as datetime));
insert into artist values (1, 4, 'パスピエ', 4, cast('2015-05-03 15:00:00' as datetime));
insert into artist values (1, 5, 'the band apart', 5, cast('2015-05-03 15:30:00' as datetime));
insert into artist values (1, 6, '空想委員会', 6, cast('2015-05-03 17:30:00' as datetime));
insert into artist values (1, 7, 'Polysics', 7, cast('2015-05-03 18:00:00' as datetime));
insert into artist values (1, 8, 'ACIDMAN', 8, cast('2015-05-03 18:15:00' as datetime));
insert into artist values (1, 9, 'ZAZEN BOYS', 9, cast('2015-05-03 19:00:00' as datetime));

