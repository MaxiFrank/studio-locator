package com.example.studioLocatorApp.dtos;

import com.example.studioLocatorApp.entities.Detail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailDto implements Serializable {
//    private Long userId;
    private Long studioId;
    private String note;
    private String reviewScore;
    private Boolean isPublic;
    private UserDto userDto;

    public DetailDto(Detail detail) {
//        if (detail.getUserId() != null) {
//            this.userId = detail.getUserId();
//        }
        if (detail.getStudioId() != null) {
            this.studioId = detail.getStudioId();
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
