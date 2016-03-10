package com.troutee.api.beans.session.decl;

import com.troutee.domain.Session;

/**
 * Created by vicente on 09/03/16.
 */
public interface SessionCreator {

    public Session create(Session session);

}
