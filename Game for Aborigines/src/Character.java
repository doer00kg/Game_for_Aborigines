/**
 * Абстрактний клас, який представляє загальні характеристики персонажа гри.
 * Цей клас слугує базовим для конкретних типів персонажів, таких як Воїн, Маг та Лучник.
 */
public abstract class Character {

    /**
     * Ім'я персонажа.
     */
    protected String name;

    /**
     * Кількість здоров'я персонажа.
     */
    protected int health;

    /**
     * Сила атаки персонажа.
     */
    protected int attackPower;

    /**
     * Позиція персонажа по осі X на арені.
     */
    protected int x;

    /**
     * Позиція персонажа по осі Y на арені.
     */
    protected int y;

    /**
     * Конструктор для створення нового персонажа.
     *
     * @param name        Ім'я персонажа.
     * @param health      Початкова кількість здоров'я персонажа.
     * @param attackPower Сила атаки персонажа.
     */
    public Character(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
        this.x = 0;
        this.y = 0;
    }

    /**
     * Отримати ім'я персонажа.
     *
     * @return Ім'я персонажа.
     */
    public String getName() {
        return name;
    }

    /**
     * Отримати поточну кількість здоров'я персонажа.
     *
     * @return Кількість здоров'я.
     */
    public int getHealth() {
        return health;
    }

    /**
     * Отримати силу атаки персонажа.
     *
     * @return Сила атаки.
     */
    public int getAttackPower() {
        return attackPower;
    }

    /**
     * Отримати поточну позицію по осі X.
     *
     * @return Координата X.
     */
    public int getX() {
        return x;
    }

    /**
     * Отримати поточну позицію по осі Y.
     *
     * @return Координата Y.
     */
    public int getY() {
        return y;
    }

    /**
     * Перемістити персонажа на задані координати.
     *
     * @param dx Зміщення по осі X.
     * @param dy Зміщення по осі Y.
     */
    public void move(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    /**
     * Атакувати іншого персонажа, зменшуючи його здоров'я.
     *
     * @param other Персонаж, якого атакують.
     */
    public void attack(Character other) {
        other.health -= this.attackPower;
        System.out.println(this.name + " атакує " + other.getName() + " і завдає " + this.attackPower + " пошкоджень.");
    }

    /**
     * Повертає рядкове представлення персонажа, включаючи його ім'я, здоров'я, силу атаки та позицію.
     *
     * @return Рядок з інформацією про персонажа.
     */
    @Override
    public String toString() {
        return name + " [HP: " + health + ", AP: " + attackPower + ", Pos: (" + x + "," + y + ")]";
    }
}
