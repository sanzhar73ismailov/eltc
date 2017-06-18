ALTER TABLE `student` DROP COLUMN `email_office`;
ALTER TABLE `student` DROP COLUMN `email_home`;
ALTER TABLE `student` DROP COLUMN `email_add`;
commit;

ALTER TABLE `email` CHANGE COLUMN `not_actual` `is_actual` TINYINT(1) NOT NULL COMMENT 'Является ли email актуальным';
ALTER TABLE `email` CHANGE COLUMN `unsubscribe` `subscribe` TINYINT(1) NOT NULL COMMENT 'Подписан ли на рассылку';
ALTER TABLE `email` MODIFY COLUMN `email_type_id` INTEGER(11) NOT NULL;
ALTER TABLE `email` MODIFY COLUMN `student_id` INTEGER(11) NOT NULL;
ALTER TABLE `email` ADD column  `user` VARCHAR(20) DEFAULT NULL COMMENT 'пользователь';
ALTER TABLE `email` ADD column   `insert_datetime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'время добавления записи';
update email set email.`is_actual`=1, email.`subscribe`=1;
update email set email.`insert_datetime` =null;

ALTER TABLE `student_organization` ADD COLUMN `department` VARCHAR(200) DEFAULT NULL COMMENT 'Отдел' AFTER `organization_id`;
ALTER TABLE `student_organization` ADD COLUMN `status` VARCHAR(40) DEFAULT NULL COMMENT 'Должность' AFTER `department`;
ALTER TABLE `student_organization` ADD column  `user` VARCHAR(20) DEFAULT NULL COMMENT 'пользователь';
ALTER TABLE `student_organization` ADD column   `insert_datetime` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'время добавления записи';
ALTER TABLE `student_organization` MODIFY COLUMN `date` DATE NOT NULL COMMENT 'Дата внесения записи';

ALTER TABLE `organization` ADD CONSTRAINT `organization_fk` FOREIGN KEY (`region_id`) REFERENCES `region` (`id`);
ALTER TABLE `organization` MODIFY COLUMN `name_en` VARCHAR(255) COLLATE utf8_general_ci DEFAULT '' COMMENT 'наименование на английском (если основное наименование уже на английском, то совпдает)'