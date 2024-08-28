package com.mycompany.laba5;



import com.mycompany.laba5.fight.ChangeTexts;
import com.mycompany.laba5.fight.CharacterAction;
import com.mycompany.laba5.fight.Fight;
import com.mycompany.laba5.player.Human;
import com.mycompany.laba5.player.Player;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/**
 * The Game class represents the main game logic and handles the creation of new enemies and humans,
 * as well as managing the end game results and writing them to an Excel file and a JTable.
 */
public class Game {

    CharacterAction action = new CharacterAction();
    ChangeTexts change = new ChangeTexts();
    Fight fight = new Fight();
    private ArrayList<Result> results = new ArrayList<>();
    /**
     * Creates a new enemy and initializes its attributes.
     *
     * @param L1 JLabel for the enemy's name
     * @param L2 JLabel for the enemy's level
     * @param L3 JLabel for the enemy's health
     * @param L4 JLabel for the enemy's damage
     * @param pr2 JProgressBar for the enemy's health
     * @return the newly created enemy
     */
    public Player NewEnemy(JLabel L1, JLabel L2,
            JLabel L3, JLabel L4, JProgressBar pr2) {
        action.setEnemyes();
        Player enemy = action.ChooseEnemy(L1, L2, L3, L4);
        action.HP(enemy, pr2);
        pr2.setMaximum(enemy.getMaxHealth());
        fight.setEnemy(enemy);
        return enemy;
    }
    /**
     * Creates a new human player and initializes its attributes.
     *
     * @param pr1 JProgressBar for the human's health
     * @return the newly created human player
     */
    public Human NewHuman(JProgressBar pr1){
        Human human = new Human (1,80,16,1);
        action.HP(human, pr1);
        pr1.setMaximum(human.getMaxHealth());
        fight.setHuman(human);
        return human;
    }
    /**
     * Ends the game and updates the top results with the human player's score.
     *
     * @param human the human player
     * @param text JTextField containing the player's name
     * @param table JTable to display the top results
     * @throws IOException if an I/O error occurs
     */
    public void EndGameTop(Human human, JTextField text, JTable table) throws IOException {
        results.add(new Result(text.getText(), human.getPoints()));
        results.sort(Comparator.comparing(Result::getPoints).reversed());
        WriteToTable(table);
        WriteToExcel();
    }
    /**
     * Writes the top results to an Excel file.
     *
     * @throws IOException if an I/O error occurs
     */
    public void WriteToExcel() throws IOException{
        XSSFWorkbook book = new XSSFWorkbook();
        XSSFSheet sheet = book.createSheet("Поминки по погибшим:");
        XSSFRow r = sheet.createRow(0);
        r.createCell(0).setCellValue("№");
        r.createCell(1).setCellValue("Имя");
        r.createCell(2).setCellValue("Количество баллов");
        for (int i=0; i<results.size();i++){
            if (i<10){
                XSSFRow r2 = sheet.createRow(i+1);
                r2.createCell(0).setCellValue(i+1);
                r2.createCell(1).setCellValue(results.get(i).getName());
                r2.createCell(2).setCellValue(results.get(i).getPoints());
            }
        }
        File f = new File("Results.xlsx");
        book.write(new FileOutputStream(f));
        
    }
     /**
     * Returns the Fight instance associated with the game.
     *
     * @return the Fight instance
     */
    public Fight getFight() {
        return fight;
    }

     /**
     * Returns the list of game results.
     *
     * @return the list of results
     */
    public ArrayList<Result> getResults(){
        return this.results;
    }
    /**
     * Reads the top results from an Excel file.
     *
     * @throws IOException if an I/O error occurs
     */
    public void ReadFromExcel() throws IOException{
        FileInputStream inputStream = new FileInputStream(new  File("Results.xlsx"));
        XSSFWorkbook book = new XSSFWorkbook(inputStream);
        XSSFSheet sh = book.getSheetAt(0);
        for (int i=1; i<=sh.getLastRowNum();i++) {
            results.add(new Result(sh.getRow(i).getCell(1).getStringCellValue(),(int)sh.getRow(i).getCell(2).getNumericCellValue()));
        }
       
        inputStream.close();
    }
    /**
     * Writes the top results to a JTable.
     *
     * @param table JTable to display the top results
     */
    public void WriteToTable(JTable table){
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        for (int i=0; i<results.size();i++){
            if (i<10){
                model.setValueAt(results.get(i).getName(), i, 0);
                model.setValueAt(results.get(i).getPoints(), i, 1);
            }
        }
    }
    

    }

