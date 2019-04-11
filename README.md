# OCEscalade

OCEscalade est les 6ème projet de la formation "Développeur d'application - JavaEE" chez OpenClassrooms.

## Context

Vous faites partie d’un club d’escalade et comme tout bon grimpeur vous passez des heures à discuter avec les autres grimpeurs, des voies sur les sites de la région, des lieux insolites pour grimper…

Et puis un jour, vous vous dites : «  Ce serait sympa de regrouper un peu toutes ces informations, et de les partager avec le plus grand nombre ! ». Ça tombe bien, vous êtes en pleine formation de développeur d’application. Vous faites un petit sondage autour de vous et vous vous lancez dans la création d’une application web permettant :
  - de partager des informations sur les sites, leurs secteurs et les voies de chaque secteur (hauteur, cotation, nombre de points…)
  - de faire une recherche multi-critères pour trouver votre prochain site de grimpe
  - de laisser des commentaires
  - de présenter les topo qui existent et les sites/secteurs qu’ils couvrent
  - d’avoir un espace de prêt de topo (les propriétaires de topo peuvent proposer le prêt de leur topo et les gens intéressés peuvent voir les topo disponibles et les réserver pour une période)

## Outils utilisés

Entre **Struts* et **Spring MVC**, j'ai opté pour le Framework **Spring MVC** qui est de plus en plus utilisé aujourd'hui. L'absence de cours sur OpenClassrooms m'a poussé à apprendre cette technologie par moi même à l'aide de mon mentor. Le résultat me semble plutôt bon dans l'ensemble, mais il y a peut-être quelque point à revoir.

L'application est packagée (WAR) avec **Apache Maven** pour être déployer sur un serveur à l'aide de **Tomcat 9.0.14**. Quant à la base de données, elle est supportée par **PostgreSQL 11**.

## Déploiement

### Sur IntelliJ

Cette manipulation a été décrite à partir d'**IntelliJ IDEA Ultimate 2019.1**. Il se peut que la manipulation soit différente sur d'autre version.

1. Télécharger ou Cloner ce projet
2. Ouvrez le à l'aide d'IntelliJ
3. Créer la base de données à partir du dump situé dans le dosier SQL Scripts du projet. Si le dump ne fonctionne pas, il faudra peut-être créer l'utilisateur nommée : "ocescalade" ; auquel vous donnerez les droits nécésaire à l'utilisation de la BdD. Le mot de passe importe peu, tant qu'il est changé dans le fichier de configuration de la base de données ("src/main/resources/db.properties"). Vous pouvez aussi changer l'url d'accès à la base de données.
4. Configurer le serveur Tomcat. Pour celà, ajouter une nouvelle configuration "Tomcat Local". Dans l'onglet de Déploiement ("Deployment"), ajouter le WAR nommé **OCEscalade:war**. Changer ensuite les port à votre convenance et confirmer la création.
5. Dans l'onglet **Database** à droite, configurer une nouvelle **DataSource PostgreSQL** avec comme utilisateur "ocescalade" et le mot de passe inscrit dans le fichier de configuration ("src/main/resources/db.properties").
6. Il ne vous reste plus qu'à déployer l'application.

### Autre

Si vous n'avez pas **IntelliJ** ou que vous cherchez un exemple plus détaillé, rendez-vous sur [ce site](https://www.baeldung.com/tomcat-deploy-war).
