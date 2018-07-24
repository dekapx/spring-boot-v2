package net.kapil.urlgenerator.service;

import org.springframework.util.StringUtils;

public enum ProtocolType {
    HTTP("http"), HTTPS("https");

    private String protocol;

    ProtocolType(String protocol) {
        this.protocol = protocol;
    }

    public String getProtocol() {
        return protocol;
    }

    public static boolean contains(final String protocol) {
        boolean isSupported = false;
        for (ProtocolType protocolType : ProtocolType.values()) {
            if (StringUtils.startsWithIgnoreCase(protocol, protocolType.getProtocol())) {
                isSupported = true;
            }
        }

        return isSupported;
    }
}
