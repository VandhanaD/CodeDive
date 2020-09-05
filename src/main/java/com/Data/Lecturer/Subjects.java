package com.Data.Lecturer;

public class Subjects {

    //List<String> subjectTaken = new ArrayList<>();
    private String  subjectTaken;
    private String studentFeedback;
    private Integer rating;

    public String getStudentFeedback() {
        return studentFeedback;
    }

    public void setStudentFeedback(String studentFeedback) {
        this.studentFeedback = studentFeedback;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getSubjectTaken() {
        return subjectTaken;
    }

    public void setSubjectTaken(String subjectTaken) {
        this.subjectTaken = subjectTaken;
    }

}
