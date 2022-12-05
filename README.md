Laboratoire SMTP : Mihajlovic Marko, Philipp Nicolas

## Introduction

Ce laboratoire à pour but d'envoyer des pranks par emails via un serveur SMTP.

## Répartition du projet

Notre projet est divisé en 2 parties (Config et src).

### partie Config
Cette partie contient 3 fichiers :
1. config.properties qui va nous servir a stocker toute les informations 
   utiles à la communication entre le serveur SMTP et notre application. Par 
   exemple le numéro de port.
2. messages.utf8 qui va contenir les sujets et les différents pranks que 
   nous allons envoyer.
3. victimes.utf8 qui va inclure les adresses emails des victimes des pranks.

### partie implémentation du code

Le package model est lui même constitué de 2 packages (mail et prank).

1.Le package mail (Person, Group et Mail) va contenir les différentes classes 
qui vont stocker les informations lors de l'envoi des mails. Par exemple la 
classe Person va stocker les adresses mails en format String.

2.Le package prank (Prank, PrankConfig et PrankGenerator) va nous permettre
de créer les groupes de victimes (grâce au package mail) sélectionnés 
aléatoirement dans le fichier victimes.utf8 et attribuer un message à chaque 
groupe. Avec les informations suivantes, la classe Prank fait appel à la 
classe client (dans le package smtp) afin d'envoyer les messages.

Le package smtp qui contient la classe Client va permettre de gèrer la 
communication avec le serveur smtp (de la création du socket jusqu'à la fin 
de la liaison) en lui envoyant les messages requis.


La classe exécutable App va recuperer les informations contenues dans config.
properties et lancer la campagne de pranks.

###  MockMock

#### Explication:
MockMock est un serveur SMTP qui ne contient pas la fonctionalité d'envoyer 
des messages. Ce dernier va nous permettre de simuler l'envoie de mail grâce 
a son interface web dans lequel nous pourront voir toutes les informations 
des mails envoyés (contenu et les adresses emails concernées).

#### Utilisation:
Pour utiliser le serveur MockMock, nous avons cloner le git suivant
https://github.com/DominiqueComte/MockMock et nous l'avons compiler sur notre
machine pour créer le dossier Target qui contiendra le MockMock.jar. Il faut
ensuite lancer ce dernier en ligne de commande grâce la commande "java -jar
MockMock.jar". Pour voir l'affichage de notre serveur, nous devons ouvrir un
navigateur web est accéder a la page "http://localhost:8282/".

Nous vous avons également mit a disposition dans le dossier Docker de quoi 
créer et lancer un conteneur Docker pour une plus simple utilisation. Dans 
ce dossier Docker, Vous aurez un autre dossier contenant le mockmock.jar 
mais vous aurez également tout les scripts utiles à la création et à 
l'utilisation du conteneur. "build-image.sh" servira a construire votre 
conteneur Docker alors que "docker-run.sh" et "docker-stop.sh" vous 
servirons à l'exéctuer et l'arrêter.

### Instruction pour lancer une campagne de prank

Voici les quelques étapes qui vont vous permettre de lancer une campagne de 
prank très rapidement.

1. Clonez se repo et modifiez les fichier "victimes.utf8" et "messages.utf8".
   Attention a bien mettre le séparateur "ThisIsTheEnd" entre chaque message 
   et à ne pas mettre de retour à la ligne entre ce séparateur et le sujet 
   du message d'après pour que le programme puisse les différencier.
2. Modifiez également le fichier config.properties en fonction de quel 
   numéro de port et le nombre de groupe de personne à qui vous voulez faire 
   un  prank.
3. Exéctuez le serveur MockMock comme expliqué dans la partie utilisation.
4. Il ne vous reste plus qu'a exécuter le programme et vous rendre sur 
   "http://localhost:8282/" pour voir le résultat.
