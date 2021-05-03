package edu.nikitaMaistrenko.domain;

import javax.persistence.*;
import java.util.List;

@Table(name = "membership_gym")
@Entity
public class MembershipGYM {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "membership_gym_id")
    private Long gymMembershipId;

    @Column(name = "type_of_gym_membership")
    private String typeOfGymMembership;

    @Column(name = "number_of_workouts")
    private Integer number_of_workouts;

    @Column(name = "validity_months")
    private Integer validityMonths;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "membershipGYM")
    private List<MembershipCard> membershipCards;

    public Long getGymMembershipId() {
        return gymMembershipId;
    }

    public void setGymMembershipId(Long gymMembershipId) {
        this.gymMembershipId = gymMembershipId;
    }

    public String getTypeOfGymMembership() {
        return typeOfGymMembership;
    }

    public void setTypeOfGymMembership(String typeOfGymMembership) {
        this.typeOfGymMembership = typeOfGymMembership;
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
