public class Hewan extends MahklukHidup {
    public Hewan(String name){
        super(name);
    }

    @Override
    public void growth(){
        System.out.println(name + " berkembang mengikuti insting dan lingkungan sekitar.");
    }

    @Override
    public void talk(){
        System.out.println("Roar!, Woof!, Kawk!");
    }

    public void berburu(){
        System.out.println(name + " sedang mencari makanan.");
    }
}
