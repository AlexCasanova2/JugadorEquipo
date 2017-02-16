package jugador_equipo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import tools.Fichero;
import tools.InputData;


public class Jugador_Equipo {

//    private static Lista_jugadores misJugadores;
    private static Lista_equipos misEquipos;
    
    private static Fichero FicheroJugadores;
    
    
    public static void main(String[] args) {
        
        FicheroJugadores = new Fichero("basket.xml");
        misEquipos = (Lista_equipos) FicheroJugadores.leer();
        if(misEquipos==null){
            misEquipos = new Lista_equipos();
        }
        
        int opcion;
        do{
            mostrarMenu();
            opcion = InputData.pedirEntero("Escoge una opcion");
            switch (opcion){
                case 1 : 
                    crearEquipo();
                    break;
                case 2 :
                    crearJugador();
                    break;
                case 3 :
                    do{
                       menuJugadores();
                       opcion = InputData.pedirEntero("Escoge una opcion");
                       switch (opcion){
                           case 1 :
                               buscarJN();
                               break;
                           case 2 :
                               buscarJC();
                               break;
                           case 3 :
                               buscarJA();
                               break;
                           case 4 :
                               buscarJP();
                               break;
                           case 5 :
//                               buscarJNacimiento();
                               break;
                           case 6 :
                               agruparJP();
                           case 7 :
                               agruparJP2();
                               break;
                       }
                    } while (opcion != 8);
                    break;
                case 4 :
                    do{
                       menuEquipos();
                       opcion = InputData.pedirEntero("Escoge una opcion");
                       switch (opcion){
                           case 1 :
                               buscarEL();
                               break;
                           case 2 :
                               buscarJNE();
                               break;
                           case 3 :
                               buscarJMaxCE();
                               break;
                           case 4 :
                               buscarJP();
                               break;
                       }
                    } while (opcion != 5);
                    break;
            }
        } while (opcion !=5);
    }
    
    
    public static void menuEquipos(){
        System.out.println("MENU EQUIPOS");
        System.out.println("1. Buscar Equipos por localidad");
        System.out.println("2 .Buscar Jugadores a partir de nombre del Equipo");
        System.out.println("3. Todos los jugadores de un equipo por posicion");
        System.out.println("4. Jugador con mas canastas de un Equipo");
        System.out.println("5. Volver");
    }
    
    public static void buscarJMaxCE(){
        String nombre = InputData.pedirCadena("Nombre del equipo");
        Jugador max = new Jugador();
        int maxC = 0;
        for(Equipo equipo : misEquipos.getLista_equipos()){
            for(Jugador jugador : equipo.getJugadores().getLista_jugadores()){
                if(jugador.getCanastas()>maxC){
                    maxC = jugador.getCanastas();
                    max= jugador;
                }
            }
            System.out.println(max);
        }
    }
    
    public static void buscarJNE(){
        String nombre = InputData.pedirCadena("Nombre del jugador");
        for(Equipo equipo : misEquipos.getLista_equipos()){
            if(equipo.getNombre().equalsIgnoreCase(nombre)){
                for(Jugador jugador : equipo.getJugadores().getLista_jugadores()){
                    System.out.println(jugador);
                }
            }
        }
    }
    
    public static void buscarEL(){
        String localidad = InputData.pedirCadena("Localida por la que buscar");
        for(Equipo equipo : misEquipos.getLista_equipos()){
            if(equipo.getLocalidad().equalsIgnoreCase(localidad)){
                System.out.println(equipo);
            }else{
                System.out.println("La localidad indicada no existe");
                break;
            }
        }
    }
    
    
    public static void menuJugadores(){
        System.out.println("MENU JUGADORES");
        System.out.println("1. Buscar Jugadores por nombre");
        System.out.println("2. Buscar Jugadores por canastas");
        System.out.println("3. Buscar Jugadores por asistencias");
        System.out.println("4. Buscar Jugadores por posicion");
        System.out.println("5. Buscar Jugadores por fecha de nacimiento");
        System.out.println("6. Agrupar Jugadores por posicion");
        System.out.println("7. Agrupar Jugadores por posicion con media");
        System.out.println("8. Volver");
    
    }
    
