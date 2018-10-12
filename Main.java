package deneme3;

public class Main {
	public static void main(String[] args){//Parsing komutlarýný dýþarý al.//En sonunda register yapýlacagýndan bunlar rungame içinde olmalýlar(constractor içinde).
		gamerun name = new gamerun();
		Humanteam t1 = new Humanteam();
		name.parcingcommand(t1);//bu komut satýrý kaldýrýlacak.
	}

}
