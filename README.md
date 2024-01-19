# JPhoto

JPhoto est un mini programme graphique pour le
traitement d'images. La section suivante détaille
les différentes fonctionnalités et leur 
utilisation.

## Utilisation

La première chose à faire est d'ouvrir une image
via le menu **fichier -> ouvrir**. L'image
apparaîtra sur la fenêtre. Pour des raisons de
temps je n'ai pas eu le temps de mettre en place
une zone de dessin avec une barre de défilement
(et éventuellement un zoom), donc il ne faut pas
ouvrir d'images dont les dimensions sont proches
ou plus grandes que celles de votre écran. Dans le
cas contraire, les données non visibles de l'image 
seront bien là mais pas visibles **dans 
l'éditeur** et donc pas forcément modifiables.
Une fois les modifications faites, il est possible
d'enregistrer l'image via **fichier -> enregistrer**.
Alternativement, il est possible de choisir une
autre destination via **fichier -> enregistrer sous**,
cette destination sera celle utilisée lors du
prochain enregistrement simple. Il est possible
de spécifier un fichier qui n'existe pas.

### Barre d'outils

Le premier outil est le pinceau, il est possible
de l'activer en cliquant sur le bouton avec
l'icone de pinceau. Il est possible de choisir
sa taille avec le sélecteur à droite et la couleur
avec le bouton en dessou. Une fois fini, un autre
click permettra de le déselectionner. Le bouton
*Négatif* permet d'inverser les couleurs de l'image
et d'effectuer l'opération réciproque à tout 
moment. Le dernier bouton (bouton Ryan Gosling)
permet d'ajouter une image de Ryan Gosling 
aléatoire à l'endroit où l'on veut. Il est possible
d'ajouter d'autre images en les ajoutant dans le
dossier **res/ryan_gosling** avec une des 
extensions de fichier parmis **png, jpg, jpeg**
puis de recompiler. Il est aussi possible de
le faire directement dans le dossier
**JPhoto.jar/res/ryan_gosling** mais les ajouts
seront écrasés à la prochaine compilation.

### Menu

Le deuxième onglet du menu est l'onglet
**Filtres**. Les filtres disponibles sont le
flou gaussien, le flou par moyennes, le niveau
de gris, le noir et blanc et le filtre néon. Lors
de l'utilisation d'un flou, une fenêtre vous
demandera la taille du noyau à utiliser, ne 
dépassez pas 11 ou 13, sauf si vous avez plusieurs
minutes libres. La valeur par défaut propose un
flou correct. Le filtre noir et blanc vous
demandera un seuil, la valeur par défaut propose
un bon équilibre. Un seuil de 255 rendra tous les
pixels noirs et un seuil de 0, tous les pixels
blancs. Le filtre néon, est un filtre que j'ai
trouvé par hasard, il effectue simplement un
XOR entre un pixel et le suivant sur la même ligne.
Ce filtre ne marche pas avec des images qui ont de
la transparence.

Le dernier onglet est l'onglet **Cryptographie**.
Le bouton chiffrement permet de chiffrer les
pixels de l'image sélectionnée avec le chiffrement
AES 128 bits et le mode Cipher Block Chaining pour
éviter la reconnaissance de pixels. Une fenêtre
apparaîtra et demandera un mot de passe, puis
les pixels chiffrés apparaîtront. Le mot de passe
sert seulement à générer la clé, et le vecteur
d'initialisation. Les 128 premiers bits du haché
SHA-256 forment la première clé et le reste forme
le vecteur d'initialisation. Le déchiffrement ne
marche pas pour des raisons inconnues.

## Installation

Quel que soit le système d'exploitation, il est
parfois possible d'exécuter une archive Jar en
double clickant dessus.

### Unix

Le fichier **compile.sh** permet de compiler le
code source et de créer une archive Jar. Le 
fichier **run.sh** permet de l'exécuter. Rendez
les fichiers exécutables :

```bash
chmod +x compile.sh run.sh
```

Pour compiler :

```bash
./compile.sh
```

Pour exécuter :

```bash
./run.sh
```

### Windows 

Le fichier **compile.bat** permet de compiler le
code source et de créer une archive Jar. Le 
fichier **run.bat** permet de l'exécuter.

Pour compiler :

```bash
.\compile
```

Pour l'exécuter :

```bash
.\run
```

Il est alternativement possible de double clicker
sur les deux fichiers.

## Organisation

A la racine du projet se trouve les fichiers de
compilation et d'exécution, un dossier **src** et
un dossier **res**. Le premier contient le code
source du projet, le second contient les images
dont le programme a besoin, et les crédits. Une
fois compilé, l'archive Jar apparaîtra à la
racine du projet.
