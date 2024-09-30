import java.util.Scanner;
import java.util.ArrayList;

public class UI {

    public static void main(String args[]) {
        MusicOrganizer myMusic = new MusicOrganizer();
        Scanner input = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("========== Pengelola Musik ==========");
            System.out.println("1. Impor lagu dari folder");
            System.out.println("2. Tambah lagu");
            System.out.println("3. Daftar semua lagu");
            System.out.println("4. Putar lagu berdasarkan nama file");
            System.out.println("5. Putar lagu berdasarkan judul");
            System.out.println("6. Berhenti memutar lagu");
            System.out.println("7. Lihat judul lagu yang sedang diputar");
            System.out.println("8. Lihat lagu di indeks tertentu");
            System.out.println("9. Hapus lagu di indeks tertentu");
            System.out.println("10. Hapus lagu berdasarkan nama file");
            System.out.println("11. Cari indeks lagu berdasarkan nama file");
            System.out.println("12. Cari file yang mengandung kata kunci");
            System.out.println("13. Cari judul lagu yang mengandung kata kunci");
            System.out.println("14. Daftar semua lagu berdasarkan artis");
            System.out.println("15. Keluar");
            System.out.println("======================================");
            System.out.print("Masukkan pilihan Anda: ");

            if (!input.hasNextInt()) {
                System.out.println("Input tidak valid. Masukkan angka.");
                input.next();
                continue;
            }

            choice = input.nextInt();
            input.nextLine(); 
            System.out.println("");

            switch (choice) {
                case 1:
                    System.out.print("Masukkan path folder: ");
                    String folderName = input.nextLine();
                    ArrayList<Song> songs = myMusic.importSongsFromFolder(folderName);
                    if (songs != null && songs.size() > 0) {
                        System.out.println(songs.size() + " lagu berhasil diimpor.");
                    } else {
                        System.out.println("Tidak ada lagu yang ditemukan di folder.");
                    }
                    break;

                case 2:
                    System.out.println("Silakan ubah nama file menjadi format [Artis-Judul.mp3] atau [Artis-Judul.wav].");
                    System.out.print("Masukkan nama file: ");
                    String filename = input.nextLine();
                    if (!filename.endsWith(".mp3") && !filename.endsWith(".wav")) {
                        System.out.println("Format file tidak valid. Hanya .mp3 dan .wav yang didukung.");
                        break;
                    }
                    String[] extractedString;
                    if (filename.endsWith(".mp3")) {
                        extractedString = filename.replace(".mp3", "").split("-");
                    } else {
                        extractedString = filename.replace(".wav", "").split("-");
                    }
                    if (extractedString.length != 2) {
                        System.out.println("Format nama file tidak valid. Pastikan formatnya [Artis-Judul].");
                        break;
                    }
                    String artist = extractedString[0].trim();
                    String title = extractedString[1].trim().replace("_", " ");
                    myMusic.addSong(filename, title, artist); 
                    System.out.println("Lagu ditambahkan: " + title + " oleh " + artist);
                    break;

                case 3:
                    myMusic.listAllSongs();
                    break;

                case 4:
                    System.out.print("Masukkan nama file: ");
                    filename = input.nextLine();
                    myMusic.startPlayingByFilename(filename);
                    break;

                case 5:
                    System.out.print("Masukkan judul: ");
                    title = input.nextLine();
                    myMusic.startPlayingByTitle(title);
                    break;

                case 6:
                    myMusic.stopPlayingTrack();
                    break;

                case 7:
                    String currentSongTitle = myMusic.getCurrentSongTitle();
                    if (currentSongTitle != null) {
                        System.out.println("Lagu yang sedang diputar: " + currentSongTitle);
                    } else {
                        System.out.println("Tidak ada lagu yang sedang diputar.");
                    }
                    break;

                case 8:
                    System.out.print("Masukkan indeks (dimulai dari nol): ");
                    if (!input.hasNextInt()) {
                        System.out.println("Input tidak valid. Masukkan angka.");
                        input.next();
                        break;
                    }
                    int index = input.nextInt();
                    input.nextLine();
                    myMusic.getSongAtIndex(index);
                    break;

                case 9:
                    System.out.print("Masukkan indeks (dimulai dari nol): ");
                    if (!input.hasNextInt()) {
                        System.out.println("Input tidak valid. Masukkan angka.");
                        input.next();
                        break;
                    }
                    index = input.nextInt();
                    input.nextLine();
                    myMusic.removeSongAtIndex(index);
                    break;

                case 10:
                    System.out.print("Masukkan nama file: ");
                    filename = input.nextLine();
                    myMusic.removeSongFromFilename(filename);
                    break;

                case 11:
                    System.out.print("Masukkan nama file: ");
                    filename = input.nextLine();
                    index = myMusic.getIndex(filename);
                    if (index != -1) {
                        System.out.println("Indeks dari " + filename + " adalah " + index);
                    } else {
                        System.out.println("Lagu tidak ditemukan.");
                    }
                    break;

                case 12:
                    System.out.print("Masukkan kata kunci untuk mencari di nama file: ");
                    String keyword = input.nextLine();
                    myMusic.searchFileContainingKeyword(keyword);
                    break;

                case 13:
                    System.out.print("Masukkan kata kunci untuk mencari di judul lagu: ");
                    keyword = input.nextLine();
                    myMusic.searchTitleContainingKeyword(keyword);
                    break;

                case 14:
                    System.out.print("Masukkan nama artis: ");
                    artist = input.nextLine();
                    myMusic.listAllSongsByArtist(artist);
                    break;

                case 15:
                    input.close();
                    System.out.println("Keluar dari program. Terima kasih!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih opsi yang tersedia.");
                    break;
            }
            System.out.println("");

        } while (choice != 15);
    }
}