package br.edu.fa7.model;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "voo")
@SQLDelete(sql = "UPDATE voo SET esta_ativo = false WHERE id = ?")
@Where(clause = "esta_ativo = '1'")
public class Voo extends BaseModel {

    private static final long serialVersionUID = 8975930420033386634L;

    @Column(name = "sigla")
    @Basic(optional = false)
    private String sigla;

    @Column(name = "numero")
    @Basic(optional = false)
    private String numero;

    @Temporal(TemporalType.TIME)
    @Column(name = "data_hora_previsto_saida")
    @Basic(optional = false)
    private Date dataHoraPrevistoSaida;

    @Temporal(TemporalType.TIME)
    @Column(name = "data_hora_previsto_chegada")
    @Basic(optional = false)
    private Date dataHoraPrevistoChegada;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_aeroporto_saida", nullable = false)
    private Aeroporto aeroportoSaida;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_aeroporto_chegada", nullable = false)
    private Aeroporto aeroportoChegada;

    @Column(name = "valor", precision = 10, scale = 2)
    @Basic(optional = false)
    private Double valor;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_empresa_aerea", nullable = false)
    private EmpresaAerea empresaAerea;

    @Column(name = "quantidade_assentos_disponiveis")
    @Basic(optional = false)
    private Integer quantidadeAssentosDisponiveis;

    public Voo() {
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Aeroporto getAeroportoSaida() {
        return aeroportoSaida;
    }

    public void setAeroportoSaida(Aeroporto aeroportoSaida) {
        this.aeroportoSaida = aeroportoSaida;
    }

    public Aeroporto getAeroportoChegada() {
        return aeroportoChegada;
    }

    public void setAeroportoChegada(Aeroporto aeroportoChegada) {
        this.aeroportoChegada = aeroportoChegada;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public EmpresaAerea getEmpresaAerea() {
        return empresaAerea;
    }

    public void setEmpresaAerea(EmpresaAerea empresaAerea) {
        this.empresaAerea = empresaAerea;
    }

    public Date getDataHoraPrevistoSaida() {
        return dataHoraPrevistoSaida;
    }

    public void setDataHoraPrevistoSaida(Date dataHoraPrevistoSaida) {
        this.dataHoraPrevistoSaida = dataHoraPrevistoSaida;
    }

    public Date getDataHoraPrevistoChegada() {
        return dataHoraPrevistoChegada;
    }

    public void setDataHoraPrevistoChegada(Date dataHoraPrevistoChegada) {
        this.dataHoraPrevistoChegada = dataHoraPrevistoChegada;
    }

    public Integer getQuantidadeAssentosDisponiveis() {
        return quantidadeAssentosDisponiveis;
    }

    public void setQuantidadeAssentosDisponiveis(Integer quantidadeAssentosDisponiveis) {
        this.quantidadeAssentosDisponiveis = quantidadeAssentosDisponiveis;
    }
}
