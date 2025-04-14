class StudyTask implements ITask {
    private String predmet;
    private int hodiny;
    private int odpracovano;
    private boolean done;

    public StudyTask(String predmet, int hodiny) {
        this.predmet = predmet;
        this.hodiny = hodiny;
        this.odpracovano = 0;
        this.done = false;
    }

    @Override
    public void display() {
        System.out.println("Study Task: " + predmet + ", Hours: " + hodiny + ", Done: " + done);
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
}