
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Вітаємо в грі \"Game for Aborigines\"!");

        Scanner scanner = new Scanner(System.in);

        // Створення арени та додавання спостерігачів
        Arena arena = new Arena();
        arena.addObserver(new PlayerNotifier("GameMaster"));
        arena.addObserver(new PlayerNotifier("Logger"));

        // Створення списку персонажів
        // Додаємо користувача
        System.out.print("Введіть ім'я вашого персонажа: ");
        String playerName = scanner.nextLine();

        String playerClass = "";
        while (true) {
            System.out.print("Виберіть клас вашого персонажа (warrior/mage/archer): ");
            playerClass = scanner.nextLine().toLowerCase();
            if (playerClass.equals("warrior") || playerClass.equals("mage") || playerClass.equals("archer")) {
                break;
            } else {
                System.out.println("Цей клас поки не додали!");
            }
        }

        Character player = CharacterFactory.createCharacter(playerClass, playerName);
        arena.addCharacter(player);

        // Створення комп'ютерних персонажів
        Character cpu1 = CharacterFactory.createCharacter("warrior", "Sven");
        Character cpu2 = CharacterFactory.createCharacter("mage", "Oracle");
        Character cpu3 = CharacterFactory.createCharacter("archer", "Windranger");

        arena.addCharacter(cpu1);
        arena.addCharacter(cpu2);
        arena.addCharacter(cpu3);

        // Головний цикл гри
        Random rand = new Random();
        while (!arena.isGameOver()) {
            List<Character> currentCharacters = new ArrayList<>(arena.getCharacters());

            for (Character attacker : currentCharacters) {
                if (arena.isGameOver()) {
                    break;
                }

                // Вибір цілі для атаки (випадковий вибір персонажа)
                List<Character> possibleTargets = new ArrayList<>(arena.getCharacters());
                possibleTargets.remove(attacker);

                if (possibleTargets.isEmpty()) {
                    break;
                }

                Character target = possibleTargets.get(rand.nextInt(possibleTargets.size()));
                arena.characterAttack(attacker, target);

                // Очікування 1 секунди між атаками
                try {
                    Thread.sleep(500); // 500 мілісекунд = 0.5 секунди
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Гра перервана.");
                    return;
                }
            }
        }

        // Оголошення переможця
        Character winner = arena.getWinner();
        if (winner != null) {
            System.out.println("Переможцем стає " + winner.getName() + "!");
        } else {
            System.out.println("Гра завершилася нічиєю.");
        }

        scanner.close();
    }
}
