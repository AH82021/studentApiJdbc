package dev.armancodeblcok.studentapi.repository;

import dev.armancodeblcok.studentapi.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

//bean(Object) managed by Spring Framework
@Component
public class StudentRepository {

private final JdbcTemplate jdbcTemplate ;

    public StudentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Student> findAllStudents() {
        String sql = "SELECT id, name,email,gpa from students";
        return jdbcTemplate.query(sql,StudentRowMapper.INSTANCE);
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
