CREATE DATABASE IF NOT EXISTS `web_booking_travel`;
USE `web_booking_travel`;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE user (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    fullname VARCHAR(100),
    email VARCHAR(100),
    phone_number VARCHAR(15),
    address VARCHAR(255),
    status VARCHAR(20),
    role_id INT
);
DROP TABLE IF EXISTS `tour`;
CREATE TABLE tour (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    image VARCHAR(255) NOT NULL,
    description text,
    start_date VARCHAR(10),
    duetime VARCHAR(10),
    price double,
    status VARCHAR(20)
);
--
-- Dumping data for table `user`
--

-- add data samples
INSERT INTO user (username, password, fullname, email, phone_number, address, status, role_id) VALUES
('john_doe', '123', 'John Doe', 'john@example.com', '1234567890', 'USA', 'active', 0),
('jane_smith', '123', 'Jane Smith', 'jane@example.com', '0987654321', 'USA', 'inactive', 1),
('john_biden', '123', 'John Biden', 'johnbiden@example.com', '0371234157', 'USA', 'active', 1),
('cr7', '123', 'Critiano Ronaldo', 'cr7@example.com', '0987654321', 'Portugal', 'active', 1),
('m10', '123', 'Messi', 'm10@example.com', '0793234666', 'Argentina', 'active', 1),
('alice_jones', '123', 'Alice Jones', 'alice@example.com', '1122334455', 'USA', 'inactive', 1);


--
-- Dumping data for table `tour`
--

-- add data tour samples
INSERT INTO tour (name, image, description, start_date, duetime, price, status) VALUES
('Nha Trang tour', '123', 'John Doe', 'john@example.com', '1234567890', 'USA', 'active', 0)