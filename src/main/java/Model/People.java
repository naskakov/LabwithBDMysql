package Model;

public class People {
    private String person;
    private String nameT;
    private String name;
    private String city;
    private String street;
    private int home;
    private int flat;
    private String number;
    private String series;

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getNameT() {
        return nameT;
    }

    public void setNameT(String nameT) {
        this.nameT = nameT;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHome() {
        return home;
    }

    public void setHome(int home) {
        this.home = home;
    }

    public int getFlat(){return flat;}

    public void setFlat(int flat) {
        this.flat = flat;
    }

    public String getNumber(){return number;}

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSeries(){return series;}

    public void setSeries(String series) {
        this.series = series;
    }
}