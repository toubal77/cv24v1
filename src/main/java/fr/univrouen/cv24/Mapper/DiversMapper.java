package fr.univrouen.cv24.Mapper;

import java.util.ArrayList;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import fr.univrouen.cv24.model.Autre;
import fr.univrouen.cv24.model.Divers;
import fr.univrouen.cv24.model.DiversType;
import fr.univrouen.cv24.model.Lv;
import fr.univrouen.cv24.model.LvType;

@Mapper
public abstract class DiversMapper {

    
            public static final  DiversMapper INSTANCE = Mappers.getMapper(DiversMapper.class);
        
            public Divers toModel(DiversType diversEntity) {
            Divers divers = new Divers();
    List<Lv> lvList = new ArrayList<>();
    for (LvType lvType : diversEntity.getLanguesDivers()) {
        Lv lv = LvMapper.INSTANCE.toModel(lvType);
        lvList.add(lv);
    }
    divers.setAutre(AutreMapper.INSTANCE.toModel(diversEntity.getAutresDivers()));
    divers.setLv(lvList);
    return divers;
}

        
            public DiversType toEntity(Divers divers) {
                DiversType diversEntity = new DiversType();
                diversEntity.setAutresDivers(AutreMapper.INSTANCE.toEntity(divers.getAutre()));
                diversEntity.setLanguesDivers(LvMapper.INSTANCE.toEntities(divers.getLv()));
                return diversEntity;
            }
            public abstract List<Divers> toModels(List<DiversType> diversEntities);
            public abstract List<DiversType> toEntities(List<Divers> diverss);
            
        }
        