package com.example.studioLocatorApp.services;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.extern.jackson.Jacksonized;


@NoArgsConstructor
@Getter
@Setter
@Data
@Builder
@Jacksonized
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class YelpResponse {
    protected Studio[] businesses;
}
