package ro.iteahome.medicom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ro.iteahome.medicom.model.dto.ConsultDTO;
import ro.iteahome.medicom.model.dto.PatientDTO;
import ro.iteahome.medicom.service.ConsultDTOService;

import java.util.ArrayList;

@Controller
@RequestMapping("/users")
public class ConsultController {

    @Autowired
    private ConsultDTOService consultDTOService;

    @GetMapping("/patient/by-cnp")
    public String showFindForm(PatientDTO patientDTO) {
        return "find-patient";
    }


    @PostMapping("/add-consult")
    public ModelAndView addConsult(ConsultDTO consultDTO, PatientDTO patientDTO) {
        ArrayList<ConsultDTO> consultDTOList = new ArrayList<>();
        consultDTOList.add(consultDTOService.addConsult(consultDTO));
        patientDTO.setCnp(consultDTO.getPatient_cnp());
        return new ModelAndView("consult/home-consult").addObject(consultDTOList).addObject(patientDTO);
    }

    @GetMapping("/consult/by-cnp")
    public ModelAndView findConsults(PatientDTO patientDTO) {

        return new ModelAndView("consult/home-consult")
                .addObject(consultDTOService.findAllConsults(patientDTO.getCnp()));
    }

    @GetMapping("/find-patient")
    public ModelAndView getPatient(PatientDTO patientDTO) {
        return new ModelAndView("consult/patient-view")
                .addObject(consultDTOService.findPatientByCnp(patientDTO.getCnp()));
    }
}
