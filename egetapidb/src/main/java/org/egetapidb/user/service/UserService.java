package org.egetapidb.user.service;

import org.egetapidb.developer.service.DeveloperService;
import org.egetapidb.user.model.User;

import io.quarkus.security.UnauthorizedException;

import java.util.List;
import java.util.UUID;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Transactional(Transactional.TxType.SUPPORTS)
@ApplicationScoped
@Named
public class UserService {

    @Inject
    EntityManager em;

    @Inject
    DeveloperService developerService;

    public List<User> findAll(UUID apiKey) {
        if (!developerService.isApiKeyValid(apiKey)) {
            throw new UnauthorizedException("Inte giltligt!");
        }
        List<User> users = em.createQuery("SELECT u FROM User u", User.class).getResultList();
        return users;
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public User create(User user, UUID apiKey) {
        if (!developerService.isApiKeyValid(apiKey)) {

        }
        em.persist(user);
        return user;
    }

    public User findUser(Long id, UUID apiKey) {
        if (!developerService.isApiKeyValid(apiKey)) {
            throw new UnauthorizedException("Inte giltligt!");
        }

        return em.find(User.class, id);
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public void deleteUser(Long id, UUID apiKey) {
        if (!developerService.isApiKeyValid(apiKey)) {
            throw new UnauthorizedException("Inte giltligt!");

        }
        em.remove(em.getReference(User.class, id));
    }

    public Long countAllUsers(UUID apiKey) {
        if (!developerService.isApiKeyValid(apiKey)) {
            throw new UnauthorizedException("Inte giltligt!");
        }
        return em.createQuery("SELECT COUNT(u) FROM User u", Long.class).getSingleResult();
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public void changeUser(Long userId, String newUser, UUID apiKey) { {
        if (!developerService.isApiKeyValid(apiKey)) {
            throw new UnauthorizedException("Inte giltligt!");
        }
            User user = em.find(User.class, userId);

            if (user.getId().equals(userId)) {
                user.setUsername(newUser);
                em.merge(user);
            }
        }
}
}