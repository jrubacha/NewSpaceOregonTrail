public  class CrewMember {
    private String name;
    CrewMemberHealth health;
    CrewMemberOccupation occupation;
    enum CrewMemberHealth {
        POOR,
        FAIR,
        GOOD
    }
    enum CrewMemberOccupation {
        ENGINEER,
        SCIENTIST,
        COMMUNICATIONS_OFFICER,
        PILOT,
        CAPTAIN
    }

    public CrewMember(String name, CrewMemberOccupation occupation) {
        this.name = name;
        this.health = CrewMemberHealth.GOOD;
        this.occupation = occupation;
    }

    public String getOccupation(){
        return occupation.toString();
    }
    public String getHealth() {
        return health.toString();
    }
    public String getName() {
        return name;
    }
    public void setHealthToPoor(){
        health = CrewMemberHealth.POOR;
    }
    public void setHealthToFair(){
        health = CrewMemberHealth.FAIR;
    }
    public void setHealthToGood(){
        health = CrewMemberHealth.GOOD;
    }
    //public
}
