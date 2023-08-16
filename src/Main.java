import hero.Hero;
import hero.HeroType;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            System.out.println("You're at the entrance of a dungeon. Who do you want to send in?");
            System.out.println("1. Warrior");
            System.out.println("2. Mage");
            System.out.println("3. Rogue");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = -1;
            try {
                choice = Integer.parseInt(reader.readLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice!");
                continue;
            }

            Hero hero = null;
            switch (choice) {
                case 1 -> hero = new Hero(HeroType.WARRIOR);
                case 2 -> hero = new Hero(HeroType.MAGE);
                case 3 -> hero = new Hero(HeroType.ROGUE);
                case 4 -> System.exit(0);
                default -> {
                    System.out.println("Invalid choice!");
                    continue;
                }
            }

            System.out.println("You sent in a " + hero.getClass().getSimpleName() + " with " + hero.getHP() + " HP and " + hero.getAttackPower() + " attack power.");
            break;
        }
    }
}