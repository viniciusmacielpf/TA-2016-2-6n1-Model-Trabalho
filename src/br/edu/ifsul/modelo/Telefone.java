/*
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Vini
 * 
 * 
 */

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "telefone")

public class Telefone implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_telefone", sequenceName = "seq_telefone_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_telefone", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @Column(name = "numero",nullable = false,length = 20)
    @NotBlank(message = "Informe um numero!")
    @Length(max=20, message = "o numero não deve ultrapassar {max} caracteres")
    private String numero;
    
    @Column(name = "operadora",nullable = true,length = 50)
    private String operadora;
    
    @NotNull(message = "O Pessoa não pode ser nula")
    @ManyToOne
    @JoinColumn(name = "pessoa", referencedColumnName = "id", nullable = false, 
            foreignKey = @ForeignKey(name = "fk_telefone_pessoa"))    
    private Pessoa pessoa;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

   

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Telefone() {
    }

    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Telefone other = (Telefone) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public String getOperadora() {
        return operadora;
    }

    public void setOperadora(String operadora) {
        this.operadora = operadora;
    }
    
    
    
}
