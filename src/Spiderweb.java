public class Spiderweb implements Effect {

    private final int REDUCE  = 10;
    private final int REQUIRED_POINTS = 8;
    private boolean expired = false;
    private int turnCounter;

    @Override
    public void onHit(Dude effectTarget) {
        turnCounter = 2;
    }

    @Override
    public void onTurnStart(Dude effectTarget) {
        int currentPoints = effectTarget.getActionPoints();
        effectTarget.setActionPoints(currentPoints - REDUCE);
    }

    @Override
    public void onTurnEnd(Dude effectTarget) {
        turnCounter--;
        if (turnCounter == 0) {expired = true;}
    }

    @Override
    public int requiredActionPoints() {
        return REQUIRED_POINTS;
    }

    @Override
    public boolean isExpired() {
        return this.expired;
    }
}
