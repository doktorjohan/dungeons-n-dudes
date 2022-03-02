import java.util.concurrent.ThreadLocalRandom;

public class Wizard extends Dude {

    public Wizard() {
        setHealth(80);
        setArmor(50);
        setAccuracy(70);
        setActionPointsRefreshRate(8);
    }

    @Override
    Effect chooseEffect() {
        int choice = ThreadLocalRandom.current().nextInt(2);
        switch (choice) {
            case 0:
                return new Spiderweb();
            case 1:
                return new Firebolt();
            default:
                return null;
        }
    }

}
