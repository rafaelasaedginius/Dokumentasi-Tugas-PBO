public abstract class MahklukHidup {
    
    protected String name;

    public MahklukHidup(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void growth();
    public abstract void talk();

    public static void main(String[] args) {
        Manusia manusia = new Manusia("Tamam");
        Hewan hewan = new Hewan("Harimau");
        Tumbuhan tumbuhan = new Tumbuhan("Bunga matahari");
        
        System.out.println("---Manusia---\n");
        manusia.getName();
        manusia.growth();
        manusia.talk();
    
        System.out.println("\n---Tumbuhan---\n");
        tumbuhan.getName();
        tumbuhan.growth();
        tumbuhan.talk();
        tumbuhan.Fotosintesis();

        System.out.println("\n---Hewan---\n");
        hewan.getName();
        hewan.growth();
        hewan.talk();
        hewan.berburu();

        System.out.println("\nAkhir dari klasifikasi -Mahkluk Hidup- .");
    }
}