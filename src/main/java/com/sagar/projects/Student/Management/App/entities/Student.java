    package com.sagar.projects.Student.Management.App.entities;

    import jakarta.persistence.Column;
    import jakarta.persistence.Entity;
    import jakarta.persistence.Id;
    import jakarta.persistence.Table;

    @Entity
    @Table(name = "Student_info")
    public class Student {


        @Column(name="name")
        private String name;

        @Column(name="Contact_number")
        private int contact_number;

        @Column(name="Adress")
        private String adress;

        @Column(name="email")
        private String email;

            @Id
            @Column(name="reg_num" ,unique = true)
            private String reg_num;


            // getter and setters

        public String getName() {
                return name;
            }

        public void setName(String name) {
            this.name = name;
        }

        public int getContact_number() {
            return contact_number;
        }

        public void setContact_number(int contact_number) {
            this.contact_number = contact_number;
        }

        public String getAdress() {
            return adress;
        }

        public void setAdress(String adress) {
            this.adress = adress;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getReg_num() {
            return reg_num;
        }

        public void setReg_num(String reg_num) {
            this.reg_num = reg_num;
        }
    }
