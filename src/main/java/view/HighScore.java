package main.java.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileWriter;

public class HighScore {
	File file;
	String data;
	String highscore = "0";
	String username;
	HighScore(int stage){
	
		try {
			if(stage == 1) {
				File file = new File("C:\\Users\\Windows10\\eclipse-workspace\\COMP2042_CW_emily1381\\src\\main\\java\\resources\\highscore1.txt");
				this.file = file;
			}
			else if(stage == 2) {
				File file = new File("C:\\Users\\Windows10\\eclipse-workspace\\COMP2042_CW_emily1381\\src\\main\\java\\resources\\highscore2.txt");
				this.file = file;
			}
			else if(stage == 3) {
				File file = new File("C:\\Users\\Windows10\\eclipse-workspace\\COMP2042_CW_emily1381\\src\\main\\java\\resources\\highscore3.txt");
				this.file = file;
			}
			else if(stage == 4) {
				File file = new File("C:\\Users\\Windows10\\eclipse-workspace\\COMP2042_CW_emily1381\\src\\main\\java\\resources\\highscore4.txt");
				this.file = file;
			}
			
			if(file.createNewFile()) {
				System.out.println("HI SUCCESS");
			}
			else {
				System.out.println("FILE EXIST");
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public void writeFile(String data) {
		try {
			FileWriter Writer = new FileWriter(file);
			Writer.write(data);
			Writer.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void readFile() {
		try {
			Scanner reader =  new Scanner(file);
			while (reader.hasNextLine()) {
				this.data = reader.nextLine();	      
				separateString(this.data);

		      }
			reader.close();
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public void separateString(String string) {
		for(int i=0;i<string.length();i++) {
			if(!Character.isDigit(string.charAt(i))) {
				this.highscore = string.substring(0,i);
				this.username = string.substring(i);
				break;
			}
			
		}
		
	}
	

}
