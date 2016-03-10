package com.troutee.api.beans.user.impl;

import com.troutee.api.beans.user.decl.UserFinder;
import com.troutee.api.exception.NotFoundException;
import com.troutee.domain.Tuser;
import org.apache.commons.lang.StringUtils;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;


/**
 * Created by vicente on 02/03/16.
 */
@Named
@Stateless
public class UserFinderImpl implements UserFinder {

    @PersistenceContext
    private EntityManager em;



    public Tuser find(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("id is required");
        } else {
            try {
                return  (Tuser) em.createNamedQuery("User.findbyid").setParameter(1,id).getSingleResult();
            } catch (NoResultException nre) {
                return null;
            }
        }
    }


    public Tuser get(Integer id) {
        Tuser u = find(id);
        if (u == null) {
            throw new NotFoundException("user.not.found.by.id");
        }
        return u;
    }


    public Tuser findByEmail(String email) {
        if (StringUtils.isEmpty(email)) {
            throw new IllegalArgumentException("email is required");
        } else {
            try {
                return  (Tuser) em.createNamedQuery("User.findbyemail").setParameter(1,email).getSingleResult();
            } catch (NoResultException nre) {
                return null;
            }
        }
    }


    public Tuser getByEmail(String email) {
        Tuser u = findByEmail(email);
        if (u == null) {
            throw new NotFoundException("user.not.found.by.email");
        }
        return u;
    }

    public Boolean isEmailRegistered(String email) {
        if (StringUtils.isEmpty(email)) {
            throw new IllegalArgumentException("email is required");
        } else {
            try {
                return  (Boolean) em.createNamedQuery("User.is.email.registered").setParameter(1,email).getSingleResult();
            } catch (NoResultException nre) {
                return null;
            }
        }
    }

    public Boolean userExistsById(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("id is required");
        } else {
            try {
                return  (Boolean) em.createNamedQuery("User.exists.by.id").setParameter(1,id).getSingleResult();
            } catch (NoResultException nre) {
                return false;
            }
        }
    }


}
