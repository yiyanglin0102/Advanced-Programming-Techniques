public class Long_Arm_Gorilla extends Character {

    Long_Arm_Gorilla() {
        // call parent's constructor
        super();
    }

    // Overloading constructors with parameters
    Long_Arm_Gorilla(String name, int position_x, int position_y) {
        // call parent's overloading constructor
        super(name, position_x, position_y);
        this.setSpecialty();
    }

    // Override Character class parant method
    public void setSpecialty() {
        this.specialty = "Long-Distance-Bomb";
    }

}
