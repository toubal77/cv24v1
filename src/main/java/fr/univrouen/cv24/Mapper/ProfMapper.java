package fr.univrouen.cv24.Mapper;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import fr.univrouen.cv24.model.Detail;
import fr.univrouen.cv24.model.DetailType;
import fr.univrouen.cv24.model.Prof;
import fr.univrouen.cv24.model.ProfType;

@Mapper
public  abstract class  ProfMapper {

        public static final  ProfMapper INSTANCE = Mappers.getMapper(ProfMapper.class);
    
        public Prof toModel(ProfType personEntity) {
    Prof prof = new Prof();
    prof.setDetails(DetailMapper.INSTANCE.toModels(personEntity.getDetail()));
    return prof;
}

    
public ProfType toEntity(Prof person) {
    ProfType personEntity = new ProfType();
    personEntity.setDetail(DetailMapper.INSTANCE.toEntities(person.getDetails()));
    return personEntity;
}

        public abstract List<Prof> toModels(List<ProfType> personEntities);
        public abstract List<ProfType> toEntities(List<Prof> persons);
        
    }
    