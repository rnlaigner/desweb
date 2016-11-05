package airlinesystem.view;

import airlinesystem.controller.AirlineSystemController;

public class MainProgram {
    public static void main(String[] args) {
		AirlineSystemController generalController = new AirlineSystemController();
		generalController.initLoginScreen();
    }
}
