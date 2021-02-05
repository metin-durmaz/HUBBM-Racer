import java.util.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
public class CreateShape {
    private ArrayList<Rectangle> shape=new ArrayList<Rectangle>();
    public CreateShape(){
        for(int i=0;i<10;i++)
            this.shape.add(new Rectangle());
    }
    public ArrayList<Rectangle> getShape() {
        return this.shape;
    }
    public void shapeInit(Rectangle shape,int x,int y){
        shape.setFill(Color.AQUA);
        shape.setRotate(new Random().nextInt());
        shape.setLayoutX(new Random().nextInt(50)+x);
        shape.setLayoutY(new Random().nextInt(50)+y);
        shape.setHeight(new Random().nextInt(20)+25);
        shape.setWidth(new Random().nextInt(20)+25);
    }
    public void shapePositionEditer(Rectangle shape,int x){
        shape.setLayoutY(shape.getLayoutY()+Assignment4.velocity);
        shape.setRotate(shape.getRotate()+Assignment4.velocity/10);
        if(shape.getLayoutY()>600){
            shape.setLayoutX(new Random().nextInt(50)+x);
            shape.setLayoutY(-100);
        }
    }
}