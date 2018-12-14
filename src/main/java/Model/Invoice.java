package Model;

public class Invoice {
    private String date;
    private String name;
    private Float selling_price;
    private Long kol;
    private String nameT;
    private String nameP;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getSellingPrice() {
        return selling_price;
    }

    public void setSelling_price(Float selling_price) {
        this.selling_price = selling_price;
    }

    public Long getKol() {
        return kol;
    }

    public void setKol(Long kol) {
        this.kol = kol;
    }

    public String getNameT(){
        return nameT;
    }

    public void setNameT(String nameT){
        this.nameT = nameT;
    }

    public String getNameP(){
        return nameP;
    }

    public void setNameP(String nameP){
        this.nameP = nameP;
    }
}
