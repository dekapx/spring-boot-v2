package net.kapil.urlgenerator.service;

import net.kapil.urlgenerator.dto.UrlShortenerRequestDto;
import net.kapil.urlgenerator.dto.UrlShortenerResponseDto;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UrlServiceIT {
    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Autowired
    private UrlService urlService;

    @Test
    public void generateAndSaveUrl_withInvalidUrl_throwsInvalidUrlException() throws Exception {
        expected.expect(InvalidUrlException.class);
        expected.expectMessage("Not a valid URL. Please check the URL...");
        final UrlShortenerRequestDto requestDto = UrlShortenerRequestDto.builder().originalUrl("dummy-url").build();
        urlService.generateAndSave(requestDto);
    }

    @Test
    public void findByUrl_withInvalidUrl_throwsUrlNotFoundException() throws Exception {
        expected.expect(UrlNotFoundException.class);
        expected.expectMessage("Exception: The URL [http://dummyurl] not found in the database...");
        final UrlShortenerRequestDto requestDto = UrlShortenerRequestDto.builder().originalUrl("http://dummyurl").build();
        urlService.findByUrl(requestDto);
    }

    @Test
    public void testUrlServiceCrudOperations() throws Exception {
        final String url = "http://localhost:9090/api/ping";
        generateAndSaveUrl_withValidUrl_createAndReturnShortUrl(url);
        findByUrl_withValidUrl_returnShortUrl(url);
        deleteUrl_withValidUrl_deleteExistingUrl(url);
    }

    private void generateAndSaveUrl_withValidUrl_createAndReturnShortUrl(final String url) throws Exception {
        final UrlShortenerRequestDto requestDto = UrlShortenerRequestDto.builder().originalUrl(url).build();
        final UrlShortenerResponseDto responseDto = urlService.generateAndSave(requestDto);
        assertThat(responseDto.getShortenUrl()).isNotNull().isNotEmpty();
    }

    private void findByUrl_withValidUrl_returnShortUrl(final String url) throws Exception {
        final UrlShortenerRequestDto requestDto = UrlShortenerRequestDto.builder().originalUrl(url).build();
        final UrlShortenerResponseDto responseDto = urlService.findByUrl(requestDto);
        assertThat(responseDto.getShortenUrl()).isNotNull().isNotEmpty();
    }

    private void deleteUrl_withValidUrl_deleteExistingUrl(final String url) throws Exception {
        final UrlShortenerRequestDto requestDto = UrlShortenerRequestDto.builder().originalUrl(url).build();
        urlService.delete(requestDto);
    }

}
