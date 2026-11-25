import java.io.IOException;
import java.util.Scanner;
class ExamException extends Exception {
 ExamException(String m){super(m);} ExamException(String m,Throwable c){super(m,c);}
}
class SubmissionStorageException extends ExamException {
 SubmissionStorageException(String m,Throwable c){super(m,c);}
}
class Storage {
 void save(String name,long size) throws SubmissionStorageException {
  try { if(size>500) throw new IOException("Disk quota exceeded"); System.out.println("Saved "+name); }
  catch(IOException e){ throw new SubmissionStorageException("Could not store "+name,e); }
 }
}
public class StorageDemo {
 public static void main(String[] a){
  Scanner s=new Scanner(System.in); Storage st=new Storage();
  System.out.print("File name: "); String name=s.nextLine();
  System.out.print("File size in KB: "); long size=s.nextLong();
  try{st.save(name,size);}
  catch(ExamException e){System.out.println("Error: "+e.getMessage()); if(e.getCause()!=null)System.out.println("Cause: "+e.getCause().getMessage());}
  s.close();
 }
}
