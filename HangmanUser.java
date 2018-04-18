import java.util.Scanner;
public class HangmanUser extends Hangman{
	public String getPhrase(){
		String p=randomPhrase();
		return p;
	}
	public String getGuess(){
		System.out.print("Guess a Character:");
		Scanner scanner=new Scanner(System.in);
		String guess=scanner.nextLine();
		return guess;
	}
	public String id(){
		System.out.print("Enter a player id:");
		Scanner scanner=new Scanner(System.in);
		String id=scanner.nextLine();
		return id;
	}
	public static void main(String[] args) {
		HangmanUser hang=new HangmanUser();
		GamesRecord rec=new GamesRecord();
		hang.readPhrases();
		String p=hang.getPhrase();
		hang.play(p);
		rec.add(hang);
		System.out.print("Do you want to play again (y/n):");
		Scanner scanner=new Scanner(System.in);
		String result=scanner.nextLine();
		do{
		while (result.equals("y")||result.equals("Y")){
			p=hang.getPhrase();
			hang=new HangmanUser();
			hang.readPhrases();
			hang.play(p);
			rec.add(hang);
			System.out.print("Do you want to play again (y/n):");
			scanner=new Scanner(System.in);
			result=scanner.nextLine();
			}
		}while(!(result.equals("n")||result.equals("N")));
		System.out.println("Average score:"+rec.average());
		System.out.println("Average score of the player:"+rec.average("bob"));
		rec.highGameList(2);
	}
} 