package bmo.jdr.jdrmanager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.StringJoiner;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    Map<String, String> getCampagneInfo(@PathVariable long id, HttpServletRequest request) {

        Map<String, String> campagneInfo = new HashMap<>();
        Optional<Campagne> oCampagne = campagneRepository.findById(id);

        if (oCampagne.isPresent()) {
            Campagne campagne = oCampagne.get();

            campagneInfo.put("name", campagne.getName());
            campagneInfo.put("desctipion", campagne.getDescription());
        }

        List<String> notes = (List<String>) request.getSession().getAttribute("NOTES_SESSION");
        if (null != notes) {
            String notesString = String.join(",", notes);
            campagneInfo.put("NOTES_SESSION", notesString);
        }
        return campagneInfo;
    }

    @GetMapping("/allScenarios")
    List<Scenario> allScenarios() {

        List<Scenario> result = new ArrayList<>();
        scenarioRepository.findAll().forEach(result::add);

        return result;
    }

    @PostMapping("/addNote")
    public String addNote(@RequestParam("note") String note, HttpServletRequest request) {
        // get the notes from request session
        List<String> notes = (List<String>) request.getSession().getAttribute("NOTES_SESSION");
        // check if notes is present in session or not
        if (notes == null) {
            notes = new ArrayList<>();
            // if notes object is not present in session, set notes in the request session
            request.getSession().setAttribute("NOTES_SESSION", notes);
        }
        notes.add(note);
        request.getSession().setAttribute("NOTES_SESSION", notes);
        return "redirect:/JDRManager/home";
    }

    @GetMapping("/home")
    public String home(Model model, HttpSession session) {
        List<String> notes = (List<String>) session.getAttribute("NOTES_SESSION");
        model.addAttribute("notesSession", notes != null ? notes : new ArrayList<>());
        return "home";
    }

    @GetMapping("/noteslist")
    public List<String> noteslist(Model model, HttpSession session) {
        List<String> notes = (List<String>) session.getAttribute("NOTES_SESSION");
        model.addAttribute("notesSession", notes != null ? notes : new ArrayList<>());
        return notes;
    }

    @PostMapping("/invalidate/session")
    public String destroySession(HttpServletRequest request) {
        // invalidate the session , this will clear the data from configured database
        // (Mysql/redis/hazelcast)
        request.getSession().invalidate();
        return "redirect:/home";
    }
}
