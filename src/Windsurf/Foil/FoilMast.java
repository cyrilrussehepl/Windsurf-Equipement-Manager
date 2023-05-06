package Windsurf.Foil;

import Windsurf.Equipement;

public class FoilMast extends Equipement {
    //Variables---------------------------------------------------------------------------------------------------------
    private int size;
    private Foil.MaterialType materialType;

    //Constructors------------------------------------------------------------------------------------------------------
    public FoilMast(int size, Foil.MaterialType materialType) {
        super();
        this.size = size;
        this.materialType = materialType;
    }

    public FoilMast(int size){
        this(size, Foil.MaterialType.CARBON);
    }

    //Getters and Setters-----------------------------------------------------------------------------------------------
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Foil.MaterialType getMaterialType() {
        return materialType;
    }

    public void setMaterialType(Foil.MaterialType materialType) {
        this.materialType = materialType;
    }

}
