public class TiketBisnis extends Tiket {
    public TiketBisnis(double hargaDasar, int bagasi, String layanan) {
        super(hargaDasar, bagasi, layanan);
    }

    @Override
    public double Harga() {
        return hargaDasar * 1.25;
    }
}