package net.kapil.urlgenerator.controller;

import net.kapil.urlgenerator.dto.UrlShortenerRequestDto;
import net.kapil.urlgenerator.dto.UrlShortenerResponseDto;
import net.kapil.urlgenerator.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CONFLICT;

@RestController
@RequestMapping("/api/url")
public class UrlGeneratorController {
    @Autowired
    private UrlService urlService;

    @PostMapping(value = "/create")
    public ResponseEntity create(@RequestBody final UrlShortenerRequestDto requestDto) {
        final UrlShortenerResponseDto responseDto = urlService.generateAndSave(requestDto);
        return new ResponseEntity(responseDto, HttpStatus.OK);
    }

    @GetMapping(value = "/{originalUrl}")
    public ResponseEntity find(@PathVariable final String originalUrl) {
        final UrlShortenerRequestDto requestDto = UrlShortenerRequestDto.builder().originalUrl(originalUrl).build();
        final UrlShortenerResponseDto responseDto = urlService.findByUrl(requestDto);
        return new ResponseEntity(responseDto, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete")
    public ResponseEntity delete(@RequestBody final UrlShortenerRequestDto requestDto) {
        urlService.delete(requestDto);
        return new ResponseEntity(HttpStatus.OK);
    }

    @ExceptionHandler
    @ResponseStatus(CONFLICT)
    public String handleException(final Exception e) {
        return e.getMessage();
    }
}
