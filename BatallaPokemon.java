import pokemon.Pokemon;
import pokemon.Pikachu;
import pokemon.Bulbasaur;

public class BatallaPokemon {
    public static void main(String args[]){
        Pokemon pikachu = new Pikachu("Pikachu", 1);
        Pokemon bulbasaur = new Bulbasaur("Bulbasaur", 1);

        pidgey.atacar(0, bulbasaur, pikachu);
        System.out.println("\n");
        charmander.atacar(2, pikachu, bulbasaur);
    }
}
