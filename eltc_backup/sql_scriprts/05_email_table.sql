CREATE TABLE `email_type` (
  `id` INTEGER(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(40) COLLATE utf8_general_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`id`),
  UNIQUE KEY `type` (`name`),
  UNIQUE KEY `type_2` (`name`),
  UNIQUE KEY `name` (`name`)
)ENGINE=InnoDB
AUTO_INCREMENT=4 CHARACTER SET 'utf8' COLLATE 'utf8_general_ci';

CREATE TABLE `email` (
  `id` INTEGER(11) NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(100) COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `student_id` INTEGER(11) DEFAULT NULL,
  `email_type_id` INTEGER(11) DEFAULT NULL,
  `not_actual` TINYINT(1) NOT NULL,
  `unsubscribe` TINYINT(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `student_id` (`student_id`),
  KEY `email_type_id` (`email_type_id`),
  CONSTRAINT `student_email_fk` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`),
  CONSTRAINT `student_email_fk1` FOREIGN KEY (`email_type_id`) REFERENCES `email_type` (`id`)
)ENGINE=InnoDB
AUTO_INCREMENT=7084 CHARACTER SET 'utf8' COLLATE 'utf8_general_ci';

/* Data for the `email_type` table  (Records 1 - 3) */

INSERT INTO `email_type` (`id`, `name`) VALUES 
  (1, 'домашняя эл.почта'),
  (3, 'дополнительня эл.почта'),
  (2, 'офисная эл.почта');

insert into email (student_id, `email`, email_type_id, not_actual, unsubscribe)
(select st.id, LOWER(st.email_home), 1, 0, 0 from student st where st.email_home is not null order by st.id);
commit;

insert into email (student_id, `email`, email_type_id, not_actual, unsubscribe)
(select st.id, LOWER(st.email_office), 2, 0, 0 from student st where st.email_office is not null order by st.id);
commit;

insert into email (student_id, `email`, email_type_id, not_actual, unsubscribe)
(select st.id, LOWER(st.email_add), 3, 0, 0 from student st where st.email_add is not null order by st.id);
commit;

--select * from email;