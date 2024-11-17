public class TiketEkonomi extends Tiket {
    public TiketEkonomi(double hargaDasar, int bagasi, String layanan) {
        super(hargaDasar, bagasi, layanan);
    }

    @Override
    public double Harga() {
        return hargaDasar * 0.9;
    }
}
