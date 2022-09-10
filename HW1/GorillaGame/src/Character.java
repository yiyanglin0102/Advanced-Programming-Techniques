public class Character {
    public static int DEFAULT_ANGLE = 45;
    public static int DEFAULT_POWER = 30;
    public static String DEFAULT_NAME = "Player";
    public static int NUM_OF_PLAYERS;

    private String name = "";
    private int position_x = 0;
    private int position_y = 0;
    private int score = 0;
    private int power = 0;
    private int playerThrewTimes = 0;
    private int angle = 0;

    public Character() {
        this.name = DEFAULT_NAME;
        this.position_x = 0;
        this.position_y = 0;
        this.score = 0;
        this.power = DEFAULT_POWER;
        NUM_OF_PLAYERS += 1;
        this.playerThrewTimes = 0;
    }

    public Character(String name, int position_x, int position_y) {
        this.name = name;
        this.position_x = position_x;
        this.position_y = position_y;
        this.score = 0;
        this.power = DEFAULT_POWER;
        NUM_OF_PLAYERS += 1;
        this.playerThrewTimes = 0;
    }

    public void printINFO() {
        System.out.println("Player name: " + this.name);
        System.out.println("Player position_x: " + this.position_x);
        System.out.println("Player position_y: " + this.position_y);
        System.out.println("Player score: " + this.score);
        System.out.println("Player threw times: " + this.playerThrewTimes);
        System.out.println("Player power: " + this.power);
    }

    public int getPosition_x() {
        return this.position_x;
    }

    public int setPosition_x(int input_position_x) {
        this.position_x = input_position_x;
        return this.position_x;
    }

    public int getPosition_y() {
        return this.position_y;
    }

    public int setPosition_y(int input_position_y) {
        this.position_y = input_position_y;
        return this.position_y;
    }

    public int getScore() {
        return this.score;
    }

    public int getPower() {
        return this.power;
    }

    public int setPower(int input_power) {
        this.power = input_power;
        return this.power;
    }

    public int getThrewTimes() {
        return this.playerThrewTimes;
    }

    public int getAngle() {
        return this.angle;
    }

    public int setAngle(int input_angle) {
        this.angle = input_angle;
        return this.angle;
    }

}
