package deneme3;

import java.util.Scanner;

import enigma.core.Enigma;

public class gamerun { 
	
	public void printScreen(){
		System.out.print("Week: ");
		System.out.print("	Robot/Credit: ");
		System.out.print("	T1: ");
		System.out.print("	T2: ");
		System.out.print("	T3: ");
		System.out.print("	T4: ");
		System.out.print("	T5: ");
		System.out.println("	T6: ");
		
		System.out.println("--- Team1: Modules ---");
		System.out.println("m01."+  "m02."+  "m03"+  "m04."+  "m05." );
		System.out.println("m06."+  "m07."+  "m08"+  "m09."+  "m10." );
		System.out.println("m11."+  "m12."+  "m13"+  "m14."+  "m15." );
		System.out.println("m16."+  "m17."+  "m18"+  "m19."+  "m20." );
		
		System.out.println("--- Team1: Robots ---");
		System.out.print("r1: ");
		
		System.out.println("--- Games (Registering) ---");
		System.out.println("Chess: "+  "	Run: "+  "	Sumo: "+  "		PingPong: ");
		System.out.println("Team1: ");
		
		System.out.println("--- Games (Results) ---");
		System.out.println("--- RoboChess : ");
		
		System.out.println("--- RoboRun : ");
		
		System.out.println("--- RoboSumo : ");
		
		System.out.println("--- RoboPingPong : ");
		
	}
	
	
	

	public void gamerun(){
		Humanteam t1 = new Humanteam();
		parcingcommand(t1);
	}
	public void parcingcommand(Humanteam t1){
		enigma.console.Console cn;
		cn=Enigma.getConsole("robot");
	
		while(true){
			System.out.print("Command > : ");//Taking command from user
			Scanner input = new Scanner(System.in);
			String command = input.nextLine();
			String p =  command.substring(0,2);//Ilk komutlarý algýlamak için gerekli deðer.
			if(command.length() == 6  ){
				String a = command.substring(3, 5);
				String b = command.substring(5);
				/*humanteam t1 yeri*/
				modules parça = new modules(a , b);
				/*modules parça yeri*/
				if(p.equals("by") ){
					t1.buy(parça);
					System.out.println(t1.getcredits());
				}
				else if(p.equals("sl")){
					t1.sell(parça);
					System.out.println(t1.getcredits());}
			}
			else if(command.length() == 5){  
				int robotnumber = Integer.parseInt(command.substring(4));//Feriþtah hoca
				if(p.equals("sl"))
					t1.sell2(robotnumber);
				/*else if(p.equals("++")){}*/
				else if(p.equals("--"))
					t1.dividerobot(robotnumber,t1);//Hangi takýmýn gideceðini düzenlemeliyiz.whichteam.dividerobot olabilir.(robotnumber,whichteam)olmalý.
			}
			else if(command.length() == 9 && p.equals("ch")){
				int robot = Integer.parseInt(command.substring(4, 5));
				int part = Integer.parseInt(command.substring(7, 9));//02 diye bir int deðer olabilir mi hocaya sor.
				t1.changerelatedmodule(robot,part,t1);//whichteam t1 yerine geçecektir.
			}
			else if(p.equals("++") && command.length() == 23){
				int robot = Integer.parseInt(command.substring(4, 5));
				String parça2 = command.substring(8, 10);
				int level    = Integer.parseInt(command.substring(10, 11));
			}
			else if(command.length() == 4 )
			{
				int  team  = Integer.parseInt(command.substring(3));
				if(p.equals("ls")){
					System.out.println(team);
				}

			}
			input.close();
		}
	}
}
