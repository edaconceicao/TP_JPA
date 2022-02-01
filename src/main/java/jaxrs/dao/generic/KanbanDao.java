package jaxrs.dao.generic;

import java.util.List;

import jaxrs.domain.KanbanBoard;

public class KanbanDao extends AbstractJpaDao<Long, KanbanBoard> {

    public KanbanDao(){
        super(KanbanBoard.class);
    }
    
    public List<KanbanBoard> getAllKanbans(){
        String query = "select k from KanbanBoard as k";
        List<KanbanBoard> kanbans = entityManager.createQuery(query, KanbanBoard.class).getResultList();
        return kanbans;
    }
    public List<KanbanBoard> getAllKanbansOfUser(String mail){
        String query = "select distinct k from KanbanBoard k join k.utilisateurs u where u.mail = :mail";
        List<KanbanBoard> kanbans = entityManager.createQuery(query, KanbanBoard.class).
                setParameter("mail", mail).getResultList();
        return kanbans;
    }
}
