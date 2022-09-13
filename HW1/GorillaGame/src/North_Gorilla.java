public class North_Gorilla extends Character {
    North_Gorilla() {
        // call parent's constructor
        super();
    }

    // Overloading constructors with parameters
    North_Gorilla(String name, int position_x, int position_y) {
        // call parent's overloading constructor
        super(name, position_x, position_y);
        this.setSpecialty();
    }
    // Override Character class parent method
    public void setSpecialty() {
        this.specialty = "Iced-Bomb";
    }
}
