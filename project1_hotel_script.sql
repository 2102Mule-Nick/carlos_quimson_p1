create schema hotel;

create table employees (
	employee_id serial primary key,
	pass_word text not null,
	first_name text not null,
	last_name text not null, 
	department text not null,
	active boolean
)

create table rooms (
	room_number int primary key,
	room_type text not null,
	room_status text not null,
	room_occupied boolean
)

alter table rooms add room_out_of_service boolean not null;

create table tickets (
	ticket_number serial primary key, 
	room_number int references rooms(room_number) on delete cascade, 
	department text, 
	request text, 
	resolved boolean

)


	