import java.io.Serializable;

public class Student implements Serializable {
	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	String name;
	int currScore = 0;
	int highScore = 0;
	
	public Student() {
		this.name = "John Smith";
		this.currScore = 0;
		this.highScore = 0;
	}
	
	public Student(String name) {
		this.name = name;
		this.highScore = 0;
		this.currScore = 0;
	}
	
	public void setCurrScore(int currScore) {
		this.currScore = currScore;
	}
	
	public int getCurrScore() {
		return this.currScore;
	}
	
	public int getHighScore() {
		return this.highScore;
	}
	
	public void setHighScore() {
		if (this.currScore > this.highScore) {
			this.highScore = this.currScore;
		}
	}
}