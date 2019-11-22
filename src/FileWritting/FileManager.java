package FileWritting;

import java.io.*;

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

    public Object deserialize(String filename) {
    	return null;
    }
    
    public void ordenar(String filename) {
    	int cantReg;
    	File archivo = new File(filename);
    	int longSec;
    	int numReg;
    	File f1 = new File("ArchivoAux1");
    	File f2 = new File("ArchivoAux2");
    	
    	cantReg = (int)archivo.length()/124;
    	numReg = (int)archivo.length()/cantReg;
    	longSec = 1;
    	while(longSec < numReg) {
    		distribuir(archivo, f1, f2, longSec, numReg);
    		mezclar(f1,f2, archivo, longSec, numReg);
    		longSec *= 2;
    	}
    }
    
    private void distribuir(File pArchivo, File pF1, File pF2, int pLongSec, int pNumReg) {
    	
    }
    
    private void mezclar(File pF1, File pF2, File pArchivo, int pLongSec, int pNumReg) {
    	
    }

    public static FileManager getInstance() {
        if (mInstance == null) {
            mInstance = new FileManager();
        }
        return mInstance;
    }
}
