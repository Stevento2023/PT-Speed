import java.util.Scanner;
import java.util.InputMismatchException;

public class BlackJack
{
    private int value;
    int a = (int)(Math.random() * 10) + 1;
    int b = (int)(Math.random() * 10) + 1;

    public BlackJack() {
        value = 0;
        value = a + b;
    }
    
    private void draw() {
        int newCard = (int)(Math.random() * 10) + 1;
        System.out.println("Your value is " + newCard + value);
        value += newCard;
    }
    
    public void turn(){
        String[] turn;
        Scanner scanner = new Scanner(System.in);
        boolean shouldContinue = true;
        
        while (true) {
            System.out.println("Your hand is " + a + "&" + b);
            System.out.println("prepare to draw");
            try {
                draw();
                if (value == 21) {
                    System.out.println("BlackJack you win!");
                    shouldContinue = false;
                } else if (value > 21) {
                    System.out.println("you busted! :(");
                    shouldContinue = false;
                } else {
                    System.out.println("Your hand is too low, let's draw again");
                    turn();
                }
            } catch (InputMismatchException error) {
                scanner.next();
                System.out.println("please 'draw' or 'stand'");
            }
        }
    }
    
    public static void main(String[] args)
    {
        BlackJack hw = new BlackJack();
        hw.turn();
    }
}