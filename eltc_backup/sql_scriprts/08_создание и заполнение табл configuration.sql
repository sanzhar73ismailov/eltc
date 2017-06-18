CREATE TABLE `configuration` (
  `id` VARCHAR(30) COLLATE utf8_general_ci NOT NULL DEFAULT '',
  `value` VARCHAR(30) COLLATE utf8_general_ci NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
)ENGINE=InnoDB
CHARACTER SET 'utf8' COLLATE 'utf8_general_ci';
COMMIT;

/* Data for the `configuration` table  (Records 1 - 1) */

INSERT INTO `configuration` (`id`, `value`) VALUES 
  ('test_mode', '1');

COMMIT;