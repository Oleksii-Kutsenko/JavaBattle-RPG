import enemies.Mob;
import enemies.MobGenerator;
import hero.Hero;
import hero.HeroType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Hero hero = selectHero();

        while (hero.getHP() > 0) {
            Mob mob = MobGenerator.generateRandomMob();
            System.out.println("A " + mob.getName() + " appeared!");
            System.out.println("It has " + mob.getHP() + " HP and " + mob.getAttackPower() + " attack power.");

            int choice = getChoice("What do you want to do?\n1. Attack\n2. Run", 2);

            while (true) {
                if (choice == 1) {
                    performAttack(hero, mob);

                    if (mob.getHP() <= 0) {
                        System.out.println("You killed the " + mob.getName() + "!");
                        break;
                    }

                    performMobAttack(hero, mob);

                    if (hero.getHP() <= 0) {
                        System.out.println("You died!");
                        System.exit(0);
                    }
                } else if (choice == 2) {
                    System.out.println("You ran away!");
                    break;
                }
            }
        }
    }

    private static Hero selectHero() throws IOException {
        Hero hero = null;
        System.out.println("You're at the entrance of a dungeon. Who do you want to send in?");
        System.out.println("1. Warrior\n2. Mage\n3. Rogue\n4. Exit");
        int choice = getChoice("Enter your choice:", 4);

        switch (choice) {
            case 1 -> hero = new Hero(HeroType.WARRIOR);
            case 2 -> hero = new Hero(HeroType.MAGE);
            case 3 -> hero = new Hero(HeroType.ROGUE);
            case 4 -> System.exit(0);
        }

        assert hero != null;
        System.out.println("You sent in a " + hero.getClass().getSimpleName() + " with " + hero.getHP() + " HP and " + hero.getAttackPower() + " attack power.");

        return hero;
    }

    private static int getChoice(String message, int maxChoice) throws IOException {
        int choice;
        while (true) {
            System.out.println(message);
            System.out.print("Enter your choice: ");
            try {
                choice = Integer.parseInt(reader.readLine());
                if (choice >= 1 && choice <= maxChoice) {
                    break;
                } else {
                    System.out.println("Invalid choice!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice!");
            }
        }
        return choice;
    }

    private static void performAttack(Hero hero, Mob mob) {
        mob.setHP(mob.getHP() - hero.getAttackPower());
        System.out.println("You attacked the " + mob.getName() + " for " + hero.getAttackPower() + " damage.");
    }

    private static void performMobAttack(Hero hero, Mob mob) {
        hero.setHP(hero.getHP() - mob.getAttackPower());
        System.out.println("The " + mob.getName() + " attacked you for " + mob.getAttackPower() + " damage.");
        System.out.println("You have " + hero.getHP() + " HP left.");
    }
}
