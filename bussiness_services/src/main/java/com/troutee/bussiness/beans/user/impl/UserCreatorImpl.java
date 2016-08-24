package com.troutee.bussiness.beans.user.impl;

import com.troutee.bussiness.exceptions.ServiceException;
import com.troutee.bussiness.exceptions.ValidationException;
import com.troutee.bussiness.beans.user.decl.UserCreator;
import com.troutee.domain.Tuser;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

/**
 * Created by vicente on 29/02/16.
 */
@Named
@Stateless
public class UserCreatorImpl implements UserCreator {

    @PersistenceContext
    private EntityManager em;

    public Tuser create(Tuser user) {
        if(user==null){
            throw new ValidationException("Entity is required");
        }else{
            try{
                em.persist(user);
                em.flush();
                return user;
            }catch(PersistenceException pex){
                throw new ServiceException(pex.toString());
            }
        }
    }
}
