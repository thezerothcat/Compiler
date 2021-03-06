import global.ProgramConstants;
import icode.ICodeGenerator;
import lex.LexicalAnalyzer;
import log.LogLevel;
import log.LogManager;
import syntax.SyntaxAnalyzer;
import syntax.symbol.SymbolTable;
import tcode.TCodeGenerator;

import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Owner
 * Date: 1/6/14
 * Time: 4:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    private static List<String> VALID_DEBUG_ARGS = Arrays.asList("-d", "d", "-debug", "debug");

    public static void main(String[] args) {
        SyntaxAnalyzer sa;
        LexicalAnalyzer la;

        ProgramConstants.logLevel = LogLevel.NONE;
        if(args.length > 1) {
            ProgramConstants.logLevel = isDebugArg(args[1]) ? LogLevel.DEBUG : LogLevel.STANDARD;
        }

        try {
            la = new LexicalAnalyzer(args[0]);


            sa = new SyntaxAnalyzer(la);
            sa.pass();

            sa.pass();
            SymbolTable.get().dumpSymbolTable();
            la.closeFile();

            TCodeGenerator.produceTargetCode();
            ICodeGenerator.dumpQuads();
            TCodeGenerator.dumpQuads();
            System.out.println("Compilation completed successfully.");
        }
        catch(Exception e) {

        }
        LogManager.cleanup();
    }

    private static boolean isDebugArg(String s) {
        return s != null
                && VALID_DEBUG_ARGS.contains(s.toLowerCase());
    }
}
