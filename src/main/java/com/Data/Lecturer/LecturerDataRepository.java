package com.Data.Lecturer;


        import org.apache.tomcat.util.digester.ArrayStack;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.dao.DataAccessException;
        import org.springframework.jdbc.core.JdbcTemplate;
        import org.springframework.jdbc.core.ResultSetExtractor;
        import org.springframework.jdbc.core.RowMapper;
        import org.springframework.stereotype.Repository;
        import org.springframework.web.bind.annotation.PathVariable;

        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;

@Repository
public class LecturerDataRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;
    String query;
    int recordsAffected;

   /*public List<Lecturer1> getLecturerData() {
        query = "SELECT * FROM Lecturer";
        List<Lecturer1> lecturerList = jdbcTemplate.query(query, new RowMapper<Lecturer1>() {

            @Override
            public Lecturer1 mapRow(ResultSet resultSet, int i) throws SQLException {
                Lecturer1 L = new Lecturer1();
                L.setId(resultSet.getInt("Id"));
                L.setName(resultSet.getString("Name"));
                L.setDOB(resultSet.getDate("DOB"));
                L.setMaritalStatus(resultSet.getString("Maritalstatus"));
                L.setQualification(resultSet.getString("Qualification"));

                Subjects s = new Subjects();
                s.setSubjectTaken(resultSet.getString("SubjectTaken"));
                s.setStudentFeedback(resultSet.getString("StudentFeedback"));
                s.setRating(resultSet.getInt("Rating"));
                L.setSubb(s);
                return L;
            }
        });
        return lecturerList;
    }*/



    List<Lecturer1> getAllLecturer(Integer id) {
        String query = "SELECT * FROM Lecturer where Id = ?";

        List<Lecturer1> lectList = jdbcTemplate.query(query, new RowMapper<Lecturer1>() {

            @Override
            public Lecturer1 mapRow(ResultSet resultSet, int i) throws SQLException {
                Lecturer1 lect = new Lecturer1();
                lect.setId(resultSet.getInt("Id"));
                lect.setName(resultSet.getString("Name"));
                lect.setDOB(resultSet.getDate("DOB"));
                lect.setMaritalStatus(resultSet.getString("Maritalstatus"));
                lect.setQualification(resultSet.getString("Qualification"));

                Subjects subb = new Subjects();
                subb.setSubjectTaken(resultSet.getString("SubjectTaken"));
                subb.setStudentFeedback(resultSet.getString("StudentFeedback"));
                subb.setRating(resultSet.getInt("Rating"));
                lect.setSubb(subb);
                return lect;
            }
        },id);
        return lectList;
    }


    public int addLecturerData(Lecturer1 lect)
    {
        query = "INSERT INTO Lecturer (Id, Name, DOB, MaritalStatus, Qualification, SubjectTaken, StudentFeedback, Rating) " +
                "values(?,?,?,?,?,?,?,?)";
        recordsAffected = jdbcTemplate.update(query,lect.getId(),lect.getName(),lect.getDOB(),lect.getMaritalStatus(),
                lect.getQualification(),lect.getSubb().getSubjectTaken(),lect.getSubb().getStudentFeedback(),lect.getSubb().getRating());

        return recordsAffected;
    }
    public int updateLecturerData(Lecturer1 lect)
    {
        query = "UPDATE Lecturer SET StudentFeedback = ? WHERE Id = ?";
        recordsAffected = jdbcTemplate.update(query, lect.getSubb().getStudentFeedback(),lect.getId());
        return recordsAffected;
    }

    public int deleteLecturerData(Integer id)
    {
        query  = "DELETE FROM Lecturer WHERE Id = ?";
        recordsAffected = jdbcTemplate.update(query, id);
        return recordsAffected;
    }
   public Map<String,String> getLecturerByRating(Integer rating)
    {
        Map<String,String>  nameTemp =  new HashMap<String, String>();
        query = "SELECT Name FROM Lecturer WHERE Rating = ? " ;
        Map<String,String>  name = jdbcTemplate.query(query,
                 new ResultSetExtractor<Map<String,String>>() {
            @Override
            public Map<String,String>  extractData(ResultSet resultSet) throws SQLException, DataAccessException {
                while (resultSet.next()) {
                    nameTemp.put("Name", resultSet.getString("Name"));

                }
                return nameTemp;
            }
        }, rating);
        return name;
    }


}
