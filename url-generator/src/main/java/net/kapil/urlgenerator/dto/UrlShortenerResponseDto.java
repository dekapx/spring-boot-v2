package net.kapil.urlgenerator.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Builder
@AllArgsConstructor
public class UrlShortenerResponseDto implements Serializable {
    private String shortenUrl;
}
