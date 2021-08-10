package bmo.jdr.jdrmanager;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping("/allScenarios")
    List<Scenario> allScenarios() {

        List<Scenario> result = new ArrayList<>();
        scenarioRepository.findAll().forEach(result::add);
        
        return result;
    }
}
