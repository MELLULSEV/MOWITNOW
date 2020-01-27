# MOWITNOW
MOWITNOW

Bonjour voici mon projet MowItNow

Il consiste à déplacer des tondeuses placées sur un terrain délimité (1 carré avec des abcisses et des ordonnées, les max sont envoyées dans la 1ere ligne du fichier). Elles se déplacent grâce à des commandes envoyées dans un fichier.

J'ai choisi le format .csv avec comme séparateur ";". 
IMPORTANT : Pour le test, le fichier de commandes MowItNow.csv attaché au projet est à placer dans un répertoire C:/MowItNow/
Le programme fait avancer chaque tondeuse en traitant les séquences de commandes de déplacement : A (avance d'une case en fonction de orientation de départ) , G (1/2 tour vers la gauche) , D (demi-tour vers la droite))
Le programme envoie un output lorsque la tondeuse traitée ne peut plus avancer, ceci pour plusieurs raisons:
1-Le parcours à traiter ne réponds pas aux critères attendus (A G ou D)
2-Le parcours de la tondeuse est terminé
3-La tondeuse est sortie du terrain
4-La tondeuse rencontre une autre tondeuse sur la position calculée par le programme (option présente mais non traitée dans mon 1er commit)
5-L'output est constitué du nom de la tondeuse arrêtée, des abcisses et ordonnées de sa position et de son orientation.
