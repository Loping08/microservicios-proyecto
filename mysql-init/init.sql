-- Crear la base de datos si no existe
CREATE DATABASE IF NOT EXISTS db_linktic;

-- Usar la base de datos
USE db_linktic;

-- Crear tabla productos
CREATE TABLE IF NOT EXISTS productos (
  id INT PRIMARY KEY AUTO_INCREMENT,
  nombre VARCHAR(255),
  precio DECIMAL(10,2),
  create_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Datos iniciales para productos
INSERT INTO productos (nombre, precio) VALUES
('ZOWIE EC3', 760000),
('ZOWIE FK2', 650000),
('ZOWIE ZA11', 820000),
('ZOWIE FK1', 840000);

-- Crear tabla inventarios
CREATE TABLE IF NOT EXISTS inventarios (
  id INT PRIMARY KEY AUTO_INCREMENT,
  producto_id INT,
  cantidad INT,
  create_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  FOREIGN KEY (producto_id) REFERENCES productos(id) ON DELETE CASCADE
);

-- Datos iniciales para inventarios
INSERT INTO inventarios (producto_id, cantidad) VALUES
(1, 50),
(2, 30),
(3, 40),
(4, 100);