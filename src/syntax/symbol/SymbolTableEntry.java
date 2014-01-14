package syntax.symbol;

/**
 * Created with IntelliJ IDEA.
 * User: Owner
 * Date: 1/13/14
 * Time: 5:04 PM
 * To change this template use File | Settings | File Templates.
 */
public class SymbolTableEntry {
    public String scope;
    public String symid;
    public String value;
    public SymbolTableEntryType kind;
    public String data;

    public SymbolTableEntry(String scope, String symid, String value, SymbolTableEntryType kind, String data) {
        this.scope = scope;
        this.symid = symid;
        this.value = value;
        this.kind = kind;
        this.data = data;
    }
}
