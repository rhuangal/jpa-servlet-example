package org.app.example.dao;

import java.util.List;
import org.app.example.model.Usuario;

/**
 *
 * @author rober
 */
public interface UsuarioDao {
    
    public Usuario create(Usuario t);
    public Usuario read(String cod);
    public Usuario update(Usuario t);
    public void delete(Usuario t);
    public List<Usuario> getAll();
    
}
