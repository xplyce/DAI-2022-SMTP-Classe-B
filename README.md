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


