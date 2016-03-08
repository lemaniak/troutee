package com.troutee.domain;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Device.class)
public abstract class Device_ {

	public static volatile SingularAttribute<Device, String> phone;
	public static volatile SingularAttribute<Device, Date> trackStartTime;
	public static volatile SingularAttribute<Device, Status> status;
	public static volatile SingularAttribute<Device, Date> trackEndTime;
	public static volatile SingularAttribute<Device, String> lastname;
	public static volatile SingularAttribute<Device, String> image;
	public static volatile SingularAttribute<Device, String> firstname;
	public static volatile SingularAttribute<Device, String> code;
	public static volatile SingularAttribute<Device, Integer> id;
	public static volatile SingularAttribute<Device, Integer> trackValue;
	public static volatile SingularAttribute<Device, Tuser> userId;
	public static volatile SingularAttribute<Device, String> trackUnit;
	public static volatile SingularAttribute<Device, TrackStatus> trackStatus;

}

