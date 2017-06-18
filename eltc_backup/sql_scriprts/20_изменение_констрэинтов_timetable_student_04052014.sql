ALTER TABLE `timetable_student` DROP FOREIGN KEY `timetable_student_student_fk`;
ALTER TABLE `timetable_student` DROP FOREIGN KEY `timetable_student_contract_fk`;
ALTER TABLE `timetable_student` DROP FOREIGN KEY `timetable_student_timetable_fk`;
  
ALTER TABLE `timetable_student` DROP INDEX `timetable_student1`;
ALTER TABLE `timetable_student` DROP INDEX `student_contract`;



ALTER TABLE `timetable_student` ADD CONSTRAINT `timetable_student_fk` FOREIGN KEY (`timetable_id`) REFERENCES `timetable` (`id`);
ALTER TABLE `timetable_student` ADD CONSTRAINT `timetable_student_fk1` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`);
ALTER TABLE `timetable_student` ADD CONSTRAINT `timetable_student_fk2` FOREIGN KEY (`contract_id`) REFERENCES `contract` (`id`);



 
ALTER TABLE `timetable_student` ADD INDEX `student_id` (`student_id`, `timetable_id`);
ALTER TABLE `timetable_student` ADD INDEX  (`timetable_id`);
