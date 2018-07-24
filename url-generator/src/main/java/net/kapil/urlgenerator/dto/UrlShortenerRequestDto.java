package net.kapil.urlgenerator.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UrlShortenerRequestDto implements Serializable {
    private String originalUrl;
}
