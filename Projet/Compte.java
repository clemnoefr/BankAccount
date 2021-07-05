package Projet;
import java.util.*;

public class Compte {

    private String typeCpte="", numeroCompte="";        
    private int nbLigneReel;
   
    private double valeurCourante=0.0;
    private LigneComptable [] ligne;
    public static final int NBLigne=10;
    public Compte(){
        

        Scanner lectureClavier = new Scanner(System.in);
       
        typeCpte=controleType();
        System.out.println("Numéro du compte : ");
        numeroCompte = lectureClavier.next();
        valeurCourante = controleValeur(); 
        ligne=new LigneComptable[NBLigne];
        nbLigneReel = -1;        
    }

    public Compte(String type){
        Scanner lectureClavier = new Scanner(System.in);
        if (type.equalsIgnoreCase("Epargne")) {
            typeCpte = type;
            System.out.print("Numéro du compte : ");
            numeroCompte = lectureClavier.next();
            valeurCourante = controleValeur();   
            nbLigneReel = 0 ;  
            ligne=new LigneComptable[NBLigne];
            nbLigneReel = -1; 
        }       
    }
    // création compte
    public void creationCompte(){
        

        Scanner lectureClavier = new Scanner(System.in);
       
        typeCpte=controleType();
        System.out.println("Numéro du compte : ");
        numeroCompte = lectureClavier.next();
        valeurCourante = controleValeur();        

        nbLigneReel = 0;        
    }

      // afficher le compte
    public void afficherCompte(){
        
        System.out.println("Le compte n° : " + numeroCompte + " est un compte "+typeCpte);
	    if (nbLigneReel > 0){
            for(int i=0; i<nbLigneReel; i++){
                System.out.println(ligne[i]);
            }
        };
        System.out.println("Valeur courante : " + valeurCourante);
        if(valeurCourante<0) System.out.print("Compte débiteur");
    }

    public void créerLigne(){
       
        
        if(nbLigneReel <= NBLigne){
            ligne[nbLigneReel+1]= new LigneComptable();
            //ligne[nbLigneReel+1].créerLigneComptable();
            
            
            nbLigneReel++;
        }
        if(nbLigneReel > NBLigne){
            decalerLesLignes();
            
            ligne[nbLigneReel+1]= new LigneComptable();
            nbLigneReel--;
        }
        valeurCourante = valeurCourante + ligne[nbLigneReel].quelleSomme();
        System.out.println("Valeur courante : " + valeurCourante);
    }

    private void decalerLesLignes(){
        for(int i=1; i<NBLigne; i++){
            ligne[i-1]=ligne[i];
        }
    }
// accéder aux valeurs
    public String quelTypeCompte(){
        return typeCpte;
    }
    public String quelNumCompte(){
        return numeroCompte;
    }
   

    public double quelValeurCompte(){
        return valeurCourante;
    }

    private String controleType(){
        char tmpc;
        String tmpS="Courant";
        Scanner lectureClavier = new Scanner(System.in);

        do{
            System.out.print("Type du compte (types possibles [C(ourant)/J(oint)] : ");
            tmpc=lectureClavier.next().charAt(0);
            tmpc= Character.toUpperCase(tmpc);
        }while(tmpc!='C' && tmpc!='J');

        switch (tmpc) {
            case 'C':
                
                tmpS = "courant";
                break;
            case 'J':
                
                tmpS = "joint";
                break;
            
            
        }
    return tmpS;
    }
   
    private double controleValeur(){
        double tmpd;        
        Scanner lectureClavier = new Scanner(System.in);
        
        do{
            System.out.print("Valur initiale du compte (ne peut être négatif) : ");
            tmpd=lectureClavier.nextDouble();
            
        }while(tmpd<0);

        
    return tmpd;
    }
}
