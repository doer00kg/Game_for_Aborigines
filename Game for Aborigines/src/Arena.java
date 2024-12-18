import java.util.ArrayList;
import java.util.List;

/**
 * Клас, який представляє арену гри, де відбуваються бої між персонажами.
 * Клас використовує патерн Спостерігач (Observer) для оповіщення спостерігачів про події на арені.
 */
public class Arena {

    /**
     * Список всіх персонажів, які знаходяться на арені.
     */
    private List<Character> characters = new ArrayList<>();

    /**
     * Список спостерігачів, які підписані на події арени.
     */
    private List<Observer> observers = new ArrayList<>();

    /**
     * Додає спостерігача до списку спостерігачів арени.
     *
     * @param obs Об'єкт, який реалізує інтерфейс {@link Observer}.
     */
    public void addObserver(Observer obs) {
        observers.add(obs);
    }

    /**
     * Додає персонажа до арени та повідомляє спостерігачів про це.
     *
     * @param character Персонаж, який додається до арени.
     */
    public void addCharacter(Character character) {
        characters.add(character);
        notifyObservers(character);
    }

    /**
     * Переміщує персонажа на задані координати.
     *
     * @param character Персонаж, який буде переміщений.
     * @param dx        Зміщення по осі X.
     * @param dy        Зміщення по осі Y.
     */
    public void moveCharacter(Character character, int dx, int dy) {
        character.move(dx, dy);
    }

    /**
     * Виконує атаку одного персонажа на іншого та обробляє наслідки атаки.
     *
     * @param attacker Персонаж, який атакує.
     * @param target   Персонаж, який є ціллю атаки.
     */
    public void characterAttack(Character attacker, Character target) {
        attacker.attack(target);
        if (target.getHealth() <= 0) {
            System.out.println("Персонаж " + target.getName() + " помер від руки " + attacker.getName() + ".");
            characters.remove(target);
        }
    }

    /**
     * Повідомляє всіх спостерігачів про нового персонажа на арені.
     *
     * @param newCharacter Новий персонаж, який був доданий до арени.
     */
    private void notifyObservers(Character newCharacter) {
        for (Observer obs : observers) {
            obs.update(newCharacter);
        }
    }

    /**
     * Отримати список усіх персонажів на арені.
     *
     * @return Список персонажів, які знаходяться на арені.
     */
    public List<Character> getCharacters() {
        return characters;
    }

    /**
     * Перевіряє, чи закінчилася гра (залишився лише один або жоден персонаж).
     *
     * @return {@code true}, якщо гра закінчилася; інакше {@code false}.
     */
    public boolean isGameOver() {
        return characters.size() <= 1;
    }

    /**
     * Отримати переможця гри (остання залишився персонаж).
     *
     * @return Персонаж-переможець або {@code null}, якщо немає переможця.
     */
    public Character getWinner() {
        if (characters.size() == 1) {
            return characters.get(0);
        }
        return null;
    }
}
