package Projet;
import java.util.*;

public class CpteEpargne extends Compte {
    // classe Compte+ce qui suit
    private double taux;

    public CpteEpargne() {
        // appel constructeur parent Compte(String Epargne)
		super("Epargne");
		taux = contrôleTaux();
	 }

     private double contrôleTaux() {
		double tmp;
        Scanner lectureClavier = new Scanner(System.in);
		do {
			System.out.print("Taux de placement :     ");
			tmp = lectureClavier.nextDouble();
		} while (tmp < 0);
		return tmp;
	}
    public  void afficherCpte()   {
        // appel fonction afficherCompte() de la classe parente
		super.afficherCompte();
		System.out.println(" Taux d'epargne du compte :  " + taux);
	}
	public double quelTaux()	{
		return taux;
	}
}
