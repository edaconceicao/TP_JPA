package jaxrs.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.List;

@Entity
@XmlRootElement(name = "KanbanBoard")
public class KanbanBoard implements Serializable {

    private int id;
    private String nom;
    private List<Section> sections;
    private List<Utilisateur> utilisateurs;

    @Id
    @GeneratedValue
    @XmlElement(name = "id")
    public int getId() {
        return id;
    }

    @ManyToMany(mappedBy = "kanbanBoards")
    @XmlTransient
    public List<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateurs(List<Utilisateur> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }

    @OneToMany(mappedBy = "kanbanBoard")
    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement(name = "nom")
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
