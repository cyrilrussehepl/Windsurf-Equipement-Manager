package Windsurf;

public class Board extends Equipement {
    //Variables---------------------------------------------------------------------------------------------------------
    private int volume;
    private int width;
    private String model;

    //Constructors------------------------------------------------------------------------------------------------------
    public Board(int volume, int width, String model) {
        super();
        this.volume = volume;
        this.width = width;
        this.model = model;
    }

    //Getters and Setters-----------------------------------------------------------------------------------------------
    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}