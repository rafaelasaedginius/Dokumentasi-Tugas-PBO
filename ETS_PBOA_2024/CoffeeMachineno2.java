public class CoffeeMachineno2 {
    private String merek;
    private int capacity;
    private boolean isOn;

    public CoffeeMachineno2(String merek, int capacity) {
        this.merek = merek;
        this.capacity = capacity;
        this.isOn = false;
    }

    public void turnOn() {
        if (!isOn) {
            isOn = true;
            System.out.println(merek + " Mesin Kopi sekarang sudah menyala.");
        } else {
            System.out.println(merek + " Mesin Kopi sekarang sedang menyala.");
        }
    }

    public void PesanCoffee(String type) {
        if (isOn && capacity >= 200) {
            int price = 0;
            switch (type.toLowerCase()) {
                case "espresso":
                    price = 15000;
                    System.out.println("Membuat Espresso... Harga: Rp " + price);
                    break;
                case "latte":
                    price = 20000;
                    System.out.println("Membuat Latte... Harga: Rp " + price);
                    break;
                case "cappuccino":
                    price = 18000;
                    System.out.println("Membuat Cappuccino... Harga: Rp " + price);
                    break;
                default:
                    System.out.println("Jenis kopi tidak tersedia.");
                    return;
            }
            capacity -= 200;
            System.out.println("Kopi Anda siap! Kapasitas air tersisa: " + capacity + "ml.");
        } else if(capacity < 200){
            System.out.println("Air habis, refill air terlebih dahulu");
        }
            else {
            System.out.println("Nyalakan mesin kopi terlebih dahulu.");
        }
    }

    public static void main(String[] args) {
        CoffeeMachineno2 myCoffeeMachine = new CoffeeMachineno2("Nescafe", 1500);

        myCoffeeMachine.turnOn();
        myCoffeeMachine.PesanCoffee("Latte");
        myCoffeeMachine.PesanCoffee("Espresso");
        myCoffeeMachine.PesanCoffee("Cappuccino");
        myCoffeeMachine.PesanCoffee("Latte");
        myCoffeeMachine.PesanCoffee("Latte");
        myCoffeeMachine.PesanCoffee("Latte");
        myCoffeeMachine.PesanCoffee("Latte");
        myCoffeeMachine.PesanCoffee("Latte");
    }
}