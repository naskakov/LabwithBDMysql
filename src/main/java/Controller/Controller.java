package Controller;

import Model.*;

import java.util.List;

public class Controller {
    private DBWorker dbWorker;

    public Controller(){
        dbWorker = new DBWorker();
    }

    public void addPeople(People people) {
        dbWorker.addPeople(people);
    }

    public void editPeople(People people, People newPeople) {
        dbWorker.editPeople(people,newPeople);
    }

    public void deletePeople(People people){
        dbWorker.deletePeople(people);
    }

    public void addInvoice(Invoice invoice) {
        dbWorker.addInvoice(invoice);
    }

    public void editInvoice(Invoice invoice, Invoice newInvoice){
        dbWorker.editInvoice(invoice,newInvoice);
    }

    public void deleteInvoice(Invoice invoice){
        dbWorker.deleteInvoice(invoice);
    }

    public void addTovar(Tovar tovar){
        dbWorker.addTovar(tovar);
    }

    public void editTovar(Tovar tovar, Tovar newTovar){
        dbWorker.editTovar(tovar,newTovar);
    }

    public void deleteTovar(Tovar tovar){
        dbWorker.deleteTovar(tovar);
    }

    public List<People> getPeople() {
        return dbWorker.getPeople();
    }

    public List<Invoice> getInvoice() {
        return dbWorker.getInvoice();
    }

    public List<Tovar> getTovar() {
        return dbWorker.getTovar();
    }

    public List<Invoice> sortNameTAndDate(String nameT, String nameP){
        return dbWorker.sortNameTAndDate(nameT, nameP);
    }

    public List<People> sortNameTAndPerson(String person, String name){
        return dbWorker.sortNameTAndPerson(person, name);
    }
}
