package com.troutee.domain;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TrackHistory.class)
public abstract class TrackHistory_ {

	public static volatile SingularAttribute<TrackHistory, Integer> id;
	public static volatile SingularAttribute<TrackHistory, Double> lon;
	public static volatile SingularAttribute<TrackHistory, Date> trackLastTimestamp;
	public static volatile SingularAttribute<TrackHistory, Date> trackFirstTimestamp;
	public static volatile SingularAttribute<TrackHistory, Device> deviceId;
	public static volatile SingularAttribute<TrackHistory, Double> lat;

}

