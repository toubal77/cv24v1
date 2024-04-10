package fr.univrouen.cv24.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class IndexController {
	 @GetMapping("/")
	    public String index() {
	        String pjctName = "CV Projet Langage Web";
	        String pjctVersion = "1.0";
	        
	 //  String[] members = {"TOUBAL Zine-Eddine"};
	        
	        String member = "TOUBAL Zine-Eddine";
	        String univLogo = "<img src='/src/main/resources/xml/logo_univ_rouen.png' alt='Logo univ rouen'>";
	        
	        StringBuilder htmlPage = new StringBuilder();
	        htmlPage.append("<!DOCTYPE html>");
	        htmlPage.append("<html>");
	        htmlPage.append("<head>");
	        htmlPage.append("<title>Page d'accueil</title>");
	        htmlPage.append("</head>");
	        htmlPage.append("<body>");
	        
	        htmlPage.append("<h1>").append(pjctName).append("</h1>");
	        htmlPage.append("<p>Version : ").append(pjctVersion).append("</p>");
	        
	        htmlPage.append("<h2>Membres de l'équipe :</h2>");
	        htmlPage.append("<p> - "+ member + "</p>");
	  //      htmlPage.append("<ul>");
	   //   for (String member : members) {
	   //       htmlPage.append("<li>").append(member).append("</li>");
	   //    }
	  //      htmlPage.append("</ul>");
	        
	        htmlPage.append(univLogo);
	        
	        htmlPage.append("</body>");
	        htmlPage.append("</html>");
	        
	        return htmlPage.toString();
	    }
}