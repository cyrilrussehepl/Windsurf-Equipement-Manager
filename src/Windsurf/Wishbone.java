package Windsurf;

public class Wishbone extends Equipment {
    //Variables---------------------------------------------------------------------------------------------------------
    private int[] size = new int[2];
    private int carbonPercent;

    //Constructors------------------------------------------------------------------------------------------------------
    public Wishbone(int min, int max, int carbonPercent) {
        super();
        this.carbonPercent = carbonPercent;
        this.size[0] = min;
        this.size[1] = max;
    }

    public Wishbone() {
        this(0, 0, 0);
    }

    public Wishbone(int year, String brand) {
        super(year, brand, Category.BOTH, Discipline.SLALOM);
    }

    //Getters and Setters-----------------------------------------------------------------------------------------------
    public int getSizeMin() {
        return this.size[0];
    }

    public void setSizeMin(int newMin) {
        this.size[0] = newMin;
    }

    public int getSizeMax() {
        return size[1];
    }

    public void setSizeMax(int newMax) {
        this.size[1] = newMax;
    }

    public int getCarbonPercent() {
        return carbonPercent;
    }

    public void setCarbonPercent(int carbonPercent) {
        this.carbonPercent = carbonPercent;
    }
}