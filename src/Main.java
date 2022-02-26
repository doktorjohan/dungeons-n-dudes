public class Main {
    public static void main(String[] args) throws InterruptedException {
        Dude fighter = new Fighter();
        Dude wizard = new Wizard();

        System.out.println(fighter.getHealth());
        System.out.println(wizard.getHealth());

        while (fighter.isAlive() && wizard.isAlive()) {
            System.out.println("The wizard attacks...");
            fighter.takeTurn(wizard);
            System.out.println("Wizard health: " + wizard.getHealth());
            System.out.println("Wizard AP: " + wizard.getActionPoints());
            Thread.sleep(1000);
            System.out.println("The fighter makes his turn...");
            wizard.takeTurn(fighter);
            System.out.println("Fighter health: " + fighter.getHealth());
            System.out.println("Fighter AP: " + fighter.getActionPoints());
            Thread.sleep(1000);
        }
        if (fighter.isAlive()) {
            System.out.println("Fighter won the battle!");
        } else {
            System.out.println("The mystic wizard reigns again!");
        }

    }
}
