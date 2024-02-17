package sieteymedia;

import java.util.Scanner;
import recursos.Baraja;
import recursos.Carta;

public class SieteYMedia implements InterfaceConsola{
    Baraja baraja;
    Carta[] cartasJugador;
    Carta[] cartasBanca;
    Scanner sc = new Scanner(System.in);

    public SieteYMedia() {
        baraja = new Baraja();
        baraja.barajar();
        // se van pidiendo cartas al jugar pero matemáticamente a partir de 15 siempre
        // nos pasamos
        // hay 12 cartas de medio puntos, si sacara estas 12 luego cartas con valor 1
        // vemos que a partir de 15 cartas siempre se pasas
        cartasJugador = new Carta[15];
        cartasBanca = new Carta[15];
    }

    public static void main(String[] args) {
        SieteYMedia sm = new SieteYMedia();
        sm.presentarJuego();
        sm.jugar();
    }

    void jugar() {
        SieteYMedia sm = new SieteYMedia();
        turnoJugador(sm);
        turnoBanca(sm);
        sm.finDelJuego();
    }

    void turnoJugador(SieteYMedia sm) {
        char opc = 'C';
        // obligamos a que como mínimo se tenga 1 carta
        while (valorCartas(cartasJugador) < 7.5 && opc == 'C') {
            Carta c = baraja.darCartas(1)[0];
            // insertamos c en las cartas del jugador
            insertarCartaEnArray(cartasJugador, c);
            // mostramos cartas y su valor, si se pasa se sale del bucle
            mostrarCartasJugador(cartasJugador);
            sm.valor_Cartas(cartasJugador);
            //pedimos que teclee opcion si es posible
            opc=sm.valorCartasJugador(cartasJugador);
        }

    }

    void turnoBanca(SieteYMedia sm) {
        // lo primero es consultar el valor que alcanzó el jugador en su turno
        if(sm.seHaPasadoJugador(cartasJugador)){
            return;
        }
        // juega hasta empatar o superar
        while (valorCartas(cartasBanca) < valorCartas(cartasJugador)) {
            Carta c = baraja.darCartas(1)[0];
            insertarCartaEnArray(cartasBanca, c);
        }
        sm.mostrarCartasBanca(cartasBanca);
        sm.seHaPasadoBanca(cartasBanca);
    }

    double valorCartas(Carta[] cartas) {
        double total = 0.0;
        int val;
        int i = 0;
        while (cartas[i] != null) {
            val = cartas[i].getNumero();
            total += (val > 7) ? 0.5 : val;
            i++;
        }

        return total;
    }

    void insertarCartaEnArray(Carta[] cartas, Carta c) {
        // inserta al final detectando el primer null
        int i = 0;
        while (cartas[i] != null) {
            i++;
        }
        cartas[i] = c;

    }

}