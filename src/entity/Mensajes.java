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
@Table(name = "Mensajes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Mensajes.findAll", query = "SELECT m FROM Mensajes m"),
    @NamedQuery(name = "Mensajes.findById", query = "SELECT m FROM Mensajes m WHERE m.id = :id"),
    @NamedQuery(name = "Mensajes.findByMensajeInicial", query = "SELECT m FROM Mensajes m WHERE m.mensajeInicial = :mensajeInicial"),
    @NamedQuery(name = "Mensajes.findByMensajeArtista", query = "SELECT m FROM Mensajes m WHERE m.mensajeArtista = :mensajeArtista"),
    @NamedQuery(name = "Mensajes.findByMensajeFinal", query = "SELECT m FROM Mensajes m WHERE m.mensajeFinal = :mensajeFinal")})
public class Mensajes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "mensajeInicial")
    private String mensajeInicial;
    @Column(name = "mensajeArtista")
    private String mensajeArtista;
    @Column(name = "mensajeFinal")
    private String mensajeFinal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "mensajesid")
    private Collection<Twitter> twitterCollection;

    public Mensajes() {
    }

    public Mensajes(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMensajeInicial() {
        return mensajeInicial;
    }

    public void setMensajeInicial(String mensajeInicial) {
        this.mensajeInicial = mensajeInicial;
    }

    public String getMensajeArtista() {
        return mensajeArtista;
    }

    public void setMensajeArtista(String mensajeArtista) {
        this.mensajeArtista = mensajeArtista;
    }

    public String getMensajeFinal() {
        return mensajeFinal;
    }

    public void setMensajeFinal(String mensajeFinal) {
        this.mensajeFinal = mensajeFinal;
    }

    @XmlTransient
    public Collection<Twitter> getTwitterCollection() {
        return twitterCollection;
    }

    public void setTwitterCollection(Collection<Twitter> twitterCollection) {
        this.twitterCollection = twitterCollection;
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
        if (!(object instanceof Mensajes)) {
            return false;
        }
        Mensajes other = (Mensajes) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Mensajes[ id=" + id + " ]";
    }
    
}
