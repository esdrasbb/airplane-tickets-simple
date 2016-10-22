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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Table(name = "pagamento")
@SQLDelete(sql = "UPDATE pagamento SET esta_ativo = false WHERE id = ?")
@Where(clause = "esta_ativo = '1'")
public class Pagamento extends BaseModel {

    private static final long serialVersionUID = -2410528949461810975L;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tipo_pagamento", nullable = false)
    private TipoPagamento tipoPagamento;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data")
    private Date data;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_reserva", nullable = false)
    private Reserva reserva;

    @Column(name = "valor", precision = 10, scale = 2)
    @Basic(optional = false)
    private Double valor;

    public Pagamento() {
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

}
