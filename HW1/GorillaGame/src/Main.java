public class Main {
    public static Character role;

    public static void main(String[] args) throws Exception {
        GameStart newRoleMontainGorilla = new GameStart(1);
        String montainSpecialty = newRoleMontainGorilla.getStartedPlayer().getSpecialty();
        System.out.println(montainSpecialty);
        newRoleMontainGorilla.getStartedPlayer().printINFO();
    }
}
