import java.awt.*;import java.awt.event.*;import java.util.*;
public class Task4_DrawPad extends Frame{
 java.util.List<Point> points=new ArrayList<>();Label status=new Label("Clicks: 0");
 Task4_DrawPad(){super("Draw Pad");add(status,BorderLayout.SOUTH);addMouseListener(new MouseAdapter(){@Override public void mouseClicked(MouseEvent e){points.add(e.getPoint());status.setText("Clicks: "+points.size());repaint();}});
 addWindowListener(new WindowAdapter(){@Override public void windowClosing(WindowEvent e){dispose();}});setSize(500,350);}
 @Override public void paint(Graphics g){super.paint(g);for(Point p:points)g.fillOval(p.x-3,p.y-3,6,6);}
 public static void main(String[]x){EventQueue.invokeLater(()->new Task4_DrawPad().setVisible(true));}
}
