package jaxrs.dao.generic;

import jaxrs.domain.Fiche;

public class FicheDao extends AbstractJpaDao<Long, Fiche>{

    public FicheDao(){
        super(Fiche.class);
    }
}

