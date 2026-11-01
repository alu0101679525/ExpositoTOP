

# Class main::java::es::ull::esit::utilities::ExpositoUtilities



[**ClassList**](annotated.md) **>** [**main**](namespacemain.md) **>** [**java**](namespacemain_1_1java.md) **>** [**es**](namespacemain_1_1java_1_1es.md) **>** [**ull**](namespacemain_1_1java_1_1es_1_1ull.md) **>** [**esit**](namespacemain_1_1java_1_1es_1_1ull_1_1esit.md) **>** [**utilities**](namespacemain_1_1java_1_1es_1_1ull_1_1esit_1_1utilities.md) **>** [**ExpositoUtilities**](classmain_1_1java_1_1es_1_1ull_1_1esit_1_1utilities_1_1_exposito_utilities.md)




























## Public Static Attributes

| Type | Name |
| ---: | :--- |
|  final int | [**ALIGNMENT\_LEFT**](#variable-alignment_left)   = `1`<br> |
|  final int | [**ALIGNMENT\_RIGHT**](#variable-alignment_right)   = `2`<br> |
|  final int | [**DEFAULT\_COLUMN\_WIDTH**](#variable-default_column_width)   = `10`<br> |
















## Public Static Functions

| Type | Name |
| ---: | :--- |
|  String | [**getFormat**](#function-getformat-112) (String string) <br> |
|  String | [**getFormat**](#function-getformat-212) (double value) <br> |
|  String | [**getFormat**](#function-getformat-312) (double value, int zeros) <br> |
|  String | [**getFormat**](#function-getformat-412) (String string, int width) <br> |
|  String | [**getFormat**](#function-getformat-512) (String string, int width, int alignment) <br> |
|  String | [**getFormat**](#function-getformat-612) (List&lt; String &gt; strings, int width) <br> |
|  String | [**getFormat**](#function-getformat-712) (List&lt; Integer &gt; strings) <br> |
|  String | [**getFormat**](#function-getformat-812) (String[] strings, int width) <br> |
|  String | [**getFormat**](#function-getformat-912) (String matrixStrings, int width) <br> |
|  String | [**getFormat**](#function-getformat-1012) (String[] strings) <br> |
|  String | [**getFormat**](#function-getformat-1112) (String[] strings, int[] width) <br> |
|  String | [**getFormat**](#function-getformat-1212) (String[] strings, int[] width, int[] alignment) <br> |
|  boolean | [**isAcyclic**](#function-isacyclic) (int distanceMatrix) <br> |
|  boolean | [**isDouble**](#function-isdouble) (String str) <br> |
|  boolean | [**isInteger**](#function-isinteger) (String str) <br> |
|  double[][] | [**multiplyMatrices**](#function-multiplymatrices) (double a, double b) <br> |
|  void | [**printFile**](#function-printfile) (String file) <br> |
|  String | [**simplifyString**](#function-simplifystring) (String string) <br> |
|  boolean | [**thereIsPath**](#function-thereispath) (int distanceMatrix, int node) <br> |
|  void | [**writeTextToFile**](#function-writetexttofile) (String file, String text) <br> |


























## Public Static Attributes Documentation




### variable ALIGNMENT\_LEFT 

```Java
final int main.java.es.ull.esit.utilities.ExpositoUtilities.ALIGNMENT_LEFT;
```




<hr>



### variable ALIGNMENT\_RIGHT 

```Java
final int main.java.es.ull.esit.utilities.ExpositoUtilities.ALIGNMENT_RIGHT;
```




<hr>



### variable DEFAULT\_COLUMN\_WIDTH 

```Java
final int main.java.es.ull.esit.utilities.ExpositoUtilities.DEFAULT_COLUMN_WIDTH;
```




<hr>
## Public Static Functions Documentation




### function getFormat [1/12]

```Java
static inline String main::java::es::ull::esit::utilities::ExpositoUtilities::getFormat (
    String string
) 
```




<hr>



### function getFormat [2/12]

```Java
static inline String main::java::es::ull::esit::utilities::ExpositoUtilities::getFormat (
    double value
) 
```




<hr>



### function getFormat [3/12]

```Java
static inline String main::java::es::ull::esit::utilities::ExpositoUtilities::getFormat (
    double value,
    int zeros
) 
```




<hr>



### function getFormat [4/12]

```Java
static inline String main::java::es::ull::esit::utilities::ExpositoUtilities::getFormat (
    String string,
    int width
) 
```




<hr>



### function getFormat [5/12]

```Java
static inline String main::java::es::ull::esit::utilities::ExpositoUtilities::getFormat (
    String string,
    int width,
    int alignment
) 
```




<hr>



### function getFormat [6/12]

```Java
static inline String main::java::es::ull::esit::utilities::ExpositoUtilities::getFormat (
    List< String > strings,
    int width
) 
```




<hr>



### function getFormat [7/12]

```Java
static inline String main::java::es::ull::esit::utilities::ExpositoUtilities::getFormat (
    List< Integer > strings
) 
```




<hr>



### function getFormat [8/12]

```Java
static inline String main::java::es::ull::esit::utilities::ExpositoUtilities::getFormat (
    String[] strings,
    int width
) 
```




<hr>



### function getFormat [9/12]

```Java
static inline String main::java::es::ull::esit::utilities::ExpositoUtilities::getFormat (
    String matrixStrings,
    int width
) 
```




<hr>



### function getFormat [10/12]

```Java
static inline String main::java::es::ull::esit::utilities::ExpositoUtilities::getFormat (
    String[] strings
) 
```




<hr>



### function getFormat [11/12]

```Java
static inline String main::java::es::ull::esit::utilities::ExpositoUtilities::getFormat (
    String[] strings,
    int[] width
) 
```




<hr>



### function getFormat [12/12]

```Java
static inline String main::java::es::ull::esit::utilities::ExpositoUtilities::getFormat (
    String[] strings,
    int[] width,
    int[] alignment
) 
```




<hr>



### function isAcyclic 

```Java
static inline boolean main::java::es::ull::esit::utilities::ExpositoUtilities::isAcyclic (
    int distanceMatrix
) 
```




<hr>



### function isDouble 

```Java
static inline boolean main::java::es::ull::esit::utilities::ExpositoUtilities::isDouble (
    String str
) 
```




<hr>



### function isInteger 

```Java
static inline boolean main::java::es::ull::esit::utilities::ExpositoUtilities::isInteger (
    String str
) 
```




<hr>



### function multiplyMatrices 

```Java
static inline double[][] main::java::es::ull::esit::utilities::ExpositoUtilities::multiplyMatrices (
    double a,
    double b
) 
```




<hr>



### function printFile 

```Java
static inline void main::java::es::ull::esit::utilities::ExpositoUtilities::printFile (
    String file
) 
```




<hr>



### function simplifyString 

```Java
static inline String main::java::es::ull::esit::utilities::ExpositoUtilities::simplifyString (
    String string
) 
```




<hr>



### function thereIsPath 

```Java
static inline boolean main::java::es::ull::esit::utilities::ExpositoUtilities::thereIsPath (
    int distanceMatrix,
    int node
) 
```




<hr>



### function writeTextToFile 

```Java
static inline void main::java::es::ull::esit::utilities::ExpositoUtilities::writeTextToFile (
    String file,
    String text
) 
```




<hr>

------------------------------
The documentation for this class was generated from the following file `src/main/java/es/ull/esit/utilities/ExpositoUtilities.java`

