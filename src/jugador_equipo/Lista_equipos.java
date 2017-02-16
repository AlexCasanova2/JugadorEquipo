
package jugador_equipo;

import java.util.ArrayList;


public class Lista_equipos {
    
    private ArrayList<Equipo> lista_equipos;
    
    
    public Lista_equipos(){
        lista_equipos = new ArrayList<>();
    }

    public ArrayList<Equipo> getLista_equipos() {
        return lista_equipos;
    }

    public void setLista_equipos(ArrayList<Equipo> lista_equipos) {
        this.lista_equipos = lista_equipos;
    }
    
    public void regisEquipo(Equipo e){
        lista_equipos.add(e);
    }
    
      public Equipo encontrarEquipo(String nombre){
        for(Equipo equipo: lista_equipos){
            if(equipo.getNombre().equalsIgnoreCase(nombre)){
                return equipo;
            }
        }
        return null;
    }
    
}
