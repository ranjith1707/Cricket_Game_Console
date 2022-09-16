package cricket;
import java.util.*;
public class GamePlaying {
	static Scanner input=new Scanner(System.in);
	final static int aponentScore=(int)Math.floor(Math.random()*(60-20+1)+20);
	static int[] runs= {0,0,0,0,0,0,0,0,0,0,0};
    static int[] runs2= {0,0,0,0,0,0,0,0,0,0,0};
	
	void gamePlay(String selectTeam, HashMap<String,String[]> teams,String oponent){
		int[] sixA=new int[11];
		int[] fourA=new int[11]; 
	   String[] out= new String[11];
	   
	   int[] six2=new int[11];
		int[] four2=new int[11]; 
	   String[] out2= new String[11];
	   
	   
	   System.out.println("Select Overs");
	  int over=input.nextInt();
	  int run;
	  int building=0;
	  int totalA=0;
	  int totalB=0;
	  int four=0; 
	  int six=0;
	 String[] battingteam=teams.get(selectTeam);
	 String[] boulingTeam=teams.get(oponent);
	 
	 drop:
	 for(int k=1;k<=2; k++) {
		 int count=0;
		 int player=0;
		 int score=0;
	  for (int i=1; i<=over; i++) {
		  
		  for (int j=1;  j<=6; j++) {
			  System.out.println("\n press  Enter");
			  String a=input.nextLine();
			  System.out.println("--  --  --  --  --  --  --  -- --  --  --  ");
			  if(k==1) {
			  System.out.println(">  "+boulingTeam[building]+"'S over  \n  "+">  "+i +"  over  and "+j+" Ball \n "+">   BatsMan is "+battingteam[player]);
			  System.out.println();
			  }
			  else {
				  System.out.println(">  "+battingteam[building]+"'S over  \n  "+">  "+i +"  over  and "+j+" Ball \n "+">   BatsMan is "+boulingTeam[player]);
				  System.out.println();
			  }
			  run=(int)Math.floor(Math.random()*7);
			  if(k==1) {
			  if(run!=5) {
			  score+=run;
			    totalA+=run;
			  }
			  }
			  else {
				  if(run!=5) {
					  score+=run;
					    totalB+=run;
					  }
			  }
			  if(run==0) {
				  count++;
				  System.out.println("Not Run   !");
			  }
			  else if(run>0) {
				  switch(run) {
				  case 1:System.out.println("    >  "+run+ "  Run   <  ");
				  
				  break;
				  case 2:System.out.println("    >  "+run+ "  Run   <  ");
				 
				  break;
				  case 3:System.out.println("    >  "+run+ "  Run   <  ");
				 
				  break;
				  case 4:System.out.println("    >  "+run+ "  Super Shot  <  ");
				  four++;
				 
				  break;
				  case 5:System.out.println("    !  No Ball     !");
				  break;
				  case 6:System.out.println("   >  "+run+ "  Runs    WonderFul  Shot   <");
				     six++;
				 
				  }
			  }
			  if(count>1) {
				  if(k==1) {
				  System.out.println(battingteam[player]+"    Out   !");
				  out[player]=battingteam[player];
				  runs[player]=score;
				  }
				  else {
					  System.out.println(boulingTeam[player]+"   Out   !");
					  out2[player]=boulingTeam[player];
					  runs2[player]=score;
				  }
				  
				  if(k==1) {
				  sixA[player]=six;
				  fourA[player]=four;
				  }
				  else {
					  six2[player]=six;
					  four2[player]=four;
				  }
				  six=0;
				  score=0;
				  four=0;
				  count=0;
				  System.out.printf("%20s %15s %15s %15s %15s","Players"," Runs","Six","Four","Singles");
					System.out.println();
					if(k==1) {
					
						System.out.printf("%20s %15s %15s %15s %15s",battingteam[player],runs[player],sixA[player],fourA[player],(runs[player]-((sixA[player]*6)+(fourA[player]*4))));
						if(Arrays.equals(battingteam, out)) {
							System.out.println("ALL Players Are Out  TEAM Change  ! ");
							continue drop;
							
						}
					}
					else {
						
						System.out.printf("%20s %15s %15s %15s %15s",boulingTeam[player],runs2[player],six2[player],four2[player],(runs2[player]-((six2[player]*6)+(four2[player]*4))));
						if(Arrays.equals(boulingTeam, out2)) {
							System.out.println("ALL Players Are Out MAtch is  ENDED  ! ");
							break drop;
						}
					}
						System.out.println();
					
			  System.out.println("Choose playe for Next BatsMan  "); 
			   player=input.nextInt();
			   --player;
			   boolean contains;
			   if(k==1) {
			    contains = Arrays.stream(out).anyMatch(battingteam[player]::equals);
			   while(contains) {
				   System.out.println(battingteam[player]+" Already Out  Select Onather player");
				   player=input.nextInt();
				   --player;
				  contains = Arrays.stream(out).anyMatch(battingteam[player]::equals);
			   }
			   }
			   else {
				    contains = Arrays.stream(out2).anyMatch(boulingTeam[player]::equals);
				   while(contains) {
					   System.out.println(boulingTeam[player]+" Already Out  Select Onather player");
					   player=input.nextInt();
					   --player;
					  contains = Arrays.stream(out2).anyMatch(boulingTeam[player]::equals);
			   }
			  
		  }
			  
		  }
		  
		  
		 }
		  building++;
		  if(building>10) {
			  building=0;
		  }
		  if(k==1) {
		  runs[player]=score;
		  sixA[player]=six;
		  fourA[player]=four;
		  }
		  else {
			  runs2[player]=score;
			  six2[player]=six;
			  four2[player]=four;
		  }
		  
		  System.out.println("\n  OVER CHANGE   \n");
		  System.out.printf("%20s %15s %15s %15s %15s","Players"," Runs","Six","Four","Singles");
			System.out.println();
			if(k==1)
			System.out.printf("%20s %15s %15s %15s %15s",battingteam[player],runs[player],sixA[player],fourA[player],(runs[player]-((sixA[player]*6)+(fourA[player]*4))));
			else
				System.out.printf("%20s %15s %15s %15s %15s",boulingTeam[player],runs2[player],six2[player],four2[player],(runs2[player]-((six2[player]*6)+(four2[player]*4))));
			System.out.println();
			
	  }
	  six=0;
	  score=0;
	  four=0;
	  count=0;
	  if(k==1) 
		  printScore(runs,aponentScore,selectTeam,battingteam,out,sixA,fourA);
	  System.out.println();
	  if(k==1) 
	  System.out.println("    Team change     "+oponent+ "  is Batting");
			
	 }
	 if(totalA>totalB)
		 System.out.println( "  You  Win   The Match");
	 else if(totalA==totalB)
		 System.out.println("Match Draw");
	 else
		 System.out.println("You Loss  ");
	 
	 printScore(runs,aponentScore,selectTeam,battingteam,out,sixA,fourA);
	 printScore(runs2,aponentScore,selectTeam,boulingTeam,out2,six2,four2); 
	}
	  
	
	  
   
	
	
	void printScore(int[] runs,int aponentScore,String selectTeam,String[] battingteam,String[] out,int[] sixA, int[] fourA){
		System.out.println("______________________________________________________________________________________\n");
		int battingScore=0;
		for(int i:runs) {
			battingScore+=i;
		}
		
		System.out.println();
		
		System.out.printf("%20s %15s %15s %15s %15s","Players"," Runs","Six","Four","Singles");
		System.out.println();
		for(int i=0; i<battingteam.length; i++) {
			System.out.printf("%20s %15s %15s %15s %15s",battingteam[i],runs[i],sixA[i],fourA[i],(runs[i]-((sixA[i]*6)+(fourA[i]*4))));
			System.out.println();
		}
		System.out.println("___________________________________________________\n Wickets \n ");
		for(int i=0; i<11; i++) {
			if(out[i]==null)
				continue;
			System.out.println(out[i]+"\t is Out");
		}
		System.out.println("Your Score is  :"+battingScore);
	}
	
}
