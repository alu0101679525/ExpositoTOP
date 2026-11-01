

# Class main::java::es::ull::esit::utilities::BellmanFord



[**ClassList**](annotated.md) **>** [**main**](namespacemain.md) **>** [**java**](namespacemain_1_1java.md) **>** [**es**](namespacemain_1_1java_1_1es.md) **>** [**ull**](namespacemain_1_1java_1_1es_1_1ull.md) **>** [**esit**](namespacemain_1_1java_1_1es_1_1ull_1_1esit.md) **>** [**utilities**](namespacemain_1_1java_1_1es_1_1ull_1_1esit_1_1utilities.md) **>** [**BellmanFord**](classmain_1_1java_1_1es_1_1ull_1_1esit_1_1utilities_1_1_bellman_ford.md)



_Implementación del algoritmo de Bellman-Ford para encontrar los caminos más cortos._ [More...](#detailed-description)






































## Public Functions

| Type | Name |
| ---: | :--- |
|   | [**BellmanFord**](#function-bellmanford) (int distanceMatrix, int nodes, List&lt; Integer &gt; path) <br>_Constructor de la clase_ [_**BellmanFord**_](classmain_1_1java_1_1es_1_1ull_1_1esit_1_1utilities_1_1_bellman_ford.md) _._ |
|  int[] | [**getDistances**](#function-getdistances) () <br>_Obtiene el array con las distancias mínimas calculadas a cada nodo._  |
|  int | [**getValue**](#function-getvalue) () <br>_Obtiene el valor del coste o distancia del nodo final._  |
|  void | [**solve**](#function-solve) () <br>_Ejecuta la lógica principal del algoritmo de Bellman-Ford._  |




























## Detailed Description


Este algoritmo evalúa las distancias más cortas desde un único nodo origen hacia todos los demás nodos en un grafo dirigido ponderado. 


    
## Public Functions Documentation




### function BellmanFord 

_Constructor de la clase_ [_**BellmanFord**_](classmain_1_1java_1_1es_1_1ull_1_1esit_1_1utilities_1_1_bellman_ford.md) _._
```Java
inline main::java::es::ull::esit::utilities::BellmanFord::BellmanFord (
    int distanceMatrix,
    int nodes,
    List< Integer > path
) 
```





**Parameters:**


* `distanceMatrix` Matriz cuadrada con las distancias (pesos) entre nodos. 
* `nodes` Número total de nodos en el grafo. 
* `path` Lista donde se almacenará el camino resultante. 




        

<hr>



### function getDistances 

_Obtiene el array con las distancias mínimas calculadas a cada nodo._ 
```Java
inline int[] main::java::es::ull::esit::utilities::BellmanFord::getDistances () 
```





**Returns:**

Array de enteros representando las distancias desde el nodo origen. 





        

<hr>



### function getValue 

_Obtiene el valor del coste o distancia del nodo final._ 
```Java
inline int main::java::es::ull::esit::utilities::BellmanFord::getValue () 
```





**Returns:**

Entero con el valor calculado de la ruta. 





        

<hr>



### function solve 

_Ejecuta la lógica principal del algoritmo de Bellman-Ford._ 
```Java
inline void main::java::es::ull::esit::utilities::BellmanFord::solve () 
```



Relaja las aristas repetidamente para encontrar las distancias más cortas y reconstruye el camino resultante hacia atrás basándose en los predecesores. 


        

<hr>

------------------------------
The documentation for this class was generated from the following file `src/main/java/es/ull/esit/utilities/BellmanFord.java`

