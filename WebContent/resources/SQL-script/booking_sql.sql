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
--
-- Table structure for table `tour`
--
DROP TABLE IF EXISTS `tour`;
CREATE TABLE tour (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    image VARCHAR(255) NOT NULL,
    description text,
    start_date VARCHAR(10) NOT NULL,
    duetime VARCHAR(10) NOT NULL,
    address VARCHAR(255) NOT NULL,
    price double NOT NULL,
    status VARCHAR(20) NOT NULL
);
--
-- Table structure for table `booking`
--
DROP TABLE IF EXISTS `booking`;
CREATE TABLE booking (
    id INT AUTO_INCREMENT PRIMARY KEY,
    user_id INT NOT NULL,
    tour_id INT NOT NULL,
    adults_quantity INT NOT NULL,
    children_quantity INT NOT NULL,
    created_date varchar(20) NOT NULL,
    status VARCHAR(20) NOT NULL
);
--
-- Table structure for table `booking`
--
DROP TABLE IF EXISTS `post`;
CREATE TABLE post (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    image VARCHAR(255) NOT NULL,
    description text,
    created_date varchar(20) NOT NULL,
    status VARCHAR(20) NOT NULL
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
INSERT INTO tour (name, image, description, start_date, duetime, address, price, status) VALUES
('Nha Trang - Da Lat tour', 'NhaTrang-bg.jpg', 
'<p><strong>Day 1: Ho Chi Minh City - Nha Trang (/)</strong><br>
Morning, pick up and transfer to Nha Trang. Stop at Phan Thiet for a short visit. Arrive in Nha Trang. 
Transfer to the hotel. Overnight in Nha Trang.</p><p><strong>Day 2: Nha Trang (B,L)</strong><br>
Breakfast at the hotel. Morning, pick up and transfer to Da Chong pier where you start your day tour exploring Nha Phu Bay. 
Visit Orchid island and explore safari park with many kinds of animal living in their natural habitat. 
Enjoy a walking route inside the green forest of pine and explore the wildlife sanctuary with many kinds of bird. 
Back to An Binh beach and have your free time of swimming. Have lunch at a local restaurant. 
Afternoon, visit Lao island, the most famous destination in Nha Trang for nature-based activities and eco-tourism. 
You can offer handshakes with monkeys and feed them. Cruise back to Da Chong Pier. 
Transfer back to the hotel. Overnight in Nha Trang.</p><p><strong>Day 3: Nha Trang - Da Lat (B)</strong><br>
Breakfast at the hotel. Visit Po Nagar Temple, built during the 8th-13th centuries in Nha Trang, 
is an architectural work of art typical of Cham ethnic aesthetics. Then, transfer to Da Lat.
 On arrival, visit Lam Vien Square and Xuan Huong Lake. Overnight in Da Lat.</p><p><strong>Day 4: Da Lat (B)</strong>
 <br>Breakfast at the hotel. Morning, visit City Flower Garden, King Bao Dai\'s Summer Palace and Truc Lam 
 Pagoda. Afternoon, visit Old Train Station and Domain De Marie Church. Overnight in Da Lat.</p><p><strong>
 Day 5: Da Lat - Ho Chi Minh City (B)</strong><br>Breakfast at the hotel. Morning, transfer back to Ho Chi Minh
 City via Dambri waterfall in Bao Loc town. Arrive in Ho Chi Minh City. Transfer to the departure point. 
 End of service. &nbsp;</p><p><strong>NOTE:&nbsp;B</strong> - Breakfast; <strong>L</strong>- Lunch</p>
 <p><strong>PRICE:</strong><br><strong>Starting at&nbsp;VND 15,999,000 / person</strong>&nbsp;(for a group of minimum 
 6&nbsp;people).<br><strong>VALIDITY: From January 1st, 2024 to December 31st, 2024</strong>&nbsp;(Except: Peak Season
 &amp; Festive periods)</p><p>Please contact us for more tailor-made&nbsp;tours: 
 <a href=\"mailto:Info@saigontouristvietnam.com\">Info@saigontouristvietnam.com</a></p>', '2024-07-25', '2024-07-27', 'Nha Trang', 85, 'active'),
('Phu Quoc tour', 'PhuQuoc-bg.jpg', 
'<p><strong>Day 1: Arrival - Phu Quoc</strong><br>Flight to Phu Quoc. Arrive in Phu Quoc. 
Pick up and transfer to the hotel. Afternoon, visit Khu Tuong pepper garden, fish sauce firm, Sung Hung Co Tu Pagoda
 and Ganh Dau Beach. Overnight in Phu Quoc.</p><p><strong>
 Day 2: Phu Quoc (B)</strong><br>Breakfast at the hotel. Morning, visit An Thoi Harbor, the feeding and growing pearl
 firm. Afternoon, visit Ham Ninh fishing village, Bien Sao Beach and Duong Dong Market. 
 Overnight in Phu Quoc.&nbsp;</p><p><strong>Day 3: Phu Quoc - Departure (B)</strong><br>Breakfast at the hotel.
 Free at leisure until transfer to the airport for the departure flight. End of service.</p><p><strong>Notes:</strong>
 B - Breakfast</p><p><strong>PRICE</strong>:<br><strong>Starting at</strong>&nbsp;<strong>VND</strong>&nbsp;<strong>9,500,000/ person </strong>
 (for a group of minimum 6&nbsp;people).</p><p><strong>Validity: From January 1st, 2024 to December 31st, 2024</strong></p>',
'2024-07-28', '2024-07-31', 'Phu Quoc', 275, 'active'),
('Da Lat tour', 'DaLat-XuanHuong.jpg', 
'<p><strong>Day 1: Arrival - Da Lat</strong><br>Flight to Da Lat. Arrive at Lien Khuong airport. 
Pick up and transfer to hotel. Afternoon, take a city tour to visit the Datanla waterfalls, 
Truc Lam Pagoda and Xuan Huong Lake. Overnight in Da Lat.</p><p><strong>Day 2: Da Lat (B)</strong><br>
Breakfast at the hotel. Take a full day city tour to visit the Domain De Marie Church, Bao Dai Summer Palace, 
Valley of Love, Minh Tam\'s flower garden, Crazy House, Truc Lam Pagoda, Tuyen Lam Lake and Da Lat Market. 
Overnight in Da Lat.&nbsp;</p><p><strong>Day 3: Da Lat - Departure (B)</strong><br>Breakfast at the hotel. 
Morning free at leisure until transfer to the airport for flight back to the departure point. 
End of service.</p><p><strong>NOTE:</strong> B - Breakfast</p>
<p><strong>PRICE:</strong></p><p><strong>Starting at</strong>&nbsp;<strong>VND&nbsp;5,500,000/ person</strong> 
(for a group of minimum 6&nbsp;people).</p>
<p><strong>Validity: From January 1st, 2024 to December 31st, 2024</strong></p>
<h2><strong>HOTLINE:&nbsp;</strong></h2><h2><a href=\"tel:+84 91 1273003\"><strong>(+84) 909 284 554</strong></a
><br><a href=\"tel:+84 91 1273003\"><strong>(+84) 911 273 003</strong></a></h2>
<p>Please contact us for more tailor-made tours: Info@saigontouristvietnam.com</p>',
'2024-07-28', '2024-07-31', 'Da Lat City', 99, 'active'),
('Da Nang tour', 'CauRongDaNang.jpg', 
'<p><strong>Start at 13:30 and return around 17:30 (tour will depart with at least 4 people).
</strong></p><p>A half day city tour in Da Nang features tho Non Nuoc carving village, the Cham Museum,
 a pedicab ride (30 minutes) along han River, and the Marble Mountains.&nbsp;During the short stop at Han market,
 you can buy unique hand-made souvenirs.</p><h3><strong>ITINERARY</strong></h3><p>Visit the Cham Museum.<br>
 Enjoy the pecicab ride along Han River (30 minutes).<br>Visit the Marble Mountains and Non Nuoc Beach.<br>
 Stop at Non Nuoc carving village and Han Market.<br>Overland back to Hoi An.<br>Return to the hotel. 
 End of tour.</p><p><strong>Departure:</strong>&nbsp;<br>At Saigontourist Da Nang\'s office&nbsp;
 10 minutes before prior to departure time.<br>Hotel pick-up.</p><p><strong>PRICE:&nbsp;VND 575,000/ person 
 for a group of minimum 4 people&nbsp;</strong><br><strong>
 Validity: From&nbsp;May 1st, 2024&nbsp;to September&nbsp;30th, 2024.</strong></p>',
'2024-08-01', '2024-08-03', 'Da Nang City', 349, 'active');


--
-- Dumping data for table `booking`
--

-- add data tour samples
INSERT INTO booking (user_id, tour_id, adults_quantity, children_quantity, created_date, status) VALUES 
(1, 1, 1, 2,'2024-07-20', 'active'),
(1, 2, 2,1 ,'2024-07-25', 'active'),
(2, 1, 1, 0, '2024-06-30', 'active'),
(2, 3, 2, 1, '2024-03-22', 'active'),
(3, 2, 3,2,'2024-04-07', 'active'),
(3, 3, 1,1, '2024-07-27', 'active');
