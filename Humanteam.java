package deneme3;
public class Humanteam {

	public modules inventory[] = new modules[20];
	public robot teamrobots[] = new robot[9];//r1 = teamrobots[0] ... for example
	private int credits=1500;
	public int robotsayaci;
	public int getcredits(){
		return credits;
	}
	public void setprice(int newcredits){
		credits = newcredits;
	}
	public Humanteam(){//Contractor.
		for (int i = 0; i < inventory.length; i++) {
			inventory[i]=null;
		}
		for (int j = 0; j < 9; j++) {
			teamrobots[j]=null;
		}
	}
	public String buy(modules modulismi){
		for(int i=0; i < inventory.length; i++){//Yetersiz Credits demeli unutmamalýyýz.
			if(inventory[i] == null && credits - modulismi.getprice() >= 0){
				inventory[i] = modulismi;
				System.out.println(inventory[i].fullname + "-" + inventory[i].durability + " Weight:" + inventory[i].weight);
				credits = credits - modulismi.getprice();//Price is private value.
				return "Success";
			}else if(credits - modulismi.getprice() < 0)
			{System.out.println("Not Enough Credits!");
			return "Not Enough Credits!";}
		}
		return "There is an error fix it dumb!";
	}
	public void sell(modules modulismi){
		for(int i=0; i < inventory.length; i++){
			if(inventory[i] == modulismi){
				inventory[i]=null;
				credits = credits + modulismi.getprice()*modulismi.durability/200;//Price is private value.
				break;
			}
		}
	}
	public void sell2(int robotnumber){
		for (int j = 0; j < 4; j++) {
			credits = credits + teamrobots[robotnumber-1].robotmodules[j].getprice()*teamrobots[robotnumber-1].robotmodules[j].durability/200;
		}

	}
	public void controlmodules(modules module1,int whichrobot, Humanteam whichteam){//hoca bakacak.Modulleri yerleþtirme ve kontrol etme.
		//Eðer hepsi true ise bir tane robot varmýþ varsay.
		if(module1.type.equals("hd") && whichteam.buy(module1).equals("Success")){
			whichteam.buy(module1);//Satýn alma baþarýlý ise burayý geç.
			whichteam.teamrobots[whichrobot-1].robotmodules[0] = module1;
			whichteam.teamrobots[whichrobot-1].isrobotparts[0] = true;
		}else if(module1.type.equals("tr") && whichteam.buy(module1).equals("Success")){
			whichteam.buy(module1);//Satýn alma baþarýlý ise burayý geç.
			whichteam.teamrobots[whichrobot-1].robotmodules[1] = module1;
			whichteam.teamrobots[whichrobot-1].isrobotparts[1] = true;
		}else if(module1.type.equals("ar") && whichteam.buy(module1).equals("Success")){
			whichteam.buy(module1);//Satýn alma baþarýlý ise burayý geç.
			whichteam.teamrobots[whichrobot-1].robotmodules[2] = module1;
			whichteam.teamrobots[whichrobot-1].isrobotparts[2] = true;
		}else if(module1.type.equals("lg") && whichteam.buy(module1).equals("Success")){
			whichteam.buy(module1);//Satýn alma baþarýlý ise burayý geç.
			whichteam.teamrobots[whichrobot-1].robotmodules[3] = module1;
			whichteam.teamrobots[whichrobot-1].isrobotparts[3] = true;
		}else if(whichteam.buy(module1).equals("Not Enough Credits!")){
			System.out.println("Not Enough Credits!");
		}
	}
	public void dividerobot(int whichrobot, Humanteam whichteam){
		int whichpartofrobot=0;//robotun hangi parçasý divide edilip env. aktarýlacak.
		for(int i=0; i < inventory.length; i++){//Yetersiz Credits demeli unutmamalýyýz.
			if(inventory[i] == null){
				inventory[i] = whichteam.teamrobots[whichrobot-1].robotmodules[whichpartofrobot];
				whichpartofrobot++;
			}else if(whichpartofrobot == 0){System.out.print("Envanter is full!");}
		}
		for (int j = 0; j < 4; j++) {
			whichteam.teamrobots[whichrobot-1].robotmodules[j] = null;
			whichteam.teamrobots[whichrobot-1].isrobotparts[j] = false;
		}		

	}
	public void changerelatedmodule(int whichrobot,int whichenvanterslot,Humanteam whichteam){//findmodule in envanter diye bir fonk. olmalý
		modules temp = new modules("tr","1");//hocam aþagýdaki tempe eþitþeme olacagýndan burada tanýmladýgým sýkýntý çýkarýr mý?
		if(whichteam.inventory[whichenvanterslot-1].type.equals("hd")){
		    temp = whichteam.teamrobots[whichrobot-1].robotmodules[0];
		    whichteam.teamrobots[whichrobot-1].robotmodules[0] = whichteam.inventory[whichenvanterslot-1];
		    whichteam.inventory[whichenvanterslot-1] = temp;
		}else if(whichteam.inventory[whichenvanterslot-1].type.equals("tr")){
		    temp = whichteam.teamrobots[whichrobot-1].robotmodules[1];
		    whichteam.teamrobots[whichrobot-1].robotmodules[1] = whichteam.inventory[whichenvanterslot-1];
		    whichteam.inventory[whichenvanterslot-1] = temp;
		}else if(whichteam.inventory[whichenvanterslot-1].type.equals("ar")){
		    temp = whichteam.teamrobots[whichrobot-1].robotmodules[2];
		    whichteam.teamrobots[whichrobot-1].robotmodules[2] = whichteam.inventory[whichenvanterslot-1];
		    whichteam.inventory[whichenvanterslot-1] = temp;
		}else if(whichteam.inventory[whichenvanterslot-1].type.equals("lg")){
		    temp = whichteam.teamrobots[whichrobot-1].robotmodules[3];
		    whichteam.teamrobots[whichrobot-1].robotmodules[3] = whichteam.inventory[whichenvanterslot-1];
		    whichteam.inventory[whichenvanterslot-1] = temp;
		}else{
			System.out.println("This envanter slot is empty,Please use another envanter slot!");
		}
		
	}
}
