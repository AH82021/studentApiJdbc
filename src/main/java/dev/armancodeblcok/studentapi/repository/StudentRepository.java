package dev.armancodeblcok.studentapi.repository;

import dev.armancodeblcok.studentapi.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

//bean(Object) managed by Spring Framework
@Repository
public class StudentRepository {

private final JdbcTemplate jdbcTemplate ;

    public StudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Student> findAllStudents() {
        String sql = "SELECT id, name,email,gpa from students";
        return jdbcTemplate.query(sql,StudentRowMapper.INSTANCE);
    }

// Nazia Iqbal
    public Long createStudent(Student student){
       String sql = "INSERT INTO students (name,email,gpa) VALUES(?,?,?)";
       // avoid SQL Injection attack
// Using Keyholder to retrieve the auto-generated key
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection ->{
            PreparedStatement ps = connection.prepareStatement(sql,new String[]{"id"});
            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setDouble(3,student.getGpa());
            return ps;
        },keyHolder);

        if(keyHolder.getKey() !=null){
            return keyHolder.getKey().longValue();
        } else {
            throw new RuntimeException("Failed to insert student");
        }

    }

    public void updateStudent(Long id,Student student){
        String sql = "UPDATE students SET name=?,email=?, gpa=? where id=?";
     int count =   jdbcTemplate.update(sql,student.getName(),student.getEmail(),student.getGpa(),id);
        if(count == 0){
            throw new RuntimeException("Student not found");
        }
    }

    public void deleteStudent(Long id){
        String sql = "DELETE FROM students WHERE id=?";
        int count = jdbcTemplate.update(sql,id);
        if(count == 0){
            throw new RuntimeException("Student not found");
        }
    }



    public Optional<Student> findById(Long id) {
        String sql = " SELECT * FROM students WHERE id = ?";
        try {
          Student student = jdbcTemplate.queryForObject(sql,StudentRowMapper.INSTANCE,id);
          return Optional.of(student);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }








   static  class StudentRowMapper implements RowMapper<Student>{
        private static final StudentRowMapper INSTANCE = new StudentRowMapper();
        private StudentRowMapper() {}

       @Override
       public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
           return new Student(
                   rs.getLong("id"),
                   rs.getString("name"),
                   rs.getString("email"),
                   rs.getDouble("gpa")
           );
       }
   }

}
