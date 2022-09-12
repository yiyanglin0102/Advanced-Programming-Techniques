public class Main {
    public static Character role;

    public static void main(String[] args) throws Exception {
        GameStart newRole1_Montain_Gorilla = new GameStart(1);
        newRole1_Montain_Gorilla.getStartedPlayer().printINFO();

        GameStart newRole2_North_Gorilla = new GameStart(2);
        newRole2_North_Gorilla.getStartedPlayer().printINFO();

        GameStart newRole3_Long_Arm_Gorilla = new GameStart(3);
        newRole3_Long_Arm_Gorilla.getStartedPlayer().printINFO();

        String montainSpecialty = newRole1_Montain_Gorilla.getStartedPlayer().getSpecialty();
        System.out.println(montainSpecialty);

        String northSpecialty = newRole2_North_Gorilla.getStartedPlayer().getSpecialty();
        System.out.println(northSpecialty);

        String longArmSpecialty = newRole3_Long_Arm_Gorilla.getStartedPlayer().getSpecialty();
        System.out.println(longArmSpecialty);
    }
}
