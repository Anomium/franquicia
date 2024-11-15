﻿# Guía de Instalación de la Aplicación con MySQL

## 1. Configurar la Base de Datos MySQL

### 1.1 Acceder a MySQL
Abre el cliente MySQL en tu terminal o consola.

### 1.2 Ejecutar las Queries de Creación de Base de Datos y Tablas

Copia y ejecuta el siguiente bloque de código SQL en tu cliente MySQL para crear la base de datos `sistema_franquicias` y las tablas necesarias:

```sql
-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS sistema_franquicias;

-- Usar la base de datos
USE sistema_franquicias;

-- Crear tabla de Franquicias
CREATE TABLE IF NOT EXISTS franquicia (
    id_franquicia INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    fecha_actualizacion TIMESTAMP DEFAULT NULL
);

-- Crear tabla de Sucursales
CREATE TABLE IF NOT EXISTS sucursal (
    id_sucursal INT PRIMARY KEY AUTO_INCREMENT,
    id_franquicia INT NOT NULL,
    nombre VARCHAR(100) NOT NULL,
    direccion VARCHAR(255),
    telefono VARCHAR(20),
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    fecha_actualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (id_franquicia) REFERENCES franquicia(id_franquicia)
);

-- Crear tabla de Productos
CREATE TABLE IF NOT EXISTS producto (
    id_producto INT PRIMARY KEY AUTO_INCREMENT,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT,
    precio_base DECIMAL(10,2) DEFAULT 0.00,
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    fecha_actualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

-- Crear tabla de relación Producto-Sucursal
CREATE TABLE IF NOT EXISTS producto_sucursal (
    id_producto_sucursal INT PRIMARY KEY AUTO_INCREMENT,
    id_sucursal INT NOT NULL,
    id_producto INT NOT NULL,
    stock INT NOT NULL DEFAULT 0,
    precio_venta DECIMAL(10,2),
    fecha_creacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    fecha_actualizacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FOREIGN KEY (id_sucursal) REFERENCES sucursal(id_sucursal),
    FOREIGN KEY (id_producto) REFERENCES producto(id_producto)
);

-- Crear índices para mejorar el rendimiento
CREATE INDEX idx_franquicia_nombre ON franquicia(nombre);
CREATE INDEX idx_sucursal_nombre ON sucursal(nombre);
CREATE INDEX idx_producto_nombre ON producto(nombre);
CREATE INDEX idx_producto_sucursal_stock ON producto_sucursal(stock);
```
# Guía de configuracion de nuestro cliente rest
### Ejemplo de Solicitud POST para Crear una Franquicia

```bash
curl --request POST \
  --url http://localhost:8080/api/franquicias \
  --header 'Content-Type: application/json' \
  --data '{
    "nombre": "McDonalds"
}`
```

### Ejemplo de Solicitud PUT para Actualizar el Nombre de una Franquicia

```bash
curl --request PUT \
  --url http://localhost:8080/api/franquicias \
  --header 'Content-Type: application/json' \
  --data '{
    "nombreActual": "McDonalds",
    "nombreNuevo": "McDonalds Express"
}'
```
### Ejemplo de Solicitud PUT para Actualizar el Nombre de una Sucursal

```bash
curl --request PUT \
  --url http://localhost:8080/api/sucursal \
  --header 'Content-Type: application/json' \
  --data '{
    "nombreActual": "Sucursal Norte",
    "nombreNuevo": "Sucursal Centro"
}'
```

### Ejemplo de Solicitud POST para Crear una Nueva Sucursal

```bash
curl --request POST \
  --url http://localhost:8080/api/sucursal/create \
  --header 'Content-Type: application/json' \
  --data '{
    "idfranquicia": 3,
    "nombre": "Sucursal Centro2",
    "direccion": "Calle Principal #123",
    "telefono": "123-456-7890"
}'
```

### Ejemplo de Solicitud GET para Obtener un Listado de Productos con mayor stock y retorna a que sucursal pertenecer

```bash
curl --request GET \
  --url http://localhost:8080/api/producto/2
```

### Ejemplo de Solicitud POST para Crear un Nuevo Producto en una Sucursal

```bash
curl --request POST \
  --url http://localhost:8080/api/producto \
  --header 'Content-Type: application/json' \
  --header 'User-Agent: Insomnia/2023.5.7' \
  --data '{
    "idSucursal": 3,
    "nombre": "nombre1",
    "descripcion": "descripcion3",
    "precioBase": 1234,
    "stock": 100,
    "precioVenta": 1234
}'
```

### Ejemplo de Solicitud DELETE para Eliminar un Producto

```bash
curl --request DELETE \
  --url http://localhost:8080/api/producto/34 \
  --header 'User-Agent: Insomnia/2023.5.7'
```

# Diagrama Entidad-Relación
![Mi genial imagen](https://raw.githubusercontent.com/Anomium/franquicia/refs/heads/feature/documentacion/img/Diagrama%20entidad%20relacion.png)

## 1. Entidad "Franquicia"
- **Atributos**:
    - `id_franquicia` (clave primaria).
- **Relación**:
    - Relación de **uno a muchos** con **Sucursal**.
    - Una franquicia puede tener muchas sucursales, pero cada sucursal pertenece a una sola franquicia.

## 2. Entidad "Sucursal"
- **Atributos**:
    - `id_sucursal` (parte de la clave primaria).
    - `id_franquicia` (parte de la clave primaria, también clave foránea que hace referencia a **Franquicia**).
- **Relación**:
    - Relación de **uno a muchos** con **Producto_sucursal**.
    - Cada sucursal puede tener muchos productos asociados, pero cada producto en la sucursal está asociado a una sola sucursal.

## 3. Entidad "Producto_sucursal"
- **Atributos**:
    - `id_producto_sucursal` (clave primaria).
    - `id_sucursal` (clave foránea que hace referencia a **Sucursal**).
    - `id_producto` (clave foránea que hace referencia a **Producto**).
- **Relación**:
    - Relación de **muchos a uno** con **Producto**.
    - Muchos registros de productos en sucursales pueden estar asociados a un solo producto, pero cada producto tiene una sola entrada por cada sucursal.

## 4. Entidad "Producto"
- **Atributos**:
    - `id_producto` (clave primaria).
- **Relación**:
    - Relación de **muchos a uno** con **Producto_sucursal**.
    - Varios registros en **Producto_sucursal** pueden hacer referencia a un solo producto.

---

## Resumen de relaciones

- **Franquicia** → **Sucursal**: Relación **uno a muchos** (una franquicia tiene varias sucursales, pero una sucursal pertenece a una sola franquicia).
- **Sucursal** → **Producto_sucursal**: Relación **uno a muchos** (una sucursal tiene varios productos asociados, pero cada producto en la sucursal pertenece a una sola sucursal).
- **Producto_sucursal** → **Producto**: Relación **muchos a uno** (varias entradas de productos en sucursales pueden referirse a un solo producto).

---

## Esquema del Diagrama ER

1. **Franquicia** (`id_franquicia`)
    - Relación 1:N con **Sucursal** (`id_sucursal`, `id_franquicia`).

2. **Sucursal** (`id_sucursal`, `id_franquicia`)
    - Relación 1:N con **Producto_sucursal** (`id_producto_sucursal`, `id_sucursal`, `id_producto`).

3. **Producto_sucursal** (`id_producto_sucursal`, `id_sucursal`, `id_producto`)
    - Relación N:1 con **Producto** (`id_producto`).

---

Este modelo refleja la estructura jerárquica de cómo las franquicias gestionan sus sucursales y los productos que se ofrecen en ellas.
