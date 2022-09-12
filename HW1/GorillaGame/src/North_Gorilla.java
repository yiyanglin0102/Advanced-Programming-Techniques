public class North_Gorilla extends Character {
    North_Gorilla() {
        super();
    }

    North_Gorilla(String name, int position_x, int position_y) {
        super(name, position_x, position_y);
        this.setSpecialty();
    }

    public void setSpecialty() {
        this.specialty = "Iced-Bomb";
    }
}
