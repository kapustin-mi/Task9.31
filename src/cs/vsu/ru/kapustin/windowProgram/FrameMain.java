package cs.vsu.ru.kapustin.windowProgram;

import cs.vsu.ru.kapustin.CreatingNewSheet;
import cs.vsu.ru.kapustin.utils.JTableUtils;
import cs.vsu.ru.kapustin.utils.SwingUtils;
import cs.vsu.ru.kapustin.utils.Utils;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.File;
import java.util.List;


public class FrameMain extends JFrame {
    private JPanel panelMain;
    private JTable tableInput;
    private JTable tableOutput;
    private JButton loadFromFileButton;
    private JButton saveToFileButton;
    private JButton fillWithRandomNumbersButton;
    private JButton saveResultToFileButton;
    private JButton enterButton;

    private final JFileChooser fileChooserOpen;
    private final JFileChooser fileChooserSave;

    public FrameMain() {
        this.setTitle("Task 9");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(600, 250, 300, 300);
        this.setResizable(false);
        this.pack();

        CreatingNewSheet creating = new CreatingNewSheet();

        JTableUtils.initJTableForArray(tableInput, 30, false, true, false, true, 25, 15);
        JTableUtils.initJTableForArray(tableOutput, 30, false, true, false, false, 25, 15);
        tableInput.setRowHeight(30);
        tableOutput.setRowHeight(30);

        fileChooserOpen = new JFileChooser();
        fileChooserSave = new JFileChooser();
        fileChooserOpen.setCurrentDirectory(new File("."));
        fileChooserSave.setCurrentDirectory(new File("."));
        FileFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooserOpen.addChoosableFileFilter(filter);
        fileChooserSave.addChoosableFileFilter(filter);

        fileChooserSave.setAcceptAllFileFilterUsed(false);
        fileChooserSave.setDialogType(JFileChooser.SAVE_DIALOG);
        fileChooserSave.setApproveButtonText("Save");

        JMenuBar menuBarMain = new JMenuBar();
        setJMenuBar(menuBarMain);

        JMenu menuLookAndFeel = new JMenu();
        menuLookAndFeel.setText("View");
        menuBarMain.add(menuLookAndFeel);
        SwingUtils.initLookAndFeelMenu(menuLookAndFeel);

        this.pack();

        loadFromFileButton.addActionListener(actionEvent -> {
            try {
                if (fileChooserOpen.showOpenDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                    List<Integer> list = Utils.readListFromFile(fileChooserOpen.getSelectedFile().getPath());
                    JTableUtils.writeArrayToJTable(tableInput, Utils.convertToIntArray(list));
                }
            } catch (Exception e) {
                ErrorMessages.showErrorMessage(0);
            }
        });

        fillWithRandomNumbersButton.addActionListener(actionEvent -> {
            int[] arr = new int[tableInput.getColumnCount()];
            Utils.fillArrayRandomNumbers(arr);
            JTableUtils.writeArrayToJTable(tableInput, arr);
        });

        saveToFileButton.addActionListener(actionEvent -> {
            try {
                if (fileChooserSave.showSaveDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                    List<Integer> list = Utils.readListFromJTable(tableInput);

                    String file = fileChooserSave.getSelectedFile().getPath();
                    if (!file.toLowerCase().endsWith(".txt")) {
                        file += ".txt";
                    }
                    Utils.writeListToFile(file, list);
                }
            } catch (Exception e) {
                ErrorMessages.showErrorMessage(2);
            }
        });

        enterButton.addActionListener(actionEvent -> {
            try {
                List<Integer> list = Utils.readListFromJTable(tableInput);
                List<Integer> newList = creating.createNewList(list);
                JTableUtils.writeArrayToJTable(tableOutput, Utils.convertToIntArray(newList));
            } catch (Exception e) {
                ErrorMessages.showErrorMessage(1);
            }
        });

        saveResultToFileButton.addActionListener(actionEvent -> {
            try {
                if (fileChooserSave.showSaveDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                    List<Integer> list = Utils.readListFromJTable(tableOutput);

                    String file = fileChooserSave.getSelectedFile().getPath();
                    if (!file.toLowerCase().endsWith(".txt")) {
                        file += ".txt";
                    }
                    Utils.writeListToFile(file, list);
                }
            } catch (Exception e) {
                ErrorMessages.showErrorMessage(2);
            }
        });
    }
}
