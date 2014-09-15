package jp.co.sampleProj.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.persistence.Table;

import java.sql.Timestamp;


@Entity
@Table(name="LOGIN_HISTORY")
public class LoginHistory {

    @Column(name="LOGIN_ID")
    public String loginId;

    @Column(name="LOGIN_SEQ")
    public Integer loginSeq;

    @Temporal(TemporalType.DATE)
    @Column(name="LOGIN_DATE")
    public Timestamp loginDate;

}