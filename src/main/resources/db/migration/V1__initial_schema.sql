-- Table: Resident
CREATE TABLE resident (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    date_of_birth DATE NOT NULL,
    address VARCHAR(255),
    phone_number VARCHAR(15),
    email_id VARCHAR(100),
    role VARCHAR(100) NOT NULL
);

-- Table: Event
CREATE TABLE event (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    location VARCHAR(150),
    date DATE NOT NULL
);

-- Table: Donation
CREATE TABLE donation (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    resident_id BIGINT,
    created_by_id BIGINT,
    event_id BIGINT,
    amount DECIMAL(10, 2) NOT NULL,
    status VARCHAR(20),
    CONSTRAINT fk_donation_resident FOREIGN KEY (resident_id) REFERENCES resident(id),
    CONSTRAINT fk_donation_event FOREIGN KEY (event_id) REFERENCES event(id)
);


-- Residents
INSERT INTO resident (id, name, date_of_birth, address, phone_number, email_id, role) VALUES
(1, 'Amit Sharma', '1985-06-15', '123 Green Street', '9876543210', 'amit@example.com', 'ADMIN'),
(2, 'Priya Mehta', '1990-02-10', '456 Lakeview Road', '9123456780', 'priya@example.com', 'RESIDENT'),
(3, 'Rahul Verma', '1978-11-23', '789 Hilltop Ave', '9012345678', 'rahul@example.com', 'RESIDENT'),
(4, 'Sita Devi', '1982-03-30', '101 Riverbank Lane', '9988776655', 'rahul@example.com','RESIDENT'),
(5, 'Vikram Singh', '1980-07-12', '234 Park Lane', '9871234567', 'vikram@example.com', 'RESIDENT'),
(6, 'Anjali Gupta', '1987-04-25', '567 Oak Street', '9765432109', 'anjali@example.com', 'ADMIN'),
(7, 'Rakesh Kumar', '1976-09-18', '890 Sunset Boulevard', '9654321098', 'rakesh@example.com', 'RESIDENT'),
(8, 'Neha Patel', '1992-12-03', '345 Maple Drive', '9543210987', 'neha@example.com', 'RESIDENT'),
(9, 'Arjun Reddy', '1983-01-15', '678 Cedar Avenue', '9432109876', 'arjun@example.com', 'RESIDENT'),
(10, 'Pooja Sharma', '1989-06-30', '123 Elm Street', '9321098765', 'pooja@example.com', 'RESIDENT'),
(11, 'Sanjay Yadav', '1979-03-22', '456 Pine Road', '9210987654', 'sanjay@example.com', 'RESIDENT'),
(12, 'Kavita Nair', '1985-10-08', '789 Birch Lane', '9109876543', 'kavita@example.com', 'ADMIN'),
(13, 'Rohit Malhotra', '1990-05-17', '101 Spruce Way', '9098765432', 'rohit@example.com', 'RESIDENT'),
(14, 'Meena Kapoor', '1981-11-11', '234 Willow Court', '9987654321', 'meena@example.com', 'RESIDENT'),
(15, 'Aditya Joshi', '1977-02-28', '567 Sycamore Drive', '9876543219', 'aditya@example.com', 'RESIDENT'),
(16, 'Shalini Rao', '1993-08-14', '890 Magnolia Street', '9765432198', 'shalini@example.com', 'RESIDENT'),
(17, 'Kiran Desai', '1984-04-05', '345 Laurel Avenue', '9654321987', 'kiran@example.com', 'RESIDENT'),
(18, 'Deepak Chopra', '1988-07-19', '678 Hazel Lane', '9543219876', 'deepak@example.com', 'RESIDENT'),
(19, 'Lakshmi Menon', '1982-09-27', '123 Chestnut Road', '9432198765', 'lakshmi@example.com', 'RESIDENT'),
(20, 'Naveen Pillai', '1975-12-12', '456 Poplar Street', '9321987654', 'naveen@example.com', 'RESIDENT'),
(21, 'Sunita Iyer', '1991-03-09', '789 Ash Lane', '9219876543', 'sunita@example.com', 'RESIDENT'),
(22, 'Manish Thakur', '1986-06-23', '101 Olive Drive', '9108765432', 'manish@example.com', 'ADMIN'),
(23, 'Rekha Bhatt', '1980-10-30', '234 Linden Court', '9097654321', 'rekha@example.com', 'RESIDENT'),
(24, 'Vishal Agarwal', '1978-01-07', '567 Tulip Road', '9986543210', 'vishal@example.com', 'RESIDENT'),
(25, 'Divya Rana', '1994-05-02', '890 Rose Avenue', '9875432109', 'divya@example.com', 'RESIDENT'),
(26, 'Suresh Kulkarni', '1983-08-16', '345 Daisy Lane', '9764321098', 'suresh@example.com', 'RESIDENT'),
(27, 'Aarti Jain', '1987-11-25', '678 Violet Street', '9653210987', 'aarti@example.com', 'RESIDENT'),
(28, 'Prakash Dubey', '1979-04-13', '123 Orchid Drive', '9542109876', 'prakash@example.com', 'RESIDENT'),
(29, 'Nisha Varghese', '1990-07-29', '456 Lotus Road', '9431098765', 'nisha@example.com', 'RESIDENT'),
(30, 'Hari Krishnan', '1981-02-04', '789 Jasmine Lane', '9320987654', 'hari@example.com', 'RESIDENT'),
(31, 'Geeta Saxena', '1985-09-10', '101 Marigold Court', '9219876542', 'geeta@example.com', 'RESIDENT'),
(32, 'Ajay Bhardwaj', '1977-06-27', '234 Ivy Street', '9108765431', 'ajay@example.com', 'RESIDENT'),
(33, 'Sarita Rathi', '1992-01-21', '567 Fern Avenue', '9097654320', 'sarita@example.com', 'RESIDENT'),
(34, 'Mohan Lal', '1984-12-15', '890 Clover Road', '9986543218', 'mohan@example.com', 'RESIDENT'),
(35, 'Rohan Chauhan', '1981-05-14', '901 Gandhi Road', '9986543217', 'rohan@example.com', 'RESIDENT'),
(36, 'Sneha Das', '1988-09-03', '432 Lotus Lane', '9876543216', 'sneha@example.com', 'ADMIN'),
(37, 'Vivek Mishra', '1976-02-19', '765 Palm Street', '9765432105', 'vivek@example.com', 'RESIDENT'),
(38, 'Tara Sengupta', '1993-07-08', '298 Coral Avenue', '9654321094', 'tara@example.com', 'RESIDENT'),
(39, 'Nikhil Bose', '1984-10-22', '543 Sapphire Drive', '9543210983', 'nikhil@example.com', 'RESIDENT'),
(40, 'Radhika Khandelwal', '1990-01-30', '876 Ruby Lane', '9432109872', 'radhika@example.com', 'RESIDENT'),
(41, 'Sameer Tiwari', '1978-06-11', '321 Emerald Road', '9321098761', 'sameer@example.com', 'RESIDENT'),
(42, 'Preeti Dutta', '1986-03-27', '654 Opal Street', '9210987650', 'preeti@example.com', 'ADMIN'),
(43, 'Kunal Roy', '1982-12-05', '987 Topaz Court', '9109876549', 'kunal@example.com', 'RESIDENT'),
(44, 'Shruti Mistry', '1991-08-16', '210 Amethyst Way', '9098765438', 'shruti@example.com', 'RESIDENT'),
(45, 'Abhishek Pandey', '1977-04-09', '543 Pearl Avenue', '9987654327', 'abhishek@example.com', 'RESIDENT'),
(46, 'Jyoti Venkatesh', '1989-11-23', '876 Diamond Lane', '9876543215', 'jyoti@example.com', 'RESIDENT'),
(47, 'Gaurav Saini', '1983-02-07', '321 Onyx Road', '9765432104', 'gaurav@example.com', 'RESIDENT'),
(48, 'Uma Nambiar', '1994-06-25', '654 Quartz Street', '9654321093', 'uma@example.com', 'RESIDENT'),
(49, 'Siddharth Balan', '1980-09-12', '987 Granite Drive', '9543210982', 'siddharth@example.com', 'RESIDENT'),
(50, 'Anita Khurana', '1985-01-28', '210 Marble Lane', '9432109871', 'anita@example.com', 'RESIDENT'),
(51, 'Yashwant Shetty', '1979-07-04', '543 Slate Road', '9321098760', 'yashwant@example.com', 'RESIDENT'),
(52, 'Bhavna Arora', '1992-10-19', '876 Basalt Avenue', '9210987649', 'bhavna@example.com', 'ADMIN'),
(53, 'Devendra Pratap', '1987-05-02', '321 Limestone Court', '9109876548', 'devendra@example.com', 'RESIDENT'),
(54, 'Mallika Shenoy', '1981-12-31', '654 Sandstone Way', '9098765437', 'mallika@example.com', 'RESIDENT'),
(55, 'Parth Vyas', '1976-08-15', '987 Shale Street', '9987654326', 'parth@example.com', 'RESIDENT'),
(56, 'Swati Gokhale', '1990-03-10', '210 Granite Lane', '9876543214', 'swati@example.com', 'RESIDENT'),
(57, 'Ishaan Barua', '1984-06-26', '543 Pebble Road', '9765432103', 'ishaan@example.com', 'RESIDENT'),
(58, 'Ritu Wadhwa', '1988-11-14', '876 Cobble Avenue', '9654321092', 'ritu@example.com', 'RESIDENT'),
(59, 'Alok Nanda', '1975-04-03', '321 Boulder Drive', '9543210981', 'alok@example.com', 'RESIDENT'),
(60, 'Seema Ahuja', '1993-09-20', '654 Cliff Lane', '9432109870', 'seema@example.com', 'RESIDENT'),
(61, 'Tejas Kadam', '1982-02-13', '987 Ridge Street', '9321098759', 'tejas@example.com', 'RESIDENT'),
(62, 'Nandini Hegde', '1986-07-29', '210 Valley Road', '9210987648', 'nandini@example.com', 'RESIDENT'),
(63, 'Raghav Luthra', '1991-01-06', '543 Hill Avenue', '9109876547', 'raghav@example.com', 'RESIDENT'),
(64, 'Leela Subramanian', '1978-10-18', '876 Crest Lane', '9098765436', 'leela@example.com', 'RESIDENT');
-- Events
INSERT INTO event (id, name, location, date) VALUES
(1, 'Village Clean-Up', 'Community Park', '2025-04-20'),
(2, 'Tree Plantation Drive', 'Village Square', '2025-05-05'),
(3, 'Health Camp', 'Community Hall', '2025-06-15'),
(4, 'Cultural Fest', 'Village Grounds', '2025-07-10'),
(5, 'Sports Day', 'Village Stadium', '2025-08-25'),
(6, 'Blood Donation Camp', 'Community Center', '2025-09-30'),
(7, 'Diwali Mela', 'Village Market', '2025-10-15'),
(8, 'New Year Celebration', 'Village Square', '2025-12-31'),
(9, 'Yoga Workshop', 'Community Hall', '2025-11-20'),
(10, 'Winter Carnival', 'Village Grounds', '2025-12-25');

