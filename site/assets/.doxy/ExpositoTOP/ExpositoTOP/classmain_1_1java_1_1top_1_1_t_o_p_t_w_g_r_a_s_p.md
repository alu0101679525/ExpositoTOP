

# Class main::java::top::TOPTWGRASP



[**ClassList**](annotated.md) **>** [**main**](namespacemain.md) **>** [**java**](namespacemain_1_1java.md) **>** [**top**](namespacemain_1_1java_1_1top.md) **>** [**TOPTWGRASP**](classmain_1_1java_1_1top_1_1_t_o_p_t_w_g_r_a_s_p.md)



_Implementación del algoritmo metaheurístico GRASP para el problema_ [_**TOPTW**_](classmain_1_1java_1_1top_1_1_t_o_p_t_w.md) _._[More...](#detailed-description)
























## Public Static Attributes

| Type | Name |
| ---: | :--- |
|  final double | [**NO\_EVALUATED**](#variable-no_evaluated)   = `-1.0`<br> |














## Public Functions

| Type | Name |
| ---: | :--- |
|   | [**TOPTWGRASP**](#function-toptwgrasp) ([**TOPTWSolution**](classmain_1_1java_1_1top_1_1_t_o_p_t_w_solution.md) sol) <br> |
|  int | [**aleatorySelectionRCL**](#function-aleatoryselectionrcl) (int maxTRCL) <br> |
|  List&lt; double[] &gt; | [**comprehensiveEvaluation**](#function-comprehensiveevaluation) (List&lt; Integer &gt; customers, List&lt; List&lt; Double &gt; &gt; departureTimes) <br> |
|  void | [**computeGreedySolution**](#function-computegreedysolution) (int maxSizeRCL) <br>_Construye una solución inicial utilizando un enfoque voraz y probabilístico._  |
|  int | [**fuzzySelectionAlphaCutRCL**](#function-fuzzyselectionalphacutrcl) (List&lt; double[] &gt; rcl, double alpha) <br> |
|  int | [**fuzzySelectionBestFDRCL**](#function-fuzzyselectionbestfdrcl) (List&lt; double[] &gt; rcl) <br> |
|  double | [**getMaxScore**](#function-getmaxscore) () <br> |
|  [**TOPTWSolution**](classmain_1_1java_1_1top_1_1_t_o_p_t_w_solution.md) | [**getSolution**](#function-getsolution) () <br> |
|  int | [**getSolutionTime**](#function-getsolutiontime) () <br> |
|  void | [**grasp**](#function-grasp) (int maxIterations, int maxSizeRCL) <br>_Ejecuta el procedimiento principal del algoritmo GRASP._  |
|  void | [**setSolution**](#function-setsolution) ([**TOPTWSolution**](classmain_1_1java_1_1top_1_1_t_o_p_t_w_solution.md) solution) <br> |
|  void | [**setSolutionTime**](#function-setsolutiontime) (int solutionTime) <br> |
|  void | [**updateSolution**](#function-updatesolution) (double[] candidateSelected, List&lt; List&lt; Double &gt; &gt; departureTimes) <br> |




























## Detailed Description


Utiliza una fase constructiva codiciosa aleatorizada para generar múltiples soluciones y se queda con la que ofrezca mejor puntuación (fitness). 


    
## Public Static Attributes Documentation




### variable NO\_EVALUATED 

```Java
final double main.java.top.TOPTWGRASP.NO_EVALUATED;
```




<hr>
## Public Functions Documentation




### function TOPTWGRASP 

```Java
inline main::java::top::TOPTWGRASP::TOPTWGRASP (
    TOPTWSolution sol
) 
```




<hr>



### function aleatorySelectionRCL 

```Java
inline int main::java::top::TOPTWGRASP::aleatorySelectionRCL (
    int maxTRCL
) 
```




<hr>



### function comprehensiveEvaluation 

```Java
inline List< double[] > main::java::top::TOPTWGRASP::comprehensiveEvaluation (
    List< Integer > customers,
    List< List< Double > > departureTimes
) 
```




<hr>



### function computeGreedySolution 

_Construye una solución inicial utilizando un enfoque voraz y probabilístico._ 
```Java
inline void main::java::top::TOPTWGRASP::computeGreedySolution (
    int maxSizeRCL
) 
```





**Parameters:**


* `maxSizeRCL` Tamaño máximo permitido para la Lista Restringida de Candidatos. 




        

<hr>



### function fuzzySelectionAlphaCutRCL 

```Java
inline int main::java::top::TOPTWGRASP::fuzzySelectionAlphaCutRCL (
    List< double[] > rcl,
    double alpha
) 
```




<hr>



### function fuzzySelectionBestFDRCL 

```Java
inline int main::java::top::TOPTWGRASP::fuzzySelectionBestFDRCL (
    List< double[] > rcl
) 
```




<hr>



### function getMaxScore 

```Java
inline double main::java::top::TOPTWGRASP::getMaxScore () 
```




<hr>



### function getSolution 

```Java
inline TOPTWSolution main::java::top::TOPTWGRASP::getSolution () 
```




<hr>



### function getSolutionTime 

```Java
inline int main::java::top::TOPTWGRASP::getSolutionTime () 
```




<hr>



### function grasp 

_Ejecuta el procedimiento principal del algoritmo GRASP._ 
```Java
inline void main::java::top::TOPTWGRASP::grasp (
    int maxIterations,
    int maxSizeRCL
) 
```





**Parameters:**


* `maxIterations` Número máximo de iteraciones a ejecutar. 
* `maxSizeRCL` Tamaño máximo de la Lista Restringida de Candidatos (RCL). 




        

<hr>



### function setSolution 

```Java
inline void main::java::top::TOPTWGRASP::setSolution (
    TOPTWSolution solution
) 
```




<hr>



### function setSolutionTime 

```Java
inline void main::java::top::TOPTWGRASP::setSolutionTime (
    int solutionTime
) 
```




<hr>



### function updateSolution 

```Java
inline void main::java::top::TOPTWGRASP::updateSolution (
    double[] candidateSelected,
    List< List< Double > > departureTimes
) 
```




<hr>

------------------------------
The documentation for this class was generated from the following file `src/main/java/top/TOPTWGRASP.java`

