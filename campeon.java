package gradle.wrapper;

public class campeon {
    private int id;
    private String Nombre;
    private int vida;
    private int daño;
    private String rol;
    private boolean ajustado;
    private String ajuste;
    private int itemsMasUsado;
    private int mejorBuff;


    public campeon(int id,String nombre,int vida,int daño,String rol,boolean ajustado,String ajuste,int itemsMasUsado,int mejorBuff){
        this.id=id;
        this.Nombre=nombre;
        this.vida=vida;
        this.daño=daño;
        this.rol=rol;
        this.ajustado=ajustado;
        this.ajuste=ajuste;
        this.itemsMasUsado=itemsMasUsado;
        this.mejorBuff=mejorBuff;
    }
    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return this.Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getVida() {
        return this.vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getDañO() {
        return this.daño;
    }

    public void setDañO(int daño) {
        this.daño = daño;
    }

    public String getRol() {
        return this.rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public boolean isAjustado() {
        return this.ajustado;
    }

    public void setAjustado(boolean ajustado) {
        this.ajustado = ajustado;
    }

    public String getAjuste() {
        return this.ajuste;
    }

    public void setAjuste(String ajuste) {
        this.ajuste = ajuste;
    }

    public int getItemsMasUsado() {
        return this.itemsMasUsado;
    }

    public void setItemsMasUsado(int itemsMasUsado) {
        this.itemsMasUsado = itemsMasUsado;
    }

    public int getMejorBuff() {
        return this.mejorBuff;
    }

    public void setMejorBuff(int mejorBuff) {
        this.mejorBuff = mejorBuff;
    }

}
