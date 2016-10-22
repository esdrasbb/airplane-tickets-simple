package br.edu.fa7.model;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "aeroporto")
@SQLDelete(sql = "UPDATE aeroporto SET esta_ativo = false WHERE id = ?")
@Where(clause = "esta_ativo = '1'")
public class Aeroporto extends BaseModel {

    private static final long serialVersionUID = -6678427990001459270L;

    @Column(name = "nome")
    @Basic(optional = false)
    private String nome;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_cidade", nullable = false)
    private Cidade cidade;

    public Aeroporto() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

}
