public class Spiderweb implements Effect {

    private final int REDUCE  = 10;
    private final int REQUIRED_POINTS = 8;
    private boolean expired = false;

    @Override
    public void onHit(Dude effectTarget) {
        effectTarget.currentlyActive.add(this);
    }

    @Override
    public void onTurnStart(Dude effectTarget) {
        effectTarget.setActionPoints(effectTarget.getActionPoints() - REDUCE);
    }

    @Override
    public void onTurnEnd(Dude effectTarget) {

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
