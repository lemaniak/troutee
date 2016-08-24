package com.troutee.domain;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ClientVisit.class)
public abstract class ClientVisit_ {

	public static volatile SingularAttribute<ClientVisit, Integer> id;
	public static volatile SingularAttribute<ClientVisit, Date> lastLogin;
	public static volatile SingularAttribute<ClientVisit, Double> lon;
	public static volatile SingularAttribute<ClientVisit, Tuser> userId;
	public static volatile SingularAttribute<ClientVisit, Double> lat;
	public static volatile SingularAttribute<ClientVisit, Client> clientId;

}

