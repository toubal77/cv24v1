<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:cv24="http://univ.fr/cv24">

    <xsl:output method="html"/>

    <xsl:template name="addStyleSheet">
        <link rel="stylesheet" type="text/css" href="styles.css"/>
    </xsl:template>

    <xsl:template match="/">
        <html>
            <head>
                <title>CV24 - Détails du CV</title>
                <meta charset="UTF-8"/>

                <xsl:call-template name="addStyleSheet"/>
            </head>
            <body>
                <div class="container">
                    <xsl:apply-templates select="/cv24:cv24"/>
                </div>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="cv24:cv24">
        <div class="identite">
            <h2>Identité</h2>
            <p>Genre: <xsl:value-of select="cv24:identite/cv24:genre"/></p>
            <p>Nom: <xsl:value-of select="cv24:identite/cv24:nom"/></p>
            <p>Prénom: <xsl:value-of select="cv24:identite/cv24:prenom"/></p>
            <p>Téléphone: <xsl:value-of select="cv24:identite/cv24:tel"/></p>
            <p>Email: <xsl:value-of select="cv24:identite/cv24:mel"/></p>
        </div>
        <xsl:apply-templates select="cv24:objectif"/>
        <xsl:apply-templates select="cv24:prof"/>
        <xsl:apply-templates select="cv24:competences"/>
        <xsl:apply-templates select="cv24:divers"/>
    </xsl:template>

    <xsl:template match="cv24:objectif">
        <div class="objectif">
            <h2>Objectif</h2>
            <p>Statut: <xsl:value-of select="@statut"/></p>
            <p>Description: <xsl:value-of select="."/></p>
        </div>
    </xsl:template>

    <xsl:template match="cv24:prof">
        <div class="prof">
            <h2>Expérience professionnelle</h2>
            <xsl:for-each select="cv24:detail">
                <p>
                    Date de début: <xsl:value-of select="cv24:datedeb"/><br/>
                    <xsl:if test="cv24:datefin">
                        Date de fin: <xsl:value-of select="cv24:datefin"/><br/>
                    </xsl:if>
                    Titre: <xsl:value-of select="cv24:titre"/>
                </p>
            </xsl:for-each>
        </div>
    </xsl:template>

    <xsl:template match="cv24:competences">
        <div class="competences">
            <h2>Compétences</h2>
            <xsl:apply-templates select="cv24:diplome"/>
            <xsl:apply-templates select="cv24:certif"/>
        </div>
    </xsl:template>

    <xsl:template match="cv24:diplome">
        <div class="diplome">
            <p>Niveau: <xsl:value-of select="@niveau"/></p>
            <p>Texte: <xsl:value-of select="cv24:texte"/></p>
            <p>Date: <xsl:value-of select="cv24:date"/></p>
            <p>Institut: <xsl:value-of select="cv24:institut"/></p>
        </div>
    </xsl:template>

    <xsl:template match="cv24:certif">
        <div class="certif">
            <p>Début: <xsl:value-of select="cv24:datedeb"/></p>
            <p>Titre: <xsl:value-of select="cv24:titre"/></p>
        </div>
    </xsl:template>

    <xsl:template match="cv24:divers">
        <div class="divers">
            <h2>Divers</h2>
            <p>Langue: <xsl:value-of select="cv24:lv/@lang"/></p>
            <p>Certification: <xsl:value-of select="cv24:lv/@cert"/></p>
            <p>Niveau oral: <xsl:value-of select="cv24:lv/@nivs"/></p>
            <p>Niveau écrit: <xsl:value-of select="cv24:lv/@nivi"/></p>
            <xsl:if test="cv24:autre/@titre">
                <p>Autre: <xsl:value-of select="cv24:autre/@titre"/></p>
            </xsl:if>
        </div>
    </xsl:template>

</xsl:stylesheet>