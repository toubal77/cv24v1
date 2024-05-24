package fr.univrouen.cv24.Mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import fr.univrouen.cv24.model.CV24type;
import fr.univrouen.cv24.model.CV24;

@Mapper
public abstract class CV24Mapper {
	public static final CV24Mapper INSTANCE = Mappers.getMapper(CV24Mapper.class);

	public CV24 toModel(CV24type cv24Entity) {
		CV24 cv24 = new CV24();
		//System.out.println(cv24Entity);
		cv24.setIdentite(IdentiteMapper.INSTANCE.toModel(cv24Entity.getIdentite()));
		cv24.setObjectif(ObjectifMapper.INSTANCE.toModel(cv24Entity.getObjectif()));
		cv24.setProf(ProfMapper.INSTANCE.toModel(cv24Entity.getProf()));
		cv24.setCompetences(CompetencesMapper.INSTANCE.toModel(cv24Entity.getCompetences()));
		cv24.setDivers(DiversMapper.INSTANCE.toModel(cv24Entity.getDivers()));
		return cv24;
	}

	public CV24type toEntity(CV24 cv24) {
		CV24type cv24Entity = new CV24type();
		cv24Entity.setIdentite(IdentiteMapper.INSTANCE.toEntity(cv24.getIdentite()));
		cv24Entity.setObjectif(ObjectifMapper.INSTANCE.toEntity(cv24.getObjectif()));
		cv24Entity.setProf(ProfMapper.INSTANCE.toEntity(cv24.getProf()));
		cv24Entity.setCompetences(CompetencesMapper.INSTANCE.toEntity(cv24.getCompetences()));
		cv24Entity.setDivers(DiversMapper.INSTANCE.toEntity(cv24.getDivers()));
		return cv24Entity;
	}
	public abstract List<CV24> toModels(List<CV24type> cv24Entities);
	public abstract List<CV24type> toEntities(List<CV24> cv24s);
	
}
