public class Main {
    public static void main(String[] args) throws Exception {

        new GameStart(1);

        Chatacter mountain = new Mountain_Gorilla();
        // mountain.printINFO();
        System.out.println(mountain.getPower());
        mountain.setPower(1);
        mountain.printINFO();
        // System.out.println("Hello World!");
        // Chatacter two = new North_Gorilla("Ken", -5, 2);
    }
}
