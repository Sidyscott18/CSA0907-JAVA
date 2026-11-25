import java.util.Scanner;
public class SeatBooking {
 private final boolean[] booked; private int bookingsMade=0;
 SeatBooking(int n){booked=new boolean[n];}
 public synchronized void book(int seat){if(seat>=0&&seat<booked.length&&!booked[seat]){booked[seat]=true;bookingsMade++;}}
 public static void main(String[] a)throws InterruptedException{
  Scanner s=new Scanner(System.in); System.out.print("Number of seats: "); int n=s.nextInt();
  System.out.print("Number of users: "); int users=s.nextInt();
  SeatBooking screen=new SeatBooking(n); Thread[] t=new Thread[users];
  for(int i=0;i<users;i++){final int seat=i%n;t[i]=new Thread(()->screen.book(seat));t[i].start();}
  for(Thread x:t)x.join(); System.out.println("Seats sold: "+screen.bookingsMade); s.close();
 }
}
