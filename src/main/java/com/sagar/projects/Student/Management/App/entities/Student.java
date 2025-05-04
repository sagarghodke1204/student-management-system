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
        private long contact_number;

        @Column(name="Adress")
        private String adress;

        @Column(name="email")
        private String email;

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        @Column(name="password")
        private String password;
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

        public long getContact_number() {
            return contact_number;
        }

        public long setContact_number(long contact_number) {
           return this.contact_number = contact_number;
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
