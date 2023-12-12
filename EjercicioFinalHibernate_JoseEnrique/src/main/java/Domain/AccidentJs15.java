/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Domain;

import java.io.Serializable;
import java.util.Collection;

import jakarta.persistence.*;

/**
 *
 * @author joshue
 */
@Entity
@Table(name = "accident_js15")
@NamedQueries({
    @NamedQuery(name = "AccidentJs15.findAll", query = "SELECT a FROM AccidentJs15 a"),
    @NamedQuery(name = "AccidentJs15.findByReportNumber", query = "SELECT a FROM AccidentJs15 a WHERE a.reportNumber = :reportNumber"),
    @NamedQuery(name = "AccidentJs15.findByLocation", query = "SELECT a FROM AccidentJs15 a WHERE a.location = :location")})
public class AccidentJs15 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "REPORT_NUMBER")
    private String reportNumber;
    @Column(name = "LOCATION")
    private String location;

    //Habia que cambiar esto para recibir el coche desde la base de datos por la table puente participated
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "participated_js15",
            joinColumns = {
                    @JoinColumn(name = "REPORT_NUMBER")},
            inverseJoinColumns = {
                    @JoinColumn(name = "LICENSE_ID")})
    private Collection<CarJs15> carJs15Collection;

    public AccidentJs15() {
    }

    public AccidentJs15(String reportNumber, String location, Collection<CarJs15> carJs15Collection) {
        this.reportNumber = reportNumber;
        this.location = location;
        this.carJs15Collection = carJs15Collection;
    }

    public AccidentJs15(String reportNumber) {
        this.reportNumber = reportNumber;
    }

    public String getReportNumber() {
        return reportNumber;
    }

    public void setReportNumber(String reportNumber) {
        this.reportNumber = reportNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Collection<CarJs15> getCarJs15Collection() {
        return carJs15Collection;
    }

    public void setCarJs15Collection(Collection<CarJs15> carJs15Collection) {
        this.carJs15Collection = carJs15Collection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reportNumber != null ? reportNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AccidentJs15)) {
            return false;
        }
        AccidentJs15 other = (AccidentJs15) object;
        if ((this.reportNumber == null && other.reportNumber != null) || (this.reportNumber != null && !this.reportNumber.equals(other.reportNumber))) {
            return false;
        }
        return true;
    }


    public String toString1() {
        return "AccidentJs15{" + "reportNumber=" + reportNumber + ", location=" + location + ", carJs15Collection=" + carJs15Collection.toString() + '}';
    }

    @Override
    public String toString() {
        return "AccidentJs15{" + "reportNumber=" + reportNumber + ", location=" + location + '}';
    }

}
