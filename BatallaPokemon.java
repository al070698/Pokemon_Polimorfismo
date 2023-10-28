package pokemon;

public class BatallaPokemon {
    public static void main(String[] args) {
        Pokemon pikachu = new Pikachu("Pikachu", 1);
        Pokemon bulbasaur = new Bulbasaur("Bulbasaur", 1);

        pikachu.atacar(0, bulbasaur, pikachu);
        System.out.println("\n");
        bulbasaur.atacar(2, pikachu, bulbasaur);
    }
}
