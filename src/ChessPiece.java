import javax.swing.*;
import java.awt.*;

public class ChessPiece extends JPanel {
    private PieceType type;
    private Color color;

    public enum PieceType {
        PAWN, ROOK, KNIGHT, BISHOP, QUEEN, KING
    }

    public ChessPiece(Color color, PieceType type) {
        this.type = type;
        this.color = color;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int width = getWidth();
        int height = getHeight();

        // Set color
        g2d.setColor(color);

        // Draw piece shape
        switch (type) {
            case PAWN:
                g2d.fillOval(10, 20, width - 20, height - 30);
                break;
            case ROOK:
                g2d.fillRect(10, 10, width - 20, height - 20);
                break;
            case KNIGHT:
                g2d.fillOval(10, 10, width - 20, height - 20);
                g2d.fillRect(15, 30, width - 30, height - 40);
                break;
            case BISHOP:
                int[] xPoints = {width / 2, 10, width - 10};
                int[] yPoints = {10, height - 10, height - 10};
                g2d.fillPolygon(xPoints, yPoints, 3);
                break;
            case QUEEN:
                g2d.fillOval(10, 10, width - 20, height - 20);
                g2d.fillRect(10, 40, width - 20, height - 50);
                break;
            case KING:
                g2d.fillOval(10, 10, width - 20, height - 20);
                g2d.fillRect(20, 40, width - 40, height - 50);
                break;
            default:
                break;
        }
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame("Chess Pieces");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(2, 3));

        frame.add(new ChessPiece(Color.WHITE, ChessPiece.PieceType.PAWN));
        frame.add(new ChessPiece(Color.BLACK, ChessPiece.PieceType.ROOK));
        frame.add(new ChessPiece(Color.WHITE, ChessPiece.PieceType.KNIGHT));
        frame.add(new ChessPiece(Color.BLACK, ChessPiece.PieceType.BISHOP));
        frame.add(new ChessPiece(Color.WHITE, ChessPiece.PieceType.QUEEN));
        frame.add(new ChessPiece(Color.BLACK, ChessPiece.PieceType.KING));

        frame.pack();
        frame.setVisible(true);
    }
}
