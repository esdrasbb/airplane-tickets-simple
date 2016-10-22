package br.edu.fa7.model;

import org.apache.commons.beanutils.BeanUtils;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;

@MappedSuperclass
public abstract class BaseModel implements Serializable {

    private static final long serialVersionUID = -9189152335097716525L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    protected Integer id;

    @Column(nullable = false, name = "esta_ativo")
    protected Boolean estaAtivo;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_registro")
    @Basic(optional = false)
    protected Date dataRegistro;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_alteracao")
    @Basic(optional = true)
    protected Date dataAlteracao;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_exclusao")
    @Basic(optional = true)
    protected Date dataExclusao;

    public Boolean getEstaAtivo() {
        return estaAtivo;
    }

    public void setEstaAtivo(Boolean estaAtivo) {
        this.estaAtivo = estaAtivo;
    }

    public Date getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(Date dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public Date getDataAlteracao() {
        return dataAlteracao;
    }

    public void setDataAlteracao(Date dataAlteracao) {
        this.dataAlteracao = dataAlteracao;
    }

    public Date getDataExclusao() {
        return dataExclusao;
    }

    public void setDataExclusao(Date dataExclusao) {
        this.dataExclusao = dataExclusao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Object clone() {
        try {
            Object obj = new Object();
            BeanUtils.copyProperties(obj, this);
            return obj;
        } catch (IllegalAccessException e) {
            return null;
        } catch (InvocationTargetException e) {
            return null;
        }
    }

    @PrePersist
    protected void onCreate() {
        dataRegistro = new Date();
        estaAtivo = Boolean.TRUE;
    }

    @PreUpdate
    protected void onUpdate() {
        dataAlteracao = new Date();
    }

    @PreRemove
    protected void onDelete() {
        dataExclusao = new Date();
        estaAtivo = Boolean.FALSE;
    }
}
