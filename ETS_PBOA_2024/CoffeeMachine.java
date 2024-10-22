public class CoffeeMachine {
    private String merek;
    private int capacity;
    private boolean isOn;

    public CoffeeMachine(String merek, int capacity) {
        this.merek = merek;
        this.capacity = capacity;
        this.isOn = false;
    }

    public void turnOn(boolean isOn) {
        if (!isOn) {
            isOn = true;
            System.out.println(merek + " Mesin Kopi sekarang sudah menyala.");
        } else {
            System.out.println(merek + " Mesin Kopi sekarang sedang menyala.");
        }
    }

    public static void main(String[] args) {
        CoffeeMachine myCoffeeMachine = new CoffeeMachine("Nescafe", 1500);

        myCoffeeMachine.turnOn(true);
    }
}
