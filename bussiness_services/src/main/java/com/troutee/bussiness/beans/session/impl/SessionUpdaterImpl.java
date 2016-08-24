package com.troutee.bussiness.beans.session.impl;

import com.troutee.bussiness.exceptions.ServiceException;
import com.troutee.bussiness.beans.session.decl.SessionUpdater;

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
            try {
                em.createNamedQuery("session.disable.user.sessions").setParameter(1, id).executeUpdate();
            }catch (Exception ex){
                throw new ServiceException("troutee.general.error");
            }
        }
    }

    public void disableUserToken(String token) {
        if(token == null){
            throw new ServiceException("troutee.general.error");
        }else{
            try {
                em.createNamedQuery("session.disable.user.session.by.token").setParameter(1, token).executeUpdate();
            }catch (Exception ex){
                throw new ServiceException("troutee.general.error");
            }
        }
    }
}
