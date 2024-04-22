package fr.univrouen.cv24.Mapper;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import fr.univrouen.cv24.model.Certif;
import fr.univrouen.cv24.model.CertifType;
import fr.univrouen.cv24.model.Competences;
import fr.univrouen.cv24.model.CompetencesType;
import fr.univrouen.cv24.model.Diplome;
import fr.univrouen.cv24.model.DiplomeType;

@Mapper
public abstract class CompetencesMapper {
    
    public static final  CompetencesMapper INSTANCE = Mappers.getMapper(CompetencesMapper.class);
        
   public Competences toModel(CompetencesType competencesEntity) {
    Competences competences = new Competences();
    List<Certif> certifList = new ArrayList<>();
    for (CertifType certifType : competencesEntity.getCertif()) {
        Certif certif = CertifsMapper.INSTANCE.toModel(certifType);
        certifList.add(certif);
    }
    competences.setCertifs(certifList);

    // Faites de même pour Diplome
    List<Diplome> diplomeList = new ArrayList<>();
    for (DiplomeType diplomeType : competencesEntity.getDiplome()) {
        Diplome diplome = DiplomeMapper.INSTANCE.toModel(diplomeType);
        diplomeList.add(diplome);
    }
    competences.setDiplomes(diplomeList);

    return competences;
}


public CompetencesType toEntity(Competences competences) {
    CompetencesType competencesEntity = new CompetencesType();
    List<CertifType> certifTypeList = new ArrayList<>();
    for (Certif certif : competences.getCertifs()) {
        CertifType certifType = CertifsMapper.INSTANCE.toEntity(certif);
        certifTypeList.add(certifType);
    }
    competencesEntity.setCertif(certifTypeList);

    // Faites de même pour Diplome
    List<DiplomeType> diplomeTypeList = new ArrayList<>();
    for (Diplome diplome : competences.getDiplomes()) {
        DiplomeType diplomeType = DiplomeMapper.INSTANCE.toEntity(diplome);
        diplomeTypeList.add(diplomeType);
    }
    competencesEntity.setDIplomes(diplomeTypeList);

    return competencesEntity;
}

    public abstract List<Competences> toModels(List<CompetencesType> competencesEntities);
    public abstract List<CompetencesType> toEntities(List<Competences> competencess);
    
}
