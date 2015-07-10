package com.chelyadin.test.address_book.domain;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.List;

/**
 * @author Dmitriy Chelyadin
 */
// TODO validation for fields
@Entity
@Table(name = "addresses")
public class Address {

    @Id
    @Column(name = "id", updatable = false)
    @GeneratedValue
    private Long id;

    @NotEmpty
    @Length(max = 100)
    @Column(name = "fullname", length = 100, nullable = false)
    private String fullname;

    @NotEmpty
    @Length(max = 9)
    @Column(name = "postcode", length = 9, nullable = false)
    private String postcode; // zip / postal code

    @NotEmpty
    @Length(max = 70)
    @Column(name = "country", length = 70, nullable = false)
    private String country;

    @Length(max = 70)
    @Column(name = "region", length = 70)
    private String region; // state / province / region / county

    @NotEmpty
    @Length(max = 70)
    @Column(name = "city", length = 70, nullable = false)
    private String city;

    @NotEmpty
    @Length(max = 100)
    @Column(name = "address1", length = 100, nullable = false)
    private String address1; // street address and house number

    @Length(max = 100)
    @Column(name = "address2", length = 100)
    private String address2; // appartment, unit, building, floor

    @ElementCollection
    @CollectionTable(
            name="phones",
            joinColumns=@JoinColumn(name="address_id")
    )
    @Column(name="phone", length = 30)
    private List<String> phones; // TODO validation

    public Address() {}

    public Address(String fullname, String postcode, String country, String region, String city,
                   String address1, String address2, List<String> phones) {
        this.fullname = fullname;
        this.postcode = postcode;
        this.country = country;
        this.region = region;
        this.city = city;
        this.address1 = address1;
        this.address2 = address2;
        this.phones = phones;
    }

    public Long getId() {
        return id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (address1 != null ? !address1.equals(address.address1) : address.address1 != null) return false;
        if (address2 != null ? !address2.equals(address.address2) : address.address2 != null) return false;
        if (city != null ? !city.equals(address.city) : address.city != null) return false;
        if (country != null ? !country.equals(address.country) : address.country != null) return false;
        if (fullname != null ? !fullname.equals(address.fullname) : address.fullname != null) return false;
        if (id != null ? !id.equals(address.id) : address.id != null) return false;
        if (phones != null ? !phones.equals(address.phones) : address.phones != null) return false;
        if (postcode != null ? !postcode.equals(address.postcode) : address.postcode != null) return false;
        if (region != null ? !region.equals(address.region) : address.region != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (fullname != null ? fullname.hashCode() : 0);
        result = 31 * result + (postcode != null ? postcode.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (region != null ? region.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (address1 != null ? address1.hashCode() : 0);
        result = 31 * result + (address2 != null ? address2.hashCode() : 0);
        result = 31 * result + (phones != null ? phones.hashCode() : 0);
        return result;
    }
}
