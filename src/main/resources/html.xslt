<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:cv24="http://univ.fr/cv24">

    <xsl:output method="html"/>
    <xsl:template match="/">
        <xsl:element name="cv">
            <xsl:call-template name="identite"/>
            <xsl:call-template name="objectif"/>
        </xsl:element>
    </xsl:template>

    <xsl:template name="identite">
        <xsl:element name="identite">
            <xsl:call-template name="name"/>
        </xsl:element>
    </xsl:template>

    <xsl:template name="name">
        <xsl:element name="genre">
            <xsl:value-of select="/cv24:cv24/cv24:identite/cv24:genre"/>
        </xsl:element>
        <xsl:element name="nom">
            <xsl:value-of select="/cv24:cv24/cv24:identite/cv24:nom"/>
        </xsl:element>
        <xsl:element name="prenom">
            <xsl:value-of select="/cv24:cv24/cv24:identite/cv24:prenom"/>
        </xsl:element>
    </xsl:template>



</xsl:stylesheet>