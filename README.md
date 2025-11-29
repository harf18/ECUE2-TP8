# TP8 : les Threads	

### Objectifs
Manipuler les threads en java

### Prérequis
- Cloner le projet sur votre poste dans le repertoire de votre choix
- Ouvrir le projet :
  - Sur l'écran d'accueil d'IntelliJ, cliquer sur **Open**
  - Sélectionner le dossier **tpx-xxx** qui a été copié depuis github puis cliqué sur **OK**.
  - Le projet s'ouvre
  - Allez vérifier que le SDK est bien sélectionné dans **File > Project Structure** onglet **Project**

### Utilisation de GIT

- Créer une nouvelle branche **prenomNom**
- Faire **1 commit** par exercice (sauf exercice 0)
- Ouvrir **une seule** *pull request* sur github et **ne pas** la fermer/merger !!



> Si vous ne l'avez pas encore fait, pensez a créer une nouvelle branche **prenomNom**

### Exercice 1

- Créer une classe **net.lecnam.ecue2.tp8.exercice1.Compteur** qui implémente **Runnable**
  - Cette classe a 2 attributs : **nomCompteur** (String) et **valeurFin** (int) 
  - Créer une Constructeur pour initialiser ces 2 valeurs, **valeurFin** doit être positif et **nomCompteur** doit être *non null*, sinon, c'est un problème qu'il faut gérer.
  - Faite en sorte les objets **Compteur** puissent être des thread et qu'ils réalise les actions suivantes :
    - Faire une boucle de 1 à valeurFin
    - A chaque itération :
      - afficher le nom du compteur suivi de la valeur du compteur séparé par : (Ex: *Cpt1 : 1*)
      - Faire une pause d'une valeur entre 1 et 500 millisecondes (nombre aléatoire)
- Créer une classe **net.lecnam.ecue2.tp8.exercice1.Execution** 
  - Créer une méthode **main()** et danc cette méthode :
    - Instancier plusieurs compteurs jusqu'à 10. 
    - Créer 1 thread pour chaque compteur
    - Appeler pour chaque compteur directement la méthode **run()**. Que voyez-vous ? quel compteur termine en 1er ? Combien de temps dure l'execution
    - Changer les appels à **run()** par des appels à **start()** Que voyez-vous ? quel compteur termine en 1er ? Combien de temps dure l'execution. Réessayer plusieurs fois.

> Pensez a faire votre 1er commit !!  

### Exercice 2

Modifier la classe compteur pour que chaque compteur affiche son ordre d'arriver à la fin de l'écoulement du temps (pensez static !)

> Pensez a faire votre 1er commit !!  

### Exercice 3

Modifier les classes précédentes pour utiliser l'héritage de **Thread** et non plus l'implémentation de **Runnable**

> Pensez a faire votre 1er commit !!  

### Exercice 4

- Créer une classe **net.lecnam.ecue2.tp8.banque.Compte**
  - Cette classe a une seule propriété solde (double) qui est à zero
  - Ajouter le getter() de solde
  - Ajouter les méthodes ```public void ajouter(double somme)``` et ```public void retirer(double somme)``` qui ajoute ou retire une somme au solde et affiche un message "ajoute x" ou "retire x"

- Créer une classe **net.lecnam.ecue2.tp8.banque.CreditDebit** qui hérite de Thread
  - Dans le **run()** de cette classe, ajouter et retirer 10 euros au compte.
  - afficher le solde du compte

- Créer une classe  **net.lecnam.ecue2.tp8.banque.ExecuteOperation**
  - Créer une méthode **main()**
  - Dans la méthode **main()** instantier un objet Compte (la déclaration doit être précédée par **final**)
  - Créer une boucle pour créer et démarrer 300 thread de CreditDebit.

- Executer plusieurs fois le **main()**, quelle est la valeur final du solde ? Comment est-ce possible ?

- Corriger le problème.

> Pensez a faire votre 1er commit !!  

### Exercice 5

Proposer une implémentation du problème consommateurs et de producteurs. La description de Wikipedia dit 

> Le problème des producteurs et des consommateurs est un exemple informatique de synchronisation de ressources, qui peut s'envisager dans différents contextes de programmation concurrente, notamment en environnement multi-thread. Il s'agit de partager entre deux tâches, le producteur et le consommateur, une zone de mémoire tampon utilisée comme une file. Le producteur génère un élément de données, l'enfile sur la file et recommence ; simultanément, le consommateur retire les données de file1.
>
> Ce problème peut être généralisé à plusieurs producteurs ou consommateurs2.

Le tp doit être réalisé dans **net.lecnam.ecue2.tp8.producteur**

- Deux implémentation de la file sont proposés dans **FileFifoDeadLock** et **FileFifoThreadSansDeadLock** Afin de pouvoir tester facilement ces 2 versions, elles implémentent l'interface FileFifo.
- Créer une classe **Producteur** qui hérite de **Thread**
  - Cette classe a 2 propriétés : Une FileFifo et un nom
  - Créer le constucteur avec ces deux types en paramètre afin d'initialiser les propriétés.
  - Dans la méthode **run()**
    - Afficher "Demarrage du producteur : **nom**"
    - Initialiser un entier **i**à 0
    - Dans une boucle sans fin
      - Ajouter la valeur **nom** + **i** a la file
      - Afficher "ajout de la valeur **nom** + **i**"
      - Mettre le thread en pause pour une durée entre 1 et 1000 ms
- Créer une classe **Consommateur** qui hérite de **Thread**
  - Cette classe a les même propriété et le même constructeur que la classe **Producteur**
  - Dans la méthode **run()**
    - Afficher "Démarrage du consommateur : **nom**"
    - Dans une boucle sans fin
      - Récupérer la valeur de la file
      - Afficher "Consommateur **name** a récupéré la valeur **xxxxx**"
- Créer une classe **Main** et une méthode **main()**
  - Dans la méthode **main()**
    - Créer une variable de type **FileFifo** qui reference un objet **FileFifoThreadDeadLock** 
    - Instancier 2 consommateurs
    - Instancier 3 producteurs
    - Démarrer les 5 threads
    - Que constatez vous ?
    - Changer l'implémentation de la File en remplaçant **FileFifoThreadDeadLock** par **FileFifoThreadSansDeadLock**
    - Que constatez vous ?

