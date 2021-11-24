package service;

public class Echo {

    private String msg;

    public Echo() {
    }

    public Echo(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "Echo{" + "msg=" + msg + '}';
    }

}
