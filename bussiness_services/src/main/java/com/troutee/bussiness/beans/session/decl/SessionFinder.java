package com.troutee.bussiness.beans.session.decl;

import com.troutee.domain.Session;
import com.troutee.domain.Tuser;

/**
 * Created by vicente on 04/04/16.
 */
public interface SessionFinder {

    Session find(String token);

    Session get(String token);

    Tuser getUserFromToken(String token);
}
