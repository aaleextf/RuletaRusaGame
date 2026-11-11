# Ruleta Rusa Táctica 

**Autor:** Alexandru Tofan  
**Fecha:** Noviembre 2026  
**Curso:** 1.º DAW 

---

## Descripción del Proyecto

Este proyecto es una adaptación en consola del juego *Buckshot Roulette*, desarrollado en **Java** como proyecto práctico para aplicar los conocimientos fundamentales del primer trimestre de 1.º DAW (variables, estructuras condicionales `if-else`, bucles `while`/`for` y arrays paralelos).

El juego permite partidas multijugador locales de 2 a 4 jugadores que compiten por turnos intentando sobrevivir a los disparos de una pistola cargada aleatoriamente con balas reales o de fogueo.

---

## Requisitos Técnicos

* **Lenguaje:** Java Standard Edition (Java SE).
* **Versión de Java:** Java JDK 8 o superior (recomendado JDK 17 o JDK 21 LTS).
* **Entorno de ejecución / IDE:** Cualquier consola de comandos / terminal o entorno como Visual Studio Code, Eclipse o IntelliJ IDEA.
* **Librerías estándar utilizadas:**
  * `java.util.Scanner` (lectura de datos por consola).
  * `java.util.Random` (generación de aleatoriedad para turnos y balas).
  * `java.util.Arrays` (inicialización y muestra rápida de arrays).

---

## Instrucciones para Compilar y Ejecutar

1. Abre la terminal o consola de comandos en la carpeta donde guardaste el archivo `RuletaRusa.java`.
2. **Compilar el programa:**
   ```bash
   javac RuletaRusa.java
   ```
3. **Ejecutar la aplicación:**
   ````bash
   java RuletaRusa
   ````

---

## Reglas de los Disparos y Eliminación

1. **Número de Jugadores:** Se permite la participación estricta de entre **2 y 4 jugadores**.
2. **Vidas Iniciales:** Todos los jugadores inician la partida con **3 vidas**.
3. **Tipos de Balas:**
   *  **Bala Real:** Resta 1 vida al objetivo. Si la vida del jugador llega a `0`, queda **ELIMINADO**.
   *  **Bala de Fogueo:** No causa daño y el jugador alcanzado se salva en ese turno.
4. **Protección de Cadáveres:** No se permite disparar a un jugador que ya haya sido eliminado (0 vidas). Si se intenta seleccionarlo, el sistema notificará el error y obligará a elegir a un participante vivo.

---

## Funcionamiento de los Turnos

* **Sorteo Inicial:** Al empezar la partida, la clase `Random` selecciona de forma aleatoria a qué jugador le toca el primer turno.
* **Rotación Secuencial:** Tras completar una acción, el turno se incrementa (`turnoActual++`). Si el índice sobrepasa el número total de jugadores, se reinicia a `0` para mantener el ciclo continuo.
* **Salto de Jugadores Muertos:** Al inicio de cada turno se comprueba si el jugador actual tiene 0 vidas. De ser así, se muestra un mensaje informativo, se incrementa el turno y se ejecuta la sentencia `continue` para saltar el menú sin interrumpir la partida.
* **Detección de Victoria:** Al final de cada ronda, un bucle `for` realiza el recuento de jugadores vivos. Cuando solo queda **1 jugador con vida**, la variable `partidaActiva` pasa a ser `false` y el juego finaliza proclamando al ganador.

---

## Limitaciones Conocidas

* **Sensibilidad a Letras (`InputMismatchException`):** Al utilizar `scanner.nextInt()`, si el usuario introduce una letra o un símbolo por consola en lugar de un número entero, Java lanzará una excepción y el programa finalizará inesperadamente.
* **Interfaz de Consola Plana:** La experiencia de juego transcurre de forma textual en la consola del sistema, sin interfaz gráfica de usuario (GUI).
* **Estructura Imperativa:** Todo el código del juego se encuentra contenido dentro del método `main`, sin modularización en subfunciones ni clases orientadas a objetos.

---

## Funcionalidades Previstas para Próximas Evaluaciones

*  **Control de Excepciones Robustas:** Validación de datos mediante `try-catch` o lectura de cadenas para evitar errores al teclear letras.
*  **Programación Orientada a Objetos (POO):** Creación de clases separadas como `Jugador`, `Arma`, `Partida` y `Turno`.
*  **Persistencia en Ficheros:** Guardar el historial de partidas y estadísticas de victoria en archivos de texto locales.