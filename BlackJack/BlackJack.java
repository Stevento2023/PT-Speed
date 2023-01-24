import java.util.Scanner;
import java.util.InputMismatchException;

public class BlackJack
{
    private int value;
    String option;
    int a = (int)(Math.random() * 10) + 1;
    int b = (int)(Math.random() * 10) + 1;

    public BlackJack() {
        value = 0;
        value = a + b;
    }

    public int draw() {
        int newCard = (int)(Math.random() * 10) + 1;

        System.out.println("you new card is " + newCard);
        System.out.println("Your old value is "+ value);
        value = value + newCard;
        System.out.println("So now your value is " + value);
        return value;
    }

    public void turn(){
        Scanner scanner = new Scanner(System.in);
        boolean shouldContinue = true;

        while (true) {
            System.out.println("Your hand is " + a + " & " + b);
            try {
                System.out.println("Your hand is " + value);
                System.out.println("Would you like to draw or stand?");
                option = scanner.next();
                if (option == "draw") {
                    draw();
                } else {
                    System.out.println("lets see how you did");
                }
            } catch (InputMismatchException error) {
                scanner.next();
                System.out.println("please 'draw' or 'stand'");
            }
            
            if (value > 21) {
                    System.out.println("you busted! Too bad you lose :(");
                    shouldContinue = false;
                } else if (value == 21) {
                    System.out.println("BlackJack you win!");
                    shouldContinue = false;
                } else if (value < 21) {
                    System.out.println("Your hand is too low, you lose");
                    shouldContinue = false;
                }
        }
    }

    public static void main(String[] args)
    {
        BlackJack hw = new BlackJack();
        hw.turn();
    }
}