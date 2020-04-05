package com.codegym.controller;

import com.codegym.model.Province;
import com.codegym.service.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProvinceController {
    @Autowired
    private ProvinceService provinceService;

    //-------------------Retrieve All Provinces--------------------------------------------------------

    @RequestMapping(value = "/provinces/", method = RequestMethod.GET)
    public ResponseEntity<List<Province>> listAllProvinces() {
        List<Province> provinces = provinceService.findAllRest();
        if (provinces.isEmpty()) {
            return new ResponseEntity<List<Province>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Province>>(provinces, HttpStatus.OK);
    }

    //-------------------Retrieve Single Province--------------------------------------------------------

    @RequestMapping(value = "/provinces/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Province> getProvince(@PathVariable("id") long id) {
        System.out.println("Fetching Province with id " + id);
        Province province = provinceService.findById(id);
        if (province == null) {
            System.out.println("Province with id " + id + " not found");
            return new ResponseEntity<Province>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Province>(province, HttpStatus.OK);
    }

    //-------------------Create a Province--------------------------------------------------------

    @RequestMapping(value = "/provinces/", method = RequestMethod.POST)
    public ResponseEntity<Void> createProvince(@RequestBody Province province, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Province " + province.getName());
        provinceService.save(province);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/provinces/{id}").buildAndExpand(province.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    //------------------- Update a Province --------------------------------------------------------

    @RequestMapping(value = "/provinces/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Province> updateProvince(@PathVariable("id") long id, @RequestBody Province province) {
        System.out.println("Updating Province " + id);

        Province currentProvince = provinceService.findById(id);

        if (currentProvince == null) {
            System.out.println("Province with id " + id + " not found");
            return new ResponseEntity<Province>(HttpStatus.NOT_FOUND);
        }

        currentProvince.setName(province.getName());
        currentProvince.setId(province.getId());

        provinceService.save(currentProvince);
        return new ResponseEntity<Province>(currentProvince, HttpStatus.OK);
    }

    //------------------- Delete a Province --------------------------------------------------------

    @RequestMapping(value = "/provinces/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Province> deleteProvince(@PathVariable("id") long id) {
        System.out.println("Fetching & Deleting Province with id " + id);

        Province province = provinceService.findById(id);
        if (province == null) {
            System.out.println("Unable to delete. Province with id " + id + " not found");
            return new ResponseEntity<Province>(HttpStatus.NOT_FOUND);
        }

        provinceService.remove(id);
        return new ResponseEntity<Province>(HttpStatus.NO_CONTENT);
    }
}
