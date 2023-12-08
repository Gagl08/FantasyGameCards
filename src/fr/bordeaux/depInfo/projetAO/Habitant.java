package fr.bordeaux.depInfo.projetAO;

public class Habitant implements Habitant_Inteface {
    private boolean work;

    public Habitant() {
        this.work = false;
    }

    @Override
    public void update(Building_Interface building) {
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