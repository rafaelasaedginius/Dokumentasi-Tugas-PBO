import java.util.Random;

public class ResponseGenerator {
    private Random random;

    public ResponseGenerator() {
        random = new Random();
    }

    public String createResponse(String input) {
        String[] pickedResponse = {
            "Itu menarik. Ceritakan lebih lanjut...",
            "Bisakah Anda memberikan detail lebih spesifik?",
            "Saya mengerti. Apa lagi yang terjadi?",
            "Hmm, saya perlu informasi tambahan untuk membantu Anda.",
            "Terima kasih telah berbagi, silakan lanjutkan."
        };

        return pickedResponse[random.nextInt(pickedResponse.length)];
    }
}
