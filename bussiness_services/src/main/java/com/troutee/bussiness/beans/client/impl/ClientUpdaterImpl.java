package com.troutee.bussiness.beans.client.impl;

import com.troutee.bussiness.beans.client.decl.ClientFinder;
import com.troutee.bussiness.beans.client.decl.ClientUpdater;
import com.troutee.bussiness.exceptions.ServiceException;
import com.troutee.bussiness.exceptions.ValidationException;
import com.troutee.domain.Client;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

/**
 * Created by vicente on 16/03/16.
 */
@Named
@Stateless
public class ClientUpdaterImpl implements ClientUpdater {

    @PersistenceContext
    private EntityManager em;

    @Inject
    private ClientFinder clientFinder;


    public Client update(Client client) {
        if(client==null){
            throw new ValidationException("Entity is required");
        }else{
            try{
                //retrieve client from db and increase version number
                Client data=clientFinder.find_by_id(client.getId());
                client.setVersion(data.getVersion()+1);

                em.merge(client);
                em.flush();
                return client;
            }catch(PersistenceException pex){
                throw new ServiceException(pex.toString());
            }
        }
    }
}
