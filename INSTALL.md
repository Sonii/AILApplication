Procédure d'installation.

Rapide :
	Importer le fichier sql dans une base de données
	Un utilisateur doit etre créer :
	Login : lookat
	Password : 123456
	
	http://localhost:8080/lookat/home

Complète :
Pour assurer une parfaite compatibilité, merci de suivre la procédure suivante :
1) Télécharger les prérequis :
	Eclipse Luna JEE : https://www.eclipse.org/downloads/packages/eclipse-ide-java-ee-developers/lunasr1
	Git Bash pour windows
	EasyPhp (pour mysql): http://www.easyphp.org/save-easyphp-devservervc11-latest.php
	Tomcat server core zip : http://tomcat.apache.org/download-80.cgi
	
2) Extraction :
	Décompresser Eclipse à la racine de votre disque dur
	Décompresser tomcat à la racine de votre disque dur
	Installer EasyPhp
	Installer GitBash
	
3) Mise en place Eclipse :
	Lancer eclipse
	Choissisez un dossier qui sera votre workspace
	Aller dans ce dossier (votre workspace) avec l'explorer windows
	Click droit dans le dossier dans le vide : "Git bash here"
	Git bash s'ouvre positionner dans le workspace et copier (maj+insert) la commande :
	git clone https://github.com/Sonii/AILApplication.git
	Vous avez le projet dans votre workspace =D
	Dans eclipse : File -> Import ... Existing Project into workspace -> Next
	Select root directory -> votreworkspace/AILApplication -> OK
	Un projet est détecter et cocher. Clicker sur Finish. Eclipse rebuild le workspace et fait quelques configurations.
	
4) Mise en place de la BDD :
	Sur l'icone EasyPhp dans la zone de notication dans la barre des taches :
	Click Droit => Administration
	Votre navigateur s'ouvre : Clicker sur 'Ouvrir' (icon bleu) on arrive sur phpmyadmin
	Dans l'onglet User => Add User :
		Username : lookat
		Passwork : 123456
		Host : Any (%)
		Dans la section global prévilège : Select All, puis décocher seulement : GRANT
		=> GO
	Toujours dans User : selectionner les 2 users notifier : 'Any' et supprimez-les (=> GO)
	Aller maintenent dans l'onglet import  et importer le fichier sql fourni dans le dossier AILApplication
		=> GO
		L'importation devrait se passer sans problème
	
	Click Droit sur l'icone de EasyPHP : Explorer (F8)
	Revener 2 dossiers avant : EasyPHP-DevServer-14.1VC11/
	Aller dans 'modules' ==> phpMyAdmin_xxxxxxxx et ouvrir config.inc.php
	Ligne 29 modifier :
		$cfg['Servers'][$i]['auth_type'] = 'config';
			en :
		$cfg['Servers'][$i]['auth_type'] = 'cookie';
	Ligne 30 modifier :
		$cfg['Servers'][$i]['user'] = 'root';
			en
		$cfg['Servers'][$i]['user'] = '';
		
	Click droit sur easyPhp : Arreter, puis refaire click droit et Démarer
5) Mise en place de tomcat et lancement
	Dans Eclipse : Click droit sur le projet : AILApplication => Run As => Run On Server
	Dans la fenetre nouvellement ouverte : Manually Define a new Server
	Dans la section suivante : Apache : TomCat v8.0 Server
	Dans la section Server Name : Appellez-le comme bon vous semble : Server TomCat par exemple
	Cocher la case Always use this server when running this project
	=> Next
	Tomcat installation directory : selectionner le dossier tomcat extrait précédemment à la racine de votre disque dur
	=> Finish
	Le serveur se lance et le projet aussi !
	
6) Configuration du path (facultatif)
	Un navigateur s'ouvre dans une url : http://localhost:8080/correction/ et arrive sur une erreur 404 (normal)
	correction etant un reste d'un projet dans eclipse au moment d'un developpeent antérieur vous pouvez le modifier dans Eclipse :
	Un autre projet s'est ajouté 'Server' dérouler les options et ouvrir server.xml
	Tout à la fin modifier la ligne :
	<Context docBase="AILApplication" path="/correction" reloadable="true" source="org.eclipse.jst.jee.server:AILApplication"/></Host>
	EN :
	<Context docBase="AILApplication" path="/lookat" reloadable="true" source="org.eclipse.jst.jee.server:AILApplication"/></Host>
	Enregistrer et Click droit sur AILApplication : Run on server => Restart => Say NO ! Si vous répondez oui, rechanger le 'PATH' dans server.xml
	cette fois-ci vous arriver sur l'URL : http://localhost:8080/lookat/ (404)
	
7) ENJOY :
	Démarer un navigateur internet (Chrome est TRES fortement recommandé)
	et copier l'url suivante : http://localhost:8080/lookat/home
	
	Bienvenue sur Look-AT !!!
	Prenez 10-15 minutes pour explorer les différentes options que nous proposons =)
	
Merci a vous
Cordialement !
	
	