package anil.com.andoirdbluetoothprint.model;

public class boleto {

    private String fecha;
    private int Adulto;
    private int Nino;
    private String transporte;

    public boleto() {
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getAdulto() {
        return Adulto;
    }

    public void setAdulto(int adulto) {
        Adulto = adulto;
    }

    public int getNino() {
        return Nino;
    }

    public void setNino(int nino) {
        Nino = nino;
    }

    public String getTransporte() {
        return transporte;
    }

    public void setTransporte(String transporte) {
        this.transporte = transporte;
    }
}
