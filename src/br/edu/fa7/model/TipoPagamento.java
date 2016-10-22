package br.edu.fa7.model;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_pagamento")
@SQLDelete(sql = "UPDATE tipo_pagamento SET esta_ativo = false WHERE id = ?")
@Where(clause = "esta_ativo = '1'")
public class TipoPagamento extends BaseModel {

    private static final long serialVersionUID = -8484901536236342916L;

    @Column(name = "descricao")
    @Basic(optional = false)
    private String descricao;

    public TipoPagamento() {
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }


}
