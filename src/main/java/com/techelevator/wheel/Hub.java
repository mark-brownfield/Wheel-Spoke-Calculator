package com.techelevator.wheel;

public class Hub {
    private double hubFlangePCD;
    private int spokeCountHub;
    private boolean isDisc;
    private double flangeOffSetDrive;
    private double flangeOffSetNonDrive;
    private boolean isJBend;

    public Hub(double hubFlangePCD, int spokeCountHub, boolean isDisc,
               double flangeOffSetDrive, double flangeOffSetNonDrive, boolean isJBend) {
        this.hubFlangePCD = hubFlangePCD;
        this.spokeCountHub = spokeCountHub;
        this.isDisc = isDisc;
        this.flangeOffSetDrive = flangeOffSetDrive;
        this.flangeOffSetNonDrive = flangeOffSetNonDrive;
        this.isJBend = isJBend;
    }

    public double getHubFlangePCD() {
        return hubFlangePCD;
    }

    public void setHubFlangePCD(int hubFlangePCD) {
        this.hubFlangePCD = hubFlangePCD;
    }

    public int getSpokeCountHub() {
        return spokeCountHub;
    }

    public void setSpokeCountHub(int spokeCountHub) {
        this.spokeCountHub = spokeCountHub;
    }

    public boolean isDisc() {
        return isDisc;
    }

    public void setDisc(boolean disc) {
        isDisc = disc;
    }

    public double getFlangeOffSetDrive() {
        return flangeOffSetDrive;
    }

    public void setFlangeOffSetDrive(int flangeOffSetDrive) {
        this.flangeOffSetDrive = flangeOffSetDrive;
    }

    public double getFlangeOffSetNonDrive() {
        return flangeOffSetNonDrive;
    }

    public void setFlangeOffSetNonDrive(int flangeOffSetNonDrive) {
        this.flangeOffSetNonDrive = flangeOffSetNonDrive;
    }

    public boolean isJBend() {
        return isJBend;
    }

    public void setJBend(boolean JBend) {
        isJBend = JBend;
    }
}
