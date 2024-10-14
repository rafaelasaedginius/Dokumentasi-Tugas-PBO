import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class ResponseGenerator {
    private HashMap<String, String> responseLibrary;
    private ArrayList<String> fallbackResponses;
    private HashMap<String, Integer> issueCounter;
    private Random randomSelector;

    public ResponseGenerator() {
        responseLibrary = new HashMap<>();
        fallbackResponses = new ArrayList<>();
        issueCounter = new HashMap<>();
        randomSelector = new Random();
        populateResponseLibrary();
        populateFallbackResponses();
    }

    private void populateResponseLibrary() {
        responseLibrary.put("bantuan", "Silakan ceritakan masalah Anda dengan lebih detail.");
        responseLibrary.put("error", "Silakan restart aplikasi Anda.");
        responseLibrary.put("install", "Aplikasi berhasil diinstall.");
        responseLibrary.put("lag", "Coba restart perangkat Anda untuk mengatasi lag.");
        responseLibrary.put("update", "Aplikasi sudah dalam versi terbaru.");
    }

    private void populateFallbackResponses() {
        fallbackResponses.add("Maaf, saya tidak bisa mengerti. Bisakah Anda memberi tahu lebih lanjut?");
        fallbackResponses.add("Tolong berikan lebih banyak detail tentang masalah Anda.");
        fallbackResponses.add("Bisa jelaskan lebih detail masalah Anda?");
    }

    private String selectFallbackResponse() {
        int index = randomSelector.nextInt(fallbackResponses.size());
        return fallbackResponses.get(index);
    }

    public String createResponse(String input) {
        String matchedKey = null;
        input = input.toLowerCase().trim();
        String[] words = input.split("\\s+");

        for (String word : words) {
            for (String key : responseLibrary.keySet()) {
                if (word.contains(key)) {
                    matchedKey = key;
                }
            }
        }

        if (matchedKey != null) {
            increaseIssueCounter(matchedKey);
            return responseLibrary.get(matchedKey);
        } else {
            return selectFallbackResponse();
        }
    }
    

    private void increaseIssueCounter(String issue) {
        issueCounter.put(issue, issueCounter.getOrDefault(issue, 0) + 1);
        System.out.println("Masalah '" + issue + "' telah dilaporkan sebanyak: " + issueCounter.get(issue) + " kali.");
    }
}
