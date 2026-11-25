import java.io.*;
import java.util.Scanner;
public class ResourceSafetyDemo {
 public static void main(String[] a){
  Scanner s=new Scanner(System.in); System.out.print("Number of store files: "); int n=s.nextInt();
  try{
   for(int i=1;i<=n;i++) try(PrintWriter w=new PrintWriter("store"+i+".txt")){w.println("Store "+i+" sales: "+(i*100));}
   int total=0;
   try(PrintWriter report=new PrintWriter("sales-report.txt")){
    for(int i=1;i<=n;i++) try(BufferedReader r=new BufferedReader(new FileReader("store"+i+".txt"))){
     String line=r.readLine(); System.out.println(line); total+=i*100; report.println(line);
    } catch(IOException e){System.out.println("Read error: "+e.getMessage());}
    report.println("Total sales: "+total);
   }
   System.out.println("Report created. Total sales: "+total);
  }catch(IOException e){System.out.println("Report error: "+e.getMessage());}
  s.close();
 }
}
