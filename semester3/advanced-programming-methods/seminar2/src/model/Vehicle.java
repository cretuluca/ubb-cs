package model;

public interface Vehicle {
    public String getColor();
    public String getModel();
    public String getLicensePlate();

    @Override
    public boolean equals(Object obj);
}
