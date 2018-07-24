package net.kapil.urlgenerator.service;

import net.kapil.urlgenerator.domain.UrlEntity;
import net.kapil.urlgenerator.dto.UrlShortenerRequestDto;
import net.kapil.urlgenerator.dto.UrlShortenerResponseDto;
import net.kapil.urlgenerator.repository.UrlRepository;
import net.kapil.urlgenerator.util.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Optional;

@Service
public class UrlServiceImpl implements UrlService {
    @Autowired
    private UrlShortenerService urlShortenerService;

    @Autowired
    private UrlRepository urlRepository;

    @Autowired
    public UrlServiceImpl(final UrlShortenerService urlShortenerService) {
        this.urlShortenerService = urlShortenerService;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public UrlShortenerResponseDto generateAndSave(final UrlShortenerRequestDto requestDto) {
        validate(requestDto.getOriginalUrl());

        final Optional<UrlEntity> optionalEntity = urlRepository.findByUrl(requestDto.getOriginalUrl());
        if(optionalEntity.isPresent()) {
            return UrlShortenerResponseDto.builder().shortenUrl(optionalEntity.get().getShortenUrl()).build();
        } else {
            final String shortUrl = urlShortenerService.getShortUrl(requestDto.getOriginalUrl());
            final UrlEntity urlEntity = toUrlEntity(requestDto, shortUrl);
            urlRepository.save(urlEntity);
            return UrlShortenerResponseDto.builder().shortenUrl(shortUrl).build();
        }
    }

    @Override
    public UrlShortenerResponseDto findByUrl(final UrlShortenerRequestDto requestDto) {
        final Optional<UrlEntity> optionalEntity = urlRepository.findByUrl(requestDto.getOriginalUrl());
        return toUrlShortenerResponseDto(optionalEntity
                .orElseThrow(() -> new UrlNotFoundException(requestDto.getOriginalUrl())));
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(final UrlShortenerRequestDto requestDto) {
        final Optional<UrlEntity> optionalEntity = urlRepository.findByUrl(requestDto.getOriginalUrl());
        urlRepository.delete(optionalEntity
                .orElseThrow(() -> new UrlNotFoundException(requestDto.getOriginalUrl())));
    }

    private void validate(final String originalUrl) {
        if (!ValidationUtil.isValidUrl(originalUrl)) {
            throw new InvalidUrlException("Not a valid URL. Please check the URL...");
        }
    }

    private UrlEntity toUrlEntity(final UrlShortenerRequestDto requestDto, final String shortUrl) {
        final UrlEntity urlEntity = new UrlEntity();
        urlEntity.setOriginalUrl(requestDto.getOriginalUrl());
        urlEntity.setShortenUrl(shortUrl);
        urlEntity.setLastUpdateDate(new Timestamp(System.currentTimeMillis()));
        return urlEntity;
    }

    private UrlShortenerResponseDto toUrlShortenerResponseDto(final UrlEntity entity) {
        return UrlShortenerResponseDto.builder()
                .shortenUrl(entity.getShortenUrl())
                .build();
    }

}
