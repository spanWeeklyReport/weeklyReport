SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `report` DEFAULT CHARACTER SET latin1 ;
USE `report` ;

-- -----------------------------------------------------
-- Table `report`.`login_info`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `report`.`login_info` ;

CREATE  TABLE IF NOT EXISTS `report`.`login_info` (
  `SNO.` INT(11) NOT NULL AUTO_INCREMENT ,
  `U_ID` INT(11) NULL DEFAULT NULL ,
  `LOGIN` TIMESTAMP NULL DEFAULT NULL ,
  `LOGOUT` TIMESTAMP NULL DEFAULT NULL ,
  PRIMARY KEY (`SNO.`) ,
  UNIQUE INDEX `s.no_UNIQUE` (`SNO.` ASC) ,
  INDEX `LOGIN_FK1_idx` (`U_ID` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `report`.`project_details`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `report`.`project_details` ;

CREATE  TABLE IF NOT EXISTS `report`.`project_details` (
  `OID` INT(11) NOT NULL AUTO_INCREMENT ,
  `PROJECT_NAME` VARCHAR(45) NULL DEFAULT NULL ,
  `PROJECT_STATUS` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`OID`) ,
  UNIQUE INDEX `proid_UNIQUE` (`OID` ASC) )
ENGINE = InnoDB
AUTO_INCREMENT = 7
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `report`.`user_details`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `report`.`user_details` ;

CREATE  TABLE IF NOT EXISTS `report`.`user_details` (
  `O_ID` INT(11) NOT NULL AUTO_INCREMENT ,
  `USER_NAME` VARCHAR(45) NULL DEFAULT NULL ,
  `PASSWORD` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`O_ID`) ,
  UNIQUE INDEX `id_UNIQUE` (`O_ID` ASC) )
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `report`.`task_details`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `report`.`task_details` ;

CREATE  TABLE IF NOT EXISTS `report`.`task_details` (
  `OID` INT(11) NOT NULL AUTO_INCREMENT ,
  `U_ID` INT(11) NULL DEFAULT NULL ,
  `PROJECT_ID` INT(11) NULL DEFAULT NULL ,
  `WEEK_NO` INT(11) NULL DEFAULT NULL ,
  `PLANNED_TASK` VARCHAR(45) NULL DEFAULT NULL ,
  `COMPLETED_TASK` VARCHAR(45) NULL DEFAULT NULL ,
  `HOLD_TASK` VARCHAR(45) NULL DEFAULT NULL ,
  `INPROGRESS_TASK` VARCHAR(45) NULL DEFAULT NULL ,
  `RISK_DESC` VARCHAR(700) NULL DEFAULT NULL ,
  `RISK_RESP` VARCHAR(45) NULL DEFAULT NULL ,
  `SHARED_RESOURCES` VARCHAR(745) NULL DEFAULT NULL ,
  `BILLED_RESOURCES` VARCHAR(45) NULL DEFAULT NULL ,
  `PROJECT_INC` VARCHAR(45) NULL DEFAULT NULL ,
  `PROJECT_DEC` VARCHAR(45) NULL DEFAULT NULL ,
  PRIMARY KEY (`O_ID`) ,
  INDEX `uid_idx` (`U_ID` ASC) ,
  INDEX `pid_idx` (`PROJECT_ID` ASC) ,
  CONSTRAINT `pid`
    FOREIGN KEY (`PROJECT_ID` )
    REFERENCES `report`.`project_details` (`OID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `uid`
    FOREIGN KEY (`U_ID` )
    REFERENCES `report`.`user_details` (`O_ID` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = latin1;

USE `report` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
