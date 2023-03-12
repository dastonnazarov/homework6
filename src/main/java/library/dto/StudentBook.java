package library.dto;

import library.enums.Status;

import java.time.LocalDate;

public class StudentBook {
private Integer id;
private Integer student_id;
private Integer book_id;
private LocalDate localDate;
private Status status;
private LocalDate returnedDate;
private Integer duration;


    public StudentBook() {
    }

    public StudentBook(Integer id, Integer student_id, Integer book_id, LocalDate localDate, Status status, LocalDate returnedDate, Integer duration) {
        this.id = id;
        this.student_id = student_id;
        this.book_id = book_id;
        this.localDate = localDate;
        this.status = status;
        this.returnedDate = returnedDate;
        this.duration = duration;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public Integer getBook_id() {
        return book_id;
    }

    public void setBook_id(Integer book_id) {
        this.book_id = book_id;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getReturnedDate() {
        return returnedDate;
    }

    public void setReturnedDate(LocalDate returnedDate) {
        this.returnedDate = returnedDate;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }


    @Override
    public String toString() {
        return "StudentBook{" +
                "id=" + id +
                ", student_id=" + student_id +
                ", book_id=" + book_id +
                ", localDate=" + localDate +
                ", status=" + status +
                ", returnedDate=" + returnedDate +
                ", duration=" + duration +
                '}';
    }
}
