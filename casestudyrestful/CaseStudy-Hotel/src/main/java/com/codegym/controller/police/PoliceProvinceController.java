package com.codegym.controller.police;

import com.codegym.model.PoliceProvince;
import com.codegym.service.PoliceCityService;
import com.codegym.service.PoliceProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/police")
public class PoliceProvinceController {
    @Autowired
    private PoliceProvinceService policeProvinceService;

    @GetMapping("/policeProvinces/")
    private ResponseEntity<List<PoliceProvince>> listPoliceProvinces(){
        List<PoliceProvince> policeProvinces= policeProvinceService.findAllRest();
        if (policeProvinces.isEmpty()) {
            return new ResponseEntity<List<PoliceProvince>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<PoliceProvince>>(policeProvinces, HttpStatus.OK);
    }

    @GetMapping(value = "/policeProvinces/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PoliceProvince> getPoliceProvince(@PathVariable("id") long id) {
        PoliceProvince currentPoliceProvince = policeProvinceService.findById(id);
        if (currentPoliceProvince == null) {

            return new ResponseEntity<PoliceProvince>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<PoliceProvince>(currentPoliceProvince, HttpStatus.OK);
    }

    @PostMapping(value = "/policeProvinces/")
    public ResponseEntity<PoliceProvince> createPoliceProvince(@RequestBody PoliceProvince policeProvince, UriComponentsBuilder ucBuilder) {
        try {
            policeProvinceService.save(policeProvince);
            return new ResponseEntity<PoliceProvince>(policeProvince, HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<PoliceProvince>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/policeProvinces/{id}")
    public ResponseEntity<PoliceProvince> updatePoliceProvince(@PathVariable("id") long id, @RequestBody PoliceProvince policeProvince) {

        PoliceProvince currentPoliceProvince = policeProvinceService.findById(id);

        if (currentPoliceProvince == null) {
            System.out.println("PoliceProvince with id " + id + " not found");
            return new ResponseEntity<PoliceProvince>(HttpStatus.NOT_FOUND);
        }

        currentPoliceProvince.setName(policeProvince.getName());

        currentPoliceProvince.setAddress(policeProvince.getAddress());

        currentPoliceProvince.setTel(policeProvince.getTel());

        currentPoliceProvince.setArea(policeProvince.getArea());
        try {
            policeProvinceService.save(currentPoliceProvince);
        }catch (Exception ex){
            return new ResponseEntity<PoliceProvince>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<PoliceProvince>(currentPoliceProvince, HttpStatus.OK);
    }

    @DeleteMapping(value = "/policeProvinces/{id}")
    public ResponseEntity<PoliceProvince> deletePoliceProvince(@PathVariable("id") long id) {

        PoliceProvince currentPoliceProvince = policeProvinceService.findById(id);
        if (currentPoliceProvince == null) {
            System.out.println("Unable to delete. PoliceProvince with id " + id + " not found");
            return new ResponseEntity<PoliceProvince>(HttpStatus.NOT_FOUND);
        }
        policeProvinceService.remove(id);
        return new ResponseEntity<PoliceProvince>(HttpStatus.NO_CONTENT);
    }
}
