package com.Data.Lecturer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class LecturerDataService {
    @Autowired
    LecturerDataRepository demoLecturerRepository;
    List<Lecturer1> lectList = new ArrayList<>();
    int recordsAffected;

  /*  public List<Lecturer1> getLecturerData()
    {
        lectL ist = demoLecturerRepository.getLecturerData();
        return lectList;
    }*/

    public List<Lecturer1> getAllLecturer(Integer id)
    {
        lectList = demoLecturerRepository.getAllLecturer(id);
        return lectList;
    }

    public int addLecturerData(Lecturer1 lect)
    {
        recordsAffected = demoLecturerRepository.addLecturerData(lect);
        return recordsAffected;
    }

    public int updateLecturerData(Lecturer1 lect)
    {
        recordsAffected = demoLecturerRepository.updateLecturerData(lect);
        return recordsAffected;
    }
    public int deleteLecturerData(Integer id)
    {
        recordsAffected = demoLecturerRepository.deleteLecturerData(id);
        return recordsAffected;
    }
    public  Map<String,String> getLecturerByRating(Integer rating)
    {
        Map<String,String> name = demoLecturerRepository.getLecturerByRating(rating);
        return name;
    }


}
