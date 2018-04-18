import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public abstract class Hangman extends Game {
	ArrayList<String> phraseList = new ArrayList<String>();
	String phrase;
	StringBuilder hiddenPhrase;	
	int score;
	String id;

	public int getScore(){
		return this.score;
	}
	public String getPlayerId(){
		return this.id;
	}
	public int compareTo(Object o){
		Hangman other=(Hangman) o;
		if (this.score>other.score){
			return 1;
			}
		if (this.score==other.score){
			return 0;
			}
		else{
			return -1;
			}
	}
	public void readPhrases(){
		try {
			File hangFile = new File("hangPhrases.txt");
			Scanner scanner = new Scanner(hangFile);
			while (scanner.hasNext()) {
		  		phraseList.add(scanner.nextLine());
			}
		}
		catch (FileNotFoundException exc){
			System.out.println(exc);
		}
	}
	public String randomPhrase(){
		Random rand=new Random();
		int num=rand.nextInt(phraseList.size());
		String phrase=phraseList.get(num);
		return phrase;
	}
	public String incPhrase(int i){
		String phrase=phraseList.get(i);
		return phrase;
	}
	public void generateHiddenPhrase(){
		StringBuilder hiddenPhrase=new StringBuilder(this.phrase);
		int i=0;
		while (i<phrase.length()){
			char ch=phrase.charAt(i);
			if (ch!=' '){
				hiddenPhrase.setCharAt(i,'*');
			}
			i++;	
		}
		this.hiddenPhrase=hiddenPhrase;
	}
	public abstract String getGuess();
	public abstract String getPhrase();
	public abstract String id();

	public StringBuilder processGuess(String guess){
		int x=0;
		char user=guess.charAt(0);
		while (x<phrase.length()){
			char ch=phrase.charAt(x);
			user=guess.charAt(0);
			if ((ch==user)||(ch==user-32)||(ch==user+32)){
				hiddenPhrase.setCharAt(x,ch);
				}	
			x++;	
			}
		return hiddenPhrase;
		}

	public void play(String phrase){
		System.out.println("Welcome to Hangman!");
		System.out.println("You can only type one letter or digit to guess the phrase");
		this.id=id();
		this.phrase=phrase;
		generateHiddenPhrase();
		System.out.println(this.hiddenPhrase);
		int count=0;
		while (hiddenPhrase.toString().contains("*")){
			String guess=getGuess();
			System.out.println();
			char user=guess.charAt(0);
			hiddenPhrase=processGuess(guess);
			count++;
			String hiddenP=hiddenPhrase.toString();
			if (!(hiddenP.contains(guess.toUpperCase())||(hiddenP.contains(guess.toLowerCase())))){
				System.out.println(guess+" is not in the phrase ");
			}
				System.out.println(hiddenPhrase);
			if (!(hiddenP.contains("*"))){
				System.out.println();
				System.out.println("Congrats You Won!");
				System.out.println("Number of guesses needed:"+count);
				System.out.println();
			}
		
		}	
		this.score=count;
	}
}
