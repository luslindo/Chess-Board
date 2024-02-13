import javax.swing.*;
import java.awt.*;

public class ChessBoard extends JFrame{
    private JPanel chessBoardPanel;

    public ChessBoard() {
        setTitle("Chess Board");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);

        initializeChessBoard();
    }
    public void initializeChessBoard(){
        chessBoardPanel  = new JPanel(new GridLayout(8,8));
        chessBoardPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        Color lightSquareColor = new Color(240, 217, 181);
        Color blackSquareColor = new Color(181, 136, 99);

        for(int row=0; row<8; row++){
            for (int col = 0; col < 8; col++) {
                JPanel square = new JPanel();
                square.setBackground((row + col)%2==0 ? lightSquareColor : blackSquareColor);

                chessBoardPanel.add(square);
            }
        }
        add(chessBoardPanel);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(()->{
            ChessBoard chessBoard = new ChessBoard();
            chessBoard.setVisible(true);
        });
    }
}
