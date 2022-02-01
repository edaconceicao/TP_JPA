package jaxrs.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.List;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="role", discriminatorType=DiscriminatorType.STRING)
@NamedQueries(@NamedQuery(name = "getAllUsers", query = "select u from Utilisateur u"))
@DiscriminatorValue("Utilisateur")
@XmlRootElement(name = "Utilisateur")
public class Utilisateur implements Serializable {

    private String nom;
    private String mail;
    private List<KanbanBoard> kanbanBoards;
    private List<Fiche> fiches;

    @Id
    @XmlElement(name = "mail")
    public String getMail() {
        return mail;
    }

    @ManyToMany
    @XmlTransient
    public List<KanbanBoard> getKanbanBoards() {
        return kanbanBoards;
    }

    public void setKanbanBoards(List<KanbanBoard> kanbanBoards) {
        this.kanbanBoards = kanbanBoards;
    }

    @OneToMany(mappedBy = "utilisateur")
    @XmlTransient
    public List<Fiche> getFiches() {
        return fiches;
    }

    public void setFiches(List<Fiche> fiches) {
        this.fiches = fiches;
    }

    @XmlElement(name = "nom")
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

}
