import java.util.Scanner;
public class ATMExceptionDemo {
 static void withdraw(int balance,int amount) throws Exception {
  if(amount<0) throw new IllegalArgumentException("Amount cannot be negative");
  if(amount>balance) throw new Exception("Insufficient balance");
  System.out.println("Withdrawal successful. Remaining balance: "+(balance-amount));
 }
 public static void main(String[] a) {
  Scanner s=new Scanner(System.in);
  System.out.print("Account number: "); String account=s.nextLine();
  try {
   System.out.print("Balance: "); int balance=Integer.parseInt(s.nextLine());
   System.out.print("Withdrawal amount: "); int amount=Integer.parseInt(s.nextLine());
   try { withdraw(balance,amount); }
   catch(IllegalArgumentException e){System.out.println("Invalid amount: "+e.getMessage());}
   catch(Exception e){System.out.println("Withdrawal failed: "+e.getMessage());}
   finally {System.out.println("ATM transaction completed for "+account);}
  } catch(NumberFormatException e){System.out.println("Invalid input: enter numbers only.");}
  s.close();
 }
}
