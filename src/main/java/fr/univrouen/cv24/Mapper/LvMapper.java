package fr.univrouen.cv24.Mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import fr.univrouen.cv24.model.Lv;
import fr.univrouen.cv24.model.LvType;


@Mapper
public abstract class LvMapper {
  
    public static final  LvMapper INSTANCE = Mappers.getMapper(LvMapper.class);
        
    public Lv toModel(LvType lvEntity) {
        Lv lv = new Lv();
        lv.setCert(lvEntity.getCert());
        lv.setLang(lvEntity.getLang());
        lv.setNivi(lvEntity.getNivi());
        lv.setNivs(lvEntity.getNivs());
        return lv;
    }

    public LvType toEntity(Lv lv) {
        LvType lvEntity = new LvType();
        lvEntity.setCert(lv.getCert());
        lvEntity.setLang(lv.getLang());
        lvEntity.setNivi(lv.getNivi());
        lvEntity.setNivs(lv.getNivs());
        return lvEntity;
    }
    public abstract List<Lv> toModels(List<LvType> lvEntities);
    public abstract List<LvType> toEntities(List<Lv> lvs);
    
}
