import java.util.*;

public class Crew {
    ArrayList<CrewMember> crewList = new ArrayList<CrewMember>();
    UserInterface ui = new UserInterface();
    Scanner keyboard = new Scanner(System.in);
    int[] crewMakeUp = {0, 0, 0, 0, 1}; // engr, sci, comm, pilot, capt

    public void assembleCrew(int maxCapacity) {
        int userSelc = 0;
        while ((sumTotalOfCrew() < maxCapacity) && (userSelc != 5)) {
            CrewMember.CrewMemberOccupation currentJob = CrewMember.CrewMemberOccupation.ENGINEER; // default to engr
            hireCrewPrompt();
            int remainingCapacity = maxCapacity - sumTotalOfCrew();
            userSelc = keyboard.nextInt();
            switch (userSelc) {
                case 1:
                    currentJob = CrewMember.CrewMemberOccupation.ENGINEER;
                    ui.print("How many engineers would you like to hire? ");
                    break;
                case 2:
                    currentJob = CrewMember.CrewMemberOccupation.SCIENTIST;    
                    ui.print("How many scientists would you like to hire? ");
                    break;
                case 3:
                    currentJob = CrewMember.CrewMemberOccupation.COMMUNICATIONS_OFFICER;
                    ui.print("How many communications officers would you like to hire? ");
                    break;
                case 4:
                    currentJob = CrewMember.CrewMemberOccupation.PILOT;
                    ui.print("How many pilots would you like to hire? ");
                    break;
                case 5:
                    ui.println("No hires, got it.");
                    break;
                default:
                    ui.println("Don't do that");
                    break;
            }
            
            if (userSelc !=5) {
                int numberOfCrewToAdd = keyboard.nextInt();
                if (numberOfCrewToAdd < 0 || numberOfCrewToAdd > remainingCapacity) {
                    ui.clear();
                    ui.println("I'm sorry, you can't hire that number. No hires were made.");
                } else {
                    ui.clear();
                    for (int i=0; i<numberOfCrewToAdd; i++) {
                        ui.print("What this crew member's name? ");
                        String newCrewName = keyboard.next();
                        crewList.add(new CrewMember(newCrewName, currentJob));
                    }
                }
            }
        }
    }

    public void hireCrewPrompt(){
        ui.clear();
        ui.println("\nWho would you like to hire?\n1. Engineer\n2. Scientist\n3. Communications Officer\n4. Pilot\n5. No more hires");
    }

    public int sumTotalOfCrew() {
        return (crewList.size() + 1);
    }

    public void printCrewList(){
        for (CrewMember i : crewList) {
            ui.println("Name: " + i.getName() + "  Occupation: " + i.getOccupation() + "   Health: " + i.getHealth());
        }
    }
}
