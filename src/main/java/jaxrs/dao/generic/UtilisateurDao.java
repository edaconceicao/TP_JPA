package jaxrs.dao.generic;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import jaxrs.domain.Utilisateur;

public class UtilisateurDao extends AbstractJpaDao<String, Utilisateur>{

    public UtilisateurDao(){
        super(Utilisateur.class);
    }

    public List<Utilisateur> getUserByName(String name){
        String query = "select u from Utilisateur as u where u.nom=:name";
        List<Utilisateur> utilisateurs = entityManager.createQuery(query, Utilisateur.class)
                .setParameter("name", name).getResultList();
        return utilisateurs;
    }

    public List<Utilisateur> getAllUsers(){
        List<Utilisateur> utilisateurs = entityManager.createNamedQuery("getAllUsers", Utilisateur.class)
                .getResultList();
        return utilisateurs;
    }

    public List<String> getIdOfUserByName(String...names){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<String> query = criteriaBuilder.createQuery(String.class);
        Root<Utilisateur> from = query.from(Utilisateur.class);
        query.select(from.get("mail"))
                .where(from.get("nom").in(names));
        return entityManager.createQuery(query).getResultList();
    }

    public Utilisateur getUserByEmail(String mail){
        String query = "select u from Utilisateur as u where u.mail=:mail";
        Utilisateur utilisateur = entityManager.createQuery(query, Utilisateur.class)
                .setParameter("mail", mail).getSingleResult();
        return utilisateur;
    }
}

