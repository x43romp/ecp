___20SP Advanced Java (CS-2463-TC02S)___
# Environmental Control Program
![ecp logo](/docs/logo.png)

## How to Run
```shell
$> mvn install
$> mvn clean javafx:run
```

## Group Members
- Tayvon Lewis
- John Untivero
- Adam Phillips

## About this project
The Environmental Control Program is meant to regulate temperature per room within a structure using thermometers in each room to regulate temperature autonomously. Ideally, a building that meets temperature equilibrium will not have “hot” and “cold” areas, but will have evenly adjusted temperatures. Global positioning of homes and buildings, especially those with windows in rooms or offices, can get far too warm or cool, but an initial thermostat reading from one location does not register the change in each area that has ventilation. The ECP will receive temperature data and close vents in order to prevent further heating or cooling based on the temperature of that room. Once the room has met its desired temperature, the ventilation will reopen in that room to allow normal heating and cooling procedures. The thermostat readings will be sub-classes that report to the parent class which is the ventilation control system. The heating/cooling unit itself will not change it’s output, allowing closed vent tubing to cycle that heat or air back toward areas that still have open vents, warming or cooling them in less time, turning off the unit and saving energy costs.

## Extended Proposal
The Environmental Control Program is meant to regulate temperature per room within a structure using thermometers in each room to regulate temperature autonomously. Ideally, a building that meets temperature equilibrium will not have “hot” and “cold” areas, but will have evenly adjusted temperatures. There are three phases to temperature control within a structure. For the purpose of this example, we will identify the structure as “ThermoHouse”. 

### Interface
Here are teo screenshots from our application

The top port, users are able to set the desired temperature for their house, _ThermoHouse_. 

The bottom part shows the status of different rooms _ThermoRoom_. The _ThermoRoom_ class tracks the room's temperature and determines whether the airvents in that room should be on (open) or off (closed) based on the desired house temperature.

The screenshot below show two rooms with the __HEATER__ turned on. The Office which is under the desired temperature, will have it's airvents opened, while the Guest Room will have its airvents off. The office's temperature will gradually incresae every hour while the Guest Room will stay the same. When there is no more rooms under the desired temperature, the heater is turned off. If there are rooms over the desired temperature, at this point the AC will turn on; so the Office vents will be closed and the Guest Room's vents will open.

![ScreenshotUnder](/docs/screenshot-under.png) ![ScreenshotOver](/docs/screenshot-over.png)



### Phase One - number of rooms
The first phase is to set the ThermoHouse program to the number of rooms that would require temperature control. The program must know how many rooms are going to be monitored and maintained(image1). Additional data includes the geographical location(image2) of each room to account for east/west facing windows that may add to the temperature and give those rooms slightly less “Attention”, as they will be receiving sunlight as an additional heat source. 

[ThermoHouse.java source](https://github.com/x43romp/CS2463/blob/develop/src/main/java/edu/occc/ecp/ThermoHouse.java)
<!-- ![phase1 image](/docs/image01.png) -->

### Phase Two - initial room temperatures
The second phase of the ECP will introduce ideal temperature settings for each room within the program. This is no different than a normal setting a user would determine for their own comfort through their thermostat. Once that ideal temperature is received, that ideal setting is stored and constantly monitored(image3). 
<!-- ![phase2 image](/docs/image02.png) -->

### Phase Three - simulation
The third phase of the program uses the “Main” program of ThermoHouse for each room to receive temperature data in order to know when to close vents to prevent further heating or cooling based on the temperature of that room. Once the room has met its desired temperature, the ventilation will reopen in that room to allow normal heating and cooling procedures. The thermostat readings will be sub-classes that report to the parent class which is the ventilation control system. The heating/cooling unit itself will not change it’s output, allowing closed vent tubing to cycle that heat or air back toward areas that still have open vents, warming or cooling them in less time, turning off the unit at erarlier intervals and saving energy costs with the unit running for less time.
<!-- ![phase3 image](/docs/image03.png) -->
