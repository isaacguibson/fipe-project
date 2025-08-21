package com.mdasdead.repository;

import com.mdasdead.entity.Marca;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class MarcaRepository {

    @Inject
    private EntityManager em;

    public Marca save(final Marca marca) {
        return em.merge(marca);
    }

    public Long countAll() {
        TypedQuery<Long> query = em.createQuery(
                "SELECT COUNT(m.id) FROM Marca m", Long.class);
        return query.getSingleResult();
    }
}
