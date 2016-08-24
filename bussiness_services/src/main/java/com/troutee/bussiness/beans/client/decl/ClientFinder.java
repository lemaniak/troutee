package com.troutee.bussiness.beans.client.decl;

import com.troutee.domain.Client;

import java.util.List;

/**
 * Created by vicente on 27/06/16.
 */
public interface ClientFinder {

    Client find_by_id(Integer id);
    Boolean isUniqueCoodinates(Integer id,Double latitude,Double longitude);
    List<Client> find_by_name(String name);
    List<Client> find_by_code(String code);
    List<Client> find_all();
    List<Client> find_all_range(List<Integer> rangeids);

}
