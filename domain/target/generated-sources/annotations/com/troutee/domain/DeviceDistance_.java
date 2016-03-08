package com.troutee.domain;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DeviceDistance.class)
public abstract class DeviceDistance_ {

	public static volatile SingularAttribute<DeviceDistance, Integer> id;
	public static volatile SingularAttribute<DeviceDistance, Double> distance;
	public static volatile SingularAttribute<DeviceDistance, String> distanceUnit;
	public static volatile SingularAttribute<DeviceDistance, Date> distanceDate;
	public static volatile SingularAttribute<DeviceDistance, Device> deviceId;

}

