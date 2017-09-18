package org.app.example.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author rober
 */
@Entity
@Table(name = "tb_usuario")
public class Usuario implements Serializable {
    
    private String codigo;
    private String password;

    @Id
    @Column(length = 8, name = "codigo", nullable = false)
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Column(length = 150, name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
      
}
