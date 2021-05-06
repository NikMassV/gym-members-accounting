package edu.nikitaMaistrenko.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import edu.nikitaMaistrenko.view.dateconverter.LocalDateStringConverter;
import edu.nikitaMaistrenko.view.dateconverter.StringLocalDateConverter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Table(name = "member")
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @JsonSerialize(converter = LocalDateStringConverter.class)
    @JsonDeserialize(converter = StringLocalDateConverter.class)
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "tel_number")
    private String telNumber;

    @Column(name = "sex")
    private String sex;

    @Column(name = "source_of_advertising")
    private String sourceOfAdvertising;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
    @Column(name = "membership_cards")
    private List<MembershipCard> membershipCards;

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

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

    public List<MembershipCard> getMembershipCards() {
        return membershipCards;
    }

    public void setMembershipCards(List<MembershipCard> membershipCards) {
        this.membershipCards = membershipCards;
    }
}
