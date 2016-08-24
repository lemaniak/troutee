package com.troutee.bussiness.beans.session.impl;

import com.troutee.bussiness.exceptions.ServiceException;
import com.troutee.bussiness.exceptions.ValidationException;
import com.troutee.bussiness.beans.session.decl.SessionCreator;
import com.troutee.domain.Session;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

/**
 * Created by vicente on 09/03/16.
 */
@Named
@Stateless
public class SessionCreatorImpl implements SessionCreator {

    @PersistenceContext
    private EntityManager em;

    public Session create(Session session) {
        if(session==null){
            throw new ValidationException("Entity is required");
        }else{
            try{
                em.persist(session);
                em.flush();
                return session;
            }catch(PersistenceException pex){
                throw new ServiceException(pex.toString());
            }
        }
    }
}
