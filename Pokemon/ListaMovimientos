package pokemon;
import java.util.ArrayList;

public class ListaMovimientos {
    private ArrayList<Movimiento> movimientos = new ArrayList<>();

    public ListaMovimientos(){
        movimientos.add(new Movimiento("Moflete Estatico", 20, 20,Tipo.ELECTRICO, ClaseMovimiento.FÍSICO));
        movimientos.add(new Movimiento("Impactrueno", 0, 15, Tipo.ELECTRICO, ClaseMovimiento.ESPECIAL));
        movimientos.add(new Movimiento("Chispa", 65, 20, Tipo.ELECTRICO, ClaseMovimiento.FÍSICO));
        movimientos.add(new Movimiento("Chispazo", 80, 15, Tipo.ELECTRICO, ClaseMovimiento.ESPECIAL));

        movimientos.add(new Movimiento("Látigo Cepa", 45, 25, Tipo.PLANTA, ClaseMovimiento.FÍSICO));
        movimientos.add(new Movimiento("Hoja Afilada", 55, 25, Tipo.PLANTA, ClaseMovimiento.FÍSICO));
        movimientos.add(new Movimiento("Bomba Germen", 80, 15, Tipo.PLANTA, ClaseMovimiento.FÍSICO));
        movimientos.add(new Movimiento("Bomba Lodo", 90, 10, Tipo.VENENO, ClaseMovimiento.ESPECIAL));
    }

    public Movimiento buscarMovimientoPorNombre(String nombre){
        for(Movimiento movimiento : movimientos){
            if(movimiento.getNombre().equals(nombre)){
                return movimiento;
            }
        }
        return null;
    }
}
