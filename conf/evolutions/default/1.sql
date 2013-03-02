# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table hop_definition (
  name                      varchar(255) not null,
  description               varchar(255),
  alpha_low                 double,
  alpha_high                double,
  beta_low                  double,
  beta_high                 double,
  constraint pk_hop_definition primary key (name))
;

create table user (
  email                     varchar(255) not null,
  first_name                varchar(255),
  last_name                 varchar(255),
  password                  varchar(255),
  constraint pk_user primary key (email))
;

create sequence hop_definition_seq;

create sequence user_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists hop_definition;

drop table if exists user;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists hop_definition_seq;

drop sequence if exists user_seq;

