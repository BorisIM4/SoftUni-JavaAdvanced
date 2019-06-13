package L6_Defining_Classes_exercise.P6_Pokémon_Trainer;


class Pokemon {
    private String name;
    private String element;
    private int health;

    Pokemon(String name, String element, int health) {
        this.name = name;
        this.element = element;
        this.health = health;
    }

    String getElement() { return element; }

    boolean lossHealth() {
        this.health -= 10;
        return this.health > 0;
    }
}