/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eltc.web.pageNavig;

/**
 *
 * @author sanzhar.ismailov
 */
public class PageNumberPanel {

    private int currentNumber;
    private int firstNumber = 1;
    private int lastNumber;
    private int prevoiusNumber;
    private int nextNumber;
    private int recordsNumberForPage;
    private String findUrlString;

    public PageNumberPanel(int currentNumber, int recNumForPage, int sizeOfRecords) {
        this.currentNumber = currentNumber;
        this.recordsNumberForPage = recNumForPage;
        this.prevoiusNumber = currentNumber - 1;
        this.nextNumber = currentNumber + 1;
        this.lastNumber = (sizeOfRecords % recordsNumberForPage == 0)
                ? (sizeOfRecords / recordsNumberForPage)
                : ((sizeOfRecords / recordsNumberForPage) + 1);
    }

    public int getCurrentNumber() {
        return currentNumber;
    }

    public int getFirstNumber() {
        return firstNumber;
    }

    public int getLastNumber() {
        return lastNumber;
    }

    public int getPrevoiusNumber() {
        return prevoiusNumber;
    }

    public int getNextNumber() {
        return nextNumber;
    }

    public String getFindUrlString() {
        return findUrlString;
    }

    public void setFindUrlString(String findUrlString) {
        this.findUrlString = findUrlString;
    }

    public int getRecordsNumberForPage() {
        return recordsNumberForPage;
    }

    public void setRecordsNumberForPage(int recordsNumberForPage) {
        this.recordsNumberForPage = recordsNumberForPage;
    }
    
    
    
}
