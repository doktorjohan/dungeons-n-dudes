import java.util.ArrayList;
import java.util.List;

public abstract class Dude {

    private int accuracy;
    private int armor;
    private int health;
    private int actionPoints;
    private int actionPointsRefreshRate;
    List<Effect> currentlyActive;
    Effect[] abilities;

    public Dude() {
        this.currentlyActive = new ArrayList<>();
        this.setActionPoints(30);
    }

    abstract Effect chooseEffect();

    void takeTurn(Dude attackTarget) {
        if (this.getActionPoints() < 30) {
            this.setActionPoints(this.getActionPoints() + this.getActionPointsRefreshRate());
        }
        for (Effect effectStart : this.currentlyActive) {
            if (!effectStart.isExpired()) {
                effectStart.onTurnStart(this);
            }
        }

        Effect attackEffect = this.chooseEffect();
        if ((Math.random() * 20) + this.getAccuracy() >= attackTarget.getArmor()) {
            if (this.getActionPoints() >= attackEffect.requiredActionPoints()) {
                attackEffect.onHit(attackTarget);
                System.out.println("Attack hit!");
            } else {
                System.out.println("Not enough action points!");
            }
        } else {
            System.out.println("Attack miss!");
        }

        for (Effect effectEnd : this.currentlyActive) {
            if (!effectEnd.isExpired()) {
                effectEnd.onTurnEnd(this);
            }
        }
        this.currentlyActive.clear();
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
