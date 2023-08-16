package hero;

import attributes.HeroAttributes;

public class Hero {
    private final HeroAttributes heroAttributes;
    private int HP;

    public Hero(HeroType heroType) {
        this.heroAttributes = HeroFactory.createHeroAttributes(heroType);
        this.HP = heroAttributes.getHP();
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getAttackPower() {
        return heroAttributes.getAttackPower();
    }
}