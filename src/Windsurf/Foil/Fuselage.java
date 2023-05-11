package Windsurf.Foil;

import Windsurf.Equipment;

public class Fuselage extends Equipment {
    //Variables---------------------------------------------------------------------------------------------------------
    private int size;
    private Foil.MaterialType materialType;
    private String model;

    //Constructors------------------------------------------------------------------------------------------------------
    public Fuselage(int size, Foil.MaterialType materialType, String model) {
        super();
        this.size = size;
        this.materialType = materialType;
        this.model = model;
    }

    public Fuselage(int size){
        this(size, Foil.MaterialType.ALUMINIUM, null);
    }

    //Getters and Setters-----------------------------------------------------------------------------------------------
    public Foil.MaterialType getMaterialType() {
        return materialType;
    }

    public void setMaterialType(Foil.MaterialType materialType) {
        this.materialType = materialType;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

}
