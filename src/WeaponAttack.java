public class WeaponAttack implements Effect{

    private final int DAMAGE = 8;
    private final int REQUIRED_POINTS = 6;

    @Override
    public void onHit(Dude effectTarget) {
        int currentHealth = effectTarget.getHealth();
        effectTarget.setHealth(currentHealth - DAMAGE);
    }

    @Override
    public void onTurnStart(Dude effectTarget) {

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
        return true;
    }
}
