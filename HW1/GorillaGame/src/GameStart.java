public class GameStart {
    public static int TOTAL_OF_GAME_THROW = 0;
    public static final int DEFAULT_POSITION_X = 100;
    public static final int DEFAULT_POSITION_Y = 100;
    public final int NUM_OF_PLAYERS = 0;
    private Character role;

    // if player do not have given name and position X, Y
    GameStart() {
        role = new Mountain_Gorilla("untitled_name", DEFAULT_POSITION_X, DEFAULT_POSITION_Y);
    }

    // Overlaod constructor
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
    
    // whenever a gorilla got created, it will create a object and using static
    // variable
    // `role` to assigned back to Main file.
    public Character getStartedPlayer() {
        return role;
    }
}
