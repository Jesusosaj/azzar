# Azzar - Sistema de Rifas

Sistema integral de rifas online que integra una tienda de compra de boletos, un panel de administración y un sorteo automatizado mediante un agente inteligente.

## 📋 Descripción

Azzar es una plataforma completa para la gestión y venta de rifas online, pensada para cubrir todo el ciclo: desde que un usuario visualiza una rifa y compra sus boletos, hasta que el administrador gestiona los premios y se ejecuta el sorteo del ganador de forma automatizada.

El sistema está compuesto por tres módulos principales:

- **Tienda web**: los usuarios visualizan las rifas activas y los premios disponibles, agregan boletos al carrito y completan el pago.
- **Panel de administración**: gestión de premios, gestión de usuarios, dashboard general y una ruleta interactiva para el sorteo de los ganadores.
- **Backend + Agente inteligente**: API REST que centraliza la lógica del sistema e integra un agente inteligente desarrollado en Python, encargado de determinar el resultado del sorteo.

## ✨ Funcionalidades

- Visualización de rifas activas y premios disponibles
- Carrito de compras y flujo de pago de boletos
- Gestión de premios y usuarios desde el panel de administración
- Dashboard administrativo
- Ruleta interactiva para el sorteo de premios
- Determinación automática del ganador mediante un agente inteligente en Python

## 🛠️ Tecnologías utilizadas

| Módulo | Tecnología |
|---|---|
| Tienda web | React, Tailwind CSS |
| Panel de administración | Next.js |
| Backend | Spring Boot |
| Agente inteligente | Python |
| Base de datos | Oracle PL/SQL |

## 🏗️ Estructura del proyecto

```
azzar/
├── tienda-web/         # Aplicación React + Tailwind CSS (compra de boletos)
├── admin-panel/        # Aplicación Next.js (panel de administración)
├── backend/            # API REST en Spring Boot
├── agente-inteligente/ # Servicio en Python (determinación del ganador)
└── README.md
```

> Ajustá los nombres de carpetas según la estructura real del repositorio.

## 🚀 Instalación y configuración

### Requisitos previos

- Node.js (v18 o superior recomendado)
- Java 17+ y Maven/Gradle
- Python 3.10+
- Oracle Database (o acceso a una instancia existente)

### Tienda web

```bash
cd tienda-web
npm install
npm run dev
```

### Panel de administración

```bash
cd admin-panel
npm install
npm run dev
```

### Backend

```bash
cd backend
./mvnw spring-boot:run
```

### Agente inteligente

```bash
cd agente-inteligente
pip install -r requirements.txt
python main.py
```

> Completá las variables de entorno necesarias (conexión a base de datos, credenciales de pago, URLs de los servicios, etc.) antes de levantar cada módulo.

## 👤 Autor

Proyecto universitario desarrollado en 2025.

## 📄 Licencia

Este proyecto fue desarrollado con fines académicos.
