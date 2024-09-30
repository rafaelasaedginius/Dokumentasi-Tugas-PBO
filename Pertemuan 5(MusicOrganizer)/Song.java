public class Song {  
  private String nama;  
  private String judul;  
  private String singer;  

  public Song(String nama, String judul, String singer) {  
      this.nama = nama;  
      this.judul = judul;  
      this.singer = singer;  
  }  

  public String getNama() {  
      return nama;  
  }  

  public String getJudul() {  
      return judul;  
  }  

  public String getSinger() {  
      return singer;  
  }
  public String getTitle() {
      return judul;
  }
  public String getArtist() {
      return singer;
  }  

  public void displayDetails() {  
      System.out.println("File: " + nama + " - Judul: " + judul + " by " + singer);  
  }  

  public void displayTrackAndSinger() {  
      System.out.println("Judul: " + judul + " by " + singer);  
  }  

  public void updateNama(String nama) {  
      this.nama = nama;  
  }  

  public void updateJudul(String newJudul) {  
      this.judul = newJudul;  
  }  

  public void updateSinger(String newSinger) {  
      this.singer = newSinger;  
  }  
}
