import java.util.*;

public class Crew {
    ArrayList<CrewMember> crewList = new ArrayList<CrewMember>();
    UserInterface ui = new UserInterface();
    Scanner keyboard = new Scanner(System.in);
    //int[] crewMakeUp = {0, 0, 0, 0, 1}; // engr, sci, comm, pilot, capt

    public void addCaptain(){
        ui.print("Hello, welcome to Star Command. What is your name? ");
        crewList.add(new CrewMember(keyboard.next(), CrewMember.CrewMemberOccupation.CAPTAIN));
    }

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
        return (crewList.size());
    }

    public void printCrewList(){
        ui.println("The following people are in your crew.\n");
        for (CrewMember i : crewList) {
            ui.println("Name: " + i.getName() + "  Occupation: " + i.getOccupation() + "   Health: " + i.getHealth());
        }
        ui.pressEnter();
    }

    public boolean doesCrewHaveCommOfficer(){
        boolean foundCommOfficer = false;
        for (CrewMember i : crewList) {
            if (i.occupation == CrewMember.CrewMemberOccupation.COMMUNICATIONS_OFFICER) {
                foundCommOfficer = true;
            }
        }
        return foundCommOfficer;
    }
    public boolean doesCrewHaveEngineer(){
        boolean foundEngineer = false;
        for (CrewMember i : crewList) {
            if (i.occupation == CrewMember.CrewMemberOccupation.ENGINEER) {
                foundEngineer = true;
            }
        }
        return foundEngineer;
    }

    public void fireCrewMember(){
        ui.clear();
        ui.println("Here's your current crew:");
        int j = 1;
        for (CrewMember i : crewList) {
            ui.println(j++ + ".  " + i.getName());
        }
        ui.print("Who would you like to fire? ");
        int firedMember = keyboard.nextInt();
        crewList.remove(firedMember - 1);
    }

    public String getOverallCrewHealth(){
        int count=0;
        for (CrewMember i : crewList) {
            if ("Good".equalsIgnoreCase(i.getHealth())) {
                count++;
            } else if ("Poor".equalsIgnoreCase(i.getHealth())) {
                count--;
            }
        }
        if (count > (2 * crewList.size() / 3)) {
            return "Good";
        } else if (count > (2 * crewList.size() / 5)) {
            return "Fair";
        } else {
            return "Poor";
        }
    }
}
