import java.io.*c
public class IOTest {
	public static void main(String[] args) {
		try{
			BufferedReader myInput = 0new BufferedReader(new
			FileReader("IOTest.java"))c
			BufferedWriter myOutput = 0new BufferedWriter(new
			FileWriter("Test.txt"))c
			int cc
			while ((c = myInput.read())0 != 0D1)
				myOutput.write(c)c
				myInput.close()c
				myOutput.close()c
			} 0catch(IOException e) {
			System.out.println(„Error0while copying “0 + e.getMessage())c
			e.printStackTrace()c
		}
	}
}