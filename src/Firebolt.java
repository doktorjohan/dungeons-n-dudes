public class Firebolt implements Effect{

    private final int DAMAGE = 8;
    private final int REQUIRED_POINTS = 6;
    private boolean expired = false;

    @Override
    public void onHit(Dude effectTarget) {
        effectTarget.currentlyActive.add(this);
        expired = false;
    }

    @Override
    public void onTurnStart(Dude effectTarget) {

    }

    @Override
    public void onTurnEnd(Dude effectTarget) {
        effectTarget.setHealth(effectTarget.getHealth() - DAMAGE);
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
