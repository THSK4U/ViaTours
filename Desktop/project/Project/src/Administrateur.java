import java.util.Scanner;
public class Administrateur {
    public static void AdminItrateur() {
        Scanner scanner = new Scanner(System.in);
        boolean continuer = true;

        while (continuer) {
            System.out.println("hello admin.");
            System.out.println("Menu :");
            System.out.println("1- Gérer les apprenants");
            System.out.println("2- Gérer les classes de l'école");
            System.out.print("votre choix : ");

            int premierchoix = scanner.nextInt();
            scanner.nextLine(); // تجاهل السطر الفارغ بعد nextInt()

            switch (premierchoix) {
                case 1:
                    gererApprenants(scanner);
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Choix invalide");
            }

            System.out.println("Voulez-vous continuer ? (o/n) : ");
            String reponse = scanner.nextLine();
            if (reponse== "n") {
                continuer = false;
            }
        }
        scanner.close();
    }
    private static void gererApprenants(Scanner scanner) {
        boolean retourMenu = false;
        ApprenantDetails apprenantDetails = new ApprenantDetails();


        while (!retourMenu) {
            System.out.println("Menu :");
            System.out.println("1- Ajouter un nouvel apprenant.");
            System.out.println("2- Consulter la liste des apprenants.");
            System.out.println("3- Modifier les informations.");
            System.out.println("4- Supprimer un apprenant.");
            System.out.println("5- Rechercher un apprenant.");
            System.out.println("6- Retour au menu principal");
            System.out.print("votre choix : ");
            int apprenantschoix = scanner.nextInt();
            scanner.nextLine();

            switch (apprenantschoix) {
                case 1:
                    apprenantDetails.ajouter(scanner);
                    break;
                case 2:
                    afficherListeApprenants(apprenantDetails);
                    break;
                case 3:
                    ModifierApprenant.modifierApprenant();
                break;
                case 4:
                    System.out.println("test4");
                    break;
                case 5:
                    System.out.println("test5");
                    break;
                case 6:
                    retourMenu = true;
                    break;
                default:
                    System.out.println("Choix invalide");
            }
        }}
    public static void afficherListeApprenants(ApprenantDetails ApprenantDetails) {
        System.out.println("Liste des apprenants :");
        for (int i = 0; i < ApprenantDetails.n; i++) {
            System.out.print("\t Nom : " + ApprenantDetails.nom[i]);
            System.out.print("\t Prénom : " + ApprenantDetails.prenom[i]);
            System.out.print("\t Date de naissance : " + ApprenantDetails.dateNaissance[i]);
            System.out.print("\t Adresse : " + ApprenantDetails.adresse[i]);
            System.out.print("\t Contact : " + ApprenantDetails.contact[i]);
            System.out.println("\t Numéro de classe : " + ApprenantDetails.numeroClasse[i]);
            System.out.println("---------------------");
        }
    }
}
class ApprenantDetails {
    String nom[];
    String prenom[];
    int dateNaissance[];
    String adresse[];
    int contact[];
    int numeroClasse[];
    int n;
    static final int MAX_APPRENANT = 10;


    public ApprenantDetails(){
        nom = new String[MAX_APPRENANT];
        prenom = new String[MAX_APPRENANT];
        dateNaissance = new int[MAX_APPRENANT];
        adresse = new String[MAX_APPRENANT];
        contact = new int[MAX_APPRENANT];
        numeroClasse = new int[MAX_APPRENANT];
        n=0;
    }

    public void ajouter(Scanner scanner) {
        if (n<MAX_APPRENANT){
        System.out.print("Nom : ");
        nom[n] = scanner.nextLine();
        System.out.print("Prénom : ");
        prenom[n] = scanner.nextLine();
        System.out.print("Date de naissance : ");
        dateNaissance[n] = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Adresse : ");
        adresse[n] = scanner.nextLine();
        System.out.print("Contact : ");
        contact[n] = scanner.nextInt();
        System.out.print("Numéro de classe : ");
        numeroClasse[n] = scanner.nextInt();
        scanner.nextLine();
        n++;
        }else System.out.println("Max apprenant limit 10 : Si vous en voulez plus, payez 100 dirhams pour 10 places.");

    }
}

class ModifierApprenant {
    Scanner scanner = new Scanner(System.in);
    ApprenantDetails apprenantDetails = new ApprenantDetails();

    public static void modifierApprenant() {
        System.out.println("list : ");
        ApprenantDetails ApprenantDetails = null;
        Administrateur.afficherListeApprenants(ApprenantDetails);

        System.out.print("Enter the apprenant index you want to modify: ");
        int choixModification = scanner.nextInt();

        System.out.println("Choose the field to modify: ");
        System.out.println("1. Nom \t 2. Prénom \t 3. Date de naissance \t 3. Date de naissance \t 4. Adresse \t 5. Contact \t 6. Numéro de classe ");
        int modificationField = scanner.nextInt();

        System.out.print("Enter the new value: ");
        String newValue = scanner.nextLine();
        switch (modificationField) {
            case 1:
                ApprenantDetails.nom[choixModification] = newValue;
                break;
            case 2:
                ApprenantDetails.prenom[choixModification] = newValue;
                break;
            case 3:
                ApprenantDetails.dateNaissance[choixModification] = scanner.nextInt();
                break;
            case 4:
                ApprenantDetails.adresse[choixModification] = newValue;
                break;
            case 5:
                ApprenantDetails.contact[choixModification] = scanner.nextInt();
                break;
            case 6:
                ApprenantDetails.numeroClasse[choixModification] = scanner.nextInt();
                break;
            default:
                System.out.println("Invalid field");
        }
    }
}