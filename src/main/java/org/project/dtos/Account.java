package org.project.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

public class Account {
    private String name;
    private String email;
    private String password;
    private String title;

    @JsonProperty("birth_date")
    private String birthDate;

    @JsonProperty("birth_month")
    private String birthMonth;

    @JsonProperty("birth_year")
    private String birthYear;

    private String firstname;
    private String lastname;
    private String company;
    private String address1;
    private String address2;
    private String country;
    private String zipcode;
    private String state;
    private String city;

    @JsonProperty("mobile_number")
    private String mobileNumber;

    public Account() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(String birthMonth) {
        this.birthMonth = birthMonth;
    }

    public String getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public Map<String, String> toMap() {
        Map<String, String> map = new HashMap<>();
        map.put("name", this.name);
        map.put("email", this.email);
        map.put("password", this.password);
        map.put("title", this.title);
        map.put("birth_date", this.birthDate);
        map.put("birth_month", this.birthMonth);
        map.put("birth_year", this.birthYear);
        map.put("firstname", this.firstname);
        map.put("lastname", this.lastname);
        map.put("company", this.company);
        map.put("address1", this.address1);
        map.put("address2", this.address2);
        map.put("country", this.country);
        map.put("zipcode", this.zipcode);
        map.put("state", this.state);
        map.put("city", this.city);
        map.put("mobile_number", this.mobileNumber);
        return map;
    }

    public static class Builder {
        private Account account;

        public Builder() {
            account = new Account();
        }

        public Builder name(String name) {
            account.name = name;
            return this;
        }

        public Builder email(String email) {
            account.email = email;
            return this;
        }

        public Builder password(String password) {
            account.password = password;
            return this;
        }

        public Builder title(String title) {
            account.title = title;
            return this;
        }

        public Builder birthDate(String birthDate) {
            account.birthDate = birthDate;
            return this;
        }

        public Builder birthMonth(String birthMonth) {
            account.birthMonth = birthMonth;
            return this;
        }

        public Builder birthYear(String birthYear) {
            account.birthYear = birthYear;
            return this;
        }

        public Builder firstname(String firstname) {
            account.firstname = firstname;
            return this;
        }

        public Builder lastname(String lastname) {
            account.lastname = lastname;
            return this;
        }

        public Builder company(String company) {
            account.company = company;
            return this;
        }

        public Builder address1(String address1) {
            account.address1 = address1;
            return this;
        }

        public Builder address2(String address2) {
            account.address2 = address2;
            return this;
        }

        public Builder country(String country) {
            account.country = country;
            return this;
        }

        public Builder zipcode(String zipcode) {
            account.zipcode = zipcode;
            return this;
        }

        public Builder state(String state) {
            account.state = state;
            return this;
        }

        public Builder city(String city) {
            account.city = city;
            return this;
        }

        public Builder mobileNumber(String mobileNumber) {
            account.mobileNumber = mobileNumber;
            return this;
        }

        public Account build() {
            return account;
        }
    }
}