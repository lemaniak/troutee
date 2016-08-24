package com.troutee.bussiness.beans.clientVisit.impl;

import com.troutee.bussiness.beans.clientVisit.decl.ClientVisitCreator;
import com.troutee.bussiness.exceptions.ServiceException;
import com.troutee.bussiness.exceptions.ValidationException;
import com.troutee.domain.ClientVisit;

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
public class ClientVisitCreatorImpl implements ClientVisitCreator{

    @PersistenceContext
    private EntityManager em;



    public ClientVisit create(ClientVisit visit) {
        if(visit==null){
            throw new ValidationException("Entity is required");
        }else{
            try{
                em.persist(visit);
                em.flush();
                return visit;
            }catch(PersistenceException pex){
                throw new ServiceException(pex.toString());
            }
        }
    }
}
