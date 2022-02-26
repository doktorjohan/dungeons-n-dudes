public class Wizard extends Dude{

    Effect firebolt;
    Effect spiderweb;

    public Wizard() {
        super();
        this.firebolt = new Firebolt();
        this.spiderweb = new Spiderweb();
        super.abilities = new Effect[]{firebolt, spiderweb};
        super.setHealth(80);
        super.setArmor(50);
        super.setAccuracy(70);
        super.setActionPointsRefreshRate(8);
    }

    @Override
    Effect chooseEffect() {
        int choice = (int)(Math.random() * 2);
        return abilities[choice];
    }

}
