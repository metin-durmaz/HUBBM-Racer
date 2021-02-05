import javafx.scene.control.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
public class CreateText {
    private Font textFont;
    private Font tableFont;
    private Label gameOver;
    private Label table;
    public CreateText(){
        this.textFont=Font.font("HVD Comic Serif Pro", FontWeight.EXTRA_BOLD,28);
        this.tableFont=Font.font("HVD Comic Serif Pro",FontWeight.EXTRA_BOLD,17);
        this.gameOver=new Label("        GAME OVER!\n        Your Score: "+Assignment4.scoreCalculator+"\n\nPress ENTER to restart!");
        this.table=new Label("Score\n"+String.valueOf(Assignment4.scoreCalculator)+"\nLevel\n"+String.valueOf(Assignment4.levelCalculator));
        this.gameOver.setTextFill(Color.BLACK);
        this.gameOver.setFont(textFont);
        this.gameOver.setLayoutX(75);
        this.gameOver.setLayoutY(100);
        this.table.setTextFill(Color.BLACK);
        this.table.setFont(tableFont);
        this.table.setLayoutX(5);
        this.table.setLayoutY(5);
    }
    public Label getGameOver() {
        return this.gameOver;
    }
    public Label getTable() {
        return this.table;
    }
}