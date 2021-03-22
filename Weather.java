import java.util.*;
public class Weather {
    UserInterface ui = new UserInterface();
    rainState currentRainState;
    windState currentWindState;
    Random rand = new Random();

    enum rainState {
        CLEAR,
        LIGHT_RAIN,
        THUNDERSTORM,
        HAIL
    }
    enum windState {
        CALM,
        LIGHT_BREEZE,
        GUSTY
    }
    public Weather() {
        rollWeatherConditions();
    }
    public String getRainState(){
        return currentRainState.toString();
    }
    public String getWindState(){
        return currentWindState.toString();
    }
    public void printCurrentWeatherForecast(){
        ui.println("Today's weather forecast is:\n\nRain: " + currentRainState + "\nWind: " + currentWindState);
    }

    public void rollWeatherConditions(){
        createRainState();
        createWindState();
    }
    public void createRainState() {
        int diceRoll = rand.nextInt(100);
        // Roll dice for rain chance
        if (diceRoll > 89) {
            currentRainState = rainState.HAIL;
        } else if (diceRoll > 65) {
            currentRainState = rainState.THUNDERSTORM;
        } else if (diceRoll < 20) {
            currentRainState = rainState.LIGHT_RAIN;
        } else {
            currentRainState = rainState.CLEAR;
        }
    }
    public void createWindState(){
        int diceRoll = rand.nextInt(100);
        // Roll dice for wind chance
        if (diceRoll > 89) {
            currentWindState = windState.GUSTY;
        } else if (diceRoll < 30) {
            currentWindState = windState.LIGHT_BREEZE;
        } else {
            currentWindState = windState.CALM;
        }
    }
    public boolean isLaunchSuccessful(){
        if (currentRainState == rainState.HAIL || currentRainState == rainState.THUNDERSTORM || currentWindState == windState.GUSTY) {
            return false;
        } else if (currentRainState == rainState.THUNDERSTORM) {
            return false;
        } else if (currentRainState == rainState.LIGHT_RAIN || currentWindState != windState.CALM) {
            return false;
        } else if (currentWindState == windState.LIGHT_BREEZE && currentRainState != rainState.CLEAR) {
            return false;
        } else {
            return true;
        }
    }
}
