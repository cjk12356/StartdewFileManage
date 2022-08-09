package test;

import util.FileUtils;

import javax.swing.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ReadTest extends JFrame {

    public ReadTest(){
        super("读档");
        setSize(300,400);
    }


    public static void main(String[] args) {
        ReadTest readTest = new ReadTest();
        readTest.setVisible(true);
        String filePath="C:\\Users\\57730\\AppData\\Roaming\\StardewValley";
        FileUtils fileUtils = new FileUtils(new ArrayList<File>(),filePath);
        List<File> fileList = fileUtils.getFileList(filePath);
        for (File file : fileList) {
            System.out.println(file.getName());
        }
    }

}
