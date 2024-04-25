<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0" xmlns:cv24="http://univ.fr/cv24">
<xsl:output method="html" indent="yes" omit-xml-declaration="yes" encoding="UTF-8" /> 
  <xsl:template match="/cv24">
    <html>
      <head>
        <title>CV24 - XSLT V1.0</title>

          <link rel="stylesheet" type="text/css" href="style.css"/>
      </head>
      <body>
        <h1>CV24 - XSLT V1.0</h1>
        <p>Le 14 février 2024</p>
        <h2>	
        	<xsl:value-of select="cv24:identite/genre"/>
        	<xsl:text> </xsl:text> 
        	<xsl:value-of select="cv24:identite/prenom"/>
        	<xsl:text> </xsl:text> <!-- genere un espace entre nom et prenom ? -->
        	<xsl:value-of select="cv24:identite/nom"/>
        </h2>
      	<p>
      		Tel: <xsl:value-of select="cv24:identite/tel"/>
        	 <br/>
        	Mel: <xsl:value-of select="cv24:identite/mel"/>
      	</p>


      </body>
    </html>
  </xsl:template>

  <xsl:template match="objectif">
    <h2>
		 <p><xsl:value-of select="."/></p>
	</h2>

    <p>	
     <!-- mmettre la valeur de l'attribut statut dans une variable -->
     <xsl:variable name="statut" select="@statut"/>
  	 <!-- utilisation de la valeur dee l'attribut statut -->
    Demande de <xsl:value-of select="$statut"/>
    </p>

  </xsl:template>




</xsl:stylesheet>