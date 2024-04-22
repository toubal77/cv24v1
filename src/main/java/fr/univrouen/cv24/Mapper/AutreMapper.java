package fr.univrouen.cv24.Mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import fr.univrouen.cv24.model.Autre;
import fr.univrouen.cv24.model.AutreType;

@Mapper
public abstract class AutreMapper {

    
    public static final  AutreMapper INSTANCE = Mappers.getMapper(AutreMapper.class);
        
    public Autre toModel(AutreType autreEntity) {
        Autre autre = new Autre();
        autre.setComment(autreEntity.getAutreComment());
        autre.setTitre(autreEntity.getAutreTitre());
        return autre;
    }

    public AutreType toEntity(Autre autre) {
        AutreType autreEntity = new AutreType();
        autreEntity.setAutreComment(autre.getComment());
        autreEntity.setAutreTitre(autre.getTitre());
        return autreEntity;
    }
    public abstract List<Autre> toModels(List<AutreType> autreEntities);
    public abstract List<AutreType> toEntities(List<Autre> autres);
    
}
