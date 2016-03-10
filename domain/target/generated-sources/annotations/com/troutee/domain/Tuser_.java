package com.troutee.domain;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Tuser.class)
public abstract class Tuser_ {

	public static volatile SingularAttribute<Tuser, Integer> id;
	public static volatile SingularAttribute<Tuser, Date> lastLogin;
	public static volatile SingularAttribute<Tuser, Status> status;
	public static volatile SingularAttribute<Tuser, String> email;
	public static volatile SingularAttribute<Tuser, Date> createdAt;
	public static volatile SingularAttribute<Tuser, String> image;
	public static volatile SingularAttribute<Tuser, String> lastname;
	public static volatile SingularAttribute<Tuser, String> firstname;
	public static volatile SingularAttribute<Tuser, String> credential;

}

