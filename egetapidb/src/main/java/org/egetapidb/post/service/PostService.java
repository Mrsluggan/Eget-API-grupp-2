package org.egetapidb.post.service;

import java.util.List;

import org.egetapidb.post.model.Post;
import org.egetapidb.user.model.User;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Transactional(Transactional.TxType.SUPPORTS)
@ApplicationScoped
@Named
public class PostService {

    @Inject
    EntityManager em;

    public List<Post> findAll() {
        List<Post> posts = em.createQuery("SELECT p FROM Post p", Post.class).getResultList();
        return posts;

    }

    public Post findPost(Long id) {
        return em.find(Post.class, id);
    }

    // Metod för att hämta posts av user
    public Post findPostbyUser(Long id) {
        return em.find(Post.class, id);
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public Post createPost(Post post, Long userId) {
        User user = em.find(User.class, userId);
        post.setUserId(user.getId());
        em.persist(post);
        return post;
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public void deletePost(Long userId, Long id) {
        User user = em.find(User.class, userId);
        if (user.getId().equals(userId)) {
            em.remove(em.getReference(Post.class, id));
        }

    }

    public Long countAllPosts() {
        return em.createQuery("SELECT COUNT(p) FROM Post p", Long.class).getSingleResult();
    }

}
