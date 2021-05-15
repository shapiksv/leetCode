package ru.shapik.leet_code.easy;

public class DesignParkingSystem {
    class ParkingSystem {
        int [] big;
        public ParkingSystem(int big, int medium, int small) {
            this.big = new int[4];
            this.big[1] = big;
            this.big[2] = medium;
            this.big[3] = small;
        }

        public boolean addCar(int carType) {
            int type = big[carType];
            if ( type != 0) {
                type --;
                big[carType] = type;
                return true;
            } else return false;
        }
    }

}
