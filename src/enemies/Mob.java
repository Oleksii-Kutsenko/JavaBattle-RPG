package enemies;

public class Mob {
    public String name;
    public int HP;
    public int attackPower;

    private final int baseHP;
    private final int baseAttackPower;


    public Mob(String name, int baseHP, int baseAttackPower) {
        this.name = name;
        this.baseHP = baseHP;
        this.baseAttackPower = baseAttackPower;
        this.HP = generateRandomHP();
        this.attackPower = generateRandomAttackPower();
    }

    public int generateRandomHP() {
        int minHP = (int) (baseHP - baseHP * 0.1);
        int maxHP = (int) (baseHP + baseHP * 0.1);
        return minHP + (int) (Math.random() * (maxHP - minHP + 1));
    }

    public int generateRandomAttackPower() {
        int minAttackPower = (int) (baseAttackPower - baseAttackPower * 0.1);
        int maxAttackPower = (int) (baseAttackPower + baseAttackPower * 0.1);
        return minAttackPower + (int) (Math.random() * (maxAttackPower - minAttackPower + 1));
    }

    public String getName() {
        return name;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getAttackPower() {
        return attackPower;
    }
}