    public static void agruparJP2(){
        
    }
    
    public static void agruparJP(){
        
    }
    
//    public static void buscarJNacimiento(){
//            int dia = InputData.pedirEntero("Dia de nacimineto: ");
//            int mes = InputData.pedirEntero("Mes de nacimineto: ");
//            int año = InputData.pedirEntero("Año de nacimineto: ");
//            
//            
//        for (Equipo equipo : misEquipos.getLista_equipos()) {
//            for (Jugador jugador : equipo.getJugadores().getLista_jugadores()) {
//                String nombreE = equipo.getNombre();
//                String fecha = jugador.getDia() + "/" + jugador.getMes() + "/" + jugador.getAño();
//                String fechaIntroducida = dia + "/" + mes + "/" + año;
//
//                SimpleDateFormat formato = new SimpleDateFormat("dd/mm/yyyy");
//                Date fecha2 = null;
//                Date fechaIntroducida2 = null;
//                fecha2 = formato.parse(fecha);
//                fechaIntroducida2 = formato.parse(fechaIntroducida);
//                if (fecha2.before(fechaIntroducida2)) {
//                    System.out.println("Nombre del equipo :" + nombreE);
//                    System.out.println("Nombre del jugador : " + jugador.getNombre());
//                    System.out.println("Fecha de nacimiento :" + fecha2);
//                } else {
//                    System.out.println("No hay ningun jugador con una fecha anterior a la que has introducido");
//                }
//            }
//        }
//            
//            
//    }
    
    
    public static void buscarJP(){
        String pos = InputData.pedirCadena("Posicion que deseas buscar");
         for(Equipo equipo : misEquipos.getLista_equipos()){
            for(Jugador jugador : equipo.getJugadores().getLista_jugadores()){
                String nombreE = equipo.getNombre();
                String fecha = jugador.getDia() + "/" + jugador.getMes() + "/" + jugador.getAño(); 
                if(jugador.getPosicion().equals(pos)){
                    System.out.println("Nombre del equipo: " + nombreE);
                    System.out.println("Nombre del jugador: " + jugador.getNombre());
                    System.out.println("Fecha de nacimineto: " + fecha);
                    System.out.println("Posición en Equipo: " + jugador.getPosicion());
                    System.out.println("Canastas totales: " + jugador.getCanastas());
                }else{
                    System.out.println("Esta posició no existe");
                }
            }
        }
    }
    
    public static void buscarJA(){
        int asistenciasMax = InputData.pedirEntero("Numero de canastass máximo");
        int asistenciasMin = InputData.pedirEntero("Numero de canastass mínimo");
        for(Equipo equipo : misEquipos.getLista_equipos()){
            for(Jugador jugador : equipo.getJugadores().getLista_jugadores()){
                String nombreE = equipo.getNombre();
                String fecha = jugador.getDia() + "/" + jugador.getMes() + "/" + jugador.getAño(); 
                if(jugador.getAsistencias() >= asistenciasMin && jugador.getCanastas() <= asistenciasMax){
                    System.out.println("Nombre del equipo: " + nombreE);
                    System.out.println("Nombre del jugador: " + jugador.getNombre());
                    System.out.println("Fecha de nacimineto: " + fecha);
                    System.out.println("Posición en Equipo: " + jugador.getPosicion());
                    System.out.println("Canastas totales: " + jugador.getCanastas());
                }else{
                    
                }
            }
        }
    }
    
