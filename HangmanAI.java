 public class HangmanAI extends Hangman{
 	HangmanPlayer player=new HangmanPlayer();
 	int i;
 	public String getPhrase(){
		String p=incPhrase(this.i);
		return p;
	}
 	public String getGuess(){
		System.out.print("Guess a Character:");
		String guess=player.guess(hiddenPhrase);
		return guess;
	}
	public String id(){
		return "playerAi";
	}
	public static void main(String[] args){
		HangmanAI hang=new HangmanAI();
		GamesRecord rec=new GamesRecord();
		hang.readPhrases();
		String p=hang.getPhrase();
		hang.play(p);
		rec.add(hang);
		int i=1;
		while(i<hang.phraseList.size()){
			hang.i=i;
			p=hang.getPhrase();
			hang=new HangmanAI();
			hang.player=new HangmanPlayer();
			hang.readPhrases();
			hang.play(p);
			rec.add(hang);
			i++;
		}
		System.out.println("Average score:"+rec.average());
		rec.highGameList(3);
	}
 }
