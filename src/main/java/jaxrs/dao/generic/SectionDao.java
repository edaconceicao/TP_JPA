package jaxrs.dao.generic;

import java.util.List;

import jaxrs.domain.Section;

public class SectionDao extends AbstractJpaDao<Long, Section> {

    public SectionDao(){
        super(Section.class);
    }

    public List<Section> getSectionByKanban(long id){
        String query = "select s from Section as s where s.kanbanBoard.id = :id";
        List<Section> sections = entityManager.createQuery(query, Section.class).
                setParameter("id",id).getResultList();
        return sections;
    }
}
