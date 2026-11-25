import java.awt.*;import javax.swing.*;
public class Task3_LibrarySearchScreen extends JFrame{
 JTextField query=new JTextField(20);JComboBox<String> category=new JComboBox<>(new String[]{"All","Book","Journal","Thesis"});DefaultListModel<String> model=new DefaultListModel<>();JList<String> results=new JList<>(model);JLabel status=new JLabel("Ready.");
 Task3_LibrarySearchScreen(){super("Campus Library Search");setLayout(new BorderLayout(6,6));JLabel title=new JLabel("Campus Library Search",0);title.setFont(new Font("Arial",1,20));add(title,BorderLayout.NORTH);
 JPanel search=new JPanel(new FlowLayout(FlowLayout.LEFT));search.add(new JLabel("Search:"));search.add(query);search.add(category);JButton go=new JButton("Search");search.add(go);add(search,BorderLayout.PAGE_START);
 add(new JScrollPane(results),BorderLayout.CENTER);JPanel actions=new JPanel();JButton prev=new JButton("Prev"),next=new JButton("Next"),reserve=new JButton("Reserve");actions.add(prev);actions.add(next);actions.add(reserve);
 JPanel south=new JPanel(new BorderLayout());south.add(actions,BorderLayout.CENTER);south.add(status,BorderLayout.SOUTH);add(south,BorderLayout.SOUTH);
 go.addActionListener(e->{model.clear();if(query.getText().trim().isEmpty()){status.setText("Enter search text.");return;}model.addElement(query.getText()+" - "+category.getSelectedItem()+" result 1");model.addElement(query.getText()+" - "+category.getSelectedItem()+" result 2");status.setText("2 sample results.");});
 prev.addActionListener(e->status.setText("Previous page"));next.addActionListener(e->status.setText("Next page"));reserve.addActionListener(e->status.setText(results.getSelectedValue()==null?"Select a result.":"Reservation requested: "+results.getSelectedValue()));
 setDefaultCloseOperation(EXIT_ON_CLOSE);setSize(680,440);setLocationRelativeTo(null);}
 public static void main(String[]x){SwingUtilities.invokeLater(()->new Task3_LibrarySearchScreen().setVisible(true));}
}
