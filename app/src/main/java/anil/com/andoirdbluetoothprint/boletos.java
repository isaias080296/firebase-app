package anil.com.andoirdbluetoothprint;

public class boletos {

    private String datel;
    private int pequeño;
    private int grande;
    private String transporteweb;
    private int total;

    public boletos(String datel, int pequeño, int grande, String transporteweb, int total) {

        this.datel=datel;
        this.pequeño=pequeño;
        this.grande=grande;
        this.transporteweb=transporteweb;
        this.total=total;
    }

    public String getDatel() {
        return datel;
    }

    public void setDatel(String datel) {
        this.datel = datel;
    }

    public int getPequeño() {
        return pequeño;
    }

    public void setPequeño(int pequeño) {
        this.pequeño = pequeño;
    }

    public int getGrande() {
        return grande;
    }

    public void setGrande(int grande) {
        this.grande = grande;
    }

    public String getTransporteweb() {
        return transporteweb;
    }

    public void setTransporteweb(String transporteweb) {
        this.transporteweb = transporteweb;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}
