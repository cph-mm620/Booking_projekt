-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema booking
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema booking
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `booking` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `booking` ;

-- -----------------------------------------------------
-- Table `booking`.`room`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `booking`.`room` (
  `room_nr` INT NOT NULL AUTO_INCREMENT,
  `description` VARCHAR(120) NULL DEFAULT NULL,
  PRIMARY KEY (`room_nr`),
  UNIQUE INDEX `description_UNIQUE` (`description` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 213
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `booking`.`item`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `booking`.`item` (
  `item_id` INT NOT NULL AUTO_INCREMENT,
  `item_name` VARCHAR(100) NULL,
  `description` VARCHAR(120) NULL,
  `item_type` VARCHAR(45) NOT NULL,
  `item_tag` VARCHAR(45) NOT NULL,
  `room_nr` INT NOT NULL,
  PRIMARY KEY (`item_id`),
  INDEX `fk_item_room1_idx` (`room_nr` ASC) VISIBLE,
  CONSTRAINT `fk_item_room1`
    FOREIGN KEY (`room_nr`)
    REFERENCES `booking`.`room` (`room_nr`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `booking`.`users`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `booking`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(90) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `role` VARCHAR(20) NOT NULL DEFAULT 'student',
  `point` INT NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `booking`.`booking`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `booking`.`booking` (
  `booking_id` INT NOT NULL AUTO_INCREMENT,
  `booking_date` VARCHAR(45) NOT NULL,
  `days` VARCHAR(45) NULL,
  `comment` VARCHAR(45) NULL,
  `booking_status` VARCHAR(45) NULL,
  `item_id` INT NOT NULL,
  `users_id` INT NOT NULL,
  PRIMARY KEY (`booking_id`, `item_id`, `users_id`),
  INDEX `fk_booking_item2_idx` (`item_id` ASC) VISIBLE,
  INDEX `fk_booking_users1_idx` (`users_id` ASC) VISIBLE,
  CONSTRAINT `fk_booking_item2`
    FOREIGN KEY (`item_id`)
    REFERENCES `booking`.`item` (`item_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_booking_users1`
    FOREIGN KEY (`users_id`)
    REFERENCES `booking`.`users` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
