delete from `type_ownership` where id > 6;

INSERT INTO `type_ownership` (`id`, `name`, `name_full`, `user`, `insert_datetime`) VALUES (-1,"нет данных", "нет данных", "admin", null);
INSERT INTO `type_ownership` (`id`, `name`, `name_full`, `user`, `insert_datetime`) VALUES (7,"ГО", "Государственный орган", "admin", null);
INSERT INTO `type_ownership` (`id`, `name`, `name_full`, `user`, `insert_datetime`) VALUES (8,"ДГП", "Дочернее государственное предприятие", "admin", null);
INSERT INTO `type_ownership` (`id`, `name`, `name_full`, `user`, `insert_datetime`) VALUES (9,"ЗАО", "Закрытое акционерное общество", "admin", null);
INSERT INTO `type_ownership` (`id`, `name`, `name_full`, `user`, `insert_datetime`) VALUES (10,"ОАО", "Открытое акционерное общество", "admin", null);
INSERT INTO `type_ownership` (`id`, `name`, `name_full`, `user`, `insert_datetime`) VALUES (11,"ООО", "Открытое общественное объединение", "admin", null);
INSERT INTO `type_ownership` (`id`, `name`, `name_full`, `user`, `insert_datetime`) VALUES (12,"РГКП", "Республиканское государственное коммунальное предприятие", "admin", null);
INSERT INTO `type_ownership` (`id`, `name`, `name_full`, `user`, `insert_datetime`) VALUES (13,"СП", "Совместное предприятие", "admin", null);
INSERT INTO `type_ownership` (`id`, `name`, `name_full`, `user`, `insert_datetime`) VALUES (14,"ЧЛ", "Частное лицо", "admin", null);
INSERT INTO `type_ownership` (`id`, `name`, `name_full`, `user`, `insert_datetime`) VALUES (15,"ЧН", "Частный нотариус", "admin", null);
INSERT INTO `type_ownership` (`id`, `name`, `name_full`, `user`, `insert_datetime`) VALUES (16,"ЧУ", "Частное учреждение", "admin", null);
 
 ALTER TABLE `student` MODIFY COLUMN `email_office` VARCHAR(100) 
 COLLATE utf8_general_ci DEFAULT NULL UNIQUE COMMENT 'эл почта - офис';
 
 ALTER TABLE `student` MODIFY COLUMN `email_home` VARCHAR(100) 
 COLLATE utf8_general_ci DEFAULT NULL UNIQUE COMMENT 'эл почта - дом';
 
 ALTER TABLE `student` MODIFY COLUMN `email_add` VARCHAR(100) 
 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'эл почта дополнительная';
 
 ALTER TABLE `student` MODIFY COLUMN `comments` VARCHAR(255) 
 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'примечание по студенту';
 
 ALTER TABLE `organization` DROP FOREIGN KEY `organization_street_fact_fk`;
 ALTER TABLE `organization` DROP FOREIGN KEY `organization_street_official_fk`;
 ALTER TABLE `organization` DROP INDEX `organization_street_official_fk`;
 ALTER TABLE `organization` DROP INDEX `organization_street_fact_fk`;
 
 CREATE TABLE `temp_org` (
  `id` INTEGER(11) NOT NULL,
  `street_house` VARCHAR(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB;

INSERT INTO temp_org (id, street_house) 
(SELECT 
  organization.id,
  CONCAT(street.name,  " ", 
  organization.house_official) as str
FROM
  organization
  INNER JOIN street ON (organization.street_official_id = street.id)
  );
  commit;
  
 ALTER TABLE `organization` DROP COLUMN `house_official`;
 ALTER TABLE `organization` DROP COLUMN `house_fact`;
 ALTER TABLE `organization` CHANGE COLUMN `street_official_id` `street_house_official` VARCHAR(100) DEFAULT NULL COMMENT 'Улица (проспект, переулок) (адрес регистрации), дом, квартира (офис)';
 ALTER TABLE `organization` CHANGE COLUMN `street_fact_id` `street_house_fact` VARCHAR(100) DEFAULT NULL COMMENT 'Улица (проспект, переулок) (адрес фактический), дом, квартира (офис)';
 ALTER TABLE `organization` ADD COLUMN `phone` VARCHAR(60) DEFAULT NULL AFTER `postal_code_fact`;
 
 delete from `country` where id=17;
 INSERT INTO `country` (`id`, `name`, `user`, `insert_datetime`) VALUES (17, 'Германия', 'admin', NULL);
 insert into `city` VALUES (3000, "Stuttgart", 17, "admin", null);
 
INSERT INTO `industry`(`id`, `name`, `user`, `insert_datetime`) 
VALUE (  -1,  "нет данных",  "admin",  null);
 
ALTER TABLE `organization` MODIFY COLUMN `rnn` VARCHAR(40) COLLATE utf8_general_ci 
DEFAULT NULL UNIQUE COMMENT 'РНН';
ALTER TABLE `organization` MODIFY COLUMN `bin` VARCHAR(40) COLLATE utf8_general_ci 
DEFAULT NULL UNIQUE COMMENT 'БИН';
ALTER TABLE `organization` MODIFY COLUMN `bank_name` VARCHAR(40) COLLATE utf8_general_ci DEFAULT NULL COMMENT 'Наименование банка';
ALTER TABLE `organization` MODIFY COLUMN `bank_address` VARCHAR(100) COLLATE utf8_general_ci DEFAULT NULL COMMENT 'Адрес банка';

ALTER TABLE `organization` MODIFY COLUMN `postal_code_official` VARCHAR(20) COLLATE utf8_general_ci DEFAULT NULL COMMENT 'почтовый индекс  (адрес регистрации)';
ALTER TABLE `organization` MODIFY COLUMN `postal_code_fact` VARCHAR(20) COLLATE utf8_general_ci DEFAULT NULL COMMENT 'почтовый индекс  (адрес фактический)';
ALTER TABLE `organization` MODIFY COLUMN `fax` VARCHAR(40) COLLATE utf8_general_ci DEFAULT NULL COMMENT 'факс';
ALTER TABLE `organization` MODIFY COLUMN `bic` VARCHAR(50) COLLATE utf8_general_ci DEFAULT NULL COMMENT 'Банковский идентификационный код (БИК) — уникальный идентификатор банка, используемый в платежных документах';
ALTER TABLE `organization` MODIFY COLUMN `kbe` VARCHAR(40) COLLATE utf8_general_ci DEFAULT NULL COMMENT 'Кбе';
ALTER TABLE `organization` MODIFY COLUMN `bank_name` VARCHAR(200) COLLATE utf8_general_ci DEFAULT NULL COMMENT 'Наименование банка';
ALTER TABLE `organization` DROP INDEX `organization_name`;
ALTER TABLE `organization` ADD INDEX `organization_name` (`name`);

CREATE TABLE `student_organization` (
  `id` INTEGER(11) NOT NULL AUTO_INCREMENT,
  `student_id` INTEGER(11) NOT NULL,
  `organization_id` INTEGER(11) NOT NULL,
  `date` DATE NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `student_org_date_unique` (`student_id`, `organization_id`, `date`),
  KEY `student_id` (`student_id`),
  KEY `organization_id` (`organization_id`),
  CONSTRAINT `student_organization_fk1` FOREIGN KEY (`organization_id`) REFERENCES `organization` (`id`),
  CONSTRAINT `student_organization_fk` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`)
)ENGINE=InnoDB
AUTO_INCREMENT=1 CHARACTER SET 'utf8' COLLATE 'utf8_general_ci';
