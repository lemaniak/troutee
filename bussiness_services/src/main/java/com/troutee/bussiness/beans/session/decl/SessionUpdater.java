package com.troutee.bussiness.beans.session.decl;

/**
 * Created by vicente on 09/03/16.
 */
public interface SessionUpdater {

     void disableUserTokens(Integer id);

     void disableUserToken(String token);
}
