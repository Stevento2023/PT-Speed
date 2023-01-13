public class BlackJack
{
    private int value;
    int a = (int)(Math.random() * 10) + 1;
    int b = (int)(Math.random() * 10) + 1;
    int total = a + b;

    
    public void turn(){
        this.value = (int)(Math.random() * 10) + 1;
        
        for (int i = value; i < 21; this.value++) {
            System.out.println(a + " " + b);
        //if (value > 21) {
            //System.out.println(value + " You lose");
        //} else if (value == 21) {
            //System.out.println(value + "BlackJack! You Win!");
        //} else if (value < 21) {
        
        //}    
        }
    }
    
    public static void main(String[] args)
    {
        BlackJack hw = new BlackJack();
        hw.turn();
    }
    
    
    
    public BlackJack() {
        this.draw();
    }
    
    private void draw() {
        this.value = (int)(Math.random() * 10) + 1;
    }
    
    private int getValue(){
        return value;
    }

    private void draw() {
        this.value = (int)(Math.random() * 10) + 1;
    }
    
    public int drawAndGetValue(int y) {
        draw();
        return getValue();
    }
}