public abstract class Game implements Comparable{
	int score;
	String  playerId;

	public abstract int getScore();
	public abstract String getPlayerId();

	public int compareTo(Object o){
		Game other=(Game) o;
		if (this.score<other.score){
			return 1;
			}
		if (this.score==other.score){
			return 0;
			}
		else{
			return -1;
			}
	}
}