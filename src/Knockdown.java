public class Knockdown implements Effect{

    boolean isActive = false;
    private final int REQUIRED_POINTS = 7;
    private int previousPoints;
    private boolean expired = false;

    @Override
    public void onHit(Dude effectTarget) {
        previousPoints = effectTarget.getActionPoints();
        effectTarget.setActionPoints(0);
        effectTarget.currentlyActive.add(this);
        expired = false;
    }

    @Override
    public void onTurnStart(Dude effectTarget) {

    }

    @Override
    public void onTurnEnd(Dude effectTarget) {
        effectTarget.setActionPoints(previousPoints);
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
