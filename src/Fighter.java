public class Fighter extends Dude{

    Effect weaponattack;
    Effect knockdown;

    public Fighter() {
        super();
        this.weaponattack = new WeaponAttack();
        this.knockdown = new Knockdown();
        super.abilities = new Effect[]{weaponattack, knockdown};
        super.setHealth(120);
        super.setArmor(80);
        super.setAccuracy(50);
        super.setActionPointsRefreshRate(5);
    }

    @Override
    Effect chooseEffect() {
        int choice = (int)(Math.random() * 2);
        return abilities[choice];
    }


}
