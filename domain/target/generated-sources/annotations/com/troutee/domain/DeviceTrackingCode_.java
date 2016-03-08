package com.troutee.domain;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DeviceTrackingCode.class)
public abstract class DeviceTrackingCode_ {

	public static volatile SingularAttribute<DeviceTrackingCode, Integer> id;
	public static volatile SingularAttribute<DeviceTrackingCode, Date> expiresAt;
	public static volatile SingularAttribute<DeviceTrackingCode, Status> status;
	public static volatile SingularAttribute<DeviceTrackingCode, String> code;
	public static volatile SingularAttribute<DeviceTrackingCode, Device> deviceId;

}

