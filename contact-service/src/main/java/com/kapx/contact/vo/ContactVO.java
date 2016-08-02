package com.kapx.contact.vo;

public class ContactVO {
    private String firstName;
    private String lastName;
    private String phone;
    private String email;

    public ContactVO() {}

    public ContactVO(final ContactBuilder contactBuilder) {
        this.firstName = contactBuilder.firstName;
        this.lastName = contactBuilder.lastName;
        this.phone = contactBuilder.phone;
        this.email = contactBuilder.email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public static class ContactBuilder {
        private String firstName;
        private String lastName;
        private String phone;
        private String email;

        public ContactBuilder withFirstName(final String firstName) {
            this.firstName = firstName;
            return this;
        }

        public ContactBuilder withLastName(final String lastName) {
            this.lastName = lastName;
            return this;
        }

        public ContactBuilder withPhone(final String phone) {
            this.phone = phone;
            return this;
        }

        public ContactBuilder withEmail(final String email) {
            this.email = email;
            return this;
        }

        public ContactVO build() {
            return new ContactVO(this);
        }
    }
}
