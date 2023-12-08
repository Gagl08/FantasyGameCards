package fr.bordeaux.depInfo.projetAO;

public class Habitant implements Habitant_Inteface {
    private boolean work;

    public Habitant() {
        this.work = false;
    }

    @Override
    public void update(Building building) {
        System.out.println("je travail");
        System.out.println(building.getNbWorkerNeeded()+ "/" +building.getNbWorkerActual());
        if (building.getNbWorkerNeeded() > building.getNbWorkerActual()) {
            this.work = true;
            building.setNbWorkerActual(building.getNbWorkerActual()+1);
            System.out.println(building.getNbWorkerActual());
        }
    }

    public boolean getWork() {
        return this.work;
    }
}