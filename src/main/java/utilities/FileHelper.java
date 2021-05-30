package utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileHelper {

    /**
     * public static String[] read(String path) throws IOException {
     * return Files.readAllLines(Paths.get(path)).toArray(new String[0]);
     * }
     **/
    public static void write(String path, String data) throws IOException {
        Files.write(Paths.get(path), data.getBytes(), StandardOpenOption.APPEND);
    }

    public static boolean isFileExistsInDirectory(String directoryPath, String nameOfFile, String extensionOfFile) {
        File[] myFiles = new File(directoryPath).listFiles();
        if (myFiles != null) {
            for (File myFile : myFiles) {
                if (myFile.getName().startsWith(nameOfFile) && myFile.getName().endsWith("." + extensionOfFile)) {
                    return true;
                }
            }
        } else {
            return false;
        }
        return false;
    }
}