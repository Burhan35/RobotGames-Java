package deneme3;

public class Main {
	public static void main(String[] args){//Parsing komutlar�n� d��ar� al.//En sonunda register yap�lacag�ndan bunlar rungame i�inde olmal�lar(constractor i�inde).
		gamerun name = new gamerun();
		Humanteam t1 = new Humanteam();
		name.parcingcommand(t1);//bu komut sat�r� kald�r�lacak.
	}

}
