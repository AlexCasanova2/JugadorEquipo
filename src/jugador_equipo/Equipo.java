package jugador_equipo;

import java.util.ArrayList;
import java.util.List;

public class Equipo {
    
    private int id;
    private String nombre;
    private String localidad;
    private int dia;
    private int mes;
    private int año;
    
//    private List<Jugador> jugadores;
    private Lista_jugadores jugadores;

    public Equipo() {
    }

    public Equipo(int id, String nombre, String localidad, int dia, int mes, int año) {
        this.id = id;
        this.nombre = nombre;
        this.localidad = localidad;
        this.dia = dia;
        this.mes = mes;
        this.año = año;
        jugadores = new Lista_jugadores();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public Lista_jugadores getJugadores() {
        return jugadores;
    }

    public void setJugadores(Lista_jugadores jugadores) {
        this.jugadores = jugadores;
    }
    
    

    
    
    
    
    
 
}
