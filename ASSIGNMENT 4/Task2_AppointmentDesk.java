import java.awt.*;import java.awt.event.*;import java.util.*;import javax.swing.*;
public class Task2_AppointmentDesk extends JFrame{
 JTextField patient=new JTextField(12);JComboBox<String> dept=new JComboBox<>(new String[]{"Cardiology","Orthopaedics","Dermatology"});
 JComboBox<String> doctor=new JComboBox<>(),slot=new JComboBox<>(new String[]{"09:00 AM","10:00 AM","11:00 AM","02:00 PM"});JLabel status=new JLabel("Ready.");
 Map<String,java.util.List<String>> doctors=new HashMap<>();boolean booking=false;
 Task2_AppointmentDesk(){super("Outpatient Appointment Desk");doctors.put("Cardiology",Arrays.asList("Dr Kumar","Dr Meena"));doctors.put("Orthopaedics",Arrays.asList("Dr Ravi","Dr Asha"));doctors.put("Dermatology",Arrays.asList("Dr Priya","Dr John"));
 setLayout(new GridLayout(5,2,8,8));add(new JLabel("Patient ID:"));add(patient);add(new JLabel("Department:"));add(dept);add(new JLabel("Doctor:"));add(doctor);add(new JLabel("Time:"));add(slot);JButton book=new JButton("Book");add(book);add(status);
 dept.addActionListener(e->refreshDoctors());book.addActionListener(e->book());refreshDoctors();
 setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);addWindowListener(new WindowAdapter(){public void windowClosing(WindowEvent e){if(!booking||JOptionPane.showConfirmDialog(Task2_AppointmentDesk.this,"Booking in progress. Close?")==0)dispose();}});
 setSize(480,240);setLocationRelativeTo(null);}
 void refreshDoctors(){doctor.removeAllItems();for(String d:doctors.get((String)dept.getSelectedItem()))doctor.addItem(d);}
 void book(){if(patient.getText().trim().isEmpty()){status.setText("Patient ID required.");return;}booking=true;String m="Booked "+patient.getText()+" with "+doctor.getSelectedItem()+" at "+slot.getSelectedItem();status.setText(m);JOptionPane.showMessageDialog(this,m);booking=false;}
 public static void main(String[]x){SwingUtilities.invokeLater(()->new Task2_AppointmentDesk().setVisible(true));}
}
