/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Yusuf
 */
@Entity
@Table(name = "dept")
@NamedQueries({
    @NamedQuery(name = "Dept.findAll", query = "SELECT d FROM Dept d")
    , @NamedQuery(name = "Dept.findByDeptId", query = "SELECT d FROM Dept d WHERE d.deptId = :deptId")
    , @NamedQuery(name = "Dept.findByDeptNo", query = "SELECT d FROM Dept d WHERE d.deptNo = :deptNo")
    , @NamedQuery(name = "Dept.findByDeptName", query = "SELECT d FROM Dept d WHERE d.deptName = :deptName")
    , @NamedQuery(name = "Dept.findByLocation", query = "SELECT d FROM Dept d WHERE d.location = :location")})
public class Dept implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "deptId")
    private Integer deptId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "deptNo")
    private int deptNo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "deptName")
    private String deptName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "location")
    private String location;
    @JoinColumn(name = "empId", referencedColumnName = "empId")
    @ManyToOne(optional = false)
    private Emp empId;

    public Dept() {
    }

    public Dept(Integer deptId) {
        this.deptId = deptId;
    }

    public Dept(Integer deptId, int deptNo, String deptName, String location) {
        this.deptId = deptId;
        this.deptNo = deptNo;
        this.deptName = deptName;
        this.location = location;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public int getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(int deptNo) {
        this.deptNo = deptNo;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Emp getEmpId() {
        return empId;
    }

    public void setEmpId(Emp empId) {
        this.empId = empId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (deptId != null ? deptId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dept)) {
            return false;
        }
        Dept other = (Dept) object;
        if ((this.deptId == null && other.deptId != null) || (this.deptId != null && !this.deptId.equals(other.deptId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.entity.Dept[ deptId=" + deptId + " ]";
    }
    
}
