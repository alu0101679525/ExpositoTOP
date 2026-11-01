# Registro de Decisiones

A continuación, se detallan las decisiones arquitectónicas y refactorizaciones aplicadas durante la fase de calidad del software:

1. **Gestión de Dependencias:** Se migró el proyecto hacia una arquitectura estandarizada con Maven (`pom.xml`).
2. **Control de Recursos:** Se implementó el patrón `try-with-resources` para asegurar el cierre seguro de flujos de E/S al leer archivos de instancias, resolviendo vulnerabilidades críticas (*Blockers*).
3. **Optimización de Memoria:** Se sustituyó la concatenación indiscriminada de *Strings* en bucles por objetos `StringBuilder`, optimizando la generación de tablas de formateo.
4. **Mantenibilidad:** Se redujo la complejidad cognitiva extrayendo lógica anidada compleja en los bucles de evaluación de la metaheurística GRASP hacia métodos auxiliares privados.