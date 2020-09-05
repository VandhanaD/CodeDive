package com.Data.Lecturer;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service
public class LecturerService {
    List<Lecturer1> lecturerList = new ArrayList<>();
    public List<Lecturer1> lecturerData()
    {
        if(lecturerList.isEmpty()) {
            Lecturer1 l1 = new Lecturer1();
            l1.setId(1);
            l1.setName("Devamuthu A");
            //l1.setGender('M');
            Date d = new Date(1957, 10, 23);
            l1.setDOB(d); //Check date online
            l1.setMaritalStatus("Married");
            l1.setQualification("M.A,M.Ed");


            Subjects s1 = new Subjects();
            s1.setSubjectTaken("One Act Plays,Indian Literature");
            s1.setRating(5);
            s1.setStudentFeedback("Excellent");
            l1.setSubb(s1);

            Lecturer1 l2 = new Lecturer1();
            l2.setId(2);
            l2.setName("Mageswari G");
            l2.setDOB(new Date(1969, 06, 17));
            l2.setMaritalStatus("Unmarried");
            l2.setQualification("M.A,B.ED");


            //lectObject.setClassTaken(lectObject.classTaken);

            Subjects s2 = new Subjects();
            s2.setSubjectTaken("Modern History,Ancient History");
            s2.setRating(4);
            s2.setStudentFeedback("Moderate");
            l2.setSubb(s2);
            lecturerList.add(l1);
            lecturerList.add(l2);
        }
        return lecturerList;
    }

    public boolean addLecturer(Lecturer1 Lect)
    {
        lecturerList = lecturerData();
        boolean isAdded = true;
        Iterator<Lecturer1> iterator = lecturerList.iterator();
        while(iterator.hasNext())
        {
            Lecturer1 lecturer = iterator.next();
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

    public boolean updateLecturer(Lecturer1 lect)
    {
        lecturerList = lecturerData();
        boolean removed = false;

        Iterator<Lecturer1> iterator = lecturerList.iterator();
        while(iterator.hasNext())
        {
            Lecturer1 lecturer = iterator.next();
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

    public boolean deleteLecturer(Lecturer1 lect)
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
    }
}
