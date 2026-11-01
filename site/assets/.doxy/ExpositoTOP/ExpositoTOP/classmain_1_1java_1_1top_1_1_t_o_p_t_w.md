

# Class main::java::top::TOPTW



[**ClassList**](annotated.md) **>** [**main**](namespacemain.md) **>** [**java**](namespacemain_1_1java.md) **>** [**top**](namespacemain_1_1java_1_1top.md) **>** [**TOPTW**](classmain_1_1java_1_1top_1_1_t_o_p_t_w.md)



_Representa la definición del problema_ [_**TOPTW**_](classmain_1_1java_1_1top_1_1_t_o_p_t_w.md) _(Tourist Orienteering Problem with Time Windows)._[More...](#detailed-description)






































## Public Functions

| Type | Name |
| ---: | :--- |
|   | [**TOPTW**](#function-toptw) (int nodes, int routes) <br>_Constructor principal del problema_ [_**TOPTW**_](classmain_1_1java_1_1top_1_1_t_o_p_t_w.md) _._ |
|  int | [**addNode**](#function-addnode) () <br> |
|  int | [**addNodeDepot**](#function-addnodedepot) () <br> |
|  void | [**calculateDistanceMatrix**](#function-calculatedistancematrix) () <br> |
|  double | [**getDistance**](#function-getdistance-14) (int[] route) <br> |
|  double | [**getDistance**](#function-getdistance-24) (List&lt; Integer &gt; route) <br> |
|  double | [**getDistance**](#function-getdistance-34) (List&lt; Integer &gt;[] routes) <br> |
|  double | [**getDistance**](#function-getdistance-44) (int i, int j) <br> |
|  double | [**getDueTime**](#function-getduetime) (int index) <br> |
|  double | [**getMaxRoutes**](#function-getmaxroutes) () <br> |
|  double | [**getMaxTimePerRoute**](#function-getmaxtimeperroute) () <br> |
|  int | [**getNodes**](#function-getnodes) () <br> |
|  int | [**getPOIs**](#function-getpois) () <br> |
|  double | [**getReadyTime**](#function-getreadytime) (int index) <br> |
|  double | [**getScore**](#function-getscore-12) (int index) <br> |
|  double[] | [**getScore**](#function-getscore-22) () <br> |
|  double | [**getServiceTime**](#function-getservicetime) (int index) <br> |
|  double | [**getTime**](#function-gettime) (int i, int j) <br> |
|  int | [**getVehicles**](#function-getvehicles) () <br> |
|  double | [**getX**](#function-getx) (int index) <br> |
|  double | [**getY**](#function-gety) (int index) <br> |
|  boolean | [**isDepot**](#function-isdepot) (int a) <br> |
|  void | [**setDueTime**](#function-setduetime) (int index, double dueTime) <br> |
|  void | [**setMaxRoutes**](#function-setmaxroutes) (double maxRoutes) <br> |
|  void | [**setMaxTimePerRoute**](#function-setmaxtimeperroute) (double maxTimePerRoute) <br> |
|  void | [**setNodes**](#function-setnodes) (int nodes) <br> |
|  void | [**setReadyTime**](#function-setreadytime) (int index, double readyTime) <br> |
|  void | [**setScore**](#function-setscore) (int index, double score) <br> |
|  void | [**setServiceTime**](#function-setservicetime) (int index, double serviceTime) <br> |
|  void | [**setX**](#function-setx) (int index, double x) <br> |
|  void | [**setY**](#function-sety) (int index, double y) <br> |
|  String | [**toString**](#function-tostring) () <br> |




























## Detailed Description


Almacena todos los parámetros del problema, incluyendo nodos, coordenadas, puntuaciones (score), ventanas de tiempo permitidas y tiempos de servicio, así como la matriz de distancias. 


    
## Public Functions Documentation




### function TOPTW 

_Constructor principal del problema_ [_**TOPTW**_](classmain_1_1java_1_1top_1_1_t_o_p_t_w.md) _._
```Java
inline main::java::top::TOPTW::TOPTW (
    int nodes,
    int routes
) 
```





**Parameters:**


* `nodes` Número de nodos o puntos de interés (POIs). 
* `routes` Número de rutas (vehículos) disponibles. 




        

<hr>



### function addNode 

```Java
inline int main::java::top::TOPTW::addNode () 
```




<hr>



### function addNodeDepot 

```Java
inline int main::java::top::TOPTW::addNodeDepot () 
```




<hr>



### function calculateDistanceMatrix 

```Java
inline void main::java::top::TOPTW::calculateDistanceMatrix () 
```




<hr>



### function getDistance [1/4]

```Java
inline double main::java::top::TOPTW::getDistance (
    int[] route
) 
```




<hr>



### function getDistance [2/4]

```Java
inline double main::java::top::TOPTW::getDistance (
    List< Integer > route
) 
```




<hr>



### function getDistance [3/4]

```Java
inline double main::java::top::TOPTW::getDistance (
    List< Integer >[] routes
) 
```




<hr>



### function getDistance [4/4]

```Java
inline double main::java::top::TOPTW::getDistance (
    int i,
    int j
) 
```




<hr>



### function getDueTime 

```Java
inline double main::java::top::TOPTW::getDueTime (
    int index
) 
```




<hr>



### function getMaxRoutes 

```Java
inline double main::java::top::TOPTW::getMaxRoutes () 
```




<hr>



### function getMaxTimePerRoute 

```Java
inline double main::java::top::TOPTW::getMaxTimePerRoute () 
```




<hr>



### function getNodes 

```Java
inline int main::java::top::TOPTW::getNodes () 
```




<hr>



### function getPOIs 

```Java
inline int main::java::top::TOPTW::getPOIs () 
```




<hr>



### function getReadyTime 

```Java
inline double main::java::top::TOPTW::getReadyTime (
    int index
) 
```




<hr>



### function getScore [1/2]

```Java
inline double main::java::top::TOPTW::getScore (
    int index
) 
```




<hr>



### function getScore [2/2]

```Java
inline double[] main::java::top::TOPTW::getScore () 
```




<hr>



### function getServiceTime 

```Java
inline double main::java::top::TOPTW::getServiceTime (
    int index
) 
```




<hr>



### function getTime 

```Java
inline double main::java::top::TOPTW::getTime (
    int i,
    int j
) 
```




<hr>



### function getVehicles 

```Java
inline int main::java::top::TOPTW::getVehicles () 
```




<hr>



### function getX 

```Java
inline double main::java::top::TOPTW::getX (
    int index
) 
```




<hr>



### function getY 

```Java
inline double main::java::top::TOPTW::getY (
    int index
) 
```




<hr>



### function isDepot 

```Java
inline boolean main::java::top::TOPTW::isDepot (
    int a
) 
```




<hr>



### function setDueTime 

```Java
inline void main::java::top::TOPTW::setDueTime (
    int index,
    double dueTime
) 
```




<hr>



### function setMaxRoutes 

```Java
inline void main::java::top::TOPTW::setMaxRoutes (
    double maxRoutes
) 
```




<hr>



### function setMaxTimePerRoute 

```Java
inline void main::java::top::TOPTW::setMaxTimePerRoute (
    double maxTimePerRoute
) 
```




<hr>



### function setNodes 

```Java
inline void main::java::top::TOPTW::setNodes (
    int nodes
) 
```




<hr>



### function setReadyTime 

```Java
inline void main::java::top::TOPTW::setReadyTime (
    int index,
    double readyTime
) 
```




<hr>



### function setScore 

```Java
inline void main::java::top::TOPTW::setScore (
    int index,
    double score
) 
```




<hr>



### function setServiceTime 

```Java
inline void main::java::top::TOPTW::setServiceTime (
    int index,
    double serviceTime
) 
```




<hr>



### function setX 

```Java
inline void main::java::top::TOPTW::setX (
    int index,
    double x
) 
```




<hr>



### function setY 

```Java
inline void main::java::top::TOPTW::setY (
    int index,
    double y
) 
```




<hr>



### function toString 

```Java
inline String main::java::top::TOPTW::toString () 
```




<hr>

------------------------------
The documentation for this class was generated from the following file `src/main/java/top/TOPTW.java`

