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
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

/**
 *
 * @author joshue
 */
@Entity
@Table(name = "person_js15")
@NamedQueries({
    @NamedQuery(name = "PersonJs15.findAll", query = "SELECT p FROM PersonJs15 p"),
    @NamedQuery(name = "PersonJs15.findByDriverId", query = "SELECT p FROM PersonJs15 p WHERE p.driverId = :driverId"),
    @NamedQuery(name = "PersonJs15.findByAddress", query = "SELECT p FROM PersonJs15 p WHERE p.address = :address"),
    @NamedQuery(name = "PersonJs15.findByName", query = "SELECT p FROM PersonJs15 p WHERE p.name = :name")})
public class PersonJs15 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "DRIVER_ID")
    private String driverId;
    @Column(name = "ADDRESS")
    private String address;
    @Column(name = "NAME")
    private String name;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "driverId")
    private Collection<CarJs15> carJs15Collection;

    public PersonJs15() {
    }

    public PersonJs15(String driverId, String address, String name, Collection<CarJs15> carJs15Collection) {
        this.driverId = driverId;
        this.address = address;
        this.name = name;
        this.carJs15Collection = carJs15Collection;
    }
    
   
    public PersonJs15(String driverId) {
        this.driverId = driverId;
    }

    public PersonJs15(String driverId, String address, String name) {
        this.driverId = driverId;
        this.address = address;
        this.name = name;
    }

    

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        hash += (driverId != null ? driverId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PersonJs15)) {
            return false;
        }
        PersonJs15 other = (PersonJs15) object;
        if ((this.driverId == null && other.driverId != null) || (this.driverId != null && !this.driverId.equals(other.driverId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "PersonJs15{" + "driverId=" + driverId + ", address=" + address + ", name=" + name +'}';
    }

    public String toString1() {
        return "PersonJs15{" + "driverId=" + driverId + ", address=" + address + ", name=" + name + ", carJs15Collection=" + carJs15Collection + '}';
    }


    
}
