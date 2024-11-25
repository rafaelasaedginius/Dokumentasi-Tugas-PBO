public class Manusia extends MahklukHidup{
    public Manusia(String name){
        super(name);
    }

    @Override
    public void growth(){
        System.out.println(name + " bertumbuh dan berkembang melalui berbagai proses");
    }

    @Override
    public void talk(){
        System.out.println("Perkenalkan nama saya " + name);
    }
}
