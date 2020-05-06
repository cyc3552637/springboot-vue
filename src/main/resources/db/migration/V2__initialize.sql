USE `test`;

/*Table structure for table `users` */

CREATE TABLE `users` (
  `id` INT(10) UNSIGNED PRIMARY KEY AUTO_INCREMENT,
  `username` VARCHAR(255) DEFAULT NULL,
  `PASSWORD` VARCHAR(255) DEFAULT NULL,
  `age` TINYINT(10) UNSIGNED DEFAULT NULL,
  `birth` DATE DEFAULT NULL,
  `email` VARCHAR(255) DEFAULT NULL
) ENGINE=INNODB DEFAULT CHARSET=utf8;
INSERT INTO `users` (`id`, `username`, `PASSWORD`, `age`, `birth`, `email`) VALUES('1','测试员9999','99999999','55','1964-08-02','11111111@qq.com');
INSERT INTO `users` (`id`, `username`, `PASSWORD`, `age`, `birth`, `email`) VALUES('2','唐朝','未知','42','1977-02-22','唐朝@qq.com');
INSERT INTO `users` (`id`, `username`, `PASSWORD`, `age`, `birth`, `email`) VALUES('3','张三','未知2','55','1964-08-12','唐朝2@qq.com');
INSERT INTO `users` (`id`, `username`, `PASSWORD`, `age`, `birth`, `email`) VALUES('4','李四','未知3','55','1964-08-13','唐朝3@qq.com');
INSERT INTO `users` (`id`, `username`, `PASSWORD`, `age`, `birth`, `email`) VALUES('5','王五','未知4','54','1964-08-14','唐朝4@qq.com');
INSERT INTO `users` (`id`, `username`, `PASSWORD`, `age`, `birth`, `email`) VALUES('6','汤嘉','汤嘉','29','1990-04-13','汤嘉@qq.com');
