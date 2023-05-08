package com.example.studioLocatorApp.services;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;



@NoArgsConstructor
@Getter
@Setter
@Data
@Builder
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class YelpResponse {
    protected Studio[] businesses;
}