    public static void buscarJC(){
        int numC = InputData.pedirEntero("Numero de canastas");
        for(Equipo equipo : misEquipos.getLista_equipos()){
            for(Jugador jugador : equipo.getJugadores().getLista_jugadores()){
                String nombreE = equipo.getNombre();
                String fecha = jugador.getDia() + "/" + jugador.getMes() + "/" + jugador.getAño(); 
                if(jugador.getCanastas() >= numC){
                    System.out.println("Nombre del equipo: " + nombreE);
                    System.out.println("Nombre del jugador: " + jugador.getNombre());
                    System.out.println("Fecha de nacimineto: " + fecha);
                    System.out.println("Posición en Equipo: " + jugador.getPosicion());
                    System.out.println("Canastas totales: " + jugador.getCanastas());
                }else{
                    System.out.println("Este jugador no existe");
                }
            }
        }
    }
    
    public static void buscarJN(){
        String nombre= InputData.pedirCadena("¿Que jugador quieres buscar?");
        for(Equipo equipo : misEquipos.getLista_equipos()){
            for(Jugador jugador : equipo.getJugadores().getLista_jugadores()){
                String nombre1 = equipo.getNombre();
                
                if(nombre1.indexOf(nombre) > -1){
                System.out.println("Nombre del equipo: " + nombre1);
                System.out.println("Nombre del Jugador: " + jugador.getNombre());
                
                String fecha = jugador.getDia() + "/" + jugador.getMes() + "/" + jugador.getAño();
                
                     System.out.println("Fecha de nacimiento: " + fecha);
                     System.out.println("Posición en Equipo: " + jugador.getPosicion());
                     System.out.println("Canastas totales: " + jugador.getCanastas());
                     System.out.println("Asistencias totales: " + jugador.getAsistencias());
                     System.out.println("Rebotes totales: " + jugador.getRebotes());
                     break;
                }else{
                     System.out.println("Este jugador no existe");
                 }
            }
        }        
    }
    
    public static void crearJugador(){
        String EquipJ = InputData.pedirCadena("¿A que equipo pertenece?");
        Equipo a = misEquipos.encontrarEquipo(EquipJ);
        if(a!=null){
            String nombre = InputData.pedirCadena("Nombre del Jugador: ");
            int dia = InputData.pedirEntero("Dia de nacimineto: ");
            int mes = InputData.pedirEntero("Mes de nacimineto: ");
            int año = InputData.pedirEntero("Año de nacimineto: ");
            int canastas = InputData.pedirEntero("Canastas: ");
            int asistencias = InputData.pedirEntero("Asistencias: ");
            int rebotes = InputData.pedirEntero("Rebotes: ");
            String posicion = InputData.pedirCadena("Posicion: ");
            
            Jugador jugador = new Jugador(1, nombre, dia, mes, año, canastas, asistencias, rebotes, posicion);
//            a.getJugadores().(jugador);
            FicheroJugadores.grabar(misEquipos);
            
        } else {
            System.out.println("El equipo no existe.");
        }
    }
    
    
    public static void crearEquipo(){
        int id= 1;
        String nombre = InputData.pedirCadena("Nombre del equipo: ");
        String localidad = InputData.pedirCadena("Localidad: ");
        int dia =0;
        int mes=0;
        int año=0;
        dia = InputData.pedirEntero("Dia de creación:");
        mes = InputData.pedirEntero("Mes de creación:");
        año = InputData.pedirEntero("Año de creación:");

       
        while (dia == 0) {
            dia = InputData.pedirEntero("Dia del equipo: ");
        }

        while (mes == 0) {
            mes = InputData.pedirEntero("Mes del equipo: ");
        }

        while (año == 0) {
            año = InputData.pedirEntero("Año del equipo: ");
        }
        
         Equipo equipo = new Equipo (id, nombre, localidad, dia, mes, año);
         misEquipos.regisEquipo(equipo);
         FicheroJugadores.grabar(misEquipos);
       
        
    }
    
    public static void mostrarMenu(){
        System.out.println("MENU");
        System.out.println("1. Crear Equipo");
        System.out.println("2. Crear Jugador");
        System.out.println("3. Menu consulta Jugadores");
        System.out.println("4. Menu consulta Equipos");
        System.out.println("5. Salir");
    }
    
}
