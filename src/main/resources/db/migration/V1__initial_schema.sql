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
    date DATE NOT NULL,
    organizer_id BIGINT,
    CONSTRAINT fk_event_organizer FOREIGN KEY (organizer_id) REFERENCES resident(id)
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
(4, 'Sita Devi', '1982-03-30', '101 Riverbank Lane', '9988776655', 'rahul@example.com','RESIDENT');

-- Events
INSERT INTO event (id, name, location, date, organizer_id) VALUES
(1, 'Village Clean-Up', 'Community Park', '2025-04-20', 1),
(2, 'Tree Plantation Drive', 'Village Square', '2025-05-05', 2);

-- Donations
INSERT INTO donation (id, resident_id, event_id, amount, status, created_by_id) VALUES
(1, 1, 1, 500.00, 'COMPLETED', 1),
(2, 2, 1, 300.00, 'PENDING', 1),
(3, 3, 2, 700.00, 'COMPLETED', 1);
