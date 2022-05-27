/* Name: Gregory Flynn
   Course: CNT 4714 Summer 2022
   Assignment title: Project 1 – Synchronized, Cooperating Threads Under Locking
   Due Date: June 5, 2022
*/

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Project1Driver {

  public static void main(String[] args) {
    int accountBalance = 0;
  
    // create FIVE deposit agent threads
    // Thread DT1 = new Thread(new DepositAgent());
    // Thread DT2 = new Thread(new DepositAgent());
    // Thread DT3 = new Thread(new DepositAgent());
    // Thread DT4 = new Thread(new DepositAgent());
    // Thread DT5 = new Thread(new DepositAgent());
    
    // create TEN withdrawal agent threads
    Thread WT1 = new Thread(new WithdrawalAgent("WT1"));
    Thread WT2 = new Thread(new WithdrawalAgent("WT2"));
    Thread WT3 = new Thread(new WithdrawalAgent("WT3"));
    Thread WT4 = new Thread(new WithdrawalAgent("WT4"));
    Thread WT5 = new Thread(new WithdrawalAgent("WT5"));
    Thread WT6 = new Thread(new WithdrawalAgent("WT6"));
    Thread WT7 = new Thread(new WithdrawalAgent("WT7"));
    Thread WT8 = new Thread(new WithdrawalAgent("WT8"));
    Thread WT9 = new Thread(new WithdrawalAgent("WT9"));
    Thread WT10 = new Thread(new WithdrawalAgent("WT10"));
    
    System.out.print("Deposit Agents\t\t  Withdrawal Agents\t        Balance\n");
    System.out.print("--------------\t\t---------------------\t------------------------\n\n");
    

    // create ExecutorService to manage threads
    ExecutorService threadExecutor = Executors.newCachedThreadPool();

    // start threads
    threadExecutor.execute(WT1);
    threadExecutor.execute(WT2);
    threadExecutor.execute(WT3);
    threadExecutor.execute(WT4);
    threadExecutor.execute(WT5);
    threadExecutor.execute(WT6);
    threadExecutor.execute(WT7);
    threadExecutor.execute(WT8);
    threadExecutor.execute(WT9);
    threadExecutor.execute(WT10);
  }
}
