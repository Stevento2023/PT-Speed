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
        if (oppValue < 17) {
            oppValue = 17;
        }
        return oppValue;
    }
    
    public int newHand() {
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
        System.out.println(" ");
        newHand();

        while (true) {
            System.out.println("Your value is " + value);
            try {
                System.out.println("Enter 1 to draw or 2 to stand?");
                option = scanner.nextInt();
                if (option == 1) {
                    draw();
                    if (value > 21) {
                        System.out.println("you busted! Too bad you lose :(");
                        System.out.println(" ");
                        System.out.println("Prepare to restart");
                        turn();
                    }
                    if (value == 21 && value != oppValue) {
                        System.out.println("BlackJack you win!");
                    }
                } else if (option == 2) {
                    System.out.println("lets see how you did");
                    dealer();
                    System.out.println("the dealer is at " + oppValue);
                    System.out.println("your value is at " + value);
                    check();
                    System.out.println(" ");
                    newHand();
                } else {
                    System.out.println("please press 1 or 2");
                    System.out.println("Since you didn't listen the first time, you're getting a new hand");
                    turn();
                }
            } catch (InputMismatchException error) {
                scanner.next();
                System.out.println("please press 1 or 2");
                System.out.println("Since you didn't listen the first time, you're getting a new hand");
                turn();
            }
        }
    }
    
    public void check() {
        if (value < oppValue) {
                System.out.println("Your hand is too low, you lose");
            } else if (value == oppValue) {
                System.out.println("Too bad you lose :(");
            } else if (value > oppValue) {
                System.out.println("You win!!!");
            }
    }

    public static void main(String[] args) {
        BlackJack hw = new BlackJack();
        hw.turn();
    }
}