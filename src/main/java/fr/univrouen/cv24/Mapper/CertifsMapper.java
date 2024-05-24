package fr.univrouen.cv24.Mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import fr.univrouen.cv24.model.Certif;
import fr.univrouen.cv24.model.CertifType;

@Mapper
public abstract class CertifsMapper {
    public static final  CertifsMapper INSTANCE = Mappers.getMapper(CertifsMapper.class);
        
    public Certif toModel(CertifType certifEntity) {
        if(certifEntity == null){
            return null;
        }
        Certif certif = new Certif();
        certif.setDate(certifEntity.getCertifDatedeb());
        certif.setDateFin(certifEntity.getCertifDatefin());
        certif.setNom(certifEntity.getCertifTitre());
        return certif;
    }

    public CertifType toEntity(Certif certif) {
        if(certif == null){
            return null;
        }
        CertifType certifEntity = new CertifType();
        certifEntity.setCertifDatedeb(certif.getDate());
        certifEntity.setCertifDatefin(certif.getDateFin());
        certifEntity.setCertifTitre(certif.getNom());
        return certifEntity;
    }
    public abstract List<Certif> toModels(List<CertifType> certifEntities);
    public abstract List<CertifType> toEntities(List<Certif> certifs);
    
}

