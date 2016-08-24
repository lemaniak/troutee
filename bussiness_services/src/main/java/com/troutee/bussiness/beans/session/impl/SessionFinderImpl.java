package com.troutee.bussiness.beans.session.impl;

import com.troutee.bussiness.exceptions.NotFoundException;
import com.troutee.bussiness.beans.session.decl.SessionFinder;
import com.troutee.domain.Session;
import com.troutee.domain.Tuser;
import org.apache.commons.lang.StringUtils;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 * Created by vicente on 04/04/16.
 */
@Named
@Stateless
public class SessionFinderImpl implements SessionFinder {

    @PersistenceContext
    private EntityManager em;

    public Session find(String token) {
        if (StringUtils.isBlank(token)) {
            throw new IllegalArgumentException("token is required");
        } else {
            try {
                return  (Session) em.createNamedQuery("session.get.user.session.by.token").setParameter(1,token).getSingleResult();
            } catch (NoResultException nre) {
                return null;
            }
        }
    }


    public Session get(String token) {
        Session u = find(token);
        if (u == null) {
            throw new NotFoundException("session.not.found.by.token");
        }
        return u;
    }

    public Tuser getUserFromToken(String token) {
       Session session = get(token);
       return session.getTuser();
    }


}
