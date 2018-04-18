import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class HangmanAi {
	public static StringBuilder generateHiddenPhrase(String phrase){
			StringBuilder hiddenPhrase= new StringBuilder(phrase);
			int i=0;
			while (i<phrase.length()){
				char ch=phrase.charAt(i);
				if (ch!=' '){
					hiddenPhrase.setCharAt(i,'*');
				}
				i++;	
			}
			return	hiddenPhrase;
		}
						
	public static StringBuilder	 processGuess(String phrase,StringBuilder hiddenPhrase,String guess){
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

	public static void main(String [] args) {
		ArrayList gList= new ArrayList();
		int games=0;
		int totalAt=0;
		int i=0;

		ArrayList<String> phraseList = new ArrayList<String>();
		try {
			File hangFile = new File("hangPhrases.txt");
			Scanner scanner = new Scanner(hangFile);

		while (scanner.hasNext()) {
		  phraseList.add(scanner.nextLine());
			
			}
		}
		catch (FileNotFoundException exc) {
			System.out.println(exc);
		}

	while(i<phraseList.size()){
		String phrase=phraseList.get(i);
		i++;
		StringBuilder hiddenPhrase=generateHiddenPhrase(phrase);
		HangmanPlayer player=new HangmanPlayer();
		System.out.println("Welcome to Hangman!");
		System.out.println(hiddenPhrase);

		int x=0;
		int count=0;

		while (hiddenPhrase.toString().contains("*")){
			System.out.print("Guess a Character:");
			String guess=player.guess(hiddenPhrase);
			System.out.println();
			char user=guess.charAt(0);

		hiddenPhrase=processGuess(phrase,hiddenPhrase,guess);
		count++;

		String hiddenP=hiddenPhrase.toString();
		if (!(hiddenP.contains(guess.toUpperCase())||(hiddenP.contains(guess.toLowerCase())))){
			System.out.println(guess+" is not in the phrase ");
			}

			System.out.println(hiddenPhrase);	

		if (!(hiddenP.contains("*"))){
			games=games+1;
			totalAt=totalAt+count;
			System.out.println();
			System.out.println("Congrats You Won!");
			System.out.println("Number of guesses needed:"+count);
			System.out.println();
				}
			
			}
		}
	double avgGuess=totalAt/games;
	System.out.println("Average number of guesses needed for all phrases:"+avgGuess);
	}
}
