package project.spring4.mvc.employee.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import project.spring4.mvc.employee.model.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository("empdao")
public class EmployeeDAOImpl implements EmployeeDAO{
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeDAOImpl(JdbcTemplate jdbcTemplate){this.jdbcTemplate = jdbcTemplate;}

    @Value("#{jdbc['selectSQL']}") private String selectSQL;
    @Value("#{jdbc['selectOneSQL']}") private String selectOneSQL;
    @Value("#{jdbc['insertSQL']}") private String insertSQL;
    @Value("#{jdbc['updateSQL']}") private String updateSQL;
    @Value("#{jdbc['deleteSQL']}") private String deleteSQL;

    @Override
    public int insertEmployee(Employee emp) {
        return 0;
    }

    @Override
    public List<Employee> selectEmployee() {
        RowMapper<Employee> mapper = new EmployeeMapper();
        return jdbcTemplate.query(selectSQL, mapper);
    }

    private class EmployeeMapper implements RowMapper<Employee> {
        // mapRow() 메소드는 jdbcTemplate 의 query() 메서드가 데이터베이스에서 조회된 결과셋을 처리하는 과정에서 내부적으로 호출된다
        @Override
        public Employee mapRow(ResultSet rs, int num) throws SQLException {
            Employee emp = new Employee(rs.getInt(1), rs.getString(2),
                    rs.getString(3), rs.getString(4), rs.getInt(5));
            return emp;
        }
    }


    @Override
    public Employee selectOneEmployee(int empid) {
        return null;
    }

    @Override
    public int updateEmployee(Employee emp) {
        return 0;
    }

    @Override
    public int deleteEmployee(int empid) {
        return 0;
    }
}
