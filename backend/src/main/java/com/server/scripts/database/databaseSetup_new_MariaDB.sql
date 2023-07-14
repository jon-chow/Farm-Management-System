/*
  users table set up
 */
CREATE OR REPLACE TABLE users
(
    user_id  INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(30)  NOT NULL,
    password VARCHAR(100) NOT NULL,
    first_name VARCHAR(30),
    last_name VARCHAR(30),
    role REFERENCES roles(role_id),
    last_login DATE
);
INSERT INTO users (username, password)
VALUES ('admin', 'admin'),
       ('guest', 'guest');

/*
 roles table set up
*/
CREATE TABLE roles
(
    role_id INT PRIMARY KEY AUTO_INCREMENT,
    role_name VARCHAR(30) NOT NULL
);

/*
  livestock table set up
 */
CREATE OR REPLACE TABLE livestock
(
    tag_id                            INT PRIMARY KEY AUTO_INCREMENT,
    animal_type                       ENUM ('CHICKEN', 'SHEEP', 'COW', 'PIG'),
    age                               INT,
    diet                              ENUM ('CANOLA','WHEAT','CORN','POTATOES','MUSTARD','COCONUT'),
    weight                            REAL,
    last_fed                          DATE,
    harvestable                       BOOL,
    last_violated_for_harvested_goods DATE
);

INSERT INTO livestock (animal_type, age, diet, weight, last_fed, harvestable, last_violated_for_harvested_goods)
VALUES ('CHICKEN', 1, 'WHEAT',0.5, '2023-07-08', FALSE, NULL),
       ('SHEEP', 2, 'WHEAT',30.2, '2023-07-07', TRUE, '2023-07-06'),
       ('COW', 3, 'CORN',500.8, '2023-07-09', FALSE, NULL),
       ('PIG', 2, 'POTATOES', 150.3, '2023-07-08', TRUE, '2023-07-07'),
       ('CHICKEN', 1, 'WHEAT', 0.7, '2023-07-10', FALSE, NULL),
       ('SHEEP', 3, 'CANOLA', 35.8, '2023-07-09', TRUE, '2023-07-08'),
       ('COW', 4, 'MUSTARD', 550.2, '2023-07-11', FALSE, NULL),
       ('PIG', 3, 'COCONUT', 160.6, '2023-07-10', TRUE, '2023-07-09');


/*
  pen table set up
 */
CREATE OR REPLACE TABLE pen
(
    facility_id     INT PRIMARY KEY AUTO_INCREMENT,
    name            VARCHAR(30),
    age             INT,
    max_capacity    INT NOT NULL,
    upkeep          INT,
    type_of_animals ENUM ('CHICKEN', 'SHEEP', 'COW', 'PIG')
);

/*
  housing table set up
 */
CREATE OR REPLACE TABLE housing
(
    facility_id        INT PRIMARY KEY AUTO_INCREMENT,
    name               VARCHAR(30),
    age                INT,
    max_capacity       INT NOT NULL,
    upkeep             INT,
    rent               INT,
    distance_to_fields INT,
    distance_from_pens INT
);

/*
  farmers table set up
 */
CREATE TABLE Farmers_2
(
    farmer_id           INT PRIMARY KEY AUTO_INCREMENT,
    fulll_name          VARCHAR(50) NOT NULL,
    years_of_employment INT,
    FOREIGN KEY (years_of_employment) REFERENCES Farmers_1 (years_of_employment)
);


CREATE TABLE Farmers_1
(
    years_of_employment INT PRIMARY KEY,
    salary              INT
);

/*
  veterinary records table set up
 */
CREATE OR REPLACE TABLE veterinary_records_has
(
    tag_id        INT NOT NULL,
    record_id     INT AUTO_INCREMENT,
    record_date   DATE,
    health_status VARCHAR(30),
    PRIMARY KEY (tag_id, record_id),
    FOREIGN KEY (tag_id) REFERENCES livestock (tag_id) ON DELETE CASCADE
);


/*
  crop table set up
 */
CREATE OR REPLACE TABLE crops
(
    crop_type ENUM ('CANOLA', 'WHEAT', 'CORN', 'POTATOES', 'MUSTARD', 'COCONUT'),
    quantity  INT
);