/* Name: Gregory Flynn
   Course: CNT 4714 Summer 2022
   Assignment title: Project 1 – Synchronized, Cooperating Threads Under Locking
   Due Date: June 5, 2022
*/

// this class is needed since the threads need to modify the same space in memory.
// primitives in java are "pass by value" so pointing all threads to an int is akin to
// pointing the threads to temporary places in memory.
// objects in java are "pass by reference" so, even though a "bank account" is simply one integer,
// all the threads will point to the same place in memory if passed an object

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {
  private int balance = 0;

  // lock to control mutually exclusive access to the buffer
  private Lock mutex = new ReentrantLock();

  // condition representing the ability to withdrawal if funds exist
  private Condition sufficientBalance = mutex.newCondition();

  // constructor
  public BankAccount(){}

  // mutator: subtract from balance
  public void withdrawalFunds(int amountToWithdrawal, String agentName) {

    // lock out any other threads from accessing the bank account object
    mutex.lock();

    if(amountToWithdrawal > balance) {
      System.out.print("\t\t\t\tAgent " + agentName + " withdraws $" + amountToWithdrawal);
      System.out.print("\t\t(******) WITHDRAWAL BLOCKED - INSUFFICIENT FUNDS!!!\n");
      try {
        // wait for balance to change, hopefully being a sufficient level to withdrawal from
        // without incurring a negative balance
        sufficientBalance.await();
      }
      catch(InterruptedException exception){
        exception.printStackTrace();
      }
    }
    else {
      balance -= amountToWithdrawal;

      System.out.print("\t\t\t\tAgent " + agentName + " withdraws $" + amountToWithdrawal);
      System.out.print("\t\t(-) Balance is $" + balance + "\n");
    }

    // unlock the lock, allowing other threads to access bank account object
    mutex.unlock();
  }

  // mutator: add to balance
  public void depositFunds(int amountToDeposit, String agentName) {

    // lock out any other threads from accessing the bank account object
    mutex.lock();

    balance += amountToDeposit;

    System.out.print("Agent " + agentName + " deposits $" + amountToDeposit);
    System.out.print("\t\t\t\t\t\t(+) Balance is $" + balance + "\n");

    // signal to all withdrawal agents that they can try to withdrawal again
    sufficientBalance.signalAll();

    // unlock the lock, allowing other threads to access bank account object
    mutex.unlock();
  }

  // accessor: see balance
  public int getBalance() {
    return balance;
  }
}