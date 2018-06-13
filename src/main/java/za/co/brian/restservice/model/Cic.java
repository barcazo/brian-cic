package za.co.brian.restservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@javax.persistence.Entity
public class Cic implements Serializable {

    private static final long serialVersionUID = 8859833304544887154L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID", nullable=false)
    @Access(AccessType.PROPERTY)
    private long cicId;

    @Column(name="TYPE", nullable=false)
    @Access(AccessType.PROPERTY)
    private String cicType;

    @Column(name="SUBJECT", nullable=false)
    @Access(AccessType.PROPERTY)
    private String subject;

    @Column(name="BODY", nullable=false)
    @Access(AccessType.PROPERTY)
    private String body;

    @Column(name="SOURCE_SYSTEM", nullable=false)
    @Access(AccessType.PROPERTY)
    private String sourceSystem;

    @Column(name="CIC_TIMESTAMP", nullable=false)
    @Temporal(TemporalType.TIMESTAMP)
    @Access(AccessType.PROPERTY)
    private Date cicTimestamp;

    /**
     * @return the cicId
     */
    public long getCicId() {
        return cicId;
    }

    /**
     * @param cicId the cicId to set
     */
    public void setCicId(long cicId) {
        this.cicId = cicId;
    }

    /**
     * @return the cicType
     */
    public String getCicType() {
        return cicType;
    }

    /**
     * @param cicType the cicType to set
     */
    public void setCicType(String cicType) {
        this.cicType = cicType;
    }

    /**
     * @return the subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * @return the body
     */
    public String getBody() {
        return body;
    }

    /**
     * @param body the body to set
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * @return the sourceSystem
     */
    public String getSourceSystem() {
        return sourceSystem;
    }

    /**
     * @param sourceSystem the sourceSystem to set
     */
    public void setSourceSystem(String sourceSystem) {
        this.sourceSystem = sourceSystem;
    }

    /**
     * @return the cicTimestamp
     */
    public Date getCicTimestamp() {
        return cicTimestamp;
    }

    /**
     * @param cicTimestamp the cicTimestamp to set
     */
    public void setCicTimestamp(Date cicTimestamp) {
        this.cicTimestamp = cicTimestamp;
    }

    public za.co.brian.restservice.model.Entity getEntity() {
        return entity;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "entity_id", nullable = false, updatable = false)
    private Entity entity;

    public Cic() {
    }

    public Cic(String cicType, String subject, String body, String sourceSystem, Date cicTimestamp, Entity entity) {
        this.cicType = cicType;
        this.subject = subject;
        this.body = body;
        this.sourceSystem = sourceSystem;
        this.cicTimestamp = cicTimestamp;
        this.entity = entity;
    }

    public void setEntity(za.co.brian.restservice.model.Entity entity) {
        this.entity = entity;
    }
}
