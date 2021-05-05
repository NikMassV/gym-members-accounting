package edu.nikitaMaistrenko.view;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import edu.nikitaMaistrenko.view.dateconverter.LocalDateStringConverter;
import edu.nikitaMaistrenko.view.dateconverter.StringLocalDateConverter;

import java.time.LocalDate;

public class MemberRequest {

    private String firstName;
    private String lastName;
    @JsonSerialize(converter = LocalDateStringConverter.class)
    @JsonDeserialize(converter = StringLocalDateConverter.class)
    private LocalDate dateOfBirth;
    private String telNumber;
    private String sex;
    private String sourceOfAdvertising;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSourceOfAdvertising() {
        return sourceOfAdvertising;
    }

    public void setSourceOfAdvertising(String sourceOfAdvertising) {
        this.sourceOfAdvertising = sourceOfAdvertising;
    }
}
