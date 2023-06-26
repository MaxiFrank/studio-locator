package com.example.studioLocatorApp.dtos;

import com.example.studioLocatorApp.entities.Detail;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailDto implements Serializable {
    private Long studioId;
    private String studioName;
    private String note;
    private Integer reviewScore;
    private Boolean isPublic;
    private UserDto userDto;

    public DetailDto(Detail detail) {
        if (detail.getStudioId() != null) {
            this.studioId = detail.getStudioId();
        }
        if (detail.getStudioName() != null) {
            this.studioName = detail.getStudioName();
        }
        if (detail.getNote() != null) {
            this.note = detail.getNote();
        }
        if (detail.getReviewScore() != null) {
            this.reviewScore = detail.getReviewScore();
        }
        if (detail.getIsPublic() != null) {
            this.isPublic = detail.getIsPublic();
        }
    }
}
