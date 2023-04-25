package Windsurf.Foil;

import Windsurf.Equipement;

public class Wing extends Equipement {
    //Variables---------------------------------------------------------------------------------------------------------
    private int area;
    private Foil.MaterialType materialType;
    private WingType wingType;

    @Override
    public Object[] toObject() {
        return new Object[0];
    }

    public enum WingType{
        FRONT_WING,
        BACK_WING
    }

    //Constructors------------------------------------------------------------------------------------------------------
    public Wing(int area, Foil.MaterialType materialType, WingType wingType) {
        super();
        this.area = area;
        this.materialType = materialType;
        this.wingType = wingType;
    }

    public Wing(int area, WingType wingType){
        this(area, Foil.MaterialType.CARBON, wingType);
    }

    //Getters and Setters-----------------------------------------------------------------------------------------------
    public WingType getWingType() {
        return wingType;
    }

    public void setWingType(WingType wingType) {
        this.wingType = wingType;
    }

    public Foil.MaterialType getMaterialType() {
        return materialType;
    }

    public void setMaterialType(Foil.MaterialType materialType) {
        this.materialType = materialType;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }



}
