class ScannerStation extends Thread {
 private final String station; private final int scripts;
 ScannerStation(String s,int n){station=s;scripts=n;}
 public void run(){try{for(int i=0;i<scripts;i++)Thread.sleep(100);System.out.println(station+" scanned "+scripts+" scripts.");}
 catch(InterruptedException e){Thread.currentThread().interrupt();}}
}
public class ScannerStations {
 public static void main(String[] a)throws InterruptedException{
  ScannerStation[] t={new ScannerStation("Station 1",5),new ScannerStation("Station 2",4),new ScannerStation("Station 3",6),new ScannerStation("Station 4",3)};
  for(ScannerStation x:t)x.start(); for(ScannerStation x:t)x.join();
  System.out.println("All scanner stations completed.");
 }
}
