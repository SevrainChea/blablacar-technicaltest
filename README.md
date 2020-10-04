# BlaBlaCar Technical Test

This project is a technical test for the BlaBlaCar company. 

## Built With

* Java 11
* Gradle 6.6.1

## Known Issues

State machines work fine for one mower in the input file.
Problems with synchronizing several mowers using threads. Seems like once a thread aqcuires lock on the Lawn object, it only releases it after comleting all its moves...

## TODO / Going further

* Add some kind of validators to input file parser
* Connect a frontend on the WebApp
* Add the possibility to configure the simulation using frontend's UI
* Use WebSocket for real time display of the mowers' positions
