SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `kuguo` DEFAULT CHARACTER SET utf8 ;
USE `kuguo` ;

-- -----------------------------------------------------
-- Table `kuguo`.`user`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `kuguo`.`user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `salt` VARCHAR(100) NOT NULL DEFAULT '0' ,
  `name` VARCHAR(50) NULL DEFAULT NULL ,
  `email` VARCHAR(100) NULL DEFAULT NULL ,
  `password` VARCHAR(200) NOT NULL DEFAULT 'NULL' ,
  `head` VARCHAR(100) NULL DEFAULT NULL ,
  `address` VARCHAR(100) NULL DEFAULT NULL ,
  `gender` TINYINT(4) NULL DEFAULT NULL ,
  `website` VARCHAR(100) NULL DEFAULT NULL ,
  `bio` VARCHAR(50) NULL DEFAULT NULL ,
  `city` VARCHAR(100) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `kuguo`.`product`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `kuguo`.`product` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(50) NOT NULL ,
  `picture` VARCHAR(1000) NULL DEFAULT NULL ,
  `order_link` VARCHAR(1000) NULL ,
  `brand` VARCHAR(50) NULL ,
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ,
  `price` DOUBLE NULL ,
  `hots` INT(11) NULL DEFAULT '0' ,
  `favorite_num` INT(11) NULL DEFAULT '0' ,
  `user_id` INT(11) NULL DEFAULT NULL ,
  `channel` VARCHAR(100) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `user_id` (`user_id` ASC) ,
  CONSTRAINT `product_ibfk_1`
    FOREIGN KEY (`user_id` )
    REFERENCES `kuguo`.`user` (`id` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COMMENT = '商品';


-- -----------------------------------------------------
-- Table `kuguo`.`channel`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `kuguo`.`channel` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(60) NULL DEFAULT NULL ,
  `parent_id` INT(11) NULL DEFAULT NULL ,
  `product_id` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `parent_id` (`parent_id` ASC) ,
  INDEX `product_id` (`product_id` ASC) ,
  CONSTRAINT `channel_ibfk_1`
    FOREIGN KEY (`parent_id` )
    REFERENCES `kuguo`.`channel` (`id` ),
  CONSTRAINT `channel_ibfk_2`
    FOREIGN KEY (`product_id` )
    REFERENCES `kuguo`.`product` (`id` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `kuguo`.`label`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `kuguo`.`label` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `name` VARCHAR(100) NULL DEFAULT NULL ,
  `product_id` INT(11) NULL DEFAULT NULL ,
  `create_user_id` INT(11) NULL DEFAULT NULL ,
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP ,
  PRIMARY KEY (`id`) ,
  INDEX `create_user_id` (`create_user_id` ASC) ,
  CONSTRAINT `label_ibfk_1`
    FOREIGN KEY (`create_user_id` )
    REFERENCES `kuguo`.`user` (`id` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `kuguo`.`product_comment`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `kuguo`.`product_comment` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `content` VARCHAR(500) NOT NULL DEFAULT 'NULL' ,
  `poke` INT(11) NULL DEFAULT '0' ,
  `hoot` INT(11) NULL DEFAULT '0' ,
  `create_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ,
  `user_id` INT(10) NULL DEFAULT NULL ,
  `product_id` INT(11) NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `fk_product_comment_product1_idx` (`product_id` ASC) ,
  CONSTRAINT `fk_product_comment_product1`
    FOREIGN KEY (`product_id` )
    REFERENCES `kuguo`.`product` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `kuguo`.`message`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `kuguo`.`message` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `type` TINYINT(4) NULL DEFAULT NULL ,
  `user_id` INT(11) NULL DEFAULT NULL ,
  `create_time` DATETIME NULL DEFAULT NULL ,
  `comment_id` INT(11) NULL DEFAULT NULL ,
  `product_id` INT(11) NULL DEFAULT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `user_id` (`user_id` ASC) ,
  INDEX `comment_id` (`comment_id` ASC) ,
  INDEX `product_id` (`product_id` ASC) ,
  CONSTRAINT `message_ibfk_1`
    FOREIGN KEY (`user_id` )
    REFERENCES `kuguo`.`user` (`id` ),
  CONSTRAINT `message_ibfk_2`
    FOREIGN KEY (`comment_id` )
    REFERENCES `kuguo`.`product_comment` (`id` ),
  CONSTRAINT `message_ibfk_3`
    FOREIGN KEY (`product_id` )
    REFERENCES `kuguo`.`product` (`id` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `kuguo`.`product_hots`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `kuguo`.`product_hots` (
  `user_id` INT(11) NOT NULL DEFAULT '0' ,
  `product_id` INT(11) NOT NULL DEFAULT '0' ,
  `create_time` DATETIME NULL DEFAULT NULL ,
  PRIMARY KEY (`user_id`, `product_id`) ,
  INDEX `product_id` (`product_id` ASC) ,
  CONSTRAINT `product_hots_ibfk_1`
    FOREIGN KEY (`user_id` )
    REFERENCES `kuguo`.`user` (`id` ),
  CONSTRAINT `product_hots_ibfk_2`
    FOREIGN KEY (`product_id` )
    REFERENCES `kuguo`.`product` (`id` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `kuguo`.`product_label`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `kuguo`.`product_label` (
  `product_id` INT(11) NOT NULL ,
  `label_id` INT(11) NOT NULL ,
  PRIMARY KEY (`product_id`, `label_id`) ,
  INDEX `label_id` (`label_id` ASC) ,
  CONSTRAINT `product_label_ibfk_1`
    FOREIGN KEY (`product_id` )
    REFERENCES `kuguo`.`product` (`id` ),
  CONSTRAINT `product_label_ibfk_2`
    FOREIGN KEY (`label_id` )
    REFERENCES `kuguo`.`label` (`id` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `kuguo`.`product_like`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `kuguo`.`product_like` (
  `product_id` INT(11) NOT NULL DEFAULT '0' ,
  `user_id` INT(11) NOT NULL DEFAULT '0' ,
  `create_time` DATETIME NULL DEFAULT NULL ,
  PRIMARY KEY (`product_id`, `user_id`) ,
  INDEX `user_id` (`user_id` ASC) ,
  CONSTRAINT `product_like_ibfk_1`
    FOREIGN KEY (`product_id` )
    REFERENCES `kuguo`.`product` (`id` ),
  CONSTRAINT `product_like_ibfk_2`
    FOREIGN KEY (`user_id` )
    REFERENCES `kuguo`.`user` (`id` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `kuguo`.`user_friend`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `kuguo`.`user_friend` (
  `user_id` INT(11) NOT NULL DEFAULT '0' ,
  `friend_id` INT(11) NOT NULL DEFAULT '0' ,
  `create_time` DATETIME NULL DEFAULT NULL ,
  PRIMARY KEY (`user_id`, `friend_id`) ,
  INDEX `friend_id` (`friend_id` ASC) ,
  CONSTRAINT `user_friend_ibfk_1`
    FOREIGN KEY (`user_id` )
    REFERENCES `kuguo`.`user` (`id` ),
  CONSTRAINT `user_friend_ibfk_2`
    FOREIGN KEY (`friend_id` )
    REFERENCES `kuguo`.`user` (`id` ))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

USE `kuguo` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;