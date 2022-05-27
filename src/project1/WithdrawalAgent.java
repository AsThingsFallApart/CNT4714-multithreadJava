/* Name: Gregory Flynn
   Course: CNT 4714 Summer 2022
   Assignment title: Project 1 – Synchronized, Cooperating Threads Under Locking
   Due Date: June 5, 2022
*/

import java.util.Random;

public class WithdrawalAgent implements Runnable {
  private int withdrawalAmount = 0;
  private int sleepDuration = 0;
  private String name = "";

  // make an instance of the "Random" class
  private static final Random random = new Random();

  // WithdrawalAgent constructor
  public WithdrawalAgent(String name) {
    this.name = name;
  }

  // overriding the "run()" method in Runnable
  // to specifiy WithdrawalAgent behavior
  public void run() {
    while(true) {
        // use the instance of the Random class to generate
        // random numbers in the range 1-99 (inclusive)
        withdrawalAmount = random.nextInt(100);

        // do the same for 'sleepDuration'
        // range: 1-3 (inclusive)
        sleepDuration = random.nextInt(5000);

        System.out.println(name + ":" + withdrawalAmount);

        try {
          Thread.sleep(sleepDuration);
        }
        catch(InterruptedException ex) {}
    }
  }
}