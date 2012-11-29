/*
 * 
 * 
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author cgomezmendez
 */
@Entity
@Table(name = "APP")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "App.findAll", query = "SELECT a FROM App a"),
    @NamedQuery(name = "App.findById", query = "SELECT a FROM App a WHERE a.id = :id"),
    @NamedQuery(name = "App.findByXmlLocation", query = "SELECT a FROM App a WHERE a.xmlLocation = :xmlLocation"),
    @NamedQuery(name = "App.findByEjecutado", query = "SELECT a FROM App a WHERE a.ejecutado = :ejecutado"),
    @NamedQuery(name = "App.findByActivo", query = "SELECT a FROM App a WHERE a.activo = :activo")})
public class App implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "xmlLocation")
    private String xmlLocation;
    @Column(name = "ejecutado")
    private Boolean ejecutado;
    @Column(name = "activo")
    private Boolean activo;
    @JoinColumn(name = "Twitter_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Twitter twitterid;

    public App() {
    }

    public App(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getXmlLocation() {
        return xmlLocation;
    }

    public void setXmlLocation(String xmlLocation) {
        this.xmlLocation = xmlLocation;
    }

    public Boolean getEjecutado() {
        return ejecutado;
    }

    public void setEjecutado(Boolean ejecutado) {
        this.ejecutado = ejecutado;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    public Twitter getTwitterid() {
        return twitterid;
    }

    public void setTwitterid(Twitter twitterid) {
        this.twitterid = twitterid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof App)) {
            return false;
        }
        App other = (App) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.App[ id=" + id + " ]";
    }
    
}
