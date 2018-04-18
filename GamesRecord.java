import java.util.ArrayList;
import java.util.Collections;
public class GamesRecord{
	ArrayList<Game> gameList = new ArrayList<Game>();
	public void add(Game g){
		gameList.add(g);
	}
	public float average(){
		int i=0;
		float s=0;
    	while (i<gameList.size()){
    		s=gameList.get(i).getScore()+s;
    		i++;
    	}
    	float avg=s/gameList.size();
    	return avg;
	}
	public float average(String playerid){
		int i=0;
		float s=0;
		int x=0;
		while (i<gameList.size()){
			if (gameList.get(i).getPlayerId().equals(playerid)){
				s=gameList.get(i).getScore()+s;
				x++;
			}
			i++;
		}
		float avg=s/x;
    	return avg;
	}
	public void highGameList(int n){
    		Collections.sort(gameList);
    		ArrayList<String> highGameList = new ArrayList<String>();
    		int i=0;
    		while(i<n){
    			highGameList.add(gameList.get(i).getPlayerId()+":"+gameList.get(i).getScore());
    			i++;
    		}
    		System.out.println(highGameList);
    	}
}