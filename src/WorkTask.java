class WorkTask implements ITask {
    private String popis;
    private int hodin;
    private String deadline;
    private int sazba;
    private int odpracovano;
    private boolean done;

    public WorkTask(String popis, int hodin, String deadline, int sazba) {
        this.popis = popis;
        this.hodin = hodin;
        this.deadline = deadline;
        this.sazba = sazba;
        this.odpracovano = 0;
        this.done = false;
    }

    @Override
    public void display() {
        System.out.println("Work Task: " + popis + ", Hours: " + hodin + ", Deadline: " + deadline + ", Rate: " + sazba + ", Done: " + done);
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