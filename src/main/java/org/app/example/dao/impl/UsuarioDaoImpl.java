package org.app.example.dao.impl;

import java.util.List;
import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.app.example.dao.UsuarioDao;
import org.app.example.model.Usuario;


/**
 *
 * @author rober
 */
@Stateless
@Local
public class UsuarioDaoImpl implements UsuarioDao {

    @PersistenceContext
    private EntityManager em;
    
    @Override
    public Usuario create(Usuario t) {
        em.persist(t);
        return t;
    }

    @Override
    public Usuario read(String cod) {
        return em.find(Usuario.class, cod);
    }

    @Override
    public Usuario update(Usuario t) {
        return em.merge(t);
    }

    @Override
    public void delete(Usuario t) {
        Usuario bean = em.merge(t);
        em.remove(bean);
    }

    @Override
    public List<Usuario> getAll() {
        Query q =  em.createQuery("from "+Usuario.class.getName()+" u");
        return q.getResultList();
    }
    
}
