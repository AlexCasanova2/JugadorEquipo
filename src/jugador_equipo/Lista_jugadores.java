
package jugador_equipo;

import java.io.Serializable;
import java.util.ArrayList;


public class Lista_jugadores implements Serializable {
    
    private ArrayList<Jugador> lista_jugadores;
    
    
    public Lista_jugadores() {
        lista_jugadores = new ArrayList<>();
    }

    public ArrayList<Jugador> getLista_jugadores() {
        return lista_jugadores;
    }

    public void setLista_jugadores(ArrayList<Jugador> lista_jugadores) {
        this.lista_jugadores = lista_jugadores;
    }
    
    
    
    public Jugador encontrarJugador(String nombre) {
        for(Jugador jugador : lista_jugadores) {
            if (jugador.getNombre().equals(nombre)) {
                return jugador;
            }
        }
      return null;
    }
    
}
