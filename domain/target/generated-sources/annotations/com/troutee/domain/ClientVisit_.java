package com.troutee.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ClientVisit.class)
public abstract class ClientVisit_ {

	public static volatile SingularAttribute<ClientVisit, Integer> id;
	public static volatile SingularAttribute<ClientVisit, TrackHistory> trackHistoryId;
	public static volatile SingularAttribute<ClientVisit, Device> deviceId;
	public static volatile SingularAttribute<ClientVisit, Client> clientId;

}

