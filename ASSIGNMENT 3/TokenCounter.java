import java.util.Scanner;
public class TokenCounter {
 private final int[] buffer=new int[5]; private int count=0,in=0,out=0;
 public synchronized void put(int token)throws InterruptedException{
  while(count==buffer.length)wait(); buffer[in]=token; in=(in+1)%buffer.length; count++; notifyAll();
 }
 public synchronized int take()throws InterruptedException{
  while(count==0)wait(); int token=buffer[out]; out=(out+1)%buffer.length; count--; notifyAll(); return token;
 }
 public static void main(String[] a)throws InterruptedException{
  Scanner s=new Scanner(System.in); System.out.print("Number of tokens: "); int n=s.nextInt();
  TokenCounter c=new TokenCounter(); int[] sum={0};
  Thread producer=new Thread(()->{try{for(int i=1;i<=n;i++)c.put(i);}catch(InterruptedException e){Thread.currentThread().interrupt();}});
  Thread consumer=new Thread(()->{try{for(int i=1;i<=n;i++)sum[0]+=c.take();}catch(InterruptedException e){Thread.currentThread().interrupt();}});
  producer.start();consumer.start();producer.join();consumer.join();
  System.out.println("Sum of tokens collected: "+sum[0]+" (expected "+(n*(n+1)/2)+")");s.close();
 }
}
