package window;

import util.FileUtils;
import util.CopyFileUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadWindow extends JFrame implements ActionListener {

    private List<Button> fileButtons;
    private List<File> fileList;
    private String targetPath="C:/Users/57730/AppData/Roaming/StardewValley/Saves/凡星_187040496";

    public ReadWindow() {
        super();
        setTitle("读档管理");
        setVisible(true);
        setSize(500, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(3);
        //将存档文件夹下的文件读取到fileList
        readFile();
        JButton backButton = new JButton("返回");
        backButton.setBackground(Color.CYAN);
        backButton.addActionListener(this);
        JPanel jPanel1 = new JPanel();
        jPanel1.add(backButton);
        for(int i=0;i<fileButtons.size();i++){
            Button fileButton = fileButtons.get(i);
            fileButton.addActionListener(this);
            jPanel1.add(fileButton);
        }

        setContentPane(jPanel1);

    }

    public void readFile(){
        fileButtons= new ArrayList<Button>();
        String filePath="C:\\Users\\57730\\AppData\\Roaming\\StardewValley";
        FileUtils fileUtils = new FileUtils(new ArrayList<File>(),filePath);
        fileList = fileUtils.getFileList(filePath);
        for (File file : fileList) {
            /*System.out.println(file.getName());*/
            Button fileButton = new Button(file.getName());
            fileButtons.add(fileButton);
        }

    }

    public void copyFile(String fileName){
        String sourcePath="C:/Users/57730/AppData/Roaming/StardewValley/"+fileName;
        try {
            CopyFileUtils.copyFolder(sourcePath,targetPath);
            JOptionPane.showMessageDialog(null,"读档成功！","标题",JOptionPane.PLAIN_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,"读档失败!\n"+"错误信息:"+e.getMessage(),"提示",JOptionPane.WARNING_MESSAGE);
        }
    }


    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        if(e.getActionCommand().equals("返回")){
            MainWindow mainWindow = new MainWindow();
            dispose();
        }
        else {
            copyFile(e.getActionCommand());
        }

    }


    public static void main(String[] args) {
        ReadWindow readWindow = new ReadWindow();
        readWindow.setVisible(true);
    }

}
