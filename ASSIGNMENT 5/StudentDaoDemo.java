import java.sql.*;import java.util.*;
interface Dao<T,K>{int insert(T x)throws SQLException;T findById(K id)throws SQLException;List<T> findAll()throws SQLException;boolean update(T x)throws SQLException;boolean delete(K id)throws SQLException;}
class Student{int id;String name,email;Student(int i,String n,String e){id=i;name=n;email=e;}public String toString(){return id+" "+name+" "+email;}}
class StudentDao implements Dao<Student,Integer>{
 Connection c;StudentDao(Connection c){this.c=c;}
 public int insert(Student s)throws SQLException{try(PreparedStatement p=c.prepareStatement("INSERT INTO students VALUES(?,?,?)")){p.setInt(1,s.id);p.setString(2,s.name);p.setString(3,s.email);return p.executeUpdate();}}
 public Student findById(Integer id)throws SQLException{try(PreparedStatement p=c.prepareStatement("SELECT * FROM students WHERE id=?")){p.setInt(1,id);try(ResultSet r=p.executeQuery()){return r.next()?new Student(r.getInt(1),r.getString(2),r.getString(3)):null;}}}
 public List<Student> findAll()throws SQLException{List<Student> a=new ArrayList<>();try(Statement s=c.createStatement();ResultSet r=s.executeQuery("SELECT * FROM students")){while(r.next())a.add(new Student(r.getInt(1),r.getString(2),r.getString(3)));}return a;}
 public boolean update(Student s)throws SQLException{try(PreparedStatement p=c.prepareStatement("UPDATE students SET name=?,email=? WHERE id=?")){p.setString(1,s.name);p.setString(2,s.email);p.setInt(3,s.id);return p.executeUpdate()==1;}}
 public boolean delete(Integer id)throws SQLException{try(PreparedStatement p=c.prepareStatement("DELETE FROM students WHERE id=?")){p.setInt(1,id);return p.executeUpdate()==1;}}
}
public class StudentDaoDemo{public static void main(String[] a){try(Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment5","root","YOUR_MYSQL_PASSWORD")){System.out.println("Student DAO ready.");}catch(Exception e){System.out.println("Set up MySQL first: "+e.getMessage());}}}
