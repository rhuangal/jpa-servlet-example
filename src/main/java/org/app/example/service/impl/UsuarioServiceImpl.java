package org.app.example.service.impl;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import org.app.example.dao.UsuarioDao;
import org.app.example.model.Usuario;
import org.app.example.service.UsuarioService;

/**
 *
 * @author rober
 */
@Stateless
public class UsuarioServiceImpl implements UsuarioService {
    
    @EJB
    UsuarioDao dao;

    @Override
    public Usuario create(Usuario t) {
        return dao.create(t);
    }

    @Override
    public Usuario read(String cod) {
        return dao.read(cod);
    }

    @Override
    public Usuario update(Usuario t) {
        return dao.update(t);
    }

    @Override
    public void delete(String cod) {
        Usuario t = this.read(cod);
        dao.delete(t);
    }

    @Override
    public List<Usuario> getAll() {
        return dao.getAll();
    }
    
}
