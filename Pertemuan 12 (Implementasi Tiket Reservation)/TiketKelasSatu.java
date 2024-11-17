public class TiketKelasSatu extends Tiket {
    public TiketKelasSatu(double hargaDasar, int bagasi, String layanan) {
        super(hargaDasar, bagasi, layanan);
    }

    @Override
    public double Harga() {
        return hargaDasar * 1.5;
    }
}
