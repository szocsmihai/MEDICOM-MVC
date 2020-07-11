package ro.iteahome.medicom.config.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import java.util.Base64;

@Component
public class RestConfig {

// FIELDS: -------------------------------------------------------------------------------------------------------------

    @Value("${nhs.rest.server-url}")
    private String SERVER_URL;

    @Value("${nhs.rest.doctors-uri}")
    private String DOCTORS_URI;

    @Value("${nhs.rest.credentials}")
    private String CREDENTIALS;

    @Value("${nhs.rest.patients-uri}")
    private String PATIENTS_URI;

// Methods: ------------------------------------------------------------------------------------------------------------

    public HttpHeaders buildAuthHeaders(String credentials) {
        HttpHeaders authHeaders = new HttpHeaders();
        authHeaders.add(
                "Authorization",
                "Basic " + buildEncodedCredentials(credentials));
        return authHeaders;
    }

    public String buildEncodedCredentials(String credentials) {
        return new String(Base64.getEncoder().encode(credentials.getBytes()));
    }

    public String getSERVER_URL() {
        return SERVER_URL;
    }

    public void setSERVER_URL(String SERVER_URL) {
        this.SERVER_URL = SERVER_URL;
    }

    public String getDOCTORS_URI() {
        return DOCTORS_URI;
    }

    public void setDOCTORS_URI(String DOCTORS_URI) {
        this.DOCTORS_URI = DOCTORS_URI;
    }

    public String getCREDENTIALS() {
        return CREDENTIALS;
    }

    public void setCREDENTIALS(String CREDENTIALS) {
        this.CREDENTIALS = CREDENTIALS;
    }

    public String getPATIENTS_URI() {
        return PATIENTS_URI;
    }

    public void setPATIENTS_URI(String PATIENTS_URI) {
        this.PATIENTS_URI = PATIENTS_URI;
    }
}
