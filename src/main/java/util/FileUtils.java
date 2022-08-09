package util;


import java.io.File;
import java.util.List;

public class FileUtils {
    /**
     * 获取存档文件夹下的所有文件名
     */
    private List<File> filelist;
    private String strPath;

    public FileUtils() {
    }

    public FileUtils(List<File> filelist, String strPath) {
        this.filelist = filelist;
        this.strPath = strPath;
    }

    public List<File> getFileList(String strPath) {
        File dir = new File(strPath);
        File[] files = dir.listFiles(); // 该文件目录下文件全部放入数组
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                String fileName = files[i].getName();


                /*if (files[i].isDirectory()) { // 判断是文件还是文件夹
                    getFileList(files[i].getAbsolutePath()); // 获取文件绝对路径
                } else  { // 判断文件名
                    String strFileName = files[i].getAbsolutePath();
                    System.out.println("---" + strFileName);
                    filelist.add(files[i]);
                }*/
                if (files[i].isDirectory() && !fileName.equals("Saves") && !fileName.equals("ErrorLogs")) {
                    String strFileName = files[i].getAbsolutePath();
                    filelist.add(files[i]);
                }
            }
        }
            return filelist;

    }
}

