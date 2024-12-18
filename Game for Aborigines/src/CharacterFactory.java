public class CharacterFactory {
    public static Character createCharacter(String type, String name) {
        switch (type.toLowerCase()) {
            case "warrior":
                return new Warrior(name);
            case "mage":
                return new Mage(name);
            case "archer":
                return new Archer(name);
            default:
                throw new IllegalArgumentException("Невідомий тип персонажа: " + type);
        }
    }
}
