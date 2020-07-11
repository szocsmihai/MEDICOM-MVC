package ro.iteahome.medicom.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.iteahome.medicom.exception.business.GlobalNotFoundException;
import ro.iteahome.medicom.model.entity.Role;
import ro.iteahome.medicom.repository.RoleRepository;

import java.util.Optional;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public Role findByName(String name) {
        Optional<Role> optionalRole = roleRepository.findByName(name);
        if (optionalRole.isPresent()) {
            return optionalRole.get();
        } else {
            throw new GlobalNotFoundException("ROLE");
        }
    }
}
