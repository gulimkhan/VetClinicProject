-- ================================================
-- WEEK 8: Create Pet Table for VetClinic
-- ================================================

-- 1. Connect to your database (replace 'vetclinic_db' with your DB name)
-- In pgAdmin: right-click vetclinic_db → Query Tool
-- In psql: \c vetclinic_db

-- ================================================
-- Create Pet Table
-- ================================================

CREATE TABLE pet (
    pet_id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age INTEGER NOT NULL,
    species VARCHAR(50) NOT NULL,
    owner_name VARCHAR(100) NOT NULL,
    -- Dog-specific field
    breed VARCHAR(100),
    trained BOOLEAN,
    -- Cat-specific field
    color VARCHAR(50),
    indoor BOOLEAN
);

-- Add indexes for performance
CREATE INDEX idx_pet_name ON pet(name);
CREATE INDEX idx_pet_species ON pet(species);

-- ================================================
-- Insert Sample Data
-- ================================================

-- Dogs
INSERT INTO pet (name, age, species, owner_name, breed, trained)
VALUES
    ('Sharik', 5, 'Dog', 'Asel', 'Golden Retriever', TRUE),
    ('Bim', 2, 'Dog', 'Nurlan', 'Beagle', FALSE);

-- Cats
INSERT INTO pet (name, age, species, owner_name, color, indoor)
VALUES
    ('Barsik', 3, 'Cat', 'Aida', 'White', FALSE),
    ('Murka', 1, 'Cat', 'Dana', 'Black', TRUE);

-- ================================================
-- Verify Data
-- ================================================

SELECT * FROM pet ORDER BY pet_id;

-- Count all pets
SELECT COUNT(*) as total_pets FROM pet;

-- Get only dogs
SELECT * FROM pet WHERE species = 'Dog';

-- Get only cats
SELECT * FROM pet WHERE species = 'Cat';

-- ================================================
-- Clean Up (if needed)
-- ================================================

-- Delete all records
-- DELETE FROM pet;

-- Drop table
-- DROP TABLE pet;

-- Drop database (if starting fresh)
-- DROP DATABASE vetclinic_db;