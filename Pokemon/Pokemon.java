package pokemon;

import java.util.Random;

public abstract class Pokemon {
    private String nombre;
    private int sp;
    private int ataque;
    private int ataqueEspecial;
    private int defensa;
    private int defensaEspecial;
    private int velocidad;
    private int nivel;
    private Movimiento[] movimientos;

    public Pokemon(String nombre, int nivel, int sp, int ataque, int ataqueEspecial, int defensa, int defensaEspecial, int velocidad) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.sp = sp;
        this.ataque = ataque;
        this.ataqueEspecial = ataqueEspecial;
        this.defensa = defensa;
        this.defensaEspecial = defensaEspecial;
        this.velocidad = velocidad;
        this.movimientos = new Movimiento[4];
    }

    public String getNombre() {
        return nombre;
    }

    public int getSp() {
        return sp;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getAtaqueEspecial() {
        return ataqueEspecial;
    }

    public int getDefensa() {
        return defensa;
    }

    public int getDefensaEspecial() {
        return defensaEspecial;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public int getNivel() {
        return nivel;
    }

    public Movimiento getMovimientos(int i) {
        return movimientos[i];
    }

    public void setMovimientos(int i, Movimiento movimiento) {
        this.movimientos[i] = movimiento;
    }

    private void calculaVidaRestante(Pokemon pokemon) {
        System.out.printf("%s tiene ahora %d puntos de vida\n", pokemon.getNombre(), getSp());
    }

    private double calcularBonificacion(Movimiento movimiento, Pokemon pokemon) {
        double bonificacion = 1.0;
        return bonificacion;
    }

    private void calcularDanio(Pokemon pokemon, int danio, double efectividad) {
        double B = calcularBonificacion(movimiento, pokemon);
        double E = efectividad;
        int N = getNivel();
        int A = (movimiento.getClaseDeMovimiento() == ClaseMovimiento.FISICO) ? getAtaque() : getAtaqueEspecial();
        int P = movimiento.getPoder();
        int D = (movimiento.getClaseDeMovimiento() == ClaseMovimiento.FISICO) ? pokemon.getDefensa() : pokemon.getDefensaEspecial();

        Random rand = new Random();
        int V = rand.nextInt(16) + 85; // Valor aleatorio entre 85 y 100

        double damage = 0.01 * B * E * V * ((((0.2 * N + 1) * A * P) / (25 * D)) + 2);
        double puntosRestados = danio * damage;

        this.sp -= puntosRestados;
        System.out.printf("%s recibe %.2f puntos de daño\n", pokemon.getNombre(), puntosRestados);
        this.calculaVidaRestante(pokemon);
    }

    public void recibirAtaque(Pokemon pokemon, Movimiento movimiento, double efectividad) {
        System.out.printf("%s recibe ATK %s\n", pokemon.getNombre(), movimiento.getNombre());
        calcularDanio(pokemon, movimiento.getPoder(), efectividad);
    }

     protected boolean seHaConcretadoAtaque(Movimiento movimiento, Pokemon pokemon, Pokemon pokemon2, int m){
        System.out.printf("%s ataca a %s con %s\n", pokemon.getNombre(), this.getNombre(), movimiento.getNombre());
        double efectividad = obtenerEfectividad(pokemon2, m);
        System.out.println(efectividad);
        if(movimiento.getPp()>0){
            pokemon.recibirAtaque(pokemon2, movimiento, efectividad);
            return true;
        } else{
            System.err.println("El movimiento no tiene puntos de pp");
            return false;
        }
    }

    public void atacar(int m, Pokemon pokemon, Pokemon pokemon2) {
        Movimiento movimiento = getMovimientos(m);
        boolean seHaConcretadoAtaque = seHaConcretadoAtaque(movimiento, pokemon, pokemon2, m);
        if(seHaConcretadoAtaque){
            pokemon.getMovimientos(m).setPp(movimiento.getPp()-1);
        }
    }

    public abstract double obtenerEfectividad(Pokemon pokemon, int m);
}
