package anil.com.andoirdbluetoothprint;

public class encuesta {

    private String pr1;
    private String pr2;
    private String pr3;
    private String pr4;
    private String pr5;
    private String Estado;
    private String Acompañantes;
    private String Comentario;
    public encuesta(String pr1, String pr2, String pr3, String pr4, String pr5, String estado, String acompañantes,String comentario){
        this.pr1 = pr1;
        this.pr2 = pr2;
        this.pr3 = pr3;
        this.pr4 = pr4;
        this.pr5 = pr5;
        Estado = estado;
        Acompañantes = acompañantes;
        Comentario=comentario;
    }

    public String getPr1() {
        return pr1;
    }

    public void setPr1(String pr1) {
        this.pr1 = pr1;
    }

    public String getPr2() {
        return pr2;
    }

    public void setPr2(String pr2) {
        this.pr2 = pr2;
    }

    public String getPr3() {
        return pr3;
    }

    public void setPr3(String pr3) {
        this.pr3 = pr3;
    }

    public String getPr4() {
        return pr4;
    }

    public void setPr4(String pr4) {
        this.pr4 = pr4;
    }

    public String getPr5() {
        return pr5;
    }

    public void setPr5(String pr5) {
        this.pr5 = pr5;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String estado) {
        Estado = estado;
    }

    public String getAcompañantes() {
        return Acompañantes;
    }

    public void setAcompañantes(String acompañantes){
        Acompañantes= acompañantes;
    }


    public String getComentario() {
        return Comentario;
    }

    public void setComentario(String comentario){
        Comentario=comentario;
    }
}

