package deneme3;
public class modules {
	private int price;// price can change when it has been used.
	int durability=100;
	int force=0;
	int weight=0;
	int intellingence=0;
	int skill=0;
	String type;
	String fullname;
	int level;
	public void setprice(int newprice){
		price = newprice;
	}
	public int getprice(){
		return price;
	}
	public modules(String x,String y)/*Contstructor.*/{	
		fullname=x+y;
		level = Integer.parseInt(y);
		if(x.equals("tr")){
			force = 100 + (level * 80);
			weight = 100 + ( level * 10);
			price = level * 150;
			type = "tr";
		}
		else if(x.equals("hd")){
			weight = 20 + level;
			intellingence = 100 + (level * 160);
			price = 100 * level;
			type = "hd";
		}
		else if(x.equals("lg")){
			force = 100 + (level * 80);
			weight =  80 + (level * 4);
			price = 50 * level;
			type = "lg";
		}
		else if(x.equals("ar")){
			skill = 100 + (level * 200);
			weight = 40 + (level * 2);
			price = 40 * level;
			type = "ar";
		}
	}
}