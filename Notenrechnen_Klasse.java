import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;




public class Notenrechnen_Klasse extends Frame {
  // Anfang Attribute
  private JComboBox<String> CBFachWahl = new JComboBox<String>();
    private DefaultComboBoxModel<String> CBFachWahlModel = new DefaultComboBoxModel<String>();
  private JLabel jLabel1 = new JLabel();
  private JTextField NFHinzu = new JTextField();
  private JButton BHinzu = new JButton();
  private JTextArea TAAusgabe = new JTextArea("");
    private JScrollPane TAAusgabeScrollPane = new JScrollPane(TAAusgabe);
  private JButton BDurchschnitt = new JButton();
  public static fach[] Schule=new fach[6];



  // Ende Attribute
  
  public Notenrechnen_Klasse() { 
    // Frame-Initialisierung       
    super();
    Schule[0]=new fach("LA");
    Schule[1]=new fach("DS");
    Schule[2]=new fach("AuD");
    Schule[3]=new fach("TGI");
    Schule[4]=new fach("RA");
    Schule[5]=new fach("Chi");
    
    addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent evt) { dispose(); }
    });
    int frameWidth = 499; 
    int frameHeight = 493;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("Notenrechner");
    setResizable(false);
    Panel cp = new Panel(null);
    add(cp);
    // Anfang Komponenten
    
    CBFachWahl.setModel(CBFachWahlModel);
    CBFachWahl.setBounds(88, 16, 198, 20);
    cp.add(CBFachWahl);
    jLabel1.setBounds(16, 16, 110, 20);
    jLabel1.setText("Fach:");
    cp.add(jLabel1);
    NFHinzu.setBounds(16, 48, 275, 20);
    NFHinzu.setText("1");
    cp.add(NFHinzu);
    BHinzu.setBounds(312, 48, 155, 25);
    BHinzu.setText("hinzufuegen");
    BHinzu.setMargin(new Insets(2, 2, 2, 2));
    BHinzu.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        BHinzu_ActionPerformed(evt);
      }
    });
    cp.add(BHinzu);
    TAAusgabeScrollPane.setBounds(16, 88, 448, 348);
    cp.add(TAAusgabeScrollPane);
    CBFachWahl.setBounds(96, 16, 374, 20);
    for (int i=0; i<Schule.length; i++) {
      CBFachWahl.addItem(Schule[i].name);
    } 
    TAAusgabeScrollPane.setBounds(16, 88, 448, 316);
    BDurchschnitt.setBounds(16, 416, 451, 25);
    BDurchschnitt.setText("Durchschnitt errechnen");
    BDurchschnitt.setMargin(new Insets(2, 2, 2, 2));
    BDurchschnitt.addActionListener(new ActionListener() { 
      public void actionPerformed(ActionEvent evt) { 
        BDurchschnitt_ActionPerformed(evt);
      }
    });
    cp.add(BDurchschnitt);
    // Ende Komponenten
    
    setVisible(true);
    

    
  } // end of public Notenrechnen_Klasse
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new Notenrechnen_Klasse();
    
    for (int i=0; i<Schule.length; i++) {
      for (int j=0; j<20; j++) {
        Schule[i].noten[j]=0;
    }} 
    
    for (int i=0; i<Schule.length; i++) {
      Schule[i].anzahl=0;
    }
    
    } // end of main
  
  public void BHinzu_ActionPerformed(ActionEvent evt) {
  int pos=CBFachWahl.getSelectedIndex();
    if ( Schule[pos].anzahl<Schule[pos].noten.length) {
       Schule[pos].noten[ Schule[pos].anzahl]=Integer.valueOf(NFHinzu.getText());
       Schule[pos].anzahl= Schule[pos].anzahl+1;
    } 
    
    TAAusgabe.setText("");
    int j;
    String AG;
    for (int i=0; i<Schule.length; i++) {   
      AG=Schule[i].name+ " ";
      j=0;
      while (Schule[i].noten[j]>0){
        AG=AG+" "+String.valueOf(Schule[i].noten[j]);
        j=j+1;
    }
      TAAusgabe.append(AG+"\n");
    }
      
    

  } // end of BHinzu_ActionPerformed

  public void BDurchschnitt_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfuegen
    int sum;
    TAAusgabe.setText("");
    int j;
    String AG;
    for (int i=0; i<Schule.length; i++) {
      sum=0;   
      AG=Schule[i].name+ " ";
      j=0;
      while (Schule[i].noten[j]>0){
        sum=sum+Schule[i].noten[j];
        AG=AG+" "+String.valueOf(Schule[i].noten[j]);
        j=j+1;
    }
      if (Schule[i].anzahl>0){
        double d=((double)(sum)/(double)(Schule[i].anzahl));
        TAAusgabe.append(AG+" | D: "+String.valueOf(d) +"\n");}else{
          TAAusgabe.append(AG+"\n");}
    }

  } // end of BDurchschnitt_ActionPerformed

  // Ende Methoden
} // end of class Notenrechnen_Klasse

class fach{
  String name;
  int[] noten=new int[20];
  int anzahl=0;
  
  fach (String bezeichnung){
    this.name=bezeichnung;
    for (int i =0;i<noten.length;i++){
      noten[i]=0;}
    anzahl=0;
  }
}
