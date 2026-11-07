package python_essentials.chapter12;

import org.python.core.*;
import org.python.util.*;

public class PyNamespaceTest {
    public static void main(String[] argv) {
        PySystemState.initialize();
        PythonInterpreter interp = new PythonInterpreter();
        interp.execfile("namespace_test.py");
        Object value = interp.get("language", String.class);
        System.out.println(value);
        interp.set("embedded", "1");
        interp.exec("print embedded");
    }      
}

