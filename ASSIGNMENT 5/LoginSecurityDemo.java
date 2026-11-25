import java.sql.*;import java.util.*;
public class LoginSecurityDemo{
 static final String URL="jdbc:mysql://localhost:3306/assignment5",USER="root",PASS="YOUR_MYSQL_PASSWORD";
 static boolean unsafe(Connection c,String id,String pw)throws SQLException{
  String q="SELECT COUNT(*) FROM app_users WHERE user_id='"+id+"' AND password_text='"+pw+"'";
  try(Statement s=c.createStatement();ResultSet r=s.executeQuery(q)){r.next();return r.getInt(1)>0;}
 }
 static boolean safe(Connection c,String id,String pw)throws SQLException{
  try(PreparedStatement p=c.prepareStatement("SELECT COUNT(*) FROM app_users WHERE user_id=? AND password_text=?")){
   p.setString(1,id);p.setString(2,pw);try(ResultSet r=p.executeQuery()){r.next();return r.getInt(1)>0;}
  }
 }
 public static void main(String[] a){
  try(Scanner s=new Scanner(System.in);Connection c=DriverManager.getConnection(URL,USER,PASS)){
   System.out.print("User ID: ");String id=s.nextLine();System.out.print("Password: ");String pw=s.nextLine();
   System.out.println("Unsafe result: "+unsafe(c,id,pw));System.out.println("PreparedStatement result: "+safe(c,id,pw));
  }catch(Exception e){System.out.println("Database error: "+e.getMessage());}
 }
}
