package com.troutee.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Client.class)
public abstract class Client_ {

	public static volatile SingularAttribute<Client, Integer> id;
	public static volatile SingularAttribute<Client, Double> lon;
	public static volatile SingularAttribute<Client, String> phone;
	public static volatile SingularAttribute<Client, ClientStatus> status;
	public static volatile SingularAttribute<Client, String> name;
	public static volatile SingularAttribute<Client, Double> lat;

}

