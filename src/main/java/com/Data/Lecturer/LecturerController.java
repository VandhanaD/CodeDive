package com.Data.Lecturer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

    @RestController
    public class LecturerController {
        @Autowired
        LecturerService lectService;
        //= new DemoService();
        List<Lecturer1> lecturerList = new ArrayList<>();
        ResponseEntity responseEntity = null;

        // testing a plain text
        @RequestMapping (value = "/test")
        public String test()
        {
            return "save me god";
        }

        //testing Json with Map
        @RequestMapping(value = "/tryJson")
        public Map tryJson()
        {
            Map<String,Object> map = new HashMap<>();
            map.put("Message","Learning Spring");
            map.put("Name","Vandhana");
            map.put("ID", 11);
            map.put("DOB","11/03/1992");
            map.put("Qualification","B.Tech CSE");
            return map;
        }
        //testing Json with Class
        @RequestMapping(value = "/tryClass")
        public Lecturer1 tryClass()
        {
            Subjects sub = new Subjects();
            sub.setSubjectTaken("One Act Plays");
            sub.setRating(5);
            sub.setStudentFeedback("Excellent");


            Lecturer1 lectObject = new Lecturer1();
            lectObject.setName("Deva");
            Date d = new Date(1957,10,23);
            lectObject.setDOB(d); //Check date online
            lectObject.setMaritalStatus("Married");
            lectObject.setQualification("M.A,M.Ed");

            //lectObject.setClassTaken(lectObject.classTaken);
            lectObject.setSubb(sub);
            return lectObject;
        }

        //Retrieving single lecturer data
        @RequestMapping(value = "/lecturer/1")
        public Lecturer1 getLecturer1()
        {
            lecturerList = lectService.lecturerData();
            for(Lecturer1 lecturer:lecturerList)
            {
                if(lecturer.getId() == 1)
                {
                    return lecturer;
                }
            }
            return null;
        }
        //retrieving all lecturer Data
        @RequestMapping(value="lecturer/all")
        public List<Lecturer1> getLecturerAll()
        {
            lecturerList = lectService.lecturerData();
            return lecturerList;
        }
        //retrieving lecturer dynamically using PathVariable
   /* @RequestMapping(value = "/lecturer/{id}")
    public Lecturer getLecturerById(@PathVariable("id") Integer Id)
    {
        List<Lecturer> lecturer1 = lecturerData();
        for(Lecturer lecturer:lecturer1)
        {
            if(lecturer.getId() == Id)
            {
                return lecturer;
            }
        }
        return null;
    }*/

        //retrieving lecturer dynamically using PathVariable with a ResponseEntity Message
        @RequestMapping(value = "/lecturer/{id}")
        public ResponseEntity getLecturerById(@PathVariable("id") Integer Id)
        {
            lecturerList = lectService.lecturerData();
            for(Lecturer1 lecturer:lecturerList)
            {
                if(lecturer.getId() == Id)
                {
                    responseEntity = new ResponseEntity(lecturer, HttpStatus.OK);
                    return responseEntity;
                }
            }
        /*Map<String,String> map = new HashMap<>();
        map.put("Message","Lecturer not found via map");
        ResponseEntity responseEntity = new ResponseEntity(map, HttpStatus.NOT_FOUND);
       */
            String message = "Lecturer not found";
            responseEntity = new ResponseEntity(message, HttpStatus.NOT_FOUND);
            return responseEntity;

        }

        //Adding Lecturer data from RequestBody
        @RequestMapping(value = "/lecturer", method = RequestMethod.POST)
        public ResponseEntity createLecturer(@RequestBody Lecturer1 lect)
        {
            boolean isAdded = lectService.addLecturer(lect);
            String message;
            if(isAdded) {
                message = "Lecturer entry made";
                responseEntity = new ResponseEntity(message, HttpStatus.CREATED);
            }
            else
            {
                message = "Existing lecturer data.No new entry made";
                responseEntity = new ResponseEntity(message, HttpStatus.NOT_FOUND);
            }
            return responseEntity;
        }

        //Updating Lecturer Data
        @RequestMapping(value ="/lecturer", method = RequestMethod.PUT)
        private ResponseEntity updateLecturerById(@RequestBody Lecturer1 lectUpdated)
        {
            boolean isUpdated = lectService.updateLecturer(lectUpdated);
            String message;
            if(isUpdated){
                message = "Lecturer data updated successfully";
                responseEntity = new ResponseEntity(message, HttpStatus.OK);
            }
            else{
                message = "Data not found for update";
                responseEntity = new ResponseEntity(message, HttpStatus.NOT_FOUND);
            }
            return responseEntity;
        }


        @RequestMapping(value = "/deleteLecturer",method= RequestMethod.PUT)
        private ResponseEntity deleteLecturerById(@RequestBody Lecturer1 lect)
        {
            boolean isDeleted = false;
            isDeleted = lectService.deleteLecturer(lect);
            String message;
            if(isDeleted)
            {
                message = "Lecturer data deleted";
                responseEntity = new ResponseEntity(message, HttpStatus.OK);
            }
            else
            {

                message = "Lecturer data not found for Deletion";
                responseEntity = new ResponseEntity(message, HttpStatus.NOT_FOUND);

            }
            return responseEntity;
        }


        //This below content moved to separate class - DemoService
/*
    private List<Lecturer> lecturerData()
    {
           if(lecturerList.isEmpty()) {
            Lecturer l1 = new Lecturer();
            l1.setId(1);
            l1.setName("Devemuthu A");
            l1.setGender('M');
            Date d = new Date(1957, 10, 23);
            l1.setDOB(d); //Check date online
            l1.setMaritalStatus("Married");
            l1.setQualification("M.A,M.Ed");
            l1.classTaken.add("II year B.A");
            l1.classTaken.add("III year B.A");
            //lectObject.setClassTaken(lectObject.classTaken);

            Subjects s1 = new Subjects();
            s1.subjectTaken.add("One Act Plays");
            s1.subjectTaken.add("Indian Culture & Literature");
            s1.subjectTaken.add("Riders to the Sea");
            s1.setRating(5);
            s1.setStudentFeedback("Excellent");
            l1.setSubb(s1);

            Lecturer l2 = new Lecturer();
            l2.setId(2);
            l2.setName("Mageswari G");
            l2.setGender('F');
            l2.setDOB(new Date(1969, 06, 17));
            l2.setMaritalStatus("Unmarried");
            l2.setQualification("M.A,B.ED");
            l2.classTaken.add("I year B.A");
            l2.classTaken.add("II year B.A");
            //lectObject.setClassTaken(lectObject.classTaken);

            Subjects s2 = new Subjects();
            s2.subjectTaken.add("Modern History");
            s2.subjectTaken.add("Ancient History");
            s2.subjectTaken.add("Medieval History");
            s2.subjectTaken.add("World History");
            s2.subjectTaken.add("Indian Art and Culture");
            s2.setRating(4);
            s2.setStudentFeedback("Moderate");
            l2.setSubb(s2);
            lecturerList.add(l1);
            lecturerList.add(l2);
        }
        return lecturerList;
    }

    private boolean addLecturer(Lecturer Lect)
    {
        lecturerList = lecturerData();
        boolean isAdded = true;
        Iterator<Lecturer> iterator = lecturerList.iterator();
        while(iterator.hasNext())
        {
            Lecturer lecturer = iterator.next();
            if(lecturer.getId() == Lect.getId())
            {
                isAdded = false;
                break;
            }
        }
        if(isAdded)
        {
            lecturerList.add(Lect);
        }
        return isAdded;
    }

    private boolean updateLecturer(Lecturer lect)
    {
        lecturerList = lecturerData();
        boolean removed = false;

        Iterator<Lecturer> iterator = lecturerList.iterator();
        while(iterator.hasNext())
        {
            Lecturer lecturer = iterator.next();
            if(lecturer.getId() == lect.getId())
            {
                iterator.remove();
                removed = true;
                break;
            }
        }
        if(removed) {
            lecturerList.add(lect);
        }

        return removed;

    }

    private boolean deleteLecturer(Lecturer lect)
    {
        lecturerList = lecturerData();
        boolean isdeleted = false;
        for(int i=0; i<lecturerList.size();i++)
        {
            if(lecturerList.get(i).getId() == lect.getId())
            {
                lecturerList.remove(i);
                isdeleted = true;
            }
        }
        return isdeleted;
    }*/


    }


