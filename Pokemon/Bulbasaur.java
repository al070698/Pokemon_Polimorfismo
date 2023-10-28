package pokemon;

public class Bulbasaur extends Pokemon {
    private Tipo tipo1 = Tipo.PLANTA;
    private Tipo tipo2 = Tipo.VENENO;

    public Bulbasaur(String nombre, int nivel){
        super(nombre, nivel, 39, 52, 43, 60, 50, 65);
        ListaMovimientos listaMovimientos = new ListaMovimientos();

        setMovimientos(0, listaMovimientos.buscarMovimientoPorNombre("Látigo Cepa"));
        setMovimientos(1, listaMovimientos.buscarMovimientoPorNombre("Hoja Afilada"));
        setMovimientos(2, listaMovimientos.buscarMovimientoPorNombre("Bomba Germen"));
        setMovimientos(3, listaMovimientos.buscarMovimientoPorNombre("Bomba Lodo"));
    }
    
    @Override
    public double obtenerEfectividad(Pokemon pokemonAtacante, int m){
        double efectividad = 1.0;
        if(pokemonAtacante.getMovimientos(m).getTipo()== Tipo.BICHO) efectividad = 0.5;
        if(pokemonAtacante.getMovimientos(m).getTipo()== Tipo.ELECTRICO) efectividad = 1.0;
        if(pokemonAtacante.getMovimientos(m).getTipo()== Tipo.FANTASMA) efectividad = 0.5;
        if(pokemonAtacante.getMovimientos(m).getTipo()== Tipo.HIELO) efectividad = 0.5;
        if(pokemonAtacante.getMovimientos(m).getTipo()== Tipo.PLANTA) efectividad = 0.5;
        if(pokemonAtacante.getMovimientos(m).getTipo()== Tipo.ROCA) efectividad = 2.0;
        if(pokemonAtacante.getMovimientos(m).getTipo()== Tipo.TIERRA) efectividad = 2.0;

        return efectividad;
    }

    @Override
    public double calcularBonificacion(Pokemon pokemon, int pos) {
        double bonificacion = 1.0;
        Movimiento movimiento = this.getMovimientos(pos);
        Tipo tipoMovimiento = movimiento.getTipo();
        if (this.getTipo1() == tipoMovimiento || this.getTipo2() == tipoMovimiento) {
            bonificacion = 1.5;
        } else {
            bonificacion = 1.0;
        }

        return bonificacion;
    }

    public Tipo getTipo1() {
        return tipo1;
    }

    public void setTipo1(Tipo tipo1) {
        this.tipo1 = tipo1;
    }

    public Tipo getTipo2() {
        return tipo2;
    }

    public void setTipo2(Tipo tipo2) {
        this.tipo2 = tipo2;
    }
}

