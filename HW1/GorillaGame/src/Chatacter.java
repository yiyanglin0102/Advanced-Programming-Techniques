public class Chatacter {
    
    public static int TOTAL_OF_GAME_THROW = 0;
    private String name = "";
    private int angle = 0;
    private int power = 0;
    private int threwTimes = 0;
    private int position_x = 0;
    private int position_y = 0;
    private int score = 0;

    public Chatacter()
    {
        System.out.println(name);
    }

    public Chatacter(String name, int position_x, int position_y)
    {
        this.name = name;
        this.position_x = position_x;
        this.position_y = position_y;
        this.score = 0;
        this.threwTimes = 0;
        this.power = 0;
    }

    public void print()
    {
        System.out.println("Player name: " + this.name);
        System.out.println("Player position_x: " + this.position_x);
        System.out.println("Player position_y: " + this.position_y);
        System.out.println("Player score: " + this.score);
        System.out.println("Player threw times: " + this.threwTimes);
        System.out.println("Player power: " + this.power);
    }

    public int getPosition_x()
    {
        return this.position_x;
    }
    
    public int getPosition_y()
    {
        return this.position_y;
    }

    public int getScore()
    {
        return this.score;
    }

    public int getPower()
    {
        return this.power;
    }

    public int getThrewTimes()
    {
        return this.threwTimes;
    }

    public int angle()
    {
        return this.angle;
    }

}
