<!-- Corriger les probl�mes li�s � l'encoding -->
<%@ include file="tags/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="th" %>
<!-- Permet de rajouter un header automatiquement  -->


<h2>Bienvenue sur votre compte - Que souhaitez vous-faire ?</h2>

<th:choose>
	<th:when test="${!empty email && (profile=='admin' || profile=='moderator')}">
		<a href="/user/new">Ajouter un utilisateur</a>
		<a href="/users?page=0&size=10&sortDirection=ASC&sortProperty=email">Liste des utilisateurs</a>
		<a href="/stories">Listes des stories</a>
	</th:when>
	<th:otherwise>
		<a href="/stories">Mes stories</a>
		<a href="/stories/new">Ajouter une nouvelle story</a>
	</th:otherwise>
</th:choose>
<a href="/user/infos">Mes infos personnelles</a>

<!-- 
<div class="container">
    <div class="jumbotron">
        <h1>Bienvenue dans l'interface de gestion des ${nbEmployes} employ�s !</h1>
        <p>Cette application web est param�tr�e pour communiquer avec une API REST accessible � l'adresse <code>http://localhost:5367</code>.</p>
        <p>Il est n�cessaire de d�velopper les services webs n�cessaires pour que cette application fonctionne. Voici l'ensemble des fonctionnalit�s :</p>
        <ul class="list-group">
            <li class="list-group-item">
                <h4 class="list-group-item-heading">1 - Compter le nombre d'employ�s</h4>
                <p class="list-group-item-text">A c�t� du lien <em>Liste des employ�s</em>, on doit voir appara�tre le nombre d'employ�s. L'appel qui est effectu� est <code>GET /employes/count</code>.</p>
            </li>
            <li class="list-group-item">
                <h4 class="list-group-item-heading">2 - Afficher un employ�</h4>
                <p class="list-group-item-text">En cliquant <a href="/employes/5">ici</a>, on peut afficher les informations basiques de l'employ� d'identifiant 5 (matricule M00001). On consulte l'URL <code>/employes/5</code>. En cliquant <a href="/employes/0">ici</a>, on essaye d'afficher l'employ� d'identifiant 0 mais on doit obtenir une erreur 404 car il n'existe pas.</p>
            </li>
            <li class="list-group-item">
                <h4 class="list-group-item-heading">3 - Recherche par matricule</h4>
                <p class="list-group-item-text">Lorsqu'on recherche le matricule <em>C00019</em> dans la barre de recherche, on tombe sur <em>Sarah Renault</em>. L'URL auquel on acc�de est <code>/?matricule=C00019</code>. Lorsqu'on recherche un matricule inexistant commme <em>ABCDEF</em>, on obtient une erreur 404.</p>
            </li>
            <li class="list-group-item">
                <h4 class="list-group-item-heading">4 - Liste des employ�s</h4>
                <p class="list-group-item-text">En cliquant <a href="/employes?page=0&size=10&sortDirection=ASC&sortProperty=matricule">ici</a>, tous les employ�s sont affich�s, de mani�re pagin�e. Il est possible de changer de page en utilisant les boutons. L'URL utilis� est <code>/employes?page=0&size=10&sortProperty=matricule&sortDirection=ASC</code></p>
            </li>
            <li class="list-group-item">
                <h4 class="list-group-item-heading">5 - Cr�ation d'un Commercial</h4>
                <p class="list-group-item-text">En cliquant <a href="/employes/new/commercial">ici</a> ou via le bouton <em>Nouvel employ�</em>, <em>Commercial</em>, pr�sent dans la liste des employ�s, on acc�de au formulaire de cr�ation d'un commercial. L'appel qui est effectu� est <code>POST /commercials/save</code> avec les donn�es du formulaire qui sont envoy�es.</p>
            </li>
            <li class="list-group-item">
                <h4 class="list-group-item-heading">6 - Modification d'un Commercial</h4>
                <p class="list-group-item-text">En cliquant <a href="/employes/8">ici</a> ou en consultant les d�tails du commercial de matricule <em>C00002</em> (id 8), il est possible de modifier les informations du commercial d'identifiant 8 qui sont persist�es en base de donn�e lorsqu'on clique sur le bouton <em>Enregistrer</em>. L'URL qui est appel� est <code>POST /commercials/8</code> avec les donn�es du formulaire qui sont envoy�es.</p>
            </li>
            <li class="list-group-item">
                <h4 class="list-group-item-heading">7 - Suppression d'un Commercial</h4>
                <p class="list-group-item-text">En cliquant <a href="/employes/22">ici</a> ou en consultant les d�tails du commercial de matricule <em>C00018</em> (id 22), il est possible de supprimer ce dernier lorsqu'on clique sur le bouton <em>Supprimer</em>. L'appel qui est effectu� est <code>GET /employes/22/delete</code>.</p>
            </li>
            <li class="list-group-item">
                <h4 class="list-group-item-heading">8 - Cr�ation, modification et suppression d'un Technicien</h4>
                <p class="list-group-item-text">Faire la m�me chose que les trois questions pr�c�dentes pour les techniciens. Le chemin de l'API est <code>/techniciens</code>.</p>
            </li>
            <li class="list-group-item">
                <h4 class="list-group-item-heading">9 - Cr�ation, modification et suppression d'un Manager</h4>
                <p class="list-group-item-text">Faire la m�me chose que la question pr�c�dente pour les managers. Le chemin de l'API est <code>/managers</code>.</p>
            </li>
            <li class="list-group-item">
                <h4 class="list-group-item-heading">10 - Ajouter ou supprimer un technicien dans l'�quipe d'un manager</h4>
                <p class="list-group-item-text">En cliquant <a href="/employes/532">ici</a> ou en consultant le d�tail du manager <em>M00528</em> (id 532), il est possible de supprimer (Appel API <code>GET /managers/532/techniciens/576/delete</code>) un membre de son �quipe (ici le technicien d'id 576) avec le bouton <span class="glyphicon glyphicon-remove"></span> et d'ajouter (Appel API <code>GET /managers/532/techniciens/add?matricule=T00110</code>) un membre � l'�quipe en renseignant son matricule (dans l'exemple T00110) et en cliquant sur le bouton <span class="glyphicon glyphicon-plus"></span>.</p>
            </li>
            <li class="list-group-item">
                <h4 class="list-group-item-heading">11 - Ajouter ou supprimer un manager � un technicien</h4>
                <p class="list-group-item-text">En cliquant <a href="/employes/576">ici</a> ou en consultant le d�tail du technicien <em>T00572</em> (id 576), il est possible de supprimer (GET /techniciens/576/manager/remove) son manager avec le bouton <span class="glyphicon glyphicon-remove"></span> et d'ajouter (Appel API <code>GET /techniciens/576/manager/M00528/add</code>) un manager en renseignant son matricule (dans l'exemple M00528) et en cliquant sur le bouton <span class="glyphicon glyphicon-plus"></span>.</p>
            </li>
        </ul>
    </div>
</div>
-->
<!-- Permet de rajouter un footer automatiquement  -->
<%@ include file="tags/footer.jsp" %>
