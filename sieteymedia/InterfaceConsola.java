package sieteymedia;
import recursos.Carta;
import java.util.Scanner;;

public class InterfaceConsola{



    public static void main(String[] args) {
        
        InterfaceConsola ic =  new InterfaceConsola();
        SieteYMedia sm = new SieteYMedia();

        ic.presentarJuego();

        ic.turnoJugador(sm);
        ic.turnoBanca(sm);


    }

    void turnoJugador(SieteYMedia sm) {
        char opc = 'C';
        Scanner sc = new Scanner(System.in);
        // obligamos a que como mínimo se tenga 1 carta
        System.out.println("Como mínimo recibes una carta, luego puedes decidir si seguir o plantarte");
        while (sm.valorCartas(sm.getCartasJugador()) < 7.5 && opc == 'C') {
            Carta c = sm.getBaraja().darCartas(1)[0];
            // insertamos c en las cartas del jugador
            sm.insertarCartaEnArray(sm.getCartasJugador(), c);
            // mostramos cartas y su valor, si se pasa se sale del bucle
            System.out.println("Éstas son tus cartas jugador:");
            sm.mostrarCartas(sm.getCartasJugador());
            double valor = sm.valorCartas(sm.getCartasJugador());
            System.out.println("\n\tValor de cartas: " + valor);
            if (valor < 7.5) {
                // suponemos que el usuario teclea bien !!!
                System.out.println("\n¿Pides [C]arta o te [P]lantas?");
                opc = sc.next().trim().toUpperCase().charAt(0);
            }

        }

    }

    void turnoBanca(SieteYMedia sm) {
        // lo primero es consultar el valor que alcanzó el jugador en su turno
        double valorCartasJugador = sm.valorCartas(sm.getCartasJugador());
        if (valorCartasJugador > 7.5) {
            System.out.println("Jugador, te has pasado en tu jugada anterior, gana la banca");
            return;
        }
        System.out.println("\n\nTurno de banca ...");

        // juega hasta empatar o superar
        while (sm.valorCartas(sm.getCartasBanca()) < valorCartasJugador) {
            Carta c = sm.getBaraja().darCartas(1)[0];
            sm.insertarCartaEnArray(sm.getCartasBanca(), c);
        }
        System.out.println("Éstas son mis cartas:");
        sm.mostrarCartas(sm.getCartasBanca());
        System.out.println("\nValor de  mis cartas(banca): " + sm.valorCartas(sm.getCartasBanca()));
        if (sm.valorCartas(sm.getCartasBanca()) > 7.5) {
            System.out.println("me pasé, ganas tú,jugador");
        } else {
            System.out.println("Gana la banca");
        }
    }


    void presentarJuego() {
        System.out.println("- El usuario es el jugador y el ordenador la  banca.");
        System.out.println("- No hay en la baraja 8s y 9s. El 10 es la sota, el 11 el caballo y el 12 el Rey.");
        System.out.println("- las figuras (10-sota, 11-caballo y 12-rey) valen medio punto y, el resto, su valor.");
        System.out.println(
                "- Hay dos turnos de juego: el turno del jugador y el turno de la banca. Se comienza por el turno del jugador.");
        System.out.println("- El jugador va pidiendo cartas a la banca de una en una.");
        System.out.println("- El jugador puede plantarse en cualquier momento.");
        System.out.print("- Si la suma de los valores de las cartas sacadas es superior ");
        System.out.println("a 7 y medio, el jugador 'se pasa de siete y medio' y  pierde.");
        System.out.println(
                "- Si el jugador no se pasa, comienza a sacar cartas la banca y ésta  está obligada a sacar cartas hasta empatar o superar al jugador.");
        System.out.println(
                "- Si la banca consigue empatar o superar la puntuación del jugador 'sin pasarse de siete y medio', gana la banca.");
        System.out.println(
                "- La banca no se puede plantar y tiene que empatar o superar la puntuación del  jugador sin pasarse.");
        System.out.println(
                "- En este proceso puede ocurrir que la banca 'se pase' y entonces pierde la banca y gana el jugador.");
        System.out.println("\nEmpecemos!!!\n");
    }




}