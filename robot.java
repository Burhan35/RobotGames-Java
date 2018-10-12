package deneme3;

public class robot{
	public modules[] robotmodules = new modules[4];
	boolean[] isrobotparts = new boolean[4];
	public robot(){
		for (int i = 0; i < 4; i++) {
			robotmodules[i]=null;
			isrobotparts[i]=false;
		}
	}
	public void controlrobot(){//If control robot has an error robot can not creating.
		if(!(robotmodules[0].type.equals("tr"))){
			System.out.println("Modül Type Error! TORSO");
		}else if(!(robotmodules[1].type.equals("hd"))){
			System.out.println("Modül Type Error! HEAD");
		}else if(!(robotmodules[2].type.equals("ar"))){
			System.out.println("Modül Type Error! ARMS");
		}else if(!(robotmodules[3].type.equals("lg"))){
			System.out.println("Modül Type Error! LEGS");
		}
	}
	public void makingrobot(modules module1,modules module2,modules module3,modules module4,int whichrobot, Humanteam whichteam){
		whichteam.controlmodules(module1,whichrobot,whichteam);
		whichteam.controlmodules(module2,whichrobot,whichteam);
		whichteam.controlmodules(module3,whichrobot,whichteam);// ++ nýn envanterden çekilmemiþ hali.
		whichteam.controlmodules(module4,whichrobot,whichteam);
	}
	
}
