package com.gcc.crudbasico.api.repository.specification;

import java.util.ArrayList;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

import com.gcc.crudbasico.api.filter.BandaFilter;
import com.gcc.crudbasico.api.model.Banda;

public class BandaSpecification {

	public static Specification<Banda> usandoFiltro(BandaFilter filtro) {
		return (root, query, builder) -> {
			
			var predicates = new ArrayList<Predicate>();
			
			if(filtro != null) {
				if (filtro.getNome() != null) {
					predicates.add(
							builder.like(
									builder.lower(
											root.get("nome")
									),
									"%" + filtro.getNome() + "%"
							)
					);
				}
				
				if (filtro.getGenero() != null) {
					predicates.add(builder.equal(root.get("genero"), filtro.getGenero()));
				}
			}
			
			return builder.and(predicates.toArray(new Predicate[0]));
		};
	}
	
}
