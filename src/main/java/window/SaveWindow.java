package window;

import sun.applet.Main;
import util.CopyFileUtils;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SaveWindow extends JFrame implements ActionListener {
    private String sourcePath="C:/Users/57730/AppData/Roaming/StardewValley/Saves/凡星_187040496";
    private JTextField saveTest;
    private JButton saveButton;
    private JButton backButton;

    public SaveWindow(){
        super();
        setTitle("存档管理");
        setVisible(true);
        setSize(300,300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
        JPanel jPanel = new JPanel();
        saveTest = new JTextField(15);
        saveButton = new JButton("存档");
        backButton = new JButton("返回");
        saveButton.addActionListener(this);
        backButton.addActionListener(this);
        jPanel.add(saveTest);
        jPanel.add(saveButton);
        jPanel.add(backButton);
        setContentPane(jPanel);

    }

    public void saveFile(){
        String targetPath="C:/Users/57730/AppData/Roaming/StardewValley/"+"凡星("+saveTest.getText()+")_187040496";
        try {
            CopyFileUtils.copyFolder(sourcePath,targetPath);
            JOptionPane.showMessageDialog(null,"存档成功！","提示",JOptionPane.PLAIN_MESSAGE);
            saveTest.setText("");
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"存档失败!\n"+"错误信息:"+e.getMessage(),"提示",JOptionPane.WARNING_MESSAGE);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("存档")){
            saveFile();
        }
        else if(e.getActionCommand().equals("返回")){
            MainWindow mainWindow = new MainWindow();
            dispose();
        }
    }
}
