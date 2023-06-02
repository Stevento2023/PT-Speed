import java.util.Scanner;
import java.util.InputMismatchException;

public class BlackJack
{
    int value;
    int A;
    int B;
    int C;
    private int oppValue;
    private int option;
    private int choice;

    public void BlackJack() {
        if (A + B == 21) {
            System.out.println("You got a BlackJack");
            System.out.println("You should probably enter 2");
        }
        if (value == 21) {
            System.out.println("You got 21");
            System.out.println("You should probably enter 2");
        }
    }

    public int dealer() {
        oppValue = (int)(Math.random() * 25) + 1;
        if (oppValue == 22) {
            oppValue = 15;
        } else if (oppValue < 17) {
            oppValue = 17;
        }
        return oppValue;
    }
    
    private void newHand() {
        int a = (int)(Math.random() * 13) + 1;
        int b = (int)(Math.random() * 13) + 1;
        if (a == 11 || a == 12 || a == 13) {
            a = 10;
        }
        if (b == 11 || b == 12 || b == 13) {
            b = 10;
        }
        A = a;
        B = b;
    }
    
    private int draw() {
        int newCard = (int)(Math.random() * 13) + 1;
        if (newCard == 11 || newCard == 12 || newCard == 13) {
            newCard = 10;
        }
        if (newCard == 1) {
            System.out.println("your new card is A");
        } else {
            System.out.println("your new card is " + newCard);
        }
        C = newCard;
        cAce();
        value = value + C;
        return value;
    }
    
    public int ace() {
        Scanner cool = new Scanner(System.in);
        if (value > 21 && C == 11) {
            cAce();
        } else if (A == 1 || (value > 21 && A == 11)) {
            System.out.println("you can either choose to make the value of A as 1 or 11");
            System.out.println("press 3 to keep as '1', or 4 to change to '11'");
            choice = cool.nextInt();
            if (choice == 3) {
                A = 1;
            } else if (choice == 4) {
                A = 11;
            } else {
                System.out.println("Since you didn't listen the first time, you're getting a new hand");
                turn();
                return A;
            }
        } else  if (B == 1 || (value > 21 && B == 11)){
            System.out.println("you can either choose to make the value of A as 1 or 11");
            System.out.println("press 3 to keep as '1', or 4 to change to '11'");
            choice = cool.nextInt();
            if (choice == 3) {
                B = 1;
            } else if (choice == 4) {
                B = 11;
            } else {
                System.out.println("Since you didn't listen the first time, you're getting a new hand");
                turn();
                return B;
            }
        }
        return value;
    }

    private int cAce() {
        Scanner diffCard = new Scanner(System.in);
        if ((C == 1) || (value > 21 && C == 11)) {
            System.out.println("you can either choose to keep A as 1 the value to be 11");
            System.out.println("press 3 to keep as '1', or 4 to change to '11'");
            choice = diffCard.nextInt();
            if (choice == 3) {
                C = 1;
            } else if (choice == 4) {
                C = 11;
            } else {
                System.out.println("Since you didn't listen the first time, you're getting a new hand");
                turn();
            }
        }
        return C;
    }

    private void check() {
        System.out.println("lets see how you did");
        dealer();
        System.out.println("the dealer is at " + oppValue);
        System.out.println("your value is at " + value);
        if (value < oppValue) {
            System.out.println("Your hand is too low, you lose :(");
        } else if (value == oppValue) {
            System.out.println("a draw!");
        } else if (value > oppValue) {
            System.out.println("You win!!!");
        } else if (value == 21 && value != oppValue){
            System.out.println("BlackJack you win!!!");
        }
        System.out.println("Prepare to restart");
    }

    private void move() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            BlackJack();
            System.out.println("Your value is " + value);
            try {
                System.out.println("Enter 1 to draw or 2 to stand?");
                option = scanner.nextInt();
                if (option == 1) {
                    draw();
                    if (value > 21) {
                        if (A == 11 || B == 11 || C == 11) {
                            System.out.println("Your value is " + value);
                            System.out.println("Are you sure you want to keep your Ace as 11?");
                            ace();
                            if (A == 1 || B == 1 || C == 1) {
                                value = value - 11 + 1;
                            }
                            move();
                        } else {
                            System.out.println("You BUSTED! Too bad you lose :(");
                            System.out.println(" ");
                            System.out.println("Prepare to restart");
                            turn();
                        }
                    }
                } else if (option == 2) {
                    check();
                    System.out.println(" ");
                    turn();
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
    
    private void cards() {
        if (A == 1 && B == 1) {
            System.out.println("Your hand is A & A");
            System.out.println("You can only chose to change one Ace.");
        } else if (B == 1) {
            System.out.println("Your hand is " + A + " & A");
        } else if (A == 1) {
            System.out.println("Your hand is A & " + B);
        } else {
            System.out.println("Your hand is " + A + " & " + B);
        }
    }

    public void turn(){
        boolean shouldContinue = true;
        System.out.println(" ");
        newHand();
        cards();
        value = A + B;
        ace();
        move();
    }

    public static void main(String[] args) {
        BlackJack hw = new BlackJack();
        hw.turn();
    }
}