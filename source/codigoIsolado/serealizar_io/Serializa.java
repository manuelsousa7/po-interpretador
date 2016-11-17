import java.io.*;

public class Serializa {
	public void saveObject(String outputFilename, Object anObject) {
		try {
			FileOutputStream fpout = new FileOutputStream(outputFilename);
			ObjectOutputStream obOut = new ObjectOutputStream(fpout);
			obOut.writeObject(anObject);
			obOut.flush();
			obOut.close();
		} catch (IOException x) {
			System.out.println("Error:" + x);
		}
	}
	public static void main(String [ ] args) {
		Serializa achas = new Serializa();
		Coordenada co = new Coordenada(1,2);
		System.out.println(co.getX());
		achas.saveObject("guardar.txt",co);
	}
}