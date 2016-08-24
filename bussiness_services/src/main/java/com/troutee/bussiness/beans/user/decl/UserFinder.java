package com.troutee.bussiness.beans.user.decl;

import com.troutee.domain.Tuser;

/**
 * Created by vicente on 29/02/16.
 */
public interface UserFinder {

    Tuser find(Integer id);

    Tuser get(Integer id);

    Tuser findByEmail(String email);

    Tuser getByEmail(String email);

    Boolean isEmailRegistered(String email);

    Boolean userExistsById(Integer id);
}
