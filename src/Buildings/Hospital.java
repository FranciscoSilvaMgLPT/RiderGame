package Buildings;
import Body.BodyPart;

public class Hospital {
    private String name = "HOSPITAL";
    public String getName() {
        return name;
    }

    public void cure(BodyPart bodyPart){
        bodyPart.setHealthy(true);
    }
}
