package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyFileUtils {
    /**
     * �����ļ���·��ʵ���ļ��еĸ��ƣ������ļ����е������ļ���
     *
     * @param sourceFolderPath
     * @param targetFolderPath
     */
    public static void copyFolder(String sourceFolderPath, String targetFolderPath) throws IOException {
        File sourceFolder = new File(sourceFolderPath);
        String[] sourceFilePathList = sourceFolder.list();
        File targetFolder = new File(targetFolderPath);
        //�ж�Ŀ���ļ����Ƿ����,û���򴴽�
        if (!targetFolder.exists()) {
            targetFolder.mkdirs();
        }

            for (String filePath : sourceFilePathList) {
                if (new File(sourceFolderPath + sourceFolder.separator + filePath).isDirectory()) {
                    copyFolder(sourceFolderPath + sourceFolder.separator + filePath, targetFolderPath + sourceFolder.separator + filePath);
                }
                if (new File(sourceFolderPath + sourceFolder.separator + filePath).isFile()) {
                    copyFile(sourceFolderPath + sourceFolder.separator + filePath, targetFolderPath + sourceFolder.separator + filePath);
                }
            }

    }

    public static void copyFile(String sourceFilePath, String targetFilePath) throws IOException {
        File sourceFile = new File(sourceFilePath);
        File targetFile = new File(targetFilePath);
        FileInputStream inputStream = new FileInputStream(sourceFile);
        FileOutputStream outputStream = new FileOutputStream(targetFile);
        byte[] buffer = new byte[4096];
        int length = 0;
        while ((length = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, length);
        }
        inputStream.close();
        outputStream.close();
    }

    //���Է���
    public static void main(String[] args) {
        /*String sourceFolderPath = "C:/Test/demo";*/
        String sourceFolderPath="C:/Users/57730/AppData/Roaming/StardewValley/ErrorLogs";
        String targetFolderPath = "C:/Test/copy/demo";
        /*copyFolder(sourceFolderPath, targetFolderPath);*/
    }

}
