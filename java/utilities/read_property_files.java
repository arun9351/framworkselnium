package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class read_property_files {

	public static void main(String[] args) throws IOException {
	

		FileReader f1 = new FileReader(System.getProperty("user.dir")+ "\\src\\test\\resources\\configurefile\\configure.properties");
		
		
		Properties p1 = new Properties();
		p1.load(f1);
		System.out.println(p1.getProperty("browser"));
	}

}
