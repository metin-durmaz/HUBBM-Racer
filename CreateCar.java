import javafx.scene.control.Label;
import javafx.scene.image.*;
import java.util.*;
public class CreateCar {
    private ArrayList<ImageView> yellowCar=new ArrayList<ImageView>();
    private ImageView whiteCar;
    private Image orangeCar;
    private Image grayCar;
    private Image tempYellowCar;
    private Image tempWhiteCar;
    public CreateCar(){
        this.whiteCar=new ImageView("whiteCar.png");
        this.orangeCar=new Image("orangeCar.png");
        this.grayCar=new Image("grayCar.png");
        this.tempYellowCar=new Image("yellowCar.png");
        this.tempWhiteCar=new Image("whiteCar.png");
        for(int i=0;i<5;i++)
            this.yellowCar.add(new ImageView("yellowCar.png"));
        
    }
    public ArrayList<ImageView> getYellowCar() {
        return this.yellowCar;
    }
    public Image getGrayCar() {
        return this.grayCar;
    }
    public Image getOrangeCar() {
        return this.orangeCar;
    }
    public Image getTempWhiteCar() {
        return this.tempWhiteCar;
    }
    public Image getTempYellowCar() {
        return this.tempYellowCar;
    }
    public ImageView getWhiteCar() {
        return this.whiteCar;
    }
    public void yellowCarEditer(ImageView yellowCar,Image tempYellowCar,Image orangeCar,Label table){
        yellowCar.setLayoutY(yellowCar.getLayoutY()+Assignment4.velocity);
        if(yellowCar.getLayoutY()>510)
            yellowCar.setImage(orangeCar);
        if(yellowCar.getLayoutY()>600){
            Assignment4.scoreCalculator+=Assignment4.levelCalculator;
            Assignment4.levelCounter++;
            if(Assignment4.levelCounter==5){
                Assignment4.levelCalculator++;
                Assignment4.levelCounter=0;
            }
            table.setText("Score\n"+String.valueOf(Assignment4.scoreCalculator)+"\nLevel\n"+String.valueOf(Assignment4.levelCalculator));
            yellowCar.setImage(tempYellowCar);
            yellowCar.setLayoutX(new Random().nextInt(270)+72);
            yellowCar.setLayoutY(-65);
        }
    }
    public void carPositionEditer(ImageView car,String carName,int layoutY,Image tempCar){
        car.setImage(tempCar);
        if(carName.equals("whiteCar")){
            car.setLayoutX(210);
            car.setLayoutY(520);
        }
        else if(carName.equals("yellowCar")){
            car.setLayoutX(new Random().nextInt(270)+72);
            car.setLayoutY(layoutY-new Random().nextInt(60));
        }
    }
}