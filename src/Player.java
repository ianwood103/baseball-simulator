public class Player {

    //Instantiating variables
    private int singles;
    private int doubles;
    private int triples;
    private int homers;
    private int walks;
    private int outs;

    //Constructor
    public Player() {
        singles = 0;
        doubles = 0;
        triples = 0;
        homers = 0;
        walks = 0;
        outs = 0;
    }

    public void add(String outcome) {
        if (outcome.equals("single")) {
            this.singles++;
        } else if (outcome.equals("double")) {
            this.doubles++;
        } else if (outcome.equals("triple")) {
            this.triples++;
        } else if (outcome.equals("homer")) {
            this.homers++;
        } else if (outcome.equals("walk")) {
            this.walks++;
        } else if (outcome.equals("out")) {
            this.outs++;
        } else {
            System.out.println("invalid type");
        }
    }

    //Methods
    public double getOPS() {
        return this.getOBP() + this.getSLG();
    }

    public int getAtBats() {
        return this.getPlateAppearances() - walks;
    }

    public int getPlateAppearances() {
        return singles + doubles + triples + homers + walks + outs;
    }

    public double getSLG() {
        double value = (double)(this.getTotalBases()) / (double)(this.getAtBats());
        return (double)Math.round(value * 1000d) / 1000d;
    }

    public double getOBP() {
        double value = (double)(this.getTimesOnBase()) / (double)(this.getPlateAppearances());
        return (double)Math.round(value * 1000d) / 1000d;
    }

    public double getAverage() {
        double value = (double)(getTotalHits()) / (double)(getAtBats());
        return (double)Math.round(value * 1000d) / 1000d;
    }

    public int getTotalBases() {
        return singles + (doubles * 2) + (triples * 3) + (homers * 4);
    }

    public int getTotalHits() {
        return this.getTimesOnBase() - walks;
    }

    public int getTimesOnBase() {
        return singles + doubles + triples + homers + walks;
    }

    //Getters and setters
    public int getSingles() {
        return singles;
    }

    public void setSingles(int singles) {
        this.singles = singles;
    }

    public int getDoubles() {
        return doubles;
    }

    public void setDoubles(int doubles) {
        this.doubles = doubles;
    }

    public int getTriples() {
        return triples;
    }

    public void setTriples(int triples) {
        this.triples = triples;
    }

    public int getHomers() {
        return homers;
    }

    public void setHomers(int homers) {
        this.homers = homers;
    }

    public int getWalks() {
        return walks;
    }

    public void setWalks(int walks) {
        this.walks = walks;
    }

    public int getOuts() {
        return outs;
    }

    public void setOuts(int outs) {
        this.outs = outs;
    }

    @Override
    public String toString() {
        return "Player{" +
                "singles=" + singles +
                ", doubles=" + doubles +
                ", triples=" + triples +
                ", homers=" + homers +
                ", walks=" + walks +
                ", outs=" + outs +
                '}';
    }
}
