package hero;

import attributes.HeroAttributes;
import attributes.MageAttributes;
import attributes.RogueAttributes;
import attributes.WarriorAttributes;

public class HeroFactory {
    public static HeroAttributes createHeroAttributes(HeroType heroType) {
        return switch (heroType) {
            case MAGE -> new MageAttributes();
            case WARRIOR -> new WarriorAttributes();
            case ROGUE -> new RogueAttributes();
            default -> throw new IllegalArgumentException("Unknown hero type: " + heroType);
        };
    }
}
