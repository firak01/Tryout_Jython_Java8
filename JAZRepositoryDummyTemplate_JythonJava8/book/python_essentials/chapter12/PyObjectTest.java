package python_essentials.chapter12;

import org.python.core.*;
import org.python.util.*;

public class PyObjectTest {
    public static void main(String[] argv) {
        PySystemState.initialize();
        PythonInterpreter interp = new PythonInterpreter();
        PyDictionary dict = new PyDictionary();
        dict.__setitem__(new PyString("zero"), new PyInteger(0));
        dict.__setitem__(new PyString("one"), new PyInteger(1));
        interp.set("dict", dict);
        interp.exec("print dict");
        interp.exec("print dict['zero'] + dict['one']");
    }      
}

