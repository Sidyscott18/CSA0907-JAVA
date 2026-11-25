import java.awt.*;import java.awt.event.*;import javax.swing.*;
public class Task5_ConverterStyles extends JFrame{
 JTextField amount=new JTextField(9);JComboBox<String> currency=new JComboBox<>(new String[]{"USD","EUR"});JLabel result=new JLabel("Enter INR.");
 Task5_ConverterStyles(){super("Currency Converter - Listener Styles");setLayout(new FlowLayout());add(new JLabel("INR:"));add(amount);add(currency);
 JButton frame=new JButton("Frame Listener"),inner=new JButton("Inner Class"),anonymous=new JButton("Anonymous"),lambdaButton=new JButton("Lambda");add(frame);add(inner);add(anonymous);add(lambdaButton);add(result);
 // Four event-handling styles: frame method, named inner class, anonymous class and lambda.
 frame.addActionListener(this::convertEvent);inner.addActionListener(new InnerHandler());
 anonymous.addActionListener(new ActionListener(){public void actionPerformed(ActionEvent e){convert();}});
 ActionListener lambda=e->convert();lambdaButton.addActionListener(lambda);amount.addActionListener(lambda);
 addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){dispose();}});setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);setSize(700,170);setLocationRelativeTo(null);}
 class InnerHandler implements ActionListener{public void actionPerformed(ActionEvent e){convert();}}
 void convertEvent(ActionEvent e){convert();}
 void convert(){try{double v=Double.parseDouble(amount.getText().trim());if(v<0)throw new NumberFormatException();String c=(String)currency.getSelectedItem();double rate=c.equals("USD")?.012:.011;result.setText(String.format("%.2f %s",v*rate,c));JOptionPane.showMessageDialog(this,result.getText());}
 catch(NumberFormatException e){result.setText("Invalid amount");JOptionPane.showMessageDialog(this,"Invalid amount","Error",0);}}
 public static void main(String[]x){SwingUtilities.invokeLater(()->new Task5_ConverterStyles().setVisible(true));}
}
