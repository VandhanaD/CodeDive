package com.Data.Lecturer;

import java.util.Date;

    public class Lecturer1 {
        private Integer Id;
        private String name;
        private Date DOB;
        private String maritalStatus;
        private String qualification;
        //List<String> classTaken = new ArrayList<>();

        Subjects subb;

        public Integer getId() {
            return Id;
        }

        public void setId(Integer id) {
            Id = id;
        }

        public Subjects getSubb() {
            return subb;
        }

        public void setSubb(Subjects subb) {
            this.subb = subb;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Date getDOB() {
            return DOB;
        }

        public void setDOB(Date DOB) {
            this.DOB = DOB;
        }

        public String getMaritalStatus() {
            return maritalStatus;
        }

        public void setMaritalStatus(String maritalStatus) {
            this.maritalStatus = maritalStatus;
        }

        public String getQualification() {
            return qualification;
        }

        public void setQualification(String qualification) {
            this.qualification = qualification;
        }

    }


