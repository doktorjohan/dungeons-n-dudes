import java.util.concurrent.ThreadLocalRandom;

public class Fighter extends Dude {

    public Fighter() {
        setHealth(120);
        setArmor(80);
        setAccuracy(50);
        setActionPointsRefreshRate(5);
    }

    @Override
    Effect chooseEffect() {
        int choice = ThreadLocalRandom.current().nextInt(2);
        switch (choice) {
            case 0:
                return new WeaponAttack();
            case 1:
                return new Knockdown();
            default:
                return null;
        }
    }


}
