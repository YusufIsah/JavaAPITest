/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Yusuf
 */
@Entity
@Table(name = "emp")
@NamedQueries({
    @NamedQuery(name = "Emp.findAll", query = "SELECT e FROM Emp e")
    , @NamedQuery(name = "Emp.findByEmpId", query = "SELECT e FROM Emp e WHERE e.empId = :empId")
    , @NamedQuery(name = "Emp.findByEmpName", query = "SELECT e FROM Emp e WHERE e.empName = :empName")
    , @NamedQuery(name = "Emp.findByJob", query = "SELECT e FROM Emp e WHERE e.job = :job")
    , @NamedQuery(name = "Emp.findByMgr", query = "SELECT e FROM Emp e WHERE e.mgr = :mgr")
    , @NamedQuery(name = "Emp.findByHiredate", query = "SELECT e FROM Emp e WHERE e.hiredate = :hiredate")
    , @NamedQuery(name = "Emp.findBySalary", query = "SELECT e FROM Emp e WHERE e.salary = :salary")
    , @NamedQuery(name = "Emp.findByComm", query = "SELECT e FROM Emp e WHERE e.comm = :comm")})
public class Emp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "empId")
    private Integer empId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "empName")
    private String empName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "job")
    private String job;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "mgr")
    private String mgr;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hiredate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date hiredate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "salary")
    private long salary;
    @Basic(optional = false)
    @NotNull
    @Column(name = "comm")
    private long comm;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empId")
    private List<Dept> deptList;

    public Emp() {
    }

    public Emp(Integer empId) {
        this.empId = empId;
    }

    public Emp(Integer empId, String empName, String job, String mgr, Date hiredate, long salary, long comm) {
        this.empId = empId;
        this.empName = empName;
        this.job = job;
        this.mgr = mgr;
        this.hiredate = hiredate;
        this.salary = salary;
        this.comm = comm;
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getMgr() {
        return mgr;
    }

    public void setMgr(String mgr) {
        this.mgr = mgr;
    }

    public Date getHiredate() {
        return hiredate;
    }

    public void setHiredate(Date hiredate) {
        this.hiredate = hiredate;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public long getComm() {
        return comm;
    }

    public void setComm(long comm) {
        this.comm = comm;
    }

    public List<Dept> getDeptList() {
        return deptList;
    }

    public void setDeptList(List<Dept> deptList) {
        this.deptList = deptList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empId != null ? empId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Emp)) {
            return false;
        }
        Emp other = (Emp) object;
        if ((this.empId == null && other.empId != null) || (this.empId != null && !this.empId.equals(other.empId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Emp[ empId=" + empId + " ]";
    }
    
}
