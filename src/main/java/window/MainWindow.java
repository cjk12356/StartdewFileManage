package window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame implements ActionListener {
    private Button saveButton ;
    private Button readButton  ;
    private Button deleteButton  ;

    public MainWindow(){
        super();
        setTitle("星露谷物语存档管理器");
        setVisible(true);
        setSize(500,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
        JPanel jPanel = new JPanel();
        /*jPanel.setLayout(new FlowLayout(FlowLayout.LEADING,20,20));*/
        jPanel.setLayout(null);
        saveButton = new Button("存档");
        readButton = new Button("读档");
        deleteButton = new Button("删除存档");
        saveButton.setBounds(50,80,100,60);
        readButton.setBounds(180,80,100,60);
        deleteButton.setBounds(310,80,100,60);
        saveButton.addActionListener(this);
        readButton.addActionListener(this);
        deleteButton.addActionListener(this);
        jPanel.add(saveButton);
        jPanel.add(readButton);
        jPanel.add(deleteButton);
        setContentPane(jPanel);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("读档")){
            ReadWindow readWindow = new ReadWindow();
            dispose();
        }
        else if(e.getActionCommand().equals("存档")){
            SaveWindow saveWindow = new SaveWindow();
            dispose();
        }
        else if(e.getActionCommand().equals("删除存档")){
            DeleteWindow deleteWindow = new DeleteWindow();
            dispose();
        }
    }

    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow();
        mainWindow.setVisible(true);
    }
}
