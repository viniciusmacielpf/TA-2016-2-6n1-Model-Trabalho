/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Vini
 */
@Entity
@Table(name = "imovel")
public class Imovel implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_imovel", sequenceName = "seq_imovel_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_imovel", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "endereco", length = 50, nullable = false)
    @NotBlank(message = "Informe um endereco!")
    @Length(max = 50, message = "o endereco não deve ultrapassar {max} caracteres")
    private String endereco;

    @Column(name = "tipo", length = 50, nullable = false)
    @NotBlank(message = "Informe um tipo!")
    @Length(max = 50, message = "o tipo não deve ultrapassar {max} caracteres")
    private String tipo;

    @Column(name = "status", length = 50, nullable = false)
    @NotBlank(message = "Informe um status!")
    @Length(max = 50, message = "o status não deve ultrapassar {max} caracteres")
    private String status;

    @Column(name = "valor", columnDefinition = "decimal(12,2)", nullable = false)
    @NotNull(message = "valor não informado")
    private Double valor;

  
    @ManyToMany
    @JoinTable(name = "imovel_caracteristicas",
            joinColumns = @JoinColumn(name = "imovel", referencedColumnName = "id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "caracteristicas", referencedColumnName = "id", nullable = false))
    private List<Caracteristicas> caracteristicas = new ArrayList<>();
    public Imovel() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

   
 
    public void addOp(Caracteristicas obj) {
        this.caracteristicas.add(obj);
    }

    public void removeOp(int index) {
        this.caracteristicas.remove(index);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Imovel other = (Imovel) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    
    public List<Caracteristicas> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(List<Caracteristicas> caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    

}
