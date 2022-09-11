public class GameStart {
    public static int TOTAL_OF_GAME_THROW = 0;
    public final int NUM_OF_PLAYERS = 0;
    private Character role;

    GameStart(int which_character) {

        switch (which_character) {
            case 1:
                role = new Mountain_Gorilla("John", 10, -10);
                break;
            case 2:
                role = new North_Gorilla("John", 10, -10);
                break;
            case 3:
                role = new Long_Arm_Gorilla("John", 10, -10);
                break;
        }

    }

    public Character getStartedPlayer() {
        return role;
    }

}
