package fr.univrouen.cv24.Mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import fr.univrouen.cv24.model.Detail;
import fr.univrouen.cv24.model.DetailType;

@Mapper
public abstract class DetailMapper {
    
            public static final  DetailMapper INSTANCE = Mappers.getMapper(DetailMapper.class);
        
            public Detail toModel(DetailType detailEntity) {
                Detail detail = new Detail();
                detail.setDatedeb(detailEntity.getDatedebDetail());
                detail.setDatefin(detailEntity.getDatefinDetail());
                detail.setTitre(detailEntity.getTitreDetail());
                
                return detail;
            }
        
            public DetailType toEntity(Detail detail) {
                DetailType detailEntity = new DetailType();
                detailEntity.setDatedebDetail(detail.getDatedeb());
                detailEntity.setDatefinDetail(detail.getDatefin());
                detailEntity.setTitreDetail(detail.getTitre());
                return detailEntity;
            }
            public abstract List<Detail> toModels(List<DetailType> detailEntities);
            public abstract List<DetailType> toEntities(List<Detail> details);
            
        }
        