import java.io.IOException;
import java.nio.file.*;

public class Nio {
    public static void write_by_bytes_nio(byte[] data,String filename) throws IOException {
        Path path = Paths.get(filename);
        Files.write(path,data);
    }

    public static byte[] read_by_bytes_nio(String filename) throws IOException {
        Path path = Paths.get(filename);
        return Files.readAllBytes(path);
    }
}
