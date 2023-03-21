import View.myGUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main {
    public static int posX=0,posY=0;
    public static void main(String[] args) {
        JFrame myFrame = new JFrame();
        myFrame.setSize(400, 300);
        myFrame.setLocationRelativeTo(null);
        myFrame.setUndecorated(true);

        myGUI content = new myGUI();

        myFrame.setContentPane(content.getMyPanel());
//        myFrame.pack();\
        myFrame.setVisible(true);

        myFrame.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.decode("#609966")));

        content.getMyPanel().addMouseListener(new MouseAdapter()
        {
            public void mousePressed(MouseEvent e)
            {
                posX=e.getX();
                posY=e.getY();
            }
        });

        content.getMyPanel().addMouseMotionListener(new MouseAdapter()
        {
            public void mouseDragged(MouseEvent evt)
            {
                myFrame.setLocation(evt.getXOnScreen()-posX,evt.getYOnScreen()-posY);
            }
        });

        content.getMinimaze().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                myFrame.setExtendedState(myFrame.getExtendedState() | myFrame.ICONIFIED);
            }
        });

    }
}
