public class BlackJack
{
    private int value;

    public BlackJack() {
        this.draw();
    }
    
    private void draw() {
        this.value = (int)(Math.random() * 10) + 1;
    }
    
    public void turn(){
        this.value = (int)(Math.random() * 10) + 1;
        
        for (int i = value; i < 21; this.value) {
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
    cd 
    
    
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