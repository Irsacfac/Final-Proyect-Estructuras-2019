package FileWritting;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class FileManager {


    private static FileManager mInstance;

    private FileManager() {
    }

    public void serialize(Object object, String filename){
        try {
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(object);
            out.close();
            file.close();
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }

    public Object deserialize(String filename)

    public static FileManager getInstance() {
        if (mInstance == null) {
            mInstance = new FileManager();
        }
        return mInstance;
    }
}
