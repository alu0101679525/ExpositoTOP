

# Class main::java::top::TOPTWSolution



[**ClassList**](annotated.md) **>** [**main**](namespacemain.md) **>** [**java**](namespacemain_1_1java.md) **>** [**top**](namespacemain_1_1java_1_1top.md) **>** [**TOPTWSolution**](classmain_1_1java_1_1top_1_1_t_o_p_t_w_solution.md)



_Representa una solución factible para el problema_ [_**TOPTW**_](classmain_1_1java_1_1top_1_1_t_o_p_t_w.md) _._[More...](#detailed-description)
























## Public Static Attributes

| Type | Name |
| ---: | :--- |
|  final int | [**NO\_INITIALIZED**](#variable-no_initialized)   = `-1`<br> |














## Public Functions

| Type | Name |
| ---: | :--- |
|   | [**TOPTWSolution**](#function-toptwsolution) ([**TOPTW**](classmain_1_1java_1_1top_1_1_t_o_p_t_w.md) problem) <br> |
|  int | [**addRoute**](#function-addroute) () <br> |
|  boolean | [**equals**](#function-equals) (Object obj) <br> |
|  double | [**evaluateFitness**](#function-evaluatefitness) () <br>_Evalúa la función objetivo de la solución actual._  |
|  int | [**getAvailableVehicles**](#function-getavailablevehicles) () <br> |
|  int | [**getCreatedRoutes**](#function-getcreatedroutes) () <br> |
|  double | [**getDistance**](#function-getdistance) (int x, int y) <br> |
|  int | [**getIndexRoute**](#function-getindexroute) (int index) <br> |
|  String | [**getInfoSolution**](#function-getinfosolution) () <br> |
|  double | [**getObjectiveFunctionValue**](#function-getobjectivefunctionvalue) () <br> |
|  int | [**getPositionInRoute**](#function-getpositioninroute) (int customer) <br> |
|  int | [**getPredecessor**](#function-getpredecessor) (int customer) <br> |
|  int[] | [**getPredecessors**](#function-getpredecessors) () <br> |
|  [**TOPTW**](classmain_1_1java_1_1top_1_1_t_o_p_t_w.md) | [**getProblem**](#function-getproblem) () <br> |
|  int | [**getSuccessor**](#function-getsuccessor) (int customer) <br> |
|  int[] | [**getSuccessors**](#function-getsuccessors) () <br> |
|  double | [**getWaitingTime**](#function-getwaitingtime) (int customer) <br> |
|  int | [**hashCode**](#function-hashcode) () <br> |
|  void | [**initSolution**](#function-initsolution) () <br> |
|  boolean | [**isDepot**](#function-isdepot) (int c) <br> |
|  double | [**printSolution**](#function-printsolution) () <br> |
|  void | [**setAvailableVehicles**](#function-setavailablevehicles) (int availableVehicles) <br> |
|  void | [**setObjectiveFunctionValue**](#function-setobjectivefunctionvalue) (double objectiveFunctionValue) <br> |
|  void | [**setPositionInRoute**](#function-setpositioninroute) (int customer, int position) <br> |
|  void | [**setPredecessor**](#function-setpredecessor) (int customer, int predecessor) <br> |
|  void | [**setSuccessor**](#function-setsuccessor) (int customer, int succesor) <br> |
|  void | [**setWaitingTime**](#function-setwaitingtime) (int customer, int waitingTime) <br> |




























## Detailed Description


Gestiona las rutas construidas, asignando predecesores y sucesores para cada cliente, calculando tiempos de espera, y evaluando la función objetivo (fitness). 


    
## Public Static Attributes Documentation




### variable NO\_INITIALIZED 

```Java
final int main.java.top.TOPTWSolution.NO_INITIALIZED;
```




<hr>
## Public Functions Documentation




### function TOPTWSolution 

```Java
inline main::java::top::TOPTWSolution::TOPTWSolution (
    TOPTW problem
) 
```




<hr>



### function addRoute 

```Java
inline int main::java::top::TOPTWSolution::addRoute () 
```




<hr>



### function equals 

```Java
inline boolean main::java::top::TOPTWSolution::equals (
    Object obj
) 
```




<hr>



### function evaluateFitness 

_Evalúa la función objetivo de la solución actual._ 
```Java
inline double main::java::top::TOPTWSolution::evaluateFitness () 
```





**Returns:**

Suma total de las puntuaciones (scores) obtenidas en todas las rutas creadas. 





        

<hr>



### function getAvailableVehicles 

```Java
inline int main::java::top::TOPTWSolution::getAvailableVehicles () 
```




<hr>



### function getCreatedRoutes 

```Java
inline int main::java::top::TOPTWSolution::getCreatedRoutes () 
```




<hr>



### function getDistance 

```Java
inline double main::java::top::TOPTWSolution::getDistance (
    int x,
    int y
) 
```




<hr>



### function getIndexRoute 

```Java
inline int main::java::top::TOPTWSolution::getIndexRoute (
    int index
) 
```




<hr>



### function getInfoSolution 

```Java
inline String main::java::top::TOPTWSolution::getInfoSolution () 
```




<hr>



### function getObjectiveFunctionValue 

```Java
inline double main::java::top::TOPTWSolution::getObjectiveFunctionValue () 
```




<hr>



### function getPositionInRoute 

```Java
inline int main::java::top::TOPTWSolution::getPositionInRoute (
    int customer
) 
```




<hr>



### function getPredecessor 

```Java
inline int main::java::top::TOPTWSolution::getPredecessor (
    int customer
) 
```




<hr>



### function getPredecessors 

```Java
inline int[] main::java::top::TOPTWSolution::getPredecessors () 
```




<hr>



### function getProblem 

```Java
inline TOPTW main::java::top::TOPTWSolution::getProblem () 
```




<hr>



### function getSuccessor 

```Java
inline int main::java::top::TOPTWSolution::getSuccessor (
    int customer
) 
```




<hr>



### function getSuccessors 

```Java
inline int[] main::java::top::TOPTWSolution::getSuccessors () 
```




<hr>



### function getWaitingTime 

```Java
inline double main::java::top::TOPTWSolution::getWaitingTime (
    int customer
) 
```




<hr>



### function hashCode 

```Java
inline int main::java::top::TOPTWSolution::hashCode () 
```




<hr>



### function initSolution 

```Java
inline void main::java::top::TOPTWSolution::initSolution () 
```




<hr>



### function isDepot 

```Java
inline boolean main::java::top::TOPTWSolution::isDepot (
    int c
) 
```




<hr>



### function printSolution 

```Java
inline double main::java::top::TOPTWSolution::printSolution () 
```




<hr>



### function setAvailableVehicles 

```Java
inline void main::java::top::TOPTWSolution::setAvailableVehicles (
    int availableVehicles
) 
```




<hr>



### function setObjectiveFunctionValue 

```Java
inline void main::java::top::TOPTWSolution::setObjectiveFunctionValue (
    double objectiveFunctionValue
) 
```




<hr>



### function setPositionInRoute 

```Java
inline void main::java::top::TOPTWSolution::setPositionInRoute (
    int customer,
    int position
) 
```




<hr>



### function setPredecessor 

```Java
inline void main::java::top::TOPTWSolution::setPredecessor (
    int customer,
    int predecessor
) 
```




<hr>



### function setSuccessor 

```Java
inline void main::java::top::TOPTWSolution::setSuccessor (
    int customer,
    int succesor
) 
```




<hr>



### function setWaitingTime 

```Java
inline void main::java::top::TOPTWSolution::setWaitingTime (
    int customer,
    int waitingTime
) 
```




<hr>

------------------------------
The documentation for this class was generated from the following file `src/main/java/top/TOPTWSolution.java`

