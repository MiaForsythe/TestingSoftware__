import Planes.ExperimentalPlane;
import models.MilitaryType;
import Planes.MilitaryPlane;
import Planes.PassengerPlane;
import Planes.Plane;

import java.util.*;
import java.util.stream.Collectors;

// version: 1.1
// made by Vitali Shulha
// 4-Jan-2019

public class Airport {
    private List<? extends Plane> planes;

    //getPasPl()-->getPassengersPlanes()

    public List<PassengerPlane> getPassengersPlanes() {

        // List<? extends Plane> l = this.planes;
        // List<PassengerPlane> x = new ArrayList<>();
        // for (Plane p : l) {if (p instanceof PassengerPlane) {x.add((PassengerPlane) p);}}
        // return x;

        return planes
        .stream()
        .filter(plane -> plane instanceof PassengerPlane)
        .map(plane -> (PassengerPlane) plane)
        .collect(Collectors.toList());
    }

    public List<MilitaryPlane> getMilitaryPlanes() {

        // List<MilitaryPlane> militaryPlanes = new ArrayList<>();
        // for (Plane plane : planes) {
        //     if (plane instanceof MilitaryPlane) {
        //         militaryPlanes.add((MilitaryPlane) plane);
        //     } //if
        //     else {

        //     } // else
        // } //for
        // return militaryPlanes;

        return planes
        .stream()
        .filter(plane -> plane instanceof MilitaryPlane)
        .map(plane -> (MilitaryPlane) plane)
        .collect(Collectors.toList());
    }

    public PassengerPlane getPassengerPlaneWithMaxPassengersCapacity() {
        
        // List<PassengerPlane> passengerPlanes = getPasPl();
        // PassengerPlane planeWithMaxCapacity = passengerPlanes.get(0);
        // for (int i = 0; i < passengerPlanes.size(); i++) {
        //     if (passengerPlanes.get(i).getPassengersCapacity() > planeWithMaxCapacity.getPassengersCapacity()) {
        //         planeWithMaxCapacity = passengerPlanes.get(i);
        //     }
        // }
        // return planeWithMaxCapacity;

        return this
        .getPassengersPlanes()
        .stream()
        .max(Comparator.comparingInt(PassengerPlane::getCapacity))
        .get();
    }

    public List<MilitaryPlane> getTransportMilitaryPlanes() {
    
        // List<MilitaryPlane> transportMilitaryPlanes = new ArrayList<>();
    // List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
    // for (int i = 0; i < militaryPlanes.size(); i++) {
    // MilitaryPlane plane = militaryPlanes.get(i);
    // if (plane.getType() == MilitaryType.TRANSPORT) {
    // transportMilitaryPlanes.add(plane);
    // }
    // }
    // return transportMilitaryPlanes;

    return this
    .getMilitaryPlanes()
    .stream()
    .filter(militaryPlane -> militaryPlane.getType() == MilitaryType.TRANSPORT)
    .collect(Collectors.toList());
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {

        // List<MilitaryPlane> bomberMilitaryPlanes = new ArrayList<>();
        // List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
        // for (int i = 0; i < militaryPlanes.size(); i++) {
        //     MilitaryPlane plane = militaryPlanes.get(i);
        //     if (plane.getType() == MilitaryType.BOMBER) {
        //         bomberMilitaryPlanes.add(plane);
        //     }
        // }
        // return bomberMilitaryPlanes;

        return this
        .getMilitaryPlanes()
        .stream()
        .filter(militaryPlane -> militaryPlane.getType() == MilitaryType.BOMBER)
        .collect(Collectors.toList());
    }

    //List<experimentalPlane>-->List<ExperimentalPlane>
    
    public List<ExperimentalPlane> getExperimentalPlanes() {
        
        // List<experimentalPlane> experimentalPlanes = new ArrayList<>();
        // for (Plane plane : planes) {
        //     if (plane instanceof experimentalPlane) {
        //         experimentalPlanes.add((experimentalPlane) plane);
        //     }
        // }
        // return experimentalPlanes;

        return planes
        .stream()
        .filter(plane -> plane instanceof ExperimentalPlane)
        .map(plane -> (ExperimentalPlane) plane)
        .collect(Collectors.toList());
    }

    public Airport sortByMaxDistance() {
        Collections.sort(planes, new Comparator<Plane>() {
            public int compare(Plane o1, Plane o2) {
                return o1.getMaxFlightDistance() - o2.getMaxFlightDistance();
            }
        });
        return this;
    }


    /**
     * Sorts by max speed
     * @return Airport
     */
    public Airport sortByMaxSpeed() {
        Collections.sort(planes, new Comparator<Plane>() {
            public int compare(Plane o1, Plane o2) {
                return o1.getMaxSpeed() - o2.getMaxSpeed();
            }
        });
        return this;
    }

    public Airport sortByMaxLoadCapacity() {
        Collections.sort(planes, new Comparator<Plane>() {
            public int compare(Plane o1, Plane o2) {
                return o1.getMinLoadCapacity() - o2.getMinLoadCapacity();
            }
        });
        return this;
    }

    public List<? extends Plane> getPlanes() {
        return planes;
    }

    private void print(Collection<? extends Plane> collection) {
        Iterator<? extends Plane> iterator = collection.iterator();
        while (iterator.hasNext()) {
            Plane plane = iterator.next();
            System.out.println(plane);
        }
    }

    @Override
    public String toString() {
        return "Airport{" +
                "Planes=" + planes.toString() +
                '}';
    }

    //Constructor
    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }

}
