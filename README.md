# Smart Home — Facade Pattern (Java 17)

`SmartHomeFacade` hides six subsystem classes (`Lights`, `Thermostat`, `Curtains`, `MusicSystem`, `DoorLock`, `SecuritySystem`) behind four methods: `arriveHome`, `leaveHome`, `startMovieNight`, `goodNight`.

## Structure
- `src/smarthome/subsystem` — subsystem classes (do not know about the Facade)
- `src/smarthome/facade` — `SmartHomeFacade`, `SmartHomeException`
- `src/smarthome/Main.java` — client, uses only the Facade

## Run
```
javac -d out $(find src -name "*.java")
java -cp out smarthome.Main
```
