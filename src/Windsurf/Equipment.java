package Windsurf;

import Windsurf.Foil.Foil;

import java.io.Serializable;
import java.util.Date;

//public abstract -> get access in Foil package
public abstract class Equipment implements Serializable {
    //Variables---------------------------------------------------------------------------------------------------------
    private int year = -1;
    private String brand;
    private Category category;
    private Date acquisitionDate;
    private String note;
    private Discipline discipline;

    public enum Category {
        PLANCHE,
        FOIL,
        BOTH
    }
    public enum Discipline {
        SLALOM,
        RACE,
        FREERACE,
        FREERIDE,
        FREESTYLE,
        WAVE
    }

    //Constructors------------------------------------------------------------------------------------------------------
    public Equipment(int year, String brand, Category category, Date acquisitionDate, Discipline discipline) {
        this.year = year;
        this.brand = brand;
        this.category = category;
        this.acquisitionDate = acquisitionDate;
        this.discipline = discipline;
    }
    public Equipment(int year, String brand, Category category, Discipline discipline){
        this(year, brand, category, new Date(), discipline);
    }
    public Equipment(int year, String brand, Category category){this(year, brand, category, Discipline.SLALOM);}
    public Equipment(){
        this(-1, null, Category.BOTH, new Date(), Discipline.SLALOM);
    }

    //Getters and Setters-----------------------------------------------------------------------------------------------
    public int getyear(){
        return this.year;
    }

    public void setYear(int year){
        this.year = year;
    }

    public String getBrand() {
        return this.brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Date getAcquisitionDate() {
        return acquisitionDate;
    }

    public void setAcquisitionDate(Date acquisitionDate) {
        this.acquisitionDate = acquisitionDate;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getNote(){
        return note;
    }

    public void setNote(String note){
        this.note = note;
    }

    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    public boolean isFoilCompatible(){
        return category == Category.FOIL?true:false;
    }

    //Methods-----------------------------------------------------------------------------------------------------------
    @Override
    public String toString() {
        return "year:"+year+";brand:"+brand+";discipline:"+discipline+";date:"+acquisitionDate+";category:"+category+";";
    }

}