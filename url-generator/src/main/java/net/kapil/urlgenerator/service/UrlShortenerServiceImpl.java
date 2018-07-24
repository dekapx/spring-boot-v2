package net.kapil.urlgenerator.service;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class UrlShortenerServiceImpl implements UrlShortenerService {
    private static final int RADIX = 36;
    private static final String PIPE = "-";
    private static final String PREFIX = "http://localhost:9090/";

    @Override
    public String getShortUrl(final String originalUrl) {
        return shortenUrl(originalUrl);
    }

    private String shortenUrl(final String url) {
        if (StringUtils.isEmpty(url)) {
            throw new InvalidUrlException("Not a valid URL. The URL must not be null or empty.");
        }

        final boolean isSupportedProtocol = ProtocolType.contains(url);
        if (!isSupportedProtocol) {
            throw new InvalidUrlException("Not a valid URL. The given URL contains invalid protocol.");
        }

        String hexValue = Integer.toString(url.hashCode(), RADIX);
        if (hexValue.startsWith(PIPE)) {
            hexValue = hexValue.substring(1);
        }

        return PREFIX + hexValue;
    }
}
