package org.lasencinas;

import java.util.EnumSet;

public enum Planeta {

    MERCURY (3.303e+23, 2.4397e6),
    VENUS   (4.869e+24, 6.0518e6),
    EARTH   (5.976e+24, 6.37814e6),
    MARS    (6.421e+23, 3.3972e6),
    JUPITER (1.9e+27,   7.1492e7),
    SATURN  (5.688e+26, 6.0268e7),
    URANUS  (8.686e+25, 2.5559e7),
    NEPTUNE (1.024e+26, 2.4746e7);

    private double MASA = 0;
    private double RADIO = 0;
    private final double G = 6.67300E-11;

    Planeta(double MASA, double RADIO) {
        this.MASA = MASA;
        this.RADIO = RADIO;
    }

    public double getMASA() {
        return MASA;
    }

    public double getRADIO() {
        return RADIO;
    }

    /*----------------------------------------Logica-------------------------------------------*/


    public double getMasa(){
        return this.getMASA();
    }

    public double getRadio() {
        return this.getRADIO();
    }

    public double pesoSuperficie(double pesoHumano) {
        return masaHumano(pesoHumano) * this.gravedadPlaneta();
    }

    public double gravedadPlaneta() {
        return G * this.getMASA() / Math.pow(this.getRADIO(),2);
    }

    public double masaHumano(double pesoHumano) {
        return pesoHumano / EARTH.gravedadPlaneta();
    }

    public static EnumSet<Planeta> getPlanetasTerrestres() {
        return EnumSet.range(MERCURY, MARS);
    }

    public static EnumSet<Planeta> getGigantesGaseosos() {
        return EnumSet.complementOf(getPlanetasTerrestres());
    }
}
