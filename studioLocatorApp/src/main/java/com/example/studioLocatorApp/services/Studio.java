package com.example.studioLocatorApp.services;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
//@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@Getter
@Setter

public class Studio {
    protected String name;
    protected Float rating;

}
