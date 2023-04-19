package com.example.studioLocatorApp.entities;

import com.example.studioLocatorApp.dtos.DetailDto;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
//@IdClass( PK.class )
@Table(name = "Details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Detail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studioId;

    @Column(columnDefinition = "text")
    private String note;

    @Column
    private String reviewScore;

    @Column
    private Boolean isPublic;

    @ManyToOne
    @JsonManagedReference
    private User user;

    public Detail(DetailDto detailDto) {
        if (detailDto.getNote() != null) {
            this.note = detailDto.getNote();
        }
    }
}
