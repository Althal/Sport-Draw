
package simple.sports.draw.machine;

import java.util.ArrayList;
import javax.swing.UIManager;

public class Controller {
    
    /**
     * Widok
     */
    private static SSDM form = new SSDM();
    
    /**
     * Lista drużyn do losowania
     */
    private static ArrayList<String> toDraw = new ArrayList<>();
    
    /**
     * Lista drużyn do losowania
     */
    private static ArrayList<String> toShow;
    
    /**
     * Wyniki losowania
     */
    private static String[] drawedList = new String[12];

    
    /**
     * Liczba wyświetlonych drużyn
     */
    private static int showedTeams = 0;

    
    
    
    
    public static void openForm(){
        form.setVisible(true);
        System.out.println(UIManager.getLookAndFeel());
    }
       
    
    
    
    
    /**
     * Metoda dodająca drużynę
     */
    public static void addTeam(){
        String name = form.teamName.getText();
        if(name.isEmpty()) return;
        
        toDraw.add(name);
        form.teamName.setText("");
        if(toDraw.size() == 12) {
            form.addTeam.setEnabled(false);
            form.draw.setEnabled(true);
        }
        setList();
    }
    
    public static void draw(){
        if(showedTeams == 0) {
            toShow = new ArrayList<>();
            for(int i=0; i<12; i++) toShow.add(toDraw.get(i));
            form.teamName.setEnabled(false);
        }
        int random = getRandomNumber();
        String team = toShow.get(getRandomNumber());
        toShow.remove(random);
        drawedList[showedTeams] = team;
        showNext();
    }
    
    public static void showNext(){
        switch(showedTeams){
            case 0: {
                form.drawed1.setText("1: " + drawedList[showedTeams]);
                break;
            }
            case 1: {
                form.drawed2.setText("1: " + drawedList[showedTeams]);
                break;
            }
            case 2: {
                form.drawed3.setText("1: " + drawedList[showedTeams]);
                break;
            }
            case 3: {
                form.drawed4.setText("1: " + drawedList[showedTeams]);
                break;
            }
            case 4: {
                form.drawed5.setText("2: " + drawedList[showedTeams]);
                break;
            }
            case 5: {
                form.drawed6.setText("2: " + drawedList[showedTeams]);
                break;
            }
            case 6: {
                form.drawed7.setText("2: " + drawedList[showedTeams]);
                break;
            }
            case 7: {
                form.drawed8.setText("2: " + drawedList[showedTeams]);
                break;
            }
            case 8: {
                form.drawed9.setText("3: " + drawedList[showedTeams]);
                break;
            }
            case 9: {
                form.drawed10.setText("3: " + drawedList[showedTeams]);
                break;
            }
            case 10: {
                form.drawed11.setText("3: " + drawedList[showedTeams]);
                break;
            }
            case 11: {
                form.drawed12.setText("3: " + drawedList[showedTeams]);
                //form.show.setEnabled(false);
                break;
            }            
        }        
        showedTeams++;
    }
    
    public static void deleteLastTeam(){
        toDraw.remove(toDraw.size()-1);
        form.addTeam.setEnabled(true);
        setList();
    }
    
    private static void setList(){
        switch(toDraw.size()){
            case 12: form.team12.setText("12: " + toDraw.get(11));
            case 11: form.team11.setText("11: " + toDraw.get(10));
            case 10: form.team10.setText("10: " + toDraw.get(9));
            case 9: form.team9.setText("9: " + toDraw.get(8));
            case 8: form.team8.setText("8: " + toDraw.get(7));
            case 7: form.team7.setText("7: " + toDraw.get(6));
            case 6: form.team6.setText("6: " + toDraw.get(5));
            case 5: form.team5.setText("5: " + toDraw.get(4));
            case 4: form.team4.setText("4: " + toDraw.get(3));
            case 3: form.team3.setText("3: " + toDraw.get(2));
            case 2: form.team2.setText("2: " + toDraw.get(1));
            case 1: form.team1.setText("1: " + toDraw.get(0));
        }
    }
    
    private static int getRandomNumber(){
        if(showedTeams == 12) return 0;
        long random = System.currentTimeMillis();
        return (int)(random % (12 - showedTeams));
    }
    
    public static void reset(){
        toDraw = new ArrayList<>();
        toShow = null;
        drawedList = new String[12];
        showedTeams = 0;
        form.addTeam.setEnabled(true);
        form.draw.setEnabled(false);
        
        form.drawed1.setText("1: " );
        form.drawed2.setText("1: " );
        form.drawed3.setText("1: " );
        form.drawed4.setText("1: " );
        form.drawed5.setText("2: " );
        form.drawed6.setText("2: " );
        form.drawed7.setText("2: " );
        form.drawed8.setText("2: " );
        form.drawed9.setText("3: " );
        form.drawed10.setText("3: " );
        form.drawed11.setText("3: " );
        form.drawed12.setText("3: " );
        
        form.team1.setText("1: " );
        form.team2.setText("2: " );
        form.team3.setText("3: " );
        form.team4.setText("4: " );
        form.team5.setText("5: " );
        form.team6.setText("6: " );
        form.team7.setText("7: " );
        form.team8.setText("8: " );
        form.team9.setText("9: " );
        form.team10.setText("10: " );
        form.team11.setText("11: " );
        form.team12.setText("12: " );
        
        form.addTeam.setEnabled(true);
        form.teamName.setEnabled(true);
    }
}
