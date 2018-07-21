public class DisPlayMessage extends Thread {
   private int number;
   public DisPlayMessage(int number) {
      this.number = number;
   }
   
   public void run() {
      int counter = 0;
      int guess = 0;
      do {
         guess = (int) (Math.random() * 100 + 1);
         System.out.println(this.getName() + " guesses " + guess);
         counter++;
      } while(guess != number);
      System.out.println("** Correct!" + this.getName() + "in" + counter + "guesses.**");
   }
   public static void main(String[] args) {
   	DisPlayMessage n = new DisPlayMessage(80);
   	n.run();
   }
}