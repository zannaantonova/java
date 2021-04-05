package ee.bcs.java.demo.tasks.lesson1.sample.employee;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SolutionEmployeeRowMapper implements RowMapper<SolutionEmployee> {

    @Override
    public SolutionEmployee mapRow(ResultSet resultSet, int i) throws SQLException {
        SolutionEmployee employee = new SolutionEmployee();
        employee.setFirstName(resultSet.getString("first_name"));
        employee.setLastName(resultSet.getString("last_name"));
        employee.setId(resultSet.getInt("id"));
        return employee;
    }
}
