import java.io.*;
public class Deserializa {
	public Object readObject(String inputFilename) {
		try {
			FileInputStream fpin = new FileInputStream(inputFilename);
			ObjectInputStream obIn = new ObjectInputStream(fpin);
			Object anObject = obIn.readObject();
			obIn.close();
			return anObject;
		} catch (IOException x) {
			System.out.println("Error:" + x);
		}
	}
	public static void main(String [ ] args) {
		Deserializa asd = new Deserializa();
		Coordenada aaa = (Coordenada)asd.readObject("guardar.txt");
		System.out.println(aaa.getY());
	}
}