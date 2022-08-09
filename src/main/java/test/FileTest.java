package test;

import util.DeleteFileUtils;

public class FileTest {
    public static void main(String[] args) {
        String testFile="C:\\Test\\demo";
        DeleteFileUtils.deleteAllFile(testFile);
    }
}
