import java.io.*;
public class FileUtility {
    private static void write_into_file(String filename, String text, boolean append) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, append))) {
            bw.write(text);
        }
    }

    public static void write_into_file(String filename, String text) throws IOException {
        write_into_file(filename, text, false);
    }

    public static void append_into_file(String filename, String text) throws IOException {
        write_into_file(filename, text, true);
    }

    public static String read_and_write_file(String filename) throws Exception {
        InputStream in = new FileInputStream(filename);
        InputStreamReader out = new InputStreamReader(in);
        BufferedReader reader = new BufferedReader(out);
        String line;
        String res = "";
        while ((line = reader.readLine()) != null) {
            res += line + "\n";
        }
        return res;
    }

    public static byte[] read_by_bytes(String filename) throws Exception {
        File file = new File(filename);
        try (FileInputStream fis = new FileInputStream(file)) {
            byte[] bytes = new byte[(int) file.length()];
            fis.read(bytes);
            return bytes;
        }
    }

    public static void write_by_bytes(String filename, byte[] data) throws IOException {
        File file = new File(filename);
        FileOutputStream fop = new FileOutputStream(file);

        fop.write(data);
        fop.flush();
        fop.close();
    }

    public static void write_object_to_file(Serializable object, String filename) throws Exception {
        try (FileOutputStream fos = new FileOutputStream(filename);
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(object);
        }
    }

    public static Object read_file_as_object(String filename){
        Object obj = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))){
            obj = in.readObject();
        } finally{
            return obj;
        }
    }
}
