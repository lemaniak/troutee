package com.troutee.domain;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DeviceTracking.class)
public abstract class DeviceTracking_ {

	public static volatile SingularAttribute<DeviceTracking, Integer> id;
	public static volatile SingularAttribute<DeviceTracking, Device> deviceId;
	public static volatile SingularAttribute<DeviceTracking, Day> dayOfWeek;

}

