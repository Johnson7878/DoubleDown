import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FirstJavaProgram {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		Student sob = new Student("John Smith");
		//Testing functions of Student Class
		System.out.println("Student Name: "+sob.name);
		System.out.println("Current Score: "+sob.currScore);
		System.out.println("High Score: "+sob.highScore);
		sob.setCurrScore(10);
		sob.setHighScore();
		System.out.println("Student Name: "+sob.name);
		System.out.println("Current Score: "+sob.currScore);
		System.out.println("High Score: "+sob.highScore);
		sob.setCurrScore(5);
		sob.setHighScore();
		System.out.println("Student Name: "+sob.name);
		System.out.println("Current Score: "+sob.currScore);
		System.out.println("High Score: "+sob.highScore);
		//Outputting detailed student file data into a txt file
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Students.txt"));
		out.writeObject(sob);
		//Creating a custom student to add to the file
		Student sob2 = new Student("Mary Sue");
		sob2.setCurrScore(20);
		sob2.setHighScore();
		sob2.setCurrScore(10);
		sob2.setHighScore();
		out.writeObject(sob2);
		//Reading in from text file
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("Students.txt"));
		Student sobReadIn = (Student) in.readObject();
		System.out.println("Student name 1 is " + sobReadIn.name);
		Student sobReadIn2 = (Student) in.readObject();
		System.out.println("Student name 2 is " + sobReadIn2.name);
	}

}