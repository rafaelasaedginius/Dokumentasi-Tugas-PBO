import java.util.ArrayList;
import java.io.File;

public class MusicOrganizer {
    private ArrayList<Song> importedSongs;
    private Song currentSong;

    public MusicOrganizer() {
        importedSongs = new ArrayList<Song>();
        currentSong = null;
    }

    public void startPlayingByFilename(String filename) {
        for (Song song : importedSongs) {
            if (song.getNama().equals(filename)) {
                setCurrentSong(song);
                startPlayingTrack();
                return;
            }
        }
        System.out.println("Song with filename '" + filename + "' not found.");
    }

    public void startPlayingByTitle(String title) {
        for (Song song : importedSongs) {
            if (song.getTitle().equalsIgnoreCase(title)) {
                setCurrentSong(song);
                startPlayingTrack();
                return;
            }
        }
        System.out.println("Song with title '" + title + "' not found.");
    }

    public void addSong(String filename, String title, String artist) {
        Song song = new Song(filename, title, artist);
        importedSongs.add(song);
    }

    public ArrayList<Song> importSongsFromFolder(String folderPath) {
        File folder = new File(folderPath);
        if (folder.exists() && folder.isDirectory()) {
            File[] files = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".mp3") || name.toLowerCase().endsWith(".wav"));
            if (files != null) {
                for (File file : files) {
                    String filename = file.getName();
                    String title, artist;
                    String extractedString[];
                    if (filename.contains(".mp3")) {
                        extractedString = filename.replace(".mp3", "").split("-");
                    } else {
                        extractedString = filename.replace(".wav", "").split("-");
                    }
                    artist = extractedString[0].trim();
                    title = extractedString[1].trim();
                    title = title.replace("_", " ");
                    Song addedSong = new Song(filename, title, artist);
                    importedSongs.add(addedSong);
                }
            }
            return importedSongs;
        } else {
            System.out.println("Folder does not exist or is not a directory.");
            return null;
        }
    }

    public String getCurrentSongTitle() {
        if (currentSong != null)
            return currentSong.getTitle();
        else
            return null;
    }

    public void setCurrentSong(Song song) {
        currentSong = song;
    }

    public void startPlayingTrack() {
        if (currentSong != null) {
            System.out.println("Currently playing: " + currentSong.getTitle() + " by " + currentSong.getArtist());
        } else {
            System.out.println("No track is currently selected.");
        }
    }

    public void stopPlayingTrack() {
        currentSong = null;
        System.out.println("Music has been stopped.");
    }
    
    public void listAllSongs() {
        if (importedSongs.size() == 0) {
            System.out.println("No songs in the list.");
        } else {
            for (int i = 0; i < importedSongs.size(); i++) {
                System.out.println((i + 1) + ". " + importedSongs.get(i).getTitle() + " by " + importedSongs.get(i).getArtist());
            }
        }
    }

    public Song getSongAtIndex(int index) {
        if (index >= 0 && index < importedSongs.size()) {
            return importedSongs.get(index);
        }
        return null;
    }

    public void removeSongAtIndex(int index) {
        if (index >= 0 && index < importedSongs.size()) {
            importedSongs.remove(index);
            System.out.println("Song removed successfully.");
        } else {
            System.out.println("Invalid index.");
        }
    }

    public int getIndex(String filename) {
        for (int i = 0; i < importedSongs.size(); i++) {
            if (importedSongs.get(i).getNama().equals(filename)) {
                return i;
            }
        }
        return -1;
    }

    public void removeSongFromFilename(String filename) {
        int index = getIndex(filename);
        if (index != -1) {
            removeSongAtIndex(index);
        } else {
            System.out.println("Song not found.");
        }
    }

    public void searchFileContainingKeyword(String keyword) {
        for (Song song : importedSongs) {
            if (song.getNama().toLowerCase().contains(keyword.toLowerCase())) {
                song.displayDetails();
            }
        }
    }

    public void searchTitleContainingKeyword(String keyword) {
        for (Song song : importedSongs) {
            if (song.getJudul().toLowerCase().contains(keyword.toLowerCase())) {
                song.displayTrackAndSinger();
            }
        }
    }

    public void listAllSongsByArtist(String artist) {
        for (Song song : importedSongs) {
            if (song.getArtist().equalsIgnoreCase(artist)) {
                song.displayDetails();
            }
        }
    }
}
