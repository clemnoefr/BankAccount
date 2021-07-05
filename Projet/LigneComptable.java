package Projet;
import java.util.*;
public class LigneComptable {
    private String motif, modePaiement, date;
    private double somme;
    
	public LigneComptable()	{
        Scanner lectureClavier = new Scanner(System.in);
        System.out.print("Entrer la somme à créditer (+) ou débiter (-) : ");
        somme = lectureClavier.nextDouble();
        System.out.print("Date de l'opération [jj/mm/an] ");
        date = lectureClavier.next();
        motif = contrôleMotif();
        modePaiement = contrôleMode();
        }

    private String contrôleMode() {
                Scanner lectureClavier = new Scanner(System.in);
        String tmpS = "";
        char tmpc ;
        do {
            System.out.print("Mode [C(B), N(° Cheque), V(irement ) ]  : ");
            tmpc = lectureClavier.next().charAt(0);
        } while ( tmpc != 'C' && tmpc != 'N' && tmpc != 'V');
        switch (tmpc) {
            case 'C' : tmpS = "CB";
            break;
            case 'N' : tmpS = "Cheque";
            break;
            case 'V' : tmpS = "Virement";
            break;		
        }
        return tmpS;
    }

    private String contrôleMotif() {
        Scanner lectureClavier = new Scanner(System.in);
        String tmpS = "";
        char tmpc ;
        do {
            System.out.print("Motif de l'operation [S(alaire),");
            System.out.print(" L(oyer), A(limenation), D(ivers)] : ");
            tmpc = lectureClavier.next().charAt(0);
        } while ( tmpc != 'S' && tmpc != 'L' && tmpc != 'A' && tmpc != 'D');
        switch (tmpc) {
            case 'S' : tmpS = "Salaire";
            break;
            case 'L' : tmpS = "Loyer";
            break;
            case 'A' : tmpS = "Alimentation";
            break;		
            case 'D' : tmpS = "Divers";
            break;
        }
        return tmpS;
    }
    public void créerLigneComptable(){
        Scanner lectureClavier = new Scanner(System.in);
        System.out.println("merci d'entrer la somme à créditer (+) ou débiter (-) ");
        somme = lectureClavier.nextDouble();
        System.out.println("merci d'entrer la date de l'opération JJ/MM/AAAA ");
        date=lectureClavier.next();
        System.out.print("Entrer le motif  [S(alaire), L(oyer), A(limenation), D(ivers)] : ");
	  	motif = lectureClavier.next();
		System.out.print("Entrer le mode [C(B), N(° Cheque), V(irement ) ] : ");
	  	modePaiement = lectureClavier.next();

    }

    public void afficherLigne(){
        if (somme < 0) 
		System.out.print("Debiter : "+somme);
		else
    	System.out.print("Crediter : "+somme);
		System.out.println(" le : "+ date +" motif  : " +motif+ " mode : "+modePaiement);
    }
    // accéder aux données
    public String quelMotif(){
        return motif;
    }
    public String quelMode(){
        return modePaiement;
    }
   
    public String quelleDate(){
        return date;
    }
    public double quelleSomme(){
        return somme;
    }

}
