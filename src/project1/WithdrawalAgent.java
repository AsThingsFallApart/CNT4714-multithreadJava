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
  private BankAccount linkedAccount;

  // make an instance of the "Random" class
  private static final Random random = new Random();

  // WithdrawalAgent constructor
  public WithdrawalAgent(String name, BankAccount acc) {
    this.name = name;
    linkedAccount = acc;
  }

  // overriding the "run()" method in Runnable
  // to specifiy WithdrawalAgent behavior
  public void run() {

    // have the thread always be in the Runnable state
    while(true) {

      /* handle withdrawals */
      // generate random numbers in the range 1-99 (inclusive)
      withdrawalAmount = random.nextInt(98) + 1;
      linkedAccount.withdrawalFunds(withdrawalAmount);
      System.out.print("\t\t\tAgent " + name + " withdraws $" + linkedAccount.getBalance());
      System.out.print("\t(-) Balance is $" + linkedAccount.getBalance() + "\n");


      // handle thread sleeping */
      // range: 1-3 (inclusive)
      sleepDuration = random.nextInt(5000);
      try {
        Thread.sleep(sleepDuration);
      }
      catch(InterruptedException ex) {}
    }
  }
}