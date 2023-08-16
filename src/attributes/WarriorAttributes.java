package attributes;

public class WarriorAttributes implements HeroAttributes {
    @Override
    public int getHP() {
        return 100;
    }

    @Override
    public int getAttackPower() {
        return 10;
    }
}
