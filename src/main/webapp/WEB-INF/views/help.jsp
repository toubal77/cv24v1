<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>



    <!DOCTYPE html>
    <html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Help</title>
</head>
<body>
<div class="intro">
<h1>CV24 REST HELP</h1>
<p><span>La Page</span> affiche la liste des opérations gérées par notre service REST.</p>
</div>

<table>
      <thead>
        <tr>
          <th scope="col">URL</th>
          <th scope="col">METHODE ATTENDUE</th>
          <th scope="col">ACTION</th>
        </tr>
      </thead>
      <tbody>
        <tr>
          <th scope="row">/</th>
          <td>GET</td>
          <td>Retourne la page d'accueil du projet</td>
        </tr>

        <tr>
          <th scope="row">/help</th>
          <td>GET</td>
          <td>Retourne la liste des opérations gérées par le service REST</td>
        </tr>

        <tr>
          <th scope="row">/resume</th>
          <td>GET / POST</td>
          <td>Retourne une liste résumée les CV24 présentes dans la base en flux XML avec 
          les informations suivantes :
		<ul>
			<li>Identifiant de la CV24</li>
            <li>Identifiant de la CV24</li>
            <li>Identifiant de la CV24</li>
            <li>Identifiant de la CV24</li>
		</ul>
        </tr>

        <tr>
          <th scope="row">/cv24/{id}</th>
          <td>GET</td>
          <td>Opération Retourne le contenu complet du CV24 dont l’identifiant est {id}, 
	          Retour Flux XML conforme au schéma XSD d'une CV24.
	      </td>
        </tr>

		<tr>
          <th scope="row">/html/cv24/{id}</th>
          <td>GET</td>
          <td>Opération Retourne le contenu complet du CV24 dont l’identifiant est {id}
 	 		  en format HTML.
	      </td>
        </tr>


        <tr>
          <th scope="row">/insert</th>
          <td>PUT</td>
          <td>Transmis Flux XML décrivant la CV24 à ajouter, conformément au schéma XSD.
	 	  </td>
        </tr>

        <tr>
          <th scope="row">/delete/{id}</th>
          <td>DELETE</td>
          <td>Suppression du CV24 dont l’identifiant est {id} Retour Flux XML
	 	  </td>
        </tr>
      </tbody>
    </table>
    <footer>
        <p>Tous droits réservés &copy; 2024</p>
    </footer>
</body>
</html>