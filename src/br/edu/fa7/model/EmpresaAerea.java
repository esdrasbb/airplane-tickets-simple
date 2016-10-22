package br.edu.fa7.model;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "empresa_aerea")
@SQLDelete(sql = "UPDATE empresa_aerea SET esta_ativo = false WHERE id = ?")
@Where(clause = "esta_ativo = '1'")
public class EmpresaAerea extends BaseModel {

    private static final long serialVersionUID = 5262427790467856178L;

    @Column(name = "nome")
    @Basic(optional = false)
    private String nome;

    @Column(name = "sigla")
    @Basic(optional = false)
    private String sigla;

    @OneToMany(mappedBy = "empresaAerea", targetEntity = Voo.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Voo> voos;

    public EmpresaAerea() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

}
