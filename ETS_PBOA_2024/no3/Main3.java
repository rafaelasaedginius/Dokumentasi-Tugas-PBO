public class Main3 {
    public static void main(String[] args) {
        ContohEncap mahasiswa = new ContohEncap();

        mahasiswa.setNamamu("Rafael Asa");
        mahasiswa.setNilaimu(100);
        mahasiswa.setMatkul("PBO");

        System.out.println("Nama Mahasiswa: " + mahasiswa.getNamaSekarang());
        System.out.println("Mata Kuliah: " + mahasiswa.getMatkul());
        System.out.println("Nilai: " + mahasiswa.getNilaimu());
    }
}
