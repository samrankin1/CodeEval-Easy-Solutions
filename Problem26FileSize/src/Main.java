import java.io.File;

public class Main {

	public static void main(String[] args) {
		File file = new File(args[0]); // the first argument will be the path to a file
		System.out.println(file.length()); // print the size of the file
	}

}
