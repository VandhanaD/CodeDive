package com.Data.Lecturer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin


    public class LecturerDataController {
        @Autowired
        LecturerDataService demoLecturerService;
        List<Lecturer1> lectList = new ArrayList<>();
        int recordsAffected;

        /*@RequestMapping(value = "lecturer/data/all", method = RequestMethod.GET)
       public List<Lecturer1> getAllLecturer()
        {
            lectList = demoLecturerService.getAllLecturer();
            return lectList;
        }*/

    @CrossOrigin
    @RequestMapping(value = "/lecturer/data/all/{id}", method = RequestMethod.GET)
    public List<Lecturer1> getAllLecturer(@PathVariable Integer id)
    {
        lectList = demoLecturerService.getAllLecturer(id);
        return lectList;
    }


        @RequestMapping(value = "/lecturer/data/add", method = RequestMethod.POST)
        public String addLecturerData(@RequestBody Lecturer1 lect)
        {
            recordsAffected = demoLecturerService.addLecturerData(lect);
            return "Lecturer Added " + recordsAffected ;
        }

        @RequestMapping(value = "/lecturer/data/update", method = RequestMethod.PUT)
        public String updateLecturerData(@RequestBody Lecturer1 lect)
        {
            recordsAffected = demoLecturerService.updateLecturerData(lect);
            return "Lecturer updated " + recordsAffected ;
        }

        @RequestMapping(value = "/lecturer/data/delete/{id}", method = RequestMethod.DELETE)
        public String deleteLecturerData(@PathVariable Integer id)
        {
            recordsAffected = demoLecturerService.deleteLecturerData(id);
            return "Lecturer deleted " + recordsAffected ;
        }
       @RequestMapping(value = "/lecturer/data/rating/{rating}", method = RequestMethod.GET)
        public  Map<String,String> getLecturerByRating(@PathVariable Integer rating)
        {
            Map<String,String> name  = demoLecturerService.getLecturerByRating(rating);
            return name;
        }


}
