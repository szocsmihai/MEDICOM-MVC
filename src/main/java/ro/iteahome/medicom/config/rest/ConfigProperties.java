package ro.iteahome.medicom.config.rest;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "nhs.rest")
public class ConfigProperties {

// FIELDS: -------------------------------------------------------------------------------------------------------------

    private String serverUrl;

    private String doctorsUri;

    private String credentials;

// GETTERS AND SETTERS: ------------------------------------------------------------------------------------------------

    public String getServerUrl() {
        return serverUrl;
    }

    public void setServerUrl(String serverUrl) {
        this.serverUrl = serverUrl;
    }

    public String getDoctorsUri() {
        return doctorsUri;
    }

    public void setDoctorsUri(String doctorsUri) {
        this.doctorsUri = doctorsUri;
    }

    public String getCredentials() {
        return credentials;
    }

    public void setCredentials(String credentials) {
        this.credentials = credentials;
    }
}
