package bmo.jdr.jdrmanager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bmo.jdr.jdrmanager.model.Campagne;
import bmo.jdr.jdrmanager.model.Scenario;
import bmo.jdr.jdrmanager.repo.CampagneRepository;
import bmo.jdr.jdrmanager.repo.ScenarioRepository;

@RestController
@RequestMapping("JDRManager")
public class JDRManagerProcess {

	@Autowired
	private CampagneRepository campagneRepository;
	
	@Autowired
    private ScenarioRepository scenarioRepository;

	@GetMapping("/allCampagnes")
	List<Campagne> allCampagnes() {

		List<Campagne> result = new ArrayList<>();
		campagneRepository.findAll().forEach(result::add);
		
		return result;
	}
	
	@GetMapping("/getCampagneInfo/{id}")
    Map<String,String> getCampagneInfo(@PathVariable long id) {
	    
	    Map<String,String> campagneInfo = new HashMap<>();
	    Optional<Campagne> oCampagne = campagneRepository.findById(id);
	    
	    if(oCampagne.isPresent()) {
	        Campagne campagne = oCampagne.get();
	        
	        campagneInfo.put("name", campagne.getName());
	        campagneInfo.put("desctipion", campagne.getDescription());
	    }
	    
        return campagneInfo;
    }
	
	@GetMapping("/allScenarios")
    List<Scenario> allScenarios() {

        List<Scenario> result = new ArrayList<>();
        scenarioRepository.findAll().forEach(result::add);
        
        return result;
    }
}
