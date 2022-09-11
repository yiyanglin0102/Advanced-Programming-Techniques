public class Long_Arm_Gorilla extends Character {

    Long_Arm_Gorilla() {
        super();
    }

    Long_Arm_Gorilla(String name, int position_x, int position_y) {
        super(name, position_x, position_y);
        this.setSpecialty();
    }

    public void setSpecialty() {
        specialty = "Long-Distance-Bomb";
    }

}
