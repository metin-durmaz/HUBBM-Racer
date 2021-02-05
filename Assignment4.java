import java.util.*;
import javafx.animation.*;
import javafx.application.*;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.stage.*;
public class Assignment4 extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    static int startGame=0;
    static double velocity=0;
    static int levelCalculator=1;
    static int levelCounter=0;
    static int scoreCalculator=0;
    @Override
    public void start(Stage stage) throws Exception {
        CreateShape shapes=new CreateShape();
        CreateCar cars=new CreateCar();
        CreateText texts=new CreateText();
        CreateLand lands=new CreateLand();
        Group root=new Group();
        Scene scene=new Scene(root,450,600);
        ArrayList<String> input=new ArrayList<String>();
        AnimationTimer timer=new AnimationTimer(){
            @Override
            public void handle(long now) {
                lands.getLineStreet().setStrokeDashOffset(lands.getLineStreet().getStrokeDashOffset()-velocity);
                if(input.contains("LEFT")&&!cars.getWhiteCar().getBoundsInParent().intersects(lands.getLeftRoadSide().getBoundsInParent()))
                    cars.getWhiteCar().setLayoutX(cars.getWhiteCar().getLayoutX()-3.25);
                if(input.contains("RIGHT")&&!cars.getWhiteCar().getBoundsInParent().intersects(lands.getRightRoadSide().getBoundsInParent()))
                    cars.getWhiteCar().setLayoutX(cars.getWhiteCar().getLayoutX()+3.25);
                if(input.contains("UP"))
                    if(velocity<7.8+levelCalculator/12)
                        velocity+=0.05;
                if(!input.contains("UP"))
                    if(velocity>0.1+levelCalculator/12)
                        velocity-=0.07;
                for(int i=0;i<5;i++)
                    cars.yellowCarEditer(cars.getYellowCar().get(i),cars.getTempYellowCar(),cars.getOrangeCar(),texts.getTable());
                for(int i=0;i<10;i++)
                    if(i<5)
                        shapes.shapePositionEditer(shapes.getShape().get(i),0);
                    else
                        shapes.shapePositionEditer(shapes.getShape().get(i),390);
                
                for(int i=0;i<5;i++){
                    if(cars.getWhiteCar().getBoundsInParent().intersects(cars.getYellowCar().get(i).getBoundsInParent())&&
                        !cars.getYellowCar().get(i).getImage().equals(cars.getOrangeCar())){
                        cars.getWhiteCar().setImage(cars.getGrayCar());
                        cars.getYellowCar().get(i).setImage(cars.getGrayCar());
                        this.stop();
                        startGame=0;
                        root.getChildren().clear();
                        texts.getGameOver().setText("        GAME OVER!\n        Your Score: "+scoreCalculator+"\n\nPress ENTER to restart!");
                        root.getChildren().addAll(lands.getLeftRoadSide(),lands.getRightRoadSide());
                        for(int j=0;j<10;j++)
                            root.getChildren().add(shapes.getShape().get(j));
                        root.getChildren().addAll(texts.getTable(),lands.getRoad(),lands.getLineStreet());
                        for(int j=0;j<5;j++)
                            root.getChildren().add(cars.getYellowCar().get(j));
                        root.getChildren().addAll(cars.getWhiteCar(),texts.getGameOver());               
                    }
                }
            }
        };
        scene.setOnKeyPressed(event->{
            String code=event.getCode().toString();
            if(code.equals("ENTER") && startGame==0){
                velocity=0;
                scoreCalculator=0;
                levelCalculator=1;
                texts.getTable().setText("Score\n"+String.valueOf(scoreCalculator)+"\nLevel\n"+String.valueOf(levelCalculator));
                cars.carPositionEditer(cars.getWhiteCar(), "whiteCar", 0, cars.getTempWhiteCar());
                for(int i=0,j=400;i<5;i++,j-=130)
                    cars.carPositionEditer(cars.getYellowCar().get(i), "yellowCar",j, cars.getTempYellowCar());
                for(int i=0,j=0;i<10;i++,j+=130)
                    if(i<5)    
                        shapes.shapeInit(shapes.getShape().get(i),0,j);
                    else
                        shapes.shapeInit(shapes.getShape().get(i),390,j-550);
                root.getChildren().clear();
                root.getChildren().addAll(lands.getLeftRoadSide(),lands.getRightRoadSide());
                for(int i=0;i<10;i++)
                    root.getChildren().add(shapes.getShape().get(i));
                root.getChildren().addAll(texts.getTable(),lands.getRoad(),lands.getLineStreet());
                for(int i=0;i<5;i++)
                    root.getChildren().add(cars.getYellowCar().get(i));
                root.getChildren().add(cars.getWhiteCar());
                timer.start();
                startGame=1;
            }    
            else if(!input.contains(code))
                input.add(code);
        });
        scene.setOnKeyReleased(event->{
            String code=event.getCode().toString();
            input.remove(code);
        }); 
        root.getChildren().add(new ImageView("startScene.png"));
        stage.setTitle("HUBBM-Racer");
		stage.getIcons().add(new Image("file:icon.png"));
        stage.setScene(scene);
        stage.show();
    }
}