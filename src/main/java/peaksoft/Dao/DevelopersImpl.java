package peaksoft.Dao;

import peaksoft.Company.Company;
import peaksoft.Util.ConnectionDataBase;
import peaksoft.Company.Company;
import peaksoft.model.Developers;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DevelopersImpl implements DevelopersDao{

     Connection connection=ConnectionDataBase.getConnection();

    @Override
    public void create() {
        String sql = """
                create table if not exists developers(
                id serial primary key,
                full_name varchar
                age smalling not null,
                company varchar);
                """;
        try(Statement statement = connection.createStatement()) {
            statement.execute(sql);
        } catch (SQLException e) {
            System.out.println("Successfully created!");
            System.out.println(e.getMessage());
        }

    }

    @Override
    public void save(Developers developers) {
        String sql= """
                insert into developers(full_name,age,company)VALUES
                (?,?,?);
                """;
       try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
           preparedStatement.setString(1,developers.getFullName());
           preparedStatement.setByte(2,  developers.getAge());
           preparedStatement.setString(3,developers.getCompany());
           System.out.println("Successfully saved!");
    }catch (SQLException e){
           System.out.println(e.getMessage());
       }
    }

    @Override
    public void findById(Long id) {
        Developers developers = new Developers();
        String sql = """
                select * from developers where id = ?;
                """;
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                developers.setId(resultSet.getLong("id"));
                developers.setFullName(resultSet.getString("full_name"));
                developers.setAge(resultSet.getByte("age"));
                System.out.println("Successfully find!");
            }

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }

    @Override
    public List<Developers> getAll() {
        List<Developers> developersList = new ArrayList<>();
        String sql= """
                select * from developers;
                """;
        try(Statement statement = connection.createStatement()){
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Developers developers = new Developers();
                developers.setId(resultSet.getLong("id"));
                developers.setFullName(resultSet.getString("full_name"));
                developers.setAge(resultSet.getByte("age"));
                developersList.add(developers);
                System.out.println("Successfully!");
            }
        }catch (SQLException e ){

        }
        return developersList;
    }

    @Override
    public void delete(Long id) {
        String sql = """
                delete * from developers where id= ?;
                """;
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1,id);
            if (preparedStatement.executeUpdate() > 0){
                System.out.println("Successfully delete");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Long id, Developers newdevelopers) {

        try(PreparedStatement preparedStatement = connection.prepareStatement("""
        update developers set full_name = ?, age = ? ,company =?  where id =?;""")){
            preparedStatement.setString(1, newdevelopers.getFullName());
            preparedStatement.setInt(2, newdevelopers.getAge());
            preparedStatement.setString(3,newdevelopers.getCompany());
            preparedStatement.executeUpdate();
            System.out.println("Successfully update table!");

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

}









