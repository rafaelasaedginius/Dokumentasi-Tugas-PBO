// 1. Classes, Mendefinisikan class baru bernama Creature
class Creature {
    // 3. Encapsulation, Pembungkusan rincian/ detail dari attribut atau komponen dari sebuah unit 
    private String species;  // Variabel 'species' dibungkus dengan akses private

    public Creature(String species) {
        this.species = species;
    }
    // 4. Abstraction dengan fungsi yang tidak didefinisikan secara lengkap
    public void emitSound() {
        System.out.println("Some generic sound...");
    }
}
// 5. Inheritance, mewarisi properti dan metode dari classes lain dalam kasus ini 'Creature'
class Cat extends Creature {  
    public Cat(String species) {
        super(species);
    }
    // 6. Polymorphism, berbentuk override method dari class Creature yang diwariskan
    @Override
    public void emitSound() {
        System.out.println("Meow! Meow!");
    }
    // 7. Overloading, Menggunakan fungsi dengan nama yang sama namun parameternya berbeda
    public void emitSound(String emotion) {
        if ("content".equals(emotion)) {
            System.out.println("Purr... (content)");
        } else {
            System.out.println("Hiss...");
        }
    }
}
public class Main {
    public static void main(String[] args) {

        // 2. Object creation
        Creature genericCreature = new Creature("Generic Creature");
        Cat cat = new Cat("Siamese Cat");

        // Menggunakan metode dari superclass, method inheritance, method hasil override
        genericCreature.emitSound();
        cat.emitSound();
        cat.emitSound("content");
    }
}
