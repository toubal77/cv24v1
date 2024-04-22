package fr.univrouen.cv24.Mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import fr.univrouen.cv24.model.Objectif;
import fr.univrouen.cv24.model.ObjectifType;

@Mapper
public abstract class ObjectifMapper {
    public static final  ObjectifMapper INSTANCE = Mappers.getMapper(ObjectifMapper.class);

	public Objectif toModel(ObjectifType objectifEntity) {
		Objectif objectif = new Objectif();
		objectif.setContenu(objectifEntity.getObjectifValue());
		objectif.setStatut(objectifEntity.getstatutObjectif());
		return objectif;
	}

	public ObjectifType toEntity(Objectif objectif) {
		ObjectifType objectifEntity = new ObjectifType();
		objectifEntity.setObjectifValue(objectif.getContenu());
		objectifEntity.setstatutObjectif(objectif.getStatut());
		return objectifEntity;
	}
	public abstract List<Objectif> toModels(List<ObjectifType> objectifEntities);
	public abstract List<ObjectifType> toEntities(List<Objectif> objectifs);
	
}
