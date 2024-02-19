import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public class ChessBoard extends JFrame {
    private JPanel chessBoardPanel;
    private static final Logger LOGGER = Logger.getLogger(ChessBoard.class.getName());
    public enum PieceType {
        PAWN, ROOK, KNIGHT, BISHOP, QUEEN, KING
    }

    public ChessBoard() {
        setTitle("Chess Board");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);

        initializeChessBoard();
        addPieces();
    }

    public void initializeChessBoard() {
        chessBoardPanel = new JPanel(new GridLayout(8, 8));
        chessBoardPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        Color lightSquareColor = new Color(240, 217, 181);
        Color blackSquareColor = new Color(181, 136, 99);

        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                JPanel square = new JPanel();
                square.setBackground((row + col) % 2 == 0 ? lightSquareColor : blackSquareColor);

                chessBoardPanel.add(square);
            }
        }
        add(chessBoardPanel);
        LOGGER.info("Chess Board is initiated");
    }

    public void addPieces() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if ((row == 0 ||row == 7) && (col == 0 || col == 7)){
                    addPiece(row, col, PieceType.ROOK);
                }
                else if ((row == 0 ||row == 7) && (col == 1 || col == 6)){
                    addPiece(row, col, PieceType.KNIGHT);
                }
                else if ((row == 0 ||row == 7) && (col == 2 || col == 5)){
                    addPiece(row, col, PieceType.BISHOP);
                }
                else if ((row == 0 ||row == 7) && (col == 3)){
                    addPiece(row, col, PieceType.QUEEN);
                }
                else if ((row == 0 ||row == 7) && (col == 4)){
                    addPiece(row, col, PieceType.KING);
                }
               else if (row == 1 || row == 6) {
                    addPiece(row, col, PieceType.PAWN);
                }
            }
        }
        LOGGER.info("Chess pieces are added to the board");
    }

    public void addPiece(int row, int col, PieceType pieceType) {
        String imagePath = getPieceSymbol(row, pieceType);
        JPanel square = (JPanel) chessBoardPanel.getComponent(row * 8 + col);
        JLabel pieceLabel = new JLabel();

        try {
            BufferedImage image = ImageIO.read(new File(imagePath));
            ImageIcon icon = new ImageIcon(image);
            pieceLabel.setIcon(icon);
        } catch (IOException e) {
            e.printStackTrace();
        }

        square.add(pieceLabel);
    }

    private String getPieceSymbol(int row, PieceType pieceType) {
        switch (pieceType) {
            case PAWN:
                if(row < 4)
                    return "C:\\Sandbox\\SideProjects\\Chess Board\\pieces\\PAWN_W.png";
                return "C:\\Sandbox\\SideProjects\\Chess Board\\pieces\\PAWN_B.png";
            case ROOK:
                if(row < 4)
                    return "C:\\Sandbox\\SideProjects\\Chess Board\\pieces\\ROOK_W.png";
                return "C:\\Sandbox\\SideProjects\\Chess Board\\pieces\\ROOK_B.png";
            case KNIGHT:
                if(row < 4)
                    return "C:\\Sandbox\\SideProjects\\Chess Board\\pieces\\KNIGHT_W.png";
                return "C:\\Sandbox\\SideProjects\\Chess Board\\pieces\\KNIGHT_B.png";
            case BISHOP:
                if(row < 4)
                    return "C:\\Sandbox\\SideProjects\\Chess Board\\pieces\\BISHOP_W.png";
                return "C:\\Sandbox\\SideProjects\\Chess Board\\pieces\\BISHOP_B.png";
            case QUEEN:
                if(row < 4)
                    return "C:\\Sandbox\\SideProjects\\Chess Board\\pieces\\QUEEN_W.png";
                return "C:\\Sandbox\\SideProjects\\Chess Board\\pieces\\QUEEN_B.png";
            case KING:
                if(row < 4)
                    return "C:\\Sandbox\\SideProjects\\Chess Board\\pieces\\KING_W.png";
                return "C:\\Sandbox\\SideProjects\\Chess Board\\pieces\\KING_B.png";
            default:
                return "";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ChessBoard chessBoard = new ChessBoard();
            chessBoard.setVisible(true);
        });
    }
}
