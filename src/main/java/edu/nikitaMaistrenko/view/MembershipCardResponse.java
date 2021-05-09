package edu.nikitaMaistrenko.view;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import edu.nikitaMaistrenko.view.dateconverter.LocalDateStringConverter;
import edu.nikitaMaistrenko.view.dateconverter.StringLocalDateConverter;

import java.time.LocalDate;


public class MembershipCardResponse {

    private String lastName;
    private String firstName;
    private String typeOfMembershipId;
    private Integer markedWorkouts;
    @JsonSerialize(converter = LocalDateStringConverter.class)
    @JsonDeserialize(converter = StringLocalDateConverter.class)
    private LocalDate expiredDate;
    @JsonSerialize(converter = LocalDateStringConverter.class)
    @JsonDeserialize(converter = StringLocalDateConverter.class)
    private LocalDate purposeDate;

    public MembershipCardResponse() {
    }

    public MembershipCardResponse(String lastName, String firstName, String typeOfMembershipId, Integer markedWorkouts, LocalDate expiredDate, LocalDate purposeDate) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.typeOfMembershipId = typeOfMembershipId;
        this.markedWorkouts = markedWorkouts;
        this.expiredDate = expiredDate;
        this.purposeDate = purposeDate;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getTypeOfMembershipId() {
        return typeOfMembershipId;
    }

    public void setTypeOfMembershipId(String typeOfMembershipId) {
        this.typeOfMembershipId = typeOfMembershipId;
    }

    public Integer getMarkedWorkouts() {
        return markedWorkouts;
    }

    public void setMarkedWorkouts(Integer markedWorkouts) {
        this.markedWorkouts = markedWorkouts;
    }

    public LocalDate getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(LocalDate expiredDate) {
        this.expiredDate = expiredDate;
    }

    public LocalDate getPurposeDate() {
        return purposeDate;
    }

    public void setPurposeDate(LocalDate purposeDate) {
        this.purposeDate = purposeDate;
    }
}
