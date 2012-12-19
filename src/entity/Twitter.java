/*
 * 
 * 
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author cgomezmendez
 */
@Entity
@Table(name = "Twitter")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Twitter.findAll", query = "SELECT t FROM Twitter t"),
    @NamedQuery(name = "Twitter.findById", query = "SELECT t FROM Twitter t WHERE t.id = :id"),
    @NamedQuery(name = "Twitter.findByUsuario", query = "SELECT t FROM Twitter t WHERE t.usuario = :usuario"),
    @NamedQuery(name = "Twitter.findByPassword", query = "SELECT t FROM Twitter t WHERE t.password = :password")})
public class Twitter implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "usuario")
    private String usuario;
    @Column(name = "password")
    private String password;
    @Column(name = "ultimoTweet")
    private String ultimoTweet;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "twitterid")
    private Collection<App> appCollection;
    @JoinColumn(name = "Mensajes_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Mensajes mensajesid;

    public Twitter() {
    }

    public Twitter(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public Collection<App> getAppCollection() {
        return appCollection;
    }

    public void setAppCollection(Collection<App> appCollection) {
        this.appCollection = appCollection;
    }

    public Mensajes getMensajesid() {
        return mensajesid;
    }

    public void setMensajesid(Mensajes mensajesid) {
        this.mensajesid = mensajesid;
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
        if (!(object instanceof Twitter)) {
            return false;
        }
        Twitter other = (Twitter) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Twitter[ id=" + id + " ]";
    }

    public String getUltimoTweet() {
        return ultimoTweet;
    }

    public void setUltimoTweet(String ultimoTweet) {
        this.ultimoTweet = ultimoTweet;
    }
    
}
