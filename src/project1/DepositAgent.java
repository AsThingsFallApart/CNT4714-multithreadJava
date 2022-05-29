/* Name: Gregory Flynn
   Course: CNT 4714 Summer 2022
   Assignment title: Project 1 – Synchronized, Cooperating Threads Under Locking
   Due Date: June 5, 2022
*/

import java.util.Random;

public class DepositAgent implements Runnable {
  private int depositAmount = 0;
  private int sleepDuration = 0;
  private String name = "";
  private BankAccount linkedAccount;

  // make an instance of the "Random" class
  private static final Random random = new Random();

  // DepositAgent constructor
  public DepositAgent(String name, BankAccount acc) {
    this.name = name;
    linkedAccount = acc;
  }

  // overriding the "run()" method in Runnable
  // to specifiy DepositAgent behavior
  public void run() {

    // have the thread always be in the Runnable state
    while(true) {

      /* handle deposits */
      // generate a random number in the range 1-500 (inclusive)
      depositAmount = random.nextInt(499) + 1;
      linkedAccount.depositFunds(depositAmount);
      System.out.print("Agent " + name + " deposits $" + depositAmount);
      System.out.print("\t\t\t\t\t\t(+) Balance is $" + linkedAccount.getBalance() + "\n");


      // handle thread sleeping */
      // range: 3-6 (inclusive)
      sleepDuration = random.nextInt(4) + 3;
      try {
        Thread.sleep(sleepDuration);
      }
      catch(InterruptedException ex) {}
    }
  }
}