package enemies;

public class MobGenerator {
    private static final String[] mobNames = {"Goblin", "Orc", "Skeleton", "Wolf", "Spider"};

    public static Mob generateRandomMob() {
        String randomName = getRandomMobName();
        int baseHP = 0;
        int baseAttack = 0;

        switch (randomName) {
            case "Goblin" -> {
                baseHP = 10;
                baseAttack = 10;
            }
            case "Orc" -> {
                baseHP = 20;
                baseAttack = 15;
            }
            case "Skeleton" -> {
                baseHP = 15;
                baseAttack = 20;
            }
            case "Wolf" -> {
                baseHP = 10;
                baseAttack = 25;
            }
            case "Spider" -> {
                baseHP = 5;
                baseAttack = 30;
            }
        }

        return new Mob(randomName, baseHP, baseAttack);
    }


    private static String getRandomMobName() {
        return mobNames[(int) (Math.random() * mobNames.length)];
    }

}
