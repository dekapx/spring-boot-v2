package com.dimensiondata.cloud.preference.controller;

import com.dimensiondata.cloud.preference.domain.UserPreference;
import com.dimensiondata.cloud.preference.service.PreferenceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import java.util.Map;

@RestController
public class PreferenceController {
    private static final Logger LOGGER = LoggerFactory.getLogger(PreferenceController.class);

    @Inject
    private PreferenceService preferenceService;

    @RequestMapping("/test")
    public String sayHello() {
        return "Preference Service REST Controller";
    }

    @RequestMapping(value = "/pref/find/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public UserPreference find(@PathVariable final long id) {
        LOGGER.info("Request for preference received for Id: {}", id);
        return preferenceService.find(String.valueOf(id));
    }

    @RequestMapping(value = "/pref/findAll", method = RequestMethod.GET, headers = "Accept=application/json")
    public Map<Object, UserPreference> findAll() {
        LOGGER.info("Request for retrieving all preference");
        return preferenceService.findAll();
    }

    @RequestMapping(value = "/pref/save", method = RequestMethod.POST)
    public ResponseEntity<Void> save(@RequestBody final UserPreference preference) {
        LOGGER.info("Request for persisting preferences for Id: {}", preference.getId());
        preferenceService.save(preference);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(value = "/pref/update", method = RequestMethod.POST)
    public ResponseEntity<Void> update(@RequestBody final UserPreference preference) {
        LOGGER.info("Request for updating preferences for Id: {}", preference.getId());
        preferenceService.update(preference);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(value = "/pref/delete/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public ResponseEntity<Void> delete(@PathVariable final long id) {
        LOGGER.info("Request for delete preference received for Id: {}", id);
        preferenceService.delete(String.valueOf(id));
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleException(Exception e) {
        return e.getMessage();
    }
}
