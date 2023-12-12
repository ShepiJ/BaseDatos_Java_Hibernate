/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

import java.io.Serializable;
import java.util.Collection;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

/**
 *
 * @author joshue
 */
@Entity
@Table(name = "car_js15")
@NamedQueries({
    @NamedQuery(name = "CarJs15.findAll", query = "SELECT c FROM CarJs15 c"),
    @NamedQuery(name = "CarJs15.findByLicenseId", query = "SELECT c FROM CarJs15 c WHERE c.licenseId = :licenseId"),
    @NamedQuery(name = "CarJs15.findByModel", query = "SELECT c FROM CarJs15 c WHERE c.model = :model"),
    @NamedQuery(name = "CarJs15.findByYear", query = "SELECT c FROM CarJs15 c WHERE c.year = :year")})
public class CarJs15 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "LICENSE_ID")
    private String licenseId;
    @Column(name = "MODEL")
    private String model;
    @Column(name = "YEAR")
    private Integer year;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "participated_js15", joinColumns = {
            @JoinColumn(name = "LICENSE_ID", referencedColumnName = "LICENSE_ID")}, inverseJoinColumns = {
            @JoinColumn(name = "REPORT_NUMBER", referencedColumnName = "REPORT_NUMBER")})
    private Collection<AccidentJs15> accidentJs15Collection;
    @OneToOne(mappedBy = "licenseId")
    private PolicyJs15 policyJs15;
    @ManyToOne(optional = false)
    @JoinColumn(name = "DRIVER_ID", referencedColumnName = "DRIVER_ID")
    private PersonJs15 driverId;

    public CarJs15() {
    }

    public CarJs15(String licenseId, String model, Integer year, PersonJs15 driverId) {
        this.licenseId = licenseId;
        this.model = model;
        this.year = year;
        this.driverId = driverId;
    }

    public CarJs15(String licenseId) {
        this.licenseId = licenseId;
    }

    public String getLicenseId() {
        return licenseId;
    }

    public void setLicenseId(String licenseId) {
        this.licenseId = licenseId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Collection<AccidentJs15> getAccidentJs15Collection() {
        return accidentJs15Collection;
    }

    public void setAccidentJs15Collection(Collection<AccidentJs15> accidentJs15Collection) {
        this.accidentJs15Collection = accidentJs15Collection;
    }

    public PolicyJs15 getPolicyJs15() {
        return policyJs15;
    }

    public void setPolicyJs15(PolicyJs15 policyJs15) {
        this.policyJs15 = policyJs15;
    }

    public PersonJs15 getDriverId() {
        return driverId;
    }

    public void setDriverId(PersonJs15 driverId) {
        this.driverId = driverId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (licenseId != null ? licenseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CarJs15)) {
            return false;
        }
        CarJs15 other = (CarJs15) object;
        if ((this.licenseId == null && other.licenseId != null) || (this.licenseId != null && !this.licenseId.equals(other.licenseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "CarJs15{" + "licenseId=" + licenseId + ", model=" + model + ", year=" + year + '}';
    }

    public String toString1() {
        return "CarJs15{" + "licenseId=" + licenseId + ", model=" + model + ", year=" + year + ", accidentJs15Collection=" + accidentJs15Collection + ", policyJs15=" + policyJs15 + '}';

    }

        public String toString2() {
            return "CarJs15{" + "licenseId=" + licenseId + ", model=" + model + ", year=" + year + ", persona=" + driverId +  ", accidentJs15Collection=" + accidentJs15Collection + ", policyJs15=" + policyJs15 + '}';

    }

}
