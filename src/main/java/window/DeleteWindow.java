package window;

import util.CopyFileUtils;
import util.DeleteFileUtils;
import util.FileUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.JOptionPane.showMessageDialog;

public class DeleteWindow extends JFrame implements ActionListener {
    private java.util.List<Button> fileButtons;
    private List<File> fileList;
    private String targetPath="C:/Users/57730/AppData/Roaming/StardewValley/Saves/凡星_187040496";

    public DeleteWindow() {
        super();
        setTitle("删除存档");
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
        //创建所有存档的按钮
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


    public void deleteFile(String fileName){
        String filePath="C:/Users/57730/AppData/Roaming/StardewValley/"+fileName;
        if(DeleteFileUtils.deleteAllFile(filePath)){
            showMessageDialog(null,"删除成功！","提示",JOptionPane.PLAIN_MESSAGE);
            DeleteWindow deleteWindow = new DeleteWindow();
            dispose();
        }
        else{
            showMessageDialog(null,"删除失败!","提示",JOptionPane.WARNING_MESSAGE);
        }
    }



    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
        if(e.getActionCommand().equals("返回")){
            MainWindow mainWindow = new MainWindow();
            dispose();
        }
        else {
            int index=JOptionPane.showConfirmDialog(null,"确认要删除 "+e.getActionCommand()+" 吗","提示",JOptionPane.YES_NO_OPTION);
            if(index==0){
                deleteFile(e.getActionCommand());
            }

        }

    }
}
