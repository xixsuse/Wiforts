package com.r.raul.tools.Inspector;

/**
 * Created by Rulo on 26/12/2015.
 */
public class Machine {

    String ip;
    String mac;
    String nombre;
    boolean conocido;
    boolean conectado;

    public Machine() {
    }

    public boolean isConocido() {
        return conocido;
    }

    public void setConocido(boolean conocido) {
        this.conocido = conocido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public boolean isConectado() {
        return conectado;
    }

    public void setConectado(boolean conectado) {
        this.conectado = conectado;
    }
}
