class PersonalTask implements ITask {
    private String popis;
    private int maxHodiny;
    private int odpracovano;
    private boolean done;

    public PersonalTask(String popis, int maxHodiny) {
        this.popis = popis;
        this.maxHodiny = maxHodiny;
        this.odpracovano = 0;
        this.done = false;
    }

    @Override
    public void display() {
        System.out.println("Personal Task: " + popis + ", Max Hours: " + maxHodiny + ", Done: " + done);
    }

    @Override
    public void update(int hours, boolean done) {
        this.odpracovano = hours;
        this.done = done;
    }

    @Override
    public int getOdpracovano() {
        return this.odpracovano;
    }

    @Override
    public boolean isDone() {
        return this.done;
    }

    public String getPopis() {
        return popis;
    }
}