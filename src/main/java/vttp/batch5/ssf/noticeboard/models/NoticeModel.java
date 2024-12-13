package vttp.batch5.ssf.noticeboard.models;


import jakarta.validation.MessageInterpolator;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.awt.*;
import java.time.LocalDate;

public class NoticeModel {

    @NotNull(message = "Mandatory")
    @Length(min = 3, max = 128, message = "The notice title's length must be between 3 and 128 characters")
    private String title;

    @Email(message = "Must be a well-formed email address")
    private String poster;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Future(message = "date must be in the future")
    @NotNull(message = "Mandatory")
    private LocalDate postDate;

    @NotNull(message = "Mandatory, please choose at least one category")
    private String categories;

    @NotNull(message = "Mandatory")
    private String text;

    // Getters and setters
    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getPostDate() {
        return postDate;
    }

    public void setPostDate(LocalDate postDate) {
        this.postDate = postDate;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    //tostring
    @Override
    public String toString() {
        return "NoticeModel{" +
                "title='" + title + '\'' +
                ", poster='" + poster + '\'' +
                ", postDate=" + postDate +
                ", categories='" + categories + '\'' +
                ", text='" + text + '\'' +
                '}';
    }

    public NoticeModel() {

    }
    public NoticeModel(String title, String poster, LocalDate postDate, String categories, String text) {
        this.title = title;
        this.poster = poster;
        this.postDate = postDate;
        this.categories = categories;
        this.text = text;
    }
}
