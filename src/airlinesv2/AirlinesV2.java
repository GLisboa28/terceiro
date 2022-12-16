/* Guilherme Lisboa
Assignment week 13
Airline Flight Schedule 
 */
package airlinesV2;

import java.util.HashMap;
import java.util.ArrayList;

public class FlightSchedule {

    ArrayList< Airline> airlines;
    HashMap< String, Flight> flightMap;

    // constructors
    public FlightSchedule() {
        airlines = new ArrayList< Airline>();
        flightMap = new HashMap< String, Flight>();
    }

    // operations
    public void addAirline(String airlineCode /*aircraft*/) {
        Airline air = new Airline(airlineCode);
        // Set aircraft info
        // air.setAircraft( aircraftModel );
        airlines.add(air);
    }

    public Flight addFlight(String airlineCode, int flightNumber) {
        Flight newFlight = null;
        if (isValidAirlineCode(airlineCode)) {
            String externalflightNumber = airlineCode + flightNumber;
            // "DL1234" -> flight:
            newFlight = new Flight(airlineCode, flightNumber);
            flightMap.put(
                    externalflightNumber, //DL1234
                    newFlight // Flight object
            );
        }
        return newFlight;
    }

    public boolean isValidAirlineCode(String airlineCode) {
        for (Airline airline : airlines) {
            //if ( 0 == airline.getCode().compareTo( airlineCode ) ) {
            //if ( 0 == airlineCode.compareTo( airline.getCode() ) ) {
            //if ( airlineCode.equals( airline.getCode() ) ) {
            if (airlineCode.equalsIgnoreCase(airline.getCode())) {
                return true;
            }
        }
        return false;
    }
}//isValidAirlineCode 
