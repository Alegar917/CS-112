import java.util.ArrayList;
// https://docs.google.com/document/d/1-c8F9UspEfl22MXFLwabNAZpjWDZwS6N_bj0WFVk8X0/edit?usp=sharing
class HangmanPlayer{
	private int a=0;
	private int b=0;
	private int c=0;
	private int d=0;
    private String guesses="iaeroutnmswydchlgznrbfkjpqvx";
    private String tWords="isattoifweam";
    private String trWords="youarethegotandbutforcup";
    private String fWords="thingsmakefullrockwalkdownthey";
    ArrayList vList= new ArrayList();


    String guess(StringBuilder hiddenPhrase) { 
    	String s=hiddenPhrase.toString();
 		if (s.contains("**")){
 			while(a<tWords.length()){
		 		char ph=tWords.charAt(a);
		        String p=Character.toString(ph);
	 			a++;
	 			while ((vList.contains(p))&&(a<tWords.length())){
					ph=tWords.charAt(a);
		        	p=Character.toString(ph);
		        	a++;
				}
	 			vList.add(p.toLowerCase());
				vList.add(p.toUpperCase());
	 			return p;
	 		}
	 	}
		if (s.contains("***")){
 			while(b<trWords.length()){
	 			char ph=trWords.charAt(b);
		        String p=Character.toString(ph);
		        b++;
		        while ((vList.contains(p))&&(b<trWords.length())){
					ph=trWords.charAt(b);
		        	p=Character.toString(ph);
		        	b++;
				}
	 			vList.add(p.toLowerCase());
				vList.add(p.toUpperCase());
	 			return p;
 			}
 		}
		if (s.contains("****")){
	 		while(c<fWords.length()){
		 		char ph=fWords.charAt(c);
			    String p=Character.toString(ph);
			    c++;
			    while ((vList.contains(p))&&(c<fWords.length())){
					ph=fWords.charAt(c);
			        p=Character.toString(ph);
			        c++;
				}
		 		vList.add(p.toLowerCase());
				vList.add(p.toUpperCase());
		 		return p;
	 		}
 		}
    	char ph=guesses.charAt(d);
	    String p=Character.toString(ph);
	    d++;
	    while (vList.contains(p)){
			ph=guesses.charAt(d);
	        p=Character.toString(ph);
	        d++;
		}
	    vList.add(p.toLowerCase());
		vList.add(p.toUpperCase());
	    return p;
    }

}