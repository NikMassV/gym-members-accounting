package edu.nikitaMaistrenko.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Table(name = "membership_card")
@Entity
public class MembershipCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "membership_card_id")
    private Long membershipCardId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "membership_gym_id")
    private MembershipGYM membershipGYM;

    @Column(name = "marked_workouts")
    private Integer markedWorkouts;

    @Column(name = "purchase_date")
    private LocalDate purchaseDate;

    @Column(name = "expired_date")
    private LocalDate expiredDate;

    @Column(name = "membership_status")
    @Enumerated
    private MembershipStatus membershipStatus;

    public Long getMembershipCardId() {
        return membershipCardId;
    }

    public void setMembershipCardId(Long membershipCardId) {
        this.membershipCardId = membershipCardId;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public MembershipGYM getMembershipGYM() {
        return membershipGYM;
    }

    public void setMembershipGYM(MembershipGYM membershipGYM) {
        this.membershipGYM = membershipGYM;
    }

    public Integer getMarkedWorkouts() {
        return markedWorkouts;
    }

    public void setMarkedWorkouts(Integer markedWorkouts) {
        this.markedWorkouts = markedWorkouts;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public LocalDate getExpiredDate() {
        return expiredDate;
    }

    public void setExpiredDate(LocalDate expiredDate) {
        this.expiredDate = expiredDate;
    }

    public MembershipStatus getMembershipStatus() {
        return membershipStatus;
    }

    public void setMembershipStatus(MembershipStatus membershipStatus) {
        this.membershipStatus = membershipStatus;
    }
}
