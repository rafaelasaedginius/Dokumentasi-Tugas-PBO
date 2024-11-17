public class Tiket {
    protected double hargaDasar; 
    protected int bagasi;       
    protected String layanan;  

    public Tiket(double hargaDasar, int bagasi, String layanan) {
        this.hargaDasar = hargaDasar;
        this.bagasi = bagasi;
        this.layanan = layanan;
    }

    public double Harga() {
        return hargaDasar;
    }

    public void tampilkanDetail() {
        System.out.println("Harga Dasar: Rp" + hargaDasar);
        System.out.println("Bagasi: " + bagasi + " kg");
        System.out.println("Layanan Tambahan: " + layanan);
        System.out.println("Total Harga: Rp" + Harga());
    }

    public static void main(String[] args) {
        Tiket ekonomi = new TiketEkonomi(500000, 20, "Makanan ringan, Hiburan standar");
        System.out.println("Tiket Ekonomi:");
        ekonomi.tampilkanDetail();

        Tiket bisnis = new TiketBisnis(1000000, 30, "Prioritas check-in, Makanan premium");
        System.out.println("\nTiket Bisnis:");
        bisnis.tampilkanDetail();

        Tiket kelasSatu = new TiketKelasSatu(2000000, 40, "Akses lounge, Makanan istimewa, Kursi ekstra luas");
        System.out.println("\nTiket Kelas Satu:");
        kelasSatu.tampilkanDetail();
    }
}


