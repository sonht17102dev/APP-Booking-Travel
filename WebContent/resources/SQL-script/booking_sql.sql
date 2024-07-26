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
    start_date VARCHAR(10) NOT NULL,
    duetime VARCHAR(10) NOT NULL,
    address VARCHAR(255) NOT NULL,
    price double NOT NULL,
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
('Nha Trang tour', 'resources/images/NhaTrang-bg.jpg', 
'Bai Tắm Hon Chồng
Hon Chong is a big rock that has the traces of the giant hand in a legend and Hon Vo is another rock looks like a woman cradling her child. You will be amazed with the beauty of massive rocks with many shapes and stacked each other.\n
20 minutes
Po Nagar Cham Towers
The special structure was built between the 7th and the 12th century by Cham (the prosperous time of Cham). The particular structures and bricks helped towers exist over 1000 years. Many scientists today have yet deciphered its mystery.\n
45 minutes
Long Son Pagoda
Long Son Pagoda, also known under other names “ Chua Phat Trang” or “ Long Son Co Tu”, the biggest church in Nha Trang city. It was built in 1886 and repaired many times. Long Son owns unique statues located in Trai Thuy hill such as bronze Buddha statue in the main hall with 1.6 metres high and 700kg weight; nirvana Buddha statues with 17 metres long and the statue of Buddha Shrine seating sermon with 31 metres high.
45 minutes
National Oceanographic Museum of Vietnam
Thap Tram Huong
The name of Tram Huong tower is derived from a rare commodity with high economic value in Nha Trang called agarwood. Located on the beach, Tram Huong tower consists of 3 floors with vivid sculpture icons: the wave of the sea, sails, petals and a stylized core.
Dam Market
Trading since 1974, Nha Trang Market’s bustling atmosphere and colourful array of goods makes it a popular spot for travelling photographers and tourists looking to immerse themselves in the local culture.
', '2024-25-07', '2024-27-07', 'Nha Trang', 85, 'active'),
('Phu Quoc tour', 'resources/images/PhuQuoc-bg.jpg', 
'DAY 01: HCMC – PHU QUOC (Lunch)
In the morning, you gather at the domestic departure terminal, Tan Son Nhat airport. Saigontourist tour guide welcomes you and assists with check-in procedures. Depart for Phu Quoc (flight VN1823 at 8:20 a.m.). You Breakfast at your own expense. Arriving at Phu Quoc, the group departs to visit the Phu Quoc pearl farming center. Continue to visit Dinh Cau - the cultural and religious symbol of Phu Quoc island, where local fishermen pray for good luck. good luck, peace and trust for a trip to the sea full of fishing when returning. The group visits Dinh Ba Thuy Long Thanh Mau. The group checks in to rest. In the afternoon, you are free to explore the pearl island of Phu Quoc. and dinner at your own expense. Overnight in Phu Quoc.
Options (sightseeing & transportation expenses covered):
- Experience the \"World\'s longest sea-crossing 3-wire cable car at Hon Thom\" with a total length of 7,899.9m, which will take visitors on an exciting high-altitude journey, to capture a 360-degree view of the beauty of the sea. Paradise of sea, islands, green forests and beaches in the An Thoi island cluster, south of Phu Quoc.
- Visit Sunset Town - known as the most beautiful place to watch the sunset in Phu Quoc, admire the unique architecture and typical works: Kissing Bridge, Clock Tower, Con So Square, Gavi Arc de Triomphe, ... and colorful coastal houses with Mediterranean architecture.
- Experience Show Kiss of The Sea - a show elaborately choreographed using Multimedia technology - a combination of fire, water and light, fireworks, lasers, music and attractive performers.

Phu Quoc Pearl Culture Center

DAY 02: PHU QUOC - VINPEARL SAFARI - VINWONDER (Breakfast, lunch, dinner)
After breakfast, the car takes the group to Bac Dao to explore Vinpearl Safari Phu Quoc - the first wild zoo in Vietnam with a scale of 180 hectares, with more than 130 rare animal species and animal performance and photography programs. ;Experience an open zoo in a natural forest, close and friendly to people. Continue to visit VinWonder Phu Quoc - a theme park divided into 6 subdivisions, symbolizing 6 territories with 12 owners The theme is inspired by famous civilizations, fairy tales, and world anecdotes, which will take visitors from one surprise to another, creating new, entertaining, educational experiences. Education and high art. The group comes to the "City that never sleeps" Grand World, free to visit bamboo structures, contemporary art park of Open Park and at their own expense experiences at Grand World: Teddy Bear museum , boat on the Venice River, Quintessence of Vietnam (at your own expense). Overnight in Phu Quoc.
Vinpearl Safari Phu Quoc

DAY 03: PHU QUOC – HCMC (Breakfast, lunch)
You are free to swim and rest at the hotel until check-out time. The car will take you to the airport. On the way, the group will stop to visit the Pepper Garden, Fish Sauce Factory, Sim Wine Furnace...Arrive at Phu Quoc Airport , the group flies back to Ho Chi Minh City (flight VN1826 at 14:40 or 15:00). At the end of the program (you will be responsible for your own transportation from the airport back home)./.

Note:
- Sightseeing spots can be rearranged accordingly while still ensuring the full content of each program.
- Flight times may be changed by the airline',
'2024-28-07', '2024-31-07', 'Phu Quoc', 275, 'active')