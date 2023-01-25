import java.util.Scanner;
import java.util.InputMismatchException;

public class BlackJack
{
    int value;
    private int oppValue = (int)(Math.random() * 21) + 1;
    private int option;

    public BlackJack() {
        
    }

    private int dealer() {
        if (oppValue <= 15) {
            oppValue = 17;
        }
        return oppValue;
    }
    
    public int newHand() {
        value = 0;
        int a = (int)(Math.random() * 10) + 1;
        int b = (int)(Math.random() * 10) + 1;
        value = a + b;
        System.out.println("Your hand is " + a + " & " + b);
        return value;
    }
    
    public int draw() {
        int newCard = (int)(Math.random() * 10) + 1;

        System.out.println("you new card is " + newCard);
        value = value + newCard;
        return value;
    }

    public void turn(){
        Scanner scanner = new Scanner(System.in);
        boolean shouldContinue = true;
        newHand();

        while (true) {
            System.out.println("Your value is " + value);
            try {
                System.out.println("Enter 1 to draw or 2 to stand?");
                option = scanner.nextInt();
                if (option == 1) {
                    draw();
                } else if (option == 2) {
                    System.out.println("lets see how you did");
                    System.out.println("the dealer is at " + oppValue);
                    System.out.println("your value is at " + value);
                    check();
                } else {
                    System.out.println("Press 1 or 2");
                }
            } catch (InputMismatchException error) {
                scanner.next();
                System.out.println("plese enter 1 or 2");
            }
        }
    }
    
    public void check() {
        if (value > 21) {
            System.out.println("you busted! Too bad you lose :(");
            } else if (value == 21 && value != oppValue) {
                System.out.println("BlackJack you win!");
            } else if (value < oppValue) {
                System.out.println("Your hand is too low, you lose");
            } else if (value == oppValue) {
                System.out.println("Too bad you lose :(");
            } else if (value > oppValue) {
                System.out.println("You win!!!");
            }
        System.out.println(" ");
    }

    public static void main(String[] args) {
        BlackJack hw = new BlackJack();
        hw.turn();
    }
}