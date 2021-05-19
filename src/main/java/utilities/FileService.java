package utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileService {

/**    public static String[] read(String path) throws IOException {
        return Files.readAllLines(Paths.get(path)).toArray(new String[0]);
    }
**/
    public static void write(String path, String data) throws IOException {
        Files.write(Paths.get(path), data.getBytes(), StandardOpenOption.APPEND);
    }
}