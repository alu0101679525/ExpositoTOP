# Algoritmo GRASP

El núcleo resolutivo de ExpositoTOP se basa en una metaheurística **GRASP** (Greedy Randomized Adaptive Search Procedure).

## Funcionamiento
1. **Fase Constructiva (Greedy Randomized):** En cada iteración, el algoritmo no toma siempre la mejor decisión local absoluta. En su lugar, evalúa a los candidatos y crea una Lista Restringida de Candidatos (RCL).
2. **Selección Difusa (Fuzzy Selection):** Se selecciona el candidato a insertar mediante un sistema de evaluación probabilística que puede utilizar cortes Alpha o el mejor valor de membresía (Fuzzy).
3. **Cálculo de Costes:** La inserción de un candidato en una ruta evalúa los *ready times* (tiempo de apertura) y los *due times* (tiempo de cierre). Si una inserción viola los márgenes temporales de los nodos siguientes, se descarta.
4. **Iteraciones:** El proceso se repite miles de veces, devolviendo finalmente la solución global que arroje la mayor puntuación de fitness.