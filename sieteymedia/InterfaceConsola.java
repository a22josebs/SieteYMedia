package sieteymedia;
import recursos.Carta;
import java.util.Scanner;

interface InterfaceConsola {
    SieteYMedia miSieteYMedia = new SieteYMedia();
    Scanner sc = new Scanner(System.in);

    //mostramos las cartas del jugador y el texto oportuno
    default public void mostrarCartasJugador(Carta[] cartas){
        int i = 0;
        System.out.println("Éstas son tus cartas jugador:");
        while (cartas[i] != null) {
            System.out.print("\t" + cartas[i]);
            i++;
        }
    }

    //mostramos las cartas de la banca y el texto oportuno
    default public void mostrarCartasBanca(Carta[] cartas){
        int i = 0;
        System.out.println("Éstas son mis cartas:");
        while (cartas[i] != null) {
            System.out.print("\t" + cartas[i]);
            i++;
        }
        System.out.println("\nValor de  mis cartas(banca): " + miSieteYMedia.valorCartas(cartas));
    }

    //mostramos valor cartas (jugador o banca) y texto
    default public void valor_Cartas(Carta[] cartas){
        double d = miSieteYMedia.valorCartas(cartas);
        String s = "\n\tValor de cartas: " + d;
        System.out.println("\n\tValor de cartas: " + d);
    }


    //comprobamos cual el es valor de las cartas del jugador para permitir que siga pidiendo
    default public char valorCartasJugador(Carta[] cartas){
        char op ='p';
        if(miSieteYMedia.valorCartas(cartas)<7.5){
                System.out.println("\n¿Pides [C]arta o te [P]lantas?");
                op = sc.next().trim().toUpperCase().charAt(0);
                return op;
        }
        return op;
    }

    //comprobamos si el jugador se pasó y sacamos texto y devolvemos un booleano para control desde prog principal
    default public boolean seHaPasadoJugador(Carta[] cartas){
        boolean se_paso = false;
        if(miSieteYMedia.valorCartas(cartas)>7.5){
                se_paso = true;
                System.out.println("Jugador, te has pasado en tu jugada anterior, gana la banca");
        }else{
                System.out.println("\n\nTurno de banca ...");
        }
        
        return se_paso;
    }
    //comprobamos si se pasó la banca para seguir sacando cartas o no
    default public void seHaPasadoBanca(Carta[] cartas){
        if(miSieteYMedia.valorCartas(cartas)>7.5){
                System.out.println("me pasé, ganas tú,jugador");
        }else{
                System.out.println("Gana la banca");
        }
    }
    
    //texto de fin de juego
    default public void  finDelJuego(){
        System.out.println("Adios");
    }
    
    //texto de inicio y explicación de juego
    default public void presentarJuego() {
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
