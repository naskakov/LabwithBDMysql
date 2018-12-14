package Model;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Logger;

public class DBWorker {
    private static final String URL = "jdbc:mysql://localhost:3311/lb2";
    private static final String USERNAME = "root";
    private static final String PASS = "Nastik0512";

    private static final String INSERT_PEOPLE = "INSERT INTO people VALUES(?,?,?,?,?,?,?,?,?);";
    private static final String UPDATE_PEOPLE = "UPDATE people SET " +
            "person=?,nameT=?,name=?,city=?,street=?,home=?,flat=?,number=?,series=?" +
            "WHERE person=? AND nameT=? AND name=? AND city=? AND street=? AND home=? AND flat=? AND number=? AND series=?;";
    private static final String DELETE_PEOPLE = "DELETE FROM people WHERE " +
            "person=? AND nameT=? AND name=? AND city=? AND street=? AND home=? AND flat=? AND number=? AND series=?;";

    private static final String INSERT_INVOICE ="INSERT INTO invoice VALUES(?,?,?,?,?,?);";
    private static final String UPDATE_INVOICE = "UPDATE invoice SET date=?,name=?,selling_price=?,kol=?,nameT=?,nameP=? WHERE date=? AND name=? AND selling_price=? AND kol=? AND nameT=? AND nameP=?;";
    private static final String DELETE_INVOICE = "DELETE FROM invoice WHERE date=? AND name=? AND selling_price=? AND kol=? AND nameT=? AND nameP=?;";

    private static final String INSERT_TOVAR = "INSERT INTO tovar VALUES(?,?,?);";
    private static final String UPDATE_TOVAR = "UPDATE tovar SET " + "kod=?,nameT=?,category=? " + "WHERE kod=? AND nameT=? AND category=?;";
    private static final String DELETE_TOVAR = "DELETE FROM tovar " +
            "WHERE kod=? AND nameT=?  AND category=?;";

    private static final String NAMET_WITH_NAMEP = "SELECT date,name,selling_price,nameT,nameP FROM lb2.invoice WHERE  nameT=? AND nameP=?;";
    private static final String SORT_NAME_PERSON = "SELECT city,street,home,flat FROM people WHERE person=? AND name=?;";
    private  static final String SORT_CATEGORY = "SELECT *, COUNT(*) c FROM tovar GROUP BY category HAVING c > 1;";


    private Connection connection;
    private PreparedStatement preparedStatement;

