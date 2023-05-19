package com.example.studioLocatorApp.entities;

import com.example.studioLocatorApp.dtos.DetailDto;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Table(name = "Details")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Detail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studioId;

    @Column(columnDefinition = "text")
    private String studioName;

    @Column(columnDefinition = "text")
    private String note;

    @Column
    private Integer reviewScore;

    @Column
    private Boolean isPublic;

    @ManyToOne
    @JsonManagedReference
    private User user;

    public Detail(DetailDto detailDto) {
        if (detailDto.getNote() != null) {
            this.note = detailDto.getNote();
        }
        if (detailDto.getReviewScore() != null) {
            this.reviewScore = detailDto.getReviewScore();
        }
        if (detailDto.getIsPublic() != null) {
            this.isPublic = detailDto.getIsPublic();
        }if (detailDto.getStudioName() != null) {
            this.studioName = detailDto.getStudioName();
        }
    }
}
