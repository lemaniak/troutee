package com.troutee.api.beans.session.impl;

import com.troutee.api.beans.session.decl.SessionUpdater;
import com.troutee.exceptions.ServiceException;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by vicente on 09/03/16.
 */
@Named
@Stateless
public class SessionUpdaterImpl implements SessionUpdater {

    @PersistenceContext
    private EntityManager em;


    public void disableUserTokens(Integer id) {
        if(id == null){
            throw new ServiceException("troutee.general.error");
        }else{
            em.createNamedQuery("Session.disable.user.sessions").setParameter(1,id).executeUpdate();
        }
    }
}
