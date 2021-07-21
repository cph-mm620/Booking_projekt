package business.persistence;

import business.entities.Student;
import business.entities.User;
import business.exceptions.UserException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentMapper {

    Database database;
    public StudentMapper(Database database) {

        this.database = database;
    }

    public List<User> getAllStudents() throws UserException{
        List<User> studentList = new ArrayList<>();

        try (Connection connection = database.connect())
        {
            String sql = "SELECT *, role FROM users WHERE role='student'";

            try (PreparedStatement ps = connection.prepareStatement(sql))
            {

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String role = rs.getString("role");
                    int id = rs.getInt("id");
                    String email = rs.getString("email");
                    String password = rs.getString("password");
                    int point = rs.getInt("point");
                    User user = new User(id, email, password, role, point);
                    user.setId(id);
                    studentList.add(user);
                }
            }
            catch (SQLException ex)
            {
                throw new UserException(ex.getMessage());
            }
        }
        catch (SQLException ex)
        {
            throw new UserException("Connection to database could not be established");
        }


        return studentList;
    }

    public Student addNewStudent(Student student) throws UserException {

        try (Connection connection = database.connect()) {
            String sql = "INSERT INTO user SET email = ?, password = ?, role = ?, phone = ?";

            try (PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
                ps.setString(1, student.getEmail());
                ps.setString(2, student.getPassword());
                ps.setString(3, student.setRole("student"));
                ps.setInt(4, student.getPhone());
                ps.executeUpdate();
                ResultSet ids = ps.getGeneratedKeys();
                ids.next();

            } catch (SQLException ex) {
                throw new UserException(ex.getMessage());
            }
        } catch (SQLException ex) {
            throw new UserException(ex.getMessage());
        }
        return student;
    }
}
