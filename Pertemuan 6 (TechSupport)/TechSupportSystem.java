import java.util.Scanner;
public class TechSupportSystem {
    private UserInput inputHandler;
    private ResponseGenerator replyHandler;
        
    public TechSupportSystem() {
        inputHandler = new UserInput();
        replyHandler = new ResponseGenerator(); 
    }

    public void startSystem() {
        boolean isFinished = false;
        printWelcomeMessage();
        
        while(!isFinished) {
            String userInput = inputHandler.captureInput();
            if(userInput.startsWith("selesai")) {
                isFinished = true;
            } else {
                String response = replyHandler.createResponse(userInput);
                System.out.println(response);
            }
        }

        printGoodbyeMessage();
    }
            
    private void printWelcomeMessage() {
        System.out.println("Selamat datang di Sistem Dukungan Teknis Kami.");
        System.out.println();
        System.out.println("Silakan jelaskan masalah yang Anda alami.");
        System.out.println("Kami akan membantu Anda dengan masalah apa pun.");
        System.out.println("Ketik 'selesai' untuk keluar dari sistem.");
    }
            
    private void printGoodbyeMessage() {
        System.out.println("Senang berbicara dengan Anda. Sampai jumpa...");
    }
    public static void main(String[] args) {
        TechSupportSystem supportSystem = new TechSupportSystem();
        supportSystem.startSystem();
    }
}
