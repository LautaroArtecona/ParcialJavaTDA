<h1 align="left">2do Parcial Taller de Programacion 1</h1>

###

<p align="left">En este repositorio van a poder encontrar tanto el parcial resuleto en Java como el enunciado. Es un parcial integrador con todo lo visto en el cuatrimestre</p>

###

<h2 align="left">Conceptos evaluados</h2>

###

<p align="left">Los conceptos evaluados hasta este momento fueron:  
  <br>- Correcta implementación de constructores.
  <br>- Aplicación adecuada de los conceptos asociados a la POO: Herencia, Polimorfismo, Composición y Agregación en Java.
  <br>- Visibilidad en Herencia.
  <br>- Tipos de datos abstractos, clases e interfaces abstractas.
  <br>- Manejo de vectores y matrices.
  <br>- Manejo de estructuras como Pilas, Colas y Listas Ordenadas.</p>

###

<h2 align="left">Enunciado</h2>

###

<p align="left">El Festival de Cine Independiente ya cuenta con un sistema funcional para acreditar a los espectadores de 
sus 10 películas. Las películas se proyectan en la única sala del Festival que cuenta con capacidad para 800 
butacas. El sistema ya desarrollado nos entrega, por cada película, tres nóminas de acreditaciones, una por 
cada tipo de función: 
  <br>
  <br>● Avant-Première 
  <br>● Función Privada 
  <br>● Función General 
  <br>
  <br>Los dos primeros tipos de función son especiales, ya que hay una sola función de cada tipo por película. 
Estas tienen como tope de acreditaciones la capacidad de la sala (800 butacas) y están ordenadas por DNI 
del acreditado.
  <br>
  <br>La nómina para funciones generales, en cambio, mantiene el resto de las registraciones para esa película, y 
no tiene límite, pues se generarán tantas funciones generales por película como haga falta.
  <br>
  <br>El sistema también es capaz de generar una matriz que indica, por cada película y tipo de función, la cantidad 
total de acreditaciones registradas hasta el momento. 
  <br>
  <br>
  <br>Objetivo
  <br>
  <br>Todas las acreditaciones ya fueron generadas y asignadas a las nóminas correspondientes en una etapa 
anterior. El sistema ya sabe cargar registraciones y procesarlas para crear las acreditaciones para los 
distintos tipos de función que se harán para cada película. En el código podrás encontrar partes que procesan 
esa etapa, pero no es necesario modificarlas ni están reflejadas en el diagrama UML que te compartimos en 
este enunciado. 
  <br>
  <br>A partir del proyecto ya desarrollado que contiene una implementación completa del sistema necesario hasta 
este punto, debemos completar y ampliar las funcionalidades para permitir el análisis de acreditaciones y la 
generación de funciones de proyección a partir de las nóminas de acreditados, dando prioridad a las 
funciones especiales cuando corresponda. 
  <br>
  <br>
  <br>Se deben implementar: 
  <br>
  <br>1- Resolver los bugs que aparecen en el proyecto. ya nos avisaron que hay un error de lógica que evita 
que se carguen acreditaciones. 
  <br>
  <br>2- getFuncionesGeneralesNecesarias() : Este método de instancia de Pelicula debe calcular cuántas funciones generales serán necesarias 
para los acreditados que quedaron en la nómina de funciones generales. Recordá que el límite por 
función está determinado por la cantidad de butacas disponibles en la sala.
  <br>
  <br>3- mostrarDatosDeAcreditaciones() : Este método de instancia debe recorrer la matriz de cantidades generada por 
obtenerAcreditadosPorTipoDeFuncionYPelicula() (que representa las cantidades de acreditados 
organizadas por película y tipo de función) para mostrar por consola una tabla que indique: 
  <br>
  <br>● La cantidad de acreditaciones por tipo de función y película. 
  <br>● Los totales por tipo de función y por película. 
  <br>● La cantidad de funciones generales que harán falta para que ningún acreditado se quede sin 
ver la película. 
  <br>
  <br>4- generarFunciones() : Cada película debe generar y mantener objetos de tipo Funcion, uno por cada función de proyección 
que se pueda crear las acreditaciones de sus nóminas. Para esto deben: 
  <br>
  <br>a. Diseñar la clase Funcion, asegurando que: 
  <br>- Tenga un tipo (Avant-Première, Función Privada, Función General). 
  <br>- Sepa qué película proyecta. 
  <br>- Mantenga la lista de acreditados para esa función. Para construirla, deberá extraer las 
acreditaciones de la nómina correspondiente.
  <br>- Debe mantener los datos ordenados por DNI y soportar búsquedas por ese campo. 
  <br>
  <br>b. El método debe: 
  <br>- Generar una función especial para Avant-Première (si hay acreditados) 
<br>- Generar una función especial para  Función Privada (si hay acreditados) 
<br>- Generar tantas funciones generales como sea necesario (sin superar la capacidad de la 
sala). 
<br>- No se generarán funciones si no hay acreditaciones. 
  <br>
  <br>5- listarFunciones() : Desarrollar los métodos para mostrar todas las funciones que se proyectarán en el festival a partir de 
los acreditados existentes. 
  <br>
  <br>Al ejecutar el programa debemos obtener una salida similar a esta, que refleje el estado de las nóminas de 
acreditación antes y después de generar las funciones. Se valorará mucho que el formato sea lo más similar 
posible a la salida que se muestra a continuación (esta salida se hace solo con dos películas, pero deberían 
ser todas). 
  <br>
  <br>
  <br>Acreditados 'Arrival' 
<br>AVANT_PREMIERE: 1 - FUNCION_PRIVADA: 0 - GENERAL: 5 - TOTAL: 6 
<br>Funciones GENERAL: 1 
<br>Acreditados '2001: Una Odisea del Espacio' 
<br>AVANT_PREMIERE: 1 - FUNCION_PRIVADA: 0 - GENERAL: 1 - TOTAL: 2 
<br>Funciones GENERAL: 1 
<br>Acreditados TOTAL 
<br>AVANT_PREMIERE: 2 - FUNCION_PRIVADA: 0 - GENERAL: 6 - TOTAL: 8 
  <br>------------------------------------------ 
<br>Funcion [titulo=Arrival, tipoDeFuncion=AVANT_PREMIERE, acreditaciones=1] 
<br>Funcion [titulo=Arrival, tipoDeFuncion=GENERAL, acreditaciones=5] 
<br>Funcion [titulo=2001: Una Odisea del Espacio, tipoDeFuncion=AVANT_PREMIERE, acreditaciones=1] 
<br>Funcion [titulo=2001: Una Odisea del Espacio, tipoDeFuncion=GENERAL, acreditaciones=1] 
<br>
<br>
<br>Consideraciones
<br>
<br>● No se debe modificar la lógica original de acreditación ni la estructura del sistema provisto. 
<br>● Sí se pueden extender para hacer lo que necesiten. 
<br>● Sé cuidadoso con la reutilización de código y el encapsulamiento. 
<br>● Usá los TADs adecuados según el comportamiento esperado. 
