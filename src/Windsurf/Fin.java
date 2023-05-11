package Windsurf;

public class Fin extends Equipment {
    //Variables---------------------------------------------------------------------------------------------------------
    private int size;


    public enum BoxType {
        POWER_BOX,
        TUTTLE,
        DEEP_TUTTLE
    }

    private BoxType box_type;
    private String model;
    private boolean anti_algae;

    //Constructors------------------------------------------------------------------------------------------------------
    public Fin(int size, BoxType boxType, boolean antiAlgae) {
        super();
        this.size = size;
        box_type = boxType;
        anti_algae = antiAlgae;
    }

    public Fin(int size, BoxType boxType) {
        this(size, boxType, false);
    }

    public Fin() {
        this(0, BoxType.DEEP_TUTTLE, false);
    }

    public Fin(int year, String brand){
        super(year, brand, Category.PLANCHE, Discipline.SLALOM);
    }

    //Getters and Setters-----------------------------------------------------------------------------------------------
    public BoxType getBox_type() {
        return box_type;
    }

    public void setBox_type(BoxType box_type) {
        this.box_type = box_type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isAnti_algae() {
        return anti_algae;
    }

    public void setAnti_algae(boolean anti_algae) {
        this.anti_algae = anti_algae;
    }
}