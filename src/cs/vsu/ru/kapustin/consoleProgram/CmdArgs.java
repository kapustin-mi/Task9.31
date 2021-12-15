package cs.vsu.ru.kapustin.consoleProgram;

public class CmdArgs {

    public static class InputArgs {
        public boolean start;
        public String inputFile;
        public String outputFile;
        public boolean window;
        public boolean error;
        public boolean help;
    }

    public static InputArgs parseCmdArgs(String[] args) {
        InputArgs params = new InputArgs();

        if (args.length > 0) {
            if (args[0].equals("--help")) {
                params.help = true;
                return params;
            }

            if (args[0].equals("--window")) {
                params.window = true;
                return params;
            }

            if (args[0].equals("-run")) {
                params.start = true;
            }

            if (args.length < 2) {
                params.help = true;
                params.error = true;
                return params;
            }

            params.inputFile = args[1];
            if (args.length > 2) {
                params.outputFile = args[2];
            }
        } else {
            params.help = true;
            params.error = true;
        }

        return params;
    }
}


