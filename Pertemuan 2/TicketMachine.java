import java.util.Scanner;

public class TicketMachine {
    
    private int price;    
    private int balance;  
    private int income;   

    public TicketMachine() {
        this.price = 0;      
        this.balance = 0;    
        this.income = 0;     
    }

    public void insertMoney(int total) {
        if (total > 0) {
            balance += total;  
            System.out.println("                Money inserted: " + total);
        } else {
            System.out.println("Invalid amount! Please try again.");
        }
    }

    public void pricing(String ty) {
        if (ty.equalsIgnoreCase("Concert")) {
            price = 50000;
        } else if (ty.equalsIgnoreCase("Festival")) {
            price = 35000;
        } else if (ty.equalsIgnoreCase("Exhibition")) {
            price = 75000;
        } else {
            System.out.println("Unknown ticket type. Please choose a valid type.");
            return;
        }
        System.out.println("\nThe price for " + ty + " is: " + price + "\n");
    }

    public void getBalance() {
        System.out.println("\nCurrent machine income: " + income + "\n");
    }

    public void printTicket() {
        if (price == 0) {
            System.out.println("Please select a valid ticket type first.");
            return;
        }

        if (balance >= price) {
            System.out.println("########### TICKET ###########");
            System.out.println("Thank you for your purchase!");
            System.out.println("Ticket Price: " + price);
            balance -= price;
            income += price;    
            returnChange(); 
            System.out.println("###############################");   
        } else {
            System.out.println("Not enough balance to print the ticket.");
        }
    }

    private void returnChange() {
        if (balance >= 0) {
            System.out.println("Returning change: " + balance);
            balance = 0;  
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicketMachine ticketMachine = new TicketMachine();

        System.out.println("        Welcome to the Ticket Machine");
        System.out.println("Enter the amount of money you want to insert : ");
        int uang = scanner.nextInt();
        ticketMachine.insertMoney(uang);

        System.out.println("Enter ticket type (Concert, Festival, Exhibition): ");
        String tipeTiket = scanner.next();
        ticketMachine.pricing(tipeTiket);

        ticketMachine.printTicket();
        ticketMachine.getBalance();
        scanner.close();
    }
}