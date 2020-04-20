package com.codegym.controller.police;

import com.codegym.model.PoliceCity;
import com.codegym.service.PoliceCityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/police")
public class PoliceCityController {
    @Autowired
    private PoliceCityService policeCityService;

    @GetMapping("/policeCitys/")
    private ResponseEntity<List<PoliceCity>> listPoliceCitys(){
        List<PoliceCity> policeCitys= policeCityService.findAllRest();
        if (policeCitys.isEmpty()) {
            return new ResponseEntity<List<PoliceCity>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<PoliceCity>>(policeCitys, HttpStatus.OK);
    }

    @GetMapping(value = "/policeCitys/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PoliceCity> getPoliceCity(@PathVariable("id") long id) {
        PoliceCity currentPoliceCity = policeCityService.findById(id);
        if (currentPoliceCity == null) {

            return new ResponseEntity<PoliceCity>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<PoliceCity>(currentPoliceCity, HttpStatus.OK);
    }

    @PostMapping(value = "/policeCitys/")
    public ResponseEntity<PoliceCity> createPoliceCity(@RequestBody PoliceCity policeCity, UriComponentsBuilder ucBuilder) {
        try {
            policeCityService.save(policeCity);
            return new ResponseEntity<PoliceCity>(policeCity, HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<PoliceCity>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/policeCitys/{id}")
    public ResponseEntity<PoliceCity> updatePoliceCity(@PathVariable("id") long id, @RequestBody PoliceCity policeCity) {

        PoliceCity currentPoliceCity = policeCityService.findById(id);

        if (currentPoliceCity == null) {
            System.out.println("PoliceCity with id " + id + " not found");
            return new ResponseEntity<PoliceCity>(HttpStatus.NOT_FOUND);
        }

        currentPoliceCity.setName(policeCity.getName());

        currentPoliceCity.setAddress(policeCity.getAddress());

        currentPoliceCity.setTel(policeCity.getTel());

        currentPoliceCity.setArea(policeCity.getArea());

        try {
            policeCityService.save(currentPoliceCity);
        }catch (Exception ex){
            return new ResponseEntity<PoliceCity>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<PoliceCity>(currentPoliceCity, HttpStatus.OK);
    }

    @DeleteMapping(value = "/policeCitys/{id}")
    public ResponseEntity<PoliceCity> deletePoliceCity(@PathVariable("id") long id) {

        PoliceCity currentPoliceCity = policeCityService.findById(id);
        if (currentPoliceCity == null) {
            System.out.println("Unable to delete. PoliceCity with id " + id + " not found");
            return new ResponseEntity<PoliceCity>(HttpStatus.NOT_FOUND);
        }
        policeCityService.remove(id);
        return new ResponseEntity<PoliceCity>(HttpStatus.NO_CONTENT);
    }
}
