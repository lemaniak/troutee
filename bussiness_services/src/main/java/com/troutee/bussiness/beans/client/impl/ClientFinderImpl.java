package com.troutee.bussiness.beans.client.impl;

import com.troutee.bussiness.beans.client.decl.ClientFinder;
import com.troutee.domain.Client;

import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by vicente on 27/06/16.
 */
@Named
@Stateless
public class ClientFinderImpl implements ClientFinder {

    @PersistenceContext
    private EntityManager em;


    public Client find_by_id(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("id is required");
        } else {
            try {
                return (Client) em.createNamedQuery("Client.findbyid").setParameter(1,id).getSingleResult();
            } catch (NoResultException nre) {
                return null;
            }
        }
    }

    public Boolean isUniqueCoodinates(Integer id, Double latitude, Double longitude) {
        if (id == null || latitude==null || longitude==null) {
            throw new IllegalArgumentException("client data is required");
        } else {
            try {
                return  (Boolean) em.createNativeQuery("SELECT  case WHEN (COUNT(*) = 0)  THEN TRUE ELSE FALSE END FROM troutee.client c WHERE c.id NOT IN (?1) AND earth_box(ll_to_earth(?2,?3), 25) @> ll_to_earth(c.lat, c.lon)").setParameter(1,id).setParameter(2,latitude).setParameter(3, longitude).getSingleResult();
            } catch (NoResultException nre) {
                return null;
            }
        }
    }

    public List<Client> find_by_name(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("client name is required");
        } else {
            try {
                return  (List<Client>) em.createNamedQuery("Client.findbyname").setParameter(1,name).getResultList();
            } catch (NoResultException nre) {
                return null;
            }
        }
    }

    public List<Client> find_by_code(String code) {
        if (code == null || code.isEmpty()) {
            throw new IllegalArgumentException("client code is required");
        } else {
            try {
                return  (List<Client>) em.createNamedQuery("Client.findbycode").setParameter(1,code).getResultList();
            } catch (NoResultException nre) {
                return null;
            }
        }
    }

    public List<Client> find_all() {
        try {
            return  (List<Client>) em.createNamedQuery("Client.findall").getResultList();
        } catch (NoResultException nre) {
            return null;
        }
    }

    public List<Client> find_all_range(List<Integer> rangeids) {
        if(rangeids==null || rangeids.isEmpty()){
            throw new IllegalArgumentException("ids range is required");
        }else{
            try {
                return  (List<Client>) em.createNamedQuery("Client.findallRange").setParameter(1,rangeids).getResultList();
            } catch (NoResultException nre) {
                return null;
            }
        }
    }
}
