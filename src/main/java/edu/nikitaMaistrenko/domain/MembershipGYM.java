package edu.nikitaMaistrenko.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Table(name = "membership_gym")
@Entity
public class MembershipGYM {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "membership_gym_id")
    private Long membershipGYMId;

    @Column(name = "type_of_membership_gym")
    private String typeOfMembershipGYM;

    @Column(name = "number_of_workouts")
    private Integer number_of_workouts;

    @Column(name = "validity_months")
    private Integer validityMonths;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "membershipGYM")
    private List<MembershipCard> membershipCards;

    public Long getMembershipGYMId() {
        return membershipGYMId;
    }

    public void setMembershipGYMId(Long membershipGYMId) {
        this.membershipGYMId = membershipGYMId;
    }

    public String getTypeOfMembershipGYM() {
        return typeOfMembershipGYM;
    }

    public void setTypeOfMembershipGYM(String typeOfMembershipGYM) {
        this.typeOfMembershipGYM = typeOfMembershipGYM;
    }

    public Integer getNumber_of_workouts() {
        return number_of_workouts;
    }

    public void setNumber_of_workouts(Integer number_of_workouts) {
        this.number_of_workouts = number_of_workouts;
    }

    public Integer getValidityMonths() {
        return validityMonths;
    }

    public void setValidityMonths(Integer validityMonths) {
        this.validityMonths = validityMonths;
    }

    public List<MembershipCard> getMembershipCards() {
        return membershipCards;
    }

    public void setMembershipCards(List<MembershipCard> membershipCards) {
        this.membershipCards = membershipCards;
    }
}
