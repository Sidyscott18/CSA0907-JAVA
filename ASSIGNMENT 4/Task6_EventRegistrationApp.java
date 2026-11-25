import java.awt.*;import java.sql.*;import java.util.*;import java.io.*;import javax.swing.*;import javax.swing.table.*;
class Registration{String id,name,event;Registration(String i,String n,String e){id=i;name=n;event=e;}}
class RegistrationDAO{
 String url="jdbc:mysql://localhost:3306/campus_events",user="root",password="YOUR_MYSQL_PASSWORD";
 Connection connect()throws SQLException{return DriverManager.getConnection(url,user,password);}
 void register(Registration r)throws SQLException{
  try(Connection c=connect();PreparedStatement p=c.prepareStatement("INSERT INTO registrations(student_id,student_name,event_name) VALUES(?,?,?)")){
   p.setString(1,r.id);p.setString(2,r.name);p.setString(3,r.event);p.executeUpdate();
  }catch(SQLIntegrityConstraintViolationException e){throw new SQLException("Student already registered for this event.");}
 }
 Vector<Vector<Object>> page(String event,int limit,int offset)throws SQLException{
  Vector<Vector<Object>> rows=new Vector<>();String q="SELECT student_id,student_name,event_name FROM registrations WHERE (?='All' OR event_name=?) ORDER BY id LIMIT ? OFFSET ?";
  try(Connection c=connect();PreparedStatement p=c.prepareStatement(q)){p.setString(1,event);p.setString(2,event);p.setInt(3,limit);p.setInt(4,offset);try(ResultSet r=p.executeQuery()){while(r.next()){Vector<Object> v=new Vector<>();v.add(r.getString(1));v.add(r.getString(2));v.add(r.getString(3));rows.add(v);}}}return rows;
 }
}
public class Task6_EventRegistrationApp extends JFrame{
 JTextField id=new JTextField(8),name=new JTextField(10);JComboBox<String> event=new JComboBox<>(new String[]{"Music","Dance","Drama","Sports"}),filter=new JComboBox<>(new String[]{"All","Music","Dance","Drama","Sports"});
 DefaultTableModel model=new DefaultTableModel(new String[]{"Student ID","Name","Event"},0);JTable table=new JTable(model);JLabel status=new JLabel("Ready.");RegistrationDAO dao=new RegistrationDAO();int page=0;final int PAGE=20;
 Task6_EventRegistrationApp(){super("Campus Event Registration");setLayout(new BorderLayout());
 JMenuBar mb=new JMenuBar();JMenu file=new JMenu("File");JMenuItem refresh=new JMenuItem("Refresh"),exit=new JMenuItem("Exit");refresh.addActionListener(e->load());exit.addActionListener(e->dispose());file.add(refresh);file.add(exit);mb.add(file);setJMenuBar(mb);
 JPanel top=new JPanel();top.add(new JLabel("Student ID"));top.add(id);top.add(new JLabel("Name"));top.add(name);top.add(event);JButton register=new JButton("Register");top.add(register);add(top,BorderLayout.NORTH);
 JPanel center=new JPanel(new BorderLayout());JPanel f=new JPanel();f.add(new JLabel("Filter"));f.add(filter);JButton apply=new JButton("Apply"),export=new JButton("Export CSV");f.add(apply);f.add(export);center.add(f,BorderLayout.NORTH);center.add(new JScrollPane(table));add(center,BorderLayout.CENTER);
 JPanel bottom=new JPanel();JButton prev=new JButton("Previous"),next=new JButton("Next");bottom.add(prev);bottom.add(next);bottom.add(status);add(bottom,BorderLayout.SOUTH);
 register.addActionListener(e->register());apply.addActionListener(e->{page=0;load();});prev.addActionListener(e->{if(page>0){page--;load();}});next.addActionListener(e->{page++;load();});export.addActionListener(e->export());setDefaultCloseOperation(EXIT_ON_CLOSE);setSize(850,500);setLocationRelativeTo(null);load();}
 void register(){String i=id.getText().trim(),n=name.getText().trim();if(i.isEmpty()||n.isEmpty()){status.setText("Enter student ID and name.");return;}Registration r=new Registration(i,n,(String)event.getSelectedItem());status.setText("Saving...");
  new SwingWorker<Void,Void>(){protected Void doInBackground()throws Exception{dao.register(r);return null;}protected void done(){try{get();status.setText("Registered.");page=0;load();}catch(Exception e){status.setText("Error: "+root(e));}}}.execute();}
 void load(){String f=(String)filter.getSelectedItem();status.setText("Loading...");new SwingWorker<Vector<Vector<Object>>,Void>(){protected Vector<Vector<Object>> doInBackground()throws Exception{return dao.page(f,PAGE,page*PAGE);}protected void done(){try{Vector<Vector<Object>> rows=get();model.setRowCount(0);for(Vector<Object> r:rows)model.addRow(r);status.setText("Page "+(page+1)+": "+rows.size()+" rows");}catch(Exception e){status.setText("Database error: "+root(e));}}}.execute();}
 String root(Exception e){Throwable t=e;while(t.getCause()!=null)t=t.getCause();return t.getMessage();}
 void export(){JFileChooser c=new JFileChooser();if(c.showSaveDialog(this)!=JFileChooser.APPROVE_OPTION)return;try(PrintWriter w=new PrintWriter(c.getSelectedFile())){for(int x=0;x<model.getColumnCount();x++)w.print((x==0?"":",")+model.getColumnName(x));w.println();for(int r=0;r<model.getRowCount();r++){for(int x=0;x<model.getColumnCount();x++)w.print((x==0?"":",")+"\""+model.getValueAt(r,x)+"\"");w.println();}status.setText("Current page exported.");}catch(Exception e){status.setText(e.getMessage());}}
 public static void main(String[]x){SwingUtilities.invokeLater(()->new Task6_EventRegistrationApp().setVisible(true));}
}
