import java.io.*;import java.nio.file.*;import java.sql.*;import java.util.*;
public class PassMigration{
 static final String URL="jdbc:mysql://localhost:3306/assignment5",USER="root",PASS="YOUR_MYSQL_PASSWORD";
 public static void main(String[] a){if(a.length==0){System.out.println("Usage: java PassMigration passes.csv");return;}
  List<String[]> good=new ArrayList<>();List<String> bad=new ArrayList<>();
  try(BufferedReader r=Files.newBufferedReader(Paths.get(a[0]))){String line;int n=0;while((line=r.readLine())!=null){n++;String[] p=line.split(",",-1);try{if(p.length!=5)throw new Exception("Expected five fields");Integer.parseInt(p[3]);double v=Double.parseDouble(p[4]);if(v<0)throw new Exception("Negative amount");good.add(p);}catch(Exception e){bad.add("Line "+n+": "+e.getMessage());}}}
  catch(IOException e){System.out.println("File error: "+e.getMessage());return;}
  try(Connection c=DriverManager.getConnection(URL,USER,PASS)){System.out.println("Loaded: "+PassLoader.loadAll(c,good));System.out.println("Rejected: "+bad.size());for(String x:bad)System.out.println(x);
   DatabaseMetaData m=c.getMetaData();System.out.println("Database: "+m.getDatabaseProductName()+" "+m.getDatabaseProductVersion());System.out.println("Driver: "+m.getDriverName()+" "+m.getDriverVersion());
   try(ResultSet t=m.getTables(c.getCatalog(),null,"%",new String[]{"TABLE"})){while(t.next())System.out.println("Table: "+t.getString("TABLE_NAME"));}
  }catch(Exception e){System.out.println("Migration error: "+e.getMessage());}
 }
}
