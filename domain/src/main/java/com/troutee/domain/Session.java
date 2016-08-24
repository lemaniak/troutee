package com.troutee.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by vicente on 09/03/16.
 */
@Entity
@Table(name = "sessions", catalog = "troutee", schema = "troutee")
public class Session implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "token")
    private String token;
    @Basic(optional = false)
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;
    @JoinColumn(name = "tuser_id", referencedColumnName = "id")
    @ManyToOne
    private Tuser tuser;

    public Session() {
    }

    public Session(Integer id, String token, Status status, Tuser tuser) {
        this.id = id;
        this.token = token;
        this.status=status;
        this.tuser = tuser;
    }

    public Session(String token, Status status, Tuser tuser) {
        this.token = token;
        this.status = status;
        this.tuser = tuser;
    }

    /**
     * @see Object#toString()
     */
    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Tuser getTuser() {
        return tuser;
    }

    public void setTuser(Tuser tuser) {
        this.tuser = tuser;
    }

    @Override
    public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder();
        hcb.append(this.id);
        return hcb.toHashCode();
    }

    /**
     * @see Object#equals(Object)
     */
    @Override
    public boolean equals(Object obj) {
        boolean equals = false;
        if (Session.class.isInstance(obj)) {
            Session session = Session.class.cast(obj);
            EqualsBuilder eb = new EqualsBuilder();
            eb.append(this.id, session.getId());
            equals = eb.isEquals();
        }
        return equals;
    }



}