package hero;

import attributes.HeroAttributes;

public class Hero {
    private final HeroAttributes heroAttributes;

    public Hero(HeroType heroType) {
        this.heroAttributes = HeroFactory.createHeroAttributes(heroType);
    }

    public int getHP() {
        return heroAttributes.getHP();
    }

    public int getAttackPower() {
        return heroAttributes.getAttackPower();
    }
}