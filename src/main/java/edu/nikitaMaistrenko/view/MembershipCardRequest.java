package edu.nikitaMaistrenko.view;

public class MembershipCardRequest {

    private String firstName;
    private String lastName;
    private String typeOfMembershipGYM;

    public MembershipCardRequest() {
    }

    public MembershipCardRequest(String firstName, String lastName, String typeOfMembershipGYM) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.typeOfMembershipGYM = typeOfMembershipGYM;
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

    public String getTypeOfMembershipGYM() {
        return typeOfMembershipGYM;
    }

    public void setTypeOfMembershipGYM(String typeOfMembershipGYM) {
        this.typeOfMembershipGYM = typeOfMembershipGYM;
    }
}
