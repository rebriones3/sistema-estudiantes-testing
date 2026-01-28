# Sistema de Gestión de Estudiantes

![CI Status](https://github.com/rebriones3/sistema-estudiantes-testing/workflows/CI/badge.svg)
![Coverage](.github/badges/jacoco.svg)
![Branches](.github/badges/branches.svg)

## 📋 Descripción

Sistema de gestión de estudiantes desarrollado en Java con pruebas unitarias automatizadas. El proyecto incluye:

- **Calculadora**: Operaciones matemáticas básicas
- **Estudiante**: Gestión de información de estudiantes
- **GestorEstudiantes**: Administración de listas de estudiantes

## 🚀 Tecnologías

- **Java 17**: Lenguaje de programación
- **JUnit 5**: Framework de pruebas unitarias
- **Maven**: Gestión de dependencias y construcción
- **JaCoCo**: Análisis de cobertura de código
- **GitHub Actions**: Integración continua (CI/CD)

## 📊 Métricas de Calidad

- ✅ Integración Continua configurada
- ✅ Pruebas unitarias automatizadas
- ✅ Cobertura de código medida con JaCoCo
- ✅ Badges de estado en tiempo real

## 🧪 Ejecutar Pruebas

```bash
# Ejecutar todas las pruebas
mvn test

# Ejecutar pruebas con reporte de cobertura
mvn clean test jacoco:report

# Ver reporte de cobertura (en target/site/jacoco/index.html)
```

## 📁 Estructura del Proyecto

```
ParteB/
├── src/
│   ├── main/java/modelo/
│   │   ├── Calculadora.java
│   │   ├── Estudiante.java
│   │   └── GestorEstudiantes.java
│   └── test/java/modelo/
│       ├── CalculadoraTest.java
│       ├── EstudianteTest.java
│       └── GestorEstudiantesTest.java
├── .github/workflows/
│   └── ci.yml
├── pom.xml
└── README.md
```

## 👩‍💻 Autora

**Ruth Estefany Briones Moreira**
- Universidad de las Fuerzas Armadas "ESPE"
- Fecha: Enero 2026

## 📄 Licencia

Proyecto académico - ESPE 2026
