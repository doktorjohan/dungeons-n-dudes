import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Dude {

    private int accuracy;
    private int armor;
    private int health;
    private int actionPoints;
    private int actionPointsRefreshRate;
    List<Effect> currentlyActive;

    public Dude() {
        this.currentlyActive = new ArrayList<>();
        this.setActionPoints(30);
    }

    abstract Effect chooseEffect();

    void takeTurn(Dude attackTarget) {
        int currentActionPoints = this.getActionPoints();
        if (currentActionPoints < 30) {
            this.setActionPoints(currentActionPoints + this.getActionPointsRefreshRate());
        }

        this.currentlyActive.stream().filter(effect -> !effect.isExpired()).forEach(effect -> effect.onTurnStart(this));

        // iga käik ründab kolme efektiga
        for (int i = 0; i < 3; i++) {

            Effect attackEffect = this.chooseEffect();
            if (ThreadLocalRandom.current().nextInt(1, 21) + this.getAccuracy() >= attackTarget.getArmor()) {
                if (this.getActionPoints() >= attackEffect.requiredActionPoints()) {
                    attackTarget.currentlyActive.add(attackEffect);
                    attackEffect.onHit(attackTarget);
                    System.out.println("Attack hit!");
                } else {
                    System.out.println("Not enough action points!");
                }
            } else {
                System.out.println("Attack miss!");
            }
        }

        this.currentlyActive.stream().filter(effect -> !effect.isExpired()).forEach(effect -> effect.onTurnEnd(this));

        this.currentlyActive.removeIf(Effect::isExpired);
        }


    boolean isAlive() {
        return health > 0;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public int getArmor() {
        return armor;
    }

    public int getHealth() {
        return health;
    }

    public int getActionPoints() {
        return actionPoints;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setActionPoints(int actionPoints) {
        this.actionPoints = actionPoints;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getActionPointsRefreshRate() {
        return actionPointsRefreshRate;
    }

    public void setActionPointsRefreshRate(int actionPointsRefreshRate) {
        this.actionPointsRefreshRate = actionPointsRefreshRate;
    }
}
