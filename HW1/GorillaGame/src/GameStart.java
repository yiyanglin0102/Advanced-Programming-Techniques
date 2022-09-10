public class GameStart {
    public static int TOTAL_OF_GAME_THROW = 0;
    public final int NUM_OF_PLAYERS = 0;

    GameStart(int which_character) {

        switch (which_character) {
            case 1:
                new Mountain_Gorilla();
                break;
            case 2:
                new North_Gorilla();
                break;
            case 3:
                new Long_Arm_Gorilla();
                break;
        }
    }

    public GameStart() {
        this.selectPlayer();
    }

    public void selectPlayer() {

    }

}
