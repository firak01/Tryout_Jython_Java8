package python_essentials.chapter12;

import org.python.core.*;
import org.python.util.*;

public class PyInterpTest {
    public static void main(String[] argv) {
        PySystemState.initialize();
        PythonInterpreter interp = new PythonInterpreter();
        PyObject value = interp.eval("2 + 2");
        System.out.println(value);
    }      
}

