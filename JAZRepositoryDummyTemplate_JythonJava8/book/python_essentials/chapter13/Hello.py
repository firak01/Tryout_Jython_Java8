from java.applet import Applet


class Hello(Applet):
    def paint(self, g):
	    g.drawString("Hello from Jython Essentials!")

