package attributes;

public class RogueAttributes implements HeroAttributes {
    @Override
    public int getHP() {
        return 75;
    }

    @Override
    public int getAttackPower() {
        return 15;
    }
}
