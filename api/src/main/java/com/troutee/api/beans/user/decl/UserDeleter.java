package com.troutee.api.beans.user.decl;

import com.troutee.domain.Tuser;

/**
 * Created by vicente on 29/02/16.
 */
public interface UserDeleter {
    public void delete (Tuser storeUser);
    public void deleteById (Long id);
}
