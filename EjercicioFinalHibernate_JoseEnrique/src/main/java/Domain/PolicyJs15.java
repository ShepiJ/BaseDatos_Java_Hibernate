/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

import java.io.Serializable;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 *
 * @author joshue
 */
@Entity
@Table(name = "policy_js15")
@NamedQueries({
    @NamedQuery(name = "PolicyJs15.findAll", query = "SELECT p FROM PolicyJs15 p"),
    @NamedQuery(name = "PolicyJs15.findByPolicyId", query = "SELECT p FROM PolicyJs15 p WHERE p.policyId = :policyId")})
public class PolicyJs15 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "POLICY_ID")
    private String policyId;
    @JoinColumn(name = "LICENSE_ID", referencedColumnName = "LICENSE_ID")
    @OneToOne(optional = false)
    private CarJs15 licenseId;

    public PolicyJs15(String policyId, CarJs15 licenseId) {
        this.policyId = policyId;
        this.licenseId = licenseId;
    }
    
    public PolicyJs15() {
    }

    public PolicyJs15(String policyId) {
        this.policyId = policyId;
    }

    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }

    public CarJs15 getLicenseId() {
        return licenseId;
    }

    public void setLicenseId(CarJs15 licenseId) {
        this.licenseId = licenseId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (policyId != null ? policyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PolicyJs15)) {
            return false;
        }
        PolicyJs15 other = (PolicyJs15) object;
        if ((this.policyId == null && other.policyId != null) || (this.policyId != null && !this.policyId.equals(other.policyId))) {
            return false;
        }
        return true;
    }


    public String toString1() {
        return "PolicyJs15{" + "policyId=" + policyId + ", licenseId=" + licenseId + '}';
    }

    @Override
    public String toString() {
        return "PolicyJs15{" + "policyId=" + policyId +  '}';
    }
    
}
