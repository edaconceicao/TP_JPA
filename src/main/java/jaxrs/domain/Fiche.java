package jaxrs.domain;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;

@Entity
@XmlRootElement(name = "Fiche")
public class Fiche implements Serializable {

    private int id;
    private Integer position;
    private String libelle;
    private String date;
    private Integer requiredTime;
    private String tags;
    private String lieu;
    private String url;
    private String note;
    private Utilisateur utilisateur;
    private Section section;

    @Id
    @GeneratedValue
    @XmlElement(name = "id")
    public int getId() {
        return id;
    }

    @ManyToOne
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    @ManyToOne
    @XmlTransient
    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public void setId(int id) {
        this.id = id;
    }

    @XmlElement(name = "position")
    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @XmlElement(name = "libelle")
    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @XmlElement(name = "date")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @XmlElement(name = "requiredTime")
    public Integer getRequiredTime() {
        return requiredTime;
    }

    public void setRequiredTime(Integer requiredTime) {
        this.requiredTime = requiredTime;
    }

    @XmlElement(name = "tags")
    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    @XmlElement(name = "lieu")
    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    @XmlElement(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @XmlElement(name = "note")
    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
