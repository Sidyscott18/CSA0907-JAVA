import java.sql.*;
public class WalletTransaction{
 public static void transfer(Connection c,int from,int to,double amount)throws SQLException{
  if(amount<=0)throw new IllegalArgumentException("Amount must be positive.");
  boolean old=c.getAutoCommit();c.setAutoCommit(false);
  try(PreparedStatement debit=c.prepareStatement("UPDATE wallets SET balance=balance-? WHERE wallet_id=? AND balance>=?");
      PreparedStatement credit=c.prepareStatement("UPDATE wallets SET balance=balance+? WHERE wallet_id=?")){
   debit.setDouble(1,amount);debit.setInt(2,from);debit.setDouble(3,amount);
   if(debit.executeUpdate()!=1)throw new SQLException("Insufficient balance or source wallet missing.");
   credit.setDouble(1,amount);credit.setInt(2,to);if(credit.executeUpdate()!=1)throw new SQLException("Destination wallet missing.");
   c.commit();
  }catch(SQLException|RuntimeException e){c.rollback();throw e;}finally{c.setAutoCommit(old);}
 }
 public static void main(String[] a){
  try(Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/assignment5","root","YOUR_MYSQL_PASSWORD")){
   transfer(c,1,2,500);System.out.println("Transfer completed.");
  }catch(Exception e){System.out.println("Transfer failed: "+e.getMessage());}
 }
}
