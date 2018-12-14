package Model;

public class InvoiceAndPeople {
    private String name;
    private Float selling_price;
    private String date;
    private String city;
    private String street;
    private int home;
    private int flat;

    public String getname() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getSellingPrice(){return selling_price;}

    public void setSellingPrice(Float selling_price){this.selling_price=selling_price;}

    public String getDate(){return date;}

    public void setDate(String date){this.date=date;}

    public String getCity(){return city;}

    public void setCity(String city){this.city=city;}

    public String getStreet(){return street;}

    public void setStreet(String street){this.street=street;}

    public int getHome(){return home;}

    public void setHome(int home){this.home=home;}

    public int getFlat(){return flat;}

    public void setFlat(int flat){this.flat=flat;}

}
