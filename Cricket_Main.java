package cricket;
import java.util.*;
public class Cricket_Main {
	static Scanner scanner=new Scanner(System.in);
	static String[] team={"india","srilanka","england","pakistan","new_zealand"};
    static String[] india={"Virat Kohli","Rohit Sharma","Rishbh pand","KL Rahul","SuryaKumar","Hardik Pandiya","Dinesh Karthik","Bhuvneshwar","Yuzvendra","Avesh Khan","Arshdeep singh"};
	static String[] srilanka= {"Dimuth Karunaratne","Kusal Perera","Jeevan Mendis", "Thisara Perera","Isuru Udana","Lahiru Thirumanne", "Kusal Mendis","Avishka fernando","Milinda Siriwardana","Jeffery Vendesay","Kasun Rajitha"};
	static String[] england= {"Charis Gayle","Darren Sammy","Hashim Amla","Ross Taylor","Morne Morkel","Tamim Iqbal","Kieron Polland","Thisara Perera","Grant Elliott","Adil Rashid","James Vince"};
	static String[] pakistan= {"Babar Azam","Mohammad Wasim","Shaheen Afridi","Mohammad razwan","Haris Rauf","Safaraz Ahmed","Shadeb khan","Iftihar Ahmed","Shadab Khan","Iftikhar Ahmed","hasan Ali"};
	static String[] new_zealand= {"Finn Allen","Kane Willamaason","Trent boult","Dane Clearver","Hanry Nicholls","Michael Rippon","Ben Seaes","Martin Guptil","Glenn Philips","colin Munro","Matt hanry"};
	static HashMap<String,String[]> teams=new HashMap<String,String[]>();
	public static void main(String[] args) {
		teams.put("india",india);
		teams.put("srilanka",srilanka);
		teams.put("england",england);
		teams.put("pakistan",pakistan);
		teams.put("new_zealand",new_zealand);
			Cricket_Main cricket=new Cricket_Main();
			
			    cricket.begin(teams);
	}
	
	
	
	void begin(HashMap<String,String[]> teams) {
		
		System.out.println("*   Teams   *");
		for(int i=0; i<team.length;i++) {
			System.out.println(i+1 +" ) "+ team[i]);
		}
		System.out.println("Select Your Team");
		int selection=scanner.nextInt();
		String selectTeam=team[selection-1];
		System.out.println("\n *   Your Team Players   *  "+selectTeam);
	    for(String m:teams.get(selectTeam)) {
			System.out.println("> "+m);
		}
	    int team2=(int)Math.floor(Math.random()*5);
	    while(selection-1==team2) {
	    	team2=(int)Math.floor(Math.random()*5);
	    }
	    	
	    //scanner.nextLine();
	    String oponenTeam=team[team2];
	    System.out.println(" \n   *Oponent Team is *"+oponenTeam);
	    for(String t:teams.get(oponenTeam)) {
	    	System.out.println("*  "+t);
	    }
	    GamePlaying play=new GamePlaying();
	    play.gamePlay(selectTeam,teams,oponenTeam);
	    
	    System.out.println("\n"+"Press   1  to Continue The MAtch     else End the MAtch");
	    int choise=scanner.nextInt();
	    while(choise==1) {
	    	begin(teams);
	    }
	    System.out.println("\n        Thank You   !     ");
	}
}
