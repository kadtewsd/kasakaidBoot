delete from festival_artist;
delete from music_festival;
delete from artist;

insert into music_festival values (1, 'JAPAN JAM BEACH 2015', '幕張メッセ',cast('2015-05-03' as date));

insert into festival_artist values (1, 1,  1, cast('2015-05-03 11:00:00' as datetime));
insert into festival_artist values (1, 2,  2, cast('2015-05-03 13:00:00' as datetime));
insert into festival_artist values (1, 3,  3, cast('2015-05-03 14:00:00' as datetime));
insert into festival_artist values (1, 4,  4, cast('2015-05-03 15:00:00' as datetime));
insert into festival_artist values (1, 5,  5, cast('2015-05-03 15:30:00' as datetime));
insert into festival_artist values (1, 6,  6, cast('2015-05-03 17:30:00' as datetime));
insert into festival_artist values (1, 7,  7, cast('2015-05-03 18:00:00' as datetime));
insert into festival_artist values (1, 8,  8, cast('2015-05-03 18:15:00' as datetime));
insert into festival_artist values (1, 9,  9, cast('2015-05-03 19:00:00' as datetime));

insert into artist values (1, 'Base Ball Bear');
insert into artist values (1, 'サンボマスター');
insert into artist values (1, 'the telephones');
insert into artist values (1, 'パスピエ');
insert into artist values (1, 'the band apart');
insert into artist values (1, '空想委員会');
insert into artist values (1, 'Polysics');
insert into artist values (1, 'ACIDMAN');
insert into artist values (1, 'ZAZEN BOYS');
