# Manual de Usuario

Bienvenido al manual de usuario del recomendador turístico con ventanas de tiempo (TOPTW).

## Descripción del Proyecto
ExpositoTOP es una herramienta desarrollada en Java para resolver el **Tourist Orienteering Problem with Time Windows (TOPTW)**. El sistema calcula las rutas óptimas para un conjunto de vehículos (turistas), maximizando la puntuación (score) de los puntos de interés visitados, respetando estrictamente las ventanas de tiempo de apertura y cierre de cada localización.

## Requisitos Previos
- **Java 11** o superior.
- **Maven 3.x** para la construcción del proyecto.

## Construcción y Ejecución
El proyecto se gestiona íntegramente a través de Maven.
1. Compilación: `mvn clean compile`
2. Empaquetado: `mvn package`
3. Ejecución: El punto de entrada principal es la clase `MainTOPTW`. El programa cargará automáticamente las instancias de prueba desde el directorio `Instances/TOPTW/`.