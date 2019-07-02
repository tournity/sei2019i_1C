use master 
go
create database tournity
go
use tournity
go
/*
create table template(
	id bigint identity primary key,
	created_date datetime default getdate() not null,
	status varchar(50) not null
);
go
*/
create table accounts(
	id bigint identity primary key,
	name varchar(50) not null,
	type varchar(10) default 'user' not null,
	email varchar(100) unique not null,
	encrypted_password varchar(max),
	created_date datetime default getdate() not null,
	status varchar(50) not null,

	check(type in ('user', 'admin', 'super_admin'))
);
go
create table users(
	id bigint identity primary key,
	account bigint references accounts unique not null,
);
go
create table admins(
	id bigint identity primary key,
	account bigint references accounts unique not null,
);
go
create table super_admins(
	id bigint identity primary key,
	account bigint references accounts unique not null,
);
go
create table sports(
	id bigint identity primary key,
	name varchar(50) not null unique,
	description varchar(500),
	created_by bigint references super_admins not null,
	created_date datetime default getdate() not null,
	status varchar(50) not null
);
go
create table user_sports(
	id bigint identity primary key,
	sport bigint references sports not null,
	owner bigint references users not null,
	created_date datetime default getdate() not null,
	status varchar(50) not null,

	unique(sport, owner)
);
go
create table user_sport_groups(
	id bigint identity primary key,
	name varchar(50) not null,
	description varchar(500),
	user_sport bigint references user_sports not null,
	created_date datetime default getdate() not null,
	status varchar(50) not null,

	unique(user_sport, name)
);
go
create table user_sport_group_competitors(
	id bigint identity primary key,
	name varchar(50) not null,
	description varchar(500),
	type varchar(10) not null,
	user_sport_group bigint references user_sport_groups not null,
	created_date datetime default getdate() not null,
	status varchar(50) not null,

	check(type in ('players', 'teams')),
	unique(user_sport_group, name, type)
);
go
create table user_sport_group_players(
	id bigint identity primary key,
	height decimal(5,2) null,
	user_sport_group_competitor bigint references user_sport_group_competitors unique not null
);
go
create table user_sport_group_teams(
	id bigint identity primary key,
	user_sport_group_competitor bigint references user_sport_group_competitors unique not null
);
go
create table user_sport_group_team_players(
	id bigint identity primary key,
	description varchar(500),
	user_sport_group_player bigint references user_sport_group_players unique not null,
	user_sport_group_team bigint references user_sport_group_teams not null,
	created_date datetime default getdate() not null,
	status varchar(50) not null
);
go
create table admin_sports(
	id bigint identity primary key,
	sport bigint references sports not null,
	owner bigint references admins not null,
	created_date datetime default getdate() not null,
	status varchar(50) not null,

	unique(sport, owner)
);
go
create table structures(
	id bigint identity primary key,
	origin varchar(10) not null,
	created_date datetime default getdate() not null,
	status varchar(50) not null,

	check(origin in ('admin', 'user'))
);
go
create table oficial_structures(
	id bigint identity primary key,
	name varchar(50) not null unique,
	structure bigint references structures not null unique,
	creator bigint references admins not null,
	created_date datetime default getdate() not null,
	status varchar(50) not null
);
go
create table user_structures(
	id bigint identity primary key,
	name varchar(50) not null,
	structure bigint references structures not null unique,
	owner bigint references users not null,
	created_date datetime default getdate() not null,
	status varchar(50) not null,

	unique(name, owner)
);
go
create table tournaments(
	id bigint identity primary key,
	name varchar(50) not null,
	description varchar(500),
	start_date datetime not null,
	end_date datetime not null,
	user_sport_group bigint references user_sport_groups not null,
	created_date datetime default getdate() not null,
	status varchar(50) not null
);
go
create table stages(
	id bigint identity primary key,
	start_date datetime not null,
	end_date datetime not null,
	structure bigint references structures not null,
	tournament bigint references tournaments not null,
	created_date datetime default getdate() not null,
	status varchar(50) not null
);
go
create table stage_groups(
	id bigint identity primary key,
	name varchar(50) not null,
	description varchar(500),
	stage bigint references stages not null,
	created_date datetime default getdate() not null,
	status varchar(50) not null
);
go
create table stage_group_competitors(
	id bigint identity primary key,
	stage_group bigint references stage_groups not null,
	user_sport_group_competitor bigint references user_sport_group_competitors not null,
	created_date datetime default getdate() not null,
	status varchar(50) not null,

	unique(stage_group, user_sport_group_competitor)
);
go
create table matches(
	id bigint identity primary key,
	name varchar(50) not null,
	description varchar(500),
	start_date datetime not null,
	end_date datetime not null,
	stage_group bigint references stage_groups not null,
	created_date datetime default getdate() not null,
	status varchar(50) not null,

	unique(name, stage_group)
);
go
create table match_competitors(
	id bigint identity primary key,
	points decimal default 0 not null,
	match bigint references matches not null,
	stage_group_competitor bigint references stage_group_competitors not null,
	created_date datetime default getdate() not null,
	status varchar(50) not null
);
go