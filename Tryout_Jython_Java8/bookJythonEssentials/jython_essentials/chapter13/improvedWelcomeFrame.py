import javax.swing as swing
import java.awt as awt
import java.lang as lang

def exit(event):
        lang.System.exit(0)

class WelcomeFrame(swing.JFrame):
    names = ["Groucho", "Chico", "Harpo"]
    quotes = {"Groucho": "Say the secret word", 
            "Chico": "Viaduct?", "Harpo": "HONK!"}

    def __init__(self, title="Welcome to Jython", size=(200, 200)):
        "@sig public WelcomeFrame(String title, java.awt.Dimension size)"
        self.title = title
        self.windowClosing = exit
        self.contentPane.layout = awt.FlowLayout()  
        self.field = swing.JTextField(preferredSize=(200,20))
        self.contentPane.add(self.field)
        buttons = [self.createButton(each) for each in self.names]
        for eachButton in buttons:
            self.contentPane.add(eachButton)
        self.pack()
            
    def buttonPressed(self, event):
         self.field.text = self.quotes[event.source.text]

    def createButton(self, name):
        "@sig public javax.swing.JButton createButton(String name)"
        return swing.JButton(name, preferredSize=(100,20), 
                actionPerformed=self.buttonPressed)
                
    def addQuote(self, marxBrother, quote):
        "@sig public void addQuote(String marxBrother, String quote)"
        self.quotes[marxBrother] = quote          
                
if __name__ == '__main__':
    WelcomeFrame().show()

