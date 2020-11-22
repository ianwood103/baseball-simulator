import java.text.DecimalFormat;

public class Player {

    //Instantiating variables
    private int singles;
    private int doubles;
    private int triples;
    private int homers;
    private int walks;
    private int outs;
    private final DecimalFormat df = new DecimalFormat("#.000");

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
        switch (outcome) {
            case "single" -> this.singles++;
            case "double" -> this.doubles++;
            case "triple" -> this.triples++;
            case "homer" -> this.homers++;
            case "walk" -> this.walks++;
            case "out" -> this.outs++;
            default -> System.out.println("invalid type");
        }
    }

    //Statistic methods
    public String getOPS() {
        double value = Double.parseDouble(this.getOBP()) + Double.parseDouble(this.getSLG());
        return df.format(value);
    }

    public String getSLG() {
        double value = (double)(this.getTotalBases()) / (double)(this.getAtBats());
        return df.format(value);
    }

    public String getOBP() {
        double value = (double)(this.getTimesOnBase()) / (double)(this.getPlateAppearances());
        return df.format(value);
    }

    public String getAverage() {
        double value = (double)(getTotalHits()) / (double)(getAtBats());
        return df.format(value);
    }

    public int getAtBats() {
        return this.getPlateAppearances() - walks;
    }

    public int getPlateAppearances() {
        return singles + doubles + triples + homers + walks + outs;
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
