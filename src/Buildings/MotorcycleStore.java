package Buildings;

import Items.MotoParts.Parts;
import Items.Motorcycle;
import java.util.ArrayList;
import java.util.Arrays;

public class MotorcycleStore {
    ArrayList<Parts> parts = new ArrayList<>();
    ArrayList<Motorcycle> motorcycles=new ArrayList<>(Arrays.asList(new Motorcycle("Yamaha",5,800),
            new Motorcycle("Honda",4,700),new Motorcycle("Suzuki",3,600),
            new Motorcycle("Kawasaki",4,700),new Motorcycle("Ducati",4,700),
            new Motorcycle("Saschs",2,500)));


}
