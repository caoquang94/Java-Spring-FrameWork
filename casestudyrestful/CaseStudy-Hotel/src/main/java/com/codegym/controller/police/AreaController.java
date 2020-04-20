package com.codegym.controller.police;

import com.codegym.model.Area;
import com.codegym.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/police")
public class AreaController {
    @Autowired
    private AreaService areaService;
    @GetMapping("/areas/")
    private ResponseEntity<List<Area>> listAreas(){
        List<Area> areas= areaService.findAllRest();
        if (areas.isEmpty()) {
            return new ResponseEntity<List<Area>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Area>>(areas, HttpStatus.OK);
    }

    @GetMapping(value = "/areas/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Area> getArea(@PathVariable("id") long id) {
        Area currentArea = areaService.findById(id);
        if (currentArea == null) {

            return new ResponseEntity<Area>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Area>(currentArea, HttpStatus.OK);
    }

    @PostMapping(value = "/areas/")
    public ResponseEntity<Area> createArea(@RequestBody Area area, UriComponentsBuilder ucBuilder) {
        try {
            areaService.save(area);
            return new ResponseEntity<Area>(area, HttpStatus.OK);
        }catch (Exception ex){
            return new ResponseEntity<Area>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/areas/{id}")
    public ResponseEntity<Area> updateArea(@PathVariable("id") long id, @RequestBody Area area) {

        Area currentArea = areaService.findById(id);

        if (currentArea == null) {
            System.out.println("Area with id " + id + " not found");
            return new ResponseEntity<Area>(HttpStatus.NOT_FOUND);
        }

        currentArea.setName(area.getName());


        try {
            areaService.save(currentArea);
        }catch (Exception ex){
            return new ResponseEntity<Area>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<Area>(currentArea, HttpStatus.OK);
    }

    @DeleteMapping(value = "/areas/{id}")
    public ResponseEntity<Area> deleteArea(@PathVariable("id") long id) {

        Area currentArea = areaService.findById(id);
        if (currentArea == null) {
            System.out.println("Unable to delete. Area with id " + id + " not found");
            return new ResponseEntity<Area>(HttpStatus.NOT_FOUND);
        }
        try {
            areaService.remove (id);
        } catch (Exception e) {
            return new ResponseEntity<Area> (HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Area>(currentArea, HttpStatus.OK);

    }
}
