import javafx.scene.paint.*;
import javafx.scene.shape.*;
public class CreateLand {
    private Line lineStreet;
    private Line leftRoadSide;
    private Line rightRoadSide;
    private Line road;
    public CreateLand(){
        this.lineStreet=new Line(225.5,0,225.5,650);
        this.leftRoadSide=new Line(35,0,35,600);
        this.rightRoadSide=new Line(415,0,415,600);
        this.road=new Line(225,0,225,600);
        this.lineStreet.setStrokeWidth(5);  
        this.lineStreet.getStrokeDashArray().addAll(40d,40d);
        this.lineStreet.setStrokeDashOffset(10);
        this.lineStreet.setStroke(Color.web("#FFF8FF"));
        this.leftRoadSide.setStroke(Color.web("#52CCCD"));
        this.rightRoadSide.setStroke(Color.web("#52CCCD"));
        this.leftRoadSide.setStrokeWidth(70);
        this.rightRoadSide.setStrokeWidth(70);
        this.road.setStroke(Color.web("#FD81B3"));
        this.road.setStrokeWidth(310);
    }
    public Line getLeftRoadSide() {
        return this.leftRoadSide;
    }
    public Line getLineStreet() {
        return this.lineStreet;
    }
    public Line getRightRoadSide() {
        return this.rightRoadSide;
    }
    public Line getRoad() {
        return this.road;
    }
}