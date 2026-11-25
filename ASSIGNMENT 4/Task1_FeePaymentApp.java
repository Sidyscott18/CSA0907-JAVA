import java.awt.*;import java.awt.event.*;import javax.swing.*;
class FeeService{
 String pay(String id,String text){
  if(id.trim().isEmpty())throw new IllegalArgumentException("Enter registration number.");
  double amount;try{amount=Double.parseDouble(text);}catch(Exception e){throw new IllegalArgumentException("Enter a valid amount.");}
  if(amount<=0)throw new IllegalArgumentException("Amount must be positive.");
  return String.format("Payment of Rs. %.2f recorded for %s",amount,id);
 }
}
public class Task1_FeePaymentApp extends JFrame{
 JTextField id=new JTextField(12),amount=new JTextField(12);JLabel status=new JLabel("Enter fee details.");FeeService service=new FeeService();
 Task1_FeePaymentApp(){super("Fee Payment");setLayout(new GridLayout(4,2,6,6));add(new JLabel("Register No:"));add(id);add(new JLabel("Amount:"));add(amount);
 JButton pay=new JButton("Pay"),clear=new JButton("Clear"),receipt=new JButton("Receipt");add(pay);add(clear);add(receipt);add(status);
 pay.addActionListener(e->{try{status.setText(service.pay(id.getText(),amount.getText()));}catch(Exception x){status.setText(x.getMessage());}});
 clear.addActionListener(e->{id.setText("");amount.setText("");status.setText("Cleared.");});
 receipt.addActionListener(e->JOptionPane.showMessageDialog(this,status.getText(),"Receipt",1));
 setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){if(JOptionPane.showConfirmDialog(Task1_FeePaymentApp.this,"Close window?")==0)dispose();}});
 setSize(430,180);setLocationRelativeTo(null);}
 public static void main(String[]x){SwingUtilities.invokeLater(()->new Task1_FeePaymentApp().setVisible(true));}
}
