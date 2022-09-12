public class Character {
    public static Character role;
    public static final int DEFAULT_ANGLE = 45;
    public static final int DEFAULT_POWER = 30;
    public static String DEFAULT_NAME = "Player";
    public static int NUM_OF_PLAYERS;

    private String name = "";
    private int position_x = 0;
    private int position_y = 0;
    private int score = 0;
    private int power = 0;
    private int playerThrowTimes = 0;
    private int angle = 0;

    // specialty should be overridden for each specific gorilla
    protected String specialty;

    public Character() {
        this.name = DEFAULT_NAME;
        this.position_x = 0;
        this.position_y = 0;
        this.score = 0;
        this.power = DEFAULT_POWER;
        NUM_OF_PLAYERS += 1;
        this.playerThrowTimes = 0;
    }

    public Character(String name, int position_x, int position_y) {
        this.name = name;
        this.position_x = position_x;
        this.position_y = position_y;
        this.score = 0;
        this.power = DEFAULT_POWER;
        NUM_OF_PLAYERS += 1;
        this.playerThrowTimes = 0;
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
        return this.playerThrowTimes;
    }

    public void playerThrows() {
        this.playerThrowTimes += 1;
    }

    public int getAngle() {
        return this.angle;
    }

    public int setAngle(int input_angle) {
        this.angle = input_angle;
        return this.angle;
    }

    public String getSpecialty() {
        return specialty;
    }
    // be overriden for each character
    public void setSpecialty() {
        specialty = "Default-Bomb";
    }

    // override the default toString with mem address
    public String toString() {
        String res = "";
        res += "Player name: " + this.name + "\n";
        res += "Player position_x: " + this.position_x + "\n";
        res += "Player position_y: " + this.position_y + "\n";
        res += "Player score: " + this.score + "\n";
        res += "Player threw times: " + this.playerThrowTimes + "\n";
        res += "Player power: " + this.power + "\n";
        res += "Player throw angle: " + this.angle + "\n";
        res += "Player specialty: " + this.specialty + "\n";
        res += "Number of Players: " + NUM_OF_PLAYERS + "\n";
        return res;
    }
}
