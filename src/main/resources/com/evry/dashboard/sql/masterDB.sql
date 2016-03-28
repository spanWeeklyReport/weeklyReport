SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

SHOW WARNINGS;
SHOW WARNINGS;

create database report;
use report;

-- -----------------------------------------------------

-- -----------------------------------------------------
DROP TABLE IF EXISTS `user_details` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `userdetails` (
  `userid` INT(11) NOT NULL AUTO_INCREMENT ,
  `username` VARCHAR(45) NULL DEFAULT NULL ,
  `password` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`userid`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

SHOW WARNINGS;
CREATE UNIQUE INDEX `id_UNIQUE` ON `userdetails` (`userid` ASC) ;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `logininfo`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `logininfo` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `logininfo` (
  `sno` INT(11) NOT NULL AUTO_INCREMENT ,
  `uid` INT(11) NULL DEFAULT NULL ,
  `login` TIMESTAMP NULL DEFAULT NULL ,
  `logout` TIMESTAMP NULL DEFAULT NULL ,
  PRIMARY KEY (`sno`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

SHOW WARNINGS;
CREATE UNIQUE INDEX `s.no_UNIQUE` ON `logininfo` (`sno` ASC) ;

SHOW WARNINGS;

-- -----------------------------------------------------
-- Table `task_deatils`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `task_deatils` ;

SHOW WARNINGS;
CREATE  TABLE IF NOT EXISTS `task_deatils` (
  `O_id` INT(11) NOT NULL AUTO_INCREMENT ,
  `u_id` INT(11) NULL DEFAULT NULL ,
  `project_name` VARCHAR(45) NULL DEFAULT NULL ,
  `week_no` INT(11) NULL DEFAULT NULL ,
  `planned_task` VARCHAR(45) NULL DEFAULT NULL ,
  `completed_task` VARCHAR(45) NULL DEFAULT NULL ,
  `hold_task` VARCHAR(45) NULL DEFAULT NULL ,
  `inprogress_task` VARCHAR(45) NULL DEFAULT NULL ,
  `risk_desc` VARCHAR(700) NULL DEFAULT NULL ,
  `risk_resp` VARCHAR(45) NULL DEFAULT NULL ,
  `shared_resources` VARCHAR(745) NULL DEFAULT NULL ,
  `build_resources` VARCHAR(45) NULL DEFAULT NULL ,
  `project_inc` VARCHAR(45) NULL DEFAULT NULL ,
  `project_dec` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`O_id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;

SHOW WARNINGS;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
