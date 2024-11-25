public class Tumbuhan extends MahklukHidup{
    
    public Tumbuhan(String name){
        super(name);
    }

    @Override
    public void growth(){
        System.out.println(name + " menghasilkan energi dan bertumbuh dengan proses Fotosintesis.");
    }

    @Override
    public void talk(){
        System.out.println(name + " ....");
    }

    public void Fotosintesis(){
        System.out.println(name + " Sedang melakukan proses Fotosintesis");
    }
}
