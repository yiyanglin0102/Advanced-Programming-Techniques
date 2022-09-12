public class Main {
    public static Character role;

    public static void main(String[] args) throws Exception {

        /*
         * In this project,
         * input number 1 in GameStart means choosing Montain_Gorilla to be
         * player's role;
         * input number 2 in GameStart means choosing North_Gorilla to be
         * player's role;
         * input number 3 in GameStart means choosing Long_Arm_Gorilla to be
         * player's role;
         */

        GameStart newRole1_Montain_Gorilla = new GameStart(1, "Justin Bieber", 40, -20);
        Character role1 = newRole1_Montain_Gorilla.getStartedPlayer();
        System.out.println(role1);
        System.out.println(role1.getPosition_x());
        System.out.println(role1.getPosition_y());
        System.out.println(role1.getScore());
        System.out.println(role1.getThrewTimes());
        
        role1.setPower(100);
        System.out.println(role1.getPower());
        role1.setAngle(60);
        System.out.println(role1.getAngle());
        
        System.out.println(role1.getSpecialty());
        

        // GameStart newRole2_North_Gorilla = new GameStart(2, "Johnny Depp", 10, 50);
        // Character role2_info = newRole2_North_Gorilla.getStartedPlayer();
        // System.out.println(role2_info);

        // GameStart newRole3_Long_Arm_Gorilla = new GameStart(3, "Jennifer Lawrence", -30, 70);
        // Character role3_info = newRole3_Long_Arm_Gorilla.getStartedPlayer();
        // System.out.println(role3_info);

        // GameStart default_new_role = new GameStart();
        // System.out.println(default_new_role.getStartedPlayer());

        // String montainSpecialty = newRole1_Montain_Gorilla.getStartedPlayer().getSpecialty();
        // System.out.println(montainSpecialty);

        // String northSpecialty = newRole2_North_Gorilla.getStartedPlayer().getSpecialty();
        // System.out.println(northSpecialty);

        // String longArmSpecialty = newRole3_Long_Arm_Gorilla.getStartedPlayer().getSpecialty();
        // System.out.println(longArmSpecialty);
    }
}
