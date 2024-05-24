package fr.univrouen.cv24.Mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import fr.univrouen.cv24.model.Prof;
import fr.univrouen.cv24.model.ProfType;

@Mapper
public  abstract class  ProfMapper {

        public static final  ProfMapper INSTANCE = Mappers.getMapper(ProfMapper.class);
    
        public Prof toModel(ProfType profEntity) {
            if(profEntity ==null){
                return null;
            }
            Prof prof = new Prof();
    prof.setDetails(DetailMapper.INSTANCE.toModels(profEntity.getDetail()));
    return prof;
}

    
public ProfType toEntity(Prof prof) {
    if(prof == null){
        return null;
    }
    ProfType profEntity = new ProfType();
    profEntity.setDetail(DetailMapper.INSTANCE.toEntities(prof.getDetails()));
    return profEntity;
}

        public abstract List<Prof> toModels(List<ProfType> profEntities);
        public abstract List<ProfType> toEntities(List<Prof> profs);
        
    }
    