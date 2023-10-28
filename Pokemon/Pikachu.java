package pokemon;

public class Pikachu extends Pokemon {
    private Tipo tipo = Tipo.ELECTRICO;

    public Pikachu(String nombre, int nivel){
        super(nombre, nivel, 40, 45, 40, 35, 35, 56);
        ListaMovimientos listaMovimientos = new ListaMovimientos();

        setMovimientos(0, listaMovimientos.buscarMovimientoPorNombre("Moflete Est├ítico"));
        setMovimientos(1, listaMovimientos.buscarMovimientoPorNombre("Impactrueno"));
        setMovimientos(2, listaMovimientos.buscarMovimientoPorNombre("Chispa"));
        setMovimientos(3, listaMovimientos.buscarMovimientoPorNombre("Chispazo"));
    }
    
     @Override
    public double obtenerEfectividad(Pokemon pokemonAtacante, int m){
        double efectividad = 1.0;
        if(pokemonAtacante.getMovimientos(m).getTipo()== Tipo.ACERO) efectividad = 0.5;
        if(pokemonAtacante.getMovimientos(m).getTipo()== Tipo.AGUA) efectividad = 2.0;
        if(pokemonAtacante.getMovimientos(m).getTipo()== Tipo.BICHO) efectividad = 0.5;
        if(pokemonAtacante.getMovimientos(m).getTipo()== Tipo.TIERRA) efectividad = 0;
        if(pokemonAtacante.getMovimientos(m).getTipo()== Tipo.HADA) efectividad = 0.5;
        if(pokemonAtacante.getMovimientos(m).getTipo()== Tipo.HIELO) efectividad = 0.5;
        if(pokemonAtacante.getMovimientos(m).getTipo()== Tipo.PLANTA) efectividad = 0.5;
        if(pokemonAtacante.getMovimientos(m).getTipo()== Tipo.ROCA) efectividad = 0.5;
        if(pokemonAtacante.getMovimientos(m).getTipo()== Tipo.VOLADOR) efectividad = 2.0;

        return efectividad;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
}
