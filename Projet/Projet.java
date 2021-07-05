package Projet;

import java.util.*;

public class Projet {   
    
    public static void main(String[] args) {
        byte choix;
        String  numeroCompteLu="", vide=""; 
        Compte c = new Compte(vide);
        Scanner lectureClavier = new Scanner(System.in);
        do{        
            choix=menuPrincipal(); 

            switch (choix) {
                case 1:
                    // option 1
                    System.out.print (" Compte Epargne (o/n) : ");
                    if (lectureClavier.next().charAt(0) == 'o')		c = new CpteEpargne();
                    else c = new Compte(); 
                    
                    break;
                case 2:
                    // option 2
                    
                    System.out.println("Merci de saisir le N° de compte que vous souhaitez consulter");
                    
                    numeroCompteLu = lectureClavier.next();
                    if(numeroCompteLu.equals(c.quelNumCompte())){
                       c.afficherCompte();
                    }else{
                        System.out.println("Le compte N° " +numeroCompteLu+" n'existe pas");
                    }
                    break;
                case 3:
                    // option 3
                    System.out.print ( "Pour quel compte souhaitez vous créer une ligne ? : ");
                    numeroCompteLu = lectureClavier.next();
                    if ( numeroCompteLu.equalsIgnoreCase(c.quelNumCompte()))
                        c.créerLigne();
                    else
                    System.out.println("Le systeme ne connait pas le compte " + numeroCompteLu);
                        break;
                case 4:
                    // option 4
                    sortie();
                    break;
                case 5:
                    // option 5
                   alAide();
                    
                    break;
            
                default:
                System.out.println("Merci d'utiliser un chiffre entre 1 et 5");
                    break;
            }
        }while(choix !=4);
      




    }

    // afficher le menu principal
    public static byte menuPrincipal(){
        byte tmp;
        Scanner lectureClavier = new Scanner(System.in);
        System.out.println("1. Créer un compte");
        System.out.println("2. Afficher un compte");
        System.out.println("3. Créer une ligne comptable");
        System.out.println("4. Sortir");
        System.out.println("5. De l'aide");
        System.out.println("Votre choix : ");
        
        tmp=lectureClavier.nextByte();

        return tmp;

    }

    // sortir du logiciel
    public static void sortie(){
        System.out.println("Au revoir et à bientôt");
                    System.exit(0);
    }

    // aide du logiciel
    public static void alAide(){
        System.out.println("Option 1. Pour creer un compte Courant entrer C ");
        System.out.println("          Pour creer un compte Joint entrer J ");
        System.out.println("          Pour creer un compte Epargne entrer E");
        System.out.print("          Puis, entrer le numero du compte, et"); 
        System.out.println(" sa premiere valeur creditee ");
        System.out.println("           Dans le cas d'un compte epargne, entrer le taux ");
        System.out.println("Option 2. Le systeme affiche les donnees du compte choisi ");
        System.out.println("Option 3. Ecrire une ligne comptable");
        System.out.println("Option 4. Pour quitter le programme");
        System.out.println("Option 5. Pour afficher de l'aide");
    }

  

    
}
