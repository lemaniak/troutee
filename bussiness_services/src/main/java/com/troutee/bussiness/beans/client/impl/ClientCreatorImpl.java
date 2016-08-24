package com.troutee.bussiness.beans.client.impl;

import com.troutee.bussiness.beans.client.decl.ClientCreator;
import com.troutee.bussiness.beans.user.decl.UserCreator;
import com.troutee.bussiness.exceptions.ServiceException;
import com.troutee.bussiness.exceptions.ValidationException;
import com.troutee.domain.Client;
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
public class ClientCreatorImpl implements ClientCreator{

    @PersistenceContext
    private EntityManager em;

    public Client create(Client client) {
        if(client==null){
            throw new ValidationException("Entity is required");
        }else{
            try{
                em.persist(client);
                em.flush();
                return client;
            }catch(PersistenceException pex){
                throw new ServiceException(pex.toString());
            }
        }
    }
}
