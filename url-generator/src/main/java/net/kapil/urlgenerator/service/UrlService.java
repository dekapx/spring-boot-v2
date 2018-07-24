package net.kapil.urlgenerator.service;

import net.kapil.urlgenerator.dto.UrlShortenerRequestDto;
import net.kapil.urlgenerator.dto.UrlShortenerResponseDto;

public interface UrlService {
    UrlShortenerResponseDto generateAndSave(UrlShortenerRequestDto requestDto);

    UrlShortenerResponseDto findByUrl(UrlShortenerRequestDto requestDto);

    void delete(UrlShortenerRequestDto requestDto);
}
