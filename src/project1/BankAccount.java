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

public class BankAccount {
  private int balance = 0;

  // constructor
  public BankAccount(){}

  // allow non-members to subtract from balance
  public void withdrawalFunds(int amountToWithdrawal) {
    balance -= amountToWithdrawal;
  }

  // allow non-members to add to balance
  public void depositFunds(int amountToDeposit) {
    balance += amountToDeposit;
  }

  // allow non-members to see balance
  public int getBalance() {
    return balance;
  }
}