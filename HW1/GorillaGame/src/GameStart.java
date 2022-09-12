public class GameStart {
    public static int TOTAL_OF_GAME_THROW = 0;
    public final int NUM_OF_PLAYERS = 0;
    private Character role;

    GameStart(int which_character, String role_name, int position_x, int position_y) {

        switch (which_character) {
            case 1:
                role = new Mountain_Gorilla(role_name, position_x, position_y);
                break;
            case 2:
                role = new North_Gorilla(role_name, position_x, position_y);
                break;
            case 3:
                role = new Long_Arm_Gorilla(role_name, position_x, position_y);
                break;
        }
    }

    // whenever a gorilla got created, it will create a object and using static variable
    // `role` to assigned back to Main file. 
    public Character getStartedPlayer() {
        return role;
    }

}
