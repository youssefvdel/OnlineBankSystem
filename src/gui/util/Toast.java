package gui.util;

import javax.swing.*;
import java.awt.*;

/**
 * Utility class for showing toast notifications.
 * Reusable across all GUI components.
 *
 * @author Youssef Adel 258270
 * @version Phase 2
 */
public class Toast {

    private static final Color SUCCESS_COLOR = new Color(76, 175, 80);
    private static final Color ERROR_COLOR = new Color(244, 67, 54);
    private static final Color INFO_COLOR = new Color(33, 150, 243);
    private static final Font TOAST_FONT = new Font("sansserif", Font.PLAIN, 14);

    /**
     * Shows a success toast message.
     *
     * @param parent Parent window
     * @param message Message to display
     */
    public static void showSuccess(Component parent, String message) {
        showToast(parent, message, SUCCESS_COLOR);
    }

    /**
     * Shows an error toast message.
     *
     * @param parent Parent window
     * @param message Message to display
     */
    public static void showError(Component parent, String message) {
        showToast(parent, message, ERROR_COLOR);
    }

    /**
     * Shows an info toast message.
     *
     * @param parent Parent window
     * @param message Message to display
     */
    public static void showInfo(Component parent, String message) {
        showToast(parent, message, INFO_COLOR);
    }

    private static void showToast(Component parent, String message, Color bgColor) {
        JDialog dialog = new JDialog((Frame) SwingUtilities.getWindowAncestor(parent));
        dialog.setUndecorated(true);
        dialog.setLayout(new BorderLayout());

        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBackground(bgColor);
        panel.setBorder(BorderFactory.createEmptyBorder(15, 20, 15, 20));

        JLabel label = new JLabel(message);
        label.setForeground(Color.WHITE);
        label.setFont(TOAST_FONT);
        label.setVerticalAlignment(SwingConstants.CENTER);

        panel.add(label, BorderLayout.CENTER);
        dialog.add(panel);

        dialog.pack();
        dialog.setLocationRelativeTo(parent);
        dialog.setAlwaysOnTop(true);

        Timer timer = new Timer(2500, e -> dialog.dispose());
        timer.setRepeats(false);

        dialog.setVisible(true);
        timer.start();
    }

    /**
     * Shows a confirmation dialog.
     *
     * @param parent Parent window
     * @param message Message to display
     * @param title Dialog title
     * @return true if user confirms, false otherwise
     */
    public static boolean showConfirm(Component parent, String message, String title) {
        int result = JOptionPane.showConfirmDialog(
            parent,
            message,
            title,
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE
        );
        return result == JOptionPane.YES_OPTION;
    }

    /**
     * Shows a simple message dialog.
     *
     * @param parent Parent window
     * @param message Message to display
     * @param title Dialog title
     * @param type Message type
     */
    public static void showMessage(Component parent, String message, String title, int type) {
        JOptionPane.showMessageDialog(parent, message, title, type);
    }
}
