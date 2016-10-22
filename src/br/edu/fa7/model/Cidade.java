package br.edu.fa7.model;

import br.edu.fa7.enums.Estado;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name = "cidade")
@SQLDelete(sql = "UPDATE cidade SET esta_ativo = false WHERE id = ?")
@Where(clause = "esta_ativo = '1'")
public class Cidade extends BaseModel {

    private static final long serialVersionUID = 7970712038357421892L;

    @Column(name = "nome")
    @Basic(optional = false)
    private String nome;

    @Column(name = "estado")
    @Enumerated(EnumType.STRING)
    @Basic(optional = false)
    private Estado estado;

    public Cidade() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
}
