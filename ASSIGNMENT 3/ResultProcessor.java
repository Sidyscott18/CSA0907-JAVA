import java.io.*;
import java.util.*;
import java.util.concurrent.*;
public class ResultProcessor {
 static class ScoreTask implements Callable<String>{
  private final File file; ScoreTask(File f){file=f;}
  public String call()throws Exception{
   if(!file.exists())throw new FileNotFoundException("Missing file: "+file.getName());
   try(BufferedReader r=new BufferedReader(new FileReader(file))){
    String line=r.readLine(); if(line==null)throw new IOException("Empty file: "+file.getName());
    int mark=Integer.parseInt(line.trim()); if(mark<0||mark>100)throw new IllegalArgumentException("Invalid mark in "+file.getName());
    return file.getName()+" -> "+(mark>=40?"PASS":"FAIL");
   }
  }
 }
 public static void main(String[] a)throws Exception{
  Scanner s=new Scanner(System.in); System.out.print("Number of sample files: "); int n=s.nextInt();s.nextLine();
  System.out.print("Thread pool size (1, 2, 4 or 8): ");int p=s.nextInt();s.nextLine();
  File dir=new File("scores");dir.mkdir(); List<File> files=new ArrayList<>();
  for(int i=1;i<=n;i++){System.out.print("File "+i+" (mark/C/M): ");String v=s.nextLine().trim();File f=new File(dir,"student"+i+".txt");files.add(f);
   if(!v.equalsIgnoreCase("M"))try(PrintWriter w=new PrintWriter(f)){w.println(v.equalsIgnoreCase("C")?"not-a-number":v);}
  }
  ExecutorService pool=Executors.newFixedThreadPool(p);List<Future<String>> results=new ArrayList<>();long start=System.nanoTime();
  for(File f:files)results.add(pool.submit(new ScoreTask(f)));
  int ok=0,bad=0;
  for(Future<String> f:results)try{System.out.println(f.get());ok++;}catch(ExecutionException e){System.out.println("Failed: "+e.getCause().getMessage());bad++;}
  pool.shutdown();System.out.println("Successful files: "+ok);System.out.println("Failed files: "+bad);
  System.out.println("Processing time (ms): "+(System.nanoTime()-start)/1_000_000.0);s.close();
 }
}
