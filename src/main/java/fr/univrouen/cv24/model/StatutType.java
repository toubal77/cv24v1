package fr.univrouen.cv24.model;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(name = "statut")
@XmlEnum
public enum StatutType {

    @XmlEnumValue("stage")
    STAGE("stage"),
    @XmlEnumValue("emploi")
    EMPLOI("emploi");
    
    private final String valueStatut;

    StatutType(String v) {
        valueStatut = v;
    }

    public String valueStatut() {
        return valueStatut;
    }

    public static StatutType fromValue(String v) {
        for (StatutType c: StatutType.values()) {
            if (c.valueStatut.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }
}
