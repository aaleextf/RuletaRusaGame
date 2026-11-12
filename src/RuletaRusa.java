/*
Autor: Alexandru Tofan
Fecha: 21/10/2026
Descripción: Vamos a crear un juego basado en Buckshot Roulette,
empleando todo lo aprendido durante el curso y mejorándolo a medida que avanzamos.
Nombres en blanco, comprobacion de letras dudas profe
*/

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class RuletaRusa {

    public static void main(String[] args) {

        // Creamos el scanner y el random.
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int totalJugadores;

        while (true) {
            System.out.println("------------------------------------------------------------");
            System.out.println("Bienvenido, ¿cuántos jugadores vais a participar? (De 2 a 4)");
            System.out.println("------------------------------------------------------------");

            totalJugadores = scanner.nextInt();
            scanner.nextLine();

            if (totalJugadores > 1 && totalJugadores < 5) {
                break; // Si se cumple la condicion salimos del bucle
            } else {
                System.out.println("Cantidad no válida. Deben participar entre 2 y 4 jugadores. Pruébalo de nuevo:");
            }
        }
        final int TOTALVIDAS = 3;

        // Creamos los arrays de jugadores y sus respectivas vidas.
        String[] jugadores = new String[totalJugadores];// Aqui se guardan los nombres en funcion de los que hayan.
        int[] vidasJugadores = new int[totalJugadores];// Aqui se guardan las vidas de cada jugador en funcion de los
                                                       // jugadores que hayan.
        Arrays.fill(vidasJugadores, TOTALVIDAS); // Esto hace que cada jugador empiece con 3 vidas como ya hemos
                                                 // declarado en la constante.

        // Bucle para pedir el nombre de cada jugador.
        for (int i = 0; i < jugadores.length; i++) { // Recorre el bucle por los jugadores que le introducimos, es decir
                                                     // que si hay 3 jugadores el bucle se repite 3 veces para cada
                                                     // jugador.

            do {
                System.out.println("----------------------------------------------");
                System.out.println("Introduce el nombre del jugador " + (i + 1) + ": ");
                System.out.println("----------------------------------------------");
                jugadores[i] = scanner.nextLine();

                if (jugadores[i].isEmpty()) {
                    System.out.println("Introduce un nombre valido");
                }
            }while (jugadores[i].isEmpty());
                



        }
        // Nos imprime los jugadores de la partida.
        System.out.println("--------------------------------");
        System.out.println("\n----- LISTA DE JUGADORES -----");
        System.out.println(Arrays.toString(jugadores));
        System.out.println("--------------------------------");

        // Usamos random para elegir aleatoriamente quien empieza.
        int indiceAleatorio = random.nextInt(jugadores.length);
        String jugadorElegido = jugadores[indiceAleatorio];

        // Random selecciona un jugador y lo guarda en turnoActual.
        int turnoActual = random.nextInt(jugadores.length);

        // Comienza el bucle de la partida, esto hace que hasta que el boolean no cambie
        // a false(cuando solo queda un jugador con vida) no se acaba el bucle.
        boolean partidaActiva = true;
        while (partidaActiva) {
            jugadorElegido = jugadores[turnoActual];
            // Este if nos permite excluir al jugador con 0 vidas, lo primer que se
            // comprueba es si el jugador tiene vidas para jugar, si las tiene se le da el
            // turno sino se salta.
            if (vidasJugadores[turnoActual] <= 0) {

                System.out
                        .println("\n " + jugadores[turnoActual] + " está muerto y no puede jugar. Se salta su turno.");

                turnoActual++;

                if (turnoActual >= jugadores.length) {
                    turnoActual = 0;
                }
                continue;
            }
            // Mensaje en pantalla de a quien le toca y que accion va a elegir.
            System.out.println("\n-----------------------");
            System.out.println("TURNO DE: " + jugadorElegido);
            System.out.println("-------------------------");
            System.out.println("¿Qué opción eliges?: ");
            System.out.println("1---------- TOMAR PISTOLA Y TENTAR A LA SUERTE ----------");
            System.out.println("2---------- PASAR TURNO ----------");

            int accion1 = scanner.nextInt();
            scanner.nextLine();
 

            // Esto nos permite realizar una accion, es decir que si introducimos "1"
            // disparamos a alguien y si ponemos "2" pasamos turno.
            if (accion1 == 1) {
                int disparar;
               
                while (true) { 
                    System.out.println("\nIndica el número del jugador al que quieres disparar:");
                    // Este bucle nos muestra cada jugador con sus vidas.
                    for (int i = 0; i < jugadores.length; i++) {
                        System.out.println((i+1) + ". " + jugadores[i] + " [Vidas: " + vidasJugadores[i] + "]");
                    }
                    disparar = scanner.nextInt() - 1;
                    
                    if (disparar < 0 || disparar > jugadores.length-1) {
                        System.out.println("Introduce un jugador válido.");
                    }else
                        break;
                }
                    
                    
                

                

                int aleatorioBala = random.nextInt(2);
                boolean esBalaReal = (aleatorioBala == 1);

                // Aqui comprobamos las vidas de cada jugador, pero esta vez para saber si se le
                // puede disparar o no.
                if (vidasJugadores[disparar] <= 0) {
                    System.out.println(
                            "\n ¡Este jugador ya está muerto! No puedes disparar a un cadaver. Pierdes el turno:\n");
                    // Aqui empieza el bucle de las balas de fogueo o reales
                } else if (esBalaReal) {
                    System.out.println(
                            "\n¡" + jugadorElegido + " apunta a " + jugadores[disparar] + " y aprieta el gatillo!");
                    vidasJugadores[disparar]--;
                    System.out.println("¡BANG! ¡Era una bala de verdad! A " + jugadores[disparar]
                            + " le quedan " + vidasJugadores[disparar] + " vidas.");

                    if (vidasJugadores[disparar] <= 0) {
                        System.out.println("¡" + jugadores[disparar] + " ha sido ELIMINADO de la partida!");
                    }
                } else {
                    System.out.println(
                            "\n¡" + jugadorElegido + " apunta a " + jugadores[disparar] + " y aprieta el gatillo!");
                    System.out
                            .println("¡CLICK! Era una bala de fogueo. " + jugadores[disparar] + " se salva por ahora.");
                }

                // Si pulsamos el "2" nos salta automaticamente.
            } else if (accion1 == 2) {
                System.out.println("\n[ACCIÓN] " + jugadorElegido + " decide pasar el turno.");
                /*
                 * Si introduces un caracter que no sea "1" o "2" se te salta el turno,
                 * por ahora lo dejamos asi ya que en un futuro le añadiremos control de errores
                 * para que si no pones algo valido te salga un error
                 */
            } else {
                System.out.println("\n[ERROR] Opción no válida. Pierdes el turno por dudar.");
            }

            // Esto es para los turnos, una vez disparado, se pasa a la siguiente posicion,
            // es decir que seguimos el mismo orden siempre
            turnoActual++; //
            if (turnoActual >= jugadores.length) {
                turnoActual = 0;
            }

            int jugadoresVivos = 0;
            String ultimoSuperviviente = "";

            // Esto comprueba que todos los jugadores tengan mas de 0 vidas.
            for (int i = 0; i < vidasJugadores.length; i++) {
                if (vidasJugadores[i] > 0) {
                    jugadoresVivos++;
                    ultimoSuperviviente = jugadores[i];
                }
            }

            // Si solo queda un jugador con vida, terminamos la partida
            if (jugadoresVivos <= 1) {
                // Aqui se cierra el bucle boolean y se cierra el bucle general
                partidaActiva = false;
                System.out.println("\nEnhorabuena " + ultimoSuperviviente + " has sido el ultimo jugador con vida");
            }

        }
        // Cerramos el scanner
        scanner.close();
    }
}