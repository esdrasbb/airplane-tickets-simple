package br.edu.fa7.model;


import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "pessoa")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pessoa extends BaseModel {

    private static final long serialVersionUID = -5673145906024695823L;

    @Basic(optional = true)
    @Column(name = "email")
    protected String email;

    @Basic(optional = true)
    @Column(name = "telefone")
    protected String telefone;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}