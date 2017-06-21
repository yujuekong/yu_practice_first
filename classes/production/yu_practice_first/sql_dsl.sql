create TABLE message_practice (
	m_id VARCHAR2(12) not null,
	message_name VARCHAR2(50) ,
	message_note VARCHAR2(100)
);
comment on table message_practice is '信息表';
comment on COLUMN message_practice.m_id is 'ID';
comment on COLUMN message_practice.message_name is '信息名称';
comment on COLUMN message_practice.message_note is '信息内容';
alter table message_practice add constraint PK_M_ID primary key (m_id);