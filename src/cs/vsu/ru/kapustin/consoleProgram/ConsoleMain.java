package cs.vsu.ru.kapustin.consoleProgram;

import cs.vsu.ru.kapustin.CreatingNewSheet;
import cs.vsu.ru.kapustin.windowProgram.GuiMain;
import cs.vsu.ru.kapustin.utils.Utils;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.List;
import java.util.Locale;

public class ConsoleMain {

    public static void main(String[] args) throws FileNotFoundException {
        Locale.setDefault(Locale.ROOT);

        CmdArgs.InputArgs inputArgs = CmdArgs.parseCmdArgs(args);
        if (inputArgs.help) {
            printHelp(inputArgs);
            System.exit(inputArgs.error ? 1 : 0);
        } else if (inputArgs.window) {
            GuiMain.main(args);
        } else {
            List<Integer> list = executeCreating(inputArgs);
            printNewListToFile(list, inputArgs);
        }
    }

    private static void printHelp(CmdArgs.InputArgs params) {
        PrintStream out = params.error ? System.err : System.out;
        out.println("Usage:");
        out.println("  <cmd> args <input-file> (<output-file>)");
        out.println("    -run  // run program");
        out.println("  <cmd> --help");
        out.println("  <cmd> --window  // show window");
    }

    private static List<Integer> executeCreating(CmdArgs.InputArgs inputArgs) throws FileNotFoundException {
        CreatingNewSheet creating = new CreatingNewSheet();

        List<Integer> list = Utils.readListFromFile(inputArgs.inputFile);
        if (list == null) {
            System.err.printf("Can't read array from \"%s\"%n", inputArgs.inputFile);
            System.exit(2);
        }

        return creating.createNewList(list);
    }

    private static void printNewListToFile(List<Integer> list, CmdArgs.InputArgs inputArgs) throws FileNotFoundException {
        if (inputArgs.outputFile == null) {
            Utils.printListInConsole(list);
        } else {
            Utils.writeListToFile(inputArgs.outputFile, list);
        }
    }
}