    public DBWorker(){
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            connection=DriverManager.getConnection(URL, USERNAME, PASS);
        }catch (SQLException e){
            e.getMessage();
            e.printStackTrace();
        }
    }

    public void addPeople(People people){
        try {
            preparedStatement = connection.prepareStatement(INSERT_PEOPLE);

            preparedStatement.setString(1,people.getPerson());
            preparedStatement.setString(2,people.getNameT());
            preparedStatement.setString(3,people.getName());
            preparedStatement.setString(4,people.getCity());
            preparedStatement.setString(5,people.getStreet());
            preparedStatement.setInt(6,people.getHome());
            preparedStatement.setInt(7,people.getFlat());
            preparedStatement.setString(8,people.getNumber());
            preparedStatement.setString(9,people.getSeries());

            preparedStatement.execute();
        }catch(SQLException e){
            e.getMessage();
            e.printStackTrace();
        }
    }

    public void editPeople(People people,People newPeople) {
        try{
            preparedStatement=connection.prepareStatement(UPDATE_PEOPLE);

            preparedStatement.setString(1,newPeople.getPerson());
            preparedStatement.setString(2,newPeople.getNameT());
            preparedStatement.setString(3,newPeople.getName());
            preparedStatement.setString(4,newPeople.getCity());
            preparedStatement.setString(5,newPeople.getStreet());
            preparedStatement.setInt(6,newPeople.getHome());
            preparedStatement.setInt(7,newPeople.getFlat());
            preparedStatement.setString(8,newPeople.getNumber());
            preparedStatement.setString(9,newPeople.getSeries());

            preparedStatement.setString(10,people.getPerson());
            preparedStatement.setString(11,people.getNameT());
            preparedStatement.setString(12,people.getName());
            preparedStatement.setString(13,people.getCity());
            preparedStatement.setString(14,people.getStreet());
            preparedStatement.setInt(15,people.getHome());
            preparedStatement.setInt(16,people.getFlat());
            preparedStatement.setString(17,people.getNumber());
            preparedStatement.setString(18,people.getSeries());

            preparedStatement.execute();
        }catch(SQLException e){
            e.getMessage();
            e.printStackTrace();
        }
    }

    public void deletePeople(People people){
        try{
            preparedStatement=connection.prepareStatement(DELETE_PEOPLE);

            preparedStatement.setString(1,people.getPerson());
            preparedStatement.setString(2,people.getNameT());
            preparedStatement.setString(3,people.getName());
            preparedStatement.setString(4,people.getCity());
            preparedStatement.setString(5,people.getStreet());
            preparedStatement.setInt(6,people.getHome());
            preparedStatement.setInt(7,people.getFlat());
            preparedStatement.setString(8,people.getNumber());
            preparedStatement.setString(9,people.getSeries());

            preparedStatement.execute();
        }catch(SQLException e){
            e.getMessage();
            e.printStackTrace();
        }
    }

    public void addInvoice(Invoice invoice) {
        try{
            preparedStatement = connection.prepareStatement(INSERT_INVOICE);

            preparedStatement.setString(1,invoice.getDate());
            preparedStatement.setString(2,invoice.getName());
            preparedStatement.setFloat(3,invoice.getSellingPrice());
            preparedStatement.setLong(4,invoice.getKol());
            preparedStatement.setString(5,invoice.getNameT());
            preparedStatement.setString(6,invoice.getNameP());

            preparedStatement.execute();
        }catch (SQLException e){
            e.getMessage();
            e.printStackTrace();
        }
    }

    public void editInvoice(Invoice invoice, Invoice newInvoice){
        try{
            preparedStatement=connection.prepareStatement(UPDATE_INVOICE);

            preparedStatement.setString(1,newInvoice.getDate());
            preparedStatement.setString(2,newInvoice.getName());
            preparedStatement.setFloat(3,newInvoice.getSellingPrice());
            preparedStatement.setLong(4,newInvoice.getKol());
            preparedStatement.setString(5,newInvoice.getNameT());
            preparedStatement.setString(6,newInvoice.getNameP());

            preparedStatement.setString(7,invoice.getDate());
            preparedStatement.setString(8,invoice.getName());
            preparedStatement.setFloat(9,invoice.getSellingPrice());
            preparedStatement.setLong(10,invoice.getKol());
            preparedStatement.setString(11,invoice.getNameT());
            preparedStatement.setString(12,invoice.getNameP());

            preparedStatement.execute();
        }catch(SQLException e){
            e.getMessage();
            e.printStackTrace();
        }
    }

    public void deleteInvoice(Invoice invoice) {
        try{
            preparedStatement=connection.prepareStatement(DELETE_INVOICE);

            preparedStatement.setString(1,invoice.getDate());
            preparedStatement.setString(2,invoice.getName());
            preparedStatement.setFloat(3,invoice.getSellingPrice());
            preparedStatement.setLong(4,invoice.getKol());
            preparedStatement.setString(5,invoice.getNameT());
            preparedStatement.setString(6,invoice.getNameP());

            preparedStatement.execute();
        }catch (SQLException e){
            e.getMessage();
            e.printStackTrace();
        }
    }

    public void addTovar(Tovar tovar){
        try {
            preparedStatement = connection.prepareStatement(INSERT_TOVAR);

            preparedStatement.setLong(1,tovar.getKod());
            preparedStatement.setString(2,tovar.getNameT());
            preparedStatement.setString(3,tovar.getCategory());

            preparedStatement.execute();
        }catch(SQLException e){
            e.getMessage();
            e.printStackTrace();
        }
    }

    public void editTovar(Tovar tovar, Tovar newTovar){
        try {
            preparedStatement = connection.prepareStatement(UPDATE_TOVAR);

            preparedStatement.setLong(1,newTovar.getKod());
            preparedStatement.setString(2,newTovar.getNameT());
            preparedStatement.setString(3,newTovar.getCategory());

            preparedStatement.setLong(4,tovar.getKod());
            preparedStatement.setString(5,tovar.getNameT());
            preparedStatement.setString(6,tovar.getCategory());

            preparedStatement.execute();
        }catch(SQLException e){
            e.getMessage();
            e.printStackTrace();
        }
    }

    public void deleteTovar(Tovar tovar){
        try{
            preparedStatement=connection.prepareStatement(DELETE_TOVAR);

            preparedStatement.setLong(1,tovar.getKod());
            preparedStatement.setString(2,tovar.getNameT());
            preparedStatement.setString(3,tovar.getCategory());

            preparedStatement.execute();
        }catch (SQLException e){
            e.getMessage();
            e.printStackTrace();
        }
    }

    public List<People> getPeople(){
        List<People> list=new ArrayList<>();
        try {
            Statement statement=connection.createStatement();

            ResultSet resultSet=statement.executeQuery("SELECT * FROM people;");
            while(resultSet.next()){
                People people=new People();

                people.setPerson(resultSet.getString(1));
                people.setNameT(resultSet.getString(2));
                people.setName(resultSet.getString(3));
                people.setCity(resultSet.getString(4));
                people.setStreet(resultSet.getString(5));
                people.setHome(resultSet.getInt(6));
                people.setFlat(resultSet.getInt(7));
                people.setNumber(resultSet.getString(8));
                people.setSeries(resultSet.getString(9));

                list.add(people);
            }
        }catch(SQLException e){
            e.getMessage();
            e.printStackTrace();
        }
        return list;
    }

    public List<Invoice> getInvoice() {
        List<Invoice> list=new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet=statement.executeQuery("SELECT * FROM invoice;");
            while(resultSet.next()){
                Invoice invoice=new Invoice();

                invoice.setDate(resultSet.getString(1));
                invoice.setName(resultSet.getString(2));
                invoice.setSelling_price(resultSet.getFloat(3));
                invoice.setKol(resultSet.getLong(4));
                invoice.setNameT(resultSet.getString(5));
                invoice.setNameP(resultSet.getString(6));

                list.add(invoice);
            }
        }catch(SQLException e){
            e.getMessage();
            e.printStackTrace();
        }
        return list;
    }

    public List<Tovar> getTovar(){
        List<Tovar> list=new ArrayList<>();
        try{
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("SELECT * FROM tovar;");
            while(resultSet.next()){
                Tovar tovar=new Tovar();

                tovar.setKod((resultSet.getLong(1)));
                tovar.setNameT(resultSet.getString(2));
                tovar.setCategory(resultSet.getString(3));

                list.add(tovar);
            }
        }catch(SQLException e){
            e.getMessage();
            e.printStackTrace();
        }
        return list;
    }

    public List<Invoice> sortNameTAndDate(String nameT, String nameP) {
        List<Invoice> list = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(NAMET_WITH_NAMEP);
            preparedStatement.setString(1, nameT);
            preparedStatement.setString(2, nameP);


            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Invoice employee = new Invoice();

                employee.setDate(resultSet.getString(1));
                employee.setName(resultSet.getString(2));
                employee.setSelling_price(resultSet.getFloat(3));
                employee.setNameT(resultSet.getString(4));
                employee.setNameP(resultSet.getString(5));

                list.add(employee);
            }

        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();
        }

        return list;
    }

    public List<People> sortNameTAndPerson(String person, String name) {
        List<People> list = new ArrayList<>();
        try {
            preparedStatement = connection.prepareStatement(SORT_NAME_PERSON);
            preparedStatement.setString(1, person);
            preparedStatement.setString(2, name);


            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                People people = new People();

                people.setCity(resultSet.getString(1));
                people.setStreet(resultSet.getString(2));
                people.setHome(resultSet.getInt(3));
                people.setFlat(resultSet.getInt(4));

                list.add(people);
            }

        } catch (SQLException e) {
            e.getMessage();
            e.printStackTrace();
        }

        return list;
    }



}
