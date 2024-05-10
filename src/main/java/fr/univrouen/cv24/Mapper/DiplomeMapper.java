package fr.univrouen.cv24.Mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import fr.univrouen.cv24.model.Diplome;
import fr.univrouen.cv24.model.DiplomeType;

@Mapper
public abstract class DiplomeMapper {
    public static final  DiplomeMapper INSTANCE = Mappers.getMapper(DiplomeMapper.class);
        
    public Diplome toModel(DiplomeType diplomeEntity) {
        Diplome diplome = new Diplome();
        diplome.setInstitut(diplomeEntity.getInstitutDiplome());
        diplome.setDate(diplomeEntity.getDiplomeDate());
        diplome.settitre(diplomeEntity.getTitreDiplome());
        diplome.setNiveau(diplomeEntity.getDiplomeNiveau());
        return diplome;
    }

    public DiplomeType toEntity(Diplome diplome) {
        DiplomeType diplomeEntity = new DiplomeType();
        diplomeEntity.setDiplomeDate(diplome.getDate());
        diplomeEntity.setDiplomeNiveau(diplome.getNiveau());
        diplomeEntity.setInstitutDiplome(diplome.getInstitut());
        diplomeEntity.setTitreDiplome(diplome.gettitre());
        return diplomeEntity;
    }
    public abstract List<Diplome> toModels(List<DiplomeType> diplomeEntities);
    public abstract List<DiplomeType> toEntities(List<Diplome> diplomes);
    
}

