import java.util.*;

public class Crew {
    ArrayList<CrewMember> crewList = new ArrayList<CrewMember>();
    UserInterface ui = new UserInterface();
    Scanner keyboard = new Scanner(System.in);
    int[] crewMakeUp = {0, 0, 0, 0, 1}; // engr, sci, comm, pilot, capt

    public void assembleCrew(int maxCapacity) {
        hireCrewPrompt();
        int userSelc = keyboard.nextInt();
        while ((sumTotalOfCrew() < maxCapacity) || (userSelc != 5)) {
            switch (userSelc) {
                case 1:
                    ui.print("How many engineers would you like to hire? ");
                    for (int i=0; i<keyboard.nextInt(); i++) {
                        String newCrewName = keyboard.next();
                        crewList.add(new CrewMember(newCrewName, CrewMember.CrewMemberOccupation.ENGINEER));
                    }
                    break;
                case 2:
                    ui.print("How many scientists would you like to hire? ");
                    for (int i=0; i<keyboard.nextInt(); i++) {
                        String newCrewName = keyboard.next();
                        crewList.add(new CrewMember(newCrewName, CrewMember.CrewMemberOccupation.SCIENTIST));
                    }
                    break;
                default:
                    ui.println("Don't do that");
            }
        }
    }

    public void hireCrewPrompt(){
        ui.println("\nWho would you like to hire?\n1. Engineer\2. Scientist\n3. Communications Officer\n4. Pilot\n5. No more hires");
    }

    public int sumTotalOfCrew() {
        return Arrays.stream(crewMakeUp).sum();
    }
}
