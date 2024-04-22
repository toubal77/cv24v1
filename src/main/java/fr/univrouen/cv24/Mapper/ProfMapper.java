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
    
        public Prof toModel(ProfType profEntity) {
    Prof prof = new Prof();
    List<Detail> detailList = new ArrayList<>();
    for (DetailType detailType : profEntity.getDetail()) {
        Detail detail = DetailMapper.INSTANCE.toModel(detailType);
        detailList.add(detail);
    }
    prof.setDetails(detailList);
    return prof;
}

    
public ProfType toEntity(Prof prof) {
    ProfType profEntity = new ProfType();
    List<DetailType> detailTypeList = new ArrayList<>();
    for (Detail detail : prof.getDetails()) {
        DetailType detailType = DetailMapper.INSTANCE.toEntity(detail);
        detailTypeList.add(detailType);
    }
    profEntity.setDetail(detailTypeList);
    return profEntity;
}

        public abstract List<Prof> toModels(List<ProfType> profEntities);
        public abstract List<ProfType> toEntities(List<Prof> profs);
        
    }
    