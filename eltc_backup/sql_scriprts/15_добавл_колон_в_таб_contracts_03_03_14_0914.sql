ALTER TABLE `contract` MODIFY COLUMN `pdf_file` VARCHAR(200) COLLATE utf8_general_ci DEFAULT NULL COMMENT 'отсканир. вариант';
ALTER TABLE `contract` ADD COLUMN `word_file` VARCHAR(200) DEFAULT NULL COMMENT 'в формате word ' AFTER `pdf_file`;
ALTER TABLE `hr_manager` MODIFY COLUMN `cv_doc_file` VARCHAR(200) COLLATE utf8_general_ci DEFAULT NULL COMMENT 'резюме в ворде';
ALTER TABLE `hr_manager` MODIFY COLUMN `photo_file` VARCHAR(200) COLLATE utf8_general_ci DEFAULT NULL COMMENT 'фото как jpeg';
ALTER TABLE `vendor_agreement` MODIFY COLUMN `pdf_file` VARCHAR(200) COLLATE utf8_general_ci DEFAULT NULL COMMENT 'файл соглашения';
ALTER TABLE `manager` MODIFY COLUMN `cv_doc_file` VARCHAR(200) COLLATE utf8_general_ci DEFAULT NULL COMMENT 'резюме в ворде';
ALTER TABLE `manager` MODIFY COLUMN `photo_file` VARCHAR(200) COLLATE utf8_general_ci DEFAULT NULL COMMENT 'фото как jpeg';
ALTER TABLE `trainer` MODIFY COLUMN `cv_doc_file` VARCHAR(200) COLLATE utf8_general_ci DEFAULT NULL COMMENT 'резюме в ворде';
ALTER TABLE `trainer` MODIFY COLUMN `photo_file` VARCHAR(200) COLLATE utf8_general_ci DEFAULT NULL COMMENT 'фото как jpeg';