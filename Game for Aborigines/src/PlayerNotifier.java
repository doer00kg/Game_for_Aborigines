public class PlayerNotifier implements Observer {
    private String observerName;

    public PlayerNotifier(String observerName) {
        this.observerName = observerName;
    }

    @Override
    public void update(Character newCharacter) {
        System.out.println("[" + observerName + "] Новий персонаж на арені: " + newCharacter);
    }
}
