/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package manyreal;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import static javax.persistence.CascadeType.PERSIST;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

/**
 *
 * @author eyvind
 */
@Entity
public class Authour implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
     @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
     @ManyToMany(cascade=PERSIST)//(mappedBy="Authour",cascade=PERSIST)
    private Set<Book> books;

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
     
     

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        if (!(object instanceof Authour)) {
            return false;
        }
        Authour other = (Authour) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "manyreal.Authour[ id=" + id + " ]";
    }
    
}
