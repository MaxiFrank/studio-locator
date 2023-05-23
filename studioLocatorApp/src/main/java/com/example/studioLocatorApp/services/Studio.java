package com.example.studioLocatorApp.services;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.extern.jackson.Jacksonized;

@Data
//@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@Jacksonized
@Getter
@Setter

public class Studio {
    protected String name;
    protected Float rating;

}
