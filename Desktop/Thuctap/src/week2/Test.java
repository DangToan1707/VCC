package week2;

import java.sql.*;

public class Test {
    public void getTest1(Connection connection, String name) throws SQLException {
        String sql = "select city.name, city.population, id " + "from city join country " + "on city.country = country.code " + "where country.name = ? " + "order by city.population desc " + "limit 1";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, name);
        ResultSet result = statement.executeQuery();
        if(result.next()) {
            int id = result.getInt("id");
            String nameCity = result.getString("name");
            int population = result.getInt("population");
            City city = new City(id,nameCity,population);
            System.out.println(city.getName() + " la thanh pho dong dan nhat dat nuoc" +name );
        }
    }
    public void getTest2(Connection connection, String name) throws SQLException {
        String sql = "select city.name, city.population, id " + "from city join country " + "on city.country = country.code " + "where country.continent = ? " + "order by city.population desc " + "limit 1";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, name);
        ResultSet result = statement.executeQuery();
        if(result.next()) {
            int id = result.getInt("id");
            String cname = result.getString("name");
            int population = result.getInt("population");
            City city = new City(id, cname, population);
            System.out.println(city.getName() + " la thanh pho dong dan nhat luc dia " + name );
        }
    }

    public void getTest3(Connection connection) throws SQLException {
        String sql = "select * from city " + "where city.id in (select capital from country) " + "order by city.population desc limit 1";
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql);
        if(result.next()) {
            int id = result.getInt("id");
            String name = result.getString("name");
            int population = result.getInt("population");
            City city = new City(id, name, population);
            System.out.println("thu do dong dan nhat the gioi  " + city.getName());
        }
    }

    public void getTest4(Connection connection, String continent) throws SQLException {
        String sql = "select * from city join country on city.country = country.code " + "where city.id in (select capital from country) " + "and country.continent = ? " + "order by city.population desc limit 1";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, continent);
        ResultSet result = statement.executeQuery();
        if(result.next()) {
            int id = result.getInt("id");
            String name = result.getString("name");
            int population = result.getInt("population");
            City city = new City(id, name, population);
            System.out.println("ma thanh pho dong dan nhat" + continent + " la " + city.getName());
        }
    }

    public void getTest5(Connection connection) throws SQLException {
        String sql = "select country.name, count(city.id) as sothanhpho " + "from country join city " + "on city.country = country.code " + "group by country.name " + "order by sothanhpho desc";
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql);
        System.out.println("ca quoc gia co so luong thanh pho giam dan:");
        System.out.println("quoc gia: ");
        while (result.next()) {
            String name = result.getString(1);
            System.out.println(name );
        }
    }

    public void getTest6(Connection connection) throws SQLException {
        String sql = "select name, (population/surface_area) as matdo " + "from country " + "where population > 0 " + "order by matdo desc";
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery(sql);
        System.out.println("cac quoc gia co mat do dan so giam:");
        System.out.println("quoc gia : ");
        while (result.next()) {
            String name = result.getString(1);
            System.out.printf("%s ", name);
        }
    }
}
