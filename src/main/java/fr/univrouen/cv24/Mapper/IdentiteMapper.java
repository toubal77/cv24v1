package fr.univrouen.cv24.Mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import fr.univrouen.cv24.model.Identite;
import fr.univrouen.cv24.model.IdentiteType;

@Mapper
public abstract class IdentiteMapper {
    public static final  IdentiteMapper INSTANCE = Mappers.getMapper(IdentiteMapper.class);

	public Identite toModel(IdentiteType identiteEntity) {
		Identite identite = new Identite();
		identite.setGenre(identiteEntity.getGenre());
		identite.setMel(identiteEntity.getMel());
        identite.setNom(identiteEntity.getNom());
        identite.setPrenom(identiteEntity.getPrenom());
        identite.setTel(identiteEntity.getTel());
		return identite;
	}

	public IdentiteType toEntity(Identite identite) {
		System.out.println("hhhhhhhhhhhhhhhhhhhhhhh" + identite);
		IdentiteType identiteEntity = new IdentiteType();
		identiteEntity.setGenre(identite.getGenre());
		identiteEntity.setMel(identite.getMel());
        identiteEntity.setNom(identite.getNom());
        identiteEntity.setPrenom(identite.getPrenom());
        identiteEntity.setTel(identite.getTel());
		return identiteEntity;
	}
	public abstract List<Identite> toModels(List<IdentiteType> identiteEntities);
	public abstract List<IdentiteType> toEntities(List<Identite> identites);
	
}
