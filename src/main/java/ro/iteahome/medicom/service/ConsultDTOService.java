package ro.iteahome.medicom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ro.iteahome.medicom.config.rest.RestConfig;
import ro.iteahome.medicom.exception.business.GlobalNotFoundException;
import ro.iteahome.medicom.model.dto.ConsultDTO;
import ro.iteahome.medicom.model.dto.PatientDTO;
import ro.iteahome.medicom.utils.ConsultList;

import java.util.ArrayList;
import java.util.Objects;

@Service
public class ConsultDTOService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RestConfig restConfig;

    public ArrayList<ConsultDTO> findAllConsults(String cnp) {
        ResponseEntity<ConsultList> consultDTOResponse =
                restTemplate.exchange(
                        restConfig.getSERVER_URL() + restConfig.getPATIENTS_URI() + "/find-consult/" + cnp,
                        HttpMethod.GET,
                        new HttpEntity<>(restConfig.buildAuthHeaders(restConfig.getCREDENTIALS())),
                        ConsultList.class);
        return Objects.requireNonNull(consultDTOResponse.getBody()).getConsultDTOList();
    }

    public ConsultDTO addConsult(ConsultDTO consultDTO) {
        ResponseEntity<ConsultDTO> consultDTOResponseEntity =
                restTemplate.exchange(
                        restConfig.getSERVER_URL() + restConfig.getPATIENTS_URI() + "/add-consult",
                        HttpMethod.POST,
                        new HttpEntity<>(consultDTO, restConfig.buildAuthHeaders(restConfig.getCREDENTIALS())),
                        ConsultDTO.class);
        return consultDTOResponseEntity.getBody();
    }

    public PatientDTO findPatientByCnp(String cnp) {
        ResponseEntity<PatientDTO> patientResponse =
                restTemplate.exchange(
                        restConfig.getSERVER_URL() + restConfig.getPATIENTS_URI() + "/by-cnp/" + cnp,
                        HttpMethod.GET,
                        new HttpEntity<>(restConfig.buildAuthHeaders(restConfig.getCREDENTIALS())),
                        PatientDTO.class);
        PatientDTO patientDTO = patientResponse.getBody();
        if (patientDTO != null) {
            return patientDTO;
        } else {
            throw new GlobalNotFoundException("PATIENTS");
        }
    }
}
