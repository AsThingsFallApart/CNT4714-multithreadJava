/* Name: Gregory Flynn
   Course: CNT 4714 Summer 2022
   Assignment title: Project 1 – Synchronized, Cooperating Threads Under Locking
   Due Date: June 5, 2022
*/

public class DepositAgent implements Runnable {

  // DepositAgent constructor
  public DepositAgent(){

  }

  // overriding the "run()" method in Runnable
  // to specifiy DepositAgent behavior
  public void run() {
    while(true){
      

      // after depositing, return all waiting withdrawal threads to the Runnable state
      // Thread.notifyAll();
    }
  }
}
