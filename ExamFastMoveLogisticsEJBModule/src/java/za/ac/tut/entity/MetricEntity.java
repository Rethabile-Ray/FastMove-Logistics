/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author mokau
 */
@Entity
public class MetricEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String empName;
    private Long staffID;
    private Integer totalBatches;
    private Integer numPristine;
    private Integer numTolerable;
    private Integer numCriticalDiscrepancy;
    private Integer EfficiencyIndex;
    private String listTokens;
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    public MetricEntity(String id, String empName, Long staffID, Integer totalBatches, Integer numPristine, Integer numTolerable, Integer numCriticalDiscrepancy, Integer EfficiencyIndex, String listTokens, Date creationDate) {
        this.id = id;
        this.empName = empName;
        this.staffID = staffID;
        this.totalBatches = totalBatches;
        this.numPristine = numPristine;
        this.numTolerable = numTolerable;
        this.numCriticalDiscrepancy = numCriticalDiscrepancy;
        this.EfficiencyIndex = EfficiencyIndex;
        this.listTokens = listTokens;
        this.creationDate = creationDate;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Long getStaffID() {
        return staffID;
    }

    public void setStaffID(Long staffID) {
        this.staffID = staffID;
    }

    public Integer getTotalBatches() {
        return totalBatches;
    }

    public void setTotalBatches(Integer totalBatches) {
        this.totalBatches = totalBatches;
    }

    public Integer getNumPristine() {
        return numPristine;
    }

    public void setNumPristine(Integer numPristine) {
        this.numPristine = numPristine;
    }

    public Integer getNumTolerable() {
        return numTolerable;
    }

    public void setNumTolerable(Integer numTolerable) {
        this.numTolerable = numTolerable;
    }

    public Integer getNumCriticalDiscrepancy() {
        return numCriticalDiscrepancy;
    }

    public void setNumCriticalDiscrepancy(Integer numCriticalDiscrepancy) {
        this.numCriticalDiscrepancy = numCriticalDiscrepancy;
    }

    public Integer getEfficiencyIndex() {
        return EfficiencyIndex;
    }

    public void setEfficiencyIndex(Integer EfficiencyIndex) {
        this.EfficiencyIndex = EfficiencyIndex;
    }

    public String getListTokens() {
        return listTokens;
    }

    public void setListTokens(String listTokens) {
        this.listTokens = listTokens;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public MetricEntity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MetricEntity)) {
            return false;
        }
        MetricEntity other = (MetricEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "za.ac.tut.entity.MetricEntity[ id=" + id + " ]";
    }
    
}
