import java.util.Scanner;

public class JeuDeBowling {
	private static int[] lancers;
	private int lancerActuel;

	public JeuDeBowling() {
		JeuDeBowling.lancers = new int[21];
	}

	public static void main(String[] args) {
		JeuDeBowling b1 = new JeuDeBowling();

		System.out.println("Saisir les entrees");
		for(int i=0; i<lancers.length; i++){
			Scanner sc = new Scanner(System.in);
			String str = sc.nextLine();
			b1.lancer(str);
			System.out.println("Score: " + b1.calculResultat());
		}
	}
	public int calculResultat() {
		int score = 0;
		int tour = 0;

		for (int i = 0; i < 10; i++) {
			if (strike(tour)) {
				score += 10 + strikeSuppl(tour);
				tour++;
			} else if (spare(tour)) {
				score += 10 + spareSuppl(tour);
				tour += 2;
			} else {
				score += sommeLancers(tour);
				tour += 2;
			}
		}

		return score;
	}
	public void lancer(String  value) {
		int valeur;
		if(value.equals("X")){
			valeur = 10;
		}else if(value.equals("/")){
			valeur = 10 - lancers[lancerActuel-1];
		}else if (value.equals("-")){
			valeur = 0;
		}else{
			valeur = Integer.valueOf(value);
		}
		lancers[lancerActuel++] = valeur;
	}

	private boolean strike(int tour) {
		return lancers[tour] == 10;
	}

	private boolean spare(int tour) {
		return sommeLancers(tour) == 10;
	}

	private int sommeLancers(int tour) {
		return lancers[tour] + lancers[tour+1];
	}


	private int strikeSuppl(int tour) {
		return sommeLancers(tour+1);
	}

	private int spareSuppl(int tour) {
		return lancers[tour+2];
	}
}