-- Donations
INSERT INTO donation (id, resident_id, event_id, amount, status) VALUES
(1, 2,1, 500.00, 'COMPLETED'),
(2, 3, 2, 300.00, 'COMPLETED'),
(3, 4, 3, 700.00, 'COMPLETED'),
(4, 5, 4, 200.00, 'COMPLETED'),
(5, 6, 5, 1000.00, 'COMPLETED'),
(6, 7, 6, 1500.00, 'COMPLETED'),
(7, 8, 7, 800.00, 'COMPLETED'),
(8, 9, 8, 600.00, 'COMPLETED'),
(9, 10, 9, 400.00, 'COMPLETED'),
(10,11 ,10 ,900.00,'COMPLETED'),
(11, 12, 1, 1200.00, 'COMPLETED'),
(12, 13, 2, 1100.00, 'COMPLETED'),
(13, 14, 3, 1300.00, 'COMPLETED'),
(14, 15, 4, 1400.00, 'COMPLETED'),
(15, 16, 5, 1500.00, 'COMPLETED'),
(16, 17, 6, 1600.00, 'COMPLETED'),
(17, 18, 7, 1700.00, 'COMPLETED'),
(18, 19, 8, 1800.00, 'COMPLETED'),
(19,20 ,9 ,1900.00,'COMPLETED'),
(20 ,21 ,10 ,2000.00,'COMPLETED');