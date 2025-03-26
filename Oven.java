
import java.lang.classfile.Signature;

public class Oven {
    double temperature;
    String setting;
    boolean on;

    private Oven(double temp, String setting, boolean on) {
        this.temperature = temp;
        this.setting = setting;
        this.on = on;
    }

    public void setTemperature(double newTemp) {
        this.temperature = newTemp;
    }

    public void setSetting(String setting) {
        this.setting = setting;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public double getTemperature() {
        return this.temperature;
    }

    public String getSetting() {
        return this.setting;
    }

    public boolean getOn() {
        return this.on;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalize called for object temperature: " + temperature + ", setting:" + setting + " and current state: " + on);
        super.finalize();

    }

    public static void main(String[] args) throws Exception {
        Oven oven1 = new Oven(180.0, "Bake", true);
        Oven oven2 = new Oven(650.0, "Roast", false);

        if (oven1.getTemperature() > 450.0 || oven2.getTemperature() > 450.0) {
            throw new Exception("Temperature exceeds oven limit");
        }

        oven1 = null;
        oven2 = null;

        try {
           Thread.sleep(2000); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        } 
        
        System.gc();
    }

}




