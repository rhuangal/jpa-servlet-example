package org.app.example.service;

import java.util.List;
import org.app.example.model.Usuario;

/**
 *
 * @author rober
 */
public interface UsuarioService {
    
    public Usuario create(Usuario t);
    public Usuario read(String cod);
    public Usuario update(Usuario t);
    public void delete(Usuario t);
    public List<Usuario> getAll();
    
}
