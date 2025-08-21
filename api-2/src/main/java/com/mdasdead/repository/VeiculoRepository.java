package com.mdasdead.repository;

import com.mdasdead.entity.Marca;
import com.mdasdead.entity.Veiculo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class VeiculoRepository {

    @Inject
    private EntityManager em;

    public Veiculo save(final Veiculo veiculo) {
        return em.merge(veiculo);
    }

    public Long countAll() {
        TypedQuery<Long> query = em.createQuery(
                "SELECT COUNT(v.id) FROM Veiculo v", Long.class);
        return query.getSingleResult();
    }
}